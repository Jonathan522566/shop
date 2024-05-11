package Manager_GUI;

import Manager_MainMene.Manager_MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Manager_landng {
    //�û�����ļ�⣺
    public static class LoginFrame extends JFrame implements ActionListener {
        //����Ķ���
        JLabel l1;
        JLabel l2;
        JTextField t1;
        JPasswordField t2;
        JButton b1;
        JButton b2;
         JPanel jPanel;

        LoginFrame() {
           //��������
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            //����Ĵ���
            t1= new JTextField(15);
            t2= new JPasswordField(15);
            b1=new JButton("�ύ");
            b2=new JButton("����");
            l1=new JLabel("�û���;");
            l2=new JLabel("���룺");
//this.setSize(300,300);

            //��Ӽ�����
            b1.addActionListener(this);
            b2.addActionListener(this);
            t1.addActionListener(this);
            t2.addActionListener(this);

            //������
            //setVisible(true);
            setTitle("����Ա��¼����");
            TextArea t = new TextArea(3, 1);

            //�м������Ĵ���
            JPanel p1 = new JPanel();
            JPanel p2 = new JPanel();
            JPanel p3 = new JPanel();



            //��������
            p1.add(l1);
            p1.add(t1);
            p2.add(l2);
            p2.add(t2);
            p3.add(b1);
            p3.add(b2);

            //�������������в����ú�����������λ��
            add(p1,"North");
            add(p2,"Center");
            add(p3,"South");
            setBounds(300,300,800,500);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();//��ȡ����ϵ��ַ���
            //����ύ��ť
            if (str.equals("�ύ")) {
                String psw=String.valueOf(this.t2.getPassword());
                char[] chars=psw.toCharArray();//ת�����ַ�����
                for(Character ch:chars){
                    if(!Character.isDigit(ch)){//isDigit(ch)�Ǽ���Ƿ�Ϊ����������1��9
                        JOptionPane.showMessageDialog(null,"�û�����ֻ��0��9");
                        //�µĽ���
                        return;
                    }
                }
                //�ж��û������Ƿ���ȷ
                if(this.t1.getText().equals("admin")&& psw.equals("123456")){
                   final JFrame frame=new JFrame();
                    frame.add(new JLabel("��ϲ�㣬��¼�ɹ���"));
                    JButton b3 =new JButton("����ϵͳ");

                    //����
                    jPanel = createBgImgJPanel(0,0,800,500,"./imgs/d.jpg");
                    JPanel p1=new JPanel();
                    frame.add(jPanel);
                    p1.add(b3);
                    frame.add(p1);

                    //������
                    b3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                Manager_MainMenu m=new Manager_MainMenu();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                   // JPanel p1=new JPanel();
                   // p1.add(b3);
                   // frame.add(p1);

                    //�������
                    frame.setVisible(true);
                    frame.setBounds(300,300,800,500);
                    //frame.pack();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                }else{
                    JOptionPane.showMessageDialog(null,"�û������벻��ȷ");
                }
            }else if(str.equals("����")){
                this.t1.setText("");
                this.t2.setText("");
                this.t1.setFocusable(true);

            }





        }


        //��������ͼƬ����           x������ߵľ��� y:���ұߵľ��� imgSrc������ͼƬ��ַ
        public static JPanel createBgImgJPanel(int x,int y,int width,int height,String imgSec){
            JPanel jPanel=new JPanel(null);
            jPanel.setBounds(x,y,width,height);
            jPanel.setOpaque(false);//���ò�͸��

            //��labelװ����ͼ����jpaenl���棬�ٰ�jpanel���ص�ϵͳ
            //�����ڴ���ʱ��ֻ����Ϊ�βΣ�Ҫͨ��returnȥ�ı�ʵ��
            ImageIcon imageIcon=new ImageIcon(imgSec);
            JLabel label=new JLabel(imageIcon);
            label.setSize(width,height);
            jPanel.add(label,-1);//����

            return jPanel;
        }






        public static void main(String[] args) {
            //������������
            LoginFrame r=new LoginFrame();
        }
    }

}
//�����ͺ����ĵ��ò��ô�������
//���̳�jframe�Ķ���psvm�ں͹��������治�ô���frame