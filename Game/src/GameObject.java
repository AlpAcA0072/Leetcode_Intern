import java.awt.*;

/**
 * 游戏物体的根类
 */
public class GameObject {
    Image image;
    double x, y;
    int speed;
    int width, height;

    GameObject() {

    }

    public GameObject(Image image, double x, double y, int speed) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public GameObject(Image image, double x, double y, int speed, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public void drawMyself(Graphics g) {
        g.drawImage(image, (int) x, (int) y, width, height, null);
    }

    /**
     * @return 返回物体对应的矩形
     */
    public Rectangle getRec() {
        return new Rectangle((int) x, (int) y, width, height);
    }
}
