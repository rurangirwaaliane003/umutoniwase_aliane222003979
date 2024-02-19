package hotelsForm;

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

import Myhotels.hotels;



public class HotelsForm implements ActionListener {
	JFrame frame;
	JLabel hotelID_lb=new JLabel("Hotel ID");
	JLabel hotelName_lb=new JLabel("hotelName");
	JLabel location_lb=new JLabel("Location");
	JLabel password_lb=new JLabel("Password");
	JLabel emailld_lb=new JLabel("Emailld");
	

	JTextField hotelID_txf=new JTextField();
	JTextField hotelName_txf=new JTextField();
	JTextField location_txf=new JTextField();
	JTextField password_txf=new JTextField();
	JTextField emailld_txf=new JTextField();

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
	public HotelsForm() {
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
		frame.setTitle("HOTELS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		hotelID_lb.setBounds(10, 10, 130, 30);
		hotelName_lb.setBounds(10, 50, 120, 30);
		location_lb.setBounds(10, 90, 100, 30);
		password_lb.setBounds(10, 130, 100, 30);
		emailld_lb.setBounds(10, 170, 100, 30);
		
		
		
		hotelID_txf.setBounds(200, 10, 170, 30);
		hotelName_txf.setBounds(200, 50, 170, 30);
		location_txf.setBounds(200, 90, 170, 30);
		password_txf.setBounds(200, 130, 170, 30);
		emailld_txf.setBounds(200, 170, 170, 30);
		
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);

		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		hotelID_lb.setFont(font);
		hotelName_lb.setFont(font);
		location_lb.setFont(font);
		password_lb.setFont(font);
		emailld_lb.setFont(font);
		

		hotelID_txf.setFont(font);
		hotelName_txf.setFont(font);
		location_txf.setFont(font);
		password_txf.setFont(font);
		emailld_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(hotelID_lb);
		frame.add(hotelName_lb);
		frame.add(location_lb);
		frame.add(password_lb);
		frame.add(emailld_lb);
		
		frame.add(hotelID_txf);
		frame.add(hotelName_txf);
		frame.add(location_txf);
		frame.add(password_txf);
		frame.add(emailld_txf);
		
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		hotels som=new hotels();
		if(e.getSource()==insert_btn) {
			som.setHotelName(hotelName_txf.getText());
			som.setLocation(location_txf.getText());
			som.setPassword(password_txf.getText());
			som.setEmailld(emailld_txf.getText());
			
			som.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("Hotel ID");
            model.addColumn("Hotel Name");
            model.addColumn("Location");
            model.addColumn("Password");
            model.addColumn("Emailld");
            
            
           
            ResultSet resultSet =hotels.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(hotelID_txf.getText());
	    	som.setHotelName(hotelName_txf.getText());
			som.setLocation(location_txf.getText());
			som.setPassword(password_txf.getText());
			som.setEmailld(emailld_txf.getText());
			
	    	som.update(id);
	    }
	  else {
			int id=Integer.parseInt(hotelID_txf.getText());
			som.delete(id);}

	  }		
		public static void main(String[] args) {
			HotelsForm ef=new HotelsForm();
			System.out.println(ef);
		
			
		}

	}

