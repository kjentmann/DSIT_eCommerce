package cart;

import entity.Product;
import java.text.NumberFormat;
import java.util.*;

/**
 *
 * @author 
 */
public class ShoppingCart {
        private Map<Integer,ShoppingCartItem> my_cart;
        
    public ShoppingCart(){
        my_cart = new HashMap<Integer,ShoppingCartItem>();
    }

    public synchronized void addItem(Product product, Integer quantity){
        ShoppingCartItem newitem = new ShoppingCartItem(product);
        newitem.setQuantity(quantity);
        my_cart.put(product.getId(),newitem);
    }


    public synchronized void update(String productId, String quantity){
         if (my_cart.containsKey(Integer.parseInt(productId))){
             my_cart.get(Integer.parseInt(productId)).setQuantity(Integer.parseInt(quantity));
         }
         else{
             System.out.println("Error while updateing shopping cart");
         }
    }


    public synchronized List<ShoppingCartItem> getItems(){
    List<ShoppingCartItem> items = new ArrayList();
        for (ShoppingCartItem item : my_cart.values()){
            items.add(item);
    }
        return items;
    }

    public synchronized int getNumberOfItems(){
        Integer items =0;
        for (ShoppingCartItem item : my_cart.values()){
         items+=item.getQuantity();
        }
        return items;
    }

    public synchronized double getTotal(){
     double total = 0;
        if (!my_cart.isEmpty()){
        for (ShoppingCartItem item : my_cart.values()){
         total+=item.getTotal();
        }
        }
        return total;
    }


    public synchronized void clear(){
        my_cart.clear();
    }
}
