package roomsForm;

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

import Myrooms.rooms;


public class RoomsForm implements ActionListener {
	JFrame frame;
	JLabel roomId_lb=new JLabel("ROOM ID");
	JLabel hotelID_lb=new JLabel("Hotel ID");
	JLabel roomNumber_lb=new JLabel("Room Number");
	JLabel roomType_lb=new JLabel("Room Type");
	JLabel price_lb=new JLabel("Price");
	

	JTextField roomId_txf=new JTextField();
	JTextField hotelID_txf=new JTextField();
	JTextField roomNumber_txf=new JTextField();
	JTextField roomType_txf=new JTextField();
	JTextField price_txf=new JTextField();

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
	public RoomsForm() {
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
		frame.setTitle("ROOMS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		roomId_lb.setBounds(10, 10, 130, 30);
		hotelID_lb.setBounds(10, 50, 120, 30);
		roomNumber_lb.setBounds(10, 90, 100, 30);
		roomType_lb.setBounds(10, 130, 100, 30);
		price_lb.setBounds(10, 170, 100, 30);
		
		
		
		roomId_txf.setBounds(200, 10, 170, 30);
		hotelID_txf.setBounds(200, 50, 170, 30);
		roomNumber_txf.setBounds(200, 90, 170, 30);
		roomType_txf.setBounds(200, 130, 170, 30);
		price_txf.setBounds(200, 170, 170, 30);
		
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);

		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		roomId_lb.setFont(font);
		hotelID_lb.setFont(font);
		roomNumber_lb.setFont(font);
		roomType_lb.setFont(font);
		price_lb.setFont(font);
		

		roomId_txf.setFont(font);
		hotelID_txf.setFont(font);
		roomNumber_txf.setFont(font);
		roomType_txf.setFont(font);
		price_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(roomId_lb);
		frame.add(hotelID_lb);
		frame.add(roomNumber_lb);
		frame.add(roomType_lb);
		frame.add(price_lb);
		
		frame.add(roomId_txf);
		frame.add(hotelID_txf);
		frame.add(roomNumber_txf);
		frame.add(roomType_txf);
		frame.add(price_txf);
		
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		rooms som=new rooms();
		if(e.getSource()==insert_btn) {
			som.setHotelID(hotelID_txf.getText());
			som.setRoomNumber(roomNumber_txf.getText());
			som.setRoomType(roomType_txf.getText());
			som.setPrice(price_txf.getText());
			
			som.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("ROOM ID");
            model.addColumn("Hotel ID");
            model.addColumn("Room Number");
            model.addColumn("Room Type");
            model.addColumn("Phone Number");
            model.addColumn("Price");
           
           
            ResultSet resultSet =rooms.viewData();
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
	    	int id=Integer.parseInt(roomId_txf.getText());
	    	som.setHotelID(hotelID_txf.getText());
			som.setRoomNumber(roomNumber_txf.getText());
			som.setRoomType(roomType_txf.getText());
			som.setPrice(price_txf.getText());
			
	    	som.update(id);
	    }
	  else {
			int id=Integer.parseInt(roomId_txf.getText());
			som.delete(id);}

	  }		
		public static void main(String[] args) {
			RoomsForm ef=new RoomsForm();
			System.out.println(ef);
		
			
		}

	}


