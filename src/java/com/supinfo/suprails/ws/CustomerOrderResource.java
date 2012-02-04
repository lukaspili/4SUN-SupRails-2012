/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.ws;

import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;
import javax.ejb.EJB;
import javax.jws.WebService;

/**
 *
 * @author lukas
 */
@WebService(serviceName="soap/customerorders")
public class CustomerOrderResource {
    
    @EJB
    private CustomerOrderService customerOrderService;
    
    @EJB
    private TripService tripService;
    
    public boolean create(String firstname, String lastname,
            String email, Long tripId) {
        
        CustomerOrder customerOrder = new CustomerOrder();
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setEmail(email);
        customerOrder.setCustomer(customer);
        
        Trip trip = tripService.findTripById(tripId);
        if(null == trip) {
            return false;
        }
        
        customerOrder.setTrip(trip);
        
        customerOrderService.processCustomer(customerOrder);
        
        return true;
    }
    
}
