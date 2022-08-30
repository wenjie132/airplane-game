package com.wowowo.view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JFrame;

import com.wowowo.listener.FrameMouseListener;
import com.wowowo.model.Enemy1;
import com.wowowo.model.Enemy2;
import com.wowowo.model.Enemy3;

public class BaseFrame extends JFrame{



    public static int frameWidth=480;
    public static int frameHeight=700;

    public MyPanel myPanel;

    //�������¼�
    public FrameMouseListener frameMouseListener;

    public void setTouchListener() {
        this.frameMouseListener=new FrameMouseListener();
        this.frameMouseListener.baseFrame = this;
        this.addKeyListener(this.frameMouseListener);
    }

    public void addEnemyType(Class c) {
        this.myPanel.enemyType.add(c);
    }

    public  BaseFrame()
    {

        super("�ɻ���ս");
        //�����Ļ�ֱ���
        Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();



        //���ô��ڴ�С��λ��
        setBounds((int) ((screenSize.getWidth()-frameWidth)/2),0,frameWidth,frameHeight);

        //���ò��ַ�ʽ
        setLayout(null);

        //����һ��MyPanel����
        this.myPanel=new MyPanel();

        //����MyPanel�����λ�úʹ�С
        this.myPanel.setBounds(0,0,frameWidth,frameHeight);

        //�������ӵ�������
        this.add(this.myPanel);

        //���ü�����
        setTouchListener();

        //��ӵл�����
        addEnemyType(Enemy1.class);
        addEnemyType(Enemy2.class);
        addEnemyType(Enemy3.class);

        //��ʾ����
        setVisible(true);

        //���ô��ڹر�
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        URL url=this.getClass().getResource("images/yinyue.wav");
        AudioClip ac= Applet.newAudioClip(url);
        ac.play();



                }
            }




