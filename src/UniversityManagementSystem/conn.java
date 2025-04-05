
package UniversityManagementSystem;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "uzairmalik12");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
