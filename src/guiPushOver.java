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
public class guiPushOver extends JFrame
{
	
	public JPanel contentPane;
	JLabel lblOutput1;
	JButton btnStart1;
	JButton btnYes;
	JButton btnNo1;
	JButton btnNo2; 
	private JLabel lblOutput2;
	private JLabel lblOutput3;
	private JLabel lblPriceString;
	private JButton btnNewButton;
	String priceGuessArray[] = new String[9];
	int priceGuessArrayStart;
	String priceGuessString = "";
	String carPriceString1;
	String carPriceArray[] = new String[5];
	int numGuess = 0;
	int correctNumGuess;
	String display = "";
	
	int actualCar1ID;
	Item actualCar1;
	String carName1;
	Integer carPrice1;
	String carDescription1;
	
	int actualCar2ID;
	Item actualCar2;
	String carName2;
	Integer carPrice2;
	String carDescription2;
	String carPriceString2;
	private JButton btnStart2;
	
	public guiPushOver()
	{
		Item.fillEmpty();
		setTitle("Push Over");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 523);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStart1 = new JButton("Start (P1)");
		btnStart1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				start1();
				btnStart1.setEnabled(false);
				btnYes.setEnabled(true);
				btnNo1.setEnabled(true);
			}
		});
		
		btnStart2 = new JButton("Start (P2)");
		btnStart2.setEnabled(false);
		btnStart2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start2();
				btnStart2.setEnabled(false);
				btnYes.setEnabled(true);
				btnNo2.setEnabled(true);
			}
		});
		btnStart2.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		btnStart2.setBounds(491, 59, 129, 34);
		contentPane.add(btnStart2);
		btnStart1.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		btnStart1.setBounds(491, 23, 129, 34);
		contentPane.add(btnStart1);
		
		btnYes = new JButton("Push Over!");
		btnYes.setEnabled(false);
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display = display.substring(0, display.length() - 2);
				display = "X " + display;
				lblPriceString.setText(display);
				numGuess++;
				
			}
		});
		btnYes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnYes.setBounds(531, 281, 89, 23);
		contentPane.add(btnYes);
		
		btnNo1 = new JButton("Keep! (P1)");
		btnNo1.setEnabled(false);
		btnNo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (numGuess == correctNumGuess)
				{
					lblOutput1.setText("Congratulations " + Player1.getName() + "!");
					lblOutput2.setText("You won a new car retailed at $" + carPrice1 + ".");
					lblOutput3.setText("Car retrieved: " + carName1 + ".");
					Player1.setPushOverWinnings(actualCar1);
				}
				else
				{
					lblOutput1.setText("Sorry, you did not guess the correct price of the car.");
					lblOutput2.setText("It was $" + carPrice1 + ". Here's $1500 for your efforts! Thanks for playing!");
					lblOutput3.setText("No car retrieved.");
					Player1.setPushOverWinnings(Item.empty.get(0));
			}
				btnStart2.setEnabled(true);
				btnYes.setEnabled(false);
				btnNo1.setEnabled(false);
				btnNo2.setEnabled(false);
			}});
		btnNo1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNo1.setBounds(531, 315, 89, 23);
		contentPane.add(btnNo1);
		
		btnNo2 = new JButton("Keep! (P2)");
		btnNo2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numGuess == correctNumGuess)
				{
					lblOutput1.setText("Congratulations " + Player2.getName() + "!");
					lblOutput2.setText("You won a new car retailed at $" + carPrice2 + ".");
					lblOutput3.setText("Car retrieved: " + carName2 + ".");
					Player2.setPushOverWinnings(actualCar2);
				}
				else
				{
					lblOutput1.setText("Sorry, you did not guess the correct price of the car.");
					lblOutput2.setText("It was $" + carPrice2 + ". Here's $1500 for your efforts! Thanks for playing!");
					lblOutput3.setText("No car retrieved.");
					Player2.setPushOverWinnings(Item.empty.get(0));
				}
				btnYes.setEnabled(false);
				btnNo1.setEnabled(false);
				btnNo2.setEnabled(false);
				btnNewButton.setVisible(true); btnNewButton.setEnabled(true);
			}
		});
		btnNo2.setEnabled(false);
		btnNo2.setBounds(531, 340, 89, 23);
		contentPane.add(btnNo2);
		
		lblPriceString = new JLabel("");
		lblPriceString.setFont(new Font("Courier New", Font.BOLD, 39));
		lblPriceString.setBounds(123, 219, 489, 51);
		contentPane.add(lblPriceString);
		
		lblOutput3 = new JLabel("Click your corresponding \"Keep\" button to finalize the price you think the car is!");
		lblOutput3.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblOutput3.setBounds(23, 430, 482, 24);
		contentPane.add(lblOutput3);
		
		lblOutput2 = new JLabel("In this game, you will push blocks until the correct price is highlighted in blue!");
		lblOutput2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblOutput2.setBounds(23, 395, 482, 24);
		contentPane.add(lblOutput2);
		
		lblOutput1 = new JLabel("Welcome to Push Over! (click \"Start (P1)\" when ready)");
		lblOutput1.setVerticalAlignment(SwingConstants.TOP);
		lblOutput1.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblOutput1.setBounds(23, 361, 482, 24);
		contentPane.add(lblOutput1);
	
		btnNewButton = new JButton("Continue");
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new guiBigWheel().setVisible(true);
				close();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(531, 395, 89, 60);
		contentPane.add(btnNewButton);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(guiPushOver.class.getResource("/img/guiPushOver.png")));
		lblBackground.setBounds(0, 0, 645, 487);
		contentPane.add(lblBackground);
		
		//Constructing car variables
		Item.fillCarItems();
		
		actualCar1ID = (int) (Math.random() * 7); //7 b/c 7 cars in carItems
		actualCar1 = Item.carItems.get(actualCar1ID);
		carName1 = actualCar1.getName();
		carPrice1 = new Integer((int) actualCar1.getPrice());
		carDescription1 = actualCar1.getDescription();
		carPriceString1 = carPrice1.toString();
		
		actualCar2ID = (int) (Math.random() * 7); //7 b/c 7 cars in carItems
		if (actualCar2ID == actualCar1ID)
		{
			actualCar2ID = (int) (Math.random() * 7);
			if (actualCar2ID == actualCar1ID)
			{
				actualCar2ID = (int) (Math.random() * 7);
			}
		}
		actualCar2 = Item.carItems.get(actualCar2ID);
		carName2 = actualCar2.getName();
		carPrice2 = new Integer((int) actualCar2.getPrice());
		carDescription2 = actualCar2.getDescription();
		carPriceString2 = carPrice2.toString();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiPushOver frame = new guiPushOver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void start1()
	{
		
		//creates correct price string P1
		for (int i = 0; i < 5; i++) 
		{
			carPriceArray[i] = carPriceString1.substring(i, i+1);
		}
		
		//creates random price string P1
		for (int j = 0; j < 9; j++)  
		{
			priceGuessArray[j] = "" + (int) (Math.random() * 10);
		}
		
		//randomly chooses correct position P1
		priceGuessArrayStart = (int) (Math.random() * 5); 
		
		//sets number of correct guesses P1
		correctNumGuess = 4 - priceGuessArrayStart;
		
		//inserts correct price string into random price string P1
		priceGuessArray[priceGuessArrayStart + 0] = carPriceArray[0];
		priceGuessArray[priceGuessArrayStart + 1] = carPriceArray[1];
		priceGuessArray[priceGuessArrayStart + 2] = carPriceArray[2];
		priceGuessArray[priceGuessArrayStart + 3] = carPriceArray[3];
		priceGuessArray[priceGuessArrayStart + 4] = carPriceArray[4];
		
		//array to string P1
		for (int k = 0; k < 9; k++)
		{
			priceGuessString += priceGuessArray[k];
		}
		
		//P1 playing
		lblOutput1.setText(Player1.getName() + ",");
		lblOutput2.setText("You will be guessing the price of a " + carName1 + "!");
		lblOutput3.setText("About the " + carName1 + ": " + carDescription1);
		
		//display
		for (int k = 0; k < priceGuessString.length(); k++)
		{
			display += priceGuessString.substring(k, k+1);
			display += " ";
		}
		
		lblPriceString.setText(display);
	
	}

	public void start2()
	{
		//delete guessing string P1
		priceGuessString = "";

		numGuess = 0;
		
		//creates correct price string P2
		for (int i = 0; i < 5; i++) 
		{
			carPriceArray[i] = carPriceString2.substring(i, i+1);
		}
		
		//creates random price string P2
		for (int j = 0; j < 9; j++)  
		{
			priceGuessArray[j] = "" + (int) (Math.random() * 10);
		}
		
		//randomly chooses correct position P2
		priceGuessArrayStart = (int) (Math.random() * 5); 
		//sets number of correct guesses P2
		correctNumGuess = 4 - priceGuessArrayStart;
		
		//inserts correct price string into random price string P2
		priceGuessArray[priceGuessArrayStart + 0] = carPriceArray[0];
		priceGuessArray[priceGuessArrayStart + 1] = carPriceArray[1];
		priceGuessArray[priceGuessArrayStart + 2] = carPriceArray[2];
		priceGuessArray[priceGuessArrayStart + 3] = carPriceArray[3];
		priceGuessArray[priceGuessArrayStart + 4] = carPriceArray[4];
		
		//array to string P2
		for (int k = 0; k < 9; k++)
		{
			priceGuessString += priceGuessArray[k];
		}
		
		//P2 playing
		lblOutput1.setText(Player2.getName() + ",");
		lblOutput2.setText("You will be guessing the price of a " + carName2 + "!");
		lblOutput3.setText("About the " + carName2 + ": " + carDescription2);
		
		//display
		display = "";
		
		for (int k = 0; k < priceGuessString.length(); k++)
		{
			display += priceGuessString.substring(k, k+1);
			display += " ";
		}
		
		lblPriceString.setText(display);
		
	
	}
	
	public void close()
	{
		this. dispose();
	}
	

}
