/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nzoda
 */
@Entity
@Table(name = "evenement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evenement.findAll", query = "SELECT e FROM Evenement e")})
public class Evenement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEVT")
    private Long idevt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMEVT")
    private String nomevt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEEVT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateevt;
    @Size(max = 50)
    @Column(name = "COMEVT")
    private String comevt;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Utilisateur iduser;

    public Evenement() {
    }

    public Evenement(Long idevt) {
        this.idevt = idevt;
    }

    public Evenement(Long idevt, String nomevt, Date dateevt) {
        this.idevt = idevt;
        this.nomevt = nomevt;
        this.dateevt = dateevt;
    }

    public Long getIdevt() {
        return idevt;
    }

    public void setIdevt(Long idevt) {
        this.idevt = idevt;
    }

    public String getNomevt() {
        return nomevt;
    }

    public void setNomevt(String nomevt) {
        this.nomevt = nomevt;
    }

    public Date getDateevt() {
        return dateevt;
    }

    public void setDateevt(Date dateevt) {
        this.dateevt = dateevt;
    }

    public String getComevt() {
        return comevt;
    }

    public void setComevt(String comevt) {
        this.comevt = comevt;
    }

    public Utilisateur getIduser() {
        return iduser;
    }

    public void setIduser(Utilisateur iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.Evenement[ idevt=" + idevt + " ]";
    }
    
}
