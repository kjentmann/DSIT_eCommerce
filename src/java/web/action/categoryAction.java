/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

/**
 *
 * @author madsf
 */
public class categoryAction extends Action{
    
}



/*

package web.action;

import javax.servlet.http.*;
import model.CategoryModel;
import web.ViewManager;

public class initAction extends Action {

    CategoryModel categoryModel;

    public initAction(CategoryModel categoryModel){
        this.categoryModel = categoryModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("categories", categoryModel.retrieveAll());
        ViewManager.nextView(req, resp, "/view/init.jsp");
        System.out.println("hello");
    }
}

*/