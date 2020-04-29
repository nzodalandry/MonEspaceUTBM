/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Formation;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author danyk
 */
public class FormationDAO {
    
     private Session session;

    public Formation addOrUpdateFormation(Formation formation) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if(formation.getIdfor()!= null)
                session.update(formation);
            else
                formation.setIdfor((Long) session.save(formation));
            session.getTransaction().commit();
            return formation;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Formation> getFormations() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Formation");
            return query.list();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
    

