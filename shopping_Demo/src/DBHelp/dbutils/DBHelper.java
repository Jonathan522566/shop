package DBHelp.dbutils;

import java.sql.*;

//数据库连接
public class DBHelper {
    private static Connection conn=null;
    private static String drive="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/xianmusx?serverTimezone=Asia/Shanghai&useSSL=false";
    public static String user ="root";
    public static String password = "123456";

    public static Connection getConn(){//static有局部变量变成全局变量的效果 .不能使用super和this关键字
        try{
            Class.forName(drive);
            conn= DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

   //数据库的关闭
   public static  void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if (conn!=null){
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       if (pstmt!=null){
           try{
               pstmt.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       if (rs!=null){
           try{
               rs.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
}
