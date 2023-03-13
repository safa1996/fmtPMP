package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Itemticono;

public interface ItemticonoDAO {
	List<Itemticono> getAllItemticonos();

	Itemticono getItemticonoById(int ItemticonoId);

	Itemticono createItemticono(Itemticono Itemticono);

	void updateItemticono(Itemticono Itemticono);

	void deleteItemticono(int ItemticonoId);
}
