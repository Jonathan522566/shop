package Manager_MainMene;

import DBHelp.dbutils.DBHelper;
import Manage_Dao.Manager_Sys_produce_alter;
import Manage_Dao.Manger_Sys_produce1_insert;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//jtable的建立

public class Manager_ProduceUI extends JPanel {
    public DefaultTableModel defaultModel;
    public JTable jtable;
    public JButton yButton,newButton;
    Connection conn=null;//用于连接
    Statement stat=null;//用于过渡
    ResultSet rs=null;//用于如查询的函数


    public Manager_ProduceUI(){
        setLayout(new BorderLayout());
       // 创建表格
        String[] names={"上架/下架","商品款式","商品名称","商品数量","商品单价","生产日期","产地","类别"};
        Object [] [] date=new String[30][names.length];
        defaultModel=new DefaultTableModel(date,names);//表格
        jtable=new JTable(defaultModel);//把表格放到jtable中
        JScrollPane s=new JScrollPane(jtable);//滑动面板

        DefaultTableCellRenderer dTCReader=new DefaultTableCellRenderer();
        dTCReader.setHorizontalAlignment(SwingConstants.CENTER);//设置jtable居中
         for(Object s1: names){
             jtable.getColumn(s1).setCellRenderer(dTCReader);
         }

         //将数据放入表格
        try{
            int i=0;
            conn=DBHelper.getConn();
            stat=conn.createStatement();
            rs=stat.executeQuery("select * from produceinfo");
             while(rs.next()){
               String produceID=rs.getString("produceID");
               String mdseID=rs.getString("mdseID");
                 String mdseName=rs.getString("mdseName");
                 String Number=rs.getString("Number");
                 String unitPrice=rs.getString("unitPrice");
                 String purchaesDate=rs.getString("purchaesDate");
                 String produceFactory=rs.getString("produceFactory");
                 String remark=rs.getString("remark");
                 jtable.setValueAt(produceID,i,0);
                 jtable.setValueAt(mdseID,i,1);
                 jtable.setValueAt(mdseName,i,2);
                 jtable.setValueAt(Number,i,3);
                 jtable.setValueAt(unitPrice,i,4);
                 jtable.setValueAt(purchaesDate,i,5);
                 jtable.setValueAt(produceFactory,i,6);
                 jtable.setValueAt(remark,i,7);
                 i++;
             }

        } catch (Exception e) {
            e.printStackTrace();
        }


        //组装销售系统produceID,mdseID,mdseName,Number,unitPrice,purchaesDate,produceFactory,remark;
        //组装文本和输入文本
        JTextField produceIDField=new JTextField(20);
        JTextField mdseID=new JTextField(20);
        JTextField mdseName=new JTextField(20);
        JTextField Number=new JTextField(20);
        JTextField unitPrice=new JTextField(20);
        JTextField purchaesDate=new JTextField(20);
        JTextField produceFactory=new JTextField(20);
        JTextField remark=new JTextField(20);
        yButton=new JButton("引入商品");
        newButton=new JButton("增加产量");



        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(2,4));
        p1.add(new JLabel("上架/下架:"));
        p1.add(produceIDField);
        p1.add(new JLabel("商品款式:"));
        p1.add(mdseID);
        p1.add(new JLabel("商品名字:"));
        p1.add(mdseName);
        p1.add(new JLabel("商品数量:"));
        p1.add(Number);
        p1.add(new JLabel("单价:"));
        p1.add(unitPrice);
        p1.add(new JLabel("生产日期:"));
        p1.add(purchaesDate);
        p1.add(new JLabel("厂商:"));
        p1.add(produceFactory);
        p1.add(new JLabel("类别:"));
        p1.add(remark);

        JPanel p2=new JPanel();
        p2.add(yButton);
        p2.add(newButton);

         JPanel panel=new JPanel();
         panel.setLayout(new GridLayout(2,1));
         panel.add(p1);
         panel.add(p2);

         add(s,BorderLayout.CENTER);
         add(panel,BorderLayout.SOUTH);
         setVisible(true);

         //监听器produceID,mdseID,mdseName,Number,unitPrice,purchaesDate,produceFactory,remark;
        //实现将数据录入数据库
        yButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p = produceIDField.getText();
                String m = mdseID.getText();
                String md = mdseName.getText();
                String n = Number.getText();
                String u = unitPrice.getText();
                String pu = purchaesDate.getText();
                String pr = produceFactory.getText();
                String s = remark.getText();

                //与数据库对接
                Manger_Sys_produce1_insert sp1 = new Manger_Sys_produce1_insert();
                try {

                    if(p.equals("") ||m.equals("")||md.equals("")||n.equals("")||u.equals("")||pu.equals("")||pr.equals("")||s.equals("")){
                        JOptionPane.showMessageDialog(null,"请把信息填写完整");
                    }else{
                        sp1.Sys_produce1(p,m,md,n,u,pu,pr,s);
                        JOptionPane.showMessageDialog(null,"启动生产");

                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String p = produceIDField.getText();
               // String m = mdseID.getText();
                String md = mdseName.getText();
                String n = Number.getText();
                //tring u = unitPrice.getText();
                //String pu = purchaesDate.getText();
                //String pr = produceFactory.getText();
               //String s = remark.getText();

                //与数据库对接
                if(md.equals("")||n.equals("")){
                    JOptionPane.showMessageDialog(null,"请把信息填写商品名和目标数量");
                }else{
                    Manager_Sys_produce_alter p2=new Manager_Sys_produce_alter();
                    p2.Manager_Sys_produce2(n,md);

                }

            }
        });






    }

    public static void main(String[] args) {
        new Manager_ProduceUI();
    }


}
