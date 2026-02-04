package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter, username, name, password;
    Signup() {
        setBounds(450, 150, 750, 450);
        getContentPane().setBackground(new Color(243, 243, 243));
        setLayout(null);

        // Create Gradient Background Panel
        JPanel gradientPanel = new JPanel() {
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
        gradientPanel.setBounds(0, 0, 750, 450);
        gradientPanel.setLayout(null);
        add(gradientPanel);

        // Create the main panel with rounded borders and shadow effect
        JPanel panel = new JPanel();
        panel.setBounds(50, 40, 650, 350);
        panel.setBorder(BorderFactory.createLineBorder(new Color(34, 193, 195), 3, true));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        gradientPanel.add(panel);

        // Heading with modern font and vibrant color
        JLabel heading = new JLabel("Create Account");
        heading.setBounds(230, 30, 180, 30);
        heading.setForeground(new Color(34, 193, 195));
        heading.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel.add(heading);

        // Account type dropdown with modern look
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 80, 150, 30);
        accountType.setBackground(new Color(255, 255, 255));
        accountType.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(accountType);

        // Labels with more spacing and clean font
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 120, 140, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(260, 120, 150, 30);
        meter.setBorder(BorderFactory.createLineBorder(new Color(34, 193, 195), 2, true));
        meter.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        meter.setVisible(false);
        panel.add(meter);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 160, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260, 160, 150, 30);
        username.setBorder(BorderFactory.createLineBorder(new Color(34, 193, 195), 2, true));
        username.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(username);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 200, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(260, 200, 150, 30);
        name.setBorder(BorderFactory.createLineBorder(new Color(34, 193, 195), 2, true));
        name.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(name);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 240, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(lblpassword);

        password = new JTextField();
        password.setBounds(260, 240, 150, 30);
        password.setBorder(BorderFactory.createLineBorder(new Color(34, 193, 195), 2, true));
        password.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(password);

        // Focus Listener for Meter number field
        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}

            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '" + meter.getText() + "'");
                    while (rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // ItemListener to toggle the visibility of meter field
        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });

        // Create button with rounded corners and hover effect
        create = new JButton("Create Account");
        create.setBackground(new Color(34, 193, 195));
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Segoe UI", Font.BOLD, 14));
        create.setBounds(100, 290, 160, 35);
        create.setFocusPainted(false);
        create.setBorder(BorderFactory.createEmptyBorder());
        create.setOpaque(true);
        create.addActionListener(this);
        create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                create.setBackground(new Color(253, 187, 45));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                create.setBackground(new Color(34, 193, 195));
            }
        });
        panel.add(create);

        // Back button with hover effect and modern design
        back = new JButton("Back");
        back.setBackground(new Color(255, 102, 102));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Segoe UI", Font.BOLD, 14));
        back.setBounds(280, 290, 160, 35);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setOpaque(true);
        back.addActionListener(this);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back.setBackground(new Color(255, 72, 72));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back.setBackground(new Color(255, 102, 102));
            }
        });
        panel.add(back);

        // Background Image (Optional)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390, 40, 280, 280);
        panel.add(image);

        setVisible(true);
    }

    // ActionListener for create and back buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();

            try {
                Conn c = new Conn();
                String query = null;
                if (atype.equals("Admin")) {
                    query = "insert into login values('" + smeter + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + atype + "')";
                } else {
                    query = "update login set username = '" + susername + "', password = '" + spassword + "', user = '" + atype + "' where meter_no = '" + smeter + "'";
                }
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
