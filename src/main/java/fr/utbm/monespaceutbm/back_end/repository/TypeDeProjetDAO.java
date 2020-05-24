/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.TypeDeProjet;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author nzoda
 */
public class TypeDeProjetDAO {

    private Session session;

    public TypeDeProjet addOrUpdateTypeDeProjet(TypeDeProjet typeDeProjet) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (typeDeProjet.getIdtypeproj() != null) {
                session.update(typeDeProjet);
            } else {
                typeDeProjet.setIdtypeproj((Long) session.save(typeDeProjet));
            }
            session.getTransaction().commit();
            return typeDeProjet;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<TypeDeProjet> getTypeDeProjets() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM TypeDeProjet");
            return query.getResultList();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public TypeDeProjet deleteTypeDeProjet(TypeDeProjet typeDeProjet) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(typeDeProjet);
            session.getTransaction().commit();
            return typeDeProjet;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
