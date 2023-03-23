import java.sql.*;

public class NavigatingQueryResult1 {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            rs.first();
            System.out.println(rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME"));
            rs.last();
            System.out.println(rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME"));
            rs.previous();
            System.out.println(rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME"));
            rs.absolute(2);
            System.out.println(rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME"));

            rs.beforeFirst();
            rs.next();
            System.out.println(rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME"));
            rs.afterLast();
            rs.previous();
            System.out.println(rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME"));



        } catch (SQLException e) {
            System.out.println("Error Has Occurred " + e.getMessage());
        }



    }

}

