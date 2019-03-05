package com.company.Q1Folder;

/**
 * Her bir entryde key ve value tutuyorum.Classımda HashEntry tipinde array tutuyorum
 * @param <K> Generic key
 * @param <V> Generic value
 */
public class HashEntry<K,V> {
    private K key;
    private V value;

    /**
     * Constructor
     * @param key Key Değeri
     * @param value Value değeri
     */
    HashEntry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
