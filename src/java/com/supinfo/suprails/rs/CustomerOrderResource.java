package com.supinfo.suprails.rs;

import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author lukas
 */
@Stateless
@Path("/customerorders")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerOrderResource {
    
    @EJB
    private CustomerOrderService customerOrderService;
    
    @EJB
    private TripService tripService;
    
    @POST
    @Path("/{firstname}/{lastname}/{email}/{tripId}")
    public Response create(@PathParam("firstname") String firstname,
                       @PathParam("lastname") String lastname,
                       @PathParam("email") String email,
                       @PathParam("tripId") Long tripId) {
        
        CustomerOrder customerOrder = new CustomerOrder();
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setEmail(email);
        customerOrder.setCustomer(customer);
        
        Trip trip = tripService.findTripById(tripId);
        if(null == trip) {
            return Response.status(404).build();
        }
        
        customerOrder.setTrip(trip);
        
        customerOrderService.processCustomer(customerOrder);
        
        return Response.ok().build();
    }
    
}
