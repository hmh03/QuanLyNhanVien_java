/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.NguoiDung;
import model.NhanVien;

/**
 *
 * @author ASUS
 */
public class NhanVienController extends KetNoi{
    NhanVien nv = new NhanVien();
    //SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    public NhanVien HienThiDuLieu(String MaND) throws SQLException{
       try{ 
          // System.out.println("MaND: " + MaND);
        String sql = "select Ten,NgaySinh,DiaChi,GioiTinh,SDT,Email from NhanVien inner join NguoiDung on NhanVien.MaND=NguoiDung.MaND where NguoiDung.MaND=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, MaND);
        ResultSet rs= pre.executeQuery();
            if(rs.next())
            {
                nv.setTen(rs.getString(1));
                //nv.setNgaySinh(new SimpleDateFormat().parse(rs.getString(2)));
                nv.setNgaySinh(rs.getDate(2));
                nv.setDiaChi(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setSDT(rs.getString(5));
                nv.setEmail(rs.getString(6));
                //System.out.println("ngay sinh: " + rs.getString("NgaySinh"));
            }
            //System.out.println("Ngay SInh khi chuan bi hien thi ra(duoc luu vao trong nv): "+nv.getNgaySinh());
        }
         catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
       return nv;
    }
    public NhanVien HienThiDuLieuUser(String MaND) throws SQLException{
       try{ 
          // System.out.println("MaND: " + MaND);
        String sql = "select Ten,NgaySinh,DiaChi,GioiTinh,STK,SDT,Email,ChucVu,ChamCong from NhanVien inner join NguoiDung on NhanVien.MaND=NguoiDung.MaND where NguoiDung.MaND=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, MaND);
        ResultSet rs= pre.executeQuery();
            if(rs.next())
            {
                nv.setTen(rs.getString(1));
                //nv.setNgaySinh(new SimpleDateFormat().parse(rs.getString(2)));
                nv.setNgaySinh(rs.getDate(2));
                nv.setDiaChi(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setSTK(rs.getString(5));
                nv.setSDT(rs.getString(6));
                nv.setEmail(rs.getString(7));
                nv.setChucVu(rs.getString(8));
                nv.setChamCong(rs.getInt(9));
                //System.out.println("ngay sinh: " + rs.getString("NgaySinh"));
            }
            //System.out.println("Ngay SInh khi chuan bi hien thi ra(duoc luu vao trong nv): "+nv.getNgaySinh());
        }
         catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
       return nv;
    }
    
    public int update(String Ten,Date NgaySinh,String DiaChi,String GioiTinh,String SDT,String Email,String MaND){
        try{
           // System.out.println("ngay sinh khi dua vao update: "+NgaySinh);
            String sql="update NhanVien set Ten=?,NgaySinh=?,DiaChi=?,GioiTinh=?,SDT=?,email=? where MaND=?";
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, Ten);
            pre.setDate(2, new java.sql.Date(NgaySinh.getTime()));
            //pre.setString(2, NgaySinh);
            pre.setString(3, DiaChi);
            pre.setString(4, GioiTinh);
            pre.setString(5, SDT);
            pre.setString(6, Email);
            pre.setString(7,MaND);
            return pre.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public int updateUser(String Ten,Date NgaySinh,String DiaChi,String GioiTinh,String STK,String SDT,String Email,String MaND){
        try{
           // System.out.println("ngay sinh khi dua vao update: "+NgaySinh);
            String sql="update NhanVien set Ten=?,NgaySinh=?,DiaChi=?,GioiTinh=?,STK=?,SDT=?,email=? where MaND=?";
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1, Ten);
            pre.setDate(2, new java.sql.Date(NgaySinh.getTime()));
            //pre.setString(2, NgaySinh);
            pre.setString(3, DiaChi);
            pre.setString(4, GioiTinh);
            pre.setString(5, STK);
            pre.setString(6, SDT);
            pre.setString(7, Email);
            pre.setString(8,MaND);
            return pre.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public ArrayList<NhanVien> docNhanVien(String VaiTro){
        ArrayList<NhanVien> dsnv= new ArrayList<NhanVien>();
        try {
            String sql="select NhanVien.* from NhanVien,NguoiDung where NhanVien.MaND=NguoiDung.MaND and NguoiDung.VaiTro=?";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1,VaiTro);
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
                NhanVien nv= new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setMaND(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setNgaySinh(rs.getDate(4));
                nv.setDiaChi(rs.getString(5));
                nv.setGioiTinh(rs.getString(6));
                nv.setSTK(rs.getString(7));
                nv.setSDT(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setChucVu(rs.getString(10));
                nv.setChamCong(rs.getInt(11));
                dsnv.add(nv);
            }
             
        } catch (Exception e) {
        }
        return dsnv;
    }
     public void chamCongNhanVien(int ChamCong,String MaNV){
        try {
            String sql="update NhanVien set ChamCong=? where MaNV=?";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setInt(1,ChamCong);
            pstm.setString(2,MaNV);
            pstm.executeUpdate();
             
        } catch (Exception e) {
        }
     }
     public void capNhatNhanVien(String ChucVu,String MaNV){
        try {
            String sql="update NhanVien set ChucVu=? where MaNV=?";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1,ChucVu);
            pstm.setString(2,MaNV);
            pstm.executeUpdate();
             
        } catch (Exception e) {
        }
     }
     
        public ArrayList<NhanVien> docNvTheoMaND(String MaND){
        ArrayList<NhanVien> docNV= new ArrayList<NhanVien>();
        try {
            String sql="select * from NhanVien where MaND=?";
            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setString(1,MaND);
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
                NhanVien nvTheoMaND= new NhanVien();
                nvTheoMaND.setMaNV(rs.getString(1));
                nvTheoMaND.setMaND(rs.getString(2));
                nvTheoMaND.setTen(rs.getString(3));
                nvTheoMaND.setNgaySinh(rs.getDate(4));
                nvTheoMaND.setDiaChi(rs.getString(5));
                nvTheoMaND.setGioiTinh(rs.getString(6));
                nvTheoMaND.setSTK(rs.getString(7));
                nvTheoMaND.setSDT(rs.getString(8));
                nvTheoMaND.setEmail(rs.getString(9));
                nvTheoMaND.setChucVu(rs.getString(10));
                nvTheoMaND.setChamCong(rs.getInt(11));
                docNV.add(nvTheoMaND);
            }
             
        } catch (Exception e) {
        }
        return docNV;
    }
        public int themNhanVien(String MaNV,String MaND,String Ten,Date NgaySinh,String DiaChi,String GioiTinh,String STK,String SDT,String Email,String ChucVu){
             try {
                 String sql="insert into NhanVien values(?,?,?,?,?,?,?,?,?,?,'0')";
                 PreparedStatement pstm=con.prepareStatement(sql);
                 pstm.setString(1, MaNV);
                 pstm.setString(2, MaND);
                 pstm.setString(3, Ten);
                 pstm.setDate(4, new java.sql.Date(NgaySinh.getTime()));
                 pstm.setString(5, DiaChi);
                 pstm.setString(6, GioiTinh);
                 pstm.setString(7, STK);
                 pstm.setString(8, SDT);
                 pstm.setString(9, Email);
                 pstm.setString(10, ChucVu);
                 return pstm.executeUpdate();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return -1;
         }
        public void xoaChucVuNhanVien(String chucVu){
             try {
                 String sql="update NhanVien set ChucVu='0' where ChucVu=?";
                 PreparedStatement pstm=con.prepareStatement(sql);
                 pstm.setString(1, chucVu);
                 pstm.executeUpdate();
             } catch (Exception e) {
             }
         }
}
