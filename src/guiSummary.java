import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class guiSummary extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiSummary frame = new guiSummary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiSummary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBigWheelOne = new JLabel(Player1.getBigWheelWinnings() + "");
		lblBigWheelOne.setBounds(201, 284, 196, 54);
		lblBigWheelOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblBigWheelOne);
		
		JLabel lblPushOverOne = new JLabel();
		lblPushOverOne.setText("<html>"+ Player1.getPushOverWinnings() + "</html>");
		lblPushOverOne.setBounds(201, 224, 196, 54);
		lblPushOverOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblPushOverOne);
		
		JLabel lblPushOverTwo = new JLabel();
		lblPushOverTwo.setText("<html>"+ Player2.getPushOverWinnings() +"</html>" );
		lblPushOverTwo.setBounds(412, 224, 196, 54);
		lblPushOverTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblPushOverTwo);
		
		JLabel lblPlinkoOne = new JLabel(Player1.getPoints() + "");
		lblPlinkoOne.setBounds(201, 163, 196, 54);
		lblPlinkoOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblPlinkoOne);
		
		JLabel lblPlinkoTwo = new JLabel(Player2.getPoints() + "");
		lblPlinkoTwo.setBounds(412, 163, 196, 54);
		lblPlinkoTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblPlinkoTwo);
		
		JLabel lblCRowTwo = new JLabel(Player2.getContestantsRowWinnings() + "");
		lblCRowTwo.setBounds(412, 104, 196, 54);
		lblCRowTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCRowTwo);
		
		JLabel lblCRowOne = new JLabel(Player1.getContestantsRowWinnings() + "");
		lblCRowOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCRowOne.setBounds(201, 104, 196, 48);
		contentPane.add(lblCRowOne);
		
		JLabel lblBigWheelTwo = new JLabel(Player2.getBigWheelWinnings() + "");
		lblBigWheelTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBigWheelTwo.setBounds(412, 284, 196, 54);
		contentPane.add(lblBigWheelTwo);
		
		JLabel lblShowcaseOne = new JLabel();
		
		lblShowcaseOne.setText("<html>"+ Player1.getShowcase().getName() + "</html>" );
		lblShowcaseOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblShowcaseOne.setBounds(201, 343, 196, 54);
		contentPane.add(lblShowcaseOne);
		
		JLabel lblShowcaseTwo = new JLabel("<html>"+ Player2.getShowcase().getName() + "</html>");
		lblShowcaseTwo.setBounds(412, 343, 196, 54);
		lblShowcaseTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblShowcaseTwo);
		
		JLabel lblPlayerOneName = new JLabel(Player1.getName());
		lblPlayerOneName.setForeground(Color.CYAN);
		lblPlayerOneName.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lblPlayerOneName.setBounds(201, 21, 196, 54);
		contentPane.add(lblPlayerOneName);
		
		JLabel lblPlayerTwoName = new JLabel(Player2.getName());
		lblPlayerTwoName.setForeground(Color.CYAN);
		lblPlayerTwoName.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lblPlayerTwoName.setBounds(412, 21, 196, 54);
		contentPane.add(lblPlayerTwoName);
		
		JButton btnPlayAgain = new JButton("Play Again!");
		btnPlayAgain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new guiDriver().setVisible(true);
				close();
				
			}
		});
		btnPlayAgain.setBounds(10, 408, 306, 33);
		contentPane.add(btnPlayAgain);
		
		JButton btnClose = new JButton("Exit");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit ();
			}
		});
		btnClose.setBounds(326, 407, 288, 34);
		contentPane.add(btnClose);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setForeground(Color.CYAN);
		lblSummary.setFont(new Font("Showcard Gothic", Font.PLAIN, 25));
		lblSummary.setBounds(10, 11, 181, 75);
		contentPane.add(lblSummary);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(guiSummary.class.getResource("/img/guiSummary.png")));
		label.setBounds(-10, -10, 640, 480);
		contentPane.add(label);
	}
	public void exit()
	{
		System.exit(0);
	}
	public void close()
	{
		this.dispose();
	}
	
}
