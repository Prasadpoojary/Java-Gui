import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EleBill extends JFrame implements ActionListener
{
	JLabel lmetno, lname, lpread, lcread, lcons, lamount;
	JTextField txtmetno, txtname, txtpread, txtcread, txtcons, txtamount;
	JButton genbill, clear;
	
	EleBill()
	{
		setLayout(new FlowLayout());
		lmetno = new JLabel("Meter Number ");
		lname = new JLabel("Customer Name ");
		lpread = new JLabel("Previous Reading ");
		lcread = new JLabel("Current Reading ");
		lcons = new JLabel("Consumption ");
		lamount = new JLabel("Amount Payable ");
		
		txtmetno = new JTextField(10);
		txtname = new JTextField(10);
		txtpread = new JTextField(10);
		txtcread = new JTextField(10);
		txtcons = new JTextField(10);
		txtamount = new JTextField(10);
		
		genbill = new JButton("Generate Bill");
		clear = new JButton("Clear");
		
		add(lmetno);
		add(txtmetno);
		add(lname);
		add(txtname);
		add(lpread);
		add(txtpread);
		add(lcread);
		add(txtcread);
		add(genbill);
		genbill.addActionListener(this);
		add(lcons);
		add(txtcons);
		add(lamount);
		add(txtamount);
		add(clear);
		clear.addActionListener(this);
				
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		int cons;
		double amount;
		String str = ae.getActionCommand();
		
		if(str.equals("Generate Bill"))
		{
			int pread, cread;
			pread = Integer.parseInt(txtpread.getText());
			cread = Integer.parseInt(txtcread.getText());
			
			if(pread < cread)
			{
				cons = cread - pread;
				
				if(cons<=150)
				{
					amount=200;
				}
				else if(cons<=200)
				{
					amount=200 + (cons-150) * 1.5;
				}
				else if(cons<=300)
				{
					amount=275 + (cons-200) * 2.0;
				}
				else
				{
					amount= Math.max(500, 475 + (cons-300) * 3.0);
				}
				
				txtcons.setText(""+cons);
				txtamount.setText(""+amount);
			}
			else
			{
				txtcons.setText("Reading ERROR");
				txtamount.setText("xxxxxxxxxxx");
			}
			
		}
		
		if(str.equals("Clear"))
		{
			txtmetno.setText("");
			txtname.setText("");
			txtpread.setText("");
			txtcread.setText("");
			txtcons.setText("");
			txtamount.setText("");
		}
	}
	
	public static void main(String args[])
	{
		EleBill eb = new EleBill();
		eb.setTitle("Swing Program-Electricity Bill");
		eb.setSize(900,300);
		eb.setVisible(true);
		eb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
