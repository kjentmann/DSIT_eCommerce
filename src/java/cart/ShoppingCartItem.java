/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */

package cart;

import entity.Product;
import model.ProductModel;
/**
 *
 * @author madsoft 
 */
public class ShoppingCartItem {
       private int quantity;
       private Product product;

   public ShoppingCartItem(Product product){
       this.product=product;
       this.quantity =1;
   }
   
   public Product getProduct(){
       return product;
   }
   
   public int getQuantity(){
       return quantity;
   }
   
   public void setQuantity(int quantity){
       this.quantity=quantity;
   }
   
   public double getTotal(){
       return product.getPrice()*Integer.toUnsignedLong(quantity);
   }
}