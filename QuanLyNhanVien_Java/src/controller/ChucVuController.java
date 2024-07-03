/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ChucVu;

/**
 *
 * @author ASUS
 */
public class ChucVuController extends KetNoi{
         public ArrayList<ChucVu> docChucVu(){
        ArrayList<ChucVu> dscv= new ArrayList<>();
        try {
            String sql="select * from ChucVu";
            PreparedStatement pstm=con.prepareStatement(sql);
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
              
                dscv.add(new ChucVu(rs.getString(1),rs.getFloat(2)));
            }
             
        } catch (Exception e) {
        }
        return dscv;
     }
         public int themChucVu(String chucVu,Float heSoLuong){
             try {
                 String sql="insert into ChucVu values(?,?)";
                 PreparedStatement pstm=con.prepareStatement(sql);
                 pstm.setString(1, chucVu);
                 pstm.setFloat(2, heSoLuong);
                return pstm.executeUpdate();
             } catch (Exception e) {
             }
             return -1;
         }
         public int suaChucVu(String chucVu,Float heSoLuong){
             try {
                 String sql="update ChucVu set HeSoLuong=? where ChucVu=?";
                 PreparedStatement pstm=con.prepareStatement(sql);
                 pstm.setFloat(1, heSoLuong);
                 pstm.setString(2, chucVu);
                return pstm.executeUpdate();
             } catch (Exception e) {
             }
             return -1;
         }
         public int xoaChucVu(String chucVu){
             try {
                 String sql="delete ChucVu where ChucVu=?";
                 PreparedStatement pstm=con.prepareStatement(sql);
                 pstm.setString(1, chucVu);
                return pstm.executeUpdate();
             } catch (Exception e) {
             }
             return -1;
         }
}
