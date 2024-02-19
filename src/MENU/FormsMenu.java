package MENU;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class FormsMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu guestsmenu;
    private JMenu hotelsmenu;
    private JMenu paymentsmenu;
    private JMenu reservationsmenu;
    private JMenu roomsmenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem guestsItem;
    private JMenuItem hotelsItem;
    private JMenuItem paymentsItem;
    private JMenuItem reservationsItem;
    private JMenuItem roomsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();
       

        // Create home menu
        guestsmenu = new JMenu("guests");
        hotelsmenu = new JMenu("hotels");
        paymentsmenu= new JMenu("payments");
        reservationsmenu = new JMenu("reservations ");
        roomsmenu = new JMenu("rooms");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(guestsmenu);
        guestsItem = new JMenuItem("guestsForm");
        guestsItem.addActionListener(this);
        
        menuBar.add(hotelsmenu);
        hotelsItem = new JMenuItem("hotelsForm");
        hotelsItem.addActionListener(this);
        
        menuBar.add(paymentsmenu);
        paymentsItem = new JMenuItem("paymentsForm");
        paymentsItem.addActionListener(this);
        
        menuBar.add(reservationsmenu);
        reservationsItem = new JMenuItem("reservationsForm");
        reservationsItem.addActionListener(this);
        
        menuBar.add(roomsmenu);
        roomsItem = new JMenuItem("roomsForm");
        roomsItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        guestsmenu.add(guestsItem);
        hotelsmenu.add(hotelsItem);
        paymentsmenu.add(paymentsItem);
        reservationsmenu.add(reservationsItem);
        roomsmenu.add(roomsItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);
        
       

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };



        // Initialize dashboard panel
        JPanel dashboardPanel1 = new JPanel();
        dashboardPanel1.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel1);

        setVisible(true);
    }
   @Override
 
   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guestsItem) {
            new guestsForm.GuestsForm();
        
        } else if (e.getSource() == hotelsItem) {
            new hotelsForm.HotelsForm();
        
        } else if (e.getSource() == paymentsItem) {
            new paymentsForm.PaymentsForm();
       
        } else if (e.getSource() == reservationsItem) {
           new reservationsForm.ReservationsForm();
        
        } else if (e.getSource() == roomsItem) {
           new roomsForm.RoomsForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO PROJECT"));
    }
}
