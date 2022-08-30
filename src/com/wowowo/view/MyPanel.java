package com.wowowo.view;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.wowowo.model.Bullet;
import com.wowowo.model.Enemy;
import com.wowowo.model.Player;
import com.wowowo.thread.DrawableTherad;

public class MyPanel extends JPanel{
    public int state=0;
    Image bg=Toolkit.getDefaultToolkit().getImage("images/pause_nor.png");

    //��ŵ��Ǳ���ͼƬ
    public Image bgImage;
    public int timer=0;
    public int top=0;

    public DrawableTherad drawableTherad;


    //����һ���ɻ����Ƕ���
    public Player player;

    //��������ӵ�
    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    //������еĵл�
    public ArrayList<Enemy> enemys = new ArrayList<Enemy>();

    //������еĵл�����
    public ArrayList<Class> enemyType = new ArrayList<Class>();
    private Object Font;

    public MyPanel()
    {
        this.bgImage=Toolkit.getDefaultToolkit().getImage("src/images/background.png");

        //�����ڴ������������Ƿɻ�Ҳ������
        this.player = new Player(this);

        //�����߳� �ػ�Panel
        this.drawableTherad=new DrawableTherad(this);

        //�����߳�
        this.drawableTherad.start();




    }
    //����
    public int number=0;




    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);



        //���Ʊ���ͼ
        g.drawImage(this.bgImage, 0, top-this.bgImage.getHeight(this), this.bgImage.getWidth(this),this.bgImage.getHeight(this), null);
        g.drawImage(this.bgImage, 0, top, this.bgImage.getWidth(this),this.bgImage.getHeight(this),null);
        timer++;

        if(timer==10000)
            timer=0;

        if(timer%10==0) {
            top++;

            if(top>this.bgImage.getHeight(this))
                top=0;
        }

        //����
        g.setColor(Color.red);
        g.setFont(new Font("",Color.red.getRed(),30));
        g.drawString("��ǰ�÷֣�"+number,10,30);

        //�������Ƿɻ�
        this.player.drawSelf(g);

        //�����ӵ�
        if(timer%100==0) {
            //�����ӵ�
            Bullet bullet = new Bullet(this);
            //��������
            bullet.x = this.player.x+this.player.width/2 - bullet.width/2;
            bullet.y = this.player.y;

            //����arrayList��
            this.bullets.add(bullet);
        }

        //�������е��ӵ�
        for(int i=0; i<bullets.size(); i++) {
            this.bullets.get(i).drawSelf(g);
        }

        //���Ƶл�
        if(timer%800==0) {
            if(this.enemyType.size()>0) {
                //�������һ�����͵ĵл�
                int index = (int)(Math.random()*this.enemyType.size());
                Enemy enemy = null;
                try {
                    enemy = (Enemy)(this.enemyType.get(index).getConstructors()[0].newInstance(new Object[] {this}));
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                //�������õĵл�����������
                this.enemys.add(enemy);
            }
        }

        //�����еĵл�������
        for(int i=0;i<this.enemys.size();i++) {
            this.enemys.get(i).drawSelf(g);
        }

    }

}




