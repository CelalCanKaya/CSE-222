package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * BookRoom ve CancelRoom hem misafir hem resepsiyonist için ortak olacağından oluşturduğum interface
 */
public interface OperationsInt {
    /**
     * Kullanıcının oda rezerve edebilmesini sağlayan metodum
     * @param name Kullsnıcının ismi
     * @param surname Kullanıcının soyismi
     * @param id Kullanıcının id'si
     * @param rooms Room arrayim
     * @throws IOException Dosya açılamazsa fırlatılacak olan exceptionım
     */
    public void BookRoom(String name, String surname, String id, Room rooms[]) throws IOException;

    /**
     * Kullanıcının yaptığı rezervasyonu iptal edebilmesini sağlayan metodum
     * @param id Kullanıcının idsi
     * @param rooms Room arrayim
     * @throws FileNotFoundException Dosya açılmazsa fırlatılacak olan exception ım
     */
    public void CancelBook(String id, Room rooms[]) throws FileNotFoundException;
}
