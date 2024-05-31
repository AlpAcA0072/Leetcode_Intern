package shangxuetang.video.old2019.Multithreading;

/**
 * 静态代理
 * <p>
 * 接口：
 * <p>
 * 1. 真实角色
 * <p>
 * 2. 代理角色
 */
public class p201_StaticProxy {
    public static void main(String[] args) {
        // 代理角色(真实角色) --> 执行方法
        // 只需要关注真实角色
        // new Thread(线程对象).start();
        new WeddingCompany(new You()).happy();
    }
}

interface Marry {
    void happy();
}

/**
 * 代理角色
 */
class WeddingCompany implements Marry {
    private final Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    private void before() {
        System.out.println("布置...........");
    }

    private void after() {
        System.out.println("结束！！！！！！！！！！");
    }

    @Override
    public void happy() {
        before();
        target.happy();
        after();
    }
}

/**
 * 真实角色
 */
class You implements Marry {

    @Override
    public void happy() {
        System.out.println("开心～～～～～～～～");
    }
}