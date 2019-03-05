package com.company.Q2Folder;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Set interfacesini implement eden class
 * @param <E> Entry
 */
public class Part2<E> implements Set<E>{

    int elementSize;
    int primeSize;
    public Part2Entry<E> arr[];



    public Part2Entry<E>[] getArr() {
        return arr;
    }

    /**
     * Constructor
     * @param size Size değeri
     */
    Part2(int size){
        arr = new Part2Entry[size];
        for(int i = 0; i<size; i++){
            arr[i] = new Part2Entry<>();
        }
        for(int i =0 ; i<size; i++){
            arr[i].setSize(size);
        }
        primeSize = arr[0].getSize();
        elementSize++;
    }

    /**
     *     Sizedan küçük en büyük asal sayıyı bulan metod
     */
    private int findPrime(int capacity){
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
        return 2;
    }

    /**
     * Arrayin indexlerini initialize eden metod
     * @param size Size değeri
     * @param array İnitialize edilecek olan array
     */
    private void initArr(int size, Part2Entry<E> array[]){
        for(int i = 0; i<size; i++){
            array[i] = new Part2Entry<>();
        }
        for(int i =0 ; i<size; i++){
            array[i].setSize(size);
        }
    }

    /**
     * Hash fonksiyonu
     * @param element Hashlenecek olan element
     * @param size Farklı size değerleri geleceği için parametre olarak gönderilen size
     * @return Hashin sonucu
     */
    private int hashFunc(E element, int size){
        return element.hashCode() % size;
    }

    /**
     * Recursion için array yollamam gerektiği için bu metod işimi görmeyeceği için helper metod yazdım ve return değeri olarak onu çağırdım.
     * @param element Eklenecek olan eleman
     * @return Helper function
     */
    @Override
    public boolean add(E element) {
        return add(element, arr);
    }

    /**
     * Helper function - Verilen elemanı recursion ile verilen arraye ekliyor. Eğer collision meydana gelirse içerdeki arraye göre hashliyor.
     * @param element Eklenecek olan eleman
     * @param array Kontrol edilecek olan array
     * @return Eleman eklendiyse true, eklenmediyse false
     */
    private boolean add(E element, Part2Entry<E> array[]){
        int index = hashFunc(element, array[0].getSize());
        if(array[index].getElement()==null){
            System.out.print("\n\n(Element : " + element + ") " + "Hash Table'a Eklendi.\n");
            array[index].setElement(element);
            elementSize++;
            return true;
        }
        else if(array[index].getElement()==element){
            System.out.print("\n\nBu eleman zaten sette var.\n");
            return false;
        }
        else if(array[index].getElement()!=null && array[index].getElement()!=element && array[index].getArr()==null){
            primeSize = findPrime(primeSize);
            array[index].setArr(new Part2Entry[primeSize]);
            initArr(primeSize,array[index].getArr());
            boolean temp2 = add(element, array[index].getArr());
            return temp2;
        }
        else if(array[index].getElement()!=null && array[index].getElement()!=element){
            add(element, array[index].getArr());
        }
        return false;
    }

    /**
     * Recursion için array yollamam gerektiği için bu metod işimi görmeyeceği için helper metod yazdım ve return değeri olarak onu çağırdım.
     * @param o Silinecek olan eleman
     * @return Helper function
     */
    @Override
    public boolean remove(Object o) {
        return remove(o,arr);
    }

    /**
     * Helper function - Verilen elemanı recursion ile bulup daha sonra onu silip "Deleted" olarak işaretleyen metod
     * @param element Silinecek olan eleman
     * @param array Kontrol edilecek olan array
     * @return Eleman silindiyse true, silinemediyse false
     */
    private boolean remove(Object element, Part2Entry<E> array[]){
        int index = hashFunc((E) element, array[0].getSize());
        if(array[index].getElement()==null){
            System.out.print("\n\nBu element sette değil.\n");
            return false;
        }
        else if(array[index].getElement()==element && array[index].getDeleted()==false){
            System.out.print("\n\n(Element : " + element + ") " + "Hash Table'dan Silindi.\n");
            elementSize--;
            array[index].setDeleted(true);
            return true;
        }
        else if(array[index].getElement()!=null && array[index].getElement()!=element){
            remove(element, array[index].getArr());
        }
        return false;
    }

    /**
     * Recursion için array yollamam gerektiği için bu metod işimi görmeyeceği için helper metod yazdım ve return değeri olarak onu çağırdım.
     * @param o Kontrol edilecek olan eleman
     * @return Helper function
     */
    @Override
    public boolean contains(Object o) {
        return contains(o,arr);
    }

    /**
     * Helper function - Verilen elementin parametre olarak verilen arrayde bulunup bulunmadıgını kontrol ediyor
     * @param element Kontrol edilecek olan eleman
     * @param array Kontrol edilecek olan array
     * @return Eğer eleman arrayde bulunuyorsa true, bulunmuyorsa false gönderiyor
     */
    private boolean contains(Object element, Part2Entry<E> array[] ){
        int index = hashFunc((E) element, array[0].getSize());
        if(array[index].getElement()==null){
            System.out.print("\n\nBu element sette değil.\n");
            return false;
        }
        else if(array[index].getElement()==element && array[index].getDeleted()==false){
            System.out.print("\n\n(Element : " + element + ") " + "Bu element sette bulunuyor.\n");
            return true;
        }
        else if(array[index].getElement()!=null && array[index].getElement()!=element){
            contains(element, array[index].getArr());
        }
        return false;
    }

    @Override
    public int size() {
        return elementSize;
    }

    @Override
    public boolean isEmpty() {
        return elementSize==0;
    }

    /**
     * Recursion ile Table'yi ve içindeki diğer tableleri yazdıran metod
     * @param array Yazdırılacak olan table
     */
    public void printTable(Part2Entry<E> array[]){
        System.out.print("[ ");
        for(int i=0; i<array[0].getSize(); i++){
            if(array[i].getElement()==null){
                System.out.print(" null");
            }
            else if(array[i].getElement()!=null && array[i].getDeleted()==false){
                System.out.print(" " + array[i].getElement());
            }
            else if(array[i].getElement()!=null && array[i].getDeleted()==true){
                System.out.print(" DELETED");
            }
            if(array[i].getArr()!=null){
                printTable(array[i].getArr());
            }
            if(i!=array[0].getSize()-1){
                System.out.print(",");
            }
        }
        System.out.print(" ]");
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

}
