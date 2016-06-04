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
@Table(name = "uslug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uslug.findAll", query = "SELECT u FROM Uslug u"),
    @NamedQuery(name = "Uslug.findById", query = "SELECT u FROM Uslug u WHERE u.id = :id"),
    @NamedQuery(name = "Uslug.findByName", query = "SELECT u FROM Uslug u WHERE u.name = :name")})
public class Uslug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "iduslug")
    @JsonIgnore
    private Collection<Stoimostuslug> stoimostuslugCollection;

    public Uslug() {
    }

    public Uslug(Integer id) {
        this.id = id;
    }

    public Uslug(Integer id, String name) {
        this.id = id;
        this.name = name;
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
    public Collection<Stoimostuslug> getStoimostuslugCollection() {
        return stoimostuslugCollection;
    }

    public void setStoimostuslugCollection(Collection<Stoimostuslug> stoimostuslugCollection) {
        this.stoimostuslugCollection = stoimostuslugCollection;
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
        if (!(object instanceof Uslug)) {
            return false;
        }
        Uslug other = (Uslug) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Uslug[ id=" + id + " ]";
    }
    
}
