package org.acme;

import org.acme.entities.Vehicle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @GET
    public Vehicle hello() {
        return new Vehicle("Lamborghini", "Huracan");
    }
}