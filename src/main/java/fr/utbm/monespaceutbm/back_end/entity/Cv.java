/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nzoda
 */
@Entity
@Table(name = "cv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cv.findAll", query = "SELECT c FROM Cv c")})
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCV")
    private Long idcv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LIBCV")
    private String libcv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROFILCV")
    private String profilcv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECREACV")
    @Temporal(TemporalType.DATE)
    private Date datecreacv;
    @Column(name = "MISAJOURCV")
    @Temporal(TemporalType.DATE)
    private Date misajourcv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcv")
    private Collection<CentreInteret> centreInteretCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<LangCv> langCvCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcv")
    private Collection<Formation> formationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcv")
    private Collection<Experience> experienceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcv")
    private Collection<Competence> competenceCollection;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Utilisateur iduser;

    public Cv() {
    }

    public Cv(Long idcv) {
        this.idcv = idcv;
    }

    public Cv(Long idcv, String libcv, String profilcv, Date datecreacv) {
        this.idcv = idcv;
        this.libcv = libcv;
        this.profilcv = profilcv;
        this.datecreacv = datecreacv;
    }

    public Long getIdcv() {
        return idcv;
    }

    public void setIdcv(Long idcv) {
        this.idcv = idcv;
    }

    public String getLibcv() {
        return libcv;
    }

    public void setLibcv(String libcv) {
        this.libcv = libcv;
    }

    public String getProfilcv() {
        return profilcv;
    }

    public void setProfilcv(String profilcv) {
        this.profilcv = profilcv;
    }

    public Date getDatecreacv() {
        return datecreacv;
    }

    public void setDatecreacv(Date datecreacv) {
        this.datecreacv = datecreacv;
    }

    public Date getMisajourcv() {
        return misajourcv;
    }

    public void setMisajourcv(Date misajourcv) {
        this.misajourcv = misajourcv;
    }

    @XmlTransient
    public Collection<CentreInteret> getCentreInteretCollection() {
        return centreInteretCollection;
    }

    public void setCentreInteretCollection(Collection<CentreInteret> centreInteretCollection) {
        this.centreInteretCollection = centreInteretCollection;
    }

    @XmlTransient
    public Collection<LangCv> getLangCvCollection() {
        return langCvCollection;
    }

    public void setLangCvCollection(Collection<LangCv> langCvCollection) {
        this.langCvCollection = langCvCollection;
    }

    @XmlTransient
    public Collection<Formation> getFormationCollection() {
        return formationCollection;
    }

    public void setFormationCollection(Collection<Formation> formationCollection) {
        this.formationCollection = formationCollection;
    }

    @XmlTransient
    public Collection<Experience> getExperienceCollection() {
        return experienceCollection;
    }

    public void setExperienceCollection(Collection<Experience> experienceCollection) {
        this.experienceCollection = experienceCollection;
    }

    @XmlTransient
    public Collection<Competence> getCompetenceCollection() {
        return competenceCollection;
    }

    public void setCompetenceCollection(Collection<Competence> competenceCollection) {
        this.competenceCollection = competenceCollection;
    }

    public Utilisateur getIduser() {
        return iduser;
    }

    public void setIduser(Utilisateur iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Cv[ idcv=" + idcv + " ]";
    }
    
}
