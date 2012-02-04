/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.ws;

import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author lukas
 */
@WebService(serviceName="soap/trips")
public class TripResource {
    
    @EJB
    private TripService tripService;
    
    @WebMethod(operationName="all")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }
    
}
