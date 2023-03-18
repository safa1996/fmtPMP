package com.fmt.pmp.fmtPMP.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fmt.pmp.fmtPMP.Model.Pmp;

public interface PmpService {
	 	List<Pmp> getAllPmps();
	    Pmp getPmpById(int PmpId);
	    Pmp createPmp(Pmp Pmp);
	    void updatePmp(Pmp Pmp);
	    void deletePmp(int PmpId);
	    LinkedHashMap<Integer, Map<String, Object>> getItemsByPmp(int id);
}
