package top.lixb.module_login;

/**
 * 登录相关
 */
public class LoginHelper {


    private static boolean isLogin;


    public static boolean isIsLogin() {
        return isLogin;
    }

    public static void setIsLogin(boolean isLogin) {
        LoginHelper.isLogin = isLogin;
    }


}