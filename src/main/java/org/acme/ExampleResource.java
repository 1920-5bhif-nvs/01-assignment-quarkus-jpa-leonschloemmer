package org.acme;

import org.acme.entities.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/vehicles")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ExampleResource {

    @Inject
    EntityManager em;

    @GET
    @Transactional
    public List<Vehicle> hello() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll", Vehicle.class);
        List<Vehicle> vehicles = query.getResultList();
        return vehicles;
    }

    @POST
    @Transactional
    public Response createVehicle(Vehicle vehicle) {
        em.persist(vehicle);
        return Response.ok().build();
    }
}