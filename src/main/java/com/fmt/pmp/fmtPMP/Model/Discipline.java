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
	@Column(name = "Discipline_id")
	private int Id;
	@Column(name = "label")
	private String label;

	public int getId() {
		return Id;
	}

	public void setId(int DisciplineId) {
		this.Id = DisciplineId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String title) {
		this.label = title;
	}

}
