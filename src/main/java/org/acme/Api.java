package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.dataEntities.Hobby;

import java.util.List;

@Path("api")
public class Api {

    @Path("hobbies")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hobby> hobbies() {
        return Hobby.listAll();
    }
}
