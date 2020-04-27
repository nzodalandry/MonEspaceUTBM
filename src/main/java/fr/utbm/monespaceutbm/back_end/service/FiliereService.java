/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Filiere;
import fr.utbm.monespaceutbm.back_end.repository.FiliereDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public class FiliereService {
    
     public Filiere addOrUpdateFiliere(Filiere filiere) {
        return new FiliereDAO().addOrUpdateFiliere(filiere);
    }
    public List<Filiere> getFilieres() {
        return new FiliereDAO().getFilieres();
    }
    
    
}
