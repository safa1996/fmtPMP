package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.DAO.ReponseDAO;
import com.fmt.pmp.fmtPMP.Model.Reponse;

@Service
public class ReponseServiceImp implements ReponseService {
	@Autowired
	private ReponseDAO ReponseDAO;

	@Override
	public Reponse getReponseById(int ReponseId) {
		Reponse obj = ReponseDAO.getReponseById(ReponseId);
		return obj;
	}

	@Override
	public List<Reponse> getAllReponses() {
		return ReponseDAO.getAllReponses();
	}

	@Override
	@Transactional
	public Reponse createReponse(Reponse theTransaction) {
		return ReponseDAO.createReponse(theTransaction);
	}

	@Override
	public void updateReponse(Reponse Reponse) {
		ReponseDAO.updateReponse(Reponse);
	}

	@Override
	public void deleteReponse(int ReponseId) {
		ReponseDAO.deleteReponse(ReponseId);
	}
}
