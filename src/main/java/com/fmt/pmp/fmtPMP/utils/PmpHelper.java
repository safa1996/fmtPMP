package com.fmt.pmp.fmtPMP.utils;

import javax.persistence.EntityManager;

import com.fmt.pmp.fmtPMP.Model.Pmp;

public class PmpHelper {
	public static Pmp getPmpById(int id, EntityManager em) {
		return em.find(Pmp.class, id);
	}
}
