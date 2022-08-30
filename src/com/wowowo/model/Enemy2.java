package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Enemy2 extends Enemy{

    public Enemy2(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub

        this.width = 69;
        this.height = 99;
        this.hp = 5;

        this.x = (int) (Math.random()*(BaseFrame.frameWidth - this.width));
        this.y = - this.height;

        this.image = Toolkit.getDefaultToolkit().getImage("src/images/enemy2.png");

    }

    //�л���ըЧ�������ڷŵ�������
    public Image[] dieImages = new Image[] {
            Toolkit.getDefaultToolkit().getImage("src/images/enemy2_down1.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy2_down2.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy2_down3.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy2_down4.png"),
    };

    //��ŵ�ǰͼƬ���±�
    public int imageIndex = 0;

    //���л�
    public void drawSelf(Graphics g) {
        //�жϵл��Ƿ񱻻���
        if(hp>0) {
            g.drawImage(this.image,x,y,width,height,null);
        }
        else {
            //������
            g.drawImage(this.dieImages[imageIndex],x,y,width,height,null);

            //ÿ��10�����л�һ��ͼƬ
            if(this.myPanel.timer%50==0) {
                imageIndex++;
                if(imageIndex>=this.dieImages.length) {
                    //�л�����
                    killed();
                    myPanel.number+=20;
                }

            }
        }

        //�л������ƶ�,����л����������
        if(this.myPanel.timer%35==0) {
            y=y+10;
            if(y>=BaseFrame.frameHeight) {
                killed();
            }
        }
    }

}
