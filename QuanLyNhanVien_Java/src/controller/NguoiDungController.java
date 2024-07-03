/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NguoiDung;

/**
 *
 * @author ASUS
 */
public class NguoiDungController extends KetNoi{
    public NguoiDung dangNhap(String TenDangNhap,String MatKhau,String VaiTro){
        NguoiDung nd= null;
        try
        {
            String sql="select * from NguoiDung where TenDangNhap=? and MatKhau=? and VaiTro=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, TenDangNhap);
            pre.setString(2, MatKhau);
            pre.setString(3, VaiTro);

            ResultSet rs= pre.executeQuery();
            if(rs.next())
            {
                nd= new NguoiDung();
                nd.setMaND(rs.getString(1));
                nd.setTenDangNhap(rs.getString(2));
                nd.setMatKhau(rs.getString(3));
                nd.setVaiTro(rs.getString(4));
             }
        }
            catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }            
        return nd;
    }
        public ArrayList<NguoiDung> hienThiNguoiDung(){
        ArrayList<NguoiDung> dsnd= new ArrayList<NguoiDung>();
        try {
            String sql="select * from NguoiDung";
            PreparedStatement pstm=con.prepareStatement(sql);
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
                dsnd.add(new NguoiDung(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
             
        } catch (Exception e) {
        }
        return dsnd;
    }
         public ArrayList<NguoiDung> timKiemNguoiDung(String ten){
        ArrayList<NguoiDung> timND= new ArrayList<NguoiDung>();
        try {
            String sql="select * from NguoiDung inner join NhanVien on NhanVien.MaND=NguoiDung.MaND where NhanVien.Ten like ?";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1,"%"+ten+"%");
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
                timND.add(new NguoiDung(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
             
        } catch (Exception e) {
        }
        return timND;
    }
         public int themNguoiDung(String MaND,String TenDangNhap,String MatKhau,String VaiTro){
             try {
                 String sql="insert into NguoiDung values (?,?,?,?)";
                 PreparedStatement pstm=con.prepareStatement(sql);
                 pstm.setString(1, MaND);
                 pstm.setString(2, TenDangNhap);
                 pstm.setString(3, MatKhau);
                 pstm.setString(4, VaiTro);
                 return pstm.executeUpdate();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return -1;
         }
         public boolean xoaNguoiDung(String MaND){
             try {
                 String sql="delete from NhanVien where MaND=?;delete from NguoiDung where MaND=?";
                 PreparedStatement pstm = con.prepareStatement(sql);
                 pstm.setString(1, MaND);
                 pstm.setString(2, MaND);
                 return pstm.executeUpdate()>0;
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return false;
         }
        public void doiMatKhau(String MaND,String MatKhau){
        try {
            String sql="update NguoiDung set MatKhau=? where MaND=?";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1,MatKhau);
            pstm.setString(2,MaND);
            pstm.executeUpdate();
             
        } catch (Exception e) {
        }
     }
}
