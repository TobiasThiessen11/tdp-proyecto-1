package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField LU_text;
	private JTextField Apellido_text;
	private JTextField Nombre_text;
	private JTextField Emal_text;
	private JTextField Git_text;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 212);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		
		LU_text = new JTextField();
		LU_text.setToolTipText("Muestra el LU del alumno");
		LU_text.setEditable(false);
		LU_text.setText(String.valueOf(studentData.getId()));
		LU_text.setBounds(90, 7, 267, 19);
		tabInformation.add(LU_text);
		LU_text.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("LU");
		lblNewLabel.setBounds(15, 10, 45, 13);
		tabInformation.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 0, 7, 19);
		tabInformation.add(textPane);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(15, 40, 73, 13);
		tabInformation.add(lblApellido);
		
		Apellido_text = new JTextField();
		Apellido_text.setToolTipText("Apellido del alumno");
		Apellido_text.setText(studentData.getLastName());
		Apellido_text.setEditable(false);
		Apellido_text.setColumns(10);
		Apellido_text.setBounds(90, 36, 267, 19);
		tabInformation.add(Apellido_text);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 70, 45, 13);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(15, 100, 45, 13);
		tabInformation.add(lblEmail);
		
		Nombre_text = new JTextField();
		Nombre_text.setEditable(false);
		Nombre_text.setText(studentData.getFirstName());
		Nombre_text.setToolTipText("Nombre del alumno");
		Nombre_text.setColumns(10);
		Nombre_text.setBounds(90, 67, 267, 19);
		tabInformation.add(Nombre_text);
		
		Emal_text = new JTextField();
		Emal_text.setText(studentData.getMail());
		Emal_text.setEditable(false);
		Emal_text.setToolTipText("E-Mail del alumno");
		Emal_text.setColumns(10);
		Emal_text.setBounds(90, 97, 267, 19);
		tabInformation.add(Emal_text);
		
		JLabel lblGit = new JLabel("Github URL");
		lblGit.setBounds(15, 130, 73, 13);
		tabInformation.add(lblGit);
		
		Git_text = new JTextField();
		Git_text.setEditable(false);
		Git_text.setText(studentData.getGithubURL());
		Git_text.setToolTipText("Github URL del alumno");
		Git_text.setColumns(10);
		Git_text.setBounds(90, 126, 267, 19);
		tabInformation.add(Git_text);
		
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("HH:mm:ss");
		
		JLabel lblNewLabel_1 = new JLabel("Esta area fue generada el " + LocalDate.now()+ " a las : " + dtf.format(LocalDateTime.now()));
		
		lblNewLabel_1.setBounds(15, 162, 357, 13);
		tabInformation.add(lblNewLabel_1);
		contentPane.add(tabbedPane);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(445, 49, 150, 130);
		ImageIcon ico= new ImageIcon(getClass().getResource(studentData.getPathPhoto()));
		ImageIcon img= new ImageIcon(ico.getImage().getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH));
        lblNewLabel_2.setIcon(img);
        contentPane.add(lblNewLabel_2);
	}
}
