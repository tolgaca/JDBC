import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("ERROR WHILE GETTING RESULT SET");
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

    public static int getRowCount(){

        int rowCount = 0;
        try {
            rs.last();
            rowCount=rs.getRow();
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ROW COUNT " + e.getMessage());
        }

        return rowCount;

    }

    public static int getColumnCNT(){
        int colCount = 0;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING THE COLUMNS " + e.getMessage());
        }
        return colCount;
    }


    public static List<String> getColumnNames(){

        List<String> colNameList = new ArrayList<>();

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int colNum = 1; colNum <= rsmd.getColumnCount(); colNum++) {

                String colName = rsmd.getColumnName(colNum);
                colNameList.add(colName);

            }
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING COLUMN NAMES " + e.getMessage());
        }


        return colNameList;
    }


    public static List<String> getRowDataAsList(int rowNum){
        List<String> rowDataList = new ArrayList<>();

        try {
            rs.absolute(rowNum);
            for (int colNum = 1; colNum <= getColumnCNT(); colNum++) {

                String cellValue = rs.getString(colNum);
                rowDataList.add(cellValue);

            }
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING RowDataAsList " + e.getMessage());
        }
        return rowDataList;
    }

    public static void main(String[] args) throws SQLException {

        createConnection();
        ResultSet myResult = runQuery("SELECT * FROM REGIONS");
        rs.next();
        System.out.println(rs.getString(1));

        System.out.println(getRowCount());
        System.out.println(getColumnCNT());

        System.out.println(getColumnNames());

        System.out.println(getRowDataAsList(3));


        destroy();

    }
}
