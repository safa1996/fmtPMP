package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Pmp;

public interface PmpDAO {
	List<Pmp> getAllPmps();

	Pmp getPmpById(int PmpId);

	void createPmp(Pmp Pmp);

	void updatePmp(Pmp Pmp);

	void deletePmp(int PmpId);

	boolean PmpExists(String label);
}
