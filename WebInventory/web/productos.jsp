<%-- 
    Document   : productos
    Created on : Nov 16, 2018, 9:44:39 PM
    Author     : admin
--%>

<%@page import="BusinessLogic.ProductosBL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="productos" scope="session" class="BusinessLogic.ProductosBL"></jsp:useBean>
<!DOCTYPE html>
<%
    //productos = new ProductosBL();
    
    ArrayList<producto> list = new ArrayList();
   
    if(request != null)
        if(request.getParameter("add") != null)
        {
            productos.add(new producto(0,
                    request.getParameter("txtNombre"),
                    Double.parseDouble(request.getParameter("txtPrecioV")),
                    Double.parseDouble(request.getParameter("txtPrecioC")),
                    Integer.parseInt(request.getParameter("txtExistencia"))
            ));
        }
    
    list = productos.get();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ferreteria - registro de productos</title>
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
                <li class="nav-item active">
                  <a class="nav-link" href="productos.jsp">Productos<span class="sr-only">(current)</span></a>
                </li>
               <li class="nav-item">
                  <a class="nav-link" href="ventas.jsp">Ventas</a>
                </li>
                  <li class="nav-item">
                  <a class="nav-link" href="compras.jsp">Compras</a>
                </li>
              </ul>
              <span class="navbar-text">
                
              </span>
            </div>
        </nav>
        
        
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    &nbsp;
                </div>
                <div class="col-sm-4 col-md-offset-4">
                    <form method="post" >
                        <div class="registro">
                            <div class="col-sm-12" >
                                <img class="avatar" src="img/logo.png" alt="">

                                <h1>REGISTRO DE PRODUCTOS</h1>

                                <!--USERNAME-->
                                <label for="username">Nombre del producto</label>
                                <input type="text" placeholder="Ingrese el nombre del producto" name="txtNombre">

                                <!--PASSWORD-->
                                <label for="precioventa">Precio de venta</label>
                                <input type="text" placeholder="Ingreso el precio de venta" name="txtPrecioV">

                                <label for="preciocompra">Precio de compra</label>
                                <input type="text" placeholder="Ingrese el precio de compra" name="txtPrecioC">

                                <label for="existencia">Existencia</label>
                                <input type="text" placeholder="Ingrese la cantidad de existencia" name="txtExistencia">

                                <input type="submit" name="add" value="REGISTRAR" onclick="swal('success', 'ok', 'success')">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Producto</th>
                                <th>Precio unitario</th>
                                <th>Existencia</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            for(producto p: list)
                            {
                                out.println("<tr>");
                                 out.println("<td>" + p.getCodigoP()+ "</td>");
                                out.println("<td>" + p.getNombreP() + "</td>");
                                out.println("<td>" + p.getPrecioV()+ "</td>");
                                out.println("<td>" + p.getExistencia()+ "</td>");
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
