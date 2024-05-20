import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * 爆炸
 */
public class Explode {
    double x, y;
    static int width = 71, height = 100;
    static Image[] images;
    int count;

    public Explode() {
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static {
        images = new Image[16];
        for (int i = 0; i < images.length; i++) {
            images[i] = GameUtil.getImage("resource/e" + (i + 1) + ".gif");
            images[i].getWidth(null); // 解决懒加载的问题
        }
    }

    public void drawMySelf(Graphics g) {
        if (count < images.length) {
            g.drawImage(images[count], (int) x, (int) y, null);
//            g.drawImage(images[count], (int) x, (int) y, width, height, null);
            count++;
        }
    }

}
