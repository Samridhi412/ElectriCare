/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class GenerateBill extends JFrame implements ActionListener {
    String meter;
    JButton bill;
    Choice cmonth;
    JTextArea area;
    GenerateBill(String meter){
        this.meter = meter;
        setSize(500, 800);
        setLocation(550, 30);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JLabel heading = new JLabel("Generate Bill");
        JLabel meternumber = new JLabel(meter);
        cmonth = new Choice();
        cmonth = new Choice();
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);
        
        area = new JTextArea(50, 15);
        area.setText("\n\n\t--------click on the----------\n\t Generate Bill Button to get\n\tthe bill of the selected month");
        area.setFont(new Font("SenSerif", Font.ITALIC, 18));
        JScrollPane pane = new JScrollPane(area);
        bill = new JButton("Generate Bill");
        bill.addActionListener(this);
        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);
        add(panel, "North");
        add(pane, "Center");
        add(bill, "South");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            String month = cmonth.getSelectedItem();
            area.setText("\tReliance Power Limited\nELECTRICITY BILL GENERATED FOR THE MONTH\t\n of "+month+", 2023\n\n\n");
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            if(rs.next()){
                area.append("\n     Customer Name: " + rs.getString("name"));
                area.append("\n     Meter Number: " + rs.getString("meter_no"));
                area.append("\n     Address: " + rs.getString("address"));
                area.append("\n     State: " + rs.getString("state"));
                area.append("\n     City: " + rs.getString("city"));
                area.append("\n     Email: " + rs.getString("email"));
                area.append("\n     Phone: " + rs.getString("phone"));
                area.append("\n--------------------------------------------");
                area.append("\n");
                
            }
            
            ResultSet rs1 = c.s.executeQuery("select * from meter_info where meter_number = '"+meter+"'");
            if(rs1.next()){
                area.append("\n     Meter Location: " + rs1.getString("meter_location"));
                area.append("\n     Meter Tyoe: " + rs1.getString("meter_type"));
                area.append("\n     Phase Code: " + rs1.getString("phase_code"));
                area.append("\n     Bill Type: " + rs1.getString("bill_type"));
                area.append("\n     Days: " + rs1.getString("days"));
                area.append("\n--------------------------------------------");
                area.append("\n");
                
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from tax");
            if(rs2.next()){
                area.append("\n");
                area.append("\n");
                area.append("\n     Cost Per Unit: " + rs2.getString("cost_per_unit"));
                area.append("\n     Meter Rent: " + rs2.getString("meter_rent"));
                area.append("\n     Service Charge: " + rs2.getString("service_charge"));
                area.append("\n     Service Tax: " + rs2.getString("service_tax"));
                area.append("\n     Swachh Bharat Cess: " + rs2.getString("swachh_bharat_cess"));
                area.append("\n     Fixed Tax: " + rs2.getString("fixed_tax"));
                area.append("\n--------------------------------------------");
                area.append("\n");
                
            }
            
             ResultSet rs3 = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+month+"'");
            if(rs3.next()){
                area.append("\n");
                area.append("\n");
                area.append("\n     Current Month: " + rs3.getString("month"));
                area.append("\n     Units Comsumed: " + rs3.getString("units"));
                area.append("\n     Total Charges: " + rs3.getString("totalbill"));
                area.append("\n--------------------------------------------");
                area.append("\n     Total Payable: " + rs3.getString("totalbill"));
                area.append("\n");
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new GenerateBill("");
    }
    
}
