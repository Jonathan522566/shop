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

//jtable�Ľ���

public class Manager_ProduceUI extends JPanel {
    public DefaultTableModel defaultModel;
    public JTable jtable;
    public JButton yButton,newButton;
    Connection conn=null;//��������
    Statement stat=null;//���ڹ���
    ResultSet rs=null;//�������ѯ�ĺ���


    public Manager_ProduceUI(){
        setLayout(new BorderLayout());
       // �������
        String[] names={"�ϼ�/�¼�","��Ʒ��ʽ","��Ʒ����","��Ʒ����","��Ʒ����","��������","����","���"};
        Object [] [] date=new String[30][names.length];
        defaultModel=new DefaultTableModel(date,names);//���
        jtable=new JTable(defaultModel);//�ѱ��ŵ�jtable��
        JScrollPane s=new JScrollPane(jtable);//�������

        DefaultTableCellRenderer dTCReader=new DefaultTableCellRenderer();
        dTCReader.setHorizontalAlignment(SwingConstants.CENTER);//����jtable����
         for(Object s1: names){
             jtable.getColumn(s1).setCellRenderer(dTCReader);
         }

         //�����ݷ�����
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


        //��װ����ϵͳproduceID,mdseID,mdseName,Number,unitPrice,purchaesDate,produceFactory,remark;
        //��װ�ı��������ı�
        JTextField produceIDField=new JTextField(20);
        JTextField mdseID=new JTextField(20);
        JTextField mdseName=new JTextField(20);
        JTextField Number=new JTextField(20);
        JTextField unitPrice=new JTextField(20);
        JTextField purchaesDate=new JTextField(20);
        JTextField produceFactory=new JTextField(20);
        JTextField remark=new JTextField(20);
        yButton=new JButton("������Ʒ");
        newButton=new JButton("���Ӳ���");



        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(2,4));
        p1.add(new JLabel("�ϼ�/�¼�:"));
        p1.add(produceIDField);
        p1.add(new JLabel("��Ʒ��ʽ:"));
        p1.add(mdseID);
        p1.add(new JLabel("��Ʒ����:"));
        p1.add(mdseName);
        p1.add(new JLabel("��Ʒ����:"));
        p1.add(Number);
        p1.add(new JLabel("����:"));
        p1.add(unitPrice);
        p1.add(new JLabel("��������:"));
        p1.add(purchaesDate);
        p1.add(new JLabel("����:"));
        p1.add(produceFactory);
        p1.add(new JLabel("���:"));
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

         //������produceID,mdseID,mdseName,Number,unitPrice,purchaesDate,produceFactory,remark;
        //ʵ�ֽ�����¼�����ݿ�
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

                //�����ݿ�Խ�
                Manger_Sys_produce1_insert sp1 = new Manger_Sys_produce1_insert();
                try {

                    if(p.equals("") ||m.equals("")||md.equals("")||n.equals("")||u.equals("")||pu.equals("")||pr.equals("")||s.equals("")){
                        JOptionPane.showMessageDialog(null,"�����Ϣ��д����");
                    }else{
                        sp1.Sys_produce1(p,m,md,n,u,pu,pr,s);
                        JOptionPane.showMessageDialog(null,"��������");

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

                //�����ݿ�Խ�
                if(md.equals("")||n.equals("")){
                    JOptionPane.showMessageDialog(null,"�����Ϣ��д��Ʒ����Ŀ������");
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
