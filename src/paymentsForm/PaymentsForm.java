package paymentsForm;

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

import Mypayments.payments;



public class PaymentsForm implements ActionListener {
	JFrame frame;
	JLabel paymentid_lb=new JLabel("Payment ID");
	JLabel reservationid_lb=new JLabel("Reservation ID");
	JLabel amount_lb=new JLabel("Amount");
	JLabel paymentdate_lb=new JLabel("PaymentDate");
	

	JTextField paymentid_txf=new JTextField();
	JTextField reservationid_txf=new JTextField();
	JTextField amount_txf=new JTextField();
	JTextField paymentdate_txf=new JTextField();
	

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
	public PaymentsForm() {
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
		frame.setTitle("PAYMENTS FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}
	
	private void setLocationandSize() {
		paymentid_lb.setBounds(10, 10, 130, 30);
		reservationid_lb.setBounds(10, 50, 120, 30);
		amount_lb.setBounds(10, 90, 100, 30);
		paymentdate_lb.setBounds(10, 130, 100, 30);
		
		
		
		paymentid_txf.setBounds(200, 10, 170, 30);
		reservationid_txf.setBounds(200, 50, 170, 30);
		amount_txf.setBounds(200, 90, 170, 30);
		paymentdate_txf.setBounds(200, 130, 170, 30);
		
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);

		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		paymentid_lb.setFont(font);
		reservationid_lb.setFont(font);
		amount_lb.setFont(font);
		paymentdate_lb.setFont(font);
	
		

		paymentid_txf.setFont(font);
		reservationid_txf.setFont(font);
		amount_txf.setFont(font);
		paymentdate_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(paymentid_lb);
		frame.add(reservationid_lb);
		frame.add(amount_lb);
		frame.add(paymentdate_lb);
		
		frame.add(paymentid_txf);
		frame.add(reservationid_txf);
		frame.add(amount_txf);
		frame.add(paymentdate_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		payments som=new payments();
		if(e.getSource()==insert_btn) {
			som.setReservationid(reservationid_txf.getText());
			som.setAmount(amount_txf.getText());
			som.setPaymentdate(paymentdate_txf.getText());
			
			
			som.insertData();
			
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("Payment ID");
            model.addColumn("Reservation ID");
            model.addColumn("Amount");
            model.addColumn("PaymentDate");
           
           
            ResultSet resultSet =payments.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

		
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(paymentid_txf.getText());
	    	som.setReservationid(reservationid_txf.getText());
			som.setAmount(amount_txf.getText());
			som.setPaymentdate(paymentdate_txf.getText());
			
			
	    	som.update(id);
	    }
	  else {
			int id=Integer.parseInt(paymentid_txf.getText());
			som.delete(id);}

	  }		
		public static void main(String[] args) {
			PaymentsForm ef=new PaymentsForm();
			System.out.println(ef);
		
			
		}

	}






