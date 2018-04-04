package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Resepsiyonist, normal kullanıcının yapabildiği işlemleri yapabileceği için User classından extend ettim.
 */
public class ReceptionistOpe extends User {
    /**
     * Kullanıcıdan aldığım verilerin sistemde kayıtlı olup olmadığına bakıyorum.Eğer kayıtlıysa super class'ın override ettiğim
     * metodunu çağırıp rezervasyon işlemini tamamlıyorum.
     * @param name Kullsnıcının ismi
     * @param surname Kullanıcının soyismi
     * @param id Kullanıcının id'si
     * @param rooms Room arrayim
     * @throws IOException Dosya açılmazsa fırlatılacak olan exception
     */
    @Override
    public void BookRoom(String name, String surname, String id, Room[] rooms) throws IOException {
        int status = 0;
        Scanner scanner = new Scanner(new FileReader("users.csv"));
        scanner.useDelimiter(";");
        scanner.nextLine();
        String tempName, tempSurname, tempId;
        while(scanner.hasNext()) {
            tempName = scanner.next();
            tempSurname = scanner.next();
            tempId = scanner.next();
            scanner.next();
            scanner.nextLine();
            if(tempName.equals(name) && tempSurname.equals(surname) && tempId.equals(id)){
                status=1;
                break;
            }
        }
        if(status==1) {
            super.BookRoom(name, surname, id, rooms);
        }
        else if(status==0){
            System.out.print("\nBu bilgilerle kayıtlı kişi sistemde bulunmamaktadır! ");
        }
    }

    /**
     *  Kullanıcıdan aldığım verilerin sistemde kayıtlı olup olmadığına bakıyorum.Eğer kayıtlıysa super class'ın override ettiğim
     * metodunu çağırıp rezervasyon iptal etme işlemini tamamlıyorum.
     * @param id Kullanıcının idsi
     * @param rooms Room arrayim
     * @throws FileNotFoundException Dosya açılmazsa fırlatılacak olan exception
     */
    @Override
    public void CancelBook(String id, Room[] rooms) throws FileNotFoundException {
        int status = 0;
        Scanner scanner = new Scanner(new FileReader("users.csv"));
        scanner.useDelimiter(";");
        scanner.nextLine();
        String tempId;
        while(scanner.hasNext()) {
            scanner.next();
            scanner.next();
            tempId = scanner.next();
            scanner.next();
            scanner.nextLine();
            if(tempId.equals(id)){
                status=1;
                break;
            }
        }
        if(status==1){
            super.CancelBook(id, rooms);
        }
        else if(status==0){
            System.out.print("\nBu bilgilerle kayıtlı kişi sistemde bulunmamaktadır! ");
        }
    }

    /**
     * Kullanıcının sistemde kayıtlı olup olmadığını kontrol ediyorum.Eğer sistemde kayıtlıysa ve rezerve ettiği odalar varsa
     * odaları listeliyorum ve hangi odaya checkin yapmak istedigini soruyorum.Geçerli bir oda numarası girerse checkin işlemini tamamlıyorum.
     * @param id Kullanıcının id'si
     * @param rooms Room arrayim
     * @throws FileNotFoundException Dosya bulunmazsa fırlatılacak olan exception
     */
    public void CheckIn(String id, Room rooms[]) throws FileNotFoundException {
        int status = 0;
        Scanner scanner = new Scanner(new FileReader("users.csv"));
        scanner.useDelimiter(";");
        scanner.nextLine();
        String tempId;
        while(scanner.hasNext()) {
            scanner.next();
            scanner.next();
            tempId = scanner.next();
            scanner.next();
            scanner.nextLine();
            if(tempId.equals(id)){
                status=1;
                break;
            }
        }
        if(status==1){
            int[] roomId = new int[15];
            int j = 0;
            int status2 = 1;
            for(int a=0; a<15; a++){
                roomId[a]=-2;
            }
            for(int i=0; i<15; i++){
                if(rooms[i].getId().equals(id) && rooms[i].getIsBooked().equals("Rezerve Edildi")){
                    roomId[j]=i;
                    j++;
                }
            }
            if(roomId[0]==-2){
                System.out.print("\nRezervasyon Ettiginiz Oda Bulunmamaktadır!");
                status2 = 0;
            }
            else {
                System.out.print("\nCheck-in Yapabilceginiz Odalar: ");
                for (int a = 0; a < 15; a++) {
                    if (roomId[a] != -2) {
                        System.out.print(roomId[a]+1 + " ");
                    }
                }
            }
            while(status2==1) {
                System.out.print("\nHangi Oda Icin Check-in Yapmak İstiyorsunuz? ");
                int success = 0;
                String temp = Main.input.nextLine();
                for (int a = 0; a < 15; a++) {
                    if (temp.equals(String.valueOf(roomId[a]+1))) {
                        rooms[roomId[a]].setIsBooked("Check-in");
                        System.out.print("\nCheck-in Başarıyla Yapıldı. ");
                        success = 1;
                        status2 = 0;
                        break;
                    }
                }
                if (success == 0) {
                    System.out.print("\nLütfen Geçerli Bir Oda Giriniz. ");
                }
            }
        }
        else if(status==0){
            System.out.print("\nBu bilgilerle kayıtlı kişi sistemde bulunmamaktadır! ");
        }
    }

    /**
     * Checkin fonksiyonumla aynı işi yapan fonksiyonum.Checkin fonksiyonumda scanner kullandıgım için unit test yapamıyordum.
     * Overload ederek unit test için uygun bir hale getirdim.
     * @param id Kullanıcının idsi
     * @param oda Kullanıcının checkin yaptırmak istedigi oda numarası
     * @param rooms Room arrayim
     * @return Eğer checkin başarılı olursa true aksi halde false return ediyorum
     * @throws FileNotFoundException Dosya bulunamazsa fırlatılacak olan exception ım
     */
    public boolean CheckInTest(String id, String oda, Room rooms[]) throws FileNotFoundException {
        int status = 0;
        Scanner scanner = new Scanner(new FileReader("users.csv"));
        scanner.useDelimiter(";");
        scanner.nextLine();
        String tempId;
        while(scanner.hasNext()) {
            scanner.next();
            scanner.next();
            tempId = scanner.next();
            scanner.next();
            scanner.nextLine();
            if(tempId.equals(id)){
                status=1;
                break;
            }
        }
        if(status==1){
            int[] roomId = new int[15];
            int j = 0;
            int status2 = 1;
            for(int a=0; a<15; a++){
                roomId[a]=-2;
            }
            for(int i=0; i<15; i++){
                if(rooms[i].getId().equals(id) && rooms[i].getIsBooked().equals("Rezerve Edildi")){
                    roomId[j]=i;
                    j++;
                }
            }
            if(roomId[0]==-2){
                System.out.print("\nRezervasyon Ettiginiz Oda Bulunmamaktadır!");
                status2 = 0;
                return false;
            }
            else {
                System.out.print("\nCheck-in Yapabilceginiz Odalar: ");
                for (int a = 0; a < 15; a++) {
                    if (roomId[a] != -2) {
                        System.out.print(roomId[a]+1 + " ");
                    }
                }
            }
            while(status2==1) {
                System.out.print("\nHangi Oda Icin Check-in Yapmak İstiyorsunuz? ");
                int success = 0;
                String temp = oda;
                for (int a = 0; a < 15; a++) {
                    if (temp.equals(String.valueOf(roomId[a]+1))) {
                        rooms[roomId[a]].setIsBooked("Check-in");
                        System.out.print("\nCheck-in Başarıyla Yapıldı. ");
                        success = 1;
                        status2 = 0;
                        return true;
                    }
                }
                if (success == 0) {
                    System.out.print("\nLütfen Geçerli Bir Oda Giriniz. ");
                    return false;
                }
            }
        }
        else if(status==0){
            System.out.print("\nBu bilgilerle kayıtlı kişi sistemde bulunmamaktadır! ");
            return false;
        }
        return false;
    }

    /**
     *  * Kullanıcının sistemde kayıtlı olup olmadığını kontrol ediyorum.Eğer sistemde kayıtlıysa ve rezerve ettiği odalar varsa
     * odaları listeliyorum ve hangi odaya checkout yapmak istedigini soruyorum.Geçerli bir oda numarası girerse ne kadar ücret tahsil
     * edildiğini gösterip checkout işlemini tamamlıyorum.
     * @param id Kullanıcının idsi
     * @param rooms Room arrayim
     * @throws FileNotFoundException Dosya bulunmazsa fırlatılacak olan exception
     */
    public void CheckOut(String id, Room rooms[]) throws FileNotFoundException {
        final int DAILY_FEE = 50;
        int status = 0;
        Scanner scanner = new Scanner(new FileReader("users.csv"));
        scanner.useDelimiter(";");
        scanner.nextLine();
        String tempId;
        while(scanner.hasNext()) {
            scanner.next();
            scanner.next();
            tempId = scanner.next();
            scanner.next();
            scanner.nextLine();
            if(tempId.equals(id)){
                status=1;
                break;
            }
        }
        if(status==1){
            int[] roomId = new int[15];
            int j = 0;
            int status2 = 1;
            for(int a=0; a<15; a++){
                roomId[a]=-2;
            }
            for(int i=0; i<15; i++){
                if(rooms[i].getId().equals(id) && rooms[i].getIsBooked().equals("Check-in")){
                    roomId[j]=i;
                    j++;
                }
            }
            if(roomId[0]==-2){
                System.out.print("\nCheck-in Yaptırdıgınız Oda Bulunmamaktadır!");
                status2 = 0;
            }
            else {
                System.out.print("\nCheck-out Yapabilceginiz Odalar: ");
                for (int a = 0; a < 15; a++) {
                    if (roomId[a] != -2) {
                        System.out.print(roomId[a]+1 + " ");
                    }
                }
            }
            while(status2==1) {
                System.out.print("\nHangi Oda Icin Check-out Yapmak İstiyorsunuz? ");
                int success = 0;
                String temp = Main.input.nextLine();
                for (int a = 0; a < 15; a++) {
                    if (temp.equals(String.valueOf(roomId[a]+1))) {
                        int bill = Integer.parseInt(rooms[roomId[a]].getCapacity()) * Integer.parseInt(rooms[roomId[a]].getDuration()) * DAILY_FEE;
                        rooms[roomId[a]].setDuration(" ");
                        rooms[roomId[a]].setName(" ");
                        rooms[roomId[a]].setSurname(" ");
                        rooms[roomId[a]].setIsBooked(" ");
                        rooms[roomId[a]].setId(" ");
                        System.out.print("\nCheck-out Başarıyla Yapıldı. ");
                        System.out.print("\n" + String.valueOf(bill) + " TL Tahsil Edildi.Yine Bekleriz.\n");
                        success = 1;
                        status2 = 0;
                        break;
                    }
                }
                if (success == 0) {
                    System.out.print("\nLütfen Geçerli Bir Oda Giriniz. ");
                }
            }
        }
        else if(status==0){
            System.out.print("\nBu bilgilerle kayıtlı kişi sistemde bulunmamaktadır! ");
        }
    }

    /**
     *Checkout fonksiyonumla aynı işi yapan fonksiyonum.Checkout fonksiyonumda scanner kullandıgım için unit test yapamıyordum.
     * Overload ederek unit test için uygun bir hale getirdim.
     * @param id Kullanıcının id'si
     * @param oda Kullanıcının checkout yapmak istediği oda numarası
     * @param rooms Room arrayim
     * @return Eğer checkout işlemi başarılı olursa true aksi halde false return ediyorum
     * @throws FileNotFoundException Dosya bulunmazsa fırlatılacak olan exception
     */
    public boolean CheckOutTest(String id, String oda, Room rooms[]) throws FileNotFoundException {
        final int DAILY_FEE = 50;
        int status = 0;
        Scanner scanner = new Scanner(new FileReader("users.csv"));
        scanner.useDelimiter(";");
        scanner.nextLine();
        String tempId;
        while(scanner.hasNext()) {
            scanner.next();
            scanner.next();
            tempId = scanner.next();
            scanner.next();
            scanner.nextLine();
            if(tempId.equals(id)){
                status=1;
                break;
            }
        }
        if(status==1){
            int[] roomId = new int[15];
            int j = 0;
            int status2 = 1;
            for(int a=0; a<15; a++){
                roomId[a]=-2;
            }
            for(int i=0; i<15; i++){
                if(rooms[i].getId().equals(id) && rooms[i].getIsBooked().equals("Check-in")){
                    roomId[j]=i;
                    j++;
                }
            }
            if(roomId[0]==-2){
                System.out.print("\nCheck-in Yaptırdıgınız Oda Bulunmamaktadır!");
                status2 = 0;
                return false;
            }
            else {
                System.out.print("\nCheck-out Yapabilceginiz Odalar: ");
                for (int a = 0; a < 15; a++) {
                    if (roomId[a] != -2) {
                        System.out.print(roomId[a]+1 + " ");
                    }
                }
            }
            while(status2==1) {
                System.out.print("\nHangi Oda Icin Check-out Yapmak İstiyorsunuz? ");
                int success = 0;
                String temp = oda;
                for (int a = 0; a < 15; a++) {
                    if (temp.equals(String.valueOf(roomId[a]+1))) {
                        int bill = Integer.parseInt(rooms[roomId[a]].getCapacity()) * Integer.parseInt(rooms[roomId[a]].getDuration()) * DAILY_FEE;
                        rooms[roomId[a]].setDuration(" ");
                        rooms[roomId[a]].setName(" ");
                        rooms[roomId[a]].setSurname(" ");
                        rooms[roomId[a]].setIsBooked(" ");
                        rooms[roomId[a]].setId(" ");
                        System.out.print("\nCheck-out Başarıyla Yapıldı. ");
                        System.out.print("\n" + String.valueOf(bill) + " TL Tahsil Edildi.Yine Bekleriz.\n");
                        success = 1;
                        status2 = 0;
                        return true;
                    }
                }
                if (success == 0) {
                    System.out.print("\nLütfen Geçerli Bir Oda Giriniz. ");
                    return false;
                }
            }
        }
        else if(status==0){
            System.out.print("\nBu bilgilerle kayıtlı kişi sistemde bulunmamaktadır! ");
            return false;
        }
        return false;
    }
}
