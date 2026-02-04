package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel, signup;
    JTextField username, password;
    Choice logginin;

    Login() {
        super("Login Page");
        
        // Set the layout manager and background color
        setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        
        // Create gradient background for the panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(34, 193, 195);
                Color color2 = new Color(253, 187, 45);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        backgroundPanel.setBounds(0, 0, 800, 400); // Increased width to 800
        backgroundPanel.setLayout(null);
        add(backgroundPanel);

        // Create a rounded corner panel for login content
        JPanel panel = new JPanel();
        panel.setBounds(100, 20, 630, 280); // Adjusted width for the panel
        panel.setBackground(new Color(255, 255, 255, 180)); // Semi-transparent background
        panel.setLayout(null);

        // Increased the border thickness to 6
        panel.setBorder(BorderFactory.createLineBorder(new Color(34, 193, 195), 3, true)); // Increased the border thickness to 6
        backgroundPanel.add(panel);

        // Heading Label
        JLabel heading = new JLabel("Login to Your Account");
        heading.setBounds(130, 20, 200, 30);
        heading.setForeground(new Color(34, 193, 195));
        heading.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panel.add(heading);

        // Username label and text field
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 60, 100, 20);
        lblusername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(170, 60, 200, 30);
        username.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        username.setBorder(BorderFactory.createLineBorder(new Color(34, 193, 195), 2, true));
        username.setOpaque(true);
        panel.add(username);

        // Password label and text field
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 100, 100, 20);
        lblpassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(lblpassword);

        password = new JTextField();
        password.setBounds(170, 100, 200, 30);
        password.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        password.setBorder(BorderFactory.createLineBorder(new Color(34, 193, 195), 2, true));
        password.setOpaque(true);
        panel.add(password);

        // Login As label and dropdown
        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(60, 140, 100, 20);
        loggininas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(loggininas);

        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(170, 140, 200, 30);
        logginin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(logginin);

        // Login Button with rounded corners
        login = new JButton("Login");
        login.setBounds(60, 180, 120, 30);
        login.setFont(new Font("Segoe UI", Font.BOLD, 14));
        login.setForeground(Color.WHITE);
        login.setBackground(new Color(34, 193, 195));
        login.setFocusPainted(false);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setBackground(new Color(253, 187, 45));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                login.setBackground(new Color(34, 193, 195));
            }
        });
        panel.add(login);

        // Cancel Button with rounded corners
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 180, 120, 30);
        cancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(255, 102, 102));
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.addActionListener(this);
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel.setBackground(new Color(255, 72, 72));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel.setBackground(new Color(255, 102, 102));
            }
        });
        panel.add(cancel);

        // Signup Button with rounded corners
        signup = new JButton("Signup");
        signup.setBounds(170, 220, 100, 30);
        signup.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signup.setForeground(Color.WHITE);
        signup.setBackground(new Color(34, 193, 195));
        signup.setFocusPainted(false);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signup.setBackground(new Color(253, 187, 45));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                signup.setBackground(new Color(34, 193, 195));
            }
        });
        panel.add(signup);

        // Background Image (Second image added back)
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(360, 20, 250, 250); // Set image position
        panel.add(image);

        setSize(800, 400);  // Increased the width to 800
        setLocation(400, 200);
        setResizable(false);  // Disable resizing if needed to prevent layout breaks
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String susername = username.getText();
            String spassword = password.getText();
            String user = logginin.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + susername + "' and password = '" + spassword + "' and user = '" + user + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user, meter);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
