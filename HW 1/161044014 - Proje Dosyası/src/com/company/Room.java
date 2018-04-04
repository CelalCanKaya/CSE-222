package com.company;

/**
 * Oda bilgilerini tutmuş olduğum classım.Sadece veri, getter ve setterlardan oluşuyor.Getterlar ve setterları gerek olmadığı için açıklamadım.
 */
public class Room {
    private String number;
    private String capacity;
    private String isBooked;
    private String name;
    private String surname;
    private String Id;
    private String duration;

    /**
     * Parametresiz constructorım
     */
    public Room(){
        super();
        number = "";
        capacity = "";
        isBooked = "";
        name = "";
        surname = "";
        Id = "";
        duration = "";
    }

    /**
     * Verileri ekrana yazdırmak için override ettiğim toString metodu
     * @return Verileri toplu şekilde string olarak return ediyor
     */
    @Override
    public String toString() {
        return number + " " + capacity + " " + isBooked + " " + name + " " + surname + " " + Id + " " + duration;
    }

    public void setNumber(String a){
        number = a;
    }

    public void setCapacity(String a){
        capacity = a;
    }

    public void setIsBooked(String a){
        isBooked = a;
    }

    public void setName(String a){
        name = a;
    }

    public void setSurname(String a){
        surname = a;
    }

    public void setId(String a){
        Id = a;
    }

    public void setDuration(String a){
        duration=a;
    }

    public String getNumber(){
        return number;
    }

    public String getCapacity(){
        return capacity;
    }

    public String getIsBooked(){
        return isBooked;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getId(){
        return Id;
    }

    public String getDuration(){
        return duration;
    }

}
