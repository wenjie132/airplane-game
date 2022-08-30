package com.wowowo.model;

import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Enemy1 extends Enemy{

    public Enemy1(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub

        this.width = 57;
        this.height = 43;
        this.hp = 3;

        this.x = (int) (Math.random()*(BaseFrame.frameWidth - this.width));
        this.y = - this.height;

        this.image = Toolkit.getDefaultToolkit().getImage("src/images/enemy1.png");
    }

}

