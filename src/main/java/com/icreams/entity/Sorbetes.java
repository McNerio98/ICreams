/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZEUS
 */
@Entity
@Table(name = "sorbetes", catalog = "icreams", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sorbetes.findAll", query = "SELECT s FROM Sorbetes s")
    , @NamedQuery(name = "Sorbetes.findByIdsorbete", query = "SELECT s FROM Sorbetes s WHERE s.idsorbete = :idsorbete")
    , @NamedQuery(name = "Sorbetes.findBySorbete", query = "SELECT s FROM Sorbetes s WHERE s.sorbete = :sorbete")
    , @NamedQuery(name = "Sorbetes.findByPreciounidad", query = "SELECT s FROM Sorbetes s WHERE s.preciounidad = :preciounidad")})
public class Sorbetes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsorbete", nullable = false)
    private Integer idsorbete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "sorbete", nullable = false, length = 15)
    private String sorbete;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciounidad", nullable = false, precision = 5, scale = 2)
    private BigDecimal preciounidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsorbete")
    private List<DetalleVenta> detalleVentaList;
    @JoinColumn(name = "idsabor", referencedColumnName = "idsabor", nullable = false)
    @ManyToOne(optional = false)
    private Sabor idsabor;

    public Sorbetes() {
    }

    public Sorbetes(Integer idsorbete) {
        this.idsorbete = idsorbete;
    }

    public Sorbetes(Integer idsorbete, String sorbete, BigDecimal preciounidad) {
        this.idsorbete = idsorbete;
        this.sorbete = sorbete;
        this.preciounidad = preciounidad;
    }

    public Integer getIdsorbete() {
        return idsorbete;
    }

    public void setIdsorbete(Integer idsorbete) {
        this.idsorbete = idsorbete;
    }

    public String getSorbete() {
        return sorbete;
    }

    public void setSorbete(String sorbete) {
        this.sorbete = sorbete;
    }

    public BigDecimal getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(BigDecimal preciounidad) {
        this.preciounidad = preciounidad;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    public Sabor getIdsabor() {
        return idsabor;
    }

    public void setIdsabor(Sabor idsabor) {
        this.idsabor = idsabor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsorbete != null ? idsorbete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sorbetes)) {
            return false;
        }
        Sorbetes other = (Sorbetes) object;
        if ((this.idsorbete == null && other.idsorbete != null) || (this.idsorbete != null && !this.idsorbete.equals(other.idsorbete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icreams.entity.Sorbetes[ idsorbete=" + idsorbete + " ]";
    }
    
}
