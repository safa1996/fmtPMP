package com.fmt.pmp.fmtPMP.Export;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fmt.pmp.fmtPMP.Model.User;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class UserPDFExporter {
	private List<User> listUsers;

	public UserPDFExporter(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public String getNameRole(User user) {
		StringBuilder sbRoles = new StringBuilder();
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		for (GrantedAuthority grantedAuthority : authorities) {
			sbRoles.append(grantedAuthority.toString());
			sbRoles.append(" ");
		}
		return sbRoles.toString();
	}

	public void export(HttpServletResponse response) throws IOException {
		PdfWriter writer = new PdfWriter(response.getOutputStream());
		PdfDocument pdfDocument;
		pdfDocument = new PdfDocument(writer);
		Document document = new Document(pdfDocument);

		try {
			document.add(new Paragraph("Paragraph test").setBold().setPaddingLeft(200f));

			Table table = new Table(new float[] { 20f, 50f, 30F });
			table.setWidthPercent(100).setPadding(0).setFontSize(9);

			Cell cell1 = new Cell(1, 3);
			cell1.setTextAlignment(TextAlignment.CENTER);
			cell1.add("User Details").setBold();
			table.addCell(cell1);

			table.addCell(new Cell().add("Id").setBold());
			table.addCell(new Cell().add("Name").setBold());
			table.addCell(new Cell().add("Role").setBold());

			for (User user : listUsers) {
				table.addCell(new Cell().add(String.valueOf(user.getId())));
				table.addCell(new Cell().add(user.getName()));
				table.addCell(new Cell().add(getNameRole(user)));
			}

			document.add(table);

			document.close();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}