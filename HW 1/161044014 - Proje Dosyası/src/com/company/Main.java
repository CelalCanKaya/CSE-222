package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main classım
 */
public class Main {

    /**
     * Dosyadan input alabilmek için global static bir scanner tanımladım.Bütün scanner işlemlerinde bu scanner'ı kullanıyorum.
     */
    public static Scanner input = new Scanner(System.in);

    /**
     * Diğer classlardan oluşturduğum objelerle programın genel akışının olduğu class.
     * @param args Main fonksiyonu çağrılırken konsoldan yollanan parametre
     * @throws IOException Dosyanın açılmama durumunda fırlatılacak exception
     */
    public static void main(String[] args) throws IOException {
        MainMenu m = new MainMenu();
        User user = new User();
        User receptionist = new ReceptionistOpe();
        ReceptionistOpe receptionist2 = new ReceptionistOpe();
        Room[] rooms = new Room[15];
        for(int i=0; i<15; i++){
            rooms[i] = new Room();
        }
        m.fillRoomsArr(rooms);
        m.updateRecords(rooms);
        System.out.println("GTU Otele Hosgeldiniz!\n\n");
        while(true) {
            System.out.println("1 - Resepsiyonist Olarak Giris Yap");
            System.out.println("2 - Kullanıcı Olarak Giris Yap");
            System.out.println("3 - Sisteme Kayit Ol");
            System.out.println("0 - Otomasyondan Cık\n");
            int status = 1;
            int status2 = 1;
            int status3 = 1;
            while(status == 1) {
                System.out.println("İslem Seciniz:");
                String temp = Main.input.nextLine();
                if(temp.equals("1")){
                    MainMenu r = new MainMenu(true);
                    int res = 0;
                    try {
                        res = r.login();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    if(res == 1){
                        status2=1;
                        while(status2 == 1){
                            System.out.println("\n1 - Rezervasyon Yap");
                            System.out.println("2 - Rezervasyonunu Iptal Et");
                            System.out.println("3 - Check-in Yap");
                            System.out.println("4 - Check out Yap");
                            System.out.println("0 - Ana Menüye Dön\n");
                            System.out.println("İslem Seciniz:");
                            String temp3 = Main.input.nextLine();
                            if(temp3.equals("1")){
                                System.out.print("\nİsminiz: ");
                                String nameInput, surnameInput, idInput;
                                nameInput = Main.input.nextLine();
                                System.out.print("\nSoyisminiz: ");
                                surnameInput = Main.input.nextLine();
                                System.out.print("\nID'niz: ");
                                idInput = Main.input.nextLine();
                                receptionist.BookRoom(nameInput, surnameInput, idInput, rooms);
                                m.updateRecords(rooms);
                            }
                            else if(temp3.equals("2")){
                                System.out.print("\nID'niz: ");
                                String idInput;
                                idInput = Main.input.nextLine();
                                receptionist.CancelBook(idInput, rooms);
                                m.updateRecords(rooms);
                            }
                            else if(temp3.equals("3")){
                                String idInput;
                                System.out.print("\nID'niz: ");
                                idInput = Main.input.nextLine();
                                receptionist2.CheckIn(idInput, rooms);
                                m.updateRecords(rooms);
                            }
                            else if(temp3.equals("4")){
                                String idInput;
                                System.out.print("\nID'niz: ");
                                idInput = Main.input.nextLine();
                                receptionist2.CheckOut(idInput, rooms);
                                m.updateRecords(rooms);
                            }
                            else if(temp3.equals("0")){
                                status=0;
                                break;
                            }
                        }
                    } else if (res == 0) {
                        status=0;
                    }
                }
                else if (temp.equals("2")) {
                    try {
                        int res = m.login();
                        if (res == 1) {
                            status3=1;
                            while(status3 == 1){
                                System.out.println("\n1 - Rezervasyon Yap");
                                System.out.println("2 - Rezervasyonunu Iptal Et");
                                System.out.println("0 - Ana Menüye Dön\n");
                                System.out.println("İslem Seciniz:");
                                String temp3 = Main.input.nextLine();
                                if(temp3.equals("1")){
                                    user.BookRoom(m.getName(), m.getSurname(), m.getId(), rooms);
                                    m.updateRecords(rooms);
                                }
                                else if(temp3.equals("2")){
                                    user.CancelBook(m.getId(), rooms);
                                    m.updateRecords(rooms);
                                }
                                else if(temp3.equals("0")){
                                    status=0;
                                    break;
                                }
                            }
                        } else if (res == 0) {
                            status=0;
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                else if(temp.equals("3")){
                    try {
                        m.signup();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(temp.equals("0")){
                    System.exit(0);
                }
            }
        }
    }
}
