import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class StudentDetail extends Applet implements AdjustmentListener, ActionListener
{
	Label lab_name, lab_class, lab_gender, lab_hobbies, lab_summary, lab_age;
	TextField txt_name, ageCount;
	Choice choice_class;
	TextArea summary;
	CheckboxGroup gender;
	Checkbox male, female, others;
	Scrollbar age;
	Button submit,clear;
	List hobbiesList;
	
	
	public void init()
	{
		setLayout(new FlowLayout(FlowLayout.LEADING));
		lab_name = new Label("Name  ");
		lab_class = new Label("Class                  ");
		lab_gender = new Label("Gender  ");
		lab_hobbies = new Label("Hobbies  ");
		lab_summary = new Label("Summary  ");
		lab_age = new Label("Age            ");
		
		
		txt_name = new TextField(20);
		
		gender = new CheckboxGroup();
		male = new Checkbox("Male",gender,false);
		female = new Checkbox("Female",gender,false);
		others = new Checkbox("Others",gender,true);
		
		choice_class = new Choice();
		choice_class.add("B.A");
		choice_class.add("B.com");
		choice_class.add("B.C.A");
		choice_class.add("B.S.W");
		choice_class.add("B.Sc");
		
		hobbiesList = new List();
		hobbiesList.add("Cricket");
		hobbiesList.add("Reading");
		hobbiesList.add("Coding");
		hobbiesList.add("Drawing");
		hobbiesList.add("Others");
		hobbiesList.setMultipleMode(true);
		
		summary = new TextArea(5,20);
		
		ageCount = new TextField();
		ageCount.setEditable(false);
		ageCount.setText("0");
		
		age = new Scrollbar(Scrollbar.HORIZONTAL,18,0,15,31);
		age.addAdjustmentListener(this);
		
		submit = new Button("Submit");
		clear = new Button("Clear");
		
		submit.addActionListener(this);
		clear.addActionListener(this);
		
		add(lab_name);
		add(txt_name);
		add(lab_gender);
		add(male);
		add(female);
		add(others);
		add(lab_class);
		add(choice_class);
		add(lab_hobbies);
		add(hobbiesList);
		add(lab_summary);
		add(summary);
		add(lab_age);
		add(ageCount);
		add(age);
		
		add(submit);
		add(clear);
		
		submit.setEnabled(false);
		
		
	}
	
	
	
	
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		ageCount.setText(""+age.getValue());
		submit.setEnabled(true);
	}
	

	public void actionPerformed(ActionEvent e)
	{
		String command;
		command = e.getActionCommand();
		
		if(command.equals("Submit"))
		{ 
			repaint();
		}
		else
		{
			txt_name.setText("");
			summary.setText("");
			ageCount.setText("0");
			gender.setSelectedCheckbox(others);
			hobbiesList.deselect(hobbiesList.getSelectedIndex());
		}
		
	}
	

	 public void paint(Graphics g)
		{ 
		 	g.drawString("----------------------------------------------------------------------", 0, 380);
			g.drawString("Name : "+txt_name.getText(), 20, 400);
			g.drawString("Gender : "+gender.getSelectedCheckbox().getLabel(), 20, 420);
			g.drawString("Class : "+choice_class.getSelectedItem(), 20, 440);
			g.drawString("Hobbies : "+iterateHobby(), 20, 460);
			if(summary.getText().equals(""))
			{
				g.drawString("Age : ", 20, 480);
			}
			else
			{
				
				g.drawString("Age : "+ageCount.getText(), 20, 480);
			}
			g.drawString("Fees : "+calculateFees(gender.getSelectedCheckbox().getLabel(),choice_class.getSelectedItem()), 20, 500);
		}


	private String iterateHobby() 
	{
		String[] HobbiesList= hobbiesList.getSelectedItems();
		String hobbies="";
		for(String hobby : HobbiesList)
		{
			hobbies+=hobby+"    ";
		}
		return hobbies;
	}
	

	private String calculateFees(String gender, String course) 
	{
		int fees=0;
		
		
		if(gender.equals("Female") || gender.equals("Others"))
		{
			if(course.equals("B.A"))
			{
				fees = 2000;
			}
			else if(course.equals("B.com"))
			{
				fees = 3000;
			}
			else if(course.equals("B.S.W"))
			{
				fees = 2500;
			}
			else if(course.equals("B.C.A"))
			{
				fees = 4000;
			}
			else if(course.equals("B.Sc"))
			{
				fees = 4500;
			}
		}
		else
		{
			if(course.equals("B.A"))
			{
				fees = 3000;
			}
			else if(course.equals("B.com"))
			{
				fees = 4000;
			}
			else if(course.equals("B.S.W"))
			{
				fees = 3500;
			}
			else if(course.equals("B.C.A"))
			{
				fees = 5000;
			}
			else if(course.equals("B.Sc"))
			{
				fees = 5500;
			}
		}
		
		if(iterateHobby().equals("Coding    "))
		{
			fees -=800;
		}
	
		return ""+fees;
	}

}














