/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Cv;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.CVDAO;
import java.util.List;

/**
 *
 * @author nzoda
 */
public abstract class CVService {

    static CVDAO CD = new CVDAO();

    public static Cv addOrUpdateCv(Cv cv) {
        Cv c = CD.addOrUpdateCv(cv);
        if (c != null) {
            if (c.getIdcv() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return c;
    }

    public static List<Cv> getCvs() {
        List<Cv> list = CD.getCvs();
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

    public static Cv deleteCv(Cv cv) {
        Cv c = CD.deleteCv(cv);
        if (c != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return c;
    }

}
