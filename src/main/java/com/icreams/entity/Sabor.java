/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollo
 */
@Entity
@Table(name="sabores")
public class Sabor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsabor", nullable = false)
    private Integer idsabor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "sabor", nullable = false, length = 15)
    private String sabor;

    public Sabor() {
    }

    public Sabor(Integer idsabor) {
        this.idsabor = idsabor;
    }

    public Sabor(Integer idsabor, String sabor) {
        this.idsabor = idsabor;
        this.sabor = sabor;
    }

    public Integer getIdsabor() {
        return idsabor;
    }

    public void setIdsabor(Integer idsabor) {
        this.idsabor = idsabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsabor != null ? idsabor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sabor)) {
            return false;
        }
        Sabor other = (Sabor) object;
        if ((this.idsabor == null && other.idsabor != null) || (this.idsabor != null && !this.idsabor.equals(other.idsabor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icreams.entity.Sabor[ idsabor=" + idsabor + " ]";
    }

}
