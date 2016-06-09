package com.example.annie.glam.Model;

import java.util.Date;

/**
 * Created by DH Yuka on 6/9/2016.
 */
public class Product {
    int Id;
    String MaSP;
    String Name;
    String Image;
    String KieuSP;
    boolean Active;
    String GiaBD;
    String GiaHT;
    Date NgayDang;
    String Id_MenuItem;

    public Product(int Id, String MaSP, String Name, String Image, String KieuSP, boolean Active, String GiaBD,
                   String GiaHT, Date NgayDang, String Id_MenuItem) {
        this.Id = Id;
        this.MaSP = MaSP;
        this.Name = Name;
        this.Image = Image;
        this.KieuSP = KieuSP;
        this.Active = Active;
        this.GiaBD = GiaBD;
        this.GiaHT = GiaHT;
        this.NgayDang = NgayDang;
        this.Id_MenuItem = Id_MenuItem;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public String getKieuSP() {
        return KieuSP;
    }

    public void setKieuSP(String kieuSP) {
        KieuSP = kieuSP;
    }

    public String getGiaBD() {
        return GiaBD;
    }

    public void setGiaBD(String giaBD) {
        GiaBD = giaBD;
    }

    public String getGiaHT() {
        return GiaHT;
    }

    public void setGiaHT(String giaHT) {
        GiaHT = giaHT;
    }

    public Date getNgayDang() {
        return NgayDang;
    }

    public void setNgayDang(Date ngayDang) {
        NgayDang = ngayDang;
    }

    public String getId_MenuItem() {
        return Id_MenuItem;
    }

    public void setId_MenuItem(String id_MenuItem) {
        Id_MenuItem = id_MenuItem;
    }


}

