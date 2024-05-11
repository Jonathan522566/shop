package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main extends JFrame{
    JPanel jPanel;
    JButton jButton1,jButton2,jButton3;
  Main(){
      //组件
      jButton1=new JButton("bt1");
      jButton2=new JButton("bt2");
      jButton3=new JButton("bt3");

      //卡片布局
      CardLayout cardLayout=new CardLayout();
      jPanel =new JPanel(cardLayout);
      jPanel.add(jButton1,"bt1");
      jPanel.add(jButton2,"bt2");
      jPanel.add(jButton3,"bt3");

      cardLayout.show(jPanel,"bt2");

      //界面设计
      add(jPanel);
      setTitle("测试窗口");
      setBounds(300,300,800,500);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      new Timer(2000, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            cardLayout.next(jPanel);//括号里面指定哪一个容器的卡片布局
          }
      }).start();

  }

    public static void main(String[] args) {
        new Main();
    }
}
