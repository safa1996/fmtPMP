package com.fmt.pmp.fmtPMP.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fmt.pmp.fmtPMP.Export.UserPDFExporter;
import com.fmt.pmp.fmtPMP.Service.UserServices;

@Controller
public class ExportController {

	@Autowired
	private UserServices service;

	@GetMapping(value = "/users/export/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public void employeeDetailsReport(HttpServletResponse response) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String fileType = "attachment; filename=Users_details_" + dateFormat.format(new Date()) + ".pdf";
		response.setHeader("Content-Disposition", fileType);
		UserPDFExporter userExport = new UserPDFExporter(service.listAll());

		userExport.export(response);
	}
}
