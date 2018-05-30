package web.action;

import cart.ShoppingCart;
import javax.servlet.http.*;
import model.CategoryModel;
import web.ViewManager;

public class initAction extends Action {

    CategoryModel categoryModel;

    public initAction(CategoryModel categoryModel){
        this.categoryModel = categoryModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        ShoppingCart emptycart = new ShoppingCart();
        HttpSession session = req.getSession();
        session.setAttribute("cart",emptycart);
        req.setAttribute("categories", categoryModel.retrieveAll());
        ViewManager.nextView(req, resp, "/view/init.jsp");
        System.out.println("Inital action excecuted.");
    }
}
