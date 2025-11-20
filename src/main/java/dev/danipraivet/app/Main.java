package dev.danipraivet.app;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Session newSession = null;
        try {
            newSession = new Configuration().configure().buildSessionFactory().openSession();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        // Consultar Dim_Language
        Query<Dim_Language> qDL = newSession.createQuery("From Dim_Language", Dim_Language.class);
        List<Dim_Language> resultListDL = qDL.list();
        System.out.println("Número de registros en Dim_Language: " + resultListDL.size());
        for (Dim_Language next : resultListDL) {
            System.out.println("Lenguaje: " + next.getLanguage());
        }

        // Insertar nuevo registro
        try {
            Dim_Language new_language = new Dim_Language();
            new_language.setLanguageCode("GER");
            new_language.setLanguage("German");
            new_language.setCreated_dt(LocalDateTime.now());
            new_language.setUpdated_dt(LocalDateTime.now());

            newSession.beginTransaction();
            newSession.save(new_language);
            newSession.getTransaction().commit();

            // Validar inserción
            Query<Dim_Language> qCheck = newSession.createQuery("From Dim_Language where languageCode = 'GER'", Dim_Language.class);
            List<Dim_Language> checkList = qCheck.list();
            System.out.println("Registros insertados con código GER: " + checkList.size());
            for (Dim_Language lang : checkList) {
                System.out.println("Lenguaje insertado: " + lang.getLanguage());
            }

        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } finally {
            if (newSession != null) newSession.close();
        }
    }
}
