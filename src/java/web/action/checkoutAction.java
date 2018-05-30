/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.ViewManager;

/**
 *
 * @author madsoft
 */
public class checkoutAction  extends Action {

    public checkoutAction() {
    }
    
    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Checkout cart action excecuted.");
        ViewManager.nextView(req, resp, "/view/checkout.jsp");
    }
}