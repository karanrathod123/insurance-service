package com.hcl.insurance.utills;

import com.hcl.insurance.dto.PolicyReport;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class GeneratePdfReport {

	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

	public static ByteArrayInputStream userPolicyReport(List<PolicyReport> policyReport) {

		Document document = new Document(PageSize.A4);
		Paragraph paragraph = new Paragraph("HCL Insurance Services");
		paragraph.setAlignment(Element.ALIGN_CENTER);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			
			PdfPTable table = new PdfPTable(10);
			table.setWidthPercentage(100);
			table.setWidths(new int[] { 10, 10, 20, 10, 12, 10, 12, 15, 15, 20 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.BLUE);
			Font cellFont = FontFactory.getFont(FontFactory.COURIER, 9, BaseColor.BLACK);
			Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, BaseColor.DARK_GRAY);

			paragraph.setFont(headingFont);
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Booking Id", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Policy Id", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Policy Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Age Limit", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Sum Assured", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Policy Term", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Yearly Premium", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Booking Date", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Maturity Date", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Nominee", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			for (PolicyReport policy : policyReport) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(policy.getBookingId().toString(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getPolicyId().toString(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getPolicyName(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getAgeLimit().toString(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getSumAssured().toString(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getPolicyTerm().toString(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getYearlyPremium().toString(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getBookingDate().toString(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getMaturityDate().toString(),cellFont));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(policy.getNominee(),cellFont));
				table.addCell(cell);
			}

			PdfWriter.getInstance(document, out);
			document.open();
			document.add(paragraph);
			document.add(new Paragraph("   "));
			document.add(table);

			document.close();

		} catch (DocumentException ex) {

			logger.error("Error occurred: {0}", ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}