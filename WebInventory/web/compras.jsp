<%-- 
    Document   : productos
    Created on : Nov 16, 2018, 9:44:39 PM
    Author     : admin
--%>

<%@page import="Entities.transaccion"%>
<%@page import="BusinessLogic.ProductosBL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tran" scope="session" class="BusinessLogic.TransaccionesBL"></jsp:useBean>
<!DOCTYPE html>
<%
    //productos = new ProductosBL();
    
    ArrayList<transaccion> list = new ArrayList();
    
    
    list = tran.getCompras();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ferreteria - registro de compras</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/master.css">
        <link href="content/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="content/css/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <!--<script src="content/js/bootstrap.min.js" type="text/javascript"></script>-->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.29.0/dist/sweetalert2.all.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="productos.jsp">Productos</a>
                </li>
               <li class="nav-item">
                  <a class="nav-link" href="ventas.jsp">Ventas</a>
                </li>
                  <li class="nav-item active">
                  <a class="nav-link" href="compras.jsp">Compras<span class="sr-only">(current)</span></a>
                </li>
              </ul>
              <span class="navbar-text">
                
              </span>
            </div>
        </nav>
        
        
        <div class="container">
            <div class="row">
            
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <a class="btn btn-danger" href="addCompra.jsp">Nueva compra</a>
                    <h1>Listado de compras</h1>
                    <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Cliente</th>
                                <th>No factura</th>
                                <th>Fecha</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            for(transaccion p: list)
                            {
                                out.println("<tr>");
                                 out.println("<td>" + p.getNombre()+ "</td>");
                                out.println("<td>" + p.getFactura() + "</td>");
                                out.println("<td>" + p.getFecha()+ "</td>");
                                out.println("<td><a class='btn btn-danger' href='viewCompra.jsp?id=" + p.getId()+ "'>Ver Detalle</a></td>");
                                out.println("</tr>");
                            }
                            %>
                           
                        </tbody>
                    </table>
                        
                </div>
            </div>
        </div>
    </body>
</html>
