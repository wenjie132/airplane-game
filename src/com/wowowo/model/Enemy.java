package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Enemy {
    //ʹ��MyPanel��ԭ���ǣ�Ҫ����MyPanel�е�timer
    public MyPanel myPanel;

    //width��height�ǵл������߶�
    public int width;
    public int height;

    //x��y�ǵл�������
    public int x;
    public int y;

    public Image image;

    //�л���ըЧ�������ڷŵ�������
    public Image[] dieImages = new Image[] {
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down1.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down2.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down3.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down4.png"),
    };

    public int hp; //�л�������ֵ

    public Enemy(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

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
                    myPanel.number+=10;
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

    //�Ƴ��������߷ɳ�����ĵл�
    public void killed() {
        this.myPanel.enemys.remove(this);

    }

    //�л����ڱ�����״̬��������ֵ����
    public void underAttack() {
        if(hp>0) {
            hp--;
        }
    }



}

