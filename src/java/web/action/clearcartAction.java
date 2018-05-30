/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import entity.Product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import web.ViewManager;

/**
 *
 * @author madsoft
 */
public class clearcartAction extends Action{

    public clearcartAction() {
    }
    
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session=req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart.clear();
        
        System.out.println("Cart cleared");
        ViewManager.nextView(req, resp, "/viewcart.do");
    }
}
