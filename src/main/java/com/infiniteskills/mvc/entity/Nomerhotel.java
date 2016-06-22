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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "NOMERHOTEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nomerhotel.findAll", query = "SELECT n FROM Nomerhotel n"),
    @NamedQuery(name = "Nomerhotel.findById", query = "SELECT n FROM Nomerhotel n WHERE n.id = :id"),
    @NamedQuery(name = "Nomerhotel.findByNumber", query = "SELECT n FROM Nomerhotel n WHERE n.number = :number"),
    @NamedQuery(name = "Nomerhotel.findByReady", query = "SELECT n FROM Nomerhotel n WHERE n.ready = :ready")})
public class Nomerhotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMBER")
    private Integer number;
    @Column(name = "READY")
    private Boolean ready;
    @OneToMany(mappedBy = "idnomer")
    @JsonIgnore
    private Collection<Bron> bronCollection;
    @OneToMany(mappedBy = "idnomer")
    @JsonIgnore
    private Collection<Progivanie> progivanieCollection;
    @JoinColumn(name = "IDGOSTIN", referencedColumnName = "ID")
    @ManyToOne
    private Hotel idgostin;
    @JoinColumn(name = "TYPENOMER", referencedColumnName = "ID")
    @ManyToOne
    private Typenomerhotel typenomer;
    @OneToMany(mappedBy = "idnomer")
    @JsonIgnore
    private Collection<Zayvka> zayvkaCollection;

    public Nomerhotel() {
    }

    public Nomerhotel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    @XmlTransient
    public Collection<Bron> getBronCollection() {
        return bronCollection;
    }

    public void setBronCollection(Collection<Bron> bronCollection) {
        this.bronCollection = bronCollection;
    }

    @XmlTransient
    public Collection<Progivanie> getProgivanieCollection() {
        return progivanieCollection;
    }

    public void setProgivanieCollection(Collection<Progivanie> progivanieCollection) {
        this.progivanieCollection = progivanieCollection;
    }

    public Hotel getIdgostin() {
        return idgostin;
    }

    public void setIdgostin(Hotel idgostin) {
        this.idgostin = idgostin;
    }

    public Typenomerhotel getTypenomer() {
        return typenomer;
    }

    public void setTypenomer(Typenomerhotel typenomer) {
        this.typenomer = typenomer;
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
        if (!(object instanceof Nomerhotel)) {
            return false;
        }
        Nomerhotel other = (Nomerhotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Nomerhotel[ id=" + id + " ]";
    }
    
}
