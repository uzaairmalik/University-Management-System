package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {

    JTextField tfName, tfFname, tfaddress, tfemail, tfphoneNo, tfx, tfxii, tfcnic;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        // Frame settings
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        // Heading label
        JLabel Heading = new JLabel("ADD NEW STUDENT");
        Heading.setBounds(310, 30, 500, 50);
        Heading.setFont(new Font("serif", Font.BOLD, 30));
        add(Heading);

        // Name label
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        // Name text field
        tfName = new JTextField();
        tfName.setBounds(200, 150, 150, 30);
        add(tfName);

        // Father Name label
        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        // Father Name text field
        tfFname = new JTextField();
        tfFname.setBounds(600, 150, 150, 30); 
        add(tfFname);

        // Roll Number label
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30); 
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        // Roll Number display label
        labelrollno = new JLabel("SP23-BCS-" + first4);
        labelrollno.setBounds(200, 200, 200, 30); 
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);
        
        // Date of Birth label
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
        // Address label
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        // Address text field
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        // Phone number label
        JLabel lblphNo = new JLabel("Contact Number");
        lblphNo.setBounds(400, 250, 200, 30);
        lblphNo.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphNo);

        // Phone number text field
        tfphoneNo = new JTextField();
        tfphoneNo.setBounds(600, 250, 150, 30);
        add(tfphoneNo);
        
        // Email label
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        // Class X label
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);
        
        // Class XII label
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);
        
        // CNIC label
        JLabel lblcnic = new JLabel("CNIC Number");
        lblcnic.setBounds(400, 350, 200, 30);
        lblcnic.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcnic);
        
        tfcnic = new JTextField();
        tfcnic.setBounds(600, 350, 150, 30);
        add(tfcnic);
        
        // Course label
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
       String  course[]={"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
       cbcourse =new JComboBox(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch[] = {"computer science","Software Engineering","Computer engineering","physiotherapy","BBA","Electrical Engineering","pharmaacy"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener((ActionListener) this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener((ActionListener) this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
    
        
        
        

        // Make frame visible
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfName.getText();
            String fname = tfFname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphoneNo.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfcnic.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            try {
                String query = "insert into student values('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";

                conn con = new conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
