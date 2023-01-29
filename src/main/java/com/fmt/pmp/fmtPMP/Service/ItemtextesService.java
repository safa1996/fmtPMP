package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Itemtextes;

public interface ItemtextesService {
	List<Itemtextes> getAllItemtextess();

	Itemtextes getItemtextesById(int ItemtextesId);

	Itemtextes createItemtextes(Itemtextes Itemtextes);

	void updateItemtextes(Itemtextes Itemtextes);
    void deleteItemtextes(int ItemtextesId);
}
