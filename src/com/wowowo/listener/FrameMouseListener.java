package com.wowowo.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.wowowo.view.BaseFrame;

public class FrameMouseListener implements KeyListener {

    public BaseFrame baseFrame;
    //@Override
    //public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        //this.baseFrame.myPanel.player.x = e.getX() - this.baseFrame.myPanel.player.width/2;
        //this.baseFrame.myPanel.player.y = e.getY() - this.baseFrame.myPanel.player.height/2;

    //}

    //@Override
    //public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    //}

    //@Override
    //public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    //}

    //@Override
    //public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

   // }

    //@Override
    //public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //��дkeyPressed����
    @Override
    public void keyPressed(KeyEvent e) {
        //��ȡ���̰��µļ�
        int keycoude=e.getKeyCode();
        //������µ����Ϸɻ���y������25����λ
        if(keycoude==KeyEvent.VK_UP){
            this.baseFrame.myPanel.player.y=this.baseFrame.myPanel.player.y-25;
        }
        //������µ����Ϸɻ���y������25����λ
        if(keycoude==KeyEvent.VK_DOWN){
            this.baseFrame.myPanel.player.y=this.baseFrame.myPanel.player.y+25;
        }
        //������µ�����ɻ���x������25����λ
        if(keycoude==KeyEvent.VK_LEFT){
            this.baseFrame.myPanel.player.x=this.baseFrame.myPanel.player.x-25;
        }
        //������µ����Ϸɻ���x������25����λ
        if(keycoude==KeyEvent.VK_RIGHT){
            this.baseFrame.myPanel.player.x=this.baseFrame.myPanel.player.x+25;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


