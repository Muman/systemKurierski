/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.muciek.systemkurierski.models.Shipment;
import java.io.IOException;

/**
 *
 * @author Muman
 */
public class PdfDocumentView extends AbstractItextPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document document,
            PdfWriter writer, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Shipment shipment = (Shipment) model.get("shipment");

        PdfPTable table = buildShipmentDocument(shipment);

        Paragraph paragraph = new Paragraph("NALEPKA ADRESPWA / ODCINEK DLA ADRESATA");

        document.add(table);
    }

    private PdfPCell buildRecipientSection(Shipment shipment) {
        PdfPCell recipientCell = new PdfPCell();
        recipientCell.setFixedHeight(144f);

        Paragraph senderParagraph = new Paragraph("Adresat:");

        Paragraph phoneNumberParagraph = new Paragraph();
        Chunk phoneNumberLAbelChunk = new Chunk("\nNr. tel. ");
        Chunk phoneNumberChunk = new Chunk("123123123");
        phoneNumberParagraph.add(phoneNumberLAbelChunk);
        phoneNumberParagraph.add(phoneNumberChunk);
        phoneNumberParagraph.setAlignment(Element.ALIGN_CENTER);

//        Paragraph senderNameParagraph = new Paragraph(shipment.getUser().getUserInfo().getFirstName());
        Paragraph recipientNameParagraph = new Paragraph("Tutaj imie i nazwisko");
        recipientNameParagraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph recipientCompanyNameParagraph = new Paragraph("Tutaj nazwa firmy");
        recipientCompanyNameParagraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph recipientAddressParagraph = new Paragraph("Tutaj adres");
        recipientAddressParagraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph recipientCityPostalCode = new Paragraph("postal code city");
        recipientCityPostalCode.setAlignment(Element.ALIGN_CENTER);

        recipientCell.addElement(senderParagraph);
        recipientCell.addElement(phoneNumberParagraph);
        recipientCell.addElement(recipientNameParagraph);
        recipientCell.addElement(recipientCompanyNameParagraph);
        recipientCell.addElement(recipientAddressParagraph);
        recipientCell.addElement(recipientCityPostalCode);
        recipientCell.setHorizontalAlignment(Element.ALIGN_CENTER);

        return recipientCell;
    }

    private PdfPCell buildBarCodeSection(Shipment shipment) throws JsonProcessingException, BadElementException {
        PdfPCell barcodeSection = new PdfPCell();

        ObjectMapper mapper = new ObjectMapper();
        String jsonOfShipment = mapper.writeValueAsString(shipment);
//                String.valueOf(shipment.getId())
        BarcodeQRCode qrCode = new BarcodeQRCode(jsonOfShipment, 1, 1, null);
        
        
        Image qrImage = qrCode.getImage();
        barcodeSection.addElement(qrImage);
        barcodeSection.setHorizontalAlignment(Element.ALIGN_CENTER);

        return barcodeSection;
    }

    private PdfPTable buildShipmentDocument(Shipment shipment) throws JsonProcessingException, BadElementException, IOException {
        PdfPTable table = new PdfPTable(2);

        PdfPCell recipientSection = buildRecipientSection(shipment);
        PdfPCell barCodeSection = buildBarCodeSection(shipment);
        PdfPCell senderSection = buildSenderSection(shipment);
        PdfPCell additionalInfoSection = buildAdditionalInfoSection(shipment);

        table.addCell(senderSection);
        table.addCell(barCodeSection);
        table.addCell(additionalInfoSection);
        table.addCell(recipientSection);

        return table;
    }

    private PdfPCell buildSenderSection(Shipment shipment) {
        PdfPCell senderCell = new PdfPCell();
        senderCell.setFixedHeight(144f);

        Paragraph senderParagraph = new Paragraph("Nadawca:");

        Paragraph phoneNumberParagraph = new Paragraph();
        Chunk phoneNumberLAbelChunk = new Chunk("\nNr. tel. ");
        Chunk phoneNumberChunk = new Chunk("123123123");
        phoneNumberParagraph.add(phoneNumberLAbelChunk);
        phoneNumberParagraph.add(phoneNumberChunk);
        phoneNumberParagraph.setAlignment(Element.ALIGN_CENTER);

//        Paragraph senderNameParagraph = new Paragraph(shipment.getUser().getUserInfo().getFirstName());
        Paragraph senderNameParagraph = new Paragraph("Tutaj imie i nazwisko");
        senderNameParagraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph senderCompanyNameParagraph = new Paragraph("Tutaj nazwa firmy");
        senderCompanyNameParagraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph senderAddressParagraph = new Paragraph("Tutaj adres");
        senderAddressParagraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph senderCityPostalCode = new Paragraph("postal code city");
        senderCityPostalCode.setAlignment(Element.ALIGN_CENTER);

        senderCell.addElement(senderParagraph);
        senderCell.addElement(phoneNumberParagraph);
        senderCell.addElement(senderNameParagraph);
        senderCell.addElement(senderCompanyNameParagraph);
        senderCell.addElement(senderAddressParagraph);
        senderCell.addElement(senderCityPostalCode);

        return senderCell;
    }

    private PdfPCell buildAdditionalInfoSection(Shipment shipment) throws BadElementException, IOException {
        PdfPCell additionalnfoCell = new PdfPCell();
        additionalnfoCell.setFixedHeight(144f);
        Paragraph senderNameParagraph = new Paragraph("Typ paczki");
        senderNameParagraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph logoParagraph = new Paragraph("Logo KurierX");
        logoParagraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph dateParagraph = new Paragraph("\nNadano dnia 21.01.2014");
        dateParagraph.setAlignment(Element.ALIGN_CENTER);
        //Image image1 = Image.getInstance("resources/img/kurierX.png");
        additionalnfoCell.addElement(senderNameParagraph);
        additionalnfoCell.addElement(dateParagraph);
        //additionalnfoCell.addElement(image1);

        return additionalnfoCell;
    }
}
