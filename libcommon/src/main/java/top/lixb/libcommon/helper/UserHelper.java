package top.lixb.libcommon.helper;

public class UserHelper {

    /**
     * 用户是否登录
     */
    private static boolean isLogin;

    public static boolean isLogin() {
        return isLogin;
    }

    public static void setLogin(boolean isLogin) {
        UserHelper.isLogin = isLogin;
    }
}
