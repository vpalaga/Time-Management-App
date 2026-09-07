package org.acme;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.transaction.Transactional;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dataEntities.Hobby;
import org.acme.dataEntities.Period;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Path("/")
public class Home {
    @Inject
    Template home;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        return home.data("hobbies", Hobby.listAll());
    }

    @POST
    @Path("new_hobby")
    @Transactional
    public Hobby create_hobby(Hobby hobby) {
        hobby.persist();

        // set the creation time
        hobby.created_at = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        return hobby;
    }

    @POST
    @Path("start")
    @Transactional
    public Period start(Period period) {
        period.persist();
        return period;
    }

    @POST
    @Path("end")
    public void end() {
        List<Period> runningPeriods = Period.list("running", true);
        // stop all running periods
        for (Period period:runningPeriods) {
            period.running = false;
        }
    }

}

