package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BinaryTree classından extend edilmiş class
 * @param <E> Generic Data Type
 */
public class Part1<E> extends BinaryTree {

    /**
     * Levelordersearch yaparken gerekli olan queue
     */
    Queue<Node> queue = new LinkedList<>();

    /**
     * Default constructor - Super classın constructorını çağırıyor
     */
    public Part1() {
        super();
    }

    /**
     * Verilen parentItem'i levelOrder veya postOrder search ile arayıp childItem'i onun çocugu olarak ekliyor
     * @param parentItem Cocuk ekleyecegimz item
     * @param childItem Eklenecek item
     * @return  İslem basarılıysa true, basarisizsa false
     */
    public boolean add(E parentItem, E childItem) {
        Node<E> temp = null;
        if (root == null) {
            root = new Node<E>(childItem);
            return true;
        }
        temp = levelOrderSearch(root, parentItem);
        if (temp == null) {
            return false;
        }
        else {
            if (temp.left == null) {
                temp.left = new Node<E>(childItem);
            }
            else {
                temp = temp.left;
                while (!(temp.right == null)) {
                    temp = temp.right;
                }
                temp.right = new Node<E>(childItem);
            }
        }
        return true;
    }

    /**
     * 1. Levelden başlayıp bütün levelleri sıra sıra geziyor.Aranan eleman bulunduysa diğer node'lara bakmıyor.
     * @param r Aramanın baslayacagi node
     * @param searchedElement Aranan eleman
     * @return Eger node bulunduysa o node ' u bulunmadıysa null donduruyor
     */
    public Node<E> levelOrderSearch(Node<E> r, E searchedElement) {
        Node<E> ret = null;
        System.out.print(r.data + " ");
        if (r.data.equals(searchedElement)) {
            ret = r;
            return ret;
        }
        if (r.left != null) {
            queue.add(r.left);
        }
        if (r.right != null) {
            ret = levelOrderSearch(r.right, searchedElement);
        }
        if (ret != null) {
            return ret;
        }
        if(!(queue.isEmpty())){
            ret = levelOrderSearch(queue.poll(), searchedElement);
        }
        return ret;


    }

    /**
     * Recursive şekilde ağacı en aşağıdan yukarıya dogru tarıyor.Eger eleman bulundyusa diger nodelara bakmiyor
     * @param r Aramanın baslayacagi node
     * @param searchedElement Aranan eleman
     * @return Eger node bulunduysa o node ' u bulunmadıysa null donduruyor
     */
    public Node<E> postOrderSearch(Node<E> r, E searchedElement) {
        Node<E> ret = null;
        if (r.left != null) {
            ret = postOrderSearch(r.left, searchedElement);
        }
        if(ret == null){
            System.out.print(r.data + " ");
        }
        if(r.data == searchedElement){
            ret = r;
            return ret;
        }
        if (ret == null && r.right != null) {
            ret = postOrderSearch(r.right, searchedElement);
        }
        return ret;
    }

    /**
     * Agacı string olarak ekrana bastırmamı sagliyan fonksiyon
     * @param node Baslangic node'u
     * @param depth Node'un leveli
     * @param sb Agactaki elemanlari ekledigimiz string
     */
    private void preOrderTraverse(Node<E> node, int depth,
                                  StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth, sb);
        }
    }

    /**
     * Override ettigim toString metodu
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        System.out.print( sb );
        return sb.toString();    }
}
