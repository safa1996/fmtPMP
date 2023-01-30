package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Reponse;

public interface ReponseDAO {
	List<Reponse> getAllReponses();

	Reponse getReponseById(int ReponseId);

	Reponse createReponse(Reponse Reponse);

	void updateReponse(Reponse Reponse);

	void deleteReponse(int ReponseId);
}
