package top.lixb.libsrc.bean;

import android.databinding.Observable;

import java.util.List;

public class PicJokeBean{

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"allNum":2903,"allPages":146,"contentlist":[{"ct":"2015-07-30 01:10:29.995","img":"http://img5.hao123.com/data/3_2ec986ed8d235ebb3bd562ed5b782eb6_0","title":"起来！就不~~~","type":2}],"currentPage":1,"maxResult":20}
     */

    public int showapi_res_code;
    public String showapi_res_error;
    public ShowapiResBodyBean showapi_res_body;

    public static class ShowapiResBodyBean {
        /**
         * allNum : 2903
         * allPages : 146
         * contentlist : [{"ct":"2015-07-30 01:10:29.995","img":"http://img5.hao123.com/data/3_2ec986ed8d235ebb3bd562ed5b782eb6_0","title":"起来！就不~~~","type":2}]
         * currentPage : 1
         * maxResult : 20
         */

        public int allNum;
        public int allPages;
        public int currentPage;
        public int maxResult;
        public List<ContentlistBean> contentlist;

        public static class ContentlistBean {
            /**
             * ct : 2015-07-30 01:10:29.995
             * img : http://img5.hao123.com/data/3_2ec986ed8d235ebb3bd562ed5b782eb6_0
             * title : 起来！就不~~~
             * type : 2
             */

            public String ct;
            public String img;
            public String title;
            public int type;
        }
    }
}
