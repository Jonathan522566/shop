package Manage_Dao;

import DBHelp.dbutils.DBHelper;


import javax.swing.*;
import java.sql.*;

public class Manger_Sys_produce1_insert {
    Connection conn=null;//用于连接
    Statement stat=null;//用于过渡
    PreparedStatement ps=null;//用于输入sql语句
    ResultSet rs=null;//用于如查询的函数


//insert into produceinfo(produceID,mdseID,mdseName,Number,unitPrice,purchaesDate,produceFactory,remark)
// values('1345465','154156','辣条',10,2,'2022-6-30','华软便利店','未知');
         public  void   Sys_produce1(String produceID,String mdseID,String mdseName,String Number,String unitPrice,String purchaesDate,String produceFactory,String remark) throws SQLException {
         String sql="insert into produceinfo(produceID,mdseID,mdseName,Number,unitPrice,purchaesDate,produceFactory,remark)"+"values('" +produceID+"','"+ mdseID+"','"+ mdseName+"','"+ Number+"','"+ unitPrice+"','" + purchaesDate+"','"+ produceFactory+"','"+ remark+"');";
         conn=DBHelper.getConn();
          stat=null;
          rs=null;
         try{
             conn = DBHelper.getConn();//用于连接
             stat = conn.createStatement();
             stat.execute(sql);

         }catch(SQLException e){
             e.printStackTrace();
         }finally{
             DBHelper.closeAll(conn,ps,rs);
         }

     }

    public static void main(String[] args) throws SQLException {
      //Sys_produce1 sp= new Sys_produce1();
      // sp.Sys_produce1("123113","1231232","泡面","15","4","2022-6-30","华软便利店","未知");
    }
}
