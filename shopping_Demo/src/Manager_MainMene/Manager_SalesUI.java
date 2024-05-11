package Manager_MainMene;

import DBHelp.dbutils.DBHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Manager_SalesUI extends JPanel {
    public DefaultTableModel defaultModel;
    public JTable jtable;
    public JLabel name, num, maney;
    public JTextField namefield, numfield, maneyfield;
    public JButton yesButton, reButton;

    public Manager_SalesUI() {
        setLayout(new BorderLayout());
        // 创建表格
        Object[] names = {"生产编号","商品款式","商品名称","商品数量","商品单价","购买日期","产地","类别" };
        Object[][] data = new String[20][names.length];
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

        // 组装销售系统界面
        name = new JLabel("商品名称");
        num = new JLabel("数量");
        maney = new JLabel("总价");
        namefield=new JTextField(10);
        numfield=new JTextField(10);
        maneyfield=new JTextField(10);

        yesButton=new JButton("确认销售");
        reButton=new JButton("重置");

        JPanel p1=new JPanel();
        p1.add(name);
        p1.add(namefield);
        p1.add(num);
        p1.add(numfield);
        p1.add(maney);
        p1.add(maneyfield);

        JPanel p2=new JPanel();
        p2.add(yesButton);
        p2.add(reButton);

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.add(p1);
        panel.add(p2);


        add(s, BorderLayout.CENTER);
        add(panel,BorderLayout.SOUTH);

        setVisible(true);
        //return this;


        //将数据放入表格
        try {
            int i = 0;
            Connection conn = DBHelper.getConn();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from produceinfo where produceID='上架';");
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
    }





}
