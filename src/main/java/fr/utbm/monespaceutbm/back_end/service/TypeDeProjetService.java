/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.entity.TypeDeProjet;
import fr.utbm.monespaceutbm.back_end.repository.TypeDeProjetDAO;
import java.util.List;

/**
 *
 * @author nzoda
 */
public abstract class TypeDeProjetService {

    static TypeDeProjetDAO TP = new TypeDeProjetDAO();

    public static TypeDeProjet addOrUpdateProjet(TypeDeProjet typeDeProjet) {
        TypeDeProjet t = TP.addOrUpdateTypeDeProjet(typeDeProjet);
        if (t != null) {
            if (t.getIdtypeproj() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return t;
    }

    public static List<TypeDeProjet> getProjets() {
        List<TypeDeProjet> list = TP.getTypeDeProjets();
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

    public static TypeDeProjet deleteProjet(TypeDeProjet typeDeProjet) {
        TypeDeProjet t = TP.deleteTypeDeProjet(typeDeProjet);
        if (t != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return t;
    }

}
