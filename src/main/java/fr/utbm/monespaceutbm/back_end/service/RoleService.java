/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.entity.Role;
import fr.utbm.monespaceutbm.back_end.repository.RoleDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public abstract class RoleService {

    static RoleDAO RL = new RoleDAO();
    static Role r;
    static List<Role> list;

    public static Role addOrUpdateRole(Role role) {
        r = RL.addOrUpdateRole(role);
        if (r != null) {
            if (role.getIdrole() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return r;
    }

    public static List<Role> getRoles() {
        list = RL.getRoles();
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

    public static Role deleteRole(Role role) {
        r = RL.deleteRole(role);
        if (r != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return r;
    }

}
