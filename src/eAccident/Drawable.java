/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

/**
 *
 * @author goodMan
 */
class Drawable {
    
}

/*public void createPdf(String firstName,String lastName,String designation,String Id_no,String gender, String district,String region) throws FileNotFoundException{
        String pdfPath;
        File file = new File(pdfPath, "myPDF.pdf");
        OutputStream outputstream = new FileOutputStream(file);
         
        
         
            PdfWriter writer = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);
            pdfDocument.setDefaultPageSize(PageSize.A6);
            document.setMargins(0, 0, 0, 0);
            
            
         
                /*iMAGE 
                Drawable d = getDrawable(R.drawable.tourising);
                Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
                
         
         Paragraph header1 = new Paragraph("The Republic of Uganda").setBold().setFontSize(24).setTextAlignment(TextAlignment.CENTER);
         Paragraph header2 = new Paragraph("Traffice Police Department\n"+"Government of Uganda").setBold().setFontSize(20).setTextAlignment(TextAlignment.CENTER);
         Paragraph header3 = new Paragraph("Traffic Officer Detail").setBold().setFontSize(18).setTextAlignment(TextAlignment.CENTER);
         
         float[] width = {100f, 100f};
         Table table = new Table(width);
         table.setHorizontalAlignment(HorizontalAlignment.CENTER);
         
         table.addCell(new Cell().add(new Paragraph("First Name")));
         table.addCell(new Cell().add(new Paragraph(firstName)));
         
         table.addCell(new Cell().add(new Paragraph("Last Name")));
         table.addCell(new Cell().add(new Paragraph(lastName)));
         
         table.addCell(new Cell().add(new Paragraph("Gender")));
         table.addCell(new Cell().add(new Paragraph(gender)));
         
         table.addCell(new Cell().add(new Paragraph("Designation")));
         table.addCell(new Cell().add(new Paragraph(designation)));
         
         table.addCell(new Cell().add(new Paragraph("Id Number")));
         table.addCell(new Cell().add(new Paragraph(Id_no)));
         
         table.addCell(new Cell().add(new Paragraph("Region")));
         table.addCell(new Cell().add(new Paragraph(region)));
         
         table.addCell(new Cell().add(new Paragraph("District")));
         table.addCell(new Cell().add(new Paragraph(district)));
         
         DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/mm/yyyy");
         table.addCell(new Cell().add(new Paragraph("Date Generated")));
         table.addCell(new Cell().add(new Paragraph(LocalDate.now().format(date).toString())));
         
         DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss a");
         table.addCell(new Cell().add(new Paragraph("Date Generated")));
         table.addCell(new Cell().add(new Paragraph(LocalTime.now().format(time).toString())));
         
         BarcodeQRCode barcode = new BarcodeQRCode(firstName+"\n"+lastName+"\n"+gender+"\n"+designation+
                 "\n"+Id_no+"\n"+region+"\n"+district+"\n"+LocalDate.now().format(date));
         
         PdfFormXObject qrcodeobject = barcode.createFormXObject(ColorConstants.BLACK, pdfDocument);
         Image qrImage = new Image(qrcodeobject).setWidth(80).setHorizontalAlignment(HorizontalAlignment.CENTER);
         
         document.add(header1);
         document.add(header2);
         document.add(header3);
         document.add(header1);
         document.add(table);
         document.add(qrImage);
         
        //open the file
         if(Desktop.isDesktopSupported()){
             try{
                 File myfile = new File("HitTable.pdf");
             Desktop.getDesktop().open(myfile);
             }catch(IOException ex){
                 //
             }
         }
         
         document.close();
         //Toast.makeText(this, "pdf created", Toast.LENGTH_LONG).show();
         
         
        
   }    

*/