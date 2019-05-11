import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    Vector2D position;
    ArrayList<PlayerBullet> playerBullet;

    public Player(){
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position = new Vector2D(200,500);
        playerBullet = new ArrayList<>();

    }

    public void render(Graphics g){
        g.drawImage(image,(int) position.x,(int) position.y,null);
        for(int i = 0;i<playerBullet.size();i++){
            PlayerBullet bullet = playerBullet.get(i);
            bullet.render(g);
        }
    }
    int count = 0;
    public void run(){
        if(KeyEventPress.isUpPress == true){
            position.y-=2;
        }
        if(KeyEventPress.isDownPress == true){
            position.y+=2;
        }
        if(KeyEventPress.isLeftPress == true){
            position.x-=2;
        }
        if(KeyEventPress.isRightPress== true){
            position.x+=2;
        }
        position.x = Mathx.clamp(position.x,0,384-32);
        position.y = Mathx.clamp(position.y,0,600-48);
        count ++;
        if(KeyEventPress.isFirePress && count >20){
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x,this.position.y);
            bullet.position2.set(this.position.x,this.position.y);
            bullet.position3.set(this.position.x,this.position.y);
            playerBullet.add(bullet);
            count =0;
        }
        for(int i =0;i<playerBullet.size();i++){
            PlayerBullet bullet = playerBullet.get(i);
            bullet.run();
        }

    }

}