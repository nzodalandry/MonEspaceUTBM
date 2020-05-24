/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Inscription;
import fr.utbm.monespaceutbm.back_end.entity.InscriptionPK;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author nzoda
 */
public class InscriptionDAO {

    private Session session;

    public Inscription addOrUpdateInscription(Inscription inscription) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (inscription.getInscriptionPK() != null) {
                session.update(inscription);
            } else {
                inscription.setInscriptionPK((InscriptionPK) session.save(inscription));
            }
            session.getTransaction().commit();
            return inscription;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Inscription> getInscriptions() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Inscription");
            return query.getResultList();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public Inscription deleteInscription(Inscription inscription) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(inscription);
            session.getTransaction().commit();
            return inscription;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
