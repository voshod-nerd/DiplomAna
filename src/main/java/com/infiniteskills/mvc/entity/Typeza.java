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
@Table(name = "TYPEZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeza.findAll", query = "SELECT t FROM Typeza t"),
    @NamedQuery(name = "Typeza.findById", query = "SELECT t FROM Typeza t WHERE t.id = :id"),
    @NamedQuery(name = "Typeza.findByName", query = "SELECT t FROM Typeza t WHERE t.name = :name")})
public class Typeza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "typez")
    @JsonIgnore
    private Collection<Zayvka> zayvkaCollection;

    public Typeza() {
    }

    public Typeza(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Zayvka> getZayvkaCollection() {
        return zayvkaCollection;
    }

    public void setZayvkaCollection(Collection<Zayvka> zayvkaCollection) {
        this.zayvkaCollection = zayvkaCollection;
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
        if (!(object instanceof Typeza)) {
            return false;
        }
        Typeza other = (Typeza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Typeza[ id=" + id + " ]";
    }
    
}
