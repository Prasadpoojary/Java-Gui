import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Employee extends Applet implements ActionListener 
{
	Label lblname, lblno, lblbasic, lblda, lblhra, lblpf, lblpt, lblgross, lblnet, lblerror;
	TextField txtname, txtno, txtbasic, txtda, txthra, txtpf, txtpt, txtgross, txtnet;
	Button calculate, clear;
	
	public void init()
	{
		setLayout(new GridLayout(15,2));
		lblname = new Label("Enter Employee Name : ");
		lblno = new Label("Enter Employee Number : ");
		lblbasic = new Label("Enter Employee Basic salary : ");
		lblda = new Label("DA : ");
		lblhra = new Label("HRA : ");
		lblpf = new Label("PF : ");
		lblpt = new Label("PT : ");
		lblgross = new Label("GROSS salary : ");
		lblnet = new Label("NET salary : ");
		lblerror = new Label("");
		
		txtname = new TextField(10);
		txtno = new TextField(10);
		txtbasic = new TextField(10);
		txtda = new TextField(10);
		txthra = new TextField(10);
		txtpf = new TextField(10);
		txtpt = new TextField(10);
		txtgross = new TextField(10);
		txtnet = new TextField(10);
		
		calculate = new Button("Calculate");
		clear = new Button("Clear");
		
		calculate.addActionListener(this);
		clear.addActionListener(this);
		
		add(lblname);
		add(txtname);
		
		add(lblno);
		add(txtno);
		
		add(lblbasic);
		add(txtbasic);
		
		add(lblda);
		add(txtda);
		
		add(lblhra);
		add(txthra);
		
		add(lblpf);
		add(txtpf);
		
		add(lblpt);
		add(txtpt);
		
		add(lblgross);
		add(txtgross);
		
		add(lblnet);
		add(txtnet);
		
		add(calculate);
		add(clear);
		
		add(lblerror);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String str;
		str = ae.getActionCommand();
		
		if(str.equals("Calculate"))
		{
			String salary = txtbasic.getText();
			int sal=0, da=0, hra=0, pf=0, pt=0, gross=0, net=0;
			
			if(salary.length()==0)
			{
				lblerror.setText("Enter The Basic Salary");
			}
			else
			{
				lblerror.setText("");
				sal=Integer.parseInt(salary);
				
				if(sal<=20000)
				{
					da = 40 * sal / 100;				
					hra = 10 * sal / 100;					
					gross = sal + da + hra;					
					pf = 12 * gross / 100;	
					pt = 100;
					
					txtda.setText(""+da);
					txthra.setText(""+hra);
					txtgross.setText(""+gross);
					txtpf.setText(""+pf);
					txtpt.setText(""+pt);
				}
				else
				{
					da = 50 * sal / 100;				
					hra = 15 * sal / 100;					
					gross = sal + da + hra;					
					pf = 12 * gross / 100;	
					pt = 150;
					
					txtda.setText(""+da);
					txthra.setText(""+hra);
					txtgross.setText(""+gross);
					txtpf.setText(""+pf);
					txtpt.setText(""+pt);
				}
				
				net = gross - (pf + pt);
				txtnet.setText(""+net);
			}
		}
		
		if(str.equals("Clear"))
		{
			txtname.setText(" ");
			txtno.setText(" ");
			txtbasic.setText("");
			txtda.setText("");
			txthra.setText("");
			txtgross.setText("");
			txtpf.setText("");
			txtpt.setText("");
			txtnet.setText("");
		}
	}
	
}








