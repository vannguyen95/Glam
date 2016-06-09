package com.example.annie.glam.Model;

/**
 * Created by DH Yuka on 6/9/2016.
 */
public class DesProduct {
    String MaSP,DsHinhAnh,ThongTinChiTiet,FullSize;

    public DesProduct(String maSP, String dsHinhAnh, String thongTinChiTiet, String fullSize) {
        this.MaSP = maSP;
        this.DsHinhAnh = dsHinhAnh;
        this.ThongTinChiTiet = thongTinChiTiet;
        this.FullSize = fullSize;
    }

    public String getFullSize() {
        return FullSize;
    }

    public void setFullSize(String fullSize) {
        FullSize = fullSize;
    }

    public String getThongTinChiTiet() {
        return ThongTinChiTiet;
    }

    public void setThongTinChiTiet(String thongTinChiTiet) {
        ThongTinChiTiet = thongTinChiTiet;
    }

    public String getDsHinhAnh() {
        return DsHinhAnh;
    }

    public void setDsHinhAnh(String dsHinhAnh) {
        DsHinhAnh = dsHinhAnh;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }
}

