/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.util.Hashtable;

/**
 *
 * @author nzoda
 */
public abstract class MessageError {

    private static String message = "";

    @SuppressWarnings("UseOfObsoleteCollectionType")
    private static Hashtable listActions() {
        Hashtable h = new Hashtable();
        h.put('C', "Enregistrement");
        h.put('R', "Lecture");
        h.put('U', "Modification");
        h.put('D', "Suppréssion");
        return h;
    }

    public static void setSuccess(char action) {
        message = listActions().get(action) + " éffectué(e) avec succès !";
    }

    public static void setErrorBD() {
        message = "Une erreur est survenue dans la base de données pendant l'opération !";
    }

    public static void setAlreadyExist(String M) {
        message = M + " existe déjà dans la base de données !";
    }

    public static void setErrorAccess() {
        message = "Vous n'avez pas les droits necessaires pour éffectuer cette action !";
    }

    public static void setDataNotFound() {
        message = "Aucune données trouvées pour l'instant !";
    }

    public static String getMessage() {
        return message;
    }

}
