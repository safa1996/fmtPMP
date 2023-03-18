package com.fmt.pmp.fmtPMP.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fmt.pmp.fmtPMP.Model.Itemtextes;
import com.fmt.pmp.fmtPMP.Model.Itemticono;
import com.fmt.pmp.fmtPMP.Model.Pmp;

public class PmpHelper {
	public static Pmp getPmpById(int id, EntityManager em) {
		return em.find(Pmp.class, id);
	}

	public static List<Itemticono> itemIconoByPmp(List<Itemticono> itemIcono, Pmp pmp) {
		return itemIcono.stream().filter(i -> i.getPmp().equals(pmp)).collect(Collectors.toList());
	}

	public static List<Itemtextes> itemtextesByPmp(List<Itemtextes> itemtext, Pmp pmp) {
		return itemtext.stream().filter(i -> i.getPmp().equals(pmp)).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public static List<Itemticono> getItemIcono(Pmp pmp, EntityManager em) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT item FROM ");
		jpql.append(Itemticono.class.getName() + " as item  ");
		jpql.append(" where item.pmp = :argPmp ORDER BY item.ordrecreationicono DESC ");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("argPmp", pmp);
		return (List<Itemticono>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Itemtextes> getItemTexts(Pmp pmp, EntityManager em) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT item FROM ");
		jpql.append(Itemtextes.class.getName() + " as item  ");
		jpql.append(" where item.pmp in :argPmp ORDER BY item.ordrecreationtexte DESC ");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("argPmp", pmp);
		return (List<Itemtextes>) query.getResultList();
	}

}
