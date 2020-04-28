/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Departement;
import fr.utbm.monespaceutbm.back_end.repository.DepartementDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public class DepartementService {
    
     public Departement addOrUpdateDepartement(Departement departement) {
        return new DepartementDAO().addOrUpdateDepartement(departement);
    }

    public List<Departement> getDepartements() {
        return new DepartementDAO().getDepartements();
    }
    
}
