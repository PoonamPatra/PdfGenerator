package com.example.PdfGenerator.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.PdfGenerator.service.PdfGeneratorService;

@Controller
public class PdfExportController {

	private final PdfGeneratorService pdfGeneratorService;

	public PdfExportController(PdfGeneratorService pdfGeneratorService) {
		this.pdfGeneratorService = pdfGeneratorService;

	}

	@GetMapping("/pdf/generate")
	public void generatePDF(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		DateFormat dateformatter = new SimpleDateFormat();
		String currentDateTime = dateformatter.format(new Date());
		
		String headerKey = "Content";
		String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		this.pdfGeneratorService.export(response);
		
		
		
	}

}
