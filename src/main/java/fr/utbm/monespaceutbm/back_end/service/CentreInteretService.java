/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.CentreInteret;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.CentreInteretDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public abstract class CentreInteretService {
     static CentreInteretDAO CI = new CentreInteretDAO();
    static CentreInteret c;
    static List<CentreInteret> list;

    public static CentreInteret addOrUpdateCentreInteret(CentreInteret centreinteret) {
        c = CI.addOrUpdateCentreInteret(centreinteret);
        if (c != null) {
            if (centreinteret.getIdcent() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return c;
    }

    public static List<CentreInteret> getCentreInterets() {
        list = CI.getCentreInterets();
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

    public static CentreInteret deleteCentreInteret(CentreInteret centreinteret) {
        c = CI.deleteCentreInteret(centreinteret);
        if (c != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return c;
    }
    
}
