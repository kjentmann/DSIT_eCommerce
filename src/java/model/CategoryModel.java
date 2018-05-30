/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author juanluis
 */
public class CategoryModel {

    UserTransaction utx;
    EntityManager em;

    public CategoryModel(EntityManager em, UserTransaction utx) {
        this.utx = utx;
        this.em = em;
    }

    public List<Category> retrieveAll(){
        Query q = em.createQuery("select o from Category as o");
        return q.getResultList();
    }
    

    public String retriveNameById(int id){ //TODO  fix or delete
     Query q = em.createNamedQuery("Category.findById");
     q.setParameter("id", id);
     List<Category> temp = q.getResultList();
     return temp.get(0).getName();
}
  
    
}
