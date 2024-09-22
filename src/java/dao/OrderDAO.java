/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Order;
import dto.OrderDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utls.MyLib;

/**
 *
 * @author DELL
 */
public class OrderDAO {

    // ham nay de lay order va order detail theo status
    public ArrayList<Order> getAllOrder(int status) {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();// mo ket noi vs sql sever
            String sql = "select [OrderID],[OrderDate],[Status],[Total],[AccID]\n"
                    + "from [dbo].[Orders]\n"
                    + "where [Status] = ?\n"
                    + "order by [OrderDate] desc";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, status);
            ResultSet rs = pst.executeQuery();
            if(rs!= null){
                while (rs.next()) {                    
                    Order ord = new Order();
                    int orderid = rs.getInt("OrderID");
                    Date d = rs.getDate("OrderDate");
//                   int status = rs.getInt("Status");
                    int total = rs.getInt("Total");
                    int accid = rs.getInt("AccID");
                    ord.setId(orderid);
                    ord.setOrderdate(d);
                    ord.setTotal(total);
                    
                    
                    //lay 
                    String sql2 = "select [DetailID],[ItemID],[OrderID],[Quantity]\n" +
"from [dbo].[OrderDetails]\n" +
"where [OrderID]=?";
                    PreparedStatement pst2 = cn.prepareStatement(sql);
                    pst2.setInt(1, orderid);
                    ResultSet rs2 = pst2.executeQuery();
                    if(rs!=null){
                        int detailid = rs2.getInt("DetailID");
                        int itmeid = rs2.getInt("ItemID");
                        int quantity = rs2.getInt("Quantity");
                        OrderDetail detail = new OrderDetail(detailid, orderid, itmeid, quantity);
                        ord.addOrderDatail(detail);
                        
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
    public int changeOrderStatus(int newstatus){
        int rs =0 ;
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();// mo ket noi vs sql sever
             
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
        return ;
    }
}
