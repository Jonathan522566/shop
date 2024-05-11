package Text;

import javax.swing.*;
import java.awt.*;

public class Sys_Produce extends JFrame {
    JTextField produceID,mdesID,mdesName,Number,unitPrice,purchaseDate,produceFactory,remark;
    JButton b1,b2;
    //JPanel p1;
   Sys_Produce(){
       setLayout(new FlowLayout());//让文本框显示出来
      // setLayout(new BorderLayout());
       produceID =new JTextField(20);
       mdesID =new JTextField(20);
       mdesName =new JTextField(20);
       Number =new JTextField(20);
       unitPrice =new JTextField(20);
       purchaseDate =new JTextField(20);
       produceFactory =new JTextField(20);
       remark =new JTextField(20);
        b1=new JButton("生产");
        b2=new JButton("重设");
       add(new Label("produceID:"));
       add(produceID);
       add(new Label("mdesID:"));
       add(mdesID);
       add(new Label("mdesName:"));
       add(mdesName);
       add(new Label("Number:"));
       add(Number);
       add(new Label("unitprice:"));
       add(unitPrice);
       add(new Label("purchaseDate:"));
       add(purchaseDate);
       add(new Label("produceFactory:"));
       add(produceFactory);
       add(new Label("REMARK:"));
       add(remark);
       add(b1);
       add(b2);



       //界面属性
       setTitle("生产系统");
       setBounds(300,300,370,500);
       this.setResizable(false);//不可调大小
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setVisible(true);
   }

    public static void main(String[] args) {
        new Sys_Produce();
    }
}
