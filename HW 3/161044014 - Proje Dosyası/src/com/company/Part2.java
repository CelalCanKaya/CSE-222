package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * LinkedList Class'ından extend ettim. Enable, Disable ve ShowDisabled metodlarını ekledim.
 * @param <E> Generic parametre. Hangi türde linkedlist olusturmak isteniliyosa o tip giriliyor.
 */
public class Part2<E> extends LinkedList<E> {

    /**
     * disable Ettiğim elemanları sakladığım linkedlist
     */
    private LinkedList<E> disabledlist;

    /**
     * Belli bir indexteki disable edilen elemanı return eden metod
     * @param index Kullanıcının gireceği index
     * @return Disable edilen element
     */
    public E getDisabled(int index){
        return disabledlist.get(index);
    }

    /**
     * Default constructor
     */
    public Part2() {
        super();
        this.disabledlist = new LinkedList<E>();
    }

    /**
     * Disable edilen elemanların size'ı etkilememesi için listemin size'ından disabledlist'in sizeını cıkardım.Böylece enable edilen elemanların size'ı gösteriliyor
     * @return Enable olan elemanların sayısı
     */
    @Override
    public int size() {
        return super.size() - disabledlist.size();
    }

    /**
     * LinkedList'i bastırmak için override ettiğim toString metodu. Linked list'in içindeki enable olan elemanları string şeklinde return ediyor
     * @return Enable olan elemanlar string tipinde return ediliyor
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        if (disabledlist.size() == 0) {
            for (int i = 0; i < super.size(); i++) {
                sb.append(super.get(i).toString());
                sb.append("  ");
            }
        }
        else{
            for(int i=0; i<super.size(); i++){
                for(int j=0; j<disabledlist.size(); j++){
                    if(!(super.get(i).equals(disabledlist.get(j)))){
                        sb.append(super.get(i).toString());
                        sb.append("  ");
                    }
                }
            }
        }

        return sb.toString();
    }

    /**
     * Disable elemanları göstermemek için override edilen get metodu.Verilen index'e, o indexe kadar disable edilen eleman sayısı ekleniyor ve super'in get metodu çağırılıyor.
     * @param index Kullanıcının vereceği index
     * @return Super class'ın get metodu çağırılıyor
     */
    @Override
    public E get(int index) {
        if(index>super.size()){
            throw new IndexOutOfBoundsException();
        }
        int add=0;
        for(int i=0; i<disabledlist.size(); i++){
            for(int j=0; j<=index; j++) {
                if (super.get(j).equals(disabledlist.get(i))) {
                    add++;
                }
            }
        }
        return super.get(index+add);
    }

    /**
     * Disable elemanı set etmemek için override edilen set metodu.Verilen index'e, o indexe kadar disable edilen eleman sayısı ekleniyor ve super'in set metodu çağırılıyor.
     * @param index Kullanıcının vereceği index
     * @param element Listeye eklenecek yeni eleman
     * @return Super class'ın set metodu çağırılıyor
     */
    @Override
    public E set(int index, E element) {
        if(index>super.size()){
            throw new IndexOutOfBoundsException();
        }
        int add=0;
        for(int i=0; i<disabledlist.size(); i++){
            for(int j=0; j<=index; j++) {
                if (super.get(j).equals(disabledlist.get(i))) {
                    add++;
                }
            }
        }
        return super.set(index+add, element);
    }

    /**
     * Disable elemanı remove etmemek için override edilen remove metodu.Verilen index'e, o indexe kadar disable edilen eleman sayısı ekleniyor ve super'in remove metodu çağırılıyor.
     * @param index Kullanıcının vereceği index
     * @return Super class'ın remove metodu
     */
    @Override
    public E remove(int index) {
        if(index>super.size()){
            throw new IndexOutOfBoundsException();
        }
        int add=0;
        for(int i=0; i<disabledlist.size(); i++){
            for(int j=0; j<=index; j++) {
                if (super.get(j).equals(disabledlist.get(i))) {
                    add++;
                }
            }
        }
        return super.remove(index+add);
    }

    /**
     * ListIterator'un disable elemanları göstermemesi için override ettim
     * @param index Kullanıcının vereceği index
     * @return Override edilen ListIterator return ediliyor
     */
        @Override
        public ListIterator<E> listIterator(int index) {
            return new ListIterator<E>(){

                /**
                 * Parametrede verilen index, Index variable'ına atanıyor
                 */
                private int Index = index;

                /**
                 * Index'im size'dan küçükse, linkedList'in next'i vardır
                 * @return next node varsa true yoksa false return ediyor
                 */
                @Override
                public boolean hasNext() {
                    return Index<size();
                }

                /**
                 * Node'un elemanını bastırıp bir sonraki node'a geçiyorum
                 * @return "<E>" tipinde linked list'te tutulan veriyi return ediyorum
                 */
                @Override
                public E next() {
                    E temp = get(Index);
                    Index++;
                    return temp;
                }

                /**
                 * Index, 0'dan büyük oldugu sürece bir önceki eleman var demektir
                 * @return Bir öönce node varsa true, yoksa false return ediyorum
                 */
                @Override
                public boolean hasPrevious() {
                    return Index>0;
                }

                /**
                 * Node'un elemanını bastırıp bir önceki node'a geçiyorum
                 * @return "<E>" tipinde linked list'te tutulan veriyi return ediyorum
                 */
                @Override
                public E previous() {
                    E temp = Part2.super.get(Index);
                    Index--;
                    return temp;
                }

                /**
                 * Index'i 1 arttırıyorum
                 * @return Yeni indexi return ediyorum
                 */
                @Override
                public int nextIndex() {
                    Index++;
                    return Index;
                }

                /**
                 * İndex'i 1 azaltıyorum
                 * @return Yeni indexi return ediyorum
                 */
                @Override
                public int previousIndex() {
                    Index--;
                    return Index;
                }

                /**
                 * Bir değişiklik olmadıgı için super'in remove metodunu cagırıyorum
                 */
                @Override
                public void remove() {
                    Part2.super.remove(Index);
                }

                /**
                 * Bu metodun ne yaptıgını anlamadıgım için boş bıraktım.
                 */
                @Override
                public void forEachRemaining(Consumer<? super E> action) {
                }

                /**
                 * Bir değişiklik olmadıgı için super'in set metodunu cagırıyorum
                 */
                @Override
                public void set(E e) {
                    Part2.super.set(Index, e);
                }

                /**
                 * Bir değişiklik olmadıgı için super'in add metodunu cagırıyorum
                 */
                @Override
                public void add(E e) {
                    Part2.super.add(Index, e);
                }
            };
        }

    /**
     * Disable etmek istedigim elemanı disabledList'ime ekliyorum fakat normal listemden silmiyorum.
     * @param elm Disable edilmek istenen eleman
     * @return Disable edildiyse true, edilmediyse false return ediyorum.
     */
    public boolean disable(E elm){
        for(int i=0; i<size(); i++){
            if(get(i).equals(elm)){
                disabledlist.add(elm);
                return true;
            }
        }
        return false;
    }

    /**
     * Enable etmek istedigim elemanı disabledListten siliyorum
     * @param elm Disable edilmek istenen eleman
     * @return Enable edildiyse true, edilmediyse false return ediyorum.
     */
    public boolean enable(E elm){
        for(int i=0; i<disabledlist.size(); i++){
            if(disabledlist.get(i).equals(elm)){
                disabledlist.remove(elm);
                return true;
            }
        }
        return false;
    }

    /**
     * DisabledList, linked listed'imi ekrana basıyorum
     */
    public void showDisabled(){
        System.out.print(disabledlist);
    }

}
