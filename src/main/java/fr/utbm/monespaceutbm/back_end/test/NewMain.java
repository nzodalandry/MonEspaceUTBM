/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.test;

import fr.utbm.monespaceutbm.back_end.entity.Departement;
import fr.utbm.monespaceutbm.back_end.entity.Filiere;
import fr.utbm.monespaceutbm.back_end.entity.Formation;
import fr.utbm.monespaceutbm.back_end.entity.Utilisateur;
import fr.utbm.monespaceutbm.back_end.service.DepartementService;
import fr.utbm.monespaceutbm.back_end.service.FiliereService;
import fr.utbm.monespaceutbm.back_end.service.FormationService;
import fr.utbm.monespaceutbm.back_end.service.UserService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nzoda
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
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
    */
    
    /* public static void main(String[] args) {
        // TODO code application logic here
        FormationService US = new FormationService();
        List<Formation> listFormation;
//        Utilisateur u = listUser.get(1);
//        u.setNomuser("WANDJI");
//        u.setSexeuser('F');
        Formation f = new Formation(null,"10/05/2020", new Date("20/05/2020"), "Kao", "I", "UTBM");
//        Utilisateur lastInsert = US.addOrUpdateUser(u);
//        System.out.println("Utilisateur " + lastInsert.getIduser() + " Modifié");
        listFormation = US.getFormations();
        listFormation.forEach((formation) -> {
            System.out.println(formation.toString());
        });
    }*/
     
    /*  public static void main(String[] args) {
        // TODO code application logic here
        DepartementService US = new DepartementService();
        List<Departement> listDepartement;
//        Utilisateur u = listUser.get(1);
//        u.setNomuser("WANDJI");
//        u.setSexeuser('F');
        Departement d = new Departement(null,(short)2,"Mecanique");
         Departement lastInsert = US.addOrUpdateDepartement(d);
       System.out.println("Departement " + lastInsert.getIddep()+ " Ajouté ");
        listDepartement = US.getDepartements();
        listDepartement.forEach((departement) -> {
            System.out.println(departement.toString());
        });
    }*/
    
    public static void main(String[] args) {
        // TODO code application logic here
        FiliereService US = new FiliereService();
        List<Filiere> listFiliere;
//        Utilisateur u = listUser.get(1);
//        u.setNomuser("WANDJI");
//        u.setSexeuser('F');
          Departement d = new Departement();
          d.setIddep(new Long (3));
        Filiere f = new Filiere(null,"ER","Energie Renouvellable",d);
         Filiere lastInsert = US.addOrUpdateFiliere(f);
       System.out.println("Filiere " + lastInsert.getIdfil()+ " Ajouté ");
        listFiliere = US.getFilieres();
        listFiliere.forEach((filiere) -> {
            System.out.println(filiere.toString());
        });
    }

}
