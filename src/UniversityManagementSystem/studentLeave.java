package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class studentLeave extends JFrame implements ActionListener {

    Choice crollno, ctime;
    JButton apply, cancel;
    JDateChooser dcdate;

    studentLeave() {
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply for Leave");
        heading.setBounds(150, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 20);
        add(crollno);
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);

        JLabel lblduration = new JLabel("Duration");
        lblduration.setBounds(60, 260, 200, 20);
        lblduration.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblduration);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        apply = new JButton("Apply");
        apply.setBounds(60, 350, 100, 25);
        apply.setBackground(Color.BLACK);
        apply.setForeground(Color.WHITE);
        apply.addActionListener(this);
        apply.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(apply);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == apply) {
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into studentleave values('" + rollno + "', '" + date + "', '" + duration + "')";

            try {
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new studentLeave();
    }
}
