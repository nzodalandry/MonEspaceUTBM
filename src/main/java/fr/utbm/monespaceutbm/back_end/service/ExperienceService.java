/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.service;

import fr.utbm.monespaceutbm.back_end.entity.Experience;
import fr.utbm.monespaceutbm.back_end.entity.MessageError;
import fr.utbm.monespaceutbm.back_end.repository.ExperienceDAO;
import java.util.List;

/**
 *
 * @author danyk
 */
public abstract class ExperienceService {
    static ExperienceDAO RL = new ExperienceDAO();
    static Experience r;
    static List<Experience> list;

    public static Experience addOrUpdateExperience(Experience experience) {
        r = RL.addOrUpdateExperience(experience);
        if (r != null) {
            if (experience.getIdexp() != null) {
                MessageError.setSuccess('U');
            } else {
                MessageError.setSuccess('C');
            }
        } else {
            MessageError.setErrorBD();
        }
        return r;
    }

    public static List<Experience> getExperiences() {
        list = RL.getExperiences();
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

    public static Experience deleteExperience(Experience experience) {
        r = RL.deleteExperience(experience);
        if (r != null) {
            MessageError.setSuccess('D');
        } else {
            MessageError.setErrorBD();
        }
        return r;
    }

}
