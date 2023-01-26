package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Discipline;

public interface DisciplineDAO {

	List<Discipline> getAllDisciplines();

	Discipline getDisciplineById(int DisciplineId);

	void createDiscipline(Discipline Discipline);

	void updateDiscipline(Discipline Discipline);

	void deleteDiscipline(int DisciplineId);

	boolean DisciplineExists(String label);
}
