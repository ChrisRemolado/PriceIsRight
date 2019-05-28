import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.CardLayout;

import javax.swing.JTextField;

import java.util.ArrayList;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.applet.*;

import sun.audio.*;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
public class guiDriver extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlayer2;
	private JTextField txtPlayer1;
	private JTextField txtP1;
	private JTextField txtP2;
	
	
	
	

	/**
	 * Create the frame.
	 */
	public guiDriver() {
		Item.fillAll();
		setTitle("Plinko");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel pnlStart = new JPanel();
		contentPane.add(pnlStart, "name_633033342866396");
		pnlStart.setLayout(null);
		
		JLabel lblWelcomeTo = new JLabel("Come on down to...");
		lblWelcomeTo.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
		lblWelcomeTo.setBounds(160, 46, 254, 61);
		pnlStart.add(lblWelcomeTo);
		
		JButton btnClickToContinue = new JButton("Click to continue");
		btnClickToContinue.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
		
		btnClickToContinue.setBounds(10, 362, 594, 58);
		pnlStart.add(btnClickToContinue);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(guiDriver.class.getResource("/img/Tpir_40_logo.png")));
		lblNewLabel_2.setBounds(199, 120, 188, 204);
		pnlStart.add(lblNewLabel_2);
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setIcon(new ImageIcon(guiDriver.class.getResource("/img/winnerbackground.png")));
		lblBackground.setBounds(0, 0, 624, 441);
		pnlStart.add(lblBackground);
		
		JPanel pnlGetNames = new JPanel();
		contentPane.add(pnlGetNames, "name_633043331272315");
		pnlGetNames.setLayout(null);
		
		txtPlayer1 = new JTextField();
		txtPlayer1.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 60));
		txtPlayer1.setBounds(101, 210, 157, 92);
		txtPlayer1.setBackground(new Color(255, 213, 87));
		pnlGetNames.add(txtPlayer1);
		txtPlayer1.setColumns(10);
		
		txtPlayer2 = new JTextField();
		txtPlayer2.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 60));
		txtPlayer2.setBounds(404, 210, 157, 92);
		txtPlayer2.setBackground(new Color(255, 213, 87));
		pnlGetNames.add(txtPlayer2);
		txtPlayer2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Player 1:");
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 26));
		lblNewLabel.setBounds(101, 163, 180, 36);
		pnlGetNames.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Player 2:");
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(404, 163, 180, 36);
		pnlGetNames.add(lblNewLabel_1);
		
		JButton btnGo = new JButton("Go!");
		btnGo.setBounds(504, 352, 100, 68);
		pnlGetNames.add(btnGo);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(guiDriver.class.getResource("/img/nametag.png")));
		lblNewLabel_3.setBounds(342, 198, 246, 118);
		pnlGetNames.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(guiDriver.class.getResource("/img/nametag.png")));
		lblNewLabel_4.setBounds(42, 198, 246, 118);
		pnlGetNames.add(lblNewLabel_4);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your names");
		lblPleaseEnterYour.setFont(new Font("Showcard Gothic", Font.PLAIN, 26));
		lblPleaseEnterYour.setBounds(67, 29, 569, 92);
		pnlGetNames.add(lblPleaseEnterYour);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(guiDriver.class.getResource("/img/winnerbackground.png")));
		lblNewLabel_5.setBounds(0, 0, 624, 441);
		pnlGetNames.add(lblNewLabel_5);
		pnlGetNames.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtPlayer1, txtPlayer2, btnGo, lblNewLabel, lblNewLabel_1, lblNewLabel_3, lblNewLabel_4, lblPleaseEnterYour}));
		
		JPanel pnlPlinko = new JPanel();
		contentPane.add(pnlPlinko, "name_635391719663182");
		pnlPlinko.setLayout(null);
		
		JButton btnDoSomething = new JButton("Do Something");
		btnDoSomething.setBounds(141, 193, 307, 30);
		pnlPlinko.add(btnDoSomething);
		
		txtP1 = new JTextField();
		txtP1.setBounds(141, 119, 86, 20);
		pnlPlinko.add(txtP1);
		txtP1.setColumns(10);
		
		txtP2 = new JTextField();
		txtP2.setBounds(352, 119, 86, 20);
		pnlPlinko.add(txtP2);
		txtP2.setColumns(10);
		
		JLabel lblPGuess = new JLabel("P1 guess");
		lblPGuess.setBounds(144, 90, 46, 14);
		pnlPlinko.add(lblPGuess);
		
		JLabel lblPGuess_1 = new JLabel("P2 guess");
		lblPGuess_1.setBounds(348, 94, 46, 14);
		pnlPlinko.add(lblPGuess_1);
		
		JLabel lblTest = new JLabel("");
		lblTest.setBounds(144, 266, 304, 79);
		pnlPlinko.add(lblTest);
		
		btnClickToContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlGetNames.setVisible(true);
				
				pnlStart.setVisible(false);
			}
		});
	
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//* LATER add a check for if the boxes don't have text *//
				
				Player1.setName(txtPlayer1.getText());
				Player2.setName(txtPlayer2.getText());
				pnlGetNames.setVisible(false);
				setBounds(100, 100, 640, 480);
				new guiContestantsRow().setVisible(true);
				close();
			}
			
		});
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiDriver frame = new guiDriver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}
	
	
	
}
