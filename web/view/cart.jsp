<%-- 
    Document   : category
    Created on : May 29, 2018, 2:08:54 PM
    Author     : madsoft
--%>

<%@page import="cart.ShoppingCart"%>
<%@page import="cart.ShoppingCartItem"%>
<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="entity.Category"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Your shopping cart</title>
    </head>
    <body>
 
        <h1>Your shopping cart </h1>
        
        <%
        ShoppingCart cart = null; 
        List<ShoppingCartItem> items = null;
        String totalSum ="0.0";
        String numItems =" "; 
        try{
            session=request.getSession();
            cart = (ShoppingCart) session.getAttribute("cart");
            items =cart.getItems(); //(List<ShoppingCartItem>) session.getAttribute("cart");
            totalSum= String.format( "%.2f",cart.getTotal());
            numItems = Integer.toString(cart.getNumberOfItems());
            }
        catch(Exception ex){
             System.out.println("Error while initializing cart jsp");
         }
        
        if (cart.getNumberOfItems()>0 ){
        %>
        
        
  <img src="img/cart.gif"> Your cart has <%=numItems%> items for the total price of <%=String.format( "%.2f",cart.getTotal()) %> £ <br> <br> 
   <a href="init.do"> Continue shopping</a> <br> <br>
   <a href="clearcart.do"> Empty your cart</a> <br> <br>
  
        
    <table width="95%" border="3" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
    <tr>
        <td><h3>Product</td><td><h3>Information</td> <td><h3>Price</td><td><h3>Quantity</td></h3>
    </tr>

    <tr> <font size="2" face="Verdana">
    <%
    try{
    for(ShoppingCartItem item : items){
    %>

    <tr>
        <td width="14%" valign="center" align="middle">
            <!<a href="category.do?categoryid=<%=item.getProduct().getId()%>">  
            <img src="img/products/<%=item.getProduct().getName()%>.png"
            alt="<%=item.getProduct().getName()%>" >
        </td>

        <td>
            <h3><%=item.getProduct().getName()%></h3>
            <%=item.getProduct().getDescription() %>
        </td>

        <td
            <h2><%=item.getProduct().getPrice()%> £ </h2>
        </td>

        <td width=' 10'<font size="2" face="Verdana">
            
            <form action="updatecart.do" method="post">
            <input type="" name="quantity" value=<%=item.getQuantity() %> >
            <input type="hidden" name="productId" value="<%=item.getProduct().getId()%>">
            <input type="submit" name="submit" value="Update quantityt">
            </form>
            </font>

        </td>
 <% }%>
 
       </font> 
       </tr>
       <tr>
       <td></td><td>TOTAL SUM:</td><td><h3><%=totalSum%> £ </h3></tr>
    </table>
    <br>

   <%-- PAYPAL --%>
   <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
    <input type="hidden" name="cmd" value="_xclick">
    <input type="hidden" name="business" value="mads@student.UPC.com">
    <input type="hidden" name="item_name" value="Shopping cart items from  Affable Bean Green Grocery">
    <input type="hidden" name="currency_code" value="EUR">
    <input type="hidden" name="amount" value="<%=totalSum%>">
    <input type="image" src="img/paypal.gif" name="submit" alt="Make payments with PayPal - it's fast, free and secure!"> 
    <br>
    <input type="submit"n ame="submit" value="Proceed to checkout">
    </form>
    
<%
}
       catch(Exception ex){

%>
        <h1>Sorry, but there was an error while creating your cart</h1>
        
<% }}
else{
%>
<h2>This shopping cart is empty. <a href="/eCommerce_exercise/init.do"> Please go shopping. </a> </h2>
      
<% } %>

    </body>
</html>