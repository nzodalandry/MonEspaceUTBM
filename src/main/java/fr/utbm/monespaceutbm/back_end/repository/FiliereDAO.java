/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Filiere;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author danyk
 */
public class FiliereDAO {
    
     private Session session;

    public Filiere addOrUpdateFiliere(Filiere filiere) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (filiere.getIdfil()!= null) {
                session.update(filiere);
            } else {
                filiere.setIdfil((Long) session.save(filiere));
            }
            session.getTransaction().commit();
            return filiere;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Filiere> getFilieres() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Filiere");
            return query.list();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
