package com.example.agendacontactos;

public class Contact {
    private String Name;
    private  String Email;
    private String imageUrl;

    public Contact(String name, String email, String imageUrl) {
        Name = name;
        Email = email;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String atoString() {
        return "Contact{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
