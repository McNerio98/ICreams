/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.controllers;

import com.icreams.controllers.util.jsfUtil;
import com.icreams.controllers.util.jsfUtil.Accion;
import com.icreams.entity.Usuario;
import com.icreams.facade.UsuariosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ZEUS
 */
@Named("registro")
@SessionScoped
public class Registro implements Serializable{
    
    @EJB
    private UsuariosFacade ejbUsuario;
    private Usuario user;

    
    private UsuariosFacade getFacade(){
        return this.ejbUsuario;
    }

    @PostConstruct
    public void init(){
        this.user = new Usuario();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    

    public void crear(){
        this.persistir(Accion.CREATE);
    }
    
    public String cancelar(){
        return "/pages/login.xhtml";
    }
    
    private void persistir(Accion action){
        
        if(action == Accion.CREATE){
            getFacade().insertar(user);
        }
    }
    

}
