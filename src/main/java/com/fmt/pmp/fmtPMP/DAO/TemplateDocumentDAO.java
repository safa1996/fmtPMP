package com.fmt.pmp.fmtPMP.DAO;

import com.fmt.pmp.fmtPMP.Model.TemplateDocument;

public interface TemplateDocumentDAO {
	TemplateDocument getPmpById(int TemplateDocumentId);

	TemplateDocument createPmp(TemplateDocument Pmp);
}
