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
@Table(name = "grafik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grafik.findAll", query = "SELECT g FROM Grafik g"),
    @NamedQuery(name = "Grafik.findById", query = "SELECT g FROM Grafik g WHERE g.id = :id"),
    @NamedQuery(name = "Grafik.findByDayd", query = "SELECT g FROM Grafik g WHERE g.dayd = :dayd")})
public class Grafik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dayd")
    @Temporal(TemporalType.DATE)
    private Date dayd;
    @JoinColumn(name = "idsotrudnik", referencedColumnName = "ID")
    @ManyToOne
    private Sotrudnik idsotrudnik;
    @JoinColumn(name = "idhotel", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hotel idhotel;

    public Grafik() {
    }

    public Grafik(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDayd() {
        return dayd;
    }

    public void setDayd(Date dayd) {
        this.dayd = dayd;
    }

    public Sotrudnik getIdsotrudnik() {
        return idsotrudnik;
    }

    public void setIdsotrudnik(Sotrudnik idsotrudnik) {
        this.idsotrudnik = idsotrudnik;
    }

    public Hotel getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(Hotel idhotel) {
        this.idhotel = idhotel;
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
        if (!(object instanceof Grafik)) {
            return false;
        }
        Grafik other = (Grafik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Grafik[ id=" + id + " ]";
    }
    
}
