/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Projet;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author nzoda
 */
public class ProjetDAO {

    private Session session;

    public Projet addOrUpdateProjet(Projet projet) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (projet.getIdproj() != null) {
                session.update(projet);
            } else {
                projet.setIdproj((Long) session.save(projet));
            }
            session.getTransaction().commit();
            return projet;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Projet> getProjets() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Projet");
            return query.getResultList();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public Projet deleteProjet(Projet projet) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(projet);
            session.getTransaction().commit();
            return projet;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
