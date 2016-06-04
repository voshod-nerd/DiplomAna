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
@Table(name = "tarifz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifz.findAll", query = "SELECT t FROM Tarifz t"),
    @NamedQuery(name = "Tarifz.findById", query = "SELECT t FROM Tarifz t WHERE t.id = :id"),
    @NamedQuery(name = "Tarifz.findByName", query = "SELECT t FROM Tarifz t WHERE t.name = :name")})
public class Tarifz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idtarif")
    @JsonIgnore
    private Collection<Stoimostnomera> stoimostnomeraCollection;
    @OneToMany(mappedBy = "idtarif")
    @JsonIgnore
    private Collection<Program> programCollection;
    @OneToMany(mappedBy = "idtarif")
    @JsonIgnore
    private Collection<Stoimostuslug> stoimostuslugCollection;
    @OneToMany(mappedBy = "idtarif")
    @JsonIgnore
    private Collection<Stimostpitan> stimostpitanCollection;

    public Tarifz() {
    }

    public Tarifz(Integer id) {
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
    public Collection<Stoimostnomera> getStoimostnomeraCollection() {
        return stoimostnomeraCollection;
    }

    public void setStoimostnomeraCollection(Collection<Stoimostnomera> stoimostnomeraCollection) {
        this.stoimostnomeraCollection = stoimostnomeraCollection;
    }

    @XmlTransient
    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    @XmlTransient
    public Collection<Stoimostuslug> getStoimostuslugCollection() {
        return stoimostuslugCollection;
    }

    public void setStoimostuslugCollection(Collection<Stoimostuslug> stoimostuslugCollection) {
        this.stoimostuslugCollection = stoimostuslugCollection;
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
        if (!(object instanceof Tarifz)) {
            return false;
        }
        Tarifz other = (Tarifz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Tarifz[ id=" + id + " ]";
    }
    
}
