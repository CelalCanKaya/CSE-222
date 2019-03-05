package com.company.Q1Folder;

import com.company.Q1Folder.HashEntry;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Map classını implement eden class - Verilen değerleri double hashing yöntemiyle bir array'de tutuyorum.
 * @param <K> Generic Key
 * @param <V> Generic Value
 */
public class Part1<K,V> implements Map<K,V> {

    private int capacity;
    private int size;
    private int prime;
    int deletedCount;
    private HashEntry<K,V> arr[];

    /**
     * Default constructor
     */
    public Part1() {
        capacity=5;
        size = 0;
        deletedCount=0;
        prime=findPrime();
        arr=new HashEntry[capacity];
    }

    public Part1(int capacity) {
        this.capacity=capacity;
        size = 0;
        deletedCount=0;
        prime=findPrime();
        arr=new HashEntry[capacity];
    }

    /**
     * 1. Hash Fonksiyonum - Önce bu fonksiyona göre hashliyorum. Eğer collision meydana gelirse double hashing yapıyorum
     * @param key Key değeri
     * @return Hashcode'un size'a modu
     */
    private int hashFunc1(K key){
        return key.hashCode() % capacity;
    }

    /**
     * 2. Hash Fonksiyonum - Double Hashing için kullanıyorum. Collision oluştuktan sonra başka bir index buluyorum
     * @param key  Key değeri
     * @return Hash fonksiyonundan çıkan integer değeri
     */
    private int hashFunc2(K key){
        return  prime - (key.hashCode() % prime);
    }

    /**
     * Sizedan küçük en büyük asal sayıyı bulan fonksiyon
     * @return Sizedan küçük en büyük asal sayı
     */
    private int findPrime(){
        int status;
        for(int i=capacity-1; i>1; i--){
            status=1;
            for(int j=i-1; j>1; j--){
                if(i%j==0){
                    status=0;
                    break;
                }
            }
            if(status==1){
                return i;
            }
        }
        return 3;
    }

    /**
     * Hash Table'mi ekrana yazdıran fonksiyon
     */
    public void printHash(){
        System.out.print("\nHASH TABLE : [");
        for(int i=0; i<capacity; i++) {
            if(arr[i] != null && arr[i].getKey()==null){
                System.out.print(" DELETED ");
            }
            else if(arr[i]==null){
                System.out.print(" null ");
            }
            else {
                System.out.print(" " + arr[i].getValue() + " ");
            }
        }
        System.out.print("]\n\n");
    }

    /**
     * Map interafacesinden override edilen put metodum. Öncelikle ilk hash fonksiyonu kullanılarak arrayin indexine bakılıyor.
     * Eğer o index dolu ise double hashing kullanılarak boş index bulunana kadar yeni index arıyorum.
     * Size'ın 6/10'u dolduktan sonra load balancer çağırılıyor. Size 2 katına çıkartılıp bütün elemanlar yeniden hashleniyor.
     * @param key Key değeri
     * @param value Value değeri
     * @return Eğer olan bir keye yeni value atandıysa eski value return ediliyor yoksa null return ediliyor
     */
    @Override
    public V put(K key, V value) {
        if(key==null || value == null){
            System.out.print("Null key yada value gönderemezsiniz.\n");
            return null;
        }
        if(size>=capacity*60/100){
            System.out.print("LoadFactor Devreye Girdi.Hash Table'ın Boyutu 2 Katına Çıkartılıyor ve Elemanlar Yeniden Hashleniyor.\n\n");
            loadFactor();
        }
        int index = hashFunc1(key);
        if(index<0){
            index += capacity;
        }
        if(arr[index]==null){
            System.out.print("(KEY: " + key + " --- VALUE: " + value + ") Hash Table'a Eklendi.\n");
            arr[index] = new HashEntry<>(key, value);
            size++;
            return null;
        }
        else if(arr[index].getKey()==key){
            System.out.print("(KEY: " + key + " --- VALUE: " + value + ") Bu Key Table'da olduğu için value değiştirildi.\n");
            V temp = arr[index].getValue();
            arr[index] = new HashEntry<>(key, value);
            size++;
            return temp;
        }
        int i=0;
        while(arr[index]!=null && arr[index].getKey()!=key){
            index = ((hashFunc1(key) + i * hashFunc2(key)) % capacity);
            i++;
            if(index<0){
                index = index + capacity;
            }
        }
        if(arr[index]==null){
            System.out.print("(KEY: " + key + " --- VALUE: " + value + ") Hash Table'a Eklendi.\n");
            arr[index] = new HashEntry<>(key, value);
            size++;
            return null;
        }
        else if(arr[index].getKey()==key){
            System.out.print("(KEY: " + key + " --- VALUE: " + value + ") Bu Key Table'da olduğu için value değiştirildi.\n");
            V temp = arr[index].getValue();
            arr[index] = new HashEntry<>(key, value);
            size++;
            return temp;
        }
        return null;
    }

    /**
     * Arraydeki bütün elemanları çıkartıp queueya atıyorum. Size*2 boyutunda Temp bir array oluşturup queuedaki bütün elemanları
     * hashleyerek temp arrayine yerleştiriyorum.
     */
    public void loadFactor(){
        Queue<HashEntry<K,V>> temp = new LinkedList<>();
        for(int i=0; i<capacity; i++) {
            if(arr[i]!=null && arr[i].getKey()!=null && arr[i].getValue()!=null) {
                temp.add(arr[i]);
            }
        }
        capacity = capacity * 2;
        prime = findPrime();
        size = size - deletedCount;
        deletedCount=0;
        HashEntry<K,V> tempArr[] = new HashEntry[capacity];
        while(!temp.isEmpty()){
            HashEntry<K,V> tmp = temp.poll();
            insertTemp(tmp.getKey(), tmp.getValue(), tempArr);
        }
        arr = tempArr;
    }

    /**
     * LoadFactor tarafından çağırılan metod - Verilen key ve value değerini array[] in içine hashlenerek atılıyor.
     * @param key Key değeri
     * @param value Value değeri
     * @param array Key ve valuelerin tutuldugu HashEntry tipinde array
     */
    public void insertTemp(K key, V value, HashEntry<K,V> array[]) {
        int index = hashFunc1(key);
        if(index<0){
            index += capacity;
        }
        if(array[index]==null){
            array[index] = new HashEntry<>(key, value);
            return;
        }
        int i=0;
        while(array[index]!=null){
            index = ((hashFunc1(key) + i * hashFunc2(key)) % capacity);
            i++;
            if(index<0){
                index = index + capacity;
            }
        }
        array[index] = new HashEntry<>(key, value);
    }

    /**
     * Verilen keye karşılık gelen değeri bulan metod
     * @param key Key değeri
     * @return Eğer key mapte varsa karşılık gelen değeri yoksa null return ediyor
     */
    @Override
    public V get(Object key) {
        int deneme = 1;
        if(key==null){
            System.out.print("Get için Null key gönderemezsiniz.\n");
            return null;
        }
        int index = hashFunc1((K) key);
        if(index<0){
            index = index + capacity;
        }
        if(arr[index]!=null && arr[index].getKey().equals(key)){
            System.out.print("KEY : " + key + " --- " + deneme + ". Denemede Bulundu. \n");
            return arr[index].getValue();
        }
        int i = 0;
        while(arr[index]!=null){
            index = ((hashFunc1((K) key) + i * hashFunc2((K) key)) % capacity);
            deneme++;
            i++;
            if(index<0){
                index = index + capacity;
            }
            if(arr[index]!=null && arr[index].getKey()==key){
                System.out.print("KEY : " + key + "  " + deneme + ". Denemede Bulundu. \n");
                return arr[index].getValue();
            }
        }
        System.out.print("KEY : " + key + " --- " + "Bu Key Mapte Değil. \n");
        return null;
    }

    /**
     * Verilen keye gelen karşılık değeri mapten kaldırarark size'ı 1 azaltıyorum. Ve o indexe bişey eklenmesini engellemek için
     * deleted olarak işaretliyorum.
     * @param key Verilen key değeri
     * @return Eğer key mapte varsa karşılık gelen değeri yoksa bir şey remove edilmediği için null return ediyor
     */
    @Override
    public V remove(Object key){
        if(key==null){
            System.out.print("Remove için Null key gönderemezsiniz.\n");
            return null;
        }
        int index = hashFunc1((K) key);
        if(index<0){
            index = index + capacity;
        }
        if(arr[index].getKey()==key){
            System.out.print("(KEY: " + key + " --- VALUE: " + arr[index].getValue() + ") Hash Tabledan Silindi Ve Deleted Olarak İşaretlendi.\n");
            V temp = arr[index].getValue();
            deletedCount++;
            arr[index].setKey(null);
            arr[index].setValue(null);
            return temp;
        }
        int i=0;
        while(arr[index]!=null){
            index = ((hashFunc1((K) key) + i * hashFunc2((K) key)) % capacity);
            i++;
            if(index<0){
                index = index + capacity;
            }
            if(arr[index]!=null && arr[index].getKey()==key){
                System.out.print("(KEY: " + key + " --- VALUE: " + arr[index].getValue() + ") Hash Tabledan Silindi Ve Deleted Olarak İşaretlendi.\n");
                V temp = arr[index].getValue();
                deletedCount++;
                arr[index].setKey(null);
                arr[index].setValue(null);
                return temp;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size>0){
            return false;
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }
}
