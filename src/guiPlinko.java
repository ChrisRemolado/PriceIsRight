import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guiPlinko extends JFrame
{
	
	public JPanel contentPane;
	final int HEADS = 0, TAILS = 1;
	static ArrayList<Integer> positions;
	JPanel pnlPlinko;
	static JLabel[] row0, row1, row2, row3, row4, row5, row6, row7, row8, prizeRow;
	static JLabel[] currentRow;
	static int NUM_SLOTS = 9;
	private JLabel lbl1;
	private JLabel lbl3;
	int currentPlayer = 1;
	private JLabel lbl2;
	private JLabel lbl4, lblNextContestant;
	JLabel lblP1Points, lblP2Points, lblP1ChipsLeft, lblP2ChipsLeft;
	static int player1tries = Player1.getDisc();
	static int player2tries = Player2.getDisc();
	
	int [] prizes = new int[NUM_SLOTS];
	private JButton btnNext;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiPlinko frame;
					frame = new guiPlinko();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public guiPlinko()
	{
		setTitle("Plinko");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		pnlPlinko = new JPanel();
		contentPane.add(pnlPlinko, "name_14729952420050");
		pnlPlinko.setLayout(null);
		
		JButton btnPlayPlinko = new JButton("Play Plinko!");
		btnPlayPlinko.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
		
		btnPlayPlinko.setBounds(10, 11, 222, 44);
		pnlPlinko.add(btnPlayPlinko);
		
		lbl1 = new JLabel("Player 1 Points:");
		lbl1.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
	
		lbl1.setBounds(10, 349, 159, 32);
		pnlPlinko.add(lbl1);
		
		lbl3 = new JLabel("Player 2 Points:");
		lbl3.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lbl3.setBounds(326, 349, 159, 32);
		pnlPlinko.add(lbl3);
		
		lbl2 = new JLabel("Chips:");
		lbl2.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lbl2.setBounds(10, 388, 61, 32);
		pnlPlinko.add(lbl2);
		
		lbl4 = new JLabel("Chips:");
		lbl4.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lbl4.setBounds(326, 388, 61, 32);
		pnlPlinko.add(lbl4);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new guiPushOver().setVisible(true);
				close();
			}
		});
		btnNext.setBounds(543, 11, 61, 44);
		pnlPlinko.add(btnNext);
		btnNext.setEnabled(false);
		
		lblP1Points = new JLabel("");
		lblP1Points.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lblP1Points.setBounds(179, 349, 81, 32);
		pnlPlinko.add(lblP1Points);
		
		lblP1ChipsLeft = new JLabel("");
		lblP1ChipsLeft.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lblP1ChipsLeft.setBounds(81, 388, 61, 32);
		pnlPlinko.add(lblP1ChipsLeft);
		
		lblP2Points = new JLabel("");
		lblP2Points.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lblP2Points.setBounds(495, 349, 81, 32);
		pnlPlinko.add(lblP2Points);
		
		lblP2ChipsLeft = new JLabel("");
		lblP2ChipsLeft.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lblP2ChipsLeft.setBounds(397, 388, 61, 32);
		pnlPlinko.add(lblP2ChipsLeft);
		
		lblNextContestant = new JLabel("come on down!");
		lblNextContestant.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lblNextContestant.setBounds(241, 12, 318, 44);
		pnlPlinko.add(lblNextContestant);
		
		
		
		createRow0();
		createRow1();
		createRow2();
		createRow3();
		createRow4();
		createRow5();	
		createRow6();
		createRow7();
		createRow8();
		
		for (int i = 0; i < 4; i++){
			Player1.addDisc();
			Player2.addDisc();
			}
		player1tries = Player1.getDisc();
		player2tries = Player2.getDisc();
		
		//put a prize in each slot
		prizes[0] = 100;
		prizes[1] = 500;
		prizes[2] = 1000;
		prizes[3] = 0;
		prizes[4] = 10000;
		prizes[5] = 0;
		prizes[6] = 1000;
		prizes[7] = 500;
		prizes[8] = 100;
		createPrizeRow();
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoBackground.png")));
		label.setBounds(0, 0, 624, 441);
		pnlPlinko.add(label);
		btnPlayPlinko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (currentPlayer == 1)
				{
					if (player1tries >= 0)
					{
					player1tries--;
					
					clearLabels();
					start();
					}
					
				 if (player1tries < 0)
				 {
				    	currentPlayer = 2;
				    	lblNextContestant.setText(Player2.getName() + " come on down!");
				 }
				 }
				if (currentPlayer == 2)
				{
					if (player2tries > 0)
					{
					player2tries--;
					clearLabels();
					start();
					}
					if (player2tries <= 0)
					{
						
						currentPlayer = 0; // this is where the next thing should start
						
						
					}
				}
					if (currentPlayer == 0)
						{
						btnPlayPlinko.setEnabled(false);
						btnNext.setEnabled(true);	
						}
					}
							
			
		});
	}
	
	private JLabel[] createRow0(){
		int xPos = 0;
		 row0 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row0[i] = new JLabel("");
			row0[i].setBounds(47 + xPos, 83, 46,14 );
			row0[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			xPos += 56;
			pnlPlinko.add(row0[i]);
			
		}
			return row0;
	}
	private JLabel[] createRow1(){
		int xPos = 0;
		row1 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row1[i] = new JLabel("");
			row1[i].setBounds(47 + xPos, 108, 46, 14 );
			row1[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			xPos += 56;
			pnlPlinko.add(row1[i]);
			
		}
		return row1;
	}
	private JLabel[] createRow2(){
		int xPos = 0;
		row2 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row2[i] = new JLabel("");
			row2[i].setBounds(47 + xPos, 133, 46,14 );
			row2[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			xPos += 56;
			pnlPlinko.add(row2[i]);
		}
			return row2;
	}
	private JLabel[] createRow3(){
		int xPos = 0;
		row3 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row3[i] = new JLabel("");
			row3[i].setBounds(47 + xPos, 158, 46,14 );
			row3[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			xPos += 56;
			pnlPlinko.add(row3[i]);
		}
			return row3;
	}
	private JLabel[] createRow4(){
		int xPos = 0;
		row4 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row4[i] = new JLabel("");
			row4[i].setBounds(47 + xPos, 183, 46,14 );
			row4[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			xPos += 56;
			pnlPlinko.add(row4[i]);
		}
			return row4;
	}
	private JLabel[] createRow5(){
		int xPos = 0;
		row5 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row5[i] = new JLabel("");
			row5[i].setBounds(47 + xPos, 208, 46,14 );
			row5[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			xPos += 56;
			pnlPlinko.add(row5[i]);
		}
			return row5;
	}
	private JLabel[] createRow6(){
		int xPos = 0;
		row6 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row6[i] = new JLabel("");
			row6[i].setBounds(47 + xPos, 233, 46,14 );
			row6[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			xPos += 56;
			pnlPlinko.add(row6[i]);
		}
			return row6;
	}
	private JLabel[] createRow7(){
		int xPos = 0;
		row7 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row7[i] = new JLabel("");
			row7[i].setBounds(47 + xPos, 258, 46,14 );
			row7[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			xPos += 56;
			pnlPlinko.add(row7[i]);
		}
			return row7;
	}
	private JLabel[] createRow8(){
		int xPos = 0;
		row8 = new JLabel[9];
		for (int i = 0; i < 9; i++){
			row8[i] = new JLabel("");
			row8[i].setBounds(47 + xPos, 283, 46,14 );
			row8[i].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/Plinkoblock.png")));
			
			xPos += 56;
			pnlPlinko.add(row8[i]);
		}
			return row8;
	}
	private JLabel[] createPrizeRow(){
		int xPos = 0;
		prizeRow = new JLabel[9];
		for (int i = 0; i < 9; i++){

			prizeRow[i] = new JLabel(prizes[i] + "");
			prizeRow[i].setBounds(47 + xPos, 308, 46,14 );
			xPos += 56;
			pnlPlinko.add(prizeRow[i]);
		}
			return prizeRow;
	}
	
	public void start()
	{		
			
				int p =	ballPath(); // final position of the ball
				if (currentPlayer == 1){
				
				Player1.setPoints(prizes[p]); 
				Player1.removeDisc();
				lblP1Points.setText(Player1.getPoints() + "");
				lblP1ChipsLeft.setText(player1tries + "");
				}
				else if (currentPlayer == 2){
				
				Player2.setPoints(prizes[p]);
				Player2.removeDisc();
				lblP2Points.setText(Player2.getPoints() + "");
				lblP2ChipsLeft.setText(player2tries + "");
				}
		
	}
	

	public int ballPath()
	{
	    int ballPosition = (int) (Math.random() * 9);
	   
	    
	    for(int i = 0; i < NUM_SLOTS; i++)//up and down
	    {
	    	if(Math.random() * 11 <= 5) // gen a number 0-10 and if it's 0-5 go right, otherwise go left
	        {
	            ballPosition++;
	            
	            if(ballPosition >= NUM_SLOTS)
	                ballPosition--;
	        }
	        else
	        {   ballPosition--;

	            if(ballPosition < 0)
	                ballPosition++;
	           
	        }
	    	//find the current row
	    	switch(i) 
    		{
    		case 0: currentRow = row0;
    		break;
    		case 1: currentRow = row1;
    		break;
    		case 2: currentRow = row2;
    		break;
    		case 3: currentRow = row3;
    		break;
    		case 4: currentRow = row4;
    		break;
    		case 5: currentRow = row5;
    		break;
    		case 6: currentRow = row6;
    		break;
    		case 7: currentRow = row7;
    		break;
    		case 8: currentRow = row8;
    		break;
    		}
	    	currentRow[ballPosition].setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoclicked.png")));
    		
    	
	    }
	    return ballPosition;
	}
	
	private static void clearLabels()
	{
		for (int i = 0; i < 9; i++)
		{
			switch(i) //find the current row
    		{
    		case 0: currentRow = row0;
    		break;
    		case 1: currentRow = row1;
    		break;
    		case 2: currentRow = row2;
    		break;
    		case 3: currentRow = row3;
    		break;
    		case 4: currentRow = row4;
    		break;
    		case 5: currentRow = row5;
    		break;
    		case 6: currentRow = row6;
    		break;
    		case 7: currentRow = row7;
    		break;
    		case 8: currentRow = row8;
    		break;
    		
    		}
			for (JLabel j : currentRow)
			{
				j.setIcon(new ImageIcon(guiPlinko.class.getResource("/img/plinkoblock.png")));
			}
		}
			}
	private void close()
	{
		this.dispose();
	}
}
