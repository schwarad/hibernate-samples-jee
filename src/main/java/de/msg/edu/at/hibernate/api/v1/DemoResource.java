package de.msg.edu.at.hibernate.api.v1;


import de.msg.edu.at.hibernate.business.services.DemoBusiness;
import de.msg.edu.at.hibernate.persistence.entities.DemoEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Represents a REST webservice in the demo application.
 */
@Path("/demos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DemoResource {

    @EJB
    private DemoBusiness demoBusiness;


    @POST
    public Response save(DemoEntity demoEntity) {
       return Response.ok(demoBusiness.save(demoEntity)).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String uuid) {
        DemoEntity demoEntity = demoBusiness.get(UUID.fromString(uuid));
        if (demoEntity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(demoEntity).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String uuid) {
        demoBusiness.delete(UUID.fromString(uuid));
        return Response.noContent().build();
    }
}
