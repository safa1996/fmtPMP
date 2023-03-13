package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.Model.Bonus;

@Transactional
@Repository
public class BonusDAOImp implements BonusDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Bonus getBonusById(int BonusId) {
		return entityManager.find(Bonus.class, BonusId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bonus> getAllBonuss() {
		String hql = "FROM Bonus as dspl ORDER BY dspl.Id DESC";
		return (List<Bonus>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Bonus createBonus(Bonus theTransaction) {
		Bonus dbTransaction = entityManager.merge(theTransaction);
		theTransaction.setId(dbTransaction.getId());
		return theTransaction;
	}

	@Override
	public void updateBonus(Bonus Bonus) {
		Bonus artcl = getBonusById(Bonus.getId());
		artcl.setPoids(Bonus.getPoids());
		entityManager.flush();
	}

	@Override
	public void deleteBonus(int BonusId) {
		entityManager.remove(getBonusById(BonusId));
	}
}
