package com.wowowo.thread;

import com.wowowo.view.MyPanel;

public class DrawableTherad extends Thread{
    public MyPanel myPanel;
    public DrawableTherad(MyPanel myPanel) {
        this.myPanel=myPanel;

    }
    public void run() {
        while(true) {
            //�ػ棬����� paintComponent
            this.myPanel.repaint();

            try {
                this.currentThread().sleep(1);
            } catch (InterruptedException e) {
                // TODO �Զ����ɵ� catch ��
                e.printStackTrace();
            }
        }
    }


}







