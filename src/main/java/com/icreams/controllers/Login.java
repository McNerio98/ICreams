/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.controllers;

import com.icreams.controllers.util.jsfUtil;
import com.icreams.entity.Usuario;
import com.icreams.facade.UsuariosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author desarrollo
 */
@Named("login")
@SessionScoped
public class Login implements Serializable{
    @EJB
    private UsuariosFacade ejbUsuario;
    private String txtUser;
    private String txtClave;
    private Usuario user;
    private UsuariosFacade getFacade(){
        return this.ejbUsuario;
    }
    
    @PostConstruct
    public void init(){
        
    }
    
    public String validar(){
        this.user = getFacade().find(txtUser);
        if(user==null){
            jsfUtil.addMsgSpecified("formLogin:msgNoti", "Usuario o clave erroreos");
        }else{
            if(this.user.getClave().equals(this.txtClave)){
                return "/pages/principal.xhtml";
            }else{
                jsfUtil.addMsgSpecified("formLogin:msgNoti", "Usuario o clave erroreos");
            }
        }
        return null;
    }

    public String getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(String txtUser) {
        this.txtUser = txtUser;
    }

    public String getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(String txtClave) {
        this.txtClave = txtClave;
    }
    
    
        
    @PostConstruct
    public void init(){
        
    }
    
    public String validar(){
        
        return "home";
    }

    
    


}
