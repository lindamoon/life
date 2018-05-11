package top.lixb.libsrc.bean;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

import top.lixb.libsrc.router.RouteTable;

public class ToutiaoNewsBean {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"75771be99c4ac5607391b991e1062232","title":"珠海高端会展酒店组团亮相国内行业大会，开拓实干发展高质量会展经济","date":"2018-05-10 13:21","category":"头条","author_name":"南方网","url":"http://mini.eastday.com/mobile/180510132145121.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_1_mwpm_03200403.jpg"},{"uniquekey":"5946aaf6e090d577b41c31a562cb9104","title":"广州人说台湾发展水平低 台网友:自家短处要认清","date":"2018-05-10 13:39","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180510133916617.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180510/20180510133916_bfe570c47949f676222b45cc04943b27_1_mwpm_03200403.jpg"},{"uniquekey":"36c41dd6328f7d5cbc158a81c2a518ab","title":"普京在阅兵式上这个反应 又帅了","date":"2018-05-10 13:30","category":"头条","author_name":"环球时报","url":"http://mini.eastday.com/mobile/180510133012124.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180510/20180510133012_b63916af7f9bf063b9f669ade20e142d_1_mwpm_03200403.jpg"},{"uniquekey":"b8db5714a82d688eb441fd141d6de4e6","title":"湖北历史上首次！500万重奖10位工匠","date":"2018-05-10 13:29","category":"头条","author_name":"光明网","url":"http://mini.eastday.com/mobile/180510132908986.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180510/20180510132908_c1ccd5c0c17f8e3aafbbb06129b019c6_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180510/20180510132908_c1ccd5c0c17f8e3aafbbb06129b019c6_2_mwpm_03200403.jpg"},{"uniquekey":"fd9b86016d98af1009555ecaa773c1e4","title":"独家述评 | 实践，以人民的名义","date":"2018-05-10 13:27","category":"头条","author_name":"新民网","url":"http://mini.eastday.com/mobile/180510132730590.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180510/20180510132730_db3e0298fab5a3b30b49e69129eccc78_1_mwpm_03200403.jpg"},{"uniquekey":"dbe09fc13b3bebe45b9ff79ac3815d28","title":"空姐打顺风车遇害 凶手仍在潜逃 滴滴公开道歉","date":"2018-05-10 13:20","category":"头条","author_name":"北京青年报","url":"http://mini.eastday.com/mobile/180510132037767.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180510/20180510132037_e5581b526ed3afa60ce5d914d45302df_1_mwpm_03200403.jpg"},{"uniquekey":"5fc4f2df22e6201f73e7ce1ad1ff3b6b","title":"女人为什么健身？让肉长到对的地方！","date":"2018-05-10 13:16","category":"头条","author_name":"猪猪评球","url":"http://mini.eastday.com/mobile/180510131619678.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180510/20180510_6c4bae0c7151553cf01f1002620ecffc_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20180510/20180510_0171db555650088e81dd81c67d0a2b49_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20180510/20180510_c161b3552613886faf0b78f5bb183c78_cover_mwpm_03200403.jpg"}]}
     */

    public String reason;
    public ResultBean result;

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"75771be99c4ac5607391b991e1062232","title":"珠海高端会展酒店组团亮相国内行业大会，开拓实干发展高质量会展经济","date":"2018-05-10 13:21","category":"头条","author_name":"南方网","url":"http://mini.eastday.com/mobile/180510132145121.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_1_mwpm_03200403.jpg"},{"uniquekey":"5946aaf6e090d577b41c31a562cb9104","title":"广州人说台湾发展水平低 台网友:自家短处要认清","date":"2018-05-10 13:39","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180510133916617.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180510/20180510133916_bfe570c47949f676222b45cc04943b27_1_mwpm_03200403.jpg"},{"uniquekey":"36c41dd6328f7d5cbc158a81c2a518ab","title":"普京在阅兵式上这个反应 又帅了","date":"2018-05-10 13:30","category":"头条","author_name":"环球时报","url":"http://mini.eastday.com/mobile/180510133012124.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180510/20180510133012_b63916af7f9bf063b9f669ade20e142d_1_mwpm_03200403.jpg"},{"uniquekey":"b8db5714a82d688eb441fd141d6de4e6","title":"湖北历史上首次！500万重奖10位工匠","date":"2018-05-10 13:29","category":"头条","author_name":"光明网","url":"http://mini.eastday.com/mobile/180510132908986.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180510/20180510132908_c1ccd5c0c17f8e3aafbbb06129b019c6_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180510/20180510132908_c1ccd5c0c17f8e3aafbbb06129b019c6_2_mwpm_03200403.jpg"},{"uniquekey":"fd9b86016d98af1009555ecaa773c1e4","title":"独家述评 | 实践，以人民的名义","date":"2018-05-10 13:27","category":"头条","author_name":"新民网","url":"http://mini.eastday.com/mobile/180510132730590.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180510/20180510132730_db3e0298fab5a3b30b49e69129eccc78_1_mwpm_03200403.jpg"},{"uniquekey":"dbe09fc13b3bebe45b9ff79ac3815d28","title":"空姐打顺风车遇害 凶手仍在潜逃 滴滴公开道歉","date":"2018-05-10 13:20","category":"头条","author_name":"北京青年报","url":"http://mini.eastday.com/mobile/180510132037767.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180510/20180510132037_e5581b526ed3afa60ce5d914d45302df_1_mwpm_03200403.jpg"},{"uniquekey":"5fc4f2df22e6201f73e7ce1ad1ff3b6b","title":"女人为什么健身？让肉长到对的地方！","date":"2018-05-10 13:16","category":"头条","author_name":"猪猪评球","url":"http://mini.eastday.com/mobile/180510131619678.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180510/20180510_6c4bae0c7151553cf01f1002620ecffc_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20180510/20180510_0171db555650088e81dd81c67d0a2b49_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20180510/20180510_c161b3552613886faf0b78f5bb183c78_cover_mwpm_03200403.jpg"}]
         */

        public String stat;
        public List<DataBean> data;

        public static class DataBean {
            /**
             * uniquekey : 75771be99c4ac5607391b991e1062232
             * title : 珠海高端会展酒店组团亮相国内行业大会，开拓实干发展高质量会展经济
             * date : 2018-05-10 13:21
             * category : 头条
             * author_name : 南方网
             * url : http://mini.eastday.com/mobile/180510132145121.html
             * thumbnail_pic_s : http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_4_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_3_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://01.imgmini.eastday.com/mobile/20180510/20180510132145_472b41efd9c6f2fdeb285717ed76591c_1_mwpm_03200403.jpg
             */

            public String uniquekey;
            public String title;
            public String date;
            public String category;
            public String author_name;
            public String url;
            public String thumbnail_pic_s;
            public String thumbnail_pic_s02;
            public String thumbnail_pic_s03;

            public void clickToWeb(View view) {
                ARouter.getInstance().build(RouteTable.mainWeb).withString("title", title).withString("url", url).navigation();
            }
        }
    }
}
