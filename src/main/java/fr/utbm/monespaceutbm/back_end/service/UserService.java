/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.entity.Utilisateur;
import fr.utbm.monespaceutbm.back_end.repository.UserDAO;
import java.util.List;

/**
 *
 * @author nzoda
 */
public abstract class UserService{
    static UserDAO UD = new UserDAO();
    static Utilisateur u;
    static List<Utilisateur> list;
    public static Utilisateur addOrUpdateUser(Utilisateur user) {
        u = UD.addOrUpdateUser(user);
        if(u != null){
            if(user.getIduser() != null)
                MessageError.setSuccess('U');
            else
                MessageError.setSuccess('C');
        }
        else
            MessageError.setErrorBD();
        return u;
    }
    public static List<Utilisateur> getUsers() {
        list = UD.getUsers();
        if(list != null){
            if(list.isEmpty())
                MessageError.setDataNotFound();
            else
                MessageError.setSuccess('R');
        }
        else
            MessageError.setErrorBD();
        return list;
    }
    public static Utilisateur deleteUser(Utilisateur user){
        u = UD.deleteUser(user);
        if(u != null)
            MessageError.setSuccess('D');
        else
            MessageError.setErrorBD();
        return u;
    }
    public static Utilisateur find(Utilisateur user){
        u = UD.find(user);
        return u;
    }
}
