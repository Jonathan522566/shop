package Manage_Dao;

import DBHelp.dbutils.DBHelper;


import javax.swing.*;
import java.sql.*;

public class Manger_Sys_produce1_insert {
    Connection conn=null;//��������
    Statement stat=null;//���ڹ���
    PreparedStatement ps=null;//��������sql���
    ResultSet rs=null;//�������ѯ�ĺ���


//insert into produceinfo(produceID,mdseID,mdseName,Number,unitPrice,purchaesDate,produceFactory,remark)
// values('1345465','154156','����',10,2,'2022-6-30','���������','δ֪');
         public  void   Sys_produce1(String produceID,String mdseID,String mdseName,String Number,String unitPrice,String purchaesDate,String produceFactory,String remark) throws SQLException {
         String sql="insert into produceinfo(produceID,mdseID,mdseName,Number,unitPrice,purchaesDate,produceFactory,remark)"+"values('" +produceID+"','"+ mdseID+"','"+ mdseName+"','"+ Number+"','"+ unitPrice+"','" + purchaesDate+"','"+ produceFactory+"','"+ remark+"');";
         conn=DBHelper.getConn();
          stat=null;
          rs=null;
         try{
             conn = DBHelper.getConn();//��������
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
      // sp.Sys_produce1("123113","1231232","����","15","4","2022-6-30","���������","δ֪");
    }
}
