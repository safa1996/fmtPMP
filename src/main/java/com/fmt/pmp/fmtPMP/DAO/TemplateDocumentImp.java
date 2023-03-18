package com.fmt.pmp.fmtPMP.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fmt.pmp.fmtPMP.Model.TemplateDocument;

public class TemplateDocumentImp implements TemplateDocumentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TemplateDocument getPmpById(int TemplateDocumentId) {
		return entityManager.find(TemplateDocument.class, TemplateDocumentId);
	}

	@Override
	public TemplateDocument createPmp(TemplateDocument template) {
		TemplateDocument dbTransaction = entityManager.merge(template);
		template.setId(dbTransaction.getId());
		template.setAttachment(dbTransaction.getAttachment());
		template.setName(dbTransaction.getName());
		return template;
	}

}
