package Manager_MainMene;

import DBHelp.dbutils.DBHelper;
import Manage_Dao.Manager_Sys_produce_alter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager_Console extends JPanel {
    public DefaultTableModel defaultModel;
    public JTable jtable;
    Connection conn=null;//��������
    Statement stat=null;//���ڹ���
    ResultSet rs=null;//�������ѯ�ĺ���



    public Manager_Console() throws SQLException {
        //��ť
        JButton b1=new JButton("ȷ��");
        JLabel l1=new JLabel("��Ʒ���ƣ�");
        JLabel l2=new JLabel("�ϼ�/�¼ܣ�");
        TextField t1=new TextField(20);
        TextField t2=new TextField(20);


        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(b1);




        // �������
        Object[] names = {"�������","��Ʒ��ʽ","��Ʒ����","��Ʒ����","��Ʒ����","��������","����","���" };
        Object[][] data = new String[30][names.length];
        defaultModel = new DefaultTableModel(data, names);// �������
        jtable = new JTable(defaultModel);
        // jtable.setPreferredScrollableViewportSize(new Dimension(400, 350));
        JScrollPane s = new JScrollPane(jtable);
        // ��jtable�е�����ȫ������
        DefaultTableCellRenderer dTCReader = new DefaultTableCellRenderer();
        dTCReader.setHorizontalAlignment(SwingConstants.CENTER);
        for (Object s1 : names) {
            jtable.getColumn(s1).setCellRenderer(dTCReader);
        }

        setLayout(new BorderLayout());
        add(p1,BorderLayout.SOUTH);//�Ű�ť
        add(s, BorderLayout.CENTER);
        setVisible(true);

        //�����ݷ�����
        try {
            int i = 0;
            conn = DBHelper.getConn();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from produceinfo;");
            while (rs.next()) {
                String produceID = rs.getString("produceID");
                String mdseID = rs.getString("mdseID");
                String mdseName = rs.getString("mdseName");
                String Number = rs.getString("Number");
                String unitPrice = rs.getString("unitPrice");
                String purchaesDate = rs.getString("purchaesDate");
                String produceFactory = rs.getString("produceFactory");
                String remark = rs.getString("remark");
                jtable.setValueAt(produceID, i, 0);
                jtable.setValueAt(mdseID, i, 1);
                jtable.setValueAt(mdseName, i, 2);
                jtable.setValueAt(Number, i, 3);
                jtable.setValueAt(unitPrice, i, 4);
                jtable.setValueAt(purchaesDate, i, 5);
                jtable.setValueAt(produceFactory, i, 6);
                jtable.setValueAt(remark, i, 7);
                i++;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        //��ť�ļ�����
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager_Sys_produce_alter a=new Manager_Sys_produce_alter();
                   String s1=t2.getText();//�ϼܻ��¼�
                   String s2=t1.getText();//��Ʒ����
                    try {
                        if(s1.equals("") ||s2.equals("")){
                            JOptionPane.showMessageDialog(null,"�����Ϣ��д����");
                        }else{
                            a.alter_Message(s1,s2);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

            }
        });

    }

    public static void main(String[] args) throws SQLException {
       new Manager_Console();
    }
}
