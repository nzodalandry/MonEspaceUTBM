/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Formation;
import fr.utbm.monespaceutbm.back_end.repository.FormationDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public abstract class FormationService {

    public static Formation addOrUpdateFormation(Formation formation) {
        return new FormationDAO().addOrUpdateFormation(formation);
    }

    public static List<Formation> getFormations() {
        return new FormationDAO().getFormations();
    }

}
