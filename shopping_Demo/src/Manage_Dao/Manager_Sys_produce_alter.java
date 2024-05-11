package Manage_Dao;

import DBHelp.dbutils.DBHelper;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager_Sys_produce_alter {
    Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;

//用于修改number的数量
    public void Manager_Sys_produce2(String Number,String mdseName){
        try{
            String sql="update produceinfo set Number='"+Number+"' where mdseName='"+mdseName+"';";
            conn= DBHelper.getConn();
            stat=conn.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"开始增产");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



 // 用于修改上架与下架信息
    public void alter_Message(String produceID,String mdseName) throws SQLException {
        try {
            String sql = "update produceinfo set produceID='" + produceID + "' where mdseName='" + mdseName + "';";
            conn = DBHelper.getConn();
            stat = conn.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"更新完毕");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }





    public static void main(String[] args) {
       // Manager_Sys_produce2 m=new Manager_Sys_produce2();
       // m.Manager_Sys_produce2(150,"莱茵蓝短袖");
    }


}
