package com.tri.plasma;



public class User {
    public String name, email, phone, blood,add;

    public User(){

    }

    public User(String name, String email, String phone,String blood, String add ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.blood=blood;
        this.add=add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
