package top.lixb.libsrc.router;

public class RouterManager {
    private static RouterManager instance;

    private RouterManager() {

    }

    public static RouterManager getInstance() {
        synchronized (RouterManager.class) {
            if (instance==null) {
                instance = new RouterManager();
            }
        }
        return instance;
    }


}
