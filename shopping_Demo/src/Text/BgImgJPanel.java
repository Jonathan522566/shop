package Text;

import javax.swing.*;

public class BgImgJPanel {

    //创建背景图片方法           x：与左边的距离 y:与右边的距离 imgSrc：背景图片地址
    public static JPanel createBgImgJPanel(int x,int y,int width,int height,String imgSec){
        JPanel jPanel=new JPanel(null);
        jPanel.setBounds(x,y,width,height);
        jPanel.setOpaque(true);//设置不透明

        //用label装背景图放入jpaenl里面，再把jpanel返回到系统
        //数据在传入时，只是作为形参，要通过return去改变实参
        ImageIcon imageIcon=new ImageIcon(imgSec);
        JLabel label=new JLabel(imageIcon);
        label.setSize(width,height);
        jPanel.add(label,-1);//索引
        return jPanel;
    }

    public static void main(String[] args) {
        BgImgJPanel b=new BgImgJPanel();
        b.createBgImgJPanel(500,300,300,300,"c.jpg");
    }
}
