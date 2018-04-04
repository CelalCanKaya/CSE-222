package com.company;

/**
 * Kendi implement ettigim linked List'im
 * Bazı getter ve setterları acıklamayacagım
 */
public class Part3 {
    /**
     * Bir sonraki node'u ve kendindeki elemanı tutan class
     */
    private class Node{

        /**
         * Bir sonraki node
         */
        public Node nextNode;
        /**
         * Node içerisindeki eleman
         */
        public Courses element;

        /**
         * Parametre olarak verilen courseyi initialize eden constructor
         * @param element Verilen course
         */
        public Node(Courses element){
            this.element = element;
        }

        /**
         *  Parametre olarak verilen courseyi ve nextNode'u initialize eden constructor
         * @param element Verilen course
         * @param nextNode Bir sonraki node
         */
        public Node(Courses element, Node nextNode){
            this.element = element;
            this.nextNode = nextNode;
        }


        public Node getNext(){
            return nextNode;
        }

        public Courses getElement() {
            return element;
        }

        public void setElement(Courses element){
            this.element = element;
        }

        public void setNext(Node next){
            this.nextNode = next;
        }

        public String toString() {
            return element.toString();
        }

    }

    /**
     * Linked list'in üzerinde dolaşmak için implement ettigim iterator
     */
    public class ListIterator{

        private Node current;
        private Node prev;
        private Node temp;

        /**
         * Default constructor
         */
        public  ListIterator() {
            current = head;
            prev = null;
            temp = null;
        }

        /**
         * Bir sonrasında eleman olup olmadıgını kontrol eden metod
         * @return Bir sonraki eleman varsa true, yoksa false return ediyor
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Bir sonrasında eleman olup olmadıgını kontrol eden metod
         * @return Bir sonraki eleman varsa true, yoksa false return ediyor
         */
        public boolean tempHasNext(){
            return temp != null;
        }

        /**
         * Kendi içerisindeki datayı return edip current node'u bir sonraki node'a alıyor.Bunu yapmadan öncede prev'i current node'una atıyor
         * @return Currentteki data
         */
        public Courses next() {
            if(hasNext()) {
                Courses item = current.element;
                prev = current;
                current = current.nextNode;
                return item;
            }
            return null;
        }

        /**
         * Aynı semesterdaki bir sonraki courseyi bulup onu gösteriyor.Eğer course kalmamış ise en baştaki courseye geri dönüyor(Circular linkedlist)
         * @return
         */
        public Courses nextInSemester() {
            if(current==head){
                Courses item = current.element;
                prev = current;
                current=current.nextNode;
                return item;
            }
            if(hasNext()) {
                Courses item = prev.element;
                if(item.getSemester()==current.getElement().getSemester()){
                    item = current.element;
                    prev = current;
                    current = current.nextNode;
                    return item;
                }
                else{
                    temp = current;
                    while(tempHasNext()){
                        if(item.getSemester()==current.getElement().getSemester()){
                            item = current.element;
                            prev=current;
                            current = current.nextNode;
                            return item;
                        }
                        current = current.nextNode;
                        temp = current.nextNode;
                    }
                    current = head;
                    temp = current;
                    while(tempHasNext()){
                        if(item.getSemester()==current.getElement().getSemester()){
                            item = current.element;
                            prev=current;
                            current = current.nextNode;
                            return item;
                        }
                        current = current.nextNode;
                        temp = current.nextNode;
                    }
                }
            }
            return null;
        }

    }

    public ListIterator iterator(){
        return new ListIterator();
    }

    private Node head;
    private Node tail;
    private int listSize;

    /**
     * Default constructor
     */
    public Part3(){
        this.head = null;
        this.tail = null;
        this.listSize = 0;
    }

    public int size(){
        return listSize;
    }

    /**
     * Indexteki elemanı return eden course
     * @param index Verilen index
     * @return Verilen indexteki courseyi return ediyor
     */
    public Courses get(int index){
        if (index < 0 || index >= size()) {
            return null;
        }

        if (index == 0) {
            return head.getElement();
        }

        Node temp = head.getNext();

        for (int i = 1; i < index; i ++) {

            if (temp.getNext() == null) {
                return null;
            }

            temp = temp.getNext();
        }

        System.out.println("\n" + temp.getElement());

        return temp.getElement();
    }

    /**
     * Verilen courseyi linkedlist'in sonuna ekliyor
     * @param element Verilen course
     */
    public void add(Courses element) {
        Node tempAdd = new Node(element);

        if (tail == null) {
            head = tempAdd;
            tail = tempAdd;
        }
        else {
            tail.setNext(tempAdd);
            tail = tempAdd;
        }

        listSize++;
    }

    /**
     * Verilen indexe verilen elemanı ekliyor
     * @param index Verilen index
     * @param element Verilen eleman
     * @return Başarılı olduysa true, değilse false return ediyorum
     */
    public boolean add(int index, Courses element) {
        if (index < 0 || index > size()) {
            return false;
        }

        Node newNode = new Node(element);
        Node prev = null;
        Node current = head;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.getNext();
        }

        if (current == head) {
            newNode.setNext(head);
            head = newNode;
        }
        else if (current == null) {
            tail.setNext(newNode);
            tail = newNode;
        }
        else {
            prev.setNext(newNode);
            newNode.setNext(current);
        }

        listSize++;
        return true;
    }

    /**
     * İlk elemanı listeden silen fonksiyon
     * @return
     */
    private boolean removeFirst() {
        if (size() == 0) {
            return false;
        }

        Node current = head;
        head = head.getNext();
        current.setNext(null);
        listSize--;
        return true;
    }

    /**
     * Son elemanı listeden silen fonksiyon
     * @return
     */
    private boolean removeLast() {
        if (size() == 0) {
            return false;
        }

        if (size() == 1) {
            Node last = tail;
            listSize = 0;
            head = null;
            tail = null;
            return true;
        }

        Node target = head;
        Node prev = null;

        for (int i = 0; i < size() - 1; ++i) {
            prev = target;
            target = target.getNext();
        }

        prev.setNext(null);
        tail = prev;
        return true;
    }

    /**
     * Verilen indexteki elemanı silen metod
     * @param index
     * @return
     */
    public boolean remove(int index) {
        if (index < 0 || index >= size()) {
            return false;
        }

        if (index == 0) {
            removeFirst();
            return true;
        }

        if (index == size() - 1) {
            removeLast();
            return true;
        }

        Node prev = null;
        Node current = head;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.getNext();
        }

        prev.setNext(current.getNext());
        listSize--;
        return true;
    }
}
