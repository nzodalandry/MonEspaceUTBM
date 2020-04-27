/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Utilisateur;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author nzoda
 */
public class UserDAO {

    private Session session;

    public Utilisateur addOrUpdateUser(Utilisateur user) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (user.getIduser() != null) {
                session.update(user);
            } else {
                user.setIduser((Long) session.save(user));
            }
            session.getTransaction().commit();
            return user;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Utilisateur> getUsers() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Utilisateur");
            return query.list();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
