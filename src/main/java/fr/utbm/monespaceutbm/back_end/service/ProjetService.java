/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.entity.Projet;
import fr.utbm.monespaceutbm.back_end.repository.ProjetDAO;
import java.util.List;

/**
 *
 * @author nzoda
 */
public abstract class ProjetService {

    static ProjetDAO PD = new ProjetDAO();

    public static Projet addOrUpdateProjet(Projet projet) {
        Projet p = PD.addOrUpdateProjet(projet);
        if (p != null) {
            if (p.getIdproj() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return p;
    }

    public static List<Projet> getProjets() {
        List<Projet> list = PD.getProjets();
        if (list != null) {
            if (list.isEmpty()) {
                MessageError.setDataNotFound();
            } else {
                MessageError.setSuccess('R');
            }
        } else {
            MessageError.setErrorBD();
        }
        return list;
    }

    public static Projet deleteProjet(Projet projet) {
        Projet p = PD.deleteProjet(projet);
        if (p != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return p;
    }

}
