package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Main classıma dosyadan input yollamak için oluşturduğum class
 */
public class MainWrapper {

    /**
     * Bu main methodu çağırılarak asıl main metoduma txt dosyasından input yönlendiriyorum
     * @param args Main'e yollayacak oldugum dosya
     * @throws IOException Dosya açılmazsa fırlatılacak olan exception
     */
    public static void main(String[] args) throws IOException {
            FileInputStream is = new FileInputStream(new File("3.txt"));
            System.setIn(is);
            Main.main(args);
    }

}

