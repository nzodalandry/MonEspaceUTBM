/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Evenement;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author nzoda
 */
public class EvenementDAO {

    private Session session;

    public Evenement addOrUpdateEvenement(Evenement evenement) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (evenement.getIdevt() != null) {
                session.update(evenement);
            } else {
                evenement.setIdevt((Long) session.save(evenement));
            }
            session.getTransaction().commit();
            return evenement;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Evenement> getEvenements() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Evenement");
            return query.getResultList();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public Evenement deleteEvenement(Evenement evenement) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(evenement);
            session.getTransaction().commit();
            return evenement;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
