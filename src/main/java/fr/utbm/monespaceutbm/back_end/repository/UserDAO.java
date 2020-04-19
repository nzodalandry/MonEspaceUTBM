/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Utilisateur;
import fr.utbm.monespaceutbm.back_end.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author nzoda
 */
public class UserDAO {

    private Session session;

    public Integer addUser(Utilisateur user) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Integer insertId = (Integer) session.save(user);
            session.getTransaction().commit();
            return insertId;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
