package com.fmt.pmp.fmtPMP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.pmp.fmtPMP.Model.TemplateDocument;
import com.fmt.pmp.fmtPMP.Service.TemplateDocumentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class TemplateDocumentController {
	@Autowired
	private TemplateDocumentService templateDocService;
	@GetMapping("Pmp")
	public ResponseEntity<TemplateDocument> getTemplateDocById(@RequestParam("id") String id) {
		TemplateDocument templateDoc = templateDocService.getTemplateDocumentById(Integer.parseInt(id));
		return new ResponseEntity<TemplateDocument>(templateDoc, HttpStatus.OK);
	}
	@RequestMapping(value = "/createTemplate", method = RequestMethod.POST)
	public TemplateDocument createTemplateDoc(@RequestBody TemplateDocument templateDoc) {

		return (templateDocService.createTemplateDocument(templateDoc));
	}
}
