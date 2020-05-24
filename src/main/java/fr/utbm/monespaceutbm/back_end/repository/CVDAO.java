/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Cv;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author nzoda
 */
public class CVDAO {

    private Session session;

    public Cv addOrUpdateCv(Cv cv) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (cv.getIdcv() != null) {
                session.update(cv);
            } else {
                cv.setIdcv((Long) session.save(cv));
            }
            session.getTransaction().commit();
            return cv;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Cv> getCvs() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Cv");
            return query.getResultList();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public Cv deleteCv(Cv cv) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cv);
            session.getTransaction().commit();
            return cv;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
