package org.acme.hibernate.reactive;

import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("city")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CityMutinyResource {

    @Inject
    Uni<Mutiny.Session> mutinySession;

    @GET
    public Uni<City[]> get() {
        return mutinySession.flatMap(session -> session.createNamedQuery("City.findAll", City.class).getResultList())
                .map(cities -> cities.toArray(new City[cities.size()]));
    }

}
