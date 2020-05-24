/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Competence;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author danyk
 */
public class CompetenceDAO {
    
    private Session session;

    public Competence addOrUpdateCompetence(Competence competence) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (competence.getIdcomp() != null) {
                session.update(competence);
            } else {
                competence.setIdcomp((Long) session.save(competence));
            }
            session.getTransaction().commit();
            return competence;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Competence> getCompetences() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Competence");
            return query.list();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public Competence deleteCompetence(Competence competence) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(competence);
            session.getTransaction().commit();
            return competence;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
