/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Langue;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author danyk
 */
public class LangueDAO {
      private Session session;

    public Langue addOrUpdateLangue(Langue langue) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (langue.getIdlang() != null) {
                session.update(langue);
            } else {
                langue.setIdlang((Long) session.save(langue));
            }
            session.getTransaction().commit();
            return langue;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Langue> getLangues() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Langue");
            return query.list();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public Langue deleteLangue(Langue langue) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(langue);
            session.getTransaction().commit();
            return langue;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
