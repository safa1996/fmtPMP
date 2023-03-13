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
@Table(name = "bonus")
public class Bonus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_bonus")
	int id;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "fk_item_texte", nullable = false)
	Itemtextes item_texte;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "fk_item_icono", nullable = false)
	Itemticono item_icono;
	@Column(name = "item_before")
	int item_before;
	@Column(name = "poids")
	int poids;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Itemtextes getItem_texte() {
		return item_texte;
	}

	public void setItem_texte(Itemtextes item_texte) {
		this.item_texte = item_texte;
	}

	public Itemticono getItem_icono() {
		return item_icono;
	}

	public void setItem_icono(Itemticono item_icono) {
		this.item_icono = item_icono;
	}

	public int getItem_before() {
		return item_before;
	}

	public void setItem_before(int item_before) {
		this.item_before = item_before;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

}
