/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Reestruslug.findByIdclient", query = "SELECT r FROM Reestruslug r WHERE r.idclient = :idclient")})
public class Reestruslug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idclient")
    private Integer idclient;
    @JoinColumn(name = "idstoimostuslig", referencedColumnName = "id")
    @ManyToOne
    private Stoimostuslug idstoimostuslig;

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

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public Stoimostuslug getIdstoimostuslig() {
        return idstoimostuslig;
    }

    public void setIdstoimostuslig(Stoimostuslug idstoimostuslig) {
        this.idstoimostuslig = idstoimostuslig;
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
