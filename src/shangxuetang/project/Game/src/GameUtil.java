import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 游戏的工具类
 */
public class GameUtil {
    /**
     * 构造器私有，阻止实例的创建
     */
    private GameUtil() {
    }

    public static Image getImage(String path) {
        BufferedImage bi = null;
        URL u = GameUtil.class.getClassLoader().getResource(path);
        try {
            if (u != null) {
                bi = ImageIO.read(u);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bi;
    }

    public static void main(String[] args) {
        Image image = GameUtil.getImage("resource/plane.png");
        System.out.println(image);
    }
}
