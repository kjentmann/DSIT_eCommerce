<%-- 
    Document   : category
    Created on : May 29, 2018, 2:08:54 PM
    Author     : madsoft
--%>

<%@page import="cart.ShoppingCart"%>
<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="entity.Category"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Browse groceries</title>
    </head>
    <body>
        
           <%
       
       String numItems ="no";
       String totPrice="0.0";
       String catName =" ";
       String id="1";
       
       try{
       ShoppingCart cart= (ShoppingCart) session.getAttribute("cart");
       id = (String)request.getParameter("categoryid");
       catName = id;
       totPrice = String.format( "%.2f",cart.getTotal());
       numItems = Integer.toString(cart.getNumberOfItems());
       catName= (String)request.getAttribute("catName");
       
       }catch(Exception ex){
           System.out.println("Exception catched in category init jsp");
       }
    %>
        
        <h1>Products of category <%= catName %> </h1>
        
    <table width="95%" border="3" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
        
        <tr>
            <td>  
                <img src="img/cart.gif"> Your cart has <%=numItems%> items.<br>
                <img src="img/cart.gif"> Total price of <%=totPrice%> £  <br>
                <a href="viewcart.do"> Show shopping cart.</a> <br> 
       
            </td>
        
        </tr>

        <tr> <font size="2" face="Verdana">
        
        <td width="30%" >
            <b>Other products:</b>
            <br />
            <br />
             
            <a href="category.do?categoryid=1"> Bakery</a> 
            <br />
            <a href="category.do?categoryid=2"> Dairy</a> 
            <br />
            <a href="category.do?categoryid=3"> Fruit & Vegs</a> 
           <br />
            <a href="category.do?categoryid=4"> Meats</a> 
       
        </td>
        
       <td> 
            <table width="100%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
             <tr> <font size="2" face="Verdana">
             <td><h3>Product</td><td><h3>Info</td><td><h3>Price</td><td><h3>Quantity</td>
             <%
            List<Product> products = (List<Product>)request.getAttribute("productsOfCategory");

            for(Product product : products){

            %>
            <tr> 

            <td width="14%" valign="center" align="middle">
                    <img src="img/products/<%=product.getName()%>.png"
                    alt="<%=product.getName()%>" >
                    <%=product.getName()%>
            </td>

            <td>
                <h3><%=product.getName()%></h3>
                <%=product.getDescription() %>
            </td>

            <td
                <h2><%=product.getPrice()%> £ </h2>
            </td>

            <td width=' 10'<font size="2" face="Verdana">
                Select desired amount
                
               <%
                   Integer numProduct;
                   try{
                    ShoppingCart cart= (ShoppingCart) session.getAttribute("cart");
                    numProduct=cart.getQuantityInChartOrOne(product.getId());
                   }catch(Exception e){
                       System.out.println("Exception while trying to do some overkill function because Java is fun");
                       numProduct=1;
                   }
                   %>
                   
                <form action="neworder.do" method="post">
                    <input type="" name="num" value="<%=Integer.toString(numProduct)%>">
                <input type="hidden" name="product" value="<%=product.getName()%>">
                <input type="hidden" name="category" value="<%=id%>">
                <input type="submit"n ame="submit" value="add to cart">
                </form>
            </td>

           <% } 
           %>
        
    </table>
       </td>
        </font> </tr>

    </table>
           <br>           

                      <%-- PAYPAL --%>
                <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
                 <input type="hidden" name="cmd" value="_xclick">
                 <input type="hidden" name="business" value="madsoft@student.etsetb.upc.com">
                 <input type="hidden" name="item_name" value="Shopping cart items from  Affable Bean Green Grocery">

                 <input type="hidden" name="currency_code" value="EUR">
                 <input type="hidden" name="amount" value="<%=totPrice%>">
                 <input type="image" src="img/paypal.gif" name="submit" alt="Make payments with PayPal - it's fast, free and secure!"> 
                 <br>
                 <input type="submit"n ame="submit" value="Proceed to checkout">
                </form>
    </body>
</html>