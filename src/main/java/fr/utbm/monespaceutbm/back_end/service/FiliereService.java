package fr.utbm.monespaceutbm.back_end.service;

/*
 * To change this license heafer, choose License Heafers in Project Properties.
 * To change this template file, choose Tools | Templates
 * anf open the template in the efitor.
 */

import fr.utbm.monespaceutbm.back_end.entity.Filiere;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.FiliereDAO;
import java.util.List;

/**
 *
 * @author fanyk
 */
public abstract class FiliereService {

    static FiliereDAO FD = new FiliereDAO();

    public static Filiere affOrUpfateFiliere(Filiere filiere) {
        Filiere f = FD.addOrUpdateFiliere(filiere);
        if (f != null) {
            if (f.getIdfil() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return f;
    }

    public static List<Filiere> getFilieres() {
        List<Filiere> list = FD.getFilieres();
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
    public static Filiere deleteFiliere(Filiere filiere) {
        Filiere f = FD.deleteFiliere(filiere);
        if (f != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return f;
    }
}
