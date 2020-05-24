/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Langue;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.LangueDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public abstract class LangueService {
    
    static LangueDAO LS = new LangueDAO();
    static Langue ls;
    static List<Langue> list;

    public static Langue addOrUpdateLangue(Langue langue) {
        ls = LS.addOrUpdateLangue(langue);
        if (ls != null) {
            if (langue.getIdlang() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return ls;
    }

    public static List<Langue> getLangues() {
        list = LS.getLangues();
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

    public static Langue deleteLangue(Langue langue) {
        ls = LS.deleteLangue(langue);
        if (ls != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return ls;
    }

}
