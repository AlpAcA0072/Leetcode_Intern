import java.awt.*;

/**
 * 炮弹类
 */
public class Shell extends GameObject {
    // 飞行角度
    double degree;

    public Shell() {
        x = 200;
        y = 200;
        degree = Math.random() * Math.PI * 2;
        width = 4;
        height = 4;
        speed = 3;
    }

    public Shell(Image image, double x, double y, int speed, int width, int height, double degree) {
        super(image, x, y, speed, width, height);
        this.degree = degree;
    }

    @Override
    public void drawMyself(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.fillOval((int) x, (int) y, width, height);
        g.setColor(c);
        // 炮弹移动方向
//        x += speed;
//        y += speed;
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);
        // 碰到边界改变方向
        // 上下取反，左右取 PI - degree
        if (y > Constant.GAME_HEIGHT - this.height || y < 30 /* 30是标题栏宽度 */) {
            degree = -degree;
        } else if (x < 0 || x >= Constant.GAME_WIDTH - this.width) {
            degree = Math.PI - degree;
        }
    }
}
