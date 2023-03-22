import java.sql.*;

public class NavigatingQueryResult {

    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            rs.next();
            System.out.println("Region Id on first row is "+ rs.getString(1));
            System.out.println("Region Id on first row is "+ rs.getString("REGION_ID"));
            System.out.println("Region NAME on first row is "+ rs.getString(2));
            System.out.println("Region NAME on first row is "+ rs.getString("REGION_NAME"));

            rs.next();
            System.out.println("Region NAME on SECOND row is "+ rs.getString("REGION_NAME"));
            rs.next();
            System.out.println("Region NAME on THIRD row is "+ rs.getString("REGION_NAME"));
            rs.next();
            System.out.println("Region NAME on FOURTH row is "+ rs.getString("REGION_NAME"));

            System.out.println("Do we have more data "+ rs.next());
            System.out.println("Reggion name after last row is " + rs.getString("REGION_NAME"));

            rs.previous();

        }catch (SQLException e) {
            System.out.println("Connection has failed "+ e.getMessage());
        }



    }
}
