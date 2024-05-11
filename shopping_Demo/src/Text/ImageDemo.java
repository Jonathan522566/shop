
package Text;
//背景图版本
import javax.swing.*;
import java.awt.*;

public class ImageDemo {
    public static void main(String[] args) {
        JFrame jf=new JFrame();

        //1.把图片放在便签里，并放在最低层
        ImageIcon bg=new ImageIcon("R-C.jpg");
        JLabel label=new JLabel(bg);
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //2.把窗口设置为透明，及流动布局
        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(new FlowLayout());
        //3.把组件放到窗口
        JButton btn=new JButton("测试按钮");
        pan.add(btn);
        jf.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true) ;
    }

    }





