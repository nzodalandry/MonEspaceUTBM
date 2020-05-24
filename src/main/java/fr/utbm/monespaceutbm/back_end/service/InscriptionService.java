/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Inscription;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.InscriptionDAO;
import java.util.List;

/**
 *
 * @author nzoda
 */
public abstract class InscriptionService {

    static InscriptionDAO ID = new InscriptionDAO();

    public static Inscription addOrUpdateInscription(Inscription inscription) {
        Inscription i = ID.addOrUpdateInscription(inscription);
        if (i != null) {
            if (i.getInscriptionPK() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return i;
    }

    public static List<Inscription> getInscriptions() {
        List<Inscription> list = ID.getInscriptions();
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

    public static Inscription deleteInscription(Inscription inscription) {
        Inscription i = ID.deleteInscription(inscription);
        if (i != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return i;
    }
}
