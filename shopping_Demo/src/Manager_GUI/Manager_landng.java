package Manager_GUI;

import Manager_MainMene.Manager_MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Manager_landng {
    //用户密码的检测：
    public static class LoginFrame extends JFrame implements ActionListener {
        //组件的定义
        JLabel l1;
        JLabel l2;
        JTextField t1;
        JPasswordField t2;
        JButton b1;
        JButton b2;
         JPanel jPanel;

        LoginFrame() {
           //界面主题
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


            //组件的创建
            t1= new JTextField(15);
            t2= new JPasswordField(15);
            b1=new JButton("提交");
            b2=new JButton("从设");
            l1=new JLabel("用户名;");
            l2=new JLabel("密码：");
//this.setSize(300,300);

            //添加监听器
            b1.addActionListener(this);
            b2.addActionListener(this);
            t1.addActionListener(this);
            t2.addActionListener(this);

            //框架设计
            //setVisible(true);
            setTitle("管理员登录窗口");
            TextArea t = new TextArea(3, 1);

            //中间容器的创建
            JPanel p1 = new JPanel();
            JPanel p2 = new JPanel();
            JPanel p3 = new JPanel();



            //放入容器
            p1.add(l1);
            p1.add(t1);
            p2.add(l2);
            p2.add(t2);
            p3.add(b1);
            p3.add(b2);

            //将容器放入框架中并设置好容器所处的位置
            add(p1,"North");
            add(p2,"Center");
            add(p3,"South");
            setBounds(300,300,800,500);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();//获取组件上的字符串
            //点击提交按钮
            if (str.equals("提交")) {
                String psw=String.valueOf(this.t2.getPassword());
                char[] chars=psw.toCharArray();//转换成字符数组
                for(Character ch:chars){
                    if(!Character.isDigit(ch)){//isDigit(ch)是检查是否为啊拉伯数字1到9
                        JOptionPane.showMessageDialog(null,"用户密码只有0到9");
                        //新的界面
                        return;
                    }
                }
                //判断用户密码是否正确
                if(this.t1.getText().equals("admin")&& psw.equals("123456")){
                   final JFrame frame=new JFrame();
                    frame.add(new JLabel("恭喜你，登录成功！"));
                    JButton b3 =new JButton("进入系统");

                    //背景
                    jPanel = createBgImgJPanel(0,0,800,500,"./imgs/d.jpg");
                    JPanel p1=new JPanel();
                    frame.add(jPanel);
                    p1.add(b3);
                    frame.add(p1);

                    //监听器
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

                    //界面设计
                    frame.setVisible(true);
                    frame.setBounds(300,300,800,500);
                    //frame.pack();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                }else{
                    JOptionPane.showMessageDialog(null,"用户名密码不正确");
                }
            }else if(str.equals("从设")){
                this.t1.setText("");
                this.t2.setText("");
                this.t1.setFocusable(true);

            }





        }


        //创建背景图片方法           x：与左边的距离 y:与右边的距离 imgSrc：背景图片地址
        public static JPanel createBgImgJPanel(int x,int y,int width,int height,String imgSec){
            JPanel jPanel=new JPanel(null);
            jPanel.setBounds(x,y,width,height);
            jPanel.setOpaque(false);//设置不透明

            //用label装背景图放入jpaenl里面，再把jpanel返回到系统
            //数据在传入时，只是作为形参，要通过return去改变实参
            ImageIcon imageIcon=new ImageIcon(imgSec);
            JLabel label=new JLabel(imageIcon);
            label.setSize(width,height);
            jPanel.add(label,-1);//索引

            return jPanel;
        }






        public static void main(String[] args) {
            //创建对象并运行
            LoginFrame r=new LoginFrame();
        }
    }

}
//函数和函数的调用不用创建对象
//若继承jframe的对象psvm内和构造器里面不用创建frame