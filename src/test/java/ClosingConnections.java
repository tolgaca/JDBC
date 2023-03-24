import java.sql.*;

public class ClosingConnections {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";


        // only work with auto closeable resources
        try( Connection connection = DriverManager.getConnection(url, username, password);
             Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");)
        {
            rs.next();
            System.out.println(rs.getString(2));

        }catch (SQLException e) {
            System.out.println("Error has occurred " + e.getMessage());
        }
      /*
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");

            System.out.println("All Successful");
        }catch (SQLException e){
            System.out.println("Error has occurred " + e.getMessage());
        }finally {
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(connection != null) connection.close();
            }catch (SQLException e){
                System.out.println("Error while closing resources " + e.getMessage());
            }
        }



       */


    }




}
