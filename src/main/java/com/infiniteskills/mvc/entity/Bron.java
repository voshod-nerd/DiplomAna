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
@Table(name = "bron")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bron.findAll", query = "SELECT b FROM Bron b"),
    @NamedQuery(name = "Bron.findById", query = "SELECT b FROM Bron b WHERE b.id = :id"),
    @NamedQuery(name = "Bron.findByDateb", query = "SELECT b FROM Bron b WHERE b.dateb = :dateb"),
    @NamedQuery(name = "Bron.findByDatee", query = "SELECT b FROM Bron b WHERE b.datee = :datee")})
public class Bron implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateb")
    @Temporal(TemporalType.DATE)
    private Date dateb;
    @Column(name = "datee")
    @Temporal(TemporalType.DATE)
    private Date datee;
    @JoinColumn(name = "idnomer", referencedColumnName = "ID")
    @ManyToOne
    private Nomerhotel idnomer;
    @JoinColumn(name = "idclient", referencedColumnName = "ID")
    @ManyToOne
    private Client idclient;

    public Bron() {
    }

    public Bron(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateb() {
        return dateb;
    }

    public void setDateb(Date dateb) {
        this.dateb = dateb;
    }

    public Date getDatee() {
        return datee;
    }

    public void setDatee(Date datee) {
        this.datee = datee;
    }

    public Nomerhotel getIdnomer() {
        return idnomer;
    }

    public void setIdnomer(Nomerhotel idnomer) {
        this.idnomer = idnomer;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
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
        if (!(object instanceof Bron)) {
            return false;
        }
        Bron other = (Bron) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Bron[ id=" + id + " ]";
    }
    
}
