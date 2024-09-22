<%-- 
    Document   : UserView
    Created on : May 28, 2024, 1:32:26 PM
    Author     : DELL
--%>

<%@page import="dto.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            ArrayList<Account> list = request.getAttribute(name);
            if(list != null){
                %>
                <table>
                 <tr> <th> Id </th> <th> Id </th> <th> Id </th> </tr>
                    <%
                        for(Account acc :list){
                            %>
                 <tr>
                     <td> <%=acc.getId() %> </td>
                     <td> <%=acc.getFullname() %> </td>
                     <td> <%=acc.getEmail() %> </td>

                 </tr>
                    <%
                        }
                    %>
                </table>
                 
        
                <%
            }
        %>
    </body>
</html>
