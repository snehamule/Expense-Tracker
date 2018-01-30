/**
 * 
 */
package expenseTracker;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;



class ExpenseTracker extends JFrame{
	 private Container container;
	 private JPanel controlPanel;
	 private JPanel amountPanel;
	 private JPanel paymentPanel;
	 private JPanel reportPanel;
	 private JPanel datePanel;
	 private JLabel amount; 
	 private JTextField amountText;
	 private JLabel dateText;
	 private JLabel dateLabel;
	 private JButton addButton;
	 private JToolBar myJToolBar;
	 private JButton expenseByCategory;
	 private JButton expenseByMonth;
	 private JComboBox<String> category;
	ExpenseTracker() throws IOException{
		super("Expense Tracker");
		controlPanel= new JPanel();
       	myJToolBar= new JToolBar();
		container = getContentPane();
		//container.setBackground( new Color(	175,238,238));
		container.setLayout(new FlowLayout());
		//container.setLayout(new GridLayout(10,20));
		container.setSize(10,10);
		datePanel=new JPanel();
		datePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		dateLabel=new JLabel("Date");
		dateLabel.setBorder(new EmptyBorder(0, 0, 10, 10));
		dateText=new JLabel();
		dateText.setBorder(new EmptyBorder(0, 0, 10, 20));
		dateText.setText(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
		datePanel.add(dateLabel);
		datePanel.add(dateText);
		
		amountPanel= new JPanel();
		amountPanel.setSize(30, 10);
		amountPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		category = new JComboBox<>();
		category.setBorder(new EmptyBorder(10,10, 10, 95));
		BufferedReader reader = new BufferedReader(new FileReader("Category.txt"));
		String line = null;
		try {
			while ((line=reader.readLine()) != null ) {
				category.addItem(line);
			}	
		}catch(Exception e){
			System.out.println("Exception"+e);
		} finally {
			reader.close();
		}	
		
		//myJToolBar.addSeparator(new Dimension(30, 20));
		amount= new JLabel("Amount");
		amountText = new JTextField(15);
		amountPanel.add(category);
		amountPanel.add(amount);
		amountPanel.add(amountText);
		
		    
        paymentPanel=new JPanel();
        addButton=new JButton("Add");
        ActionListener actionListener = new ActionListnerImplement() ;
        addButton.addActionListener(actionListener);
        paymentPanel.add(addButton);
       
        
        reportPanel= new JPanel();
        reportPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        expenseByCategory= new JButton("Expense By Category");
        expenseByCategory.addActionListener(actionListener);
        expenseByMonth= new JButton("Expense By Month");
        expenseByMonth.addActionListener(actionListener);
        reportPanel.add(expenseByCategory);
        reportPanel.add(expenseByMonth);
        
       
        container.add(datePanel);
		container.add(amountPanel);
		container.add(paymentPanel);
		container.add(reportPanel);
		setSize(500, 500);
		setVisible(true);
		
		
	}
class ActionListnerImplement implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==addButton){
				System.out.println("U are in Add button");
				String selectedCategory=category.getSelectedItem().toString();
				double amount=Double.parseDouble(amountText.getText());
				try {
					AddExpense add=new AddExpense(selectedCategory,amount);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if (e.getSource()==expenseByMonth){
				
			}else if (e.getSource()==expenseByCategory){
				
			
		}
	}	
}

}



public class FrontPage {
	public static void main(String[] args) throws IOException {
		ExpenseTracker expense= new ExpenseTracker();
		
	}
}
