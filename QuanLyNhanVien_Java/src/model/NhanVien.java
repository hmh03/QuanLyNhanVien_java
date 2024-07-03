/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class NhanVien {
    private String MaNV;
    private String MaND;
    private String Ten;
    private Date NgaySinh;
    private String DiaChi;
    private String GioiTinh;
    private String STK;
    private String SDT;
    private String Email;
    private String ChucVu;
    private int ChamCong;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String MaND, String Ten, Date NgaySinh, String DiaChi, String GioiTinh, String STK, String SDT, String Email, String ChucVu, int ChamCong) {
        this.MaNV = MaNV;
        this.MaND = MaND;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.STK = STK;
        this.SDT = SDT;
        this.Email = Email;
        this.ChucVu = ChucVu;
        this.ChamCong = ChamCong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNgaySinh() {
 //       return NgaySinh;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(NgaySinh);
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh =  NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSTK() {
        return STK;
    }

    public void setSTK(String STK) {
        this.STK = STK;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getChamCong() {
        return ChamCong;
    }

    public void setChamCong(int ChamCong) {
        this.ChamCong = ChamCong;
    }
           
}
