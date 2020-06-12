import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shopping extends JFrame implements ActionListener
{
	JLabel lcode, ltitle, lprice, ldiscount, lamount;
	JTextField txtcode, txttitle, txtprice, txtdiscount, txtamount;
	JButton btnbill, btnclear;
	
	Shopping()
	{
		lcode = new JLabel("Book Code ");
		ltitle = new JLabel("Book Title ");
		lprice = new JLabel("Book Price ");
		ldiscount = new JLabel("Discount ");
		lamount = new JLabel("Net Amount ");
		
		txtcode = new JTextField(5);
		txttitle = new JTextField(10);
		txtprice = new JTextField(5);
		txtdiscount = new JTextField(5);
		txtamount = new JTextField(5);
	
		btnbill = new JButton("Process Bill");
		btnclear = new JButton("Clear");
				
		setLayout(new FlowLayout());
		add(lcode);
		add(txtcode);
		add(ltitle);
		add(txttitle);
		add(lprice);
		add(txtprice);
		add(btnbill);
		btnbill.addActionListener(this);
		add(ldiscount);
		add(txtdiscount);
		add(lamount);
		add(txtamount);
		add(btnclear);
		btnclear.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str;
		double discount, netamt;
		str = ae.getActionCommand();
		
		if(str.equals("Process Bill"))
		{
			int code, price;
			code = Integer.parseInt(txtcode.getText());
			price = Integer.parseInt(txtprice.getText());
			
			if(code==101)
			{
				discount = price * 0.15;
			}
			else if(code==102)
			{
				discount = price * 0.2;
			}
			else if(code==103)
			{
				discount = price * 0.25;
			}
			else
			{
				discount = price * 0.05;
			}
			
			netamt = price - discount;
			txtdiscount.setText(""+discount);
			txtamount.setText(""+netamt);
		}
		
		if(str.equals("Clear"))
		{
			txtcode.setText("");
			txttitle.setText("");
			txtprice.setText("");
			txtdiscount.setText("");
			txtamount.setText("");
		}
		
	}
	
	public static void main(String args[])
	{
		Shopping s = new Shopping();
		s.setTitle("Swing Program-Book Shopping");
		s.setSize(500,300);
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
