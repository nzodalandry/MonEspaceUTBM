/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nzoda
 */
@Entity
@Table(name = "lang_cv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LangCv.findAll", query = "SELECT l FROM LangCv l")})
public class LangCv implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LangCvPK langCvPK;
    @Size(max = 4)
    @Column(name = "NIVLANG")
    private String nivlang;
    @JoinColumn(name = "IDCV", referencedColumnName = "IDCV", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cv cv;
    @JoinColumn(name = "IDLANG", referencedColumnName = "IDLANG", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Langue langue;

    public LangCv() {
    }

    public LangCv(LangCvPK langCvPK) {
        this.langCvPK = langCvPK;
    }

    public LangCv(long idcv, long idlang) {
        this.langCvPK = new LangCvPK(idcv, idlang);
    }

    public LangCvPK getLangCvPK() {
        return langCvPK;
    }

    public void setLangCvPK(LangCvPK langCvPK) {
        this.langCvPK = langCvPK;
    }

    public String getNivlang() {
        return nivlang;
    }

    public void setNivlang(String nivlang) {
        this.nivlang = nivlang;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (langCvPK != null ? langCvPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LangCv)) {
            return false;
        }
        LangCv other = (LangCv) object;
        if ((this.langCvPK == null && other.langCvPK != null) || (this.langCvPK != null && !this.langCvPK.equals(other.langCvPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.LangCv[ langCvPK=" + langCvPK + " ]";
    }
    
}
