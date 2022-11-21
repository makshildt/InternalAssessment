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
import java.sql.ResultSet;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Insets;

//Primary key means has to be unique, this means it can be used in other tables aswell
//foreign keys unique attributed, used to link 2 tables together, 

public class ZZZMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfNameNewTeam;
	private JLabel lbAddNewTeam;
	private JLabel lbTestName;
	int ArrayCounter = 0;

	Team[] teams = new Team[10];
	int numTeams = 0;
	JLabel[] labels = new JLabel[10];
	int numLabels = 0;

	//FONTS 
	Font normaltext = new Font("Monospaced", Font.PLAIN, 20);
	Font title = new Font("Monospaced", Font.PLAIN, 30);
	public static String team = "Team: "; 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//TestDb db = new TestDb();
	

		//EXAMPLE CODE FOR QUEREY
//		try {
//			db.connect();
//			ResultSet resultSet = db.query("SELECT first_name FROM USERS;");
//
//			while (resultSet.next()) {
//				String name = resultSet.getString(1);
//				System.out.println(name);
//			}
//
//			db.disconnect();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				ZZZMainFrame frame = new ZZZMainFrame();
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
	public ZZZMainFrame() {
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
		
		//GIRD LAYOUT MAKES LABELS STACK ON TOP OF EACH OTHER
		JPanel panel1 = new JPanel(new GridLayout(0, 1, 10, 10));
		panel1.setBackground(Color.RED);
		PanelMain.add(panel1, "name_53911858030200");

		JLabel panelOneTitle = new JLabel("Welcome To Panel 1");
		panel1.add(panelOneTitle);
		panelOneTitle.setFont(title);
		panelOneTitle.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel panelOneTeamNames = new JLabel("Teams: ");
		panel1.add(panelOneTeamNames);
		panelOneTeamNames.setFont(normaltext);
		panelOneTeamNames.setHorizontalAlignment(SwingConstants.LEFT);
			
		// for (int i = 0; i < numTeams; i++) {
		// 	//lbTestName = new JLabel(teams[i].getName());
		// 	//anel1.add(lbTestName);
		// 	JLabel newteamone = new JLabel(teams[i].getName());
		// 	panel1.add(newteamone);
		// }

		//FOR LOOP TO ADD LABELS TO PANEL 1
		for (int i = 0; i < 10; i++) {
			JLabel newteamone = new JLabel();
			labels[i] = newteamone;
			panel1.add(newteamone);
			panel1.setFont(normaltext);
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
		
		//EVERYTIME SUBMIT IS PRESSED IT ADDS A NEW TEAM TO THE ARRAY AND INCREMENTS THE TEAM COUNTER.
		//EVERYTIME SUBMIT IS PRESSED IT ADDS A NEW LABEL TO THE ARRAY AND INCREMENTS THE LABEL COUNTER.
		JButton btnOkNewTeam = new JButton("Submit");
		btnOkNewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if a team by the same name already exists it will not add a new team and print an error message in the tfNameNewteam text field.
				for (int i = 0; i < numTeams; i++) {
					if (tfNameNewTeam.getText().equals(teams[i].getName())) {
						tfNameNewTeam.setText("Team already exists");
						return;
					}
				}
				teams[numTeams] = new Team(tfNameNewTeam.getText());
				numTeams ++;
				// lbTestName.setText(teamInfo[0]);
				// ArrayCounter = ArrayCounter + 1;
				// System.out.println(ArrayCounter);
				labels[numLabels].setText(tfNameNewTeam.getText());
				numLabels = numLabels + 1;
				tfNameNewTeam.setText("");
			}
		});
		panel2.add(btnOkNewTeam);
		


		//PANEL 3 ----------------------

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.YELLOW);
		PanelMain.add(panel3, "name_53919315779100");
		GridBagLayout gbl_panel3 = new GridBagLayout();
		gbl_panel3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel3.setLayout(gbl_panel3);
		
		JLabel lblNewLabel = new JLabel("Enter New Employees");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 1;
		panel3.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 4;
		panel3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 4;
		panel3.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 5;
		panel3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 5;
		panel3.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Year of Birth: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 6;
		panel3.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 6;
		panel3.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 7;
		panel3.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 5;
		gbc_textField_3.gridy = 7;
		panel3.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Role: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 8;
		panel3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 5;
		gbc_textField_4.gridy = 8;
		panel3.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ID: ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 9;
		panel3.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 5;
		gbc_textField_5.gridy = 9;
		panel3.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Team: ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 10;
		panel3.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 10;
		panel3.add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 11;

        String[] info = new String[6];
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //when submit button is clicked, the information is sent to the string array
				//if one of the textfields are null print an error message
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please fill out all fields");
				}
				else{
                info[0] = textField.getText();
                info[1] = textField_1.getText();
                info[2] = textField_2.getText();
                info[3] = textField_3.getText();
                info[4] = textField_4.getText();
                info[5] = textField_5.getText();
				System.out.println(Arrays.toString(info));
				}
			}
		});
		
		panel3.add(btnNewButton, gbc_btnNewButton);
		
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
};