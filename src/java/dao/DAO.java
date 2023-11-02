/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO extends DBContext{

    
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Product> getAllPriceProduct(){
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where price <150";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Product> getProductByCID(String cid){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where cateID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Product getProductByID(String id){
        
        String sql = "select * from product where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Product> getProductByName(String txtSearch){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where [name] like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,"%"+txtSearch+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Account login(String user, String pass){
        String sql = "select * from Account where [user] = ? and pass = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,user);
            st.setString(2,pass);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4), 
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    public Account checkAccount(String user){
        String sql = "select * from Account where [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,user);           
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4), 
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    public void signup(String user,String pass){
        String sql = "insert into account values (?,?,0,0)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,user); 
            st.setString(2, pass);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<Product> getProductBySellID(int id){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where sell_ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public void deleteProduct(String pid){
        String sql = "delete from product where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,pid);           
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void insertProduct(String name,String image,String price,String title,String description,
            String category, int sid){
        String sql = "INSERT [dbo].[product] ([name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (?,?,?,?,?,?,?) ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,name);  
            st.setString(2 ,image);
            st.setString(3, price);
            st.setString(4,title);
            st.setString(5,description);
            st.setString(6,category); 
            st.setInt(7, sid);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void editProduct(String name,String image,String price,String title,String description,
            String category, String pid){
        String sql = "update product set [name]=?,[image]=?,[price]=?,[title]=?,[description]=?,cateID=? where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,name);  
            st.setString(2 ,image);
            st.setString(3, price);
            st.setString(4,title);
            st.setString(5,description);
            st.setString(6,category); 
            st.setString(7, pid);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    
}



