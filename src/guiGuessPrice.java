import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guiGuessPrice extends JFrame
{
	//price guessing
	ArrayList<Item> items;
	
	
	
	int guess;
	Item current;
	public JPanel contentPane;
	private JLabel lblPrompt, lblDig1, lblEndResult;
	private JRadioButton rb1, rb2;
	private JButton btnGo, btnContinue;
	private int playerNum = 1, index = 0, btnCount;
	private JPanel panel;
	private JLabel lblP1chips;
	private JLabel lblP2chips;
	private JLabel lblPlayer1Name;
	private JLabel lblPlayer2Name;
	private JLabel lblGuessesLeftOne, lblGuessesLeftTwo;
	ButtonGroup group;
	private JLabel lblDig2;
	private Color lightBlue = new Color(174,196,251), darkBlue = new Color(22,58,152);
	private JLabel label_1;
	private JLabel label_2;
	
	public guiGuessPrice()
	{
		 items = Item.twoDigitItems;
		 Collections.shuffle(items);
		 
		 setTitle("Price Guessing");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setBounds(100, 100, 640, 480);
		 contentPane = new JPanel();
		
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setContentPane(contentPane);
		 contentPane.setLayout(new CardLayout(0, 0));
		
		 group = new ButtonGroup();
		 
		 panel = new JPanel();
		 contentPane.add(panel, "name_26342315988977");
		 panel.setLayout(null);
		 
		 btnContinue = new JButton("Continue");
		 btnContinue.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		new guiPlinko().setVisible(true);
				close();
		 	}
		 });
		 btnContinue.setEnabled(false);
		 btnContinue.setVisible(false);
		 btnContinue.setBounds(251, 287, 236, 92);
		 panel.add(btnContinue);
		 
		 btnGo = new JButton("Go!");
		 btnGo.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		 btnGo.setBounds(251, 334, 143, 81);
		 panel.add(btnGo);
		
		 
		 lblEndResult = new JLabel("");
		 lblEndResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblEndResult.setBounds(205, 252, 200, 54);
		 panel.add(lblEndResult);
		 
		 rb2 = new JRadioButton("");
		
		 rb2.setBounds(144,359,20,20);
		 rb2.setEnabled(false);
		 panel.add(rb2);
		 group.add(rb2);
		 
		 
		 rb1 = new JRadioButton("");
		
		 rb1.setBounds(55, 359, 20, 20);
		 rb1.setEnabled(false);
		 panel.add(rb1);
		 group.add(rb1);
		 
		 lblPrompt = new JLabel("");
		 lblPrompt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 lblPrompt.setBounds(19, 162, 395, 94);
		 panel.add(lblPrompt);
		 lblPrompt.setHorizontalAlignment(SwingConstants.LEFT);
		 
		 lblDig1 = new JLabel("");
		 lblDig1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblDig1.setFont(new Font("Courier New", Font.BOLD, 34));
		 lblDig1.setForeground(lightBlue);
		 lblDig1.setBounds(29, 264, 78, 88);
		 panel.add(lblDig1);
		 
		 lblDig2 = new JLabel("");
		 lblDig2.setHorizontalAlignment(SwingConstants.CENTER);
		 lblDig2.setFont(new Font("Courier New", Font.BOLD, 34));
		 lblDig2.setForeground(lightBlue);
		 lblDig2.setBounds(117, 267, 78, 85);
		 panel.add(lblDig2);
		 
		 lblP1chips = new JLabel("");
		 lblP1chips.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblP1chips.setBounds(435, 195, 169, 29);
		 panel.add(lblP1chips);
		 
		 lblP2chips = new JLabel("");
		 lblP2chips.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblP2chips.setBounds(435, 328, 169, 29);
		 panel.add(lblP2chips);
		 
		 lblPlayer1Name = new JLabel(Player1.getName());
		 lblPlayer1Name.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 16));
		 lblPlayer1Name.setBounds(448, 145, 156, 29);
		 panel.add(lblPlayer1Name);
		 
		 lblPlayer2Name = new JLabel(Player2.getName());
		 lblPlayer2Name.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 16));
		 lblPlayer2Name.setBounds(445, 287, 169, 29);
		 panel.add(lblPlayer2Name);
		 
		 lblGuessesLeftOne = new JLabel("Guesses left:");
		 lblGuessesLeftOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblGuessesLeftOne.setBounds(435, 227, 169, 29);
		 panel.add(lblGuessesLeftOne);
		 
		 lblGuessesLeftTwo = new JLabel("Guesses left:");
		 lblGuessesLeftTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblGuessesLeftTwo.setBounds(435, 359, 169, 29);
		 panel.add(lblGuessesLeftTwo);
		 
		 label_2 = new JLabel("");
		 label_2.setIcon(new ImageIcon(guiGuessPrice.class.getResource("/img/nametagSmall.png")));
		 label_2.setBounds(424, 254, 252, 144);
		 panel.add(label_2);
		 
		 label_1 = new JLabel("");
		 label_1.setIcon(new ImageIcon(guiGuessPrice.class.getResource("/img/nametagSmall.png")));
		 label_1.setBounds(430, 113, 252, 144);
		 panel.add(label_1);
		 
		 JLabel label = new JLabel("");
		 label.setIcon(new ImageIcon(guiGuessPrice.class.getResource("/img/priceguessing.png")));
		 label.setBounds(0, 0, 614, 431);
		 panel.add(label);

		 
		
		 
		 btnGo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) 
		 	{		btnCount++;
		 			rb1.setEnabled(true);
		 			rb2.setEnabled(true);

					setIndex();
					check();
					
					btnGo.setEnabled(false);
					checkEnd();
		 	}
		 });
		 rb1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		btnGo.setEnabled(true);
			 	}
			 });
		 rb2.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		btnGo.setEnabled(true);
			 	}
			 });
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiGuessPrice frame = new guiGuessPrice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void twoDigitGuessP1()
	{
			
		if (playerNum == 1){
			//player1
			
			lblPrompt.setText("");
			lblPrompt.setText("<html>" +Player1.getName() + ", take a guess for a chip.<br>" + items.get(index).getName()+ 
					"<br>" + items.get(index).getDescription() + "</html>"); 
			lblDig1.setText(DigitOne());
			lblDig2.setText(DigitTwo());
			
		
			if (rb1.isSelected() && 1 == items.get(index-1).getWhichDig())
			{
 				//do two digit thing with buttons
				
				Player1.addDisc();
				lblEndResult.setText("<html>The actual price was " + items.get(index-1).getPrice() + ". Congratulations, you won a chip! </html>");
				
			}
 			else if (rb2.isSelected() && 2 == items.get(index-1).getWhichDig())
			{
				Player1.addDisc();
				lblEndResult.setText("<html>The actual price was " + items.get(index-1).getPrice() + ". Congratulations, you won a chip! </html>");
			}
 			else 
 				{
 				if (btnCount > 1)
 				lblEndResult.setText("<html>The actual price was " + items.get(index-1).getPrice() + ". Sorry, you did not win a chip! </html>");
 				}
		}	
		Player1.removeAGuess();
		
		lblP1chips.setText("Chips:  " + Player1.getDisc() + "");	
		if (index == 4) playerNum = 2;
		
	}
		
	public void twoDigitGuessP2()
	{
			//player2
			
			lblPrompt.setText("");
			lblPrompt.setText("<html>" +Player2.getName() + ", take a guess for a chip.<br>" + items.get(index).getName()+ 
					"<br>" + items.get(index).getDescription() + "</html>"); 
			lblDig1.setText(DigitOne());
			lblDig2.setText(DigitTwo());
			
	
			if (rb1.isSelected() && 1 == items.get(index-1).getWhichDig() )
			{
 				//do two digit thing with buttons
				
				Player2.addDisc();
				lblEndResult.setText("<html>The actual price was " + items.get(index-1).getPrice() + ". Congratulations, you won a chip! </html>");
				
			}
 			else if (rb2.isSelected() && 2 == items.get(index-1).getWhichDig())
			{
				Player2.addDisc();
				lblEndResult.setText("<html>The actual price was " + items.get(index-1).getPrice() + ". Congratulations, you won a chip! </html>");
			}
 			else
 			{	
 				if (btnCount > 1)
 				lblEndResult.setText("<html>The actual price was " + items.get(index-1).getPrice() + ". Sorry, you did not win any chips. </html>");
 			}
 				Player2.removeAGuess();
		
		
		lblP2chips.setText("Chips:  "  + Player2.getDisc() + "");	
		
		
		
	
	}
	public void check()
	{
		
		
		if(playerNum == 1)
			twoDigitGuessP1();
		
		else if (playerNum == 2)
			twoDigitGuessP2();
		
		
		//else //something happens here
		group.clearSelection();
	}
	private String DigitOne()
	{
		String dig = (""+ items.get(index).getFakePrice());
		dig = dig.charAt(0) + "";
		return dig;
	}
	private String DigitTwo()
	{
		String dig = (""+ items.get(index).getFakePrice());
		dig = dig.charAt(1) + "";
		return dig;
	}
	private void setIndex()
	{
		index++;
		lblGuessesLeftOne.setText("Guesses left:  " + Player1.getGuesses() + "");
		lblGuessesLeftTwo.setText("Guesses left:  " + Player2.getGuesses() + "");
	}
	private void checkEnd()
	{
		if (Player2.getGuesses() == -1)
		{
			rb1.setEnabled(false);
			rb2.setEnabled(false);
			btnGo.setVisible(false);
			btnGo.setEnabled(false);
			btnContinue.setVisible(true);
			btnContinue.setEnabled(true);
		}
	}
	public void close()
	{
		this.dispose();
	}
}
