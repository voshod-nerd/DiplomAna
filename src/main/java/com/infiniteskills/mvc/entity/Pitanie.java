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
@Table(name = "pitanie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pitanie.findAll", query = "SELECT p FROM Pitanie p"),
    @NamedQuery(name = "Pitanie.findById", query = "SELECT p FROM Pitanie p WHERE p.id = :id"),
    @NamedQuery(name = "Pitanie.findByName", query = "SELECT p FROM Pitanie p WHERE p.name = :name")})
public class Pitanie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idpitanie")
    @JsonIgnore
    private Collection<Stimostpitan> stimostpitanCollection;

    public Pitanie() {
    }

    public Pitanie(Integer id) {
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
    public Collection<Stimostpitan> getStimostpitanCollection() {
        return stimostpitanCollection;
    }

    public void setStimostpitanCollection(Collection<Stimostpitan> stimostpitanCollection) {
        this.stimostpitanCollection = stimostpitanCollection;
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
        if (!(object instanceof Pitanie)) {
            return false;
        }
        Pitanie other = (Pitanie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Pitanie[ id=" + id + " ]";
    }
    
}
