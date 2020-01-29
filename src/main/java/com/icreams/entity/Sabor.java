/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author desarrollo
 */
@Entity
@Table(name="sabores")
public class Sabor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idsabor")
    private Integer idSabor;
    @Column(name="sabor")
    private String sabor;

    public Sabor() {
    }

    public int getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(int idSabor) {
        this.idSabor = idSabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}
