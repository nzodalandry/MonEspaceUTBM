/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.test;

import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.entity.Utilisateur;
import fr.utbm.monespaceutbm.back_end.service.UserService;
import java.util.List;

/**
 *
 * @author nzoda
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Utilisateur> listUser;
        Utilisateur u = UserService.getUsers().get(2);
        UserService.deleteUser(u);
        System.out.println(MessageError.getMessage());
//        u.setNomuser("WANDJI");
//        u.setSexeuser('F');
//        Utilisateur u = new Utilisateur("WANDJI", 'F', "nzodalandry@gmail.com", "2 rue ernest duvillard", "90 000", "Belfort", "France", "admin", "lnzodaou");
//        Utilisateur lastInsert = US.addOrUpdateUser(u);
//        System.out.println("Utilisateur " + lastInsert.getIduser() + " Modifié");
        listUser = UserService.getUsers();
        listUser.forEach((user) -> {
            System.out.println(user.toString());
        });
    }

}
