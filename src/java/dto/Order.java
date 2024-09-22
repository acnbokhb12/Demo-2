/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Order {
    private int id;
    private Date orderdate;
    private int status;
    private double  total;
    private int accid;
    private ArrayList<OrderDetail> detail;

    public Order(int id, Date orderdate, int status, double total, int accid, ArrayList<OrderDetail> detail) {
        this.id = id;
        this.orderdate = orderdate;
        this.status = status;
        this.total = total;
        this.accid = accid;
        this.detail = detail;
    }

    public Order() {
        orderdate = new Date(System.currentTimeMillis());
        detail = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public ArrayList<OrderDetail> getDetail() {
        return detail;
    }

    public void setDetail(ArrayList<OrderDetail> detail) {
        this.detail = detail;
    }

  public boolean addOrderDatail(OrderDetail dt){
      return detail.add(dt);
  }
    
}   
