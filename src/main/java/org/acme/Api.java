package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dataEntities.Hobby;
import org.acme.dataEntities.Period;

import java.util.List;

@Path("api")
public class Api {

    @GET
    @Path("hobbies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hobby> hobbies() {
        return Hobby.listAll();
    }

    @POST
    @Path("hobbies")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Hobby createHobby(Hobby hobby) {
        hobby.persist();
        return hobby;
    }

    @DELETE
    @Path("hobbies/{id}")
    @Transactional
    public Response deleteHobby(Long id) {
        boolean deleted = Hobby.deleteById(id);
        return deleted
                ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("periods")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Period> periods() {
        return Period.listAll();
    }

    @POST
    @Path("start/{hobbyId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response start(Long hobbyId) {
        Hobby hobby = Hobby.findById(hobbyId);
        if (hobby == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Period period = new Period();
        period.hobby = hobby;
        period.persist();
        return Response.ok(period).build();
    }

    @POST
    @Path("end")
    @Transactional
    public void end() {
        List<Period> runningPeriods = Period.list("running", true);
        for (Period period : runningPeriods) {
            period.running = false;
        }
    }
}