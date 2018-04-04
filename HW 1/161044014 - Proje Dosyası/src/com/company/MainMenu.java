package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * Kullanıcının karşısında giriş yada kayıt yapmasını soran ilk ekranın class'ı.Eğer kullanıcı giriş yaparsa kullanıcının ismi login verilerinin tutulduğu classtan alınıp.Burdaki verilerime atıyorum.
 */
public class MainMenu {
    private String name;
    private String surname;
    private String id;
    private String password;
    private boolean isReceptionist;

    /**
     * Parametresiz constructor'ım. Verilerimi ilklendiriyor.
     */
    public MainMenu(){
        super();
        name = "";
        surname = "";
        id = "";
        isReceptionist = false;
    }

    /**
     * Resepsiyonist olarak giriş yapacağımda kullandığım constructor
     *
     * @param b Boolean değer - Kod içerisinde "true" değerini yolluyorum.Bu sayede isReceptionist değerim true oluyor.
     */
    public MainMenu(boolean b){
        super();
        name = "";
        surname = "";
        id = "";
        isReceptionist = b;
    }

    /**
     * toString metodunu override ettim.Kullanıcıya dair verileri string olarak return ediyor.
     * @return isim, soyisim ve id'yi string olarak return ediyorum
     */
    @Override
    public String toString() {
        return name + " " + surname + " " + id;
    }

    /**
     * İsmi return eden getter
     * @return name değişkeni return ediliyor
     */
    public String getName(){
        return name;
    }

    /**
     * Soyismi return eden getter
     * @return surname değişkeni return ediliyor
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Id'yi return eden getter
     * @return id değişkenini return ediliyor
     */
    public String getId(){
        return id;
    }

    /**
     * Kullanıcının ismi, soyismi, id'si ve şifresini alıyorum."users.csv" dosyası içerisinde o id kayıtlı değil ise kullanıcının
     * kaydını "users.csv" dosyasına kaydediyorum.Eğer kayıtlı ise başka id girene kadar fonksiyon bitmiyor.Olmayan bir id girildiğinde kayıt
     * tamamlanıp ana menüye dönüyor.
     * @throws IOException Eğer dosya açılmazsa fırlattığım exception
     */
    public void signup() throws IOException {
        int status = 1;
        String name, surname, pass, id="";
        FileWriter fw = new FileWriter("users.csv", true);
        System.out.print("Lütfen isminizi giriniz: ");
        name = Main.input.nextLine();
        System.out.print("\nLütfen soy isminizi giriniz: ");
        surname = Main.input.nextLine();
        while(status==1){
            System.out.print("\nLütfen sadece sayılardan oluşan ID'nizi giriniz: ");
            if (Main.input.hasNextInt()) {
                id = String.valueOf(Main.input.nextInt());
                if(checkDuplicate(id)==1){
                    System.out.print("\n Bu Id Zaten Sistemde Kayıtlı.Lütfen Başka Id Seçiniz.\n");
                }
                else {
                    status = 0;
                }
            }
        }
        System.out.print("\nLütfen şifrenizi giriniz: ");
        pass = Main.input.nextLine();
        pass = Main.input.nextLine();
        fw.write(name + ";" + surname + ";" + id + ";" + pass + ";");
        System.out.print("\nKayıt işlemi başarılı! Giriş Yapabilirsiniz.\n");
        fw.close();
    }

    /**
     * Kullanıcı resepsiyonistse "receptionist.csv" içerisine, kullanıcı misafir ise "users.csv" dosyasını kontrol ediyorum.
     * Eğer kullanıcıdan aldığım id ve şifre değişkenleri ilgili dosya içerisindeki veriyle uyuşuyorsa o kullanıcının sisteme girişini
     * sağlıyorum ve kullanıcının isim, soyisim, id gibi değerlerini zaten giriş yaparken aldığım için oda rezervasyonu gibi işlemlerde
     * tekrar sormuyorum.
     * @return Giriş başarılı olursa 1, değilse 0 return ediyorum.
     * @throws FileNotFoundException Dosya bulunmazsa throwladığım exception
     */
    public int login() throws FileNotFoundException {
        int againStatus = 1;
        while(true) {
            Scanner scanner = null;
            if(isReceptionist==true) {
                scanner = new Scanner(new FileReader("receptionist.csv"));
            }
            else{
                scanner = new Scanner(new FileReader("users.csv"));
            }
            scanner.useDelimiter(";");
            scanner.nextLine();
            System.out.print("\nLütfen ID'nizi giriniz: ");
            String tempId = Main.input.nextLine();
            System.out.print("\nLütfen Parolanızı giriniz: ");
            String tempPass = Main.input.nextLine();
            while(scanner.hasNext()){
                name = scanner.next();
                surname = scanner.next();
                id = scanner.next();
                password = scanner.next();
                scanner.nextLine();
                if (id.equals(tempId)) {
                    if (password.equals(tempPass)) {
                        System.out.print("\nGiris Basarili!");
                        return 1;
                    }
                }
            }
            againStatus = 1;
            while(againStatus==1) {
                System.out.print("\nGiris Basarisiz! Tekrar Denemek İcin 1'e, Ana Menuye Donmek İcin 0'a Basınız: ");
                String temp = Main.input.nextLine();
                if(temp.equals("1")){
                    againStatus=0;
                }
                else if(temp.equals("0")){
                    return 0;
                }

            }
        }
    }

    /**
     * Yolladığım id'nin dosyada daha önce olup olmadığını kontrol ediyorum.Eğer varsa kullanıcı tekrar kayıt yapamasın diye
     * return değerimi signup fonksiyonuma yolluyorum.
     * @param id Kullanıcının id'si
     * @return Eğer kullanıcı id'si dosyada varsa 1 değilse 0 return ediyorum
     * @throws FileNotFoundException Dosya açılmazsa fırlatılacak olan exception
     */
    public int checkDuplicate(String id) throws FileNotFoundException {
        String tempId;
        Scanner scanner = new Scanner(new FileReader("users.csv"));
        scanner.useDelimiter(";");
        scanner.nextLine();
        while(scanner.hasNext()){
            scanner.next();
            scanner.next();
            tempId = scanner.next();
            scanner.next();
            scanner.nextLine();
            if (id.equals(tempId)) {
                scanner.close();
                return 1;
            }
        }
        scanner.close();
        return 0;
    }

    /**
     * Room arrayimi "rooms.csv" adlı dosyadan dolduran fonksiyon."rooms.csv" dosyasından gerekli verileri okuyup rooms arrayimi
     * dolduruyorum.
     * @param rooms Room classından oluşturulan array
     * @throws FileNotFoundException Dosya açılamazsa fırlatılan exception
     */
    public void fillRoomsArr(Room[] rooms) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("rooms.csv"));
        scanner.useDelimiter(";");
        scanner.nextLine();
        int i = 0;
        while(scanner.hasNext() || i<15){
            rooms[i].setNumber(scanner.next());
            rooms[i].setCapacity(scanner.next());
            rooms[i].setIsBooked(scanner.next());
            rooms[i].setName(scanner.next());
            rooms[i].setSurname(scanner.next());
            rooms[i].setId(scanner.next());
            rooms[i].setDuration(scanner.next());
            scanner.nextLine();
            i++;
        }
    }

    /**
     * Rooms arrayimdeki verileri "rooms.csv" dosyasına yazdıran fonksiyonum.Herhangi bir işlemden sonra bu fonksiyonu çağırıyorum
     * Böylece csv dosyası sürekli güncelleniyor.
     * @param rooms Room classından oluşturulan array
     * @throws IOException Dosya açılamazsa fırlattığım exception
     */
    public void updateRecords(Room[] rooms) throws IOException {
        FileWriter fw = new FileWriter("rooms.csv", false);
        fw.write("Oda Numarasi;Kapasite;Rezerve/Check-in;Isim;Soyisim;ID;Sure;\n");
        for(int i = 0 ; i < 15 ; i ++){
            fw.write(rooms[i].getNumber() + ";" + rooms[i].getCapacity() + ";" + rooms[i].getIsBooked() + ";" + rooms[i].getName() + ";" + rooms[i].getSurname() + ";" + rooms[i].getId() + ";" + rooms[i].getDuration() + ";" + "\n");
        }
        fw.close();
    }

}
