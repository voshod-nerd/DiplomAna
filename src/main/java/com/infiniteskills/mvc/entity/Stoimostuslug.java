/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Юыху
 */
@Entity
@Table(name = "stoimostuslug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stoimostuslug.findAll", query = "SELECT s FROM Stoimostuslug s"),
    @NamedQuery(name = "Stoimostuslug.findById", query = "SELECT s FROM Stoimostuslug s WHERE s.id = :id"),
    @NamedQuery(name = "Stoimostuslug.findBySumma", query = "SELECT s FROM Stoimostuslug s WHERE s.summa = :summa")})
public class Stoimostuslug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "summa")
    private BigDecimal summa;
    @JoinColumn(name = "iduslug", referencedColumnName = "id")
    @ManyToOne
    private Uslug iduslug;
    @JoinColumn(name = "idtarif", referencedColumnName = "id")
    @ManyToOne
    private Tarifz idtarif;

    public Stoimostuslug() {
    }

    public Stoimostuslug(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public Uslug getIduslug() {
        return iduslug;
    }

    public void setIduslug(Uslug iduslug) {
        this.iduslug = iduslug;
    }

    public Tarifz getIdtarif() {
        return idtarif;
    }

    public void setIdtarif(Tarifz idtarif) {
        this.idtarif = idtarif;
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
        if (!(object instanceof Stoimostuslug)) {
            return false;
        }
        Stoimostuslug other = (Stoimostuslug) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Stoimostuslug[ id=" + id + " ]";
    }
    
}
