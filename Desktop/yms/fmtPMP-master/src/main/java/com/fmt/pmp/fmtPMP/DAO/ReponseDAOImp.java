package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.Model.Reponse;

@Transactional
@Repository
public class ReponseDAOImp implements ReponseDAO{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Reponse getReponseById(int ReponseId) {
		return entityManager.find(Reponse.class, ReponseId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reponse> getAllReponses() {
		String hql = "FROM Reponse as dspl ORDER BY dspl.Id DESC";
		return (List<Reponse>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Reponse createReponse(Reponse theTransaction) {
		Reponse dbTransaction = entityManager.merge(theTransaction);
		theTransaction.setId(dbTransaction.getId());
		return theTransaction;
	}

	@Override
	public void updateReponse(Reponse Reponse) {
		Reponse artcl = getReponseById(Reponse.getId());
		artcl.setOrdre(Reponse.getOrdre());
		entityManager.flush();
	}

	@Override
	public void deleteReponse(int ReponseId) {
		entityManager.remove(getReponseById(ReponseId));
	}
}
