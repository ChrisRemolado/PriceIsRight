import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimerTask;

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



import java.awt.Color;
import java.lang.Math;
import java.util.Timer;

public class guiBigWheel extends JFrame
{
	public JPanel contentPane;
	
	JLabel lblMidSlot, lblTop, lblBottom, lblOutput1, lblOutput2, lblOutput3, lblScore1, lblScore2, lblPlayerOne, lblPlayerTwo;
	JButton btnSpin, btnSpinAgain,btnContinue, btnPass, btnNext;
	javax.swing.Timer t;
	DecimalFormat decimal = new DecimalFormat("0.00");
	
	int[] Wheel = new int[60];
	int value, valueMinusOne, valuePlusOne;
	int limit;
	int currentPos = 0;
	int TimeLim;
	int spinCount = 0, spinAgainCount = 0;
	double score1, score2 = 0;
	double diff1, diff2;
	boolean bonus1 = false, bonus2 = false;
	
	public guiBigWheel()
	{
		setTitle("Big Wheel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 523);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblScore2 = new JLabel("0.00");
		lblScore2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblScore2.setForeground(new Color(255, 255, 102));
		lblScore2.setFont(new Font("Courier New", Font.PLAIN, 60));
		lblScore2.setBounds(469, 265, 147, 91);
		contentPane.add(lblScore2);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new guiShowcase().setVisible(true);
				close();
			}
		});
		btnContinue.setEnabled(false);
		btnContinue.setVisible(false);
		btnContinue.setBounds(360, 294, 99, 47);
		contentPane.add(btnContinue);
		
		lblScore1 = new JLabel("0.00");
		lblScore1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblScore1.setForeground(new Color(255, 255, 102));
		lblScore1.setFont(new Font("Courier New", Font.PLAIN, 60));
		lblScore1.setBounds(469, 125, 147, 91);
		contentPane.add(lblScore1);
		
		lblOutput1 = new JLabel("Welcome to the Big Wheel! Each player will spin");
		lblOutput1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOutput1.setBounds(384, 404, 232, 14);
		contentPane.add(lblOutput1);
		
		lblOutput2 = new JLabel("the wheel once. You can also spin again to get");
		lblOutput2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOutput2.setBounds(384, 428, 232, 14);
		contentPane.add(lblOutput2);
		
		lblOutput3 = new JLabel("as close to $1.00 as possible! (P1's turn!)");
		lblOutput3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOutput3.setBounds(384, 454, 232, 14);
		contentPane.add(lblOutput3);
		
		lblPlayerOne = new JLabel("Player One");
		lblPlayerOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerOne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayerOne.setBounds(502, 88, 87, 26);
		contentPane.add(lblPlayerOne);
		
		lblPlayerTwo = new JLabel("Player Two");
		lblPlayerTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTwo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayerTwo.setBounds(502, 233, 87, 26);
		contentPane.add(lblPlayerTwo);
		
		lblBottom = new JLabel("Bottom");
		lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel5.png")));
		lblBottom.setBounds(55, 335, 300, 150);
		contentPane.add(lblBottom);
		
		lblTop = new JLabel("");
		lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel15.png")));
		lblTop.setBounds(55, 13, 300, 150);
		contentPane.add(lblTop);
		
		lblMidSlot = new JLabel("");
		lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel100.png")));
		lblMidSlot.setBounds(55, 174, 300, 150);
		contentPane.add(lblMidSlot);
		
		btnSpin = new JButton("Spin!");
		btnSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					limit = ((int) (Math.random() * 40)) + 20;
					startWheel();
					spinCount++;
					
					if (spinCount == 1)
					{
						lblPlayerOne.setText(Player1.getName());
						lblPlayerTwo.setText(Player2.getName());
						
						score1 += (value * .01);
						lblOutput1.setText(Player1.getName() + ", you got $" + decimal.format(value * .01) + ".");
						lblOutput2.setText("Click \"Spin Again\" if you want another go!");
						lblOutput3.setText("Or click pass to let Player 2 go!");
						lblScore1.setText("" + decimal.format(score1));
						
						btnSpin.setEnabled(false);
						btnSpinAgain.setEnabled(true);
						btnPass.setEnabled(true);
					}
					else if (spinCount == 2)
					{
						score2 += (value * .01);
						lblOutput1.setText(Player2.getName() + ", you got $" + decimal.format(value * .01) + ".");
						lblOutput2.setText("Click \"Spin Again\" if you want another go!");
						lblOutput3.setText("Or click pass to stay at your score!");
						lblScore2.setText("" + decimal.format(score2));
						
						btnSpin.setEnabled(false);
						btnSpinAgain.setEnabled(true);
						btnPass.setEnabled(true);
					}
			}
		});
		
		btnPass = new JButton("Pass...");
		btnPass.setEnabled(false);
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spinAgainCount++;
				
				if (spinAgainCount == 1)
				{
					lblOutput1.setText("Okay " + Player1.getName() + ".");
					lblOutput2.setText("You ended up with a score of $" + decimal.format(score1) + "!");
					lblOutput3.setText("It's Player 2's turn!");
					
					btnSpin.setEnabled(true);
					btnSpinAgain.setEnabled(false);
					btnPass.setEnabled(false);
					
					if (score1 == 1)
					{
						lblOutput3.setText("You got $1.00! Bonus $10,000! It's P2's turn!");
						bonus1 = true;
					}
				}
				else if (spinAgainCount == 2)
				{
					lblOutput1.setText("Okay " + Player2.getName() + ".");
					lblOutput2.setText("You ended up with a score of $" + decimal.format(score2) + "!");
					lblOutput3.setText("Time to tally scores!");

					btnNext.setEnabled(true);
					btnSpin.setEnabled(false);
					btnSpinAgain.setEnabled(false);
					btnPass.setEnabled(false);
					
					if (score2 == 1)
					{
						lblOutput3.setText("You got $1.00! Bonus $10,000! Time to tally!");
						bonus2 = true;
					}
				}
			}
		});
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				diff1 = Math.abs(1 - score1);
				diff2 = Math.abs(1 - score2);
				
				if (diff1 < diff2)
				{
					lblOutput1.setText(Player1.getName() + ", you were closer to $1.00!");
					lblOutput2.setText("You were $" + decimal.format(diff1) + " away!");
					lblOutput3.setText("Player 1 wins $20,000! Player 2 gets $7,500!");
					Player1.setBigWheelWinnings(20000);
					Player2.setBigWheelWinnings(7500);
					
					if (bonus1 == true)
					{
						lblOutput3.setText(Player1.getName() + " wins $20,000 + $10,000!" + Player2.getName() +" gets $7,500!");
						Player1.setBigWheelWinnings(30000);
					}
				}
				else if (diff2 < diff1)
				{
					lblOutput1.setText(Player2.getName() + ", you were closer to $1.00!");
					lblOutput2.setText("You were $" + decimal.format(diff2) + " away!");
					lblOutput3.setText("Player 1 gets $7,500! Player 2 wins $20,000!");
					Player1.setBigWheelWinnings(7500);
					Player2.setBigWheelWinnings(20000);
					
					if (bonus2 == true)
					{
						lblOutput3.setText("P1 gets $7,500! P2 wins $20,000 + $10,000!");
						Player2.setBigWheelWinnings(30000);
					}
				}
				else if (diff1 == diff2)
				{
					lblOutput1.setText("Both of you tied!!");
					lblOutput2.setText("You were $" + decimal.format(diff1) + " away!");
					lblOutput3.setText("Both of you get $10,000!");
					Player1.setBigWheelWinnings(10000);
					Player2.setBigWheelWinnings(10000);
					
					if (bonus1 == true)
					{
						lblOutput3.setText("Both of you get $10,000 + $10,000!");
						Player2.setBigWheelWinnings(20000);
					}
				}
				
				btnNext.setEnabled(false);
				btnNext.setVisible(false);
				btnContinue.setEnabled(true);
				btnContinue.setVisible(true);
			}
		});
		btnNext.setEnabled(false);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNext.setBounds(360, 293, 99, 47);
		contentPane.add(btnNext);
		btnPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPass.setBounds(360, 174, 99, 47);
		contentPane.add(btnPass);
		
		btnSpinAgain = new JButton("Spin Again!");
		btnSpinAgain.setEnabled(false);
		btnSpinAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limit = ((int) (Math.random() * 40)) + 20;
				startWheel();
				spinAgainCount++;
				
				if (spinAgainCount == 1)
				{
					score1 += (value * .01);
					lblOutput1.setText(Player1.getName() + ", you got $" + decimal.format(value * .01) + ".");
					lblOutput2.setText("You ended up with a score of $" + decimal.format(score1) + "!");
					lblOutput3.setText("It's Player 2's turn!");
					lblScore1.setText("" + decimal.format(score1));
					
					btnSpin.setEnabled(true);
					btnSpinAgain.setEnabled(false);
					btnPass.setEnabled(false);
					
					if (score1 == 1)
					{
						lblOutput3.setText("You got $1.00! Bonus $10,000! It's P2's turn!");
						bonus1 = true;
					}
				}
				else if (spinAgainCount == 2)
				{
					score2 += (value * .01);
					lblOutput1.setText(Player2.getName() + ", you got $" + decimal.format(value * .01) + ".");
					lblOutput2.setText("You ended up with a score of $" + decimal.format(score2) + "!");
					lblOutput3.setText("Time to tally the scores!");
					lblScore2.setText("" + decimal.format(score2));
					
					btnNext.setEnabled(true);
					btnSpin.setEnabled(false);
					btnSpinAgain.setEnabled(false);
					btnPass.setEnabled(false);
					
					if (score2 == 1)
					{
						lblOutput3.setText("You got $1.00! Bonus $10,000! Time to tally!");
						bonus2 = true;
					}
				}
			}
		});
		btnSpinAgain.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSpinAgain.setBounds(360, 125, 99, 47);
		contentPane.add(btnSpinAgain);
		btnSpin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSpin.setBounds(360, 74, 99, 47);
		contentPane.add(btnSpin);
		
	
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/guiBigWheel.png")));
		lblBackground.setBounds(0, 11, 641, 473);
		contentPane.add(lblBackground);
		
		//Array
		Wheel[0] = 5;
		Wheel[1] = 100;
		Wheel[2] = 15;
		Wheel[3] = 80;
		Wheel[4] = 35;
		Wheel[5] = 60;
		Wheel[6] = 20;
		Wheel[7] = 40;
		Wheel[8] = 75;
		Wheel[9] = 55;
		Wheel[10] = 95;
		Wheel[11] = 50;
		Wheel[12] = 85;
		Wheel[13] = 30;
		Wheel[14] = 65;
		Wheel[15] = 10;
		Wheel[16] = 45;
		Wheel[17] = 70;
		Wheel[18] = 25;
		Wheel[19] = 90;
		Wheel[20] = 5;
		Wheel[21] = 100;
		Wheel[22] = 15;
		Wheel[23] = 80;
		Wheel[24] = 35;
		Wheel[25] = 60;
		Wheel[26] = 20;
		Wheel[27] = 40;
		Wheel[28] = 75;
		Wheel[29] = 55;
		Wheel[30] = 95;
		Wheel[31] = 50;
		Wheel[32] = 85;
		Wheel[33] = 30;
		Wheel[34] = 65;
		Wheel[35] = 10;
		Wheel[36] = 45;
		Wheel[37] = 70;
		Wheel[38] = 25;
		Wheel[39] = 90;
		Wheel[40] = 5;
		Wheel[41] = 100;
		Wheel[42] = 15;
		Wheel[43] = 80;
		Wheel[44] = 35;
		Wheel[45] = 60;
		Wheel[46] = 20;
		Wheel[47] = 40;
		Wheel[48] = 75;
		Wheel[49] = 55;
		Wheel[50] = 95;
		Wheel[51] = 50;
		Wheel[52] = 85;
		Wheel[53] = 30;
		Wheel[54] = 65;
		Wheel[55] = 10;
		Wheel[56] = 45;
		Wheel[57] = 70;
		Wheel[58] = 25;
		Wheel[59] = 90;
		
		
	}
	
	//GUI crap
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiBigWheel frame = new guiBigWheel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void startWheel()
	{
		int k;
		for (k = 0; k < limit; k++)
		{
			
			valueMinusOne = Wheel[k+1];
			
			value = Wheel[k];
			if (k != 0)
			valuePlusOne = Wheel[k-1];
			
			setPics();
		
		}
		
       	 
       
       	 
    }
	public void setPics()
	{
		if (value == 5) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel5.png")));}
       	else if (value == 10) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel10.png")));}
       	else if (value == 15) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel15.png")));}
       	else if (value == 20) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel20.png")));}
       	else if (value == 25) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel25.png")));}
       	else if (value == 30) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel30.png")));}
       	else if (value == 35) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel35.png")));}
       	else if (value == 40) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel40.png")));}
       	else if (value == 45) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel45.png")));}
       	else if (value == 50) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel50.png")));}
       	else if (value == 55) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel55.png")));}
       	else if (value == 60) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel60.png")));}
       	else if (value == 65) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel65.png")));}
       	else if (value == 70) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel70.png")));}
       	else if (value == 75) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel75.png")));}
       	else if (value == 80) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel80.png")));}
       	else if (value == 85) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel85.png")));}
       	else if (value == 90) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel90.png")));}
       	else if (value == 95) {lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel95.png")));}
       	else if (value == 100){lblMidSlot.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel100.png")));}
		
		
		if (valueMinusOne == 5) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel5.png")));}
       	else if (valueMinusOne == 10) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel10.png")));}
       	else if (valueMinusOne == 15) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel15.png")));}
       	else if (valueMinusOne == 20) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel20.png")));}
       	else if (valueMinusOne == 25) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel25.png")));}
       	else if (valueMinusOne == 30) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel30.png")));}
       	else if (valueMinusOne == 35) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel35.png")));}
       	else if (valueMinusOne == 40) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel40.png")));}
       	else if (valueMinusOne == 45) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel45.png")));}
       	else if (valueMinusOne == 50) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel50.png")));}
       	else if (valueMinusOne == 55) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel55.png")));}
       	else if (valueMinusOne == 60) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel60.png")));}
       	else if (valueMinusOne == 65) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel65.png")));}
       	else if (valueMinusOne == 70) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel70.png")));}
       	else if (valueMinusOne == 75) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel75.png")));}
       	else if (valueMinusOne == 80) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel80.png")));}
       	else if (valueMinusOne == 85) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel85.png")));}
       	else if (valueMinusOne == 90) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel90.png")));}
       	else if (valueMinusOne == 95) {lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel95.png")));}
       	else if (valueMinusOne == 100){lblTop.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel100.png")));}
		
		
		if (valuePlusOne == 5) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel5.png")));}
       	else if (valuePlusOne == 10) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel10.png")));}
       	else if (valuePlusOne == 15) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel15.png")));}
       	else if (valuePlusOne == 20) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel20.png")));}
       	else if (valuePlusOne == 25) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel25.png")));}
       	else if (valuePlusOne == 30) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel30.png")));}
       	else if (valuePlusOne == 35) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel35.png")));}
       	else if (valuePlusOne == 40) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel40.png")));}
       	else if (valuePlusOne == 45) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel45.png")));}
       	else if (valuePlusOne == 50) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel50.png")));}
       	else if (valuePlusOne == 55) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel55.png")));}
       	else if (valuePlusOne == 60) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel60.png")));}
       	else if (valuePlusOne == 65) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel65.png")));}
       	else if (valuePlusOne == 70) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel70.png")));}
       	else if (valuePlusOne == 75) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel75.png")));}
       	else if (valuePlusOne == 80) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel80.png")));}
       	else if (valuePlusOne == 85) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel85.png")));}
       	else if (valuePlusOne == 90) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel90.png")));}
       	else if (valuePlusOne == 95) {lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel95.png")));}
       	else if (valuePlusOne == 100){lblBottom.setIcon(new ImageIcon(guiBigWheel.class.getResource("/img/wheel100.png")));}
	}
	public void close()
	{
		this.dispose();
	}
}

	
	
