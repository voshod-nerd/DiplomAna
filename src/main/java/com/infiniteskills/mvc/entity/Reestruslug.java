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
@Table(name = "reestruslug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reestruslug.findAll", query = "SELECT r FROM Reestruslug r"),
    @NamedQuery(name = "Reestruslug.findById", query = "SELECT r FROM Reestruslug r WHERE r.id = :id"),
    @NamedQuery(name = "Reestruslug.findByDok", query = "SELECT r FROM Reestruslug r WHERE r.dok = :dok")})
public class Reestruslug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dok")
    @Temporal(TemporalType.DATE)
    private Date dok;
    @JoinColumn(name = "iduslug", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Uslug iduslug;
    @JoinColumn(name = "idclient", referencedColumnName = "ID")
    @ManyToOne
    private Client idclient;

    public Reestruslug() {
    }

    public Reestruslug(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDok() {
        return dok;
    }

    public void setDok(Date dok) {
        this.dok = dok;
    }

    public Uslug getIduslug() {
        return iduslug;
    }

    public void setIduslug(Uslug iduslug) {
        this.iduslug = iduslug;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
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
        if (!(object instanceof Reestruslug)) {
            return false;
        }
        Reestruslug other = (Reestruslug) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Reestruslug[ id=" + id + " ]";
    }
    
}
