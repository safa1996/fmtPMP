package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Reponse;

public interface ReponseService {
	 List<Reponse> getAllReponses();
	    Reponse getReponseById(int ReponseId);
	    Reponse createReponse(Reponse Reponse);
	    void updateReponse(Reponse Reponse);
	    void deleteReponse(int ReponseId);
}
