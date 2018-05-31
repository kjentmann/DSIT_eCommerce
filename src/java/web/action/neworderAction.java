/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import entity.Product;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author madsoft
 */
public class neworderAction extends Action{

    CategoryModel categoryModel;
    ProductModel productModel;
    

    public neworderAction(CategoryModel categoryModel, ProductModel productModel) {
        this.categoryModel = categoryModel;
        this.productModel=productModel;
    }

  
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session=req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        String category = req.getParameter("category");
        String product = req.getParameter("product");
        try{
        Integer quantity = Math.abs(Integer.parseInt(req.getParameter("num")));
        Product newproduct = productModel.getProductByName(product);
        cart.addItem(newproduct,quantity);
        session.setAttribute("cart", cart);
        System.out.println(quantity + " " + product + " will be added to cart..");

        }
        catch(Exception e){
            System.out.println("Error while parsing int. Try with valid input. Nothing was added.");
        }
        req.setAttribute("productsOfCategory", productModel.retrieveProducts(category));

        ViewManager.nextView(req, resp, "/category.do?categoryid="+category);
    }
}