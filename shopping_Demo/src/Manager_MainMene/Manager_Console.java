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
    Connection conn=null;//用于连接
    Statement stat=null;//用于过渡
    ResultSet rs=null;//用于如查询的函数



    public Manager_Console() throws SQLException {
        //按钮
        JButton b1=new JButton("确认");
        JLabel l1=new JLabel("商品名称：");
        JLabel l2=new JLabel("上架/下架：");
        TextField t1=new TextField(20);
        TextField t2=new TextField(20);


        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(b1);




        // 创建表格
        Object[] names = {"生产编号","商品款式","商品名称","商品数量","商品单价","购买日期","产地","类别" };
        Object[][] data = new String[30][names.length];
        defaultModel = new DefaultTableModel(data, names);// 创建表格
        jtable = new JTable(defaultModel);
        // jtable.setPreferredScrollableViewportSize(new Dimension(400, 350));
        JScrollPane s = new JScrollPane(jtable);
        // 将jtable中的数据全部居中
        DefaultTableCellRenderer dTCReader = new DefaultTableCellRenderer();
        dTCReader.setHorizontalAlignment(SwingConstants.CENTER);
        for (Object s1 : names) {
            jtable.getColumn(s1).setCellRenderer(dTCReader);
        }

        setLayout(new BorderLayout());
        add(p1,BorderLayout.SOUTH);//放按钮
        add(s, BorderLayout.CENTER);
        setVisible(true);

        //将数据放入表格
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

        //按钮的监听器
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager_Sys_produce_alter a=new Manager_Sys_produce_alter();
                   String s1=t2.getText();//上架或下架
                   String s2=t1.getText();//商品名字
                    try {
                        if(s1.equals("") ||s2.equals("")){
                            JOptionPane.showMessageDialog(null,"请把信息填写完整");
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
