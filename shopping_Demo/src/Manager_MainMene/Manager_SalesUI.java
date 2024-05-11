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
        // �������
        Object[] names = {"�������","��Ʒ��ʽ","��Ʒ����","��Ʒ����","��Ʒ����","��������","����","���" };
        Object[][] data = new String[20][names.length];
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

        // ��װ����ϵͳ����
        name = new JLabel("��Ʒ����");
        num = new JLabel("����");
        maney = new JLabel("�ܼ�");
        namefield=new JTextField(10);
        numfield=new JTextField(10);
        maneyfield=new JTextField(10);

        yesButton=new JButton("ȷ������");
        reButton=new JButton("����");

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


        //�����ݷ�����
        try {
            int i = 0;
            Connection conn = DBHelper.getConn();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from produceinfo where produceID='�ϼ�';");
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
