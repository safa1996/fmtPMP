package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.DAO.ItemtextesDAO;
import com.fmt.pmp.fmtPMP.Model.Itemtextes;

@Service
public class ItemtextesServiceImp implements ItemtextesService {
	@Autowired
	private ItemtextesDAO ItemtextesDAO;

	@Override
	public Itemtextes getItemtextesById(int ItemtextesId) {
		Itemtextes obj = ItemtextesDAO.getItemtextesById(ItemtextesId);
		return obj;
	}

	@Override
	public List<Itemtextes> getAllItemtextess() {
		return ItemtextesDAO.getAllItemtextess();
	}

	@Override
	@Transactional
	public Itemtextes createItemtextes(Itemtextes Itemtextes) {
		return ItemtextesDAO.createItemtextes(Itemtextes);
	}

	@Override
	public void updateItemtextes(Itemtextes Itemtextes) {
		ItemtextesDAO.updateItemtextes(Itemtextes);
	}

	@Override
	public void deleteItemtextes(int ItemtextesId) {
		ItemtextesDAO.deleteItemtextes(ItemtextesId);
	}
}
