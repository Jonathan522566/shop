package Manage_Dao;

import DBHelp.dbutils.DBHelper;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*public class Manager_Sys_produce_query extends JFrame {
    //定义变量
    Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;

    public Manager_Sys_produce_query(String type) throws SQLException {
        String sql="select * from produceinfo where remark='"+type+"';";
        System.out.println(sql);
        try {
            conn = DBHelper.getConn();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            JOptionPane.showMessageDialog(null,"查询成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {
       // Manager_Sys_produce_query q=new Manager_Sys_produce_query("服饰");
    }


}*/
