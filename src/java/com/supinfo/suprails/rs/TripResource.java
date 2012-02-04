package com.supinfo.suprails.rs;

import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author lukas
 */
@Stateless
@Path("/trips")
@Produces(MediaType.APPLICATION_JSON)
public class TripResource {
    
    @EJB
    private TripService tripService;
    
    @GET
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }
}
