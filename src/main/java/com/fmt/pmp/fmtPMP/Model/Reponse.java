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
@Table(name = "Reponse")
public class Reponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_reponse")
	int id;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "fk_pmp", nullable = false)
	Pmp pmp;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "fk_etudiant", nullable = false)
	User etudiant;
	@Column(name = "bonus")
	int bonus;
	@Column(name = "note")
	int note;
	@Column(name = "ordre")
	int ordre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pmp getPmp() {
		return pmp;
	}
	public void setPmp(Pmp pmp) {
		this.pmp = pmp;
	}
	public User getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(User etudiant) {
		this.etudiant = etudiant;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	
}
