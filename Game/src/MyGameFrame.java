import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;

/**
 * 飞机游戏主窗口
 */
public class MyGameFrame extends Frame {
//    boolean left, right, up, down;

    Plane plane = new Plane(GameUtil.getImage("resource/plane.png"), 100, 100, 10);
    Image bg = GameUtil.getImage("resource/bg.jpg");
    Shell[] shells = new Shell[100];
    GameObject background = new GameObject(bg, 0, 0, 0, 500, 500);
    Explode explode;
    static boolean crash = false;
    Time start = new Time(System.currentTimeMillis());
    Time end;
    long period;


    private int count = 0;

    /**
     * 自动被调用，g相当于一根画笔。
     *
     * @param g the specified Graphics window
     */
    @Override
    public void paint(Graphics g) {
        System.out.println("绘制次数：" + count++);
//        Color oldColor = g.getColor();
//        g.setColor(Color.BLUE);
//        Font oldFont = g.getFont();
//        g.drawLine(100, 100, 300, 300);
//        g.drawRect(100, 100, 300, 300);
//        g.fillRect(100, 100, 40, 40);
//        g.setFont(new Font("Default", Font.BOLD, 25));
//        g.drawString("This is a String", 200, 200);
//        g.setFont(oldFont);
//        g.setColor(oldColor);


//        g.drawImage(bg, 0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT, null);
//        g.drawImage(plane, 100, 100, 22, 33, null);
//        if (left) {
//            plane.x -= plane.speed;
//        }
//        if (right) {
//            plane.x += plane.speed;
//        }
//        if (up) {
//            plane.y -= plane.speed;
//        }
//        if (down) {
//            plane.y += plane.speed;
//        }
        // 绘制背景
        background.drawMyself(g);
        // 绘制时间
        drawTime(g);
        // 绘制飞机
        plane.drawMyself(g);

        // 绘制炮弹
        for (Shell shell : shells) {
            shell.drawMyself(g);
            // 碰撞检测
            if (!crash) {
                crash = shell.getRec().intersects(plane.getRec());
            }
        }

        if (crash) {
            drawCollision(g);
        }
    }

    public void drawCollision(Graphics g) {
        Color oldColor = g.getColor();
        Font oldFont = g.getFont();

        System.out.println("碰撞");
        plane.live = false;
        if (explode == null) {
            explode = new Explode(plane.x, plane.y);
        }
        explode.drawMySelf(g);

        g.setColor(oldColor);
        g.setFont(oldFont);
    }

    public void drawTime(Graphics g) {
        Color oldColor = g.getColor();
        Font oldFont = g.getFont();
        g.setColor(Color.MAGENTA);
        if (plane.live) {
            period = (System.currentTimeMillis() - start.getTime()) / 1000L;
            g.drawString("坚持：" + period + "秒", 30, 50);
        } else {
            if (end == null) {
                end = new Time(System.currentTimeMillis());
            }
            period = (end.getTime() - start.getTime()) / 1000L;
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 30));
            g.drawString("最终时间：" + period + "秒", 200, 200);
        }

        g.setColor(oldColor);
        g.setFont(oldFont);
    }

    /**
     * 初始化窗口
     */
    public void launchFrame() {
        // 启动重绘窗口的线程
        new PaintThread().start();
        this.setTitle("飞机游戏");
        this.setVisible(true);
        this.setSize(500, 500);
        // 设置窗口在屏幕的坐标，左上角为0，0。
        // 横向为x轴，向右，纵向为y轴，向下。
        this.setLocation(300, 300);

        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyMonitor());


    }

    /**
     * 窗口重绘线程内部类
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 内部类，实现键盘的监听处理
     */
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按下 + " + e.getKeyCode());
//            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                left = true;
//            }
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("松开 + " + e.getKeyCode());
            super.keyReleased(e);
//            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                left = false;
//            }
            plane.deleteDirection(e);
        }
    }

    private Image offScrennImage = null;

    /**
     * 双缓冲技术解决屏幕闪烁问题
     *
     * @param g the specified Graphics window
     */
    public void update(Graphics g) {
        if (offScrennImage == null) {
            offScrennImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }

        Graphics gOff = offScrennImage.getGraphics();
        paint(gOff);
        g.drawImage(offScrennImage, 0, 0, null);
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
