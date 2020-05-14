
package student_management_system_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student_Table extends JFrame implements ActionListener{
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel titleLabel, snLabel, idLabel,phoneLabel, smLabel,dLabel,aLabel;
    private JTextField snTf ,idTf, phoneTf , smTf,dTf,aTf;
    private JButton addButton,updateButton,deleteButton,clearButton;
    
    private String[] rows = {"Student Name","Student ID","Phone Number","Semister","Depertment","Advisor Name"};
    private String[] columns = new String[6];
    
    
    Student_Table()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,700);
        this.setLocationRelativeTo(null);
        this.setTitle("Student Table");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);
        
        Font font = new Font("Arial",Font.BOLD,16);
        
        titleLabel = new JLabel("Student Registration");
        titleLabel.setFont(font);
        titleLabel.setBounds(140, 10, 250, 50);
        c.add(titleLabel);
        
        snLabel = new JLabel("S_Name   : ");
        snLabel.setBounds(10, 80, 140, 30);
        snLabel.setFont(font);
        c.add(snLabel);
        
        snTf = new JTextField();
        snTf.setBounds(110, 80, 200, 30);
        snTf.setFont(font);
        c.add(snTf);
        
        addButton = new JButton("Add");
        addButton.setBounds(400, 80, 100, 30);
        addButton.setFont(font);
        c.add(addButton);
        
        idLabel = new JLabel("S_ID          : ");
        idLabel.setBounds(10, 130, 150, 30);
        idLabel.setFont(font);
        c.add(idLabel);
        
        idTf = new JTextField();
        idTf.setBounds(110, 130, 200, 30);
        idTf.setFont(font);
        c.add(idTf);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(400, 130, 100, 30);
        updateButton.setFont(font);
        c.add(updateButton);
        
        phoneLabel = new JLabel("Phone       : ");
        phoneLabel.setBounds(10, 180, 150, 30);
        phoneLabel.setFont(font);
        c.add(phoneLabel);
        
        phoneTf = new JTextField();
        phoneTf.setBounds(110, 180, 200, 30);
        phoneTf.setFont(font);
        c.add(phoneTf);
        
        deleteButton = new JButton("Delete ");
        deleteButton.setBounds(400, 180, 100, 30);
        deleteButton.setFont(font);
        c.add(deleteButton);
        
        smLabel = new JLabel("Semister   : ");
        smLabel.setBounds(10, 230, 150, 30);
        smLabel.setFont(font);
        c.add(smLabel);
        
        smTf = new JTextField();
        smTf.setBounds(110, 230, 200, 30);
        smTf.setFont(font);
        c.add(smTf);
        
        dLabel = new JLabel("Dept           : ");
        dLabel.setBounds(10, 230, 200, 140);
        dLabel.setFont(font);
        c.add(dLabel);
        
        dTf = new JTextField();
        dTf.setBounds(110, 280, 200, 30);
        dTf.setFont(font);
        c.add(dTf);
        
        aLabel = new JLabel("A_Name    : ");
        aLabel.setBounds(10, 220, 250, 250);
        aLabel.setFont(font);
        c.add(aLabel);
        
        aTf = new JTextField();
        aTf.setBounds(110, 330, 200, 30);
        aTf.setFont(font);
        c.add(aTf);
        
        clearButton = new JButton("Clear ");
        clearButton.setBounds(400, 230, 100, 30);
        clearButton.setFont(font);
        c.add(clearButton);
        
        table = new JTable();
        
        model = new DefaultTableModel();
       
        model.setColumnIdentifiers(rows);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.green);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        
        
        scroll = new JScrollPane(table);
        scroll.setBounds(10, 380, 750, 260);
        c.add(scroll);
        
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        
        table.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent me)
                {
                   int numberOfRow = table.getSelectedRow();
                   
                   String S_name = model.getValueAt(numberOfRow, 0).toString();
                   String S_ID = model.getValueAt(numberOfRow, 1).toString();
                   String phone = model.getValueAt(numberOfRow, 2).toString();
                   String Semister = model.getValueAt(numberOfRow, 3).toString();
                   String Dept = model.getValueAt(numberOfRow, 4).toString();
                   String A_Name = model.getValueAt(numberOfRow, 5).toString();
                   
                   snTf.setText(S_name);
                   idTf.setText(S_ID);
                   phoneTf.setText(phone);
                   smTf.setText(Semister);
                   dTf.setText(Dept);
                   aTf.setText(A_Name);
                }
            
        });
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == addButton)
        {
            rows[0] = snTf.getText();
            rows[1] = idTf.getText();
            rows[2] = phoneTf.getText();
            rows[3] = smTf.getText();
            rows[4] = dTf.getText();
            rows[5] = aTf.getText();
            model.addRow(rows);
        }
        
        else if(e.getSource() == clearButton)
        {
            snTf.setText("");
            idTf.setText("");
            phoneTf.setText("");
            smTf.setText("");
            dTf.setText("");
            aTf.setText("");
        }
        
        else if(e.getSource() == deleteButton)
        {
            int numberOfRow = table.getSelectedRow();
            
            if(numberOfRow >= 0)
            {
                model.removeRow(numberOfRow);
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "No Row Has Been Selected or No Row Exist");
            }
        }
        
        else if(e.getSource() == updateButton)
        {
            int numberOfRow = table.getSelectedRow();
            
            String S_name = snTf.getText();
            String S_ID = idTf.getText();
            String phone = phoneTf.getText();
            String Semister = smTf.getText();
            String Dept = dTf.getText();
            String A_Name = aTf.getText();
            
            model.setValueAt(S_name, numberOfRow, 0);
            model.setValueAt(S_ID, numberOfRow, 1);
            model.setValueAt(phone, numberOfRow, 2);
            model.setValueAt(Semister, numberOfRow, 3);
            model.setValueAt(Dept, numberOfRow, 4);
            model.setValueAt(A_Name, numberOfRow, 5);
        }
       
    }
    
    public static void main(String[] args) {
        
        Student_Table frame = new Student_Table();
        frame.setVisible(true);
    }

   
}
