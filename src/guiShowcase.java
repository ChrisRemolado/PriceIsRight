import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class guiShowcase extends JFrame
{
	ArrayList<Item> cars, vacations;
	Scanner scan = new Scanner(System.in);
	private int carBid, vacaBid, carPrice, vacationPrice, p1Diff, p2Diff, winner, showcaseIndex;
	private static int vacaPlayer, carPlayer;
	private JPanel contentPane;
	private JLabel lblP2Points, lblP1Points, lblP1Name, lblP2Name, lblPrompt;
	private Color lightBlue = new Color(174,196,251), darkBlue = new Color(22,58,152);
	private JButton btnP2Bid;
	private JButton btnPass;
	private JButton btnP1Bid, btnContinueToSummary;
	private JButton btnGo;
	private JTextField txtP1;
	private JTextField txtP2;
	private int carIndex, vacaIndex;
	private JButton btnP1Bid2;
	private JLabel lblPrompt3, lblPrompt2;
	private JLabel lblP1ShowcaseName;
	private JLabel lblP2ShowcaseName;
	private JLabel lblWinner, lblWin;
	private JButton btnNext;
	
	
	public guiShowcase() {
		
		setTitle("Showcase");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNext = new JButton("Next");
		
		btnNext.setEnabled(false);
		btnNext.setVisible(false);
		
		lblWin = new JLabel("");
		lblWin.setBounds(10, 11, 604, 123);
		lblWin.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		lblWin.setForeground(darkBlue);
		lblWin.setVisible(false);
		
		btnContinueToSummary = new JButton("Continue to summary");
		btnContinueToSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new guiSummary().setVisible(true);
				close();
			}
		});
		btnContinueToSummary.setBounds(419, 400, 195, 34);
		contentPane.add(btnContinueToSummary);
		contentPane.add(lblWin);
		btnNext.setBounds(525, 145, 89, 23);
		btnContinueToSummary.setVisible(false);
		btnContinueToSummary.setEnabled(false);
		contentPane.add(btnNext);
		
		btnGo = new JButton("Go!");
		
		btnGo.setBounds(525, 145, 89, 23);
		contentPane.add(btnGo);
	
		
		btnPass = new JButton("Pass");
		btnPass.setBounds(57, 274, 82, 34);
		contentPane.add(btnPass);
		btnPass.setEnabled(false);
		
		btnP1Bid = new JButton("Bid!");
		btnP1Bid.setBounds(146, 274, 82, 34);
		contentPane.add(btnP1Bid);
		btnP1Bid.setEnabled(false);
		
		btnP2Bid = new JButton("Bid!");
		btnP2Bid.setBounds(443, 400, 89, 23);
		contentPane.add(btnP2Bid);
		btnP2Bid.setEnabled(false);
		
		btnP1Bid2 = new JButton("Bid!");
		btnP1Bid2.setEnabled(false);
		btnP1Bid2.setVisible(false);
		btnP1Bid2.setBounds(106, 400, 89, 23);
		contentPane.add(btnP1Bid2);
		
		txtP1 = new JTextField();
		txtP1.setToolTipText("Type only integers!");
	
		
		txtP1.setEnabled(false);
		txtP1.setBounds(106, 366, 89, 23);
		contentPane.add(txtP1);
		txtP1.setColumns(10);
		
		txtP2 = new JTextField();
		txtP2.setToolTipText("Type only integers!");
		txtP2.setEnabled(false);
		txtP2.setColumns(10);
		txtP2.setBounds(443, 366, 89, 23);
		contentPane.add(txtP2);
		
		lblP2Points = new JLabel("Player 2 Points");
		lblP2Points.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblP2Points.setBounds(389, 298, 194, 91);
		contentPane.add(lblP2Points);
		
		lblP1Points = new JLabel("Player 1 Points");
		lblP1Points.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblP1Points.setBounds(47, 298, 194, 91);
		contentPane.add(lblP1Points);
		
		lblP2Name = new JLabel(Player2.getName());
		lblP2Name.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblP2Name.setForeground(darkBlue);
		lblP2Name.setBounds(389, 191, 161, 34);
		contentPane.add(lblP2Name);
	
		lblP1Name = new JLabel(Player1.getName());
		lblP1Name.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblP1Name.setForeground(darkBlue);
		lblP1Name.setBounds(47, 191, 161, 34);
		contentPane.add(lblP1Name);
		
		lblPrompt = new JLabel("PROMPT");
		lblPrompt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrompt.setForeground(darkBlue);
		lblPrompt.setBounds(20, 60, 594, 21);
		contentPane.add(lblPrompt);
		lblPrompt.setText("You will guess the prices of showcases that are described to you.");
		
		lblPrompt2 = new JLabel("");
		lblPrompt2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrompt2.setForeground(darkBlue);
		lblPrompt2.setBounds(20, 81, 594, 39);
		contentPane.add(lblPrompt2);
		
		lblPrompt3 = new JLabel("");
		lblPrompt3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrompt3.setForeground(darkBlue);
		lblPrompt3.setBounds(20, 92, 594, 76);
		contentPane.add(lblPrompt3);
		
		lblP1ShowcaseName = new JLabel("");
		lblP1ShowcaseName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblP1ShowcaseName.setBounds(50, 179, 194, 91);
		contentPane.add(lblP1ShowcaseName);
		
		lblP2ShowcaseName = new JLabel("");
		lblP2ShowcaseName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblP2ShowcaseName.setBounds(384, 179, 194, 91);
		contentPane.add(lblP2ShowcaseName);
		
		lblWinner = new JLabel("Winner");
		lblWinner.setIcon(new ImageIcon(guiShowcase.class.getResource("/img/winnerbackground.png")));
		lblWinner.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		lblWinner.setBounds(0, 0, 624, 441);
		lblWinner.setVisible(false);
		contentPane.add(lblWinner);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(guiShowcase.class.getResource("/img/showcasebackground.png")));
		lblBackground.setBounds(0, 0, 624, 452);
		contentPane.add(lblBackground);
		
	
		//for testing purposes
		Item.fillCarItems();
		Item.fillVacaItems();
		Item.fillEmpty();
		
		cars = Item.carItems;
		vacations = Item.vacaItems;
		carIndex = (int) (Math.random() * 7);
		vacaIndex = (int) (Math.random() * 2);
		
		carPrice = (int) cars.get(carIndex).getPrice();
		vacationPrice = (int) vacations.get(vacaIndex).getPrice();
		
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPrompt.setText(vacations.get(vacaIndex).getName());
				lblPrompt2.setText(vacations.get(vacaIndex).getDescription());//"Would you like to guess its price or pass?");
				btnP1Bid.setEnabled(true);
				
				btnPass.setEnabled(true);
				btnGo.setEnabled(false);
				btnGo.setVisible(false);
				
			}
		});
		
		btnP1Bid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vacaPlayer = 1; carPlayer = 2;
				btnPass.setEnabled(false);
				btnP1Bid.setEnabled(false);
				txtP1.setEnabled(true);
				btnPass.setVisible(false);
				btnP1Bid.setVisible(false);
				btnP1Bid2.setVisible(true);
				Player1.setShowcase(vacations.get(vacaIndex));
				lblP1ShowcaseName.setText(Player1.getShowcase().getName());
				lblPrompt3.setText("Now please enter your bid to the nearest dollar.");
			}
		});
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			pass();
			
						
			}
		});
		btnP1Bid2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			p1Bid();		
				
			}
		});
		btnP2Bid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				p2Bid();
			}
		});
	
		txtP1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				btnP1Bid2.setEnabled(true);
				
			}
		});
		txtP2.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent arg0)
			{
				btnP2Bid.setEnabled(true);
				
			}
		});
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compare();
				btnNext.setEnabled(false);
			}
		});
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiShowcase frame = new guiShowcase();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void compare()
	{
		
		//compare
		
		lblPrompt.setText("");
		lblPrompt2.setText("");
		lblPrompt3.setText("");
		p1Diff = Math.abs(Player1.getShowcaseBid() - Player1.getReal());
		p2Diff = Math.abs(Player2.getShowcaseBid() - Player2.getReal());
		lblP1ShowcaseName.setBounds(47,231,lblP1ShowcaseName.getWidth(), lblP1ShowcaseName.getHeight());
		lblP1ShowcaseName.setText("<html>" + Player1.getName() + ", you guessed: " + Player1.getShowcaseBid() +"<br> on your showcase of " + Player1.getShowcase().getName()
				+ ". <br>The actual price was " + Player1.getReal() + "</html>");
		lblP1Points.setText("Difference:" + p1Diff );
		
		lblP2ShowcaseName.setBounds(384,231,lblP2ShowcaseName.getWidth(), lblP2ShowcaseName.getHeight());
		lblP2ShowcaseName.setText("<html>" + Player2.getName() + ", you guessed: " + Player2.getShowcaseBid() +"<br> on your showcase of "  + Player2.getShowcase().getName()
				+ ". <br>The actual price was " + Player2.getReal() + "</html>");
		lblP2Points.setText("Difference:" + p2Diff );
		
		lblWinner.setVisible(true);
		lblWin.setVisible(true);
		
		if (p1Diff < p2Diff)
			winner = 1;
		else winner = 2;
		
		
		if (winner == 1)
		{
			lblWin.setText("<html>" + Player1.getName() + " won the showcase showdown!</html>");
			Player2.setShowcase(Item.empty.get(0));
		}
			else	
			{
			lblWin.setText("<html>" + Player2.getName() + " won the showcase showdown!</html>");
			Player1.setShowcase(Item.empty.get(0));
			}
		btnContinueToSummary.setEnabled(true);btnContinueToSummary.setVisible(true);
	}
	
	private void p1Bid()
	{

		if (vacaPlayer == 1)
		{
	try
	{
		vacaBid = (new Integer(txtP1.getText())).intValue();
	}
	catch 	(NumberFormatException e)
	{
		vacaBid = 0;
	}
		Player1.setShowcaseBidAndActual(vacaBid, vacations.get(vacaIndex).getPrice());
		Player2.setShowcase(cars.get(carIndex));
		lblP1ShowcaseName.setText(Player1.getShowcase().getName());
		lblPrompt.setText(Player2.getName() + ", your showcase is");
		lblPrompt2.setText(cars.get(carIndex).getName());
		lblPrompt3.setText("<html>" + cars.get(carIndex).getDescription() + "</html>");
		lblP2ShowcaseName.setText(cars.get(carIndex).getName());
		txtP2.setEnabled(true);
		lblP1Points.setText(vacaBid + "");
		

		btnP1Bid2.setEnabled(false);
		btnP1Bid2.setVisible(false);
		txtP1.setEnabled(false);
		p2Bid();
		}
		
		else
		{
		Player1.setShowcase(cars.get(carIndex));
		lblPrompt.setText(Player1.getName() + "\'s showcase is");
		lblPrompt2.setText(Player1.getShowcase().getName());
		lblPrompt3.setText("<html>"+ Player1.getShowcase().getDescription() + "</html>");
		lblP1ShowcaseName.setText(Player1.getShowcase().getName());
		try
		{
			carBid = (new Integer(txtP1.getText())).intValue();
		}
		catch 	(NumberFormatException e)
		{
			carBid = 0;
		}
		Player1.setShowcaseBidAndActual(carBid, cars.get(carIndex).getPrice());
		lblP1Points.setText(carBid + "");

		btnP1Bid2.setEnabled(false);
		btnP1Bid2.setVisible(false);
		txtP1.setEnabled(false);
		
		btnNext.setVisible(true);
		btnNext.setEnabled(true);
		}
	}
	private void p2Bid()
	{
		if (carPlayer == 2)
		{
			try
			{
				carBid = (new Integer(txtP2.getText())).intValue();
			}
			catch 	(NumberFormatException e)
			{
				carBid = 0;
			}
		Player2.setShowcaseBidAndActual(carBid, cars.get(carIndex).getPrice());

		lblP2Points.setText(carBid + "");
		btnP2Bid.setEnabled(false);
		btnP2Bid.setVisible(false);
		txtP2.setEnabled(false);
		//NEXT
		btnNext.setVisible(true);
		btnNext.setEnabled(true);
		}
		else
		{
		
		lblPrompt3.setText(Player2.getName() + " please bid!");
		Player2.setShowcase(vacations.get(vacaIndex));
		lblP2ShowcaseName.setText(Player2.getShowcase().getName());
			
		try
		{
			vacaBid = (new Integer(txtP2.getText())).intValue();
		}
		catch 	(NumberFormatException e)
		{
			vacaBid = 0;
		}
		Player2.setShowcaseBidAndActual(vacaBid, vacations.get(vacaIndex).getPrice());

		txtP1.setEnabled(true);
		btnP1Bid2.setEnabled(true);

		lblP2Points.setText(vacaBid + "");
		btnP2Bid.setEnabled(false);
		btnP2Bid.setVisible(false);
		txtP2.setEnabled(false);
		
		
	
		}
	
		
	}
	private void pass()
	{
		vacaPlayer = 2; carPlayer = 1;
		btnPass.setEnabled(false);
		btnPass.setVisible(false);
		btnP1Bid.setVisible(false);
		btnP1Bid.setEnabled(false);
		btnP1Bid2.setEnabled(false);
		btnP1Bid2.setVisible(true);
		txtP2.setEnabled(true);
		txtP1.setEnabled(false);
		
	}
	public void close()
	{
		this.dispose();
	}
}
