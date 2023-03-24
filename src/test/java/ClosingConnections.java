import java.sql.*;

public class ClosingConnections {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");





        rs.close();
        stmt.close();
        connection.close();

    }




}
