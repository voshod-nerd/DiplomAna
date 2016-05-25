/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "stoimostnomera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stoimostnomera.findAll", query = "SELECT s FROM Stoimostnomera s"),
    @NamedQuery(name = "Stoimostnomera.findById", query = "SELECT s FROM Stoimostnomera s WHERE s.id = :id"),
    @NamedQuery(name = "Stoimostnomera.findBySumma", query = "SELECT s FROM Stoimostnomera s WHERE s.summa = :summa")})
public class Stoimostnomera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "summa")
    private BigInteger summa;
    @JoinColumn(name = "idtypenomer", referencedColumnName = "ID")
    @ManyToOne
    private Typenomerhotel idtypenomer;
    @JoinColumn(name = "idtarif", referencedColumnName = "id")
    @ManyToOne
    private Tarifz idtarif;
    @OneToMany(mappedBy = "idstoimostnomer")
    @JsonIgnore
    private Collection<Progivanie> progivanieCollection;

    public Stoimostnomera() {
    }

    public Stoimostnomera(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getSumma() {
        return summa;
    }

    public void setSumma(BigInteger summa) {
        this.summa = summa;
    }

    public Typenomerhotel getIdtypenomer() {
        return idtypenomer;
    }

    public void setIdtypenomer(Typenomerhotel idtypenomer) {
        this.idtypenomer = idtypenomer;
    }

    public Tarifz getIdtarif() {
        return idtarif;
    }

    public void setIdtarif(Tarifz idtarif) {
        this.idtarif = idtarif;
    }

    @XmlTransient
    public Collection<Progivanie> getProgivanieCollection() {
        return progivanieCollection;
    }

    public void setProgivanieCollection(Collection<Progivanie> progivanieCollection) {
        this.progivanieCollection = progivanieCollection;
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
        if (!(object instanceof Stoimostnomera)) {
            return false;
        }
        Stoimostnomera other = (Stoimostnomera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Stoimostnomera[ id=" + id + " ]";
    }
    
}
