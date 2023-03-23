import java.sql.*;

public class ResultSetMetaData_ForColumnInfo {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");

            ResultSetMetaData rsmd =rs.getMetaData(); //YOU CAN COLUMN RELATED INFO IN THIS WAY
            int columnCount = rsmd.getColumnCount();
            //String firstColumn = rsmd.getColumnName(1);

            //System.out.println("columnCount = " + columnCount);
            //System.out.println("firstColumn = " + firstColumn);

            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {

                System.out.print(rsmd.getColumnName(colIndex)+" \t");

            }
            System.out.println();
            while (rs.next()){
                //printing all data in one row
                rs.next();
                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    System.out.print(rs.getString(colIndex)+ " \t");

                }
                System.out.println();
            }



        } catch (SQLException e) {
            System.out.println("Error Has Occurred " + e.getMessage());
        }



    }
}
