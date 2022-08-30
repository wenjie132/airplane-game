package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Enemy3 extends Enemy{

    public Enemy3(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub

        this.width = 169;
        this.height = 258;
        this.hp = 8;

        this.x = (int) (Math.random()*(BaseFrame.frameWidth - this.width));
        this.y = - this.height;

        this.image = Toolkit.getDefaultToolkit().getImage("src/images/enemy3_n1.png");

    }

    //�л���ըЧ�������ڷŵ�������
    public Image[] dieImages = new Image[] {
            Toolkit.getDefaultToolkit().getImage("src/images/enemy3_down1.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy3_down2.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy3_down3.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy3_down4.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy3_down5.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy3_down6.png"),
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

            //ÿ��50�����л�һ��ͼƬ
            if(this.myPanel.timer%50==0) {
                imageIndex++;
                if(imageIndex>=this.dieImages.length) {
                    //�л�����
                    killed();
                    myPanel.number+=30;
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
