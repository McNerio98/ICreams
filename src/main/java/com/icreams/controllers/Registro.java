/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.controllers;

import com.icreams.controllers.util.jsfUtil;
import com.icreams.controllers.util.jsfUtil.PersistAction;
import com.icreams.entity.Usuario;
import com.icreams.facade.UsuariosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ZEUS
 */
@Named("registro")
@SessionScoped
public class Registro implements Serializable {

    @EJB
    private UsuariosFacade ejbUsuario;
    private Usuario user;
    private String repeatPass;

    private UsuariosFacade getFacade() {
        return this.ejbUsuario;
    }

    @PostConstruct
    public void init() {
        this.user = new Usuario();

    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getRepeatPass() {
        return repeatPass;
    }

    public void setRepeatPass(String repeatPass) {
        this.repeatPass = repeatPass;
    }
    
    

    public void crear() {
        if(this.repeatPass.equals(this.user.getClave())){
            persistir(PersistAction.CREATE);
        }else{
            jsfUtil.addMsgSpecified("formRegistro:msgSystem", "Las claves deben ser iguales");
        }
    }

    public String cancelar() {
        return "/pages/login.xhtml";
    }

    private void persistir(PersistAction action) {

        try {
            if (action == PersistAction.CREATE) {
                getFacade().edit(user);
            }

        } catch (Exception e) {        
            jsfUtil.addMsgSpecified("formRegistro:msgSystem", "Error al registrar los datos");
        }
    }

}
