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
 * @author соколов
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByDataokon", query = "SELECT c FROM Client c WHERE c.dataokon = :dataokon"),
    @NamedQuery(name = "Client.findByDatavid", query = "SELECT c FROM Client c WHERE c.datavid = :datavid"),
    @NamedQuery(name = "Client.findByDr", query = "SELECT c FROM Client c WHERE c.dr = :dr"),
    @NamedQuery(name = "Client.findByFio", query = "SELECT c FROM Client c WHERE c.fio = :fio"),
    @NamedQuery(name = "Client.findByKemvidan", query = "SELECT c FROM Client c WHERE c.kemvidan = :kemvidan"),
    @NamedQuery(name = "Client.findByNumberdoc", query = "SELECT c FROM Client c WHERE c.numberdoc = :numberdoc"),
    @NamedQuery(name = "Client.findByPol", query = "SELECT c FROM Client c WHERE c.pol = :pol"),
    @NamedQuery(name = "Client.findByProgclient", query = "SELECT c FROM Client c WHERE c.progclient = :progclient"),
    @NamedQuery(name = "Client.findBySerdoc", query = "SELECT c FROM Client c WHERE c.serdoc = :serdoc"),
    @NamedQuery(name = "Client.findByFioeng", query = "SELECT c FROM Client c WHERE c.fioeng = :fioeng"),
    @NamedQuery(name = "Client.findByViddock", query = "SELECT c FROM Client c WHERE c.viddock = :viddock"),
    @NamedQuery(name = "Client.findByStrana", query = "SELECT c FROM Client c WHERE c.strana = :strana"),
    @NamedQuery(name = "Client.findByAdres", query = "SELECT c FROM Client c WHERE c.adres = :adres")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATAOKON")
    @Temporal(TemporalType.DATE)
    private Date dataokon;
    @Column(name = "DATAVID")
    @Temporal(TemporalType.DATE)
    private Date datavid;
    @Column(name = "DR")
    private String dr;
    @Column(name = "FIO")
    private String fio;
    @Column(name = "KEMVIDAN")
    private String kemvidan;
    @Column(name = "NUMBERDOC")
    private String numberdoc;
    @Column(name = "POL")
    private String pol;
    @Column(name = "PROGCLIENT")
    private String progclient;
    @Column(name = "SERDOC")
    private String serdoc;
    @Column(name = "FIOENG")
    private String fioeng;
    @Column(name = "VIDDOCK")
    private String viddock;
    @Basic(optional = false)
    @Column(name = "STRANA")
    private String strana;
    @Column(name = "ADRES")
    private String adres;
    @JoinColumn(name = "idorg", referencedColumnName = "ID")
    @ManyToOne
    private Organization idorg;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, String strana) {
        this.id = id;
        this.strana = strana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataokon() {
        return dataokon;
    }

    public void setDataokon(Date dataokon) {
        this.dataokon = dataokon;
    }

    public Date getDatavid() {
        return datavid;
    }

    public void setDatavid(Date datavid) {
        this.datavid = datavid;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getKemvidan() {
        return kemvidan;
    }

    public void setKemvidan(String kemvidan) {
        this.kemvidan = kemvidan;
    }

    public String getNumberdoc() {
        return numberdoc;
    }

    public void setNumberdoc(String numberdoc) {
        this.numberdoc = numberdoc;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getProgclient() {
        return progclient;
    }

    public void setProgclient(String progclient) {
        this.progclient = progclient;
    }

    public String getSerdoc() {
        return serdoc;
    }

    public void setSerdoc(String serdoc) {
        this.serdoc = serdoc;
    }

    public String getFioeng() {
        return fioeng;
    }

    public void setFioeng(String fioeng) {
        this.fioeng = fioeng;
    }

    public String getViddock() {
        return viddock;
    }

    public void setViddock(String viddock) {
        this.viddock = viddock;
    }

    public String getStrana() {
        return strana;
    }

    public void setStrana(String strana) {
        this.strana = strana;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Organization getIdorg() {
        return idorg;
    }

    public void setIdorg(Organization idorg) {
        this.idorg = idorg;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Client[ id=" + id + " ]";
    }
    
}
