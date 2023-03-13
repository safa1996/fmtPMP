package com.fmt.pmp.fmtPMP.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pmp")
public class Pmp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pmp")
	private int Id;
	@Column(name = "titre")
	private String titre;
	@Column(name = "date")
	private Date date;
	@Column(name = "description")
	@Size(max = 3000)
	private String description;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitre() {
		
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
