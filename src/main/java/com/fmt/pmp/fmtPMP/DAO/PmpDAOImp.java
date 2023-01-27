package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.Model.Pmp;

@Transactional
@Repository
public class PmpDAOImp implements PmpDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Pmp getPmpById(int PmpId) {
		return entityManager.find(Pmp.class, PmpId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Pmp> getAllPmps() {
		String hql = "FROM Pmp as dspl ORDER BY dspl.Id DESC";
		return (List<Pmp>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createPmp(Pmp Pmp) {
		entityManager.persist(Pmp);
	}
	@Override
	public void updatePmp(Pmp Pmp) {
		Pmp artcl = getPmpById(Pmp.getId());
		artcl.setDescription(Pmp.getDescription());
		artcl.setDate(Pmp.getDate());
		artcl.setTitre(Pmp.getTitre());
		entityManager.flush();
	}
	@Override
	public void deletePmp(int PmpId) {
		entityManager.remove(getPmpById(PmpId));
	}
	@Override
	public boolean PmpExists(String label) {
		String hql = "FROM Pmp as atcl WHERE atcl.description = ?";
		int count = entityManager.createQuery(hql).setParameter(1, label)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
