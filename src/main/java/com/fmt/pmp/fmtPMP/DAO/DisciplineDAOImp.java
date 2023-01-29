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
	public Discipline createDiscipline(Discipline theTransaction) {
		Discipline dbTransaction = entityManager.merge(theTransaction);
		theTransaction.setId(dbTransaction.getId());
		return theTransaction;
	}

	@Override
	public void updateDiscipline(Discipline Discipline) {
		Discipline artcl = getDisciplineById(Discipline.getId());
		artcl.setTheme(Discipline.getTheme());
		entityManager.flush();
	}

	@Override
	public void deleteDiscipline(int DisciplineId) {
		entityManager.remove(getDisciplineById(DisciplineId));
	}

}
