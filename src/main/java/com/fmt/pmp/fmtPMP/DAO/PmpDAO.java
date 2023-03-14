package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;
import java.util.Map;

import com.fmt.pmp.fmtPMP.Model.Pmp;

public interface PmpDAO {
	List<Pmp> getAllPmps();

	Pmp getPmpById(int PmpId);

	Pmp createPmp(Pmp Pmp);

	void updatePmp(Pmp Pmp);

	void deletePmp(int PmpId);
	
	Map<String, Object> getItemsByPmp(int id);

}
