/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Departement;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author danyk
 */
public class DepartementDAO {
    
     private Session session;

    public Departement addOrUpdateDepartement(Departement departement) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if(departement.getIddep()!= null)
                session.update(departement);
            else
               departement.setIddep((Long) session.save(departement));
            session.getTransaction().commit();
            return departement;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Departement> getDepartements() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Departement");
            return query.getResultList();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
