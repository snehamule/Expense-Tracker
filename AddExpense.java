/**
 * 
 */
package expenseTracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AddExpense {
	private String selectedCategory;
	private double amount;
	private String noteText;
	private String payee;
	private String paymentMethod;
	
	AddExpense(String selectedCategory, double amount) throws IOException{
		this.selectedCategory=selectedCategory;
		this.amount=amount;
		saveExpenseData();
	}

	public void saveExpenseData() throws IOException{
		BufferedWriter writer= new BufferedWriter(new FileWriter("Expense Store.txt",true));
		ArrayList list= new ArrayList();
		list.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
		list.add(selectedCategory);
		list.add(amount);
		writer.write(list.toString().substring(1,list.toString().length()-1)+ "\n");
		writer.close();
	}
	
	
	
	
	
}
