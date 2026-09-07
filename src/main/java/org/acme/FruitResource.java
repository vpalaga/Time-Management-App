package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    @GET
    public List<Fruit> list() {
        return Fruit.listAll();
    }

    @GET
    @Path("/{id}")
    public Fruit get(Long id) {
        return Fruit.findById(id);
    }

    @POST
    @Transactional
    public Fruit create(Fruit fruit) {
        fruit.persist();
        return fruit;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        Fruit.deleteById(id);
    }
}