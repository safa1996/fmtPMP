package com.fmt.pmp.fmtPMP.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fmt.pmp.fmtPMP.DAO.TemplateDocumentDAO;
import com.fmt.pmp.fmtPMP.Model.TemplateDocument;

public class TemplateDocumentServiceImp implements TemplateDocumentService {
	@Autowired
	private TemplateDocumentDAO templateDocument;

	@Override
	public TemplateDocument getTemplateDocumentById(int TemplateDocumentId) {
		return templateDocument.getPmpById(TemplateDocumentId);
	}

	@Override
	public TemplateDocument createTemplateDocument(TemplateDocument TemplateDocument) {
		return templateDocument.createPmp(TemplateDocument);
	}

}
