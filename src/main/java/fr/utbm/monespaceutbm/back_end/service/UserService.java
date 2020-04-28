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
    public static Utilisateur addOrUpdateUser(Utilisateur user) {
        Utilisateur u = UD.addOrUpdateUser(user);
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
        List<Utilisateur> list = UD.getUsers();
        if(list != null){
            if(!list.isEmpty())
                MessageError.setSuccess('R');
            else
                MessageError.setDataNotFound();
        }
        else
            MessageError.setErrorBD();
        return list;
    }
    public static Utilisateur deleteUser(Utilisateur user){
         Utilisateur u = UD.deleteUser(user);
        if(u != null)
            MessageError.setSuccess('D');
        else
            MessageError.setErrorBD();
        return u;
    }
    
}
