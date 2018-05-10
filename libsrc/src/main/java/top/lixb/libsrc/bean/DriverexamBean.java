package top.lixb.libsrc.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class DriverexamBean {

    /**
     * status : 0
     * msg : ok
     * result : {"total":"950","pagenum":"1","pagesize":"3","subject":"1","type":"C1","sort":"normal","list":[{"question":"未取得驾驶证的学员在道路上学习驾驶技能，下列哪种做法是正确的？","option1":"A、使用所学车型的教练车由教练员随车指导","option2":"B、使用所学车型的教练车单独驾驶学习","option3":"C、使用私家车由教练员随车指导","option4":"D、使用所学车型的教练车由非教练员的驾驶人随车指导","answer":"A","explain":"《公安部令第123号》规定：未取得驾驶证的学员在道路上学习驾驶技能，使用所学车型的教练车由教练员随车指导。","pic":"","type":"C1,C2,C3"},{"question":"在实习期内驾驶机动车的，应当在车身后部粘贴或者悬挂哪种标志？","option1":"A、注意新手标志","option2":"B、注意避让标志","option3":"C、统一式样的实习标志","option4":"D、注意车距标志","answer":"C","explain":"《公安部令第123号》第六十四条规定：在实习期内驾驶机动车的，应当在车身后部粘贴或者悬挂统一式样的实习标志。","pic":"","type":"C1,C2,C3"},{"question":"机动车驾驶人在实习期内驾驶机动车不得牵引挂车。","option1":"","option2":"","option3":"","option4":"","answer":"对","explain":"《公安部令第123号》第六十五条规定：机动车驾驶人在实习期内不得驾驶公共汽车、营运客车或者执行任务的警车、消防车、救护车、工程救险车以及载有爆炸物品、易燃易爆化学物品、剧毒或者放射性等危险物品的机动车；驾驶的机动车不得牵引挂车。","pic":"","type":"C1,C2,C3"}]}
     */

    public String status;
    public String msg;
    public ResultBean result;

    public static class ResultBean {
        /**
         * total : 950
         * pagenum : 1
         * pagesize : 3
         * subject : 1
         * type : C1
         * sort : normal
         * list : [{"question":"未取得驾驶证的学员在道路上学习驾驶技能，下列哪种做法是正确的？","option1":"A、使用所学车型的教练车由教练员随车指导","option2":"B、使用所学车型的教练车单独驾驶学习","option3":"C、使用私家车由教练员随车指导","option4":"D、使用所学车型的教练车由非教练员的驾驶人随车指导","answer":"A","explain":"《公安部令第123号》规定：未取得驾驶证的学员在道路上学习驾驶技能，使用所学车型的教练车由教练员随车指导。","pic":"","type":"C1,C2,C3"},{"question":"在实习期内驾驶机动车的，应当在车身后部粘贴或者悬挂哪种标志？","option1":"A、注意新手标志","option2":"B、注意避让标志","option3":"C、统一式样的实习标志","option4":"D、注意车距标志","answer":"C","explain":"《公安部令第123号》第六十四条规定：在实习期内驾驶机动车的，应当在车身后部粘贴或者悬挂统一式样的实习标志。","pic":"","type":"C1,C2,C3"},{"question":"机动车驾驶人在实习期内驾驶机动车不得牵引挂车。","option1":"","option2":"","option3":"","option4":"","answer":"对","explain":"《公安部令第123号》第六十五条规定：机动车驾驶人在实习期内不得驾驶公共汽车、营运客车或者执行任务的警车、消防车、救护车、工程救险车以及载有爆炸物品、易燃易爆化学物品、剧毒或者放射性等危险物品的机动车；驾驶的机动车不得牵引挂车。","pic":"","type":"C1,C2,C3"}]
         */

        public String total;
        public String pagenum;
        public String pagesize;
        public String subject;
        public String type;
        public String sort;
        public List<ListBean> list;

        public static class ListBean extends BaseObservable{
            /**
             * question : 未取得驾驶证的学员在道路上学习驾驶技能，下列哪种做法是正确的？
             * option1 : A、使用所学车型的教练车由教练员随车指导
             * option2 : B、使用所学车型的教练车单独驾驶学习
             * option3 : C、使用私家车由教练员随车指导
             * option4 : D、使用所学车型的教练车由非教练员的驾驶人随车指导
             * answer : A
             * explain : 《公安部令第123号》规定：未取得驾驶证的学员在道路上学习驾驶技能，使用所学车型的教练车由教练员随车指导。
             * pic :
             * type : C1,C2,C3
             */

            public String question;
            public String option1;
            public String option2;
            public String option3;
            public String option4;
            public String answer;
            public String explain;
            public String pic;
            public String type;

            /**
             * 是否显示答案
             */
            public ObservableBoolean showanser = new ObservableBoolean(false);

            {
                addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(Observable sender, int propertyId) {
                        updateFlag();
                    }
                });
            }





            public boolean updateFlag() {
                if (!TextUtils.isEmpty(answer)) {
                    if (answer.contains("对") || answer.contains("错")) {
                        answerIsTrueOrFalse.set(true);
                        return true;
                    }
                }
                answerIsTrueOrFalse.set(false);
                return false;
            }

            public ObservableBoolean answerIsTrueOrFalse = new ObservableBoolean(updateFlag());

            public void changeShowanser(View view) {
                showanser.set(!showanser.get());
            }
        }
    }
}
