package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.Model.Itemtextes;

@Transactional
@Repository
public class ItemtextesDAOImp implements ItemtextesDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Itemtextes getItemtextesById(int ItemtextesId) {
		return entityManager.find(Itemtextes.class, ItemtextesId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Itemtextes> getAllItemtextess() {
		String hql = "FROM Itemtextes as dspl ORDER BY dspl.id_item_texte DESC";
		return (List<Itemtextes>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Itemtextes createItemtextes(Itemtextes Itemtextes) {
		Itemtextes dbTransaction = entityManager.merge(Itemtextes);
		Itemtextes.setId_item_texte(dbTransaction.getId_item_texte());
		return Itemtextes;
	}

	@Override
	public void updateItemtextes(Itemtextes Itemtextes) {
		Itemtextes artcl = getItemtextesById(Itemtextes.getId_item_texte());
		artcl.setOrdrecreationtexte(Itemtextes.getOrdrecreationtexte());
		entityManager.flush();
	}

	@Override
	public void deleteItemtextes(int ItemtextesId) {
		entityManager.remove(getItemtextesById(ItemtextesId));
	}

}
