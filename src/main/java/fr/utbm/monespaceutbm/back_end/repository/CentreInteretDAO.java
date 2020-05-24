/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.CentreInteret;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author nzoda
 */
public class CentreInteretDAO {

    private Session session;

    public CentreInteret addOrUpdateCentreInteret(CentreInteret centreinteret) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (centreinteret.getIdcent() != null) {
                session.update(centreinteret);
            } else {
                centreinteret.setIdcent((Long) session.save(centreinteret));
            }
            session.getTransaction().commit();
            return centreinteret;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<CentreInteret> getCentreInterets() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM CentreInteret");
            return query.list();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public CentreInteret deleteCentreInteret(CentreInteret centreinteret) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(centreinteret);
            session.getTransaction().commit();
            return centreinteret;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
    }

