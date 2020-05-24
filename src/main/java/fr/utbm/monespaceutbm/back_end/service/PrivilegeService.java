/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.entity.Privileges;
import fr.utbm.monespaceutbm.back_end.repository.PrivilegeDAO;
import java.util.List;

/**
 *
 * @author nzoda
 */
public abstract class PrivilegeService {

    static PrivilegeDAO PD = new PrivilegeDAO();
    static Privileges p;
    static List<Privileges> list;

    public static Privileges addOrUpdateFormation(Privileges privilege) {
        p = PD.addOrUpdatePrivilege(privilege);
        if (p != null) {
            if (privilege.getPrivilegesPK() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return p;
    }

    public static List<Privileges> getPrivileges() {
        list = PD.getPrivileges();
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

    public static Privileges deletePriviege(Privileges privilege) {
        p = PD.deletePrivilege(privilege);
        if (p != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return p;
    }
}
