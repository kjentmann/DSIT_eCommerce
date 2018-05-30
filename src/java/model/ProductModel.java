/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Category;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author juanluis
 */
public class ProductModel {

    UserTransaction utx;
    EntityManager em;

    public ProductModel(EntityManager em, UserTransaction utx) {
        this.utx = utx;
        this.em = em;
    }
    
    public Product getProductByName(String name){
        Query q = em.createQuery("SELECT p FROM Product p WHERE p.name = :name");
        q.setParameter("name",name);
        List<Product> list= q.getResultList();
        return list.get(0);
    }
    
    public List<Product> retrieveProducts(String category){
         Query q = em.createQuery("SELECT p FROM Product p WHERE p.category = :category");
         q.setParameter("category",new Category(Integer.parseInt(category)));
        return q.getResultList();
    }
}
