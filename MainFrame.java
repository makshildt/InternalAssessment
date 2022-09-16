import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfNameNewTeam;
	private JLabel lbAddNewTeam;
	private JLabel lbTestName;
	String teamInfo[] = {"nameofcomp, testcrit"};
	int ArrayCounter = 0;

	Team[] teams = new Team[5];
	int numTeams = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setFont(new Font("Agency FB", Font.PLAIN, 12));
		setTitle("Universal Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//COMPONENTS
		
		JPanel PanelLeft = new JPanel();
		PanelLeft.setBackground(Color.LIGHT_GRAY);
		PanelLeft.setBounds(0, 0, 100, 461);
		contentPane.add(PanelLeft);
		
		JButton btn1 = new JButton("View Teams");
		PanelLeft.add(btn1);
		
		JButton btn2 = new JButton("Add Teams");
		PanelLeft.add(btn2);
		
		JButton btn3 = new JButton("Add Employees");
		PanelLeft.add(btn3);
		
		JButton btn4 = new JButton("Add Tasks & Deadlines");
		PanelLeft.add(btn4);
		
		JButton btn5 = new JButton("Visual Representation");
		PanelLeft.add(btn5);
		
		JButton btn0 = new JButton("Home");
		PanelLeft.add(btn0);
		
		JPanel PanelMain = new JPanel();
		PanelMain.setBounds(100, 0, 543, 461);
		contentPane.add(PanelMain);
		PanelMain.setLayout(new CardLayout(0, 0));
		
		//PANEL 1 ----------------------
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.RED);
		PanelMain.add(panel1, "name_53911858030200");
		
		for (int i = 0; i < numTeams; i++) {
			lbTestName = new JLabel(teams[i].getName());
			panel1.add(lbTestName);
		
		}

		

		
		//PANEL 2 ----------------------
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.ORANGE);
		PanelMain.add(panel2, "name_53916439187000");
		
		lbAddNewTeam = new JLabel("Name of New Team:");
		panel2.add(lbAddNewTeam);
		
		tfNameNewTeam = new JTextField();
		panel2.add(tfNameNewTeam);
		tfNameNewTeam.setColumns(10);
		
		JButton btnOkNewTeam = new JButton("Submit");
		btnOkNewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teamInfo[0] = tfNameNewTeam.getText();
				teams[numTeams] = new Team(teamInfo[0]);
				// lbTestName.setText(teamInfo[0]);
				// ArrayCounter = ArrayCounter + 1;
				// System.out.println(ArrayCounter);
			}
		});
		panel2.add(btnOkNewTeam);
		


		//PANEL 3 ----------------------
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.YELLOW);
		PanelMain.add(panel3, "name_53919315779100");
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.GREEN);
		PanelMain.add(panel4, "name_2440391277100");
		
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.BLUE);
		PanelMain.add(panel5, "name_2465340226300");
		
		JPanel panel0 = new JPanel();
		PanelMain.add(panel0, "name_2793039368800");
		
		JLabel lbWelcome = new JLabel("Welcome To Universal Manager!");
		panel0.add(lbWelcome);
		
		//ACTIONS SWITCHING TABS
		
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel0.setVisible(true);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel0.setVisible(false);
				panel1.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel0.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(false);
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel0.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(true);
				panel4.setVisible(false);
				panel5.setVisible(false);
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel0.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(true);
				panel5.setVisible(false);
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel0.setVisible(false);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panel5.setVisible(true);
			}
		});
		
		
	}
}