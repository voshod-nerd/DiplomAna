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
@Table(name = "stimostpitan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stimostpitan.findAll", query = "SELECT s FROM Stimostpitan s"),
    @NamedQuery(name = "Stimostpitan.findById", query = "SELECT s FROM Stimostpitan s WHERE s.id = :id"),
    @NamedQuery(name = "Stimostpitan.findBySum", query = "SELECT s FROM Stimostpitan s WHERE s.sum = :sum")})
public class Stimostpitan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sum")
    private Long sum;
    @OneToMany(mappedBy = "idstoimostpit")
    @JsonIgnore
    private Collection<Progivanie> progivanieCollection;
    @JoinColumn(name = "idpitanie", referencedColumnName = "id")
    @ManyToOne
    private Pitanie idpitanie;
    @JoinColumn(name = "idtarif", referencedColumnName = "id")
    @ManyToOne
    private Tarifz idtarif;

    public Stimostpitan() {
    }

    public Stimostpitan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @XmlTransient
    public Collection<Progivanie> getProgivanieCollection() {
        return progivanieCollection;
    }

    public void setProgivanieCollection(Collection<Progivanie> progivanieCollection) {
        this.progivanieCollection = progivanieCollection;
    }

    public Pitanie getIdpitanie() {
        return idpitanie;
    }

    public void setIdpitanie(Pitanie idpitanie) {
        this.idpitanie = idpitanie;
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
        if (!(object instanceof Stimostpitan)) {
            return false;
        }
        Stimostpitan other = (Stimostpitan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infiniteskills.mvc.entity.Stimostpitan[ id=" + id + " ]";
    }
    
}
