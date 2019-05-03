package hotelManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class HotelManagementSystem {
	
	private JFrame frame;
	private JTextField txtDisplay;
	private JTextField txtFriedRice;
	private JTextField txtShawarma;
	private JTextField txtChicken;
	private JTextField txtChooseDrink;
	private JTextField txtEnterCurrency;
	
	double firstNumber;
	double secondNumber;
	double result;
	String operations;
	String answer;
	
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelManagementSystem window = new HotelManagementSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void datetime() {
		Thread datetime = new Thread()
				{
					public void run() {
						try 
						{
							for(;;)
							{
								Calendar calendar = new GregorianCalendar();
								int day = calendar.get(Calendar.DAY_OF_MONTH);
								int month = calendar.get(Calendar.MONTH);
								int year = calendar.get(Calendar.YEAR);
								
								int second = calendar.get(Calendar.SECOND);
								int minute = calendar.get(Calendar.MINUTE);
								int hour = calendar.get(Calendar.HOUR);
								
								lblClock.setText("Time: " + hour + ":" + minute + ":" + second + "   " + "Date: " + year + "/" + month + "/" + day);
								
								sleep(1000);
							}
						}
						catch(Exception e)
						{
							
						}
					}
				};
		datetime.start();
	}

	/**
	 * Create the application.
	 */
	public HotelManagementSystem() {
		initialize();
		datetime();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1370, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		panel.setBounds(10, 71, 412, 597);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 392, 575);
		panel.add(tabbedPane);
		
		//=========================Calculator=======================
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Calculator", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 11, 383, 541);
		panel_3.add(panel_5);
		
		txtDisplay = new JTextField();
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtDisplay.setColumns(10);
		txtDisplay.setBounds(22, 11, 343, 44);
		panel_5.add(txtDisplay);
		
		//Calculator Row 01
		
		JButton btnBackSpace = new JButton("\uF0E7");
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtDisplay.getText().length()>0) {
					String btnBackSpace = null;
					StringBuilder stringBuilder = new StringBuilder(txtDisplay.getText());
					stringBuilder.deleteCharAt(txtDisplay.getText().length()-1);
					btnBackSpace = stringBuilder.toString();
					txtDisplay.setText(btnBackSpace);
				}
			}
		});
		btnBackSpace.setFont(new Font("Dialog", Font.BOLD, 40));
		btnBackSpace.setBounds(22, 66, 80, 80);
		panel_5.add(btnBackSpace);
		
		JButton btnModulus = new JButton("%");
		btnModulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				firstNumber = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "%";
			}
		});
		btnModulus.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnModulus.setBounds(195, 66, 80, 80);
		panel_5.add(btnModulus);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDisplay.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 60));
		btnClear.setBounds(108, 66, 80, 80);
		panel_5.add(btnClear);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				firstNumber = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
			    operations = "+";
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnAdd.setBounds(285, 66, 80, 80);
		panel_5.add(btnAdd);
		
		//Calculator Row 02
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNumber = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "-";
			}
		});
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnMinus.setBounds(285, 157, 80, 80);
		panel_5.add(btnMinus);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn9.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn9.setBounds(195, 157, 80, 80);
		panel_5.add(btn9);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String EnterValue = txtDisplay.getText()+btn8.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn8.setBounds(108, 157, 80, 80);
		panel_5.add(btn8);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn7.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn7.setBounds(22, 157, 80, 80);
		panel_5.add(btn7);
		
		//Calculator Row 03
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn4.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn4.setBounds(22, 243, 80, 80);
		panel_5.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn5.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn5.setBounds(108, 243, 80, 80);
		panel_5.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn6.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn6.setBounds(195, 243, 80, 80);
		panel_5.add(btn6);
		
		JButton btnMul = new JButton("X");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				firstNumber = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "X";
			}
		});
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 65));
		btnMul.setBounds(285, 243, 80, 80);
		panel_5.add(btnMul);
		
		//Calculator Row 04
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn1.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn1.setBounds(22, 328, 80, 80);
		panel_5.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn2.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn2.setBounds(108, 328, 80, 80);
		panel_5.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn3.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn3.setBounds(195, 328, 80, 80);
		panel_5.add(btn3);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNumber = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "/";
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 55));
		btnDiv.setBounds(285, 328, 80, 80);
		panel_5.add(btnDiv);
		
		//Calculator Row 05
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				secondNumber = Double.parseDouble(txtDisplay.getText());
				
				if(operations == "+") {
					result = firstNumber + secondNumber;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				else if(operations == "-") {
					result = firstNumber - secondNumber;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				else if(operations == "X") {
					result = firstNumber * secondNumber;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				else if(operations == "/") {
					result = firstNumber / secondNumber;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}
				else if(operations == "%") {
					result = firstNumber % secondNumber;
					answer = String.format("%.2f", result);
					txtDisplay.setText(answer);
				}	
			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 55));
		btnEqual.setBounds(285, 415, 80, 80);
		panel_5.add(btnEqual);
		
		JButton btnAddMinus = new JButton("\u00B1");
		btnAddMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double plusMinus = Double.parseDouble(String.valueOf(txtDisplay.getText()));
				plusMinus = plusMinus*(-1);
				txtDisplay.setText(String.valueOf(plusMinus));
			}
		});
		btnAddMinus.setFont(new Font("Tahoma", Font.BOLD, 55));
		btnAddMinus.setBounds(195, 415, 80, 80);
		panel_5.add(btnAddMinus);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btnDot.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 70));
		btnDot.setBounds(108, 415, 80, 80);
		panel_5.add(btnDot);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterValue = txtDisplay.getText()+btn0.getText();
				txtDisplay.setText(EnterValue);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 70));
		btn0.setBounds(22, 415, 80, 80);
		panel_5.add(btn0);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_4, null);
		panel_4.setLayout(null);
		
		JTextArea ReceiptArea = new JTextArea();
		ReceiptArea.setBounds(0, 0, 387, 547);
		panel_4.add(ReceiptArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		panel_1.setBounds(427, 167, 907, 295);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.BLUE);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblMenu.setBounds(20, 23, 103, 31);
		panel_1.add(lblMenu);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(Color.BLUE);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblQuantity.setBounds(210, 23, 121, 31);
		panel_1.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price $");
		lblPrice.setForeground(Color.BLUE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblPrice.setBounds(382, 23, 103, 31);
		panel_1.add(lblPrice);
		
		JLabel btnFriedRice = new JLabel("Fried Rice ");
		btnFriedRice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFriedRice.setBounds(20, 58, 103, 31);
		panel_1.add(btnFriedRice);
		
		JLabel btnSharwama = new JLabel("Shawarma");
		btnSharwama.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSharwama.setBounds(20, 88, 103, 31);
		panel_1.add(btnSharwama);
		
		JLabel btnChicken = new JLabel("Chicken");
		btnChicken.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChicken.setBounds(20, 118, 103, 31);
		panel_1.add(btnChicken);
		
		JComboBox btnChooseDrink = new JComboBox();
		btnChooseDrink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChooseDrink.setModel(new DefaultComboBoxModel(new String[] {"Choose a drink", "Coca Cola", "Heineken", "Pepsi"}));
		btnChooseDrink.setBounds(20, 151, 161, 25);
		panel_1.add(btnChooseDrink);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 187, 474, 2);
		panel_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(516, 23, 2, 253);
		panel_1.add(separator_3);
		
		JComboBox btnChooseRoom = new JComboBox();
		btnChooseRoom.setModel(new DefaultComboBoxModel(new String[] {"Choose a room", "101", "201", "VIP"}));
		btnChooseRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChooseRoom.setBounds(20, 200, 161, 25);
		panel_1.add(btnChooseRoom);
		
		JCheckBox btnDelivery = new JCheckBox("Delivery");
		btnDelivery.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelivery.setBounds(20, 232, 121, 23);
		panel_1.add(btnDelivery);
		
		JCheckBox btnTax = new JCheckBox("Tax");
		btnTax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTax.setBounds(20, 253, 97, 23);
		panel_1.add(btnTax);
		
		txtFriedRice = new JTextField();
		txtFriedRice.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtFriedRice.setBounds(210, 58, 121, 25);
		panel_1.add(txtFriedRice);
		txtFriedRice.setColumns(10);
		
		txtShawarma = new JTextField();
		txtShawarma.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtShawarma.setColumns(10);
		txtShawarma.setBounds(210, 88, 121, 25);
		panel_1.add(txtShawarma);
		
		txtChicken = new JTextField();
		txtChicken.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtChicken.setColumns(10);
		txtChicken.setBounds(210, 118, 121, 25);
		panel_1.add(txtChicken);
		
		txtChooseDrink = new JTextField();
		txtChooseDrink.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtChooseDrink.setColumns(10);
		txtChooseDrink.setBounds(210, 151, 121, 25);
		panel_1.add(txtChooseDrink);
		
		JLabel lblNewLabel_1 = new JLabel("5.676");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(382, 62, 86, 23);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_4 = new JLabel("3.987");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(382, 92, 86, 23);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("11.452");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(382, 122, 86, 23);
		panel_1.add(label_5);
		
		JLabel label = new JLabel("   -");
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(382, 150, 86, 23);
		panel_1.add(label);
		
		JLabel lblCurrencyConvertor = new JLabel("Currency Converter");
		lblCurrencyConvertor.setForeground(Color.BLUE);
		lblCurrencyConvertor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblCurrencyConvertor.setBounds(560, 23, 256, 31);
		panel_1.add(lblCurrencyConvertor);
		
		JComboBox btnSelectCountry = new JComboBox();
		btnSelectCountry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSelectCountry.setModel(new DefaultComboBoxModel(new String[] {"Country", "Nigeria ", "Kenya", "China ", "India"}));
		btnSelectCountry.setBounds(553, 66, 274, 31);
		panel_1.add(btnSelectCountry);
		
		txtEnterCurrency = new JTextField();
		txtEnterCurrency.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtEnterCurrency.setColumns(10);
		txtEnterCurrency.setBounds(553, 118, 274, 31);
		panel_1.add(txtEnterCurrency);
		
		JLabel txtConvertedMoney = new JLabel("");
		txtConvertedMoney.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtConvertedMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtConvertedMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtConvertedMoney.setBounds(553, 175, 274, 31);
		panel_1.add(txtConvertedMoney);
		
		//Reset button for currency section
		
		JButton btnReset2 = new JButton("Reset");
		btnReset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtEnterCurrency.setText(null);
				txtConvertedMoney.setText(null);
				btnSelectCountry.setSelectedItem("Country");
			}
		});
		btnReset2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset2.setBounds(706, 228, 121, 31);
		panel_1.add(btnReset2);
		
		//Convert
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double USA_Dollar = Double.parseDouble(txtEnterCurrency.getText()); //First we have to enter value in USA Dollars
				
				double Nigerian_Naira = 360.00;
				double Kenyan_Shilling = 101.00;
				double Chinese_Yuan = 6.29;
				double Indian_Rupee = 65.02;
				
				if(btnSelectCountry.getSelectedItem().equals("Nigeria"))
				{
					String Naira = String.format("N %.2f", USA_Dollar*Nigerian_Naira);
					txtConvertedMoney.setText(Naira);
				}
				if(btnSelectCountry.getSelectedItem().equals("Kenya"))
				{
					String Shilling = String.format("KS %.2f", USA_Dollar*Kenyan_Shilling);
					txtConvertedMoney.setText(Shilling);
				}
				if(btnSelectCountry.getSelectedItem().equals("China"))
				{
					String Yuan = String.format("CY %.2f", USA_Dollar*Chinese_Yuan);
					txtConvertedMoney.setText(Yuan);
				}
				if(btnSelectCountry.getSelectedItem().equals("India"))
				{
					String Rupee = String.format("INR %.2f", USA_Dollar*Indian_Rupee);
					txtConvertedMoney.setText(Rupee);
				}
			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConvert.setBounds(553, 228, 121, 31);
		panel_1.add(btnConvert);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(427, 465, 907, 203);
		frame.getContentPane().add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 10, true));
		panel_2.setLayout(null);
		
		JLabel btnTotalCostOfMeal = new JLabel("Total cost of meal");
		btnTotalCostOfMeal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTotalCostOfMeal.setBounds(22, 23, 172, 31);
		panel_2.add(btnTotalCostOfMeal);
		
		JLabel btnTotalCostOfDrink = new JLabel("Total cost of drink");
		btnTotalCostOfDrink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTotalCostOfDrink.setBounds(22, 65, 172, 31);
		panel_2.add(btnTotalCostOfDrink);
		
		JLabel btnCostOfDelivery = new JLabel("Cost of delivery");
		btnCostOfDelivery.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCostOfDelivery.setBounds(22, 107, 172, 31);
		panel_2.add(btnCostOfDelivery);
		
		JLabel lblCostOfRoom = new JLabel("Cost of room");
		lblCostOfRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCostOfRoom.setBounds(22, 149, 172, 31);
		panel_2.add(lblCostOfRoom);
		
		JLabel txtTotalCostOfMeal = new JLabel("");
		txtTotalCostOfMeal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalCostOfMeal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotalCostOfMeal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtTotalCostOfMeal.setBounds(210, 23, 274, 31);
		panel_2.add(txtTotalCostOfMeal);
		
		JLabel txtTotalCostOfDrink = new JLabel("");
		txtTotalCostOfDrink.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalCostOfDrink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotalCostOfDrink.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtTotalCostOfDrink.setBounds(210, 65, 274, 31);
		panel_2.add(txtTotalCostOfDrink);
		
		JLabel txtCostOfDelivery = new JLabel("");
		txtCostOfDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		txtCostOfDelivery.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCostOfDelivery.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtCostOfDelivery.setBounds(210, 107, 274, 31);
		panel_2.add(txtCostOfDelivery);
		
		JLabel txtCostOfRoom = new JLabel("");
		txtCostOfRoom.setHorizontalAlignment(SwingConstants.CENTER);
		txtCostOfRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCostOfRoom.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtCostOfRoom.setBounds(210, 149, 274, 31);
		panel_2.add(txtCostOfRoom);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(518, 23, 2, 157);
		panel_2.add(separator_4);
		
		JLabel btnTaxPay = new JLabel("Tax");
		btnTaxPay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTaxPay.setBounds(545, 65, 106, 31);
		panel_2.add(btnTaxPay);
		
		JLabel btnSubTotal = new JLabel("Sub Total");
		btnSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubTotal.setBounds(545, 107, 106, 31);
		panel_2.add(btnSubTotal);
		
		JLabel btnTotal = new JLabel("Total");
		btnTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTotal.setBounds(545, 149, 106, 31);
		panel_2.add(btnTotal);
		
		JLabel txtTax = new JLabel("");
		txtTax.setHorizontalAlignment(SwingConstants.CENTER);
		txtTax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTax.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtTax.setBounds(675, 65, 195, 31);
		panel_2.add(txtTax);
		
		JLabel txtTotal = new JLabel("");
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtTotal.setBounds(675, 149, 195, 31);
		panel_2.add(txtTotal);
		
		JLabel txtSubTotal = new JLabel("");
		txtSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtSubTotal.setBounds(675, 107, 195, 31);
		panel_2.add(txtSubTotal);
		
		lblClock = new JLabel("Clock");
		lblClock.setHorizontalAlignment(SwingConstants.LEFT);
		lblClock.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblClock.setBounds(545, 23, 325, 31);
		panel_2.add(lblClock);
		
		JLabel lblNewLabel = new JLabel("Hotel Management System");
		lblNewLabel.setBounds(460, 71, 848, 85);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 63));
		
		//Drinks
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double Drinks = Double.parseDouble(txtChooseDrink.getText());
				double CocaCola = 0.957*Drinks;
				double Heineken = 2.432*Drinks;
				double Pepsi = 1.674*Drinks;
				
				if(btnChooseDrink.getSelectedItem().equals("Coca Cola"))
						{
							String pCoca_Cola = String.format("%.3f", CocaCola);
							txtTotalCostOfDrink.setText(pCoca_Cola);
						}
				if(btnChooseDrink.getSelectedItem().equals("Heineken"))
						{
							String pHeineken = String.format("%.3f", Heineken);
							txtTotalCostOfDrink.setText(pHeineken);
						}
				if(btnChooseDrink.getSelectedItem().equals("Pepsi"))
						{
							String pPepsi = String.format("%.3f", Pepsi);
							txtTotalCostOfDrink.setText(pPepsi);
						}
				if(btnChooseDrink.getSelectedItem().equals("Choose a drink"))
						{
							txtTotalCostOfDrink.setText("0.000");
						}
				
				//Meals
				
				double FriedRice = Double.parseDouble(txtFriedRice.getText());
				double pFriedRice = 5.676;
				double getFriedRice;
				getFriedRice = (FriedRice*pFriedRice);
				String TotalFriedRice = String.format("%.3f", getFriedRice);
				txtTotalCostOfMeal.setText(TotalFriedRice);
				
				double Shawarma = Double.parseDouble(txtShawarma.getText());
				double pShawarma = 3.987;
				double getShawarma;
				getShawarma = (Shawarma*pShawarma);
				String TotalShawarma = String.format("%.3f", getShawarma + getFriedRice);
				txtTotalCostOfMeal.setText(TotalShawarma);
				
				double Chicken = Double.parseDouble(txtChicken.getText());
				double pChicken = 9.452;
				double getChicken;
				getChicken = (Chicken*pChicken);
				String TotalChicken = String.format("%.3f", getShawarma + getFriedRice + getChicken);
				txtTotalCostOfMeal.setText(TotalChicken);
				
				//Room
				
				double room1 = 5.00;
				double room2 = 10.00;
				double roomVIP = 20.00;
				
				if(btnChooseRoom.getSelectedItem().equals("101"))
						{
							String aroom1 = String.format("%.3f", room1);
							txtCostOfRoom.setText(aroom1);
						}
				if(btnChooseRoom.getSelectedItem().equals("201"))
						{
							String aroom2 = String.format("%.3f", room2);
							txtCostOfRoom.setText(aroom2);
						}
				if(btnChooseRoom.getSelectedItem().equals("VIP"))
						{
							String aroomVIP = String.format("%.3f", roomVIP);
							txtCostOfRoom.setText(aroomVIP);
						}
				if(btnChooseRoom.getSelectedItem().equals("Choose a room"))
						{
							txtCostOfRoom.setText("0.000");
						}
				
				//Delivery
				
				double cDelivery = 4.50;
				if(btnDelivery.isSelected())
					{
						String pDelivery = String.format("%.3f", cDelivery);
						txtCostOfDelivery.setText(pDelivery);
					
					}
				else
					{
						txtCostOfDelivery.setText("0.000");
					}
				
				//Tax
				
				double pTotal1 = Double.parseDouble(txtTotalCostOfMeal.getText());
				double pTotal2 = Double.parseDouble(txtTotalCostOfDrink.getText());
				double pTotal3 = Double.parseDouble(txtCostOfDelivery.getText());
				double cTotal = (pTotal1 + pTotal2 + pTotal3)*2.5/100;
				
				if(btnTax.isSelected())
					{
						String dTotal = String.format("%.3f", cTotal);
						txtTax.setText(dTotal);
					}
				else
					{
						txtTax.setText("0.000");
					}
				
				//Total
				
				double pTotal4 = Double.parseDouble(txtTax.getText());
				double pTotal5 = Double.parseDouble(txtCostOfRoom.getText());
				
				double SubTotal = (pTotal1 + pTotal2 + pTotal3+ pTotal5);
				String pSubTotal = String.format("$%.3f", SubTotal);
				txtSubTotal.setText(pSubTotal);
				
				double xTotal = (pTotal1 + pTotal2 + pTotal3 + pTotal4 + pTotal5);
				String yTotal = String.format("$%.3f", xTotal);
				txtTotal.setText(yTotal);
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBounds(210, 228, 121, 31);
		panel_1.add(btnSubmit);
		
		//Reset
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFriedRice.setText(null);
				txtShawarma.setText(null);
				txtChicken.setText(null);
				txtChooseDrink.setText(null);
				txtTotalCostOfMeal.setText(null);
				txtTotalCostOfDrink.setText(null);
				txtCostOfDelivery.setText(null);
				txtCostOfRoom.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				txtEnterCurrency.setText(null);
				txtConvertedMoney.setText(null);
				txtDisplay.setText(null);
				btnChooseDrink.setSelectedItem("Choose a drink");
				btnChooseRoom.setSelectedItem("Choose a room");
				btnSelectCountry.setSelectedItem("Country");
				ReceiptArea.setText(null);
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(364, 228, 121, 31);
		panel_1.add(btnReset);
		
		//================Menu bar all=====================
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 1324, 39);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnFile);
		
		JMenu mnNewMenu = new JMenu("New");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnFile.add(mnNewMenu);
		
		//Receipt for customer
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Receipt");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double Invoice1 = Double.parseDouble(txtFriedRice.getText());
				Double Invoice2 = Double.parseDouble(txtShawarma.getText());
				Double Invoice3 = Double.parseDouble(txtChicken.getText());
				Double Invoice4 = Double.parseDouble(txtChooseDrink.getText());
				
				ReceiptArea.append("\t\nHotel Management System :\n");
				ReceiptArea.append("\nFried Rice  \t" +Invoice1);
				ReceiptArea.append("\nShawarma    \t" +Invoice2);
				ReceiptArea.append("\nChicken     \t" +Invoice3);
				ReceiptArea.append("\n" + btnChooseDrink.getSelectedItem() + "\t" +Invoice4);
				ReceiptArea.append("\nTotal       \t" +txtTotal.getText());
				ReceiptArea.append("\n\nWelcome and Thank you for your patronage");
				
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu.add(mntmNewMenuItem);
		
		//Reset
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Reset");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtFriedRice.setText(null);
				txtShawarma.setText(null);
				txtChicken.setText(null);
				txtChooseDrink.setText(null);
				txtTotalCostOfMeal.setText(null);
				txtTotalCostOfDrink.setText(null);
				txtCostOfDelivery.setText(null);
				txtCostOfRoom.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				txtEnterCurrency.setText(null);
				txtConvertedMoney.setText(null);
				txtDisplay.setText(null);
				btnChooseDrink.setSelectedItem("Choose a drink");
				btnChooseRoom.setSelectedItem("Choose a room");
				btnSelectCountry.setSelectedItem("Country");
				ReceiptArea.setText(null);
				
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		//Refresh 
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Refresh");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtFriedRice.setText(null);
				txtShawarma.setText(null);
				txtChicken.setText(null);
				txtChooseDrink.setText(null);
				txtTotalCostOfMeal.setText(null);
				txtTotalCostOfDrink.setText(null);
				txtCostOfDelivery.setText(null);
				txtCostOfRoom.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				txtEnterCurrency.setText(null);
				txtConvertedMoney.setText(null);
				txtDisplay.setText(null);
				btnChooseDrink.setSelectedItem("Choose a drink");
				btnChooseRoom.setSelectedItem("Choose a room");
				btnSelectCountry.setSelectedItem("Country");
				ReceiptArea.setText(null);
				
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnFile.add(mntmNewMenuItem_3);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		//Exit
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Exit");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mntmNewMenuItem_4.setForeground(Color.RED);
		mnFile.add(mntmNewMenuItem_4);
		
		JPanel panel_6 = new JPanel();
		menuBar.add(panel_6);
	}
}
