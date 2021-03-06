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
 * @author ����
 */
@Entity
@Table(name = "ORGANIZATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o"),
    @NamedQuery(name = "Organization.findById", query = "SELECT o FROM Organization o WHERE o.id = :id"),
    @NamedQuery(name = "Organization.findByAdres", query = "SELECT o FROM Organization o WHERE o.adres = :adres"),
    @NamedQuery(name = "Organization.findByFiopredstavitel", query = "SELECT o FROM Organization o WHERE o.fiopredstavitel = :fiopredstavitel"),
    @NamedQuery(name = "Organization.findByInn", query = "SELECT o FROM Organization o WHERE o.inn = :inn"),
    @NamedQuery(name = "Organization.findByKpp", query = "SELECT o FROM Organization o WHERE o.kpp = :kpp"),
    @NamedQuery(name = "Organization.findByMail", query = "SELECT o FROM Organization o WHERE o.mail = :mail"),
    @NamedQuery(name = "Organization.findByName", query = "SELECT o FROM Organization o WHERE o.name = :name"),
    @NamedQuery(name = "Organization.findByOgrn", query = "SELECT o FROM Organization o WHERE o.ogrn = :ogrn"),
    @NamedQuery(name = "Organization.findByPhone", query = "SELECT o FROM Organization o WHERE o.phone = :phone")})
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ADRES")
    private String adres;
    @Column(name = "FIOPREDSTAVITEL")
    private String fiopredstavitel;
    @Column(name = "INN")
    private String inn;
    @Column(name = "KPP")
    private String kpp;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "NAME")
    private String name;
    @Column(name = "OGRN")
    private String ogrn;
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(mappedBy = "idorg")
    @JsonIgnore
    private Collection<Bron> bronCollection;
    @OneToMany(mappedBy = "idorganization")
    @JsonIgnore
    private Collection<Program> programCollection;
    @JoinColumn(name = "iduser", referencedColumnName = "username")
    @ManyToOne
    private Employee iduser;
    @OneToMany(mappedBy = "idorg")
    @JsonIgnore
    private Collection<Client> clientCollection;

    public Organization() {
    }

    public Organization(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getFiopredstavitel() {
        return fiopredstavitel;
    }

    public void setFiopredstavitel(String fiopredstavitel) {
        this.fiopredstavitel = fiopredstavitel;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<Bron> getBronCollection() {
        return bronCollection;
    }

    public void setBronCollection(Collection<Bron> bronCollection) {
        this.bronCollection = bronCollection;
    }

    @XmlTransient
    public Collection<Program> getProgramCollection() {
        return programCollection;
    }

    public void setProgramCollection(Collection<Program> programCollection) {
        this.programCollection = programCollection;
    }

    public Employee getIduser() {
        return iduser;
    }

    public void setIduser(Employee iduser) {
        this.iduser = iduser;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
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
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Organization[ id=" + id + " ]";
    }
    
}
