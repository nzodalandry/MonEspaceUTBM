/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Competence;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.CompetenceDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public abstract class CompetenceService {
     static CompetenceDAO C = new CompetenceDAO();
    static Competence c;
    static List<Competence> list;

    public static Competence addOrUpdateCompetence(Competence competence) {
        c = C.addOrUpdateCompetence(competence);
        if (c != null) {
            if (competence.getIdcomp() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return c;
    }

    public static List<Competence> getRCompetences() {
        list = C.getCompetences();
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

    public static Competence deleteCompetence(Competence competence) {
        c = C.deleteCompetence(competence);
        if (c != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return c;
    }
    
}
