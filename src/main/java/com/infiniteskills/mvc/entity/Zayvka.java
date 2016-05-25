/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Юыху
 */
@Entity
@Table(name = "ZAYVKA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zayvka.findAll", query = "SELECT z FROM Zayvka z"),
    @NamedQuery(name = "Zayvka.findById", query = "SELECT z FROM Zayvka z WHERE z.id = :id"),
    @NamedQuery(name = "Zayvka.findByDatez", query = "SELECT z FROM Zayvka z WHERE z.datez = :datez"),
    @NamedQuery(name = "Zayvka.findByDatezav", query = "SELECT z FROM Zayvka z WHERE z.datezav = :datezav"),
    @NamedQuery(name = "Zayvka.findByStatus", query = "SELECT z FROM Zayvka z WHERE z.status = :status")})
public class Zayvka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATEZ")
    @Temporal(TemporalType.DATE)
    private Date datez;
    @Column(name = "DATEZAV")
    @Temporal(TemporalType.DATE)
    private Date datezav;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "IDNOMER", referencedColumnName = "ID")
    @ManyToOne
    private Nomerhotel idnomer;
    @JoinColumn(name = "IDSOTR", referencedColumnName = "ID")
    @ManyToOne
    private Sotrudnik idsotr;
    @JoinColumn(name = "TYPEZ", referencedColumnName = "ID")
    @ManyToOne
    private Typeza typez;

    public Zayvka() {
    }

    public Zayvka(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatez() {
        return datez;
    }

    public void setDatez(Date datez) {
        this.datez = datez;
    }

    public Date getDatezav() {
        return datezav;
    }

    public void setDatezav(Date datezav) {
        this.datezav = datezav;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Nomerhotel getIdnomer() {
        return idnomer;
    }

    public void setIdnomer(Nomerhotel idnomer) {
        this.idnomer = idnomer;
    }

    public Sotrudnik getIdsotr() {
        return idsotr;
    }

    public void setIdsotr(Sotrudnik idsotr) {
        this.idsotr = idsotr;
    }

    public Typeza getTypez() {
        return typez;
    }

    public void setTypez(Typeza typez) {
        this.typez = typez;
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
        if (!(object instanceof Zayvka)) {
            return false;
        }
        Zayvka other = (Zayvka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Zayvka[ id=" + id + " ]";
    }
    
}
