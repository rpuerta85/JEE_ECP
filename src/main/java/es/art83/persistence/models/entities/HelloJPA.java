package es.art83.persistence.models.entities;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.security.auth.login.Configuration;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.sessions.factories.SessionFactory;

public class HelloJPA {
    public static void main(String[] args) {
        //Se borrar y se crean las tablas
        Map<String, String> properties = new HashMap<>();
        properties. put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        EntityManager em = Persistence.createEntityManagerFactory("BBDD", properties)
                .createEntityManager();
        
       
     /* EntityManager em = Persistence.createEntityManagerFactory("BBDD")
           .createEntityManager();*/
        
        /*Tema t1 = new Tema("tema1", "cual es ...");
        Tema t2 = new Tema("tema2", "cual es ...");
        Tema t3 = new Tema("tema2", "cual es ...");
        Voto v1 = new Voto("1", 5, "bachiller");
        Voto v2 = new Voto("34", 5, "bachiller");
        Voto v3 = new Voto("1", 5, "bachiller");*/
        //em.getTransaction().begin();
        
       /* Tema t1 = em.find (Tema.class,1);
         System.out.println(t1.getVotos().size());
         List<Voto> lista = t1.getVotos();
        //lista.remove(1);
         lista.add(v2);
         em.merge(t1);
         em.flush();*/
        // System.out.println(t1.getVotos().size());
        
       // t1.getVotos().add(v1);
       // t1.getVotos().add(v2);
        
        
        
        
       // em.persist(t1);
       // em.persist(t2);
       // em.persist(t3);
      // em.flush();
        //t1.setPregunta("pregunta actualizada");
       // em.merge(t1);
       
       
       //em.persist(v1);
       //em.persist(v1);
      //em.persist(v2);
       //em.persist(v3);
      // em.flush();
     //   em.getTransaction().commit();
        
//        User1 u1 = new User1(1, "Sou u1");
//        // Create
//        em.getTransaction().begin();
//        em.persist(u1);
//        em.persist(new User1(2, "Soy dos"));
//        em.persist(new User1(3, "Soy tres"));
//        em.getTransaction().commit();
//        // Read
//        System.out.println(em.find(User1.class, 1));
//        // Update
//        em.getTransaction().begin();
//        em.merge(new User1(2, "dos cambiado con update"));
//        em.getTransaction().commit();
//        // Update2
//        em.getTransaction().begin();
//        u1.setName("uno, cambiado con set");
//        em.getTransaction().commit();
//        // Delete
//        User1 u3 = em.find(User1.class, 3);
//        em.getTransaction().begin();
//        em.remove(u3);
//        em.getTransaction().commit();

    }
}
