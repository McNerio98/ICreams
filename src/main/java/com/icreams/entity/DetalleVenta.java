/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icreams.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZEUS
 */
@Entity
@Table(name = "detalle_venta", catalog = "icreams", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")
    , @NamedQuery(name = "DetalleVenta.findByIddetalle", query = "SELECT d FROM DetalleVenta d WHERE d.iddetalle = :iddetalle")
    , @NamedQuery(name = "DetalleVenta.findByCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleVenta.findByPreciounidad", query = "SELECT d FROM DetalleVenta d WHERE d.preciounidad = :preciounidad")
    , @NamedQuery(name = "DetalleVenta.findBySubtotal", query = "SELECT d FROM DetalleVenta d WHERE d.subtotal = :subtotal")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle", nullable = false)
    private Integer iddetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciounidad", nullable = false, precision = 8, scale = 2)
    private BigDecimal preciounidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal", nullable = false, precision = 5, scale = 2)
    private BigDecimal subtotal;
    @JoinColumn(name = "idsorbete", referencedColumnName = "idsorbete", nullable = false)
    @ManyToOne(optional = false)
    private Sorbetes idsorbete;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa", nullable = false)
    @ManyToOne(optional = false)
    private Ventas idventa;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public DetalleVenta(Integer iddetalle, int cantidad, BigDecimal preciounidad, BigDecimal subtotal) {
        this.iddetalle = iddetalle;
        this.cantidad = cantidad;
        this.preciounidad = preciounidad;
        this.subtotal = subtotal;
    }

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(BigDecimal preciounidad) {
        this.preciounidad = preciounidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Sorbetes getIdsorbete() {
        return idsorbete;
    }

    public void setIdsorbete(Sorbetes idsorbete) {
        this.idsorbete = idsorbete;
    }

    public Ventas getIdventa() {
        return idventa;
    }

    public void setIdventa(Ventas idventa) {
        this.idventa = idventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalle != null ? iddetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.iddetalle == null && other.iddetalle != null) || (this.iddetalle != null && !this.iddetalle.equals(other.iddetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icreams.entity.DetalleVenta[ iddetalle=" + iddetalle + " ]";
    }
    
}
