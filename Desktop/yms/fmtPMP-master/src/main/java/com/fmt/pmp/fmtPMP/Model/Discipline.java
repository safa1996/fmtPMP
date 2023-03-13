package com.fmt.pmp.fmtPMP.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Disciplines")
public class Discipline implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_discipline")
	private int Id;
	@Column(name = "theme")
	private String theme;

	public int getId() {
		return Id;
	}

	public void setId(int DisciplineId) {
		this.Id = DisciplineId;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String title) {
		this.theme = title;
	}

}
