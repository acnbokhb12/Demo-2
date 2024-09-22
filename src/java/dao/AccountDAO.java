/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utls.MyLib;

/**
 *
 * @author DELL
 */
public class AccountDAO {

    ArrayList<Account> list = new ArrayList<>();

    // ham nay de lay tat ca cac dong trong bang account tra ve ARRAYLIST<Account>
    public ArrayList<Account> getAccount() {
        //1.  Tao connection
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();// mo ket noi vs sql sever
            if (cn != null) {
                //2 viet sql va excute
                String sql = "select [AccId],[Email],[FullName],[Password]\n"
                        + "from [dbo].[Accounts]";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) { // data trong bang rs
                    while (rs.next()) {
                        int id = rs.getInt("AccId");
                        String email = rs.getString("Email");
                        String fullname = rs.getString("FullName");
                        String password = rs.getString("Password");
                        Account a = new Account(id, email, fullname, password);
                        list.add(a);
                    }
                    
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    // function to delete 1 table 1 account
    // input : accid need delete
    // output : 1/0
    public int removeAccount(int id) {
        int rs = 0;
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();// mo ket noi vs sql sever
            if (cn != null) {
                //2 viet sql va excute
                String sql = "delete from [dbo].[Accounts]\n"
                        + "where [AccId] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                rs = pst.executeUpdate();

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return rs;
    }

    // func to check email is  trung vs user ko ?
    // input dau vao la email can tim
    // return object
    public Account getUser(String email) {
        Account acc = null;

        Connection cn = null;
        try {
            cn = MyLib.makeConnection();// mo ket noi vs sql sever
            if (cn != null) {
                //2 viet sql va excute
                String sql = "select [AccId],[Email],[FullName],[Password]\n"
                        + "from [dbo].[Accounts]\n"
                        + "where [Email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                
                if(rs!= null && rs.next()){
                    int id= rs.getInt("AccId");
                    String fullname = rs.getString("FullName");
                    String password = rs.getString("Password");
                    acc = new Account(id, email, fullname, password);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return acc;
    }
    
    
    // ham nay de insert 1 
    //input 
    
    public int insertUser (String email,String fullname, String password){
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();// mo ket noi vs sql sever
            if (cn != null) {
                //2 viet sql va excute
                String sql = "insert [dbo].[Accounts] (Email,FullName,Password) values(?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, fullname);
                pst.setString(3, password);
                
                rs = pst.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        return rs;
    }
}
