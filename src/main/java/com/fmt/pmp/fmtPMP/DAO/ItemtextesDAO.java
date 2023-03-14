package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Itemtextes;

public interface ItemtextesDAO {
	List<Itemtextes> getAllItemtextess();

	Itemtextes getItemtextesById(int ItemtextesId);

	Itemtextes createItemtextes(Itemtextes Itemtextes);

	void updateItemtextes(Itemtextes Itemtextes);

	void deleteItemtextes(int ItemtextesId);
	
	List<Itemtextes> getItemtextesByPmp(int pmp);
}
