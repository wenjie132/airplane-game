package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Player {

    //ʹ��MyPanel��ԭ���ǣ�Ҫ����MyPanel�е�timer
    public MyPanel myPanel;

    //width��height�����Ƿɻ������߶�
    public int width = 102;
    public int height = 126;

    //x��y�����Ƿɻ������꣨���Ͻǣ�
    public int x;
    public int y;

    //�����е����Ƿɻ� ͼƬ����ŵ�������
    public Image[] images = new Image[] {
            Toolkit.getDefaultToolkit().getImage("src/images/me1.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/me2.png")
    };

    //��ŵ�ǰͼƬ���±�
    public int imageIndex = 0;

    public Player(MyPanel myPanel) {
        this.myPanel = myPanel;
        this.x = (BaseFrame.frameWidth - this.width)/2;
        this.y = BaseFrame.frameHeight - this.height*2;
    }

    //���Ʒɻ�
    public void drawSelf(Graphics g) {
        g.drawImage(this.images[imageIndex],x,y,width,height,null);

        //ÿ��50�����л�һ��ͼƬ
        if(this.myPanel.timer%50==0) {
            imageIndex++;
            //ͼƬ���������һ����ͼƬ�±��ٴ���0��ʼ
            if(this.imageIndex==this.images.length) {
                this.imageIndex = 0;
            }
        }
    }
}







