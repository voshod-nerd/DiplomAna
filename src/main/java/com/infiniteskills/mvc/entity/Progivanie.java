/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "progivanie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Progivanie.findAll", query = "SELECT p FROM Progivanie p"),
    @NamedQuery(name = "Progivanie.findById", query = "SELECT p FROM Progivanie p WHERE p.id = :id"),
    @NamedQuery(name = "Progivanie.findByDatein", query = "SELECT p FROM Progivanie p WHERE p.datein = :datein"),
    @NamedQuery(name = "Progivanie.findByDateout", query = "SELECT p FROM Progivanie p WHERE p.dateout = :dateout"),
    @NamedQuery(name = "Progivanie.findByDopusl", query = "SELECT p FROM Progivanie p WHERE p.dopusl = :dopusl"),
    @NamedQuery(name = "Progivanie.findByTotalsum", query = "SELECT p FROM Progivanie p WHERE p.totalsum = :totalsum")})
public class Progivanie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datein")
    @Temporal(TemporalType.DATE)
    private Date datein;
    @Column(name = "dateout")
    @Temporal(TemporalType.DATE)
    private Date dateout;
    @Column(name = "dopusl")
    private BigInteger dopusl;
    @Column(name = "totalsum")
    private BigInteger totalsum;
    @JoinColumn(name = "idclient", referencedColumnName = "ID")
    @ManyToOne
    private Client idclient;
    @JoinColumn(name = "idnomer", referencedColumnName = "ID")
    @ManyToOne
    private Nomerhotel idnomer;
    @JoinColumn(name = "idstoimostnomer", referencedColumnName = "id")
    @ManyToOne
    private Stoimostnomera idstoimostnomer;
    @JoinColumn(name = "idstoimostpit", referencedColumnName = "id")
    @ManyToOne
    private Stimostpitan idstoimostpit;

    public Progivanie() {
    }

    public Progivanie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatein() {
        return datein;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    public Date getDateout() {
        return dateout;
    }

    public void setDateout(Date dateout) {
        this.dateout = dateout;
    }

    public BigInteger getDopusl() {
        return dopusl;
    }

    public void setDopusl(BigInteger dopusl) {
        this.dopusl = dopusl;
    }

    public BigInteger getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(BigInteger totalsum) {
        this.totalsum = totalsum;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Nomerhotel getIdnomer() {
        return idnomer;
    }

    public void setIdnomer(Nomerhotel idnomer) {
        this.idnomer = idnomer;
    }

    public Stoimostnomera getIdstoimostnomer() {
        return idstoimostnomer;
    }

    public void setIdstoimostnomer(Stoimostnomera idstoimostnomer) {
        this.idstoimostnomer = idstoimostnomer;
    }

    public Stimostpitan getIdstoimostpit() {
        return idstoimostpit;
    }

    public void setIdstoimostpit(Stimostpitan idstoimostpit) {
        this.idstoimostpit = idstoimostpit;
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
        if (!(object instanceof Progivanie)) {
            return false;
        }
        Progivanie other = (Progivanie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Progivanie[ id=" + id + " ]";
    }
    
}
