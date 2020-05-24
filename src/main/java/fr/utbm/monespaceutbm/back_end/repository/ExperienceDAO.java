/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Experience;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author danyk
 */
public class ExperienceDAO {
      private Session session;

    public Experience addOrUpdateExperience(Experience experience) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (experience.getIdexp() != null) {
                session.update(experience);
            } else {
                experience.setIdexp((Long) session.save(experience));
            }
            session.getTransaction().commit();
            return experience;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Experience> getExperiences() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Experience");
            return query.list();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public Experience deleteExperience(Experience experience) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(experience);
            session.getTransaction().commit();
            return experience;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
