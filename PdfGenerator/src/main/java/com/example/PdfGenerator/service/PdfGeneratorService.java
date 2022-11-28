package com.example.PdfGenerator.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;

@Service
public class PdfGeneratorService {
	public void export(HttpServletResponse response) throws IOException{
    Document document = new Document(PageSize.A4);
    PdfWriter.getInstance(document, response.getOutputStream());
      
    document.open();
    Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    fontTitle.setSize(20);
    
    Paragraph paragraph = new Paragraph("Incture", fontTitle);
    paragraph.setAlignment(paragraph.ALIGN_CENTER);
    
    Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
    fontTitle.setSize(15);
    
    Paragraph paragraph2 = new Paragraph("Incture Bhubaneswar", fontTitle);
    paragraph.setAlignment(paragraph.ALIGN_CENTER);
    
    document.add(paragraph);
    document.add(paragraph2);
    document.close();
    
    
    
    
}
}