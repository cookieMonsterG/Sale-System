import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import com.itextpdf.text.*;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class pdfSystem {
    private static String FILE = "practice.pdf";
    static Document document;

    // ====================fonts============================================
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 19,
        Font.BOLD);
    private static Font catFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
        Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
        Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
        Font.BOLD);
    // ======================================================================


   


    public pdfSystem(String path) {
        
        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            addTitle("Sale for unused items");
        }
        catch (Exception e) {
            
            e.printStackTrace();
        }
       
    }

    public Document getDoc() {
        return document;
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(
        String title,
        String subject,
        String key,
        String author,
        String creator) {
        document.addTitle(title);
        document.addSubject(subject);
        document.addKeywords(key);
        document.addAuthor(author);
        document.addCreator(creator);
    }

    
    @SuppressWarnings("unused")
    private static void addTitle() throws DocumentException {
        addTitle("");
    }

    private static void addTitle(String title) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1); // add an empty line -> more organized
        preface.setAlignment(Element.ALIGN_CENTER);
        preface.add(new Paragraph(title, catFont));
        addEmptyLine(preface, 1);
        document.add(preface);

    }


    /**
     * 
     * @param author
     * @param phone
     * @param email
     * @throws DocumentException
     */
    public void addAuthor(String author, String phone, String email)
        throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1); // add an empty line -> more organized
        preface.add(new Paragraph("Contact name: " + author + "\n" + "Phone: "
            + phone + "\n" + "Email: " + email, catFont2));
        addEmptyLine(preface, 1);
        addEmptyLine(preface, 1);
        document.add(preface);

    }
    
    /**
     * 
     * @param author
     * @param phone
     * @param email
     * @param wechat
     * @throws DocumentException
     */
    @SuppressWarnings("unused")
    private static void addAuthor(
        String author,
        String phone,
        String email,
        String wechat)
        throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1); // add an empty line -> more organized
        preface.add(new Paragraph("Contact name: " + author + "\n" + "weChat: "
            + wechat + "\n" + "Phone: " + phone + "\n" + "Email: " + email,
            catFont2));
        addEmptyLine(preface, 1);
        document.add(preface);
        document.newPage();
    }


    public static PdfPTable createTable(int numCells) throws DocumentException {
        PdfPTable table = new PdfPTable(numCells);
        PdfPCell c1 = new PdfPCell(new Phrase("Item Picture"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Item Description"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setWidthPercentage(100);
        return table;
    }
    
    
    public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
        Image img = Image.getInstance(path);
        img.scaleToFit(150, 150);
        PdfPCell cell = new PdfPCell(img, true);
        return cell;
    }
    
    static PdfPCell createDescription(String text) {
        Phrase ph = new Phrase(text + "\n");
        PdfPCell cell = new PdfPCell(ph);
        return cell;
    }
    /**
     * This method helps adding certain number of lines
     * @param paragraph
     * @param number 
     */
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
