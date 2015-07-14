/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author felipe
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "ClienteBancoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public Customer findById(String id) {
        try {
            Query q = em.createNamedQuery("Customer.findById");  //se crea la consulta EQL
            q.setParameter("id", id);   //Se pasa el parametro
            return (Customer) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en :" + e);
            return null;
        }
    }

}
