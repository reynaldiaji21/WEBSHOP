/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indocyber.service;

import com.indocyber.model.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class ProductService {

    
//    EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
//    public void saveData(Product product){
//    em= emf.createEntityManager();
//    em.getTransaction().begin();
//    em.persist(product);
//    em.getTransaction().commit();
//    em.close();

//    }
    public List<Product>  findAll(){
        List<Product> product=em.createNamedQuery("Product.findAll").getResultList();
        return product;
    }
    public Product findById(Integer productId){
    return em.find(Product.class, productId);
    }
}
