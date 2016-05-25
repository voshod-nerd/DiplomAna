/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Юыху
 */
@Entity
@Table(name = "TYPENOMERHOTEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typenomerhotel.findAll", query = "SELECT t FROM Typenomerhotel t"),
    @NamedQuery(name = "Typenomerhotel.findById", query = "SELECT t FROM Typenomerhotel t WHERE t.id = :id"),
    @NamedQuery(name = "Typenomerhotel.findByMest", query = "SELECT t FROM Typenomerhotel t WHERE t.mest = :mest"),
    @NamedQuery(name = "Typenomerhotel.findByType", query = "SELECT t FROM Typenomerhotel t WHERE t.type = :type")})
public class Typenomerhotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MEST")
    private String mest;
    @Column(name = "TYPE")
    private String type;
    @OneToMany(mappedBy = "idtypenomer")
    @JsonIgnore
    private Collection<Stoimostnomera> stoimostnomeraCollection;
    @OneToMany(mappedBy = "typenomer")
    @JsonIgnore
    private Collection<Nomerhotel> nomerhotelCollection;

    public Typenomerhotel() {
    }

    public Typenomerhotel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMest() {
        return mest;
    }

    public void setMest(String mest) {
        this.mest = mest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Stoimostnomera> getStoimostnomeraCollection() {
        return stoimostnomeraCollection;
    }

    public void setStoimostnomeraCollection(Collection<Stoimostnomera> stoimostnomeraCollection) {
        this.stoimostnomeraCollection = stoimostnomeraCollection;
    }

    @XmlTransient
    public Collection<Nomerhotel> getNomerhotelCollection() {
        return nomerhotelCollection;
    }

    public void setNomerhotelCollection(Collection<Nomerhotel> nomerhotelCollection) {
        this.nomerhotelCollection = nomerhotelCollection;
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
        if (!(object instanceof Typenomerhotel)) {
            return false;
        }
        Typenomerhotel other = (Typenomerhotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Typenomerhotel[ id=" + id + " ]";
    }
    
}
