/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nzoda
 */
@Entity
@Table(name = "langue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langue.findAll", query = "SELECT l FROM Langue l")})
public class Langue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLANG")
    private Long idlang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LIBLANG")
    private String liblang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "langue")
    private Collection<LangCv> langCvCollection;

    public Langue() {
    }

    public Langue(Long idlang) {
        this.idlang = idlang;
    }

    public Langue(Long idlang, String liblang) {
        this.idlang = idlang;
        this.liblang = liblang;
    }

    public Long getIdlang() {
        return idlang;
    }

    public void setIdlang(Long idlang) {
        this.idlang = idlang;
    }

    public String getLiblang() {
        return liblang;
    }

    public void setLiblang(String liblang) {
        this.liblang = liblang;
    }

    @XmlTransient
    public Collection<LangCv> getLangCvCollection() {
        return langCvCollection;
    }

    public void setLangCvCollection(Collection<LangCv> langCvCollection) {
        this.langCvCollection = langCvCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlang != null ? idlang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Langue)) {
            return false;
        }
        Langue other = (Langue) object;
        if ((this.idlang == null && other.idlang != null) || (this.idlang != null && !this.idlang.equals(other.idlang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Langue[ idlang=" + idlang + " ]";
    }
    
}
