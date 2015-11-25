package app;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.Font;

public class BHD_beta extends JFrame {
	private static final long serialVersionUID = 1L;

	// Strings containing converted data
	private String finalHex, binToDeciTable, deciToBinary, finalDeciHex, hexDeciTable, hexBinTable;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BHD_beta frame = new BHD_beta();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Unhandled exception occured starting the application");
				}
			}
		});
	}

	// Just a formatter method used to replace 10-15 with A-F while dealing with
	// hex
	private void bin_hex_FO(int x, String y) {
		finalHex += "\n= " + x + "\n----------------\n= " + y + " (In Hex)\n----------------\n\n";
	}

	// Method to copy string to clipboard
	private void copy(String selection) {
		StringSelection strSel = new StringSelection(selection);
		Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
		cp.setContents(strSel, null);
	}

	public BHD_beta() {
		setResizable(false);
		setBounds(100, 100, 909, 455);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel binaryLabel = new JLabel("Binary");

		JTextField binary = new JTextField();
		binary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		binary.setColumns(10);

		JLabel hexLabel = new JLabel("Hex");

		JTextField hex = new JTextField();
		hex.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hex.setColumns(10);

		JLabel decimalLabel = new JLabel("Decimal");

		JTextField decimal = new JTextField();
		decimal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		decimal.setColumns(10);

		JButton binary_method = new JButton(">>");

		JButton hex_method = new JButton(">>");

		JButton decimal_method = new JButton(">>");

		binary_method.setVisible(false);

		hex_method.setVisible(false);

		decimal_method.setVisible(false);

		JScrollPane method_scrollPane = new JScrollPane();

		JButton RButton = new JButton("...");

		// Extended method view text area
		JTextArea enRemMethod = new JTextArea();
		enRemMethod.setEditable(false);
		JScrollPane enScrollPane = new JScrollPane();
		enScrollPane.setViewportView(enRemMethod);
		JPanel enMethodPane = new JPanel(new GridLayout(1, 1));
		enMethodPane.add(enScrollPane);
		JDialog enDialog = new JDialog();
		enDialog.getContentPane().add(enMethodPane);
		enDialog.setPreferredSize(new Dimension(300, 700));
		enDialog.pack();

		JButton binCopy = new JButton("Copy");

		JButton hexCopy = new JButton("Copy");

		JButton decimalCopy = new JButton("Copy");

		JLabel aboutLabel = new JLabel("[ Created by Jaskaranbir ]");

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(binary, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 460,
														Short.MAX_VALUE)
												.addComponent(binCopy))
										.addGap(18).addComponent(binary_method))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(hexCopy)
										.addComponent(hex, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
								.addGap(18).addComponent(hex_method))
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(aboutLabel)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(decimalCopy))
								.addComponent(decimal, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
								.addGap(18).addComponent(decimal_method))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(hexLabel))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(decimalLabel))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(binaryLabel,
								GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
						.addGap(23).addComponent(method_scrollPane, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(RButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(22, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(RButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(binaryLabel, GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(binary, GroupLayout.PREFERRED_SIZE, 65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(binary_method))
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(binCopy).addGap(10)
										.addComponent(hexLabel).addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(hex, GroupLayout.PREFERRED_SIZE, 65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(hex_method))
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(hexCopy).addGap(15)
										.addComponent(decimalLabel).addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(decimal, GroupLayout.PREFERRED_SIZE, 65,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(decimal_method))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(decimalCopy)
										.addComponent(aboutLabel)))
								.addComponent(method_scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 393,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));

		// Text Area containing method to convert
		JTextArea methodTextArea = new JTextArea();
		methodTextArea.setForeground(Color.WHITE);
		methodTextArea.setBackground(Color.DARK_GRAY);
		methodTextArea.setEditable(false);
		method_scrollPane.setViewportView(methodTextArea);
		getContentPane().setLayout(groupLayout);

		binary.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (binary.hasFocus() && !(binary.getText().equals(""))) {
					hex.setText("");
					decimal.setText("");
					String binString = binary.getText();
					int binCharCount = binString.length();
					// All these are used to format the method output
					String numArray = "", numArray2 = "", numArray3 = "", numArray4 = "", lineArray = "", expArray = "";

					String finalBin = "" + binString;
					// Dont want to manipulate real variable, so lets create a
					// temp copy
					String tempBin = finalBin;

					// Add zeros to complete pairs of 4 if needed
					int binCount = binCharCount % 4;
					finalHex = tempBin + "b\n";
					if (binCount != 0)
						for (int i = 0; i < (4 - binCount); i++) {
							finalBin = "0" + tempBin;
							tempBin = finalBin;
						}
					finalHex += "= " + tempBin + "\n";

					// Arrange in pairs of four
					String pairSystem = "";
					for (int i = 0; i < (tempBin.length() / 4); i++)
						pairSystem += tempBin.substring((4 * i), ((4 * i) + 4)) + ",";
					pairSystem = pairSystem.substring(0, (pairSystem.length() - 1));
					finalHex += ">>> [" + pairSystem + "]\n\n";

					// Hex Calculation
					tempBin = finalBin;
					String tempBin2;
					int arrayCount = finalBin.length() / 4;
					String tempHex = "";
					int x = 0;
					for (int i = 0; i < arrayCount; i++) {
						tempBin2 = tempBin.substring(0, 4);
						finalHex += ">> " + tempBin2 + "\n-----------------------\n|";
						char[] binArray = tempBin2.toCharArray();
						for (int j = 0; j < 4; j++) {
							x += (int) ((Integer.parseInt(String.valueOf(binArray[j]))) * (Math.pow(2, (4 - (j + 1)))));
							finalHex += "2^" + (4 - (j + 1)) + "|";
							if (j == 3)
								finalHex += "\n-----------------------\n";
						}

						lineArray = "\n-----------------------\n";
						finalHex += "|";
						for (int k = 0; k < 4; k++) {
							finalHex += "   " + String.valueOf(binArray[k]) + " |";
							if (!(k == 3)) {
								expArray += " [" + String.valueOf(binArray[k]) + "x(2^" + (4 - (k + 1) + ")] + ");
								numArray += "     " + String.valueOf(binArray[k]) + "x"
										+ (int) Math.pow(2, (4 - (k + 1))) + "      +";
								numArray2 += "       " + (Integer.parseInt(String.valueOf(binArray[k]))
										* (int) Math.pow(2, (4 - (k + 1)))) + "        +";
							} else {
								expArray += " [" + String.valueOf(binArray[k]) + "x(2^" + (4 - (k + 1) + ")] ");
								numArray += "     " + String.valueOf(binArray[k]) + "x"
										+ (int) Math.pow(2, (4 - (k + 1)));
								numArray2 += "       " + (Integer.parseInt(String.valueOf(binArray[k]))
										* (int) Math.pow(2, (4 - (k + 1))));
							}
						}
						finalHex += lineArray + expArray + "\n=" + numArray + "\n=" + numArray2;
						expArray = "";
						numArray = "";
						numArray2 = "";

						// Correction for A-F instead of 10-15
						if (x <= 9) {
							tempHex += "" + x;
							finalHex += "\n= " + x + "\n----------------\n= " + x + " (In Hex)\n----------------\n\n";
						} else if (x == 10) {
							tempHex += "A";
							bin_hex_FO(x, "A");
						} else if (x == 11) {
							tempHex += "B";
							bin_hex_FO(x, "B");
						} else if (x == 12) {
							tempHex += "C";
							bin_hex_FO(x, "C");
						} else if (x == 13) {
							tempHex += "D";
							bin_hex_FO(x, "D");
						} else if (x == 14) {
							tempHex += "E";
							bin_hex_FO(x, "E");
						} else if (x == 15) {
							tempHex += "F";
							bin_hex_FO(x, "F");
						}
						x = 0;
						tempBin = tempBin.substring(4, tempBin.length());
					}
					hex.setText(tempHex);
					finalHex += "\n-->> Hex Code= " + tempHex;
					methodTextArea.setText(finalHex);

					// Decimal Conversion
					char[] binArray = binString.toCharArray();
					int binToDeci = 0;
					numArray = "|";
					numArray2 = "|";
					numArray3 = "= ";
					numArray4 = "= ";
					lineArray = "";
					expArray = "= ";
					for (int i = 0; i < binCharCount; i++) {
						binToDeci += (Integer.parseInt(String.valueOf(binArray[i]))
								* (int) Math.pow(2, (binCharCount - (i + 1))));
						numArray += " 2^" + (binCharCount - (i + 1)) + " |";
						lineArray += "-------";
						numArray2 += "   " + String.valueOf(binArray[i]) + "   |";
						expArray += " [" + String.valueOf(binArray[i]) + "x(2^" + (binCharCount - (i + 1)) + ")] +";
						if (i == (binCharCount - 1)) {
							numArray3 += "    " + String.valueOf(binArray[i]) + "x"
									+ ((int) Math.pow(2, (binCharCount - (i + 1))));
							numArray4 += "      " + (Integer.parseInt(String.valueOf(binArray[i]))
									* ((int) Math.pow(2, (binCharCount - (i + 1)))));
						} else {
							numArray3 += "    " + String.valueOf(binArray[i]) + "x"
									+ ((int) Math.pow(2, (binCharCount - (i + 1))) + "      +");
							numArray4 += "      " + (Integer.parseInt(String.valueOf(binArray[i]))
									* ((int) Math.pow(2, (binCharCount - (i + 1))))) + "        + ";
						}
					}

					binToDeciTable = lineArray + "\n" + numArray + "\n" + lineArray + "\n" + numArray2 + "\n"
							+ lineArray + "\n" + expArray.substring(0, (expArray.length() - 1)) + "\n" + numArray3
							+ "\n" + numArray4 + "\n= " + binToDeci + "  (In Decimal)";
					decimal.setText("" + binToDeci);
				}
			}
		});

		hex.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (hex.hasFocus() && !(hex.getText().equals(""))) {
					binary.setText("");
					decimal.setText("");
					String hexArray = hex.getText().toUpperCase();
					// Hex to Decimal Array
					String[] hexDeciArray = new String[hexArray.length() * 2];
					String hexChar = "";
					String hquot = ""; // Stores quotient remaining after
										// dividing by 16
					String hexToBin = "";
					int decimalValue = 0, hrem = 0, hlen = 0;
					boolean reverse = false;
					hexBinTable = hexArray + "\n= ";
					String hexDiv = "", divStore = "============\n", binConcat = "";

					for (int i = 0; i < hexArray.length(); i++) {
						hexChar = hexArray.substring(i, (i + 1));
						if (hexChar.equals("0") || hexChar.equals("1") || hexChar.equals("2") || hexChar.equals("3")
								|| hexChar.equals("4") || hexChar.equals("5") || hexChar.equals("6")
								|| hexChar.equals("7") || hexChar.equals("8") || hexChar.equals("9"))
							hexDeciArray[i] = hexChar;
						else if (hexChar.equals("A")) {
							hexDeciArray[i] = "10";
							reverse = true;
						} else if (hexChar.equals("B")) {
							hexDeciArray[i] = "11";
							reverse = true;
						} else if (hexChar.equals("C")) {
							hexDeciArray[i] = "12";
							reverse = true;
						} else if (hexChar.equals("D")) {
							hexDeciArray[i] = "13";
							reverse = true;
						} else if (hexChar.equals("E")) {
							hexDeciArray[i] = "14";
							reverse = true;
						} else if (hexChar.equals("F")) {
							hexDeciArray[i] = "15";
							reverse = true;
						}
						hexBinTable += hexDeciArray[i] + "|";
						decimalValue = Integer.parseInt(hexDeciArray[i]);
						hquot = "";
						while (decimalValue > 0) {
							hrem = decimalValue % 2;
							hexDiv += "\n2 | " + decimalValue + " | " + hrem;
							hquot += hrem;
							decimalValue /= 2;
						}
						divStore += hexDiv + "\n============";
						hexDiv = "";
						hlen = (hquot.length() % 4);
						if (!(hlen == 0)) {
							for (int j = 0; j < (4 - hlen); j++) {
								hquot = "0" + hquot;
							}
						}
						if (reverse) {
							String tempRev = hquot;
							int length = hquot.length();
							hquot = "";
							for (int j = 0; j < length; j++) {
								hquot += tempRev.substring((tempRev.length() - 1), tempRev.length());
								tempRev = tempRev.substring(0, (tempRev.length() - 1));
							}
							reverse = false;
						}

						binConcat += " " + hquot;
						divStore += "\n= " + hquot + "\n============\n\n";
						hexToBin += hquot;
					}
					// Method for hex to binary
					hexBinTable += "\n" + divStore + "\n=" + binConcat + "\n= " + binConcat.replace(" ", "");
					binary.setText(hexToBin);
					methodTextArea.setText(hexBinTable);

					// Hex to Decimal

					int hexToDeci = 0; // Final converted int container
					// Elements used in method generation output formatting
					String numArray = "|";
					String numArray2 = "|";
					String numArray3 = "= ";
					String numArray4 = "= ";
					String lineArray = "";
					String expArray = "= ";

					int hexCharCount = hexArray.length();
					// This loop gets the number, multiplies it by 16
					// raised to power of the location of that number in string
					// And this loop also forms the method string form
					for (int i = 0; i < hexArray.length(); i++) {
						hexToDeci += (Integer.parseInt(String.valueOf(hexDeciArray[i]))
								* (int) Math.pow(16, (hexCharCount - (i + 1))));
						numArray += " 16^" + (hexCharCount - (i + 1)) + " |";
						lineArray += "-------";
						numArray2 += "   " + String.valueOf(hexDeciArray[i]) + "   |";
						expArray += " [" + String.valueOf(hexDeciArray[i]) + "x(16^" + (hexCharCount - (i + 1))
								+ ")] +";
						if (i == (hexCharCount - 1)) {
							numArray3 += "    " + String.valueOf(hexDeciArray[i]) + "x"
									+ ((int) Math.pow(16, (hexCharCount - (i + 1))));
							numArray4 += "      " + (Integer.parseInt(String.valueOf(hexDeciArray[i]))
									* ((int) Math.pow(16, (hexCharCount - (i + 1)))));
						} else {
							numArray3 += "    " + String.valueOf(hexDeciArray[i]) + "x"
									+ ((int) Math.pow(16, (hexCharCount - (i + 1))) + "      +");
							numArray4 += "      " + (Integer.parseInt(String.valueOf(hexDeciArray[i]))
									* ((int) Math.pow(16, (hexCharCount - (i + 1))))) + "        + ";
						}
					}

					// String containing method
					hexDeciTable = lineArray + "\n" + numArray + "\n" + lineArray + "\n" + numArray2 + "\n" + lineArray
							+ "\n" + expArray.substring(0, (expArray.length() - 1)) + "\n" + numArray3 + "\n"
							+ numArray4 + "\n= " + hexToDeci + "  (In Decimal)";
					decimal.setText("" + hexToDeci);
				}
			}
		});

		decimal.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (decimal.hasFocus() && !decimal.getText().equals("")) {
					binary.setText("");
					hex.setText("");
					methodTextArea.setText("");
					int decimalValue = Integer.parseInt(decimal.getText());

					// Binary Conversion
					deciToBinary = "";
					int dec = decimalValue;
					int remainder = dec % 2;
					int count = 0;
					String temp = "", decVal = "";// , temp2;
					while (dec > 0) {
						count++;
						decVal += "" + dec + "|";
						temp += remainder;
						dec = dec / 2;
						remainder = dec % 2;
					}

					// reverse the binary code to get correct code
					String binaryCode = "";
					binary.setText("");
					int length = temp.length();
					for (int i = length - 1; i >= 0; i--)
						binaryCode += temp.charAt(i);
					binary.setText(binaryCode);

					// Binary Conversion to array.
					// This generates the method
					// I dont know what I am doing
					String[] decVal2 = new String[count];
					count -= 2;
					for (int i = 0; i <= count; i++) {
						decVal2[i] = decVal.substring(0, (decVal.indexOf("|")));
						if (decVal.endsWith("|"))
							decVal = decVal.substring((decVal.indexOf("|") + 1), (decVal.length() - 1));
						else {
							decVal = decVal.substring((decVal.indexOf("|") + 1), decVal.length());
						}
					}
					char[] remStore = temp.toCharArray();
					count += 2;
					if (count == 1)
						binary.setText("1");
					else {
						for (int i = 0; i < count; i++) {
							if (i == (count - 1)) {
								deciToBinary += "2 | " + (Integer.parseInt(String.valueOf(decVal2[i - 1])) / 2) + " | "
										+ remStore[i] + "\n  | 0 |";
							} else {
								deciToBinary += "2 | " + decVal2[i] + " | " + remStore[i] + "\n";
							}
						}
					}

					// Hex Conversion
					int hremainder = decimalValue % 16;
					int hcount = 0;
					String htemp = "", hexVal = "", hexremainder = "";
					while (decimalValue > 0) {
						hcount++;
						hexVal += "" + decimalValue + "|";
						if (hremainder <= 9) {
							hexremainder = "" + hremainder;
						} else {
							if (hremainder == 10)
								hexremainder = "A";
							else if (hremainder == 11)
								hexremainder = "B";
							else if (hremainder == 12)
								hexremainder = "C";
							else if (hremainder == 13)
								hexremainder = "D";
							else if (hremainder == 14)
								hexremainder = "E";
							else if (hremainder == 15)
								hexremainder = "F";
						}
						htemp += hexremainder + "\n";
						decimalValue = decimalValue / 16;
						hremainder = decimalValue % 16;
					}
					htemp = htemp.replace("\n", "");

					// reverse the hex code to get correct code
					String hexCode = "";
					int hlength = htemp.length();
					for (int i = hlength - 1; i >= 0; i--)
						hexCode += htemp.charAt(i);

					// Hex Conversion to array.
					// This generates the method
					// I dont know what I am doing
					String[] hexVal2 = new String[hcount];
					hcount -= 2;
					for (int i = 0; i <= hcount; i++) {
						hexVal2[i] = hexVal.substring(0, (hexVal.indexOf("|")));
						if (hexVal.endsWith("|"))
							hexVal = hexVal.substring((hexVal.indexOf("|") + 1), (hexVal.length() - 1));
						else {
							hexVal = hexVal.substring((hexVal.indexOf("|") + 1), hexVal.length());
						}
					}
					hex.setText(hexCode);

					char[] hremStore = htemp.toCharArray();
					finalDeciHex = "";
					hcount += 2;
					if (hcount == 1)
						hex.setText("1");
					else {
						for (int i = 0; i < hcount; i++) {
							if (i == (hcount - 1)) {
								finalDeciHex += "16 | " + ((Integer.parseInt(String.valueOf(hexVal2[i - 1])) / 16))
										+ " | " + hremStore[i] + "\n      | 0 |";
							} else {
								finalDeciHex += "16 | " + hexVal2[i] + " | " + hremStore[i] + "\n";
							}
						}
					}
					methodTextArea.setText(finalDeciHex);
				}
			}
		});

		methodTextArea.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				enRemMethod.setText(methodTextArea.getText());
			}
		});

		// Just a rough way to update the data when moving from one field to
		// another
		binary.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				binary_method.setVisible(false);
				hex_method.setVisible(true);
				decimal_method.setVisible(true);
				try {
					binary.setCaretPosition(0);
					binary.setCaretPosition(binary.getText().length());
				} catch (Exception e) {
				}
			}

			public void focusLost(FocusEvent arg0) {
			}
		});

		hex.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				binary_method.setVisible(true);
				hex_method.setVisible(false);
				decimal_method.setVisible(true);
				try {
					hex.setCaretPosition(0);
					hex.setCaretPosition(hex.getText().length());
				} catch (Exception e) {
				}
			}

			public void focusLost(FocusEvent arg0) {
			}
		});

		decimal.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				binary_method.setVisible(true);
				hex_method.setVisible(true);
				decimal_method.setVisible(false);
				try {
					decimal.setCaretPosition(0);
					decimal.setCaretPosition(decimal.getText().length());
				} catch (Exception e) {
				}
			}

			public void focusLost(FocusEvent arg0) {
			}
		});

		// Button Actions
		RButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enDialog.setVisible(true);
			}
		});

		decimal_method.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (binary.hasFocus() || !binary_method.isVisible()) {
					methodTextArea.setText(binToDeciTable);
				} else if (hex.hasFocus() || !hex_method.isVisible()) {
					methodTextArea.setText(hexDeciTable);
				}
			}
		});

		binary_method.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (decimal.hasFocus() || !decimal_method.isVisible())
					methodTextArea.setText(deciToBinary);
				else if (hex.hasFocus() || !hex_method.isVisible()) {
					methodTextArea.setText(hexBinTable);
				}
			}
		});

		hex_method.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (binary.hasFocus() || !binary_method.isVisible()) {
					methodTextArea.setText(finalHex);
				} else if (decimal.hasFocus() || !decimal_method.isVisible()) {
					methodTextArea.setText(finalDeciHex);
				}
			}
		});

		binCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy(binary.getText());
			}
		});

		hexCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy(hex.getText());
			}
		});

		decimalCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy(decimal.getText());
			}
		});

	}
}
