/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Departement;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.DepartementDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public abstract class DepartementService {

    static DepartementDAO DD = new DepartementDAO();

    public static Departement addOrUpdateDepartement(Departement departement) {
        Departement d = DD.addOrUpdateDepartement(departement);
        if (d != null) {
            if (d.getIddep() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return d;
    }

    public static List<Departement> getDepartements() {
        List<Departement> list = DD.getDepartements();
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

    public static Departement deleteDepartement(Departement departement) {
        Departement d = DD.deleteDepartement(departement);
        if (d != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return d;
    }

}
