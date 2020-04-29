/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.test;

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
        List<Utilisateur> listUser = UserService.getUsers();
        listUser.forEach((departement) -> {
            System.out.println(departement.toString());
        });
        Utilisateur u = listUser.get(1);
//        u.setNomuser("WANDJI");
//        u.setSexeuser('F');
        Utilisateur us = UserService.find(u);
        System.out.println("Departement " + us.getNomuser() + " Trouvé ");

    }

}
