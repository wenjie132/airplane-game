package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Bullet {
    //ʹ��MyPanel��ԭ���ǣ�Ҫ����MyPanel�е�timer
    public MyPanel myPanel;

    //width��height���ӵ������߶�
    public int width = 5;
    public int height = 11;

    //x��y���ӵ�������
    public int x;
    public int y;


    //�����е��ӵ� ͼƬ����ŵ�������
    public Image[] images = new Image[] {
            Toolkit.getDefaultToolkit().getImage("src/images/bullet1.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/bullet2.png")
    };

    //��ŵ�ǰͼƬ���±�
    public int imageIndex = 0;

    public Bullet(MyPanel myPanel) {
        this.myPanel = myPanel;
    }


    //���ӵ�
    public void drawSelf(Graphics g) {
        g.drawImage(this.images[imageIndex],x,y,width,height,null);

        //ÿ��50�����л�һ��ͼƬ
        if(this.myPanel.timer%50==0) {
            imageIndex++;
            //ͼƬ���������һ����ͼƬ�±��ٴ���0��ʼ
            if(this.imageIndex==this.images.length) {
                this.imageIndex = 0;
            }

            //�ӵ������������ƶ�
            y=y-15;

            //����ӵ��ɳ����ڣ����Ƴ��ӵ�
            if(y<0) {
                //�Ƴ��ӵ�
                this.myPanel.bullets.remove(this);

            }

        }
        //�ж��ӵ��Ƿ���ел�
        for(int i=0; i<this.myPanel.enemys.size(); i++) {
            Enemy e = this.myPanel.enemys.get(i);

            //�ж�
            if((this.x>=e.x && this.x<=e.x+e.width) && (this.y>=e.y && this.y<=e.y+e.height)) {
                //�Ƴ����ӵ�
                this.myPanel.bullets.remove(this);
                //��ȥ�л���hpֵ
                e.underAttack();
            }
        }
    }
}



