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
@Table(name = "DOLGNOST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dolgnost.findAll", query = "SELECT d FROM Dolgnost d"),
    @NamedQuery(name = "Dolgnost.findById", query = "SELECT d FROM Dolgnost d WHERE d.id = :id"),
    @NamedQuery(name = "Dolgnost.findByDolgnost", query = "SELECT d FROM Dolgnost d WHERE d.dolgnost = :dolgnost")})
public class Dolgnost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DOLGNOST")
    private String dolgnost;
    @OneToMany(mappedBy = "iddolgnost")
    @JsonIgnore
    private Collection<Sotrudnik> sotrudnikCollection;

    public Dolgnost() {
    }

    public Dolgnost(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDolgnost() {
        return dolgnost;
    }

    public void setDolgnost(String dolgnost) {
        this.dolgnost = dolgnost;
    }

    @XmlTransient
    public Collection<Sotrudnik> getSotrudnikCollection() {
        return sotrudnikCollection;
    }

    public void setSotrudnikCollection(Collection<Sotrudnik> sotrudnikCollection) {
        this.sotrudnikCollection = sotrudnikCollection;
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
        if (!(object instanceof Dolgnost)) {
            return false;
        }
        Dolgnost other = (Dolgnost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Dolgnost[ id=" + id + " ]";
    }
    
}
