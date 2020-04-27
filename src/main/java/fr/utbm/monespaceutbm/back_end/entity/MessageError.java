/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

/**
 *
 * @author nzoda
 */
public class MessageError {

    private Integer code;
    private String status;
    private String message;
    public MessageError(Integer code, String status, String messsage) {
        this.code = code;
        this.status = status;
    }

    public static MessageError getSuccess(String message) {
        return new MessageError(1, "Success", message);
    }

    public static MessageError getErrorBD(String message) {
        return new MessageError(2, "Error", message);
    }

    public static MessageError getErrorExists(String message) {
        return new MessageError(3, "Already exists", message);
    }

    public static MessageError getErrorAccess(String message) {
        return new MessageError(4, "Not privileges", message);
    }

}
