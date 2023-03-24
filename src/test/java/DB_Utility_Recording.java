import java.sql.*;

public class DB_Utility_Recording {

    public  static  void createConnection(){
        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");

        }catch (SQLException e){
            System.out.println("Connection has failed " + e.getMessage());
        }
    }



    public static void main(String[] args) {



    }
}
