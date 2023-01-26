package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmt.pmp.fmtPMP.DAO.DisciplineDAO;
import com.fmt.pmp.fmtPMP.Model.Discipline;
@Service
public class DisciplineServiceImp implements DisciplineService{

	@Autowired
	private DisciplineDAO DisciplineDAO;
	@Override
	public Discipline getDisciplineById(int DisciplineId) {
		Discipline obj = DisciplineDAO.getDisciplineById(DisciplineId);
		return obj;
	}	
	@Override
	public List<Discipline> getAllDisciplines(){
		return DisciplineDAO.getAllDisciplines();
	}
	@Override
	public synchronized boolean createDiscipline(Discipline Discipline){
       if (DisciplineDAO.DisciplineExists(Discipline.getLabel())) {
    	   return false;
       } else {
    	   DisciplineDAO.createDiscipline(Discipline);
    	   return true;
       }
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
