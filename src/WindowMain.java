import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.itextpdf.text.DocumentException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class WindowMain extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    static pdfSystem pdf;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    WindowMain frame = new WindowMain();
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
     */
    public WindowMain() {
        pdf = new pdfSystem("saleslist.pdf");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 264);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Sale PDF-Window");
        lblNewLabel.setBounds(5, 5, 693, 16);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);

        JLabel lblName = new JLabel("NAME:");
        lblName.setBounds(178, 73, 61, 16);
        contentPane.add(lblName);

        JLabel lblNewLabel_1 = new JLabel("PHONE NUM:");
        lblNewLabel_1.setBounds(139, 101, 88, 16);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(228, 68, 296, 26);
        contentPane.add(textField);
        textField.setColumns(10);
        String name = textField.getText();

        textField_1 = new JTextField();
        textField_1.setBounds(228, 96, 296, 26);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        String phone = textField_1.getText();

        JLabel lblGmail = new JLabel("E-MAIL:");
        lblGmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblGmail.setBounds(159, 129, 73, 16);
        contentPane.add(lblGmail);

        textField_2 = new JTextField();
        textField_2.setBounds(228, 124, 296, 26);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        String mail = textField_2.getText();

        JButton btnNewButton = new JButton("Quit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnNewButton.setBounds(385, 178, 117, 29);
        contentPane.add(btnNewButton);

        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                WindowPDFMaker.newScreen(textField.getText(), textField_1
                    .getText(), textField_2.getText(), pdf);
                

            }
        });
        btnNext.setBounds(244, 178, 117, 29);
        contentPane.add(btnNext);
    }

}
