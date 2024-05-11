

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
     public JButton stock1;//新增

     public JLabel title;
     public  Font font;
     public CardLayout card;//卡片布局


    public Manager_MainMenu() throws SQLException {
        //组件
        setLayout(new BorderLayout());//边框布局
        font = new Font("华文行楷", Font.PLAIN, 36);
        title = new JLabel("产销一体化信息系统");
        title.setFont(font);//设计LABEL字体

        sales = new JButton("销售系统");
        produce = new JButton("生产系统");
        stock = new JButton("分类筛选");//按钮
        stock1 = new JButton("上架/下架");//新增按钮


        panel1 = new JPanel();
        panel2 = new JPanel();
        cardPanel = new JPanel();
        panel4 = new JPanel();//容器


        //组装
        panel1.add(title);
        panel2.setLayout(new GridLayout(10, 1));//网格布局
        panel2.add(sales);
        panel2.add(produce);
        panel2.add(stock);
        panel2.add(stock1);



        card = new CardLayout();//卡牌布局
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


        //界面设计
        setTitle("欢迎使用系统！");
        // setBounds(300,200,800,500);
        setBounds(300, 200, 1000, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //监听器
        sales.addActionListener(new Manager_MainMenuAction(this));
        stock.addActionListener(new Manager_MainMenuAction(this));
        produce.addActionListener(new Manager_MainMenuAction(this));//this调用构造器
        stock1.addActionListener(new Manager_MainMenuAction(this));


    }
}

