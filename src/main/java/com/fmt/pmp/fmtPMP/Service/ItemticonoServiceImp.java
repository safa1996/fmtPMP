package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.DAO.ItemticonoDAO;
import com.fmt.pmp.fmtPMP.Model.Itemticono;

@Service
public class ItemticonoServiceImp implements ItemticonoService {
	@Autowired
	private ItemticonoDAO ItemticonoDAO;

	@Override
	public Itemticono getItemticonoById(int ItemticonoId) {
		Itemticono obj = ItemticonoDAO.getItemticonoById(ItemticonoId);
		return obj;
	}

	@Override
	public List<Itemticono> getAllItemticonos() {
		return ItemticonoDAO.getAllItemticonos();
	}

	@Override
	@Transactional
	public Itemticono createItemticono(Itemticono Itemticono) {
		return ItemticonoDAO.createItemticono(Itemticono);
	}

	@Override
	public void updateItemticono(Itemticono Itemticono) {
		ItemticonoDAO.updateItemticono(Itemticono);
	}

	@Override
	public void deleteItemticono(int ItemticonoId) {
		ItemticonoDAO.deleteItemticono(ItemticonoId);
	}

	@Override
	public List<Itemticono> getItemIconoByPmp(int pmp) {
		return ItemticonoDAO.getItemIconoByPmp(pmp);
	}
}
