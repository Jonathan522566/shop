package Text;

import com.sun.jdi.PathSearchingVirtualMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextF  extends JFrame{
    public static void main(String[] args) {
        TextF t=new TextF();

        String s1=null;
        String s2=null;

        JTextField t1=new JTextField(20);
        JTextField t2=new JTextField(20);
        JButton b=new JButton("ȷ��");

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().equals("") || t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"��д��Ϣ");
                }else{
                    JOptionPane.showMessageDialog(null,"�Ѿ�����");
                }
            }
        });

        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p1.add(new JLabel("�˺ţ�"));
        p1.add(t1);
        p1.add(new JLabel("���룺"));
        p1.add(t2);
        p2.add(b);

       t.setBounds(300,300,800,500);
       t.setLayout(new GridLayout(2,1));
       t.add(p1);
       t.add(p2);
       t.setVisible(true);




    }
}
