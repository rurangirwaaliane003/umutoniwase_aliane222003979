package guestsForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import Myguests.guests;


public class GuestsForm implements ActionListener {
	JFrame frame;
	JLabel guestId_lb=new JLabel("Guests ID");
	JLabel firstname_lb=new JLabel("First Name");
	JLabel lastname_lb=new JLabel("Last Name");
	JLabel email_lb=new JLabel("Email");
	JLabel phonenumber_lb=new JLabel("Phone Number");
	JLabel password_lb=new JLabel("Password");

	JTextField guestId_txf=new JTextField();
	JTextField firstname_txf=new JTextField();
	JTextField lastname_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phonenumber_txf=new JTextField();
	JTextField password_txf=new JTextField();

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public GuestsForm() {
		createForm();
		actionEvent();
		setFontforall();
		addComponentToFrame();
		setLocationandSize();
	}

	private void actionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("GUESTS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		guestId_lb.setBounds(10, 10, 130, 30);
		firstname_lb.setBounds(10, 50, 120, 30);
		lastname_lb.setBounds(10, 90, 100, 30);
		email_lb.setBounds(10, 130, 100, 30);
		phonenumber_lb.setBounds(10, 170, 100, 30);
		password_lb.setBounds(10, 210, 100, 30);
		
		
		guestId_txf.setBounds(200, 10, 170, 30);
		firstname_txf.setBounds(200, 50, 170, 30);
		lastname_txf.setBounds(200, 90, 170, 30);
		email_txf.setBounds(200, 130, 170, 30);
		phonenumber_txf.setBounds(200, 170, 170, 30);
		password_txf.setBounds(200, 210, 170, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);

		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		guestId_lb.setFont(font);
		firstname_lb.setFont(font);
		lastname_lb.setFont(font);
		email_lb.setFont(font);
		phonenumber_lb.setFont(font);
		password_lb.setFont(font);
		

		guestId_txf.setFont(font);
		firstname_txf.setFont(font);
		lastname_txf.setFont(font);
		email_txf.setFont(font);
		phonenumber_txf.setFont(font);
		password_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(guestId_lb);
		frame.add(firstname_lb);
		frame.add(lastname_lb);
		frame.add(email_lb);
		frame.add(phonenumber_lb);
		frame.add(password_lb);
		
		frame.add(guestId_txf);
		frame.add(firstname_txf);
		frame.add(lastname_txf);
		frame.add(email_txf);
		frame.add(phonenumber_txf);
		frame.add(password_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		guests som=new guests();
		if(e.getSource()==insert_btn) {
			som.setFirstname(firstname_txf.getText());
			som.setLastname(lastname_txf.getText());
			som.setEmail(email_txf.getText());
			som.setPhonenumber(phonenumber_txf.getText());
			som.setPassword(password_txf.getText());
			
			som.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("Guests ID");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Email");
            model.addColumn("Phone Number");
            model.addColumn("Password");
            
           
            ResultSet resultSet =guests.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(guestId_txf.getText());
	    	som.setFirstname(firstname_txf.getText());
			som.setLastname(lastname_txf.getText());
			som.setEmail(email_txf.getText());
			som.setPhonenumber(phonenumber_txf.getText());
			som.setPassword(password_txf.getText());
	    	som.update(id);
	    }
	  else {
			int id=Integer.parseInt(guestId_txf.getText());
			som.delete(id);}

	  }		
		public static void main(String[] args) {
			GuestsForm ef=new GuestsForm();
			System.out.println(ef);
		
			
		}

	}




