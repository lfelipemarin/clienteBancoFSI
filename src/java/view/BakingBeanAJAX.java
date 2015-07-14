/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Customer;
import java.util.List;
import session.CustomerFacadeLocal;
import javax.ejb.EJB;

/**
 *
 * @author felipe
 */
public class BakingBeanAJAX extends BakingBeanBase {

    @EJB
    private CustomerFacadeLocal customerFacade;
    private List<Customer> filteredCustomers;

    public List<Customer> getFilteredCustomers() {
        return filteredCustomers;
    }

    public void setFilteredCustomers(List<Customer> filteredCustomers) {
        this.filteredCustomers = filteredCustomers;
    }

    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BakingBeanAJAX() {
    }

    @Override
    public String showBalance() {
        if (!password.equals("secret")) {
            message = "Constraseña Incorrecta";
        } else {
            customer = customerFacade.findById(customerId);
            if (customer == null) {
                message = "Cliente Desconocido";
            } else {
                message = String.format("Saldo para %s %s es $%.2f", customer.getFirstname(),
                        customer.getLastname(), customer.getBalance());
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> lista = null;
        lista = customers = customerFacade.findAll();
        return lista;
    }

}
