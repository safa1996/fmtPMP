package com.fmt.pmp.fmtPMP.Service;

import com.fmt.pmp.fmtPMP.Model.TemplateDocument;

public interface TemplateDocumentService {
	TemplateDocument getTemplateDocumentById(int TemplateDocumentId);
	TemplateDocument createTemplateDocument(TemplateDocument TemplateDocument);
}
