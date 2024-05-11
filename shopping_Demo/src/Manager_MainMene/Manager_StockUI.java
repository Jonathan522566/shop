package Manager_MainMene;

import DBHelp.dbutils.DBHelper;


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

public class Manager_StockUI extends JPanel {
    public DefaultTableModel defaultModel;
    public JTable jtable;
    public JButton button;
    public Choice choice;
    public JLabel select;
    public JTextField t1;
    Connection conn=null;//用于连接
    Statement stat=null;//用于过渡
    ResultSet rs=null;//用于如查询的函数



    public Manager_StockUI() throws SQLException {
        //组件
        button=new JButton("筛选");
        setLayout(new FlowLayout());
        /**choice=new Choice();
        select=new JLabel("Choose your option:");
        choice.add("食物");
        choice.add("Food");
        choice.add("Cloths");
        choice.add("DailyNecessaries");**/
        select=new JLabel("商品款式：");
        t1=new JTextField(20);
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(select);
        p1.add(t1);
        JPanel p2=new JPanel();
        p2.add(button);
        JPanel p3=new JPanel();
        p3.setLayout(new GridLayout(1,2));
        p3.add(p1);
        p3.add(p2);


        // 创建表格
        Object[] names = {"上架/下架","商品款式","商品名称","商品数量","商品单价","购买日期","产地","类别" };
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
        add(p3,BorderLayout.NORTH);
        add(s, BorderLayout.CENTER);
        setVisible(true);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将数据放入表格
                try {
                    int i = 0;
                    conn = DBHelper.getConn();
                    stat = conn.createStatement();
                    rs = stat.executeQuery("select * from produceinfo where remark='"+t1.getText()+"';");
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

                }catch (Exception eC) {
                    eC.printStackTrace();
                }
            }

        });




        //将数据放入表格
    /**  try {
            int i = 0;
            conn = DBHelper.getConn();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from produceinfo where remark='"+t1.getText()+"';");
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
    }**/




}}
