/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class ChucVu {
    private String Chucvu;
    private float HeSoLuong;

    public ChucVu(String Chucvu, float HeSoLuong) {
        this.Chucvu = Chucvu;
        this.HeSoLuong = HeSoLuong;
    }

    public ChucVu() {
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public float getHeSoLuong() {
        return HeSoLuong;
    }

    public void setHeSoLuong(float HeSoLuong) {
        this.HeSoLuong = HeSoLuong;
    }
    
    
}
