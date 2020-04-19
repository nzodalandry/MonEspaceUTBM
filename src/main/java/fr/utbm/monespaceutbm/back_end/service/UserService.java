/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Utilisateur;
import fr.utbm.monespaceutbm.back_end.repository.UserDAO;
import java.util.List;

/**
 *
 * @author nzoda
 */
public class UserService {
    
    public Utilisateur addOrUpdateUser(Utilisateur user) {
        return new UserDAO().addOrUpdateUser(user);
    }
    public List<Utilisateur> getUsers() {
        return new UserDAO().getUsers();
    }
    
}
