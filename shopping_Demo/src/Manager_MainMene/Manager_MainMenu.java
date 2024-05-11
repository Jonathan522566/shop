

package Manager_MainMene;

import DBHelp.dbutils.DBHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager_MainMenu extends JFrame {
     public JPanel panel1;
     public JPanel panel2;
     public JPanel cardPanel;
     public JPanel panel4;

     public JButton produce;
     public JButton sales;
     public JButton stock;
     public JButton stock1;//����

     public JLabel title;
     public  Font font;
     public CardLayout card;//��Ƭ����


    public Manager_MainMenu() throws SQLException {
        //���
        setLayout(new BorderLayout());//�߿򲼾�
        font = new Font("�����п�", Font.PLAIN, 36);
        title = new JLabel("����һ�廯��Ϣϵͳ");
        title.setFont(font);//���LABEL����

        sales = new JButton("����ϵͳ");
        produce = new JButton("����ϵͳ");
        stock = new JButton("����ɸѡ");//��ť
        stock1 = new JButton("�ϼ�/�¼�");//������ť


        panel1 = new JPanel();
        panel2 = new JPanel();
        cardPanel = new JPanel();
        panel4 = new JPanel();//����


        //��װ
        panel1.add(title);
        panel2.setLayout(new GridLayout(10, 1));//���񲼾�
        panel2.add(sales);
        panel2.add(produce);
        panel2.add(stock);
        panel2.add(stock1);



        card = new CardLayout();//���Ʋ���
        cardPanel.setLayout(card);
        String[] cardName = {"0", "1", "2", "3"};
        cardPanel.add(new Manager_SalesUI(), cardName[0]);
        cardPanel.add(new Manager_StockUI(), cardName[1]);
        cardPanel.add(new Manager_ProduceUI(), cardName[2]);
        cardPanel.add(new Manager_Console(), cardName[3]);


        panel4.setLayout(new BorderLayout());
        panel4.add(panel2, BorderLayout.WEST);
        panel4.add(cardPanel, BorderLayout.CENTER);

        add(panel1, BorderLayout.NORTH);
        add(panel4, BorderLayout.CENTER);


        //�������
        setTitle("��ӭʹ��ϵͳ��");
        // setBounds(300,200,800,500);
        setBounds(300, 200, 1000, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //������
        sales.addActionListener(new Manager_MainMenuAction(this));
        stock.addActionListener(new Manager_MainMenuAction(this));
        produce.addActionListener(new Manager_MainMenuAction(this));//this���ù�����
        stock1.addActionListener(new Manager_MainMenuAction(this));


    }
}

