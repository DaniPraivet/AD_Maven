package dev.danipraivet;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main() {
        System.out.println("Hello and welcome!");
        Session newSession = null;
        try {
            newSession = new Configuration().configure().buildSessionFactory().openSession();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        // Query city
        Query q = newSession.createQuery("From city where name = 'Kabul'", city.class);
        List<city> resultList = q.list();
        System.out.println("num of cities: " + resultList.size());
        for (city next : resultList) {
            System.out.println("next cities: " + next.getName());
        }

        // Query dim_language
        Query qDL = newSession.createQuery("From Dim_Language", Dim_Language.class);
        List<Dim_Language> resultListDL = qDL.list();
        System.out.println("num of cities: " + resultListDL.size());
        for (Dim_Language next : resultListDL) {
            System.out.println("next cities: " + next.getLanguage());
        }
        // Inserta registro en la tabla dim_language
        try {
            Dim_Language new_language = new Dim_Language();
            new_language.setLanguageCode("ITA");
            new_language.setLanguage("Italian");
            new_language.setCreated_dt(LocalDateTime.now());
            new_language.setUpdated_dt(LocalDateTime.now());

            newSession.beginTransaction();
            newSession.save(new_language);
            newSession.getTransaction().commit();

        } catch (Exception ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }

    }
}
