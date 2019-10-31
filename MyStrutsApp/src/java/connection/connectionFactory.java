
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbimobiliaria";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER,PASSWORD);                    
          } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Error in connection",ex);
        }
    }
        
    public static void closeConnection(Connection con) {     
        if (con != null){             
             try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Error:"+ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {     
        if (stmt != null){             
             try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Error:"+ex);
            }
        }  
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {     
        if (rs != null){             
             try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Error:"+ex);
            }
        }
        closeConnection(con);
    }
}
