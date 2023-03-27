import java.sql.*;

public class DB_Utility_Recording {

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public  static  void createConnection(){
        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");

        }catch (SQLException e){
            System.out.println("Connection has failed " + e.getMessage());
        }
    }

    public static ResultSet runQuery(String query){

        try {
             stmt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING RESULTSET");
        }
        return rs;
    }


    public static  void destroy(){


            try {
                if(rs!= null) {
                    rs.close();
                }
                if(stmt!= null) {
                    stmt.close();
                }
                if(conn!= null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public  static int getRowCount(){

        int rowCount = 0;
        rs.last();

    }


    public static void main(String[] args) throws SQLException {

        createConnection();
        ResultSet myResult = runQuery("SELECT * FROM REGIONS");
        rs.next();
        System.out.println(rs.getString(1));

        destroy();

    }
}
