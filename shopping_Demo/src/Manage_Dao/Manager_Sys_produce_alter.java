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

//�����޸�number������
    public void Manager_Sys_produce2(String Number,String mdseName){
        try{
            String sql="update produceinfo set Number='"+Number+"' where mdseName='"+mdseName+"';";
            conn= DBHelper.getConn();
            stat=conn.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"��ʼ����");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



 // �����޸��ϼ����¼���Ϣ
    public void alter_Message(String produceID,String mdseName) throws SQLException {
        try {
            String sql = "update produceinfo set produceID='" + produceID + "' where mdseName='" + mdseName + "';";
            conn = DBHelper.getConn();
            stat = conn.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"�������");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }





    public static void main(String[] args) {
       // Manager_Sys_produce2 m=new Manager_Sys_produce2();
       // m.Manager_Sys_produce2(150,"����������");
    }


}
