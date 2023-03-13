package com.fmt.pmp.fmtPMP.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Itemtextes")
public class Itemtextes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_item_texte")
	private int id_item_texte;
	@Column(name = "proposition")
	private String proposition;
	@Column(name = "reponse")
	private String reponse;
	@Column(name = "note")
	private int note;
	@Column(name = "ordrecreationtexte")
	private int ordrecreationtexte;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "fk_pmp", nullable = false)
	private Pmp pmp;

	public int getId_item_texte() {
		return id_item_texte;
	}

	public void setId_item_texte(int id_item_texte) {
		this.id_item_texte = id_item_texte;
	}

	public String getProposition() {
		return proposition;
	}

	public void setProposition(String proposition) {
		this.proposition = proposition;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getOrdrecreationtexte() {
		return ordrecreationtexte;
	}

	public void setOrdrecreationtexte(int ordrecreationtexte) {
		this.ordrecreationtexte = ordrecreationtexte;
	}

	public Pmp getPmp() {
		return pmp;
	}

	public void setPmp(Pmp pmp) {
		this.pmp = pmp;
	}

	
}
