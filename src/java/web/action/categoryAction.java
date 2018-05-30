/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCartItem;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;
/**
 *
 * @author madsoft
 */
public  class categoryAction extends Action {

    CategoryModel categoryModel;
    ProductModel productModel;
    

    public categoryAction(CategoryModel categoryModel, ProductModel productModel){
        this.categoryModel = categoryModel;
        this.productModel=productModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {
       String category = req.getParameter("categoryid");
       req.setAttribute("catName",categoryModel.retriveNameById(Integer.parseInt(category)));
       req.setAttribute("productsOfCategory", productModel.retrieveProducts(category));

       System.out.println("Category selected. Redirecting..");
       ViewManager.nextView(req, resp, "/view/category.jsp");
    }
}