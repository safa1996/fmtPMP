package com.fmt.pmp.fmtPMP.DAO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.Model.Itemtextes;
import com.fmt.pmp.fmtPMP.Model.Itemticono;
import com.fmt.pmp.fmtPMP.Model.Pmp;
import com.fmt.pmp.fmtPMP.utils.PmpHelper;

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
	public Pmp createPmp(Pmp Pmp) {
		Pmp dbTransaction = entityManager.merge(Pmp);
		Pmp.setId(dbTransaction.getId());
		return Pmp;
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
	public Map<String, Object> getItemsByPmp(int id) {
		LinkedHashMap<String, Object> itemsBypmpMap = new LinkedHashMap<String, Object>();
		List<Object> items = new ArrayList<>();
		Pmp pmp = getPmpById(id);
		List<Itemticono> itemsIcono = PmpHelper.getItemIcono(pmp, entityManager);
		List<Itemtextes> itemsTexts = PmpHelper.getItemTexts(pmp, entityManager);
		items.addAll(itemsIcono);
		items.addAll(itemsTexts);
		int pos;
		Object temp;
		for (int i = 0; i < items.size(); i++) {
			pos = i;
			for (int j = i + 1; j < items.size(); j++) {
				int nbJ = getOrdre(items, j);
				int nbI = getOrdre(items, i);

				if (nbJ < nbI) // find the index of the minimum element
				{
					pos = j;
				}
			}

			temp = items.get(pos); // swap the current element with the minimum element
			items.set(pos, items.get(i));
			items.set(i, temp);
		}
		int i = 0;
		for (Object item : items) {
			if (item instanceof Itemticono) {
				itemsBypmpMap.put("iconoElement" + i, item);
			} else {
				itemsBypmpMap.put("TextElement" + i, item);
			}
			i++;
		}
		return itemsBypmpMap;
	}

	private int getOrdre(List<Object> items, int j) {
		if (items.get(j) instanceof Itemticono) {
			return ((Itemticono) items.get(j)).getOrdrecreationicono();
		} else {
			return ((Itemtextes) items.get(j)).getOrdrecreationtexte();
		}
	}

}
