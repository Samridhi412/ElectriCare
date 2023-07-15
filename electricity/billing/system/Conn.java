//JDBC (JAVA DATABASE CONNECTION)
//1. Register the driver class
//2. Creating connection
//3. Creating Statement
//4. Execute mysql queries
//5. Close connections
package electricity.billing.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","sam1234");
        s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
