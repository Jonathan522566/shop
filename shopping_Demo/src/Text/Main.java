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
      //���
      jButton1=new JButton("bt1");
      jButton2=new JButton("bt2");
      jButton3=new JButton("bt3");

      //��Ƭ����
      CardLayout cardLayout=new CardLayout();
      jPanel =new JPanel(cardLayout);
      jPanel.add(jButton1,"bt1");
      jPanel.add(jButton2,"bt2");
      jPanel.add(jButton3,"bt3");

      cardLayout.show(jPanel,"bt2");

      //�������
      add(jPanel);
      setTitle("���Դ���");
      setBounds(300,300,800,500);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      new Timer(2000, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            cardLayout.next(jPanel);//��������ָ����һ�������Ŀ�Ƭ����
          }
      }).start();

  }

    public static void main(String[] args) {
        new Main();
    }
}
