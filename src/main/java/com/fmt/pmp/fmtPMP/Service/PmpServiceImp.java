package com.fmt.pmp.fmtPMP.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.DAO.PmpDAO;
import com.fmt.pmp.fmtPMP.Model.Pmp;

@Service
public class PmpServiceImp implements PmpService {
	@Autowired
	private PmpDAO PmpDAO;

	@Override
	public Pmp getPmpById(int PmpId) {
		Pmp obj = PmpDAO.getPmpById(PmpId);
		return obj;
	}

	@Override
	public List<Pmp> getAllPmps() {
		return PmpDAO.getAllPmps();
	}

	@Override
	@Transactional
	public Pmp createPmp(Pmp Pmp) {
		return PmpDAO.createPmp(Pmp);
	}

	@Override
	public void updatePmp(Pmp Pmp) {
		PmpDAO.updatePmp(Pmp);
	}

	@Override
	public void deletePmp(int PmpId) {
		PmpDAO.deletePmp(PmpId);
	}

	@Override
	public Map<String, Object> getItemsByPmp(int id) {
		return PmpDAO.getItemsByPmp(id);
	}
}
