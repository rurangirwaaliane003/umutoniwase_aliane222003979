package reservationsForm;

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

import Myreservations.reservations;



public class ReservationsForm implements ActionListener {
	JFrame frame;
	JLabel reservationid_lb=new JLabel("Reservation ID");
	JLabel guestId_lb=new JLabel("Guest ID");
	JLabel roomId_lb=new JLabel("Room ID");
	JLabel checkInDate_lb=new JLabel("CheckInDate");
	JLabel checkOutDate_lb=new JLabel("CheckOutDate");
	

	JTextField reservationid_txf=new JTextField();
	JTextField guestId_txf=new JTextField();
	JTextField roomId_txf=new JTextField();
	JTextField checkInDate_txf=new JTextField();
	JTextField checkOutDate_txf=new JTextField();

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
	public ReservationsForm() {
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
		frame.setTitle("RESERVATIONS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		reservationid_lb.setBounds(10, 10, 130, 30);
		guestId_lb.setBounds(10, 50, 120, 30);
		roomId_lb.setBounds(10, 90, 100, 30);
		checkInDate_lb.setBounds(10, 130, 100, 30);
		checkOutDate_lb.setBounds(10, 170, 100, 30);
		
		
		
		reservationid_txf.setBounds(200, 10, 170, 30);
		guestId_txf.setBounds(200, 50, 170, 30);
		roomId_txf.setBounds(200, 90, 170, 30);
		checkInDate_txf.setBounds(200, 130, 170, 30);
		checkOutDate_txf.setBounds(200, 170, 170, 30);
		
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);

		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		reservationid_lb.setFont(font);
		guestId_lb.setFont(font);
		roomId_lb.setFont(font);
		checkInDate_lb.setFont(font);
		checkOutDate_lb.setFont(font);
		

		reservationid_txf.setFont(font);
		guestId_txf.setFont(font);
		roomId_txf.setFont(font);
		checkInDate_txf.setFont(font);
		checkOutDate_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(reservationid_lb);
		frame.add(guestId_lb);
		frame.add(roomId_lb);
		frame.add(checkInDate_lb);
		frame.add(checkOutDate_lb);
		
		frame.add(reservationid_txf);
		frame.add(guestId_txf);
		frame.add(roomId_txf);
		frame.add(checkInDate_txf);
		frame.add(checkOutDate_txf);
		
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		reservations som=new reservations();
		if(e.getSource()==insert_btn) {
			som.setGuestId(guestId_txf.getText());
			som.setRoomId(roomId_txf.getText());
			som.setCheckInDate(checkInDate_txf.getText());
			som.setCheckOutDate(checkOutDate_txf.getText());
			
			som.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("Reservation ID");
            model.addColumn("Guest ID");
            model.addColumn("Room ID");
            model.addColumn("CheckInDate");
            model.addColumn("CheckOutDate");
           
            
           
            ResultSet resultSet =reservations.viewData();
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
	    	int id=Integer.parseInt(reservationid_txf.getText());
	    	som.setGuestId(guestId_txf.getText());
			som.setRoomId(roomId_txf.getText());
			som.setCheckInDate(checkInDate_txf.getText());
			som.setCheckOutDate(checkOutDate_txf.getText());
			
	    	som.update(id);
	    }
	  else {
			int id=Integer.parseInt(reservationid_txf.getText());
			som.delete(id);}

	  }		
		public static void main(String[] args) {
			ReservationsForm ef=new ReservationsForm();
			System.out.println(ef);
		
			
		}

	}



