/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import dto.Order;
import dto.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class OrderView extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("LISTORDER");
            String [] arr= ["","Pending", "Processing","complete", "cancel"];
            if(list!= null){
                out.print("<script src='mycode.js'></script>");
                
                out.print("<table>");
                out.print("<tr> <th> ID</th><th>ORDERDAER</th><th>CUSTOMER</th> </tr>");
                for(Order d:list){
                    
                out.print("<tr>");
                out.print("<td>"+ d.getId()+ "</td>");
                out.print("<td>"+ d.getOrderdate()+ "</td>");
                out.print("<td>"+ d.getAccid()+ "</td>");
                
                out.print("<td> <a href='DetaolView?id=> </td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("");
                    out.print("<td ccolspan='5'>");
                        out.print("<table>");
                        for(OrderDetail detail : d.getDetail()){
                            out.print(out);
                        }
                       out.print("</table>");

                    out.print("</td>");
                                out.print("</tr>");

                }

                                out.print("</table>");

            }
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
