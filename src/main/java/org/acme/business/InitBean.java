package org.acme.business;

import io.quarkus.runtime.StartupEvent;
import org.acme.entities.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    public void init(@Observes StartupEvent ev) {
        System.out.println("hello");
        Vehicle vehicle = new Vehicle("lambo", "huracan");
        em.persist(vehicle);
    }

}
