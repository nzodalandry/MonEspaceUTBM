/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Formation;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.FormationDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public abstract class FormationService {

    static FormationDAO FD = new FormationDAO();
    static Formation f;
    static List<Formation> list;

    public static Formation addOrUpdateFormation(Formation formation) {
        f = FD.addOrUpdateFormation(formation);
        if (f != null) {
            if (formation.getIdfor() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return f;
    }

    public static List<Formation> getFormations() {
        list = FD.getFormations();
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

    public static Formation deleteFormation(Formation formation) {
        f = FD.deleteFormation(formation);
        if (f != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return f;
    }

}
