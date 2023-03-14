package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.Model.Itemticono;
import com.fmt.pmp.fmtPMP.Model.Pmp;
import com.fmt.pmp.fmtPMP.utils.PmpHelper;

@Transactional
@Repository
public class ItemticonoDAOImp implements ItemticonoDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Itemticono getItemticonoById(int ItemticonoId) {
		return entityManager.find(Itemticono.class, ItemticonoId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Itemticono> getAllItemticonos() {
		String hql = "FROM Itemticono as dspl ORDER BY dspl.id DESC";
		return (List<Itemticono>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Itemticono createItemticono(Itemticono Itemticono) {
		Itemticono dbTransaction = entityManager.merge(Itemticono);
		Itemticono.setId(dbTransaction.getId());
		return Itemticono;
	}

	@Override
	public void updateItemticono(Itemticono Itemticono) {
		Itemticono artcl = getItemticonoById(Itemticono.getId());
		artcl.setOrdrecreationicono(Itemticono.getOrdrecreationicono());
		entityManager.flush();
	}

	@Override
	public void deleteItemticono(int ItemticonoId) {
		entityManager.remove(getItemticonoById(ItemticonoId));
	}

	@Override
	public List<Itemticono> getItemIconoByPmp(int id) {
		Pmp pmp = PmpHelper.getPmpById(id, entityManager);
		if (null != pmp) {
			List<Itemticono> itemIcono = getAllItemticonos();
			return PmpHelper.itemIconoByPmp(itemIcono, pmp);
		}
		return null;
	}

}
