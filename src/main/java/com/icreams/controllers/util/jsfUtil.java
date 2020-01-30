/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.controllers.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author desarrollo
 */
public class jsfUtil {
    
    public static void addErrorMessage(String msg){
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
    public static void addMsgSuccess(String msg){
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
    // PERSDONALIZADO
    public static void addMsgSpecified(String path, String msg){
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg);
        FacesContext.getCurrentInstance().addMessage(path, facesMsg);
    }
    
    public static enum PersistAction{
        CREATE,
        DELETE,
        UPDATE,
        FIND
    }
    
}
