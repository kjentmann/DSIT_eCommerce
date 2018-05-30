/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author madsoft
 */
public class updatecartAction extends Action{

    public updatecartAction(ProductModel productModel) {
    }
    
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session=req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart.update(req.getParameter("productId"), req.getParameter("quantity"));
        
        System.out.println("Cart updated.");
        ViewManager.nextView(req, resp, "/viewcart.do");

    }
    
}
