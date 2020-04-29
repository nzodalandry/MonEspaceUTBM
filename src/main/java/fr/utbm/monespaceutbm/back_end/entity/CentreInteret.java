/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.monespaceutbm.back_end.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nzoda
 */
@Entity
@Table(name = "centre_interet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentreInteret.findAll", query = "SELECT c FROM CentreInteret c")})
public class CentreInteret implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCENT")
    private Long idcent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "LIBCENT")
    private String libcent;
    @JoinColumn(name = "IDCV", referencedColumnName = "IDCV")
    @ManyToOne(optional = false)
    private Cv idcv;

    public CentreInteret() {
    }

    public CentreInteret(Long idcent) {
        this.idcent = idcent;
    }

    public CentreInteret(Long idcent, String libcent) {
        this.idcent = idcent;
        this.libcent = libcent;
    }

    public Long getIdcent() {
        return idcent;
    }

    public void setIdcent(Long idcent) {
        this.idcent = idcent;
    }

    public String getLibcent() {
        return libcent;
    }

    public void setLibcent(String libcent) {
        this.libcent = libcent;
    }

    public Cv getIdcv() {
        return idcv;
    }

    public void setIdcv(Cv idcv) {
        this.idcv = idcv;
    }

    @Override
    public String toString() {
        return "fr.utbm.monespaceutbm.back_end.entity.CentreInteret[ idcent=" + idcent + " ]";
    }
    
}
