package com.fmt.pmp.fmtPMP.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fmt.pmp.fmtPMP.Export.ResultatExport;
import com.fmt.pmp.fmtPMP.Export.UserPDFExporter;
import com.fmt.pmp.fmtPMP.Model.TemplateDocument;
import com.fmt.pmp.fmtPMP.Service.PmpService;
import com.fmt.pmp.fmtPMP.Service.TemplateDocumentService;
import com.fmt.pmp.fmtPMP.Service.UserServices;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

@Controller
public class ExportController {

	@Autowired
	private UserServices service;
	@Autowired
	private TemplateDocumentService templateDocService;
	@Autowired
	private PmpService pmpService;

	@GetMapping(value = "/users/export/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public void employeeDetailsReport(HttpServletResponse response) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String fileType = "attachment; filename=Users_details_" + dateFormat.format(new Date()) + ".pdf";
		response.setHeader("Content-Disposition", fileType);
		UserPDFExporter userExport = new UserPDFExporter(service.listAll());

		userExport.export(response);
	}

	@GetMapping(value = "/users/export/pdfFromTemplate", produces = MediaType.APPLICATION_PDF_VALUE)
	public void pdfFromTemplate(@RequestParam("id") int id, HttpServletResponse response) throws IOException {
		TemplateDocument templateDocument = templateDocService.getTemplateDocumentById(id);

		ResultatExport resultatExport = new ResultatExport(pmpService.getPmpById(id));
		try {
			generatePdf(resultatExport, templateDocument);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
	}

	public void generatePdf(ResultatExport data, TemplateDocument templateDocument)
			throws IOException, XDocReportException {
		InputStream template = getClass().getResourceAsStream(templateDocument.getAttachment().toString());
		IXDocReport report = XDocReportRegistry.getRegistry().loadReport(template, TemplateEngineKind.Velocity);

		IContext context = report.createContext();
		context.put("dateJourFormate", data.getDateJourFormate());
		context.put("titre", data.getTitre());
		context.put("description", data.getDescription());

		OutputStream out = new FileOutputStream("output.pdf");
		Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF);
		report.convert(context, options, out);
	}
}
