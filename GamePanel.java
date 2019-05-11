import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    Player player;
    Background background;


    public GamePanel() {
        this.player = new Player();
        this.player.position.set(200, 500);
        this.player.position = new Vector2D(175, 500);
        this.background = new Background();
        this.background.position.set(0, 600-3109);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(Color.YELLOW);
//        g.drawRect(100, 100, 200, 200);
//        g.fillRect(400, 100, 200, 200);
        this.player.render(g);
        this.background.render(g);

//        for (PlayerBullet bullet: Player.playerBullets) {
//            bullet.render(g);
//        }
        g.drawImage(this.background.image, (int)this.background.position.x, (int)this.background.position.y, null);
        g.drawImage(this.player.image, (int)this.player.position.x, (int)this.player.position.y, null);

    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000 / 60) {
//                System.out.println(currentTime - lastTime);
                //run logic
                this.runAll();
                //render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
    public void runAll() {
        //player run
       this.player.run();
        //background run
       this.background.run();

        //bullet run
//        for (PlayerBullet bullet: Player.playerBullets) {
//            bullet.run();
//        }
//

    }
}
