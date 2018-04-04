package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Misafir kullanıcının yapabildiği işlemleri implement ettiğim classım.
 * OperationsInt adlı interfacedeki BookRoom ve CancelRoom'u yapabildiği için OperationsInt adlı interfaceyi implement ettim.
 */
public class User implements OperationsInt {

    /**
     * Kullanıcının gerekli bilgilerini parametre olarak alıyorum.Kullanıcıya kaç kişilik oda istediğini soruyorum.Eğer istediği
     * oda mevcut ise kaç gün kalacağını soruyorum.Aldığım verileri "rooms.csv" dosyasına işleyerek kullanıcının rezervasyonunu gerçekleştiriyorum.
     * @param name Kullsnıcının ismi
     * @param surname Kullanıcının soyismi
     * @param id Kullanıcının id'si
     * @param rooms Room arrayim
     * @throws IOException Dosya açılamazsa fırlatılacak olan exception
     */
    public void BookRoom(String name, String surname, String id, Room rooms[]) throws IOException {
        int status = 1;
        while(status==1) {
            System.out.print("\nKaç Kişilik Oda Rezerve Etmek İstiyorsunuz?(1-2-3-4) ");
            String temp = Main.input.nextLine();
            if(temp.equals("1")){
                int success = 0;
                for(int i = 0 ; i<7; i++){
                    if(rooms[i].getIsBooked().equals(" ")){
                        int status2=1;
                        while(status2==1) {
                            System.out.print("\n Kaç Günlük Rezerve Etmek İstiyorsunuz? ");
                            if (Main.input.hasNextInt()) {
                                rooms[i].setDuration(String.valueOf(Main.input.nextInt()));
                                System.out.print(i+1 + " Numaralı Oda Rezerve Edildi.");
                                status2=0;
                                status=0;
                            }
                        }
                        rooms[i].setIsBooked("Rezerve Edildi");
                        rooms[i].setName(name);
                        rooms[i].setSurname(surname);
                        rooms[i].setId(id);
                        success = 1;
                        break;
                    }
                }
                if(success == 0){
                    System.out.print("Tek Kisilik Odamiz Kalmamistir.");
                }
            }
            else if(temp.equals("2")){
                int success = 0;
                for(int i = 7 ; i<12; i++){
                    if(rooms[i].getIsBooked().equals(" ")){
                        int status2=1;
                        while(status2==1) {
                            System.out.print("\n Kaç Günlük Rezerve Etmek İstiyorsunuz? ");
                            if (Main.input.hasNextInt()) {
                                rooms[i].setDuration(String.valueOf(Main.input.nextInt()));
                                System.out.print(i+1 + " Numaralı Oda Rezerve Edildi.");
                                status2=0;
                                status=0;
                            }
                        }
                        rooms[i].setIsBooked("Rezerve Edildi");
                        rooms[i].setName(name);
                        rooms[i].setSurname(surname);
                        rooms[i].setId(id);
                        success = 1;
                        break;
                    }
                }
                if(success == 0){
                    System.out.print("Çift Kisilik Odamiz Kalmamistir.");
                }
            }
            else if(temp.equals("3")){
                int success = 0;
                for(int i = 11 ; i<13; i++){
                    if(rooms[i].getIsBooked().equals(" ")){
                        int status2=1;
                        while(status2==1) {
                            System.out.print("\n Kaç Günlük Rezerve Etmek İstiyorsunuz? ");
                            if (Main.input.hasNextInt()) {
                                rooms[i].setDuration(String.valueOf(Main.input.nextInt()));
                                System.out.print(i+1 + " Numaralı Oda Rezerve Edildi.");
                                status2=0;
                                status=0;
                            }
                        }
                        rooms[i].setIsBooked("Rezerve Edildi");
                        rooms[i].setName(name);
                        rooms[i].setSurname(surname);
                        rooms[i].setId(id);
                        success = 1;
                        break;
                    }
                }
                if(success == 0){
                    System.out.print("Üç Kisilik Odamiz Kalmamistir.");
                }
            }
            else if(temp.equals("4")){
                int success = 0;
                for(int i = 13 ; i<15; i++){
                    if(rooms[i].getIsBooked().equals(" ")){
                        int status2=1;
                        while(status2==1) {
                            System.out.print("\n Kaç Günlük Rezerve Etmek İstiyorsunuz? ");
                            if (Main.input.hasNextInt()) {
                                rooms[i].setDuration(String.valueOf(Main.input.nextInt()));
                                System.out.print(i+1 + " Numaralı Oda Rezerve Edildi.");
                                status2=0;
                                status=0;
                            }
                        }
                        rooms[i].setIsBooked("Rezerve Edildi");
                        rooms[i].setName(name);
                        rooms[i].setSurname(surname);
                        rooms[i].setId(id);
                        success = 1;
                        break;
                    }
                }
                if(success == 0){
                    System.out.print("Dört Kisilik Odamiz Kalmamistir.");
                }
            }
            else{
                System.out.print("Lütfen gecerli bir deger giriniz!");
            }
        }

    }

    /**
     * Bookroom classımda scannerla kullanıcıdan input beklediğim için unit test yapamıyordum.Aldığım o inputları parametre kısmına yazıp
     * ve işlemin başarına göre boolean return edip fonksiyonumu unit test için uygun şekilde overload ettim.Yaptığı iş bakımından book room'dan
     * farkı yok sadece unit test için overload edildi.
     * @param name Kullanıcının ismi
     * @param surname Kullanıcının soyismi
     * @param id Kullanıcının id'si
     * @param kisi Kullanıcının kaç kişilik oda istediği
     * @param gun Kullanıcının kaç gün kalacağı
     * @param rooms Room class arrayim
     * @return Eğer oda başarıyla rezerve edilirse true, edilemezse false return ediyorum
     * @throws IOException Dosya açılamazsa fırlatılacak olan exception
     */
    public boolean BookRoomTest(String name, String surname, String id, String kisi, String gun, Room rooms[]) throws IOException {
        int status = 1;
        while(status==1) {
            System.out.print("\nKaç Kişilik Oda Rezerve Etmek İstiyorsunuz?(1-2-3-4) ");
            String temp = kisi;
            if(temp.equals("1")){
                int success = 0;
                for(int i = 0 ; i<7; i++){
                    if(rooms[i].getIsBooked().equals(" ")){
                        int status2=1;
                        while(status2==1) {
                            System.out.print("\n Kaç Günlük Rezerve Etmek İstiyorsunuz? ");
                                rooms[i].setDuration(gun);
                                System.out.print(i+1 + " Numaralı Oda Rezerve Edildi.");
                                status2=0;
                                status=0;
                        }
                        rooms[i].setIsBooked("Rezerve Edildi");
                        rooms[i].setName(name);
                        rooms[i].setSurname(surname);
                        rooms[i].setId(id);
                        success = 1;
                        return true;
                    }
                }
                if(success == 0){
                    System.out.print("Tek Kisilik Odamiz Kalmamistir.");
                    return false;
                }
            }
            else if(temp.equals("2")){
                int success = 0;
                for(int i = 7 ; i<12; i++){
                    if(rooms[i].getIsBooked().equals(" ")){
                        int status2=1;
                        while(status2==1) {
                            System.out.print("\n Kaç Günlük Rezerve Etmek İstiyorsunuz? ");
                                rooms[i].setDuration(gun);
                                System.out.print(i+1 + " Numaralı Oda Rezerve Edildi.");
                                status2=0;
                                status=0;
                        }
                        rooms[i].setIsBooked("Rezerve Edildi");
                        rooms[i].setName(name);
                        rooms[i].setSurname(surname);
                        rooms[i].setId(id);
                        success = 1;
                        return true;
                    }
                }
                if(success == 0){
                    System.out.print("Çift Kisilik Odamiz Kalmamistir.");
                    return false;
                }
            }
            else if(temp.equals("3")){
                int success = 0;
                for(int i = 11 ; i<13; i++){
                    if(rooms[i].getIsBooked().equals(" ")){
                        int status2=1;
                        while(status2==1) {
                            System.out.print("\n Kaç Günlük Rezerve Etmek İstiyorsunuz? ");
                                rooms[i].setDuration(gun);
                                System.out.print(i+1 + " Numaralı Oda Rezerve Edildi.");
                                status2=0;
                                status=0;
                        }
                        rooms[i].setIsBooked("Rezerve Edildi");
                        rooms[i].setName(name);
                        rooms[i].setSurname(surname);
                        rooms[i].setId(id);
                        success = 1;
                        return true;
                    }
                }
                if(success == 0){
                    System.out.print("Üç Kisilik Odamiz Kalmamistir.");
                    return false;
                }
            }
            else if(temp.equals("4")){
                int success = 0;
                for(int i = 13 ; i<15; i++){
                    if(rooms[i].getIsBooked().equals(" ")){
                        int status2=1;
                        while(status2==1) {
                            System.out.print("\n Kaç Günlük Rezerve Etmek İstiyorsunuz? ");
                                rooms[i].setDuration(gun);
                                System.out.print(i+1 + " Numaralı Oda Rezerve Edildi.");
                                status2=0;
                                status=0;
                        }
                        rooms[i].setIsBooked("Rezerve Edildi");
                        rooms[i].setName(name);
                        rooms[i].setSurname(surname);
                        rooms[i].setId(id);
                        success = 1;
                        return true;
                    }
                }
                if(success == 0){
                    System.out.print("Dört Kisilik Odamiz Kalmamistir.");
                    return false;
                }
            }
            else{
                System.out.print("Lütfen gecerli bir deger giriniz!");
                return false;
            }
        }

        return false;
    }

    /**
     * Kullanıcının id'sini alıp rezervasyon ettiği odaları gösteriyorum.Rezervasyon ettiği odalar arasından hangisini iptal
     * etmek istediğini soruyorum.Kullanıcı geçerli bir oda girer ise o odadan rezervasyonu siliyorum.Sadece rezerve edilmiş odaların
     * rezervasyonunu siliyorum.
     * @param id Kullanıcının idsi
     * @param rooms Room arrayim
     * @throws FileNotFoundException Dosya açılmazsa fırlatılacak olan exceptionım
     */
    public void CancelBook(String id, Room rooms[]) throws FileNotFoundException {
        int[] roomId = new int[15];
        int j = 0;
        int status = 1;
        for(int a=0; a<15; a++){
            roomId[a]=-2;
        }
        for(int i=0; i<15; i++){
            if(rooms[i].getId().equals(id)){
                roomId[j]=i;
                j++;
            }
        }
        if(roomId[0]==-2){
            System.out.print("\nRezervasyon Ettiginiz Oda Bulunmamaktadır!");
            status = 0;
        }
        else {
            System.out.print("\nRezervasyon İptali Yapabilceginiz Odalar: ");
            for (int a = 0; a < 15; a++) {
                if (roomId[a] != -2) {
                    System.out.print(roomId[a]+1 + " ");
                }
            }
        }
        while(status==1) {
            System.out.print("\nHangi Odanın Rezervasyonunu İptal Etmek İstiyorsunuz? ");
            int success = 0;
            String temp = Main.input.nextLine();
            for (int a = 0; a < 15; a++) {
                if (temp.equals(String.valueOf(roomId[a]+1))) {
                    rooms[roomId[a]].setDuration(" ");
                    rooms[roomId[a]].setName(" ");
                    rooms[roomId[a]].setSurname(" ");
                    rooms[roomId[a]].setIsBooked(" ");
                    rooms[roomId[a]].setId(" ");
                    System.out.print("\nRezervasyon Başarıyla İptal Edildi. ");
                    success = 1;
                    status = 0;
                    break;
                }
            }
            if (success == 0) {
                System.out.print("\nLütfen Geçerli Bir Oda Giriniz. ");
            }
        }
    }

    /**
     * Cancelbook classımda scannerla kullanıcıdan input beklediğim için unit test yapamıyordum.Aldığım o inputları parametre kısmına yazıp
     * ve işlemin başarına göre boolean return edip fonksiyonumu unit test için uygun şekilde overload ettim.Yaptığı iş bakımından cancel book'dan
     * farkı yok sadece unit test için overload edildi.
     * @param id Kullanıcının ismi
     * @param oda Rezervasyonun iptal edileceği oda
     * @param rooms Room array'im
     * @return Eğer başarılı şekilde rezervasyon silinirse true, aksi halde false return ediyorum.
     * @throws FileNotFoundException Dosya bulunamazsa fırlatılacak olan exception
     */
    public boolean CancelBookTest(String id, String oda, Room rooms[]) throws FileNotFoundException {
        int[] roomId = new int[15];
        int j = 0;
        int status = 1;
        for(int a=0; a<15; a++){
            roomId[a]=-2;
        }
        for(int i=0; i<15; i++){
            if(rooms[i].getId().equals(id)){
                roomId[j]=i;
                j++;
            }
        }
        if(roomId[0]==-2){
            System.out.print("\nRezervasyon Ettiginiz Oda Bulunmamaktadır!");
            status = 0;
            return false;
        }
        else {
            System.out.print("\nRezervasyon İptali Yapabilceginiz Odalar: ");
            for (int a = 0; a < 15; a++) {
                if (roomId[a] != -2) {
                    System.out.print(roomId[a]+1 + " ");
                }
            }
        }
        while(status==1) {
            System.out.print("\nHangi Odanın Rezervasyonunu İptal Etmek İstiyorsunuz? ");
            int success = 0;
            String temp = oda;
            for (int a = 0; a < 15; a++) {
                if (temp.equals(String.valueOf(roomId[a]+1))) {
                    rooms[roomId[a]].setDuration(" ");
                    rooms[roomId[a]].setName(" ");
                    rooms[roomId[a]].setSurname(" ");
                    rooms[roomId[a]].setIsBooked(" ");
                    rooms[roomId[a]].setId(" ");
                    System.out.print("\nRezervasyon Başarıyla İptal Edildi. ");
                    success = 1;
                    status = 0;
                    return true;
                }
            }
            if (success == 0) {
                System.out.print("\nLütfen Geçerli Bir Oda Giriniz. ");
                return false;
            }
        }
        return false;
    }

}
