/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.controllers;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author desarrollo
 */
@Named("login")
@SessionScoped
public class Login implements Serializable{
    
        
    @PostConstruct
    public void init(){
        
    }
    
    public String validar(){
        
        return "home";
    }

    
    


}
