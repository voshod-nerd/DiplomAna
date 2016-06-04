/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Юыху
 */
@Entity
@Table(name = "otpusk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otpusk.findAll", query = "SELECT o FROM Otpusk o"),
    @NamedQuery(name = "Otpusk.findById", query = "SELECT o FROM Otpusk o WHERE o.id = :id"),
    @NamedQuery(name = "Otpusk.findByDateb", query = "SELECT o FROM Otpusk o WHERE o.dateb = :dateb"),
    @NamedQuery(name = "Otpusk.findByDateend", query = "SELECT o FROM Otpusk o WHERE o.dateend = :dateend")})
public class Otpusk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateb")
    @Temporal(TemporalType.DATE)
    private Date dateb;
    @Column(name = "dateend")
    @Temporal(TemporalType.DATE)
    private Date dateend;
    @JoinColumn(name = "idsotr", referencedColumnName = "ID")
    @ManyToOne
    private Sotrudnik idsotr;

    public Otpusk() {
    }

    public Otpusk(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateb() {
        return dateb;
    }

    public void setDateb(Date dateb) {
        this.dateb = dateb;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    public Sotrudnik getIdsotr() {
        return idsotr;
    }

    public void setIdsotr(Sotrudnik idsotr) {
        this.idsotr = idsotr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otpusk)) {
            return false;
        }
        Otpusk other = (Otpusk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Otpusk[ id=" + id + " ]";
    }
    
}
