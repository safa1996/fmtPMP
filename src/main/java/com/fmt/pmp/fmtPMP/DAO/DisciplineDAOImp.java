package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.Model.Discipline;

@Transactional
@Repository
public class DisciplineDAOImp implements DisciplineDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Discipline getDisciplineById(int DisciplineId) {
		return entityManager.find(Discipline.class, DisciplineId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Discipline> getAllDisciplines() {
		String hql = "FROM Discipline as dspl ORDER BY dspl.Id DESC";
		return (List<Discipline>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createDiscipline(Discipline Discipline) {
		entityManager.persist(Discipline);
	}
	@Override
	public void updateDiscipline(Discipline Discipline) {
		Discipline artcl = getDisciplineById(Discipline.getId());
		artcl.setLabel(Discipline.getLabel());
		entityManager.flush();
	}
	@Override
	public void deleteDiscipline(int DisciplineId) {
		entityManager.remove(getDisciplineById(DisciplineId));
	}
	@Override
	public boolean DisciplineExists(String label) {
		String hql = "FROM Discipline as atcl WHERE atcl.label = ?";
		int count = entityManager.createQuery(hql).setParameter(1, label)
		              .getResultList().size();
		return count > 0 ? true : false;
	}

}
