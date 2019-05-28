import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import  javax.swing.Timer;

import java.awt.Color;

import java.lang.Math;
public class guiContestantsRow extends JFrame
{
	public JPanel contentPane;
	private JTextField txtBid;
	JButton btnStart;
	JLabel lblOutput1;
	JLabel lblOutput2;
	JLabel lblOutput3;
	JLabel lblName1;
	JLabel lblName2;
	JLabel lblGuess1;
	JLabel lblGuess2;
	JButton btnNext;
	static JFrame thisThing;
	
	int actualItemID; //8 b/c 8 cars in carItems
	Item actualItem;
	String actualName;
	int actualPrice;
	String actualDescription;
	int nextCount = 0;
	
	int guess1;
	int guess2;
	int diff1;
	int diff2;
	private JButton btnNewButton;
	
	public guiContestantsRow()
	{
		
		Item.fillAll();
		setTitle("Contestants' Row");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 523);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Continue");
		btnNewButton.setVisible(false);btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new guiGuessPrice().setVisible(true);
				close();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		btnNewButton.setBounds(377, 69, 264, 141);
		contentPane.add(btnNewButton);
		
		txtBid = new JTextField();
		txtBid.setHorizontalAlignment(SwingConstants.CENTER);
		txtBid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBid.setEnabled(false);
		txtBid.setBounds(89, 190, 86, 20);
		contentPane.add(txtBid);
		txtBid.setColumns(4);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
				txtBid.setEnabled(true);
				btnNext.setEnabled(true);
				btnStart.setEnabled(false);
			}
		});
		
		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextCount++;
				if (nextCount == 1)
				{
					guess1 = (new Integer(txtBid.getText())).intValue();
					lblGuess1.setText("" + guess1);
					txtBid.setText("");
				}
				else if (nextCount == 2)
				{
					guess2 = (new Integer(txtBid.getText())).intValue();
					
					lblGuess2.setText("" + guess2);
					txtBid.setText("");
					txtBid.setEnabled(false);
					
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					
					diff1 = Math.abs(actualPrice - guess1);
					diff2 = Math.abs(actualPrice - guess2);
					btnNext.setEnabled(false);
					btnNewButton.setEnabled(true);
					btnNewButton.setVisible(true);
					if (diff1 < diff2)
					{
						lblOutput1.setText("Congratulations " + Player1.getName() + "!");
						lblOutput2.setText("You won a new " + actualName + "!");
						lblOutput3.setText("The item's price was $" + actualPrice + ". You were $" + diff1 + " off!");
						Player1.setContestantsRowWinnings(actualPrice);
						Player2.setContestantsRowWinnings(0);
						
						if (diff1 <= 10)
						{
								lblOutput1.setText("Congratulations " + Player1.getName() + ", you won a $1000 bonus AND");
								lblOutput2.setText("A new " + actualName + "!");
								lblOutput3.setText("Your bid was within $10 of the actual price $" + actualPrice + "!");
								Player1.setContestantsRowWinnings(actualPrice + 1000);
								Player2.setContestantsRowWinnings(0);
						}
					}
					else if (diff2 < diff1)
					{
						lblOutput1.setText("Congratulations " + Player2.getName() + "!");
						lblOutput2.setText("You won a new " + actualName + "!");
						lblOutput3.setText("The item's price was $" + actualPrice + ". You were $" + diff2 + " off!");
						Player1.setContestantsRowWinnings(0);
						Player2.setContestantsRowWinnings(actualPrice);
						
						if (diff2 <= 10)
						{
							lblOutput1.setText("Congratulations " + Player2.getName() + ", you won a $1000 bonus AND");
							lblOutput2.setText("A new " + actualName + "!");
							lblOutput3.setText("Your bid was within $10 of the actual price $" + actualPrice + "!");
							Player1.setContestantsRowWinnings(0);
							Player2.setContestantsRowWinnings(actualPrice + 1000);
						}
						
					}
					
					
				}
			
					
			}
		});
		btnNext.setBounds(187, 190, 89, 20);
		contentPane.add(btnNext);
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStart.setBounds(382, 130, 75, 36);
		contentPane.add(btnStart);
		
		lblOutput3 = new JLabel("The person who has the closest bid wins the item!");
		lblOutput3.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblOutput3.setBounds(29, 174, 332, 20);
		contentPane.add(lblOutput3);
		
		lblOutput2 = new JLabel("You will be bidding on an item!");
		lblOutput2.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblOutput2.setBounds(29, 109, 344, 60);
		contentPane.add(lblOutput2);
		
		lblOutput1 = new JLabel("Welcome to Contestant's Row!");
		lblOutput1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblOutput1.setBounds(136, 94, 246, 14);
		contentPane.add(lblOutput1);
		
		lblGuess2 = new JLabel("0000");
		lblGuess2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGuess2.setForeground(new Color(255, 255, 102));
		lblGuess2.setFont(new Font("Courier New", Font.PLAIN, 80));
		lblGuess2.setBounds(404, 362, 197, 91);
		contentPane.add(lblGuess2);
		
		lblGuess1 = new JLabel("0000");
		lblGuess1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGuess1.setForeground(new Color(255, 255, 102));
		lblGuess1.setFont(new Font("Courier New", Font.PLAIN, 80));
		lblGuess1.setBounds(101, 362, 197, 91);
		contentPane.add(lblGuess1);
		
		lblName2 = new JLabel("");
		lblName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName2.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		lblName2.setBounds(371, 258, 197, 60);
		contentPane.add(lblName2);
		
		lblName1 = new JLabel("");
		lblName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName1.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		lblName1.setBounds(59, 258, 197, 60);
		contentPane.add(lblName1);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(guiContestantsRow.class.getResource("/img/guiContestantsRow.png")));
		lblBackground.setBounds(0, -28, 641, 540);
		contentPane.add(lblBackground);
		
		
		
		actualItemID = (int) (Math.random() * 8); //8 b/c 8 cars in carItems
		actualItem = Item.bigItems.get(actualItemID);
		actualName = actualItem.getName();
		actualPrice = (int) (actualItem.getPrice());
		actualDescription = actualItem.getDescription();
	}
	
	//GUI crap
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiContestantsRow frame;
					
					frame = new guiContestantsRow();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void start()
	{
		lblName1.setText(Player1.getName());
		lblName2.setText(Player2.getName());
		
		lblOutput1.setText("<html>Item: " + actualName + "</html>");
		lblOutput2.setText("<html>Description: " + actualDescription + "</html>");
		lblOutput3.setText(Player1.getName() + ", your turn to bid:");
		
		lblGuess1.setText(txtBid.getText());
	}
	public void close()
	{
		this.dispose();
	}
	
}
