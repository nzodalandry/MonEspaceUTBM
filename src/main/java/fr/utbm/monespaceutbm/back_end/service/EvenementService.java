/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Evenement;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.EvenementDAO;
import java.util.List;

/**
 *
 * @author nzoda
 */
public abstract class EvenementService {
        static EvenementDAO ED = new EvenementDAO();
    static Evenement e;
    static List<Evenement> list;

    public static Evenement addOrUpdateEvenement(Evenement evenement) {
        e = ED.addOrUpdateEvenement(evenement);
        if (e != null) {
            if (evenement.getIdevt() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return e;
    }

    public static List<Evenement> getEvenements() {
        list = ED.getEvenements();
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

    public static Evenement deleteEvenement(Evenement evenement) {
        e = ED.deleteEvenement(evenement);
        if (e != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return e;
    }
}
