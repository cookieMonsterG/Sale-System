import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class WindowPDFMaker extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    public static String pathway;


    /**
     * Launch the application.
     */
    public static void newScreen(
        String name,
        String phone,
        String email,
        pdfSystem pdf) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WindowPDFMaker frame = new WindowPDFMaker(name, phone,
                        email, pdf);
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     * 
     * @throws DocumentException
     * @throws IOException
     */
    public WindowPDFMaker(
        String name,
        String phone,
        String email,
        pdfSystem pdf)
        throws DocumentException,
        IOException {
        pdf.addAuthor(name,phone,email);
        PdfPTable tb = pdfSystem.createTable(2);
        pdf.getDoc().add(tb);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 626, 509);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(17, 16, 61, 16);
        contentPane.add(lblName);

        JLabel label_1 = new JLabel(name);
        label_1.setBounds(64, 16, 323, 16);
        contentPane.add(label_1);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(17, 34, 61, 16);
        contentPane.add(lblPhone);

        JLabel lblNewLabel = new JLabel(phone);
        lblNewLabel.setBounds(74, 34, 313, 16);
        contentPane.add(lblNewLabel);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(17, 51, 61, 16);
        contentPane.add(lblEmail);

        JLabel lblNewLabel_1 = new JLabel(email);
        lblNewLabel_1.setBounds(74, 51, 313, 16);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("no file selected");
        lblNewLabel_2.setBounds(112, 316, 174, 16);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(Color.GRAY);
        contentPane.add(lblNewLabel_2);

        JButton btnAddPicture = new JButton("Add Picture ");
        btnAddPicture.setBounds(146, 287, 137, 29);

        btnAddPicture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                OpenFile of = new OpenFile();

                try {
                    pathway = of.pickMe();
                    lblNewLabel_2.setText(pathway);
                    lblNewLabel_2.setForeground(Color.GRAY);
                    table.addCell(pdfSystem.createImageCell(pathway));

                }
                catch (Exception ex) {
                    lblNewLabel_2.setText("Not a good size of picture");
                    lblNewLabel_2.setForeground(Color.RED);
                }

            }
        });
        contentPane.add(btnAddPicture);

        JButton btnAddDescription = new JButton("Add Description");
        btnAddDescription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.addCell(pdf.createDescription("Item Name: " + textField
                    .getText() + "\n" + "Item Url: " + textField_2.getText()
                    + "\n" + "Ori. Price: " + textField_3.getText() + "\n"
                    + "Sale Price: " + textField_4.getText() + "\n" + "Detail: " + textField_1.getText() + "\n"));
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
                lblNewLabel_2.setText("no file selected");
                lblNewLabel_2.setForeground(Color.GRAY);
                try {
                    pdf.document.add(table);
                }
                catch (DocumentException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
        });
        btnAddDescription.setBounds(6, 413, 128, 29);
        contentPane.add(btnAddDescription);

        JLabel lblItemName = new JLabel("Item Name:");
        lblItemName.setBounds(17, 110, 81, 16);
        contentPane.add(lblItemName);

        textField = new JTextField();
        textField.setBounds(95, 105, 196, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblItemDescription = new JLabel("Item Description (50 words):");
        lblItemDescription.setBounds(17, 135, 189, 16);
        contentPane.add(lblItemDescription);

        textField_1 = new JTextField();
        textField_1.setBounds(6, 152, 286, 100);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblUrloptional = new JLabel("Url (optional) :");
        lblUrloptional.setBounds(17, 264, 96, 16);
        contentPane.add(lblUrloptional);

        textField_2 = new JTextField();
        textField_2.setBounds(112, 259, 179, 26);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblPicture = new JLabel("Picture");
        lblPicture.setBounds(372, 16, 96, 16);
        lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblPicture);

        JLabel lblName_1 = new JLabel("Name");
        lblName_1.setBounds(480, 16, 128, 16);
        lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblName_1);

        JLabel lblAddPictureoptinal = new JLabel("add picture (optional)");
        lblAddPictureoptinal.setBounds(17, 292, 137, 16);
        contentPane.add(lblAddPictureoptinal);

        JLabel lblOriPrice = new JLabel("Ori. Price");
        lblOriPrice.setBounds(17, 344, 61, 16);
        contentPane.add(lblOriPrice);

        textField_3 = new JTextField();
        textField_3.setBounds(75, 339, 216, 26);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblSalePrice = new JLabel("Sale Price");
        lblSalePrice.setBounds(17, 372, 61, 16);
        contentPane.add(lblSalePrice);

        textField_4 = new JTextField();
        textField_4.setBounds(76, 367, 215, 26);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        
        JButton btnFinish = new JButton("Finish");
        btnFinish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pdf.document.close();
            }
        });
        btnFinish.setBounds(147, 413, 117, 29);
        contentPane.add(btnFinish);

    }
}
