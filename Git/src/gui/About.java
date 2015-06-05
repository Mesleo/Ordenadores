package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

/**
 * Muestra información sobre el programa Gestión ordenadores
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("Sobre Gestión ordenadores");
		setResizable(false);
		setModal(true);
		setBounds(150, 150, 388, 232);
		
		JTextArea txtrGestinOrdenadoresVersion = new JTextArea();
		txtrGestinOrdenadoresVersion.setForeground(Color.BLACK);
		txtrGestinOrdenadoresVersion.setFont(new Font("SimSun", Font.ITALIC, 13));
		txtrGestinOrdenadoresVersion.setBackground(SystemColor.inactiveCaption);
		txtrGestinOrdenadoresVersion.setEditable(false);
		txtrGestinOrdenadoresVersion.setText("Gesti\u00F3n ordenadores\r\n\r\nVersion: (1.0)\r\nBuild id: 0123456789\r\n(c) Copyright 2015.  All rights reserved.\r\n\r\nCreado por:\r\n\tJavier Ben\u00EDtez del Pozo");
		txtrGestinOrdenadoresVersion.setBounds(0, 0, 382, 153);
		
		JScrollPane scrollPane = new JScrollPane(txtrGestinOrdenadoresVersion);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 382, 156);
		
		JButton btnOk = new JButton("Aceptar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(137, 169, 91, 23);
		
		getContentPane().setLayout(null);
		getContentPane().add(scrollPane);
		getContentPane().add(btnOk);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
}