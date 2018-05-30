/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCartItem;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategoryModel;
import web.ViewManager;

/**
 *
 * @author madsoft
 */
public class viewcartAction extends Action {

    public viewcartAction() {
    }
    
    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Show cart action excecuted.");
        ViewManager.nextView(req, resp, "/view/cart.jsp");
    }
}


