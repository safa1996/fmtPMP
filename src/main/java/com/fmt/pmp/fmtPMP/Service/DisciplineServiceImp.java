package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.DAO.DisciplineDAO;
import com.fmt.pmp.fmtPMP.Model.Discipline;

@Service
public class DisciplineServiceImp implements DisciplineService {

	@Autowired
	private DisciplineDAO DisciplineDAO;

	@Override
	public Discipline getDisciplineById(int DisciplineId) {
		Discipline obj = DisciplineDAO.getDisciplineById(DisciplineId);
		return obj;
	}

	@Override
	public List<Discipline> getAllDisciplines() {
		return DisciplineDAO.getAllDisciplines();
	}

	@Override
	@Transactional
	public Discipline createDiscipline(Discipline theTransaction) {
		return DisciplineDAO.createDiscipline(theTransaction);
	}

	@Override
	public void updateDiscipline(Discipline Discipline) {
		DisciplineDAO.updateDiscipline(Discipline);
	}

	@Override
	public void deleteDiscipline(int DisciplineId) {
		DisciplineDAO.deleteDiscipline(DisciplineId);
	}

}
