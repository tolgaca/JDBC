import java.sql.*;

public class LoopingResultSet {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            while ((rs.next())){
                System.out.println(rs.getString(1) + " | " + rs.getString(2));
            }

            rs.beforeFirst();
            while ((rs.next())){
                System.out.println("ROW NUMBER IS "+ rs.getRow());
                System.out.println(rs.getString(1) + " | " + rs.getString(2));
            }

            rs.last();
            System.out.println("ROW NUMBER IS "+ rs.getRow());


        } catch (SQLException e) {
            System.out.println("Error Has Occurred " + e.getMessage());
        }

    }

}
