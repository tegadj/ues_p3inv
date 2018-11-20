<%-- 
    Document   : productos
    Created on : Nov 16, 2018, 9:44:39 PM
    Author     : admin
--%>

<%@page import="java.util.Date"%>
<%@page import="BusinessLogic.TransaccionesBL"%>
<%@page import="Entities.detalle"%>
<%@page import="Entities.transaccion"%>
<%@page import="BusinessLogic.ProductosBL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entities.producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="tran" scope="session" class="BusinessLogic.TransaccionesBL"></jsp:useBean>
<!DOCTYPE html>
<%
    //productos = new ProductosBL();
    tran = new TransaccionesBL();
    int id = 0;
    double total = 0D;
    transaccion t = new transaccion();
    ArrayList<producto> prods = tran.getProducts();
    ArrayList<detalle> detalles = new ArrayList();
    if(request.getParameter("id") != null)
    {
        detalles = tran.getDetails(request.getParameter("id"));
        id = Integer.parseInt(request.getParameter("id"));
        t = tran.getById(request.getParameter("id"));
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ferreteria - nueva compra</title>
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
               <li class="nav-item ">
                  <a class="nav-link" href="ventas.jsp">Ventas</a>
                </li>
                  <li class="nav-item active">
                  <a class="nav-link" href="compras.jsp">Compras <span class="sr-only">(current)</span></a>
                </li>
              </ul>
              <span class="navbar-text">
                
              </span>
            </div>
        </nav>
        
        
        <div class="container">
             <form method="post" >
            <div class="row">
             
                <div class="col-sm-12">
                   
                        <div class="registro">
                            <div class="col-sm-12" >
                                <img class="avatar" src="img/logo.png" alt="">

                                <h1>REGISTRO DE COMPAS</h1>

                                <div class="col-sm-6">
                                    <label>Nombre del proveedor</label>
                                    <input type="text" <%=id > 0? "readonly":""%> <%=id == 0? "required":""%> placeholder="Ingrese el nombre del cliente" name="txtNombre" value="<%=id > 0 ?t.getNombre(): ""%>">
                                </div>
                                <div class="col-sm-6">
                                    <label for="username">No Factura o comprobante</label>
                                    <input type="text" <%=id > 0? "readonly":""%> <%=id == 0? "required":""%> placeholder="No de Factura" name="txtFactura" value="<%=id > 0?t.getFactura():""%>">
                                </div>
                            </div>
                        </div>
                  
                </div>
            </div>
            <div class="row" <%=id == 0? "style='display: none'":""%>>
                <div class="col-sm-12">
                   
                    <h1>Detalles</h1>
                    <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Cantidad</th>
                                <th class="text-right">Subtotal</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            for(detalle d: detalles)
                            {
                                total = total + d.getSubtotalCompra();
                                out.println("<tr>");
                                 out.println("<td>" + d.getProducto()+ "</td>");
                                out.println("<td>" + d.getCantidad() + "</td>");
                                out.println("<td class='text-right'>$ " + String.format("%.2f", d.getSubtotalCompra()) + "</td>");
                                out.println("</tr>");
                            }
                            %>
                           
                        </tbody>
                        <tfoot>
                             <tr>
                                 <th colspan="2" class="text-right">Sub Total</th>
                                 <th class="text-right">$ <%=String.format("%.2f",total)%></th>
                            </tr>
                              <tr>
                                 <th colspan="2" class="text-right">IVA</th>
                                 <th class="text-right">$ <%=String.format("%.2f",total * 0.13D)%></th>
                            </tr>
                              <tr>
                                 <th colspan="2" class="text-right">TOTAL</th>
                                 <th class="text-right"><h2>$ <%=String.format("%.2f",total * 1.13D)%></h2></th>
                            </tr>
                        </tfoot>
                    </table>
                            <hr />
                            <a href="compras.jsp" class="btn btn-danger">Regresar</a>
                </div>
            </div>
                              </form>
        </div>
    </body>
</html>
