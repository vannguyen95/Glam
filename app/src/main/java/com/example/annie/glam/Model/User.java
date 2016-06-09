package com.example.annie.glam.Model;

import java.sql.Date;

/**
 * Created by DH Yuka on 6/9/2016.
 */
public class User {

    String Email;
    String FullName;
    String PassWord;
    String Address;
    String GioiTinh;
    int PhoneNumber;
    Date BirthDay;

    public User(String Email, String FullName, String PassWord, String Address, String GioiTinh, int PhoneNumber, Date BirthDay) {
        this.Email = Email;
        this.FullName = FullName;
        this.PassWord = PassWord;
        this.Address = Address;
        this.GioiTinh = GioiTinh;
        this.PhoneNumber = PhoneNumber;
        this.BirthDay = BirthDay;
    }

    public User(String Email, String PassWord) {
        this.Email = Email;
        this.PassWord = PassWord;

    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
