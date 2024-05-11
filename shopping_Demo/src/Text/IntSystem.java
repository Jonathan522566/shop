package Text;

import Text.Sys_Produce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntSystem extends JFrame {
    JPanel  contentPane;
    Image im;

    public IntSystem(){

        //按钮
        JButton b1=new JButton("销售");
        JButton b2=new JButton("库存");
        JButton b3=new JButton("生产");
        JPanel p=new JPanel();
        p.add(b1);
        p.add(b2);
        p.add(b3);
        add(p);

        //监听器
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sys_Produce();
            }
        });



        setVisible(true);
        setBounds(300,300,800,500);
        //pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }


    public static void main(String[] args) {

    }
    }
