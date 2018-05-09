package top.lixb.libsrc.bean;

import java.util.List;

public class GifJokeBean {

    /**
     * showapi_res_error :
     * showapi_res_code : 0
     * showapi_res_body : {"allNum":242,"contentlist":[{"ct":"2018-03-28 15:30:09.844","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q50P3.gif","title":"搞笑gif第七百二十一期（共5图）","type":3},{"ct":"2018-03-28 15:30:09.840","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q50Z8.gif","title":"搞笑gif第七百二十二期（共5图）","type":3},{"ct":"2018-03-28 15:30:09.833","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q51013.gif","title":"搞笑gif第七百二十三期（共5图）","type":3},{"ct":"2018-03-28 15:30:09.832","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q51202.gif","title":"搞笑gif第七百二十四期（共5图）","type":3},{"ct":"2018-03-28 15:30:09.775","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q51403.gif","title":"搞笑gif第七百二十五期（共5图）","type":3},{"ct":"2018-03-28 13:00:05.409","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23U1.gif","title":"邪恶动态图第464期橹管专用动态XXO0（共5图）","type":3},{"ct":"2018-03-28 13:00:05.399","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23542.gif","title":"邪恶动态图第461期橹管专用动态XXO0（共5图）","type":3},{"ct":"2018-03-28 13:00:05.399","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23I6.gif","title":"邪恶动态图第462期女人BB被黑人大棒插12p（共5图）","type":3},{"ct":"2018-03-28 13:00:05.399","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23Q7.gif","title":"邪恶动态图第463期橹管专用动态XXO0（共5图）","type":3},{"ct":"2018-03-28 13:00:05.398","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23925.gif","title":"邪恶动态图第465期橹管专用动态XXO0（共5图）","type":3}],"ret_code":0,"maxResult":10,"allPages":25,"currentPage":1}
     */

    public String showapi_res_error;
    public int showapi_res_code;
    public ShowapiResBodyBean showapi_res_body;

    public static class ShowapiResBodyBean {
        /**
         * allNum : 242
         * contentlist : [{"ct":"2018-03-28 15:30:09.844","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q50P3.gif","title":"搞笑gif第七百二十一期（共5图）","type":3},{"ct":"2018-03-28 15:30:09.840","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q50Z8.gif","title":"搞笑gif第七百二十二期（共5图）","type":3},{"ct":"2018-03-28 15:30:09.833","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q51013.gif","title":"搞笑gif第七百二十三期（共5图）","type":3},{"ct":"2018-03-28 15:30:09.832","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q51202.gif","title":"搞笑gif第七百二十四期（共5图）","type":3},{"ct":"2018-03-28 15:30:09.775","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q51403.gif","title":"搞笑gif第七百二十五期（共5图）","type":3},{"ct":"2018-03-28 13:00:05.409","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23U1.gif","title":"邪恶动态图第464期橹管专用动态XXO0（共5图）","type":3},{"ct":"2018-03-28 13:00:05.399","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23542.gif","title":"邪恶动态图第461期橹管专用动态XXO0（共5图）","type":3},{"ct":"2018-03-28 13:00:05.399","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23I6.gif","title":"邪恶动态图第462期女人BB被黑人大棒插12p（共5图）","type":3},{"ct":"2018-03-28 13:00:05.399","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23Q7.gif","title":"邪恶动态图第463期橹管专用动态XXO0（共5图）","type":3},{"ct":"2018-03-28 13:00:05.398","img":"http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q23925.gif","title":"邪恶动态图第465期橹管专用动态XXO0（共5图）","type":3}]
         * ret_code : 0
         * maxResult : 10
         * allPages : 25
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
             * ct : 2018-03-28 15:30:09.844
             * img : http://www.zbjuran.com/uploads/allimg/180328/2-1P32Q50P3.gif
             * title : 搞笑gif第七百二十一期（共5图）
             * type : 3
             */

            public String ct;
            public String img;
            public String title;
            public int type;
        }
    }
}

