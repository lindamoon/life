package top.lixb.libsrc.bean;

import java.util.List;

public class TextJokeBean {

    /**
     * showapi_res_error :
     * showapi_res_code : 0
     * showapi_res_body : {"allNum":9383,"contentlist":[{"ct":"2018-05-09 14:30:03.203","title":"和妹子打车被司机黑了...","type":1,"text":"和妹子打车被司机黑了，多要两倍钱。 \r\n我刚想和司机理论一下，妹子先把钱给了,\r\n下车之后我说：为什么不和司机讲清楚啊？多亏啊！\r\n妹子说：我那20是假钱，老娘等这一天等了好久了。。。 "},{"ct":"2018-05-09 14:30:03.203","title":"昨天晚上跟同事俩人一...","type":1,"text":"昨天晚上跟同事俩人一起去公共浴室洗澡，\r\n我趁他在洗头睁不开眼的时候拿着护发素走到了他身后死命对他的屁股挤，\r\n白色的乳液喷了他一屁股都是，他杀猪般地叫唤：\u201c卧槽，你搞什么？\u201d\r\n 我立即将护发素放好，握着丁丁摆出一副迷茫的表情站在他身后等他回头。"}],"ret_code":0,"maxResult":2,"allPages":4692,"currentPage":1}
     */

    public String showapi_res_error;
    public int showapi_res_code;
    public ShowapiResBodyBean showapi_res_body;

    public static class ShowapiResBodyBean {
        /**
         * allNum : 9383
         * contentlist : [{"ct":"2018-05-09 14:30:03.203","title":"和妹子打车被司机黑了...","type":1,"text":"和妹子打车被司机黑了，多要两倍钱。 \r\n我刚想和司机理论一下，妹子先把钱给了,\r\n下车之后我说：为什么不和司机讲清楚啊？多亏啊！\r\n妹子说：我那20是假钱，老娘等这一天等了好久了。。。 "},{"ct":"2018-05-09 14:30:03.203","title":"昨天晚上跟同事俩人一...","type":1,"text":"昨天晚上跟同事俩人一起去公共浴室洗澡，\r\n我趁他在洗头睁不开眼的时候拿着护发素走到了他身后死命对他的屁股挤，\r\n白色的乳液喷了他一屁股都是，他杀猪般地叫唤：\u201c卧槽，你搞什么？\u201d\r\n 我立即将护发素放好，握着丁丁摆出一副迷茫的表情站在他身后等他回头。"}]
         * ret_code : 0
         * maxResult : 2
         * allPages : 4692
         * currentPage : 1
         */

        public int allNum;
        public int ret_code;
        public int maxResult;
        public int allPages;
        public int currentPage;
        public List<ContentlistBean> contentlist;

        public static class ContentlistBean {
            /**
             * ct : 2018-05-09 14:30:03.203
             * title : 和妹子打车被司机黑了...
             * type : 1
             * text : 和妹子打车被司机黑了，多要两倍钱。
             我刚想和司机理论一下，妹子先把钱给了,
             下车之后我说：为什么不和司机讲清楚啊？多亏啊！
             妹子说：我那20是假钱，老娘等这一天等了好久了。。。
             */

            public String ct;
            public String title;
            public int type;
            public String text;
        }
    }
}
