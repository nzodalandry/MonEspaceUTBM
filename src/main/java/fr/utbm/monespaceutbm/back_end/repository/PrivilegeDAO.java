/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.repository;

import fr.utbm.monespaceutbm.back_end.entity.Privileges;
import fr.utbm.monespaceutbm.back_end.entity.PrivilegesPK;
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
public class PrivilegeDAO {
     private Session session;

    public Privileges addOrUpdatePrivilege(Privileges privilege) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if (privilege.getPrivilegesPK() != null) {
                session.update(privilege);
            } else {
                privilege.setPrivilegesPK((PrivilegesPK) session.save(privilege));
            }
            session.getTransaction().commit();
            return privilege;
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Utilisateur> getPrivileges() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query;
            query = session.createQuery("FROM Privileges");
            return query.list();
        } catch (HibernateException ex) {
            return null;
        } finally {
            session.close();
        }
    }
}
