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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Îëåã
 */
@Entity
@Table(name = "VIZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viza.findAll", query = "SELECT v FROM Viza v"),
    @NamedQuery(name = "Viza.findById", query = "SELECT v FROM Viza v WHERE v.id = :id"),
    @NamedQuery(name = "Viza.findByBeg", query = "SELECT v FROM Viza v WHERE v.beg = :beg"),
    @NamedQuery(name = "Viza.findByEnd", query = "SELECT v FROM Viza v WHERE v.end = :end"),
    @NamedQuery(name = "Viza.findById\u0441lient", query = "SELECT v FROM Viza v WHERE v.id\u0441lient = :id\u0441lient"),
    @NamedQuery(name = "Viza.findByNumber", query = "SELECT v FROM Viza v WHERE v.number = :number")})
public class Viza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "BEG")
    @Temporal(TemporalType.DATE)
    private Date beg;
    @Column(name = "END")
    @Temporal(TemporalType.DATE)
    private Date end;
    @Column(name = "Idclient")
    private Integer idñlient;
    @Column(name = "NUMBER")
    private String number;

    public Viza() {
    }

    public Viza(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBeg() {
        return beg;
    }

    public void setBeg(Date beg) {
        this.beg = beg;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getIdñlient() {
        return idñlient;
    }

    public void setIdñlient(Integer idñlient) {
        this.idñlient = idñlient;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        if (!(object instanceof Viza)) {
            return false;
        }
        Viza other = (Viza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Viza[ id=" + id + " ]";
    }
    
}
