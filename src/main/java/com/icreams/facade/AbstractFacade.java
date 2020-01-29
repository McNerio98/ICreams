/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.facade;

import javax.persistence.EntityManager;

/**
 *
 * @author ZEUS
 */

public abstract class AbstractFacade<T> {
    private Class<T> claseEntidad;
    
    public AbstractFacade(Class<T> claseEntidad){
        this.claseEntidad = claseEntidad;
    }
    //Las clases hijas tendran acceso a este miembro abstracto 
    // El EnitityManager pertenece a la API JPA
    protected abstract EntityManager getEntityManager();
    
    public void insertar(T entidad){
        getEntityManager().persist(entidad);
    }
    
}
