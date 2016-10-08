package convertR;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Converts a given number format to another specified number formats.
 * Formats supported are: Decimal, Binary, Octal and Hexadecimal.
 */
@SuppressWarnings("serial")
public class NumberConverter extends JFrame {

	private JTextField userIn = new JTextField();
	
	private final String[] start = { "Decimal", "Binary", "Octal", "Hexadecimal"};
	private JComboBox <String>startCombo = new JComboBox<String>(start);
	private JComboBox <String>convertCombo = new JComboBox<String>(start);
	private JTextField output = new JTextField();
	
	public NumberConverter(){
				
		// panel1 which asks user for starting number
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(5,2,0,0));
		
		// combo box1
		startCombo.setSelectedIndex(0);
		
		panel1.add(startCombo);
		panel1.add(new JLabel("Original Number: "));
		panel1.add(userIn);
		panel1.setBorder(new TitledBorder("Enter number to be converted and its type:"));
		
		
		// panel2 which shows converted number
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5,2,0,0));
		
		convertCombo.setSelectedIndex(0);
		
		output.setEditable(false);
		
		panel2.add(convertCombo);
		panel2.add(new JLabel("Converted Number: "));
		panel2.add(output);
		panel2.setBorder(new TitledBorder("Select the type the above number must be converted into:"));
		
		
		// convert button
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton convert = new JButton("Convert");
		south.add(convert);
		
		// action listener
		convert.addActionListener(new ButtonListener());
				
		// add panels to frame		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(south,BorderLayout.SOUTH);
		
	}
					
	public static void main(String[] args) {
		
		NumberConverter gui = new NumberConverter();
		gui.setTitle("Number Converter");
		gui.setSize(500, 350);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		
	}

	protected class ButtonListener implements ActionListener{ // inner class

		@Override
		public void actionPerformed(ActionEvent e) {
			
			NumberSystem startNum = null;
			NumberSystem convertedNum = null;
			String startStr = "", temp = "";
			NumberSystem d = null;
			
			
			// starting number, catch exceptions
			if( !userIn.getText().equals(null)){  startStr = userIn.getText(); }
			
			int startType = startCombo.getSelectedIndex();
			switch(startType){
			case 0:
				try{
					startNum = new DecimalNumber(startStr);
				}
				catch (NumberFormatException ex1 ){
					convertExceptionPopup();
				}
				break;
				
			case 1:
				try{
					startNum = new BinaryNumber(startStr);
				}
				catch (NumberFormatException ex1 ){
					inputExceptionPopup();
				}
				break;
				
			case 2:
				try{
					startNum = new OctalNumber(startStr);
				}
				catch (NumberFormatException ex1 ){
					inputExceptionPopup();
				}
				break;
				
			case 3:
				try{
					startNum = new HexNumber(startStr);
				}
				catch (NumberFormatException ex1 ){
					inputExceptionPopup();
				}
				break;
			}
			
			// converting number, catch exceptions
			int convertedType = convertCombo.getSelectedIndex();
			switch(convertedType){
			case 0:
				try{
					temp = startNum.convertToDecimal();
					d = new DecimalNumber(temp);

				}
				catch( NumberFormatException ex2){
					convertExceptionPopup();
				}
				catch( NullPointerException ex3){}
				
				convertedNum = d;
				break;
				
			case 1:
				try{
					temp = startNum.convertToDecimal();
					d = new DecimalNumber(temp);				
					convertedNum = new BinaryNumber();
					temp = d.convertFromDecimalTo((DecimalNumber) d, convertedNum);
					convertedNum.setNumberString(temp);

				}
				catch( NumberFormatException ex2){
					convertExceptionPopup();
				}
				catch( NullPointerException ex3){}
								
				break;
				
			case 2:
				try{
					temp = startNum.convertToDecimal();
					d = new DecimalNumber(temp);	
					convertedNum = new OctalNumber();
					temp = d.convertFromDecimalTo((DecimalNumber) d, convertedNum);
					convertedNum.setNumberString(temp);
				}
				catch( NumberFormatException ex2){
					convertExceptionPopup();
				}
				catch( NullPointerException ex3){}
												
				break;
				
			case 3:
				try{
					temp = startNum.convertToDecimal();
					d = new DecimalNumber(temp);		
					convertedNum = new HexNumber();
					temp = d.convertFromDecimalTo((DecimalNumber) d, convertedNum);
					convertedNum = new HexNumber();
					temp = d.convertFromDecimalTo((DecimalNumber) d, convertedNum);
					convertedNum.setNumberString(temp);
				}
				catch (NumberFormatException ex2){
					convertExceptionPopup();
				}
				catch( NullPointerException ex3){}
							
				break;
				
			}
			
			try{
				output.setText(convertedNum.getNumberString());
				}
			catch (NullPointerException ex3){}
		}
		
		private void convertExceptionPopup() {
			JFrame frame1 = new JFrame();
			JOptionPane.showMessageDialog(frame1, 
					"The input number too large to convert.\n " +
					"Please enter another number.");			
		}


		private void inputExceptionPopup() {
			JFrame frame2 = new JFrame();
			JOptionPane.showMessageDialog(frame2, 
					"The input number is not valid.\n " +
					"Please verify number or select the proper format.");			
		}		
	} // end inner class
	
}