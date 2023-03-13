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
@Table(name = "Itemticono")
public class Itemticono implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_icono")
	private int id;
	@Column(name = "filename")
	private String filename;
	@Column(name = "titre")
	private String titre;
	@Column(name = "commentaire")
	private String commentaire;
	@Column(name = "note")
	private int note;
	@Column(name = "ordre")
	private int ordrecreationicono;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "fk_pmp",nullable = false)
	private Pmp pmp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getOrdrecreationicono() {
		return ordrecreationicono;
	}

	public void setOrdrecreationicono(int ordrecreationicono) {
		this.ordrecreationicono = ordrecreationicono;
	}

	public Pmp getPmp() {
		return pmp;
	}

	public void setPmp(Pmp pmp) {
		this.pmp = pmp;
	}

}
