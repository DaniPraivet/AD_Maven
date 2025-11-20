package dev.danipraivet.new_app;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class Main {
    static void main() {
        Session newSession = null;
        try {
            newSession = new Configuration().configure().buildSessionFactory().openSession();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Query<Autores> query = newSession.createQuery("from Autores", Autores.class);
        List<Autores> autores = query.list();
        for (Autores autor : autores) {
            System.out.println("Autor: " + autor.toString());
        }

        try {
            Autores nuevoAutor = new Autores();
            nuevoAutor.setNombre("Roberto");
            nuevoAutor.setApellido("Augusto");
            nuevoAutor.setId(0);
            nuevoAutor.setNacionalidad("Español");
            newSession.beginTransaction();
            newSession.save(nuevoAutor);
            newSession.getTransaction().commit();

            Query<Autores> qCheck = newSession.createQuery("From Autores where Id = 0",  Autores.class);
            List<Autores> autoresCheck = qCheck.list();
            for (Autores autor : autoresCheck) {
                System.out.println("Autor: " + autor.toString());
            }
        }  catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            if (newSession != null) {
                newSession.close();
            }
        }
    }
}
