package com.example.administrator.eshop.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class CategoryRight {

    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"2745","gc_name":"面部护肤","child":[{"gc_id":"4060","gc_name":"面霜乳液"},{"gc_id":"2748","gc_name":"洁面"},{"gc_id":"2749","gc_name":"爽肤水"},{"gc_id":"2750","gc_name":"面膜"},{"gc_id":"2751","gc_name":"精华"},{"gc_id":"2752","gc_name":"眼膜/眼霜"},{"gc_id":"3560","gc_name":"防晒"},{"gc_id":"4059","gc_name":"卸妆"},{"gc_id":"4064","gc_name":"套装/套盒"},{"gc_id":"4374","gc_name":"明兰本草"},{"gc_id":"4470","gc_name":"佰草集"}]},{"gc_id":"3476","gc_name":"时尚彩妆","child":[{"gc_id":"3477","gc_name":"面部"},{"gc_id":"3590","gc_name":"眼部"},{"gc_id":"3478","gc_name":"唇部"},{"gc_id":"3481","gc_name":"眉笔"},{"gc_id":"3973","gc_name":"香水"}]},{"gc_id":"2724","gc_name":"美发护发","child":[{"gc_id":"2725","gc_name":"洗发"},{"gc_id":"2726","gc_name":"护发"},{"gc_id":"2728","gc_name":"洗护套装"},{"gc_id":"3974","gc_name":"染烫用品"},{"gc_id":"3975","gc_name":"头发造型"}]},{"gc_id":"2729","gc_name":"身体护理","child":[{"gc_id":"2730","gc_name":"沐浴"},{"gc_id":"2731","gc_name":"脱毛膏"},{"gc_id":"2734","gc_name":"手足护理"},{"gc_id":"3976","gc_name":"身体护理"},{"gc_id":"4178","gc_name":"洗手液"}]},{"gc_id":"2741","gc_name":"女性护理","child":[{"gc_id":"2742","gc_name":"卫生巾"},{"gc_id":"2743","gc_name":"护垫"},{"gc_id":"2744","gc_name":"私密洗护"}]},{"gc_id":"2737","gc_name":"美容清洁","child":[{"gc_id":"3845","gc_name":"漱口水"},{"gc_id":"2739","gc_name":"牙刷牙膏"},{"gc_id":"2740","gc_name":"儿童牙刷"}]},{"gc_id":"3977","gc_name":"男士护肤","child":[{"gc_id":"3979","gc_name":"洗发护发"},{"gc_id":"3980","gc_name":"剃须用品"},{"gc_id":"4341","gc_name":"面霜"},{"gc_id":"4342","gc_name":"洁面乳"},{"gc_id":"4343","gc_name":"啫哩/凝露"}]},{"gc_id":"3985","gc_name":"眼睛护理","child":[{"gc_id":"4156","gc_name":"蒸汽眼罩"},{"gc_id":"3987","gc_name":"护理液"},{"gc_id":"4338","gc_name":"润眼液"},{"gc_id":"4339","gc_name":"洗眼液"},{"gc_id":"4340","gc_name":"参天santen-fx"}]},{"gc_id":"4321","gc_name":"国际名品","child":[{"gc_id":"4322","gc_name":"Dior迪奥"},{"gc_id":"4323","gc_name":"YSL圣罗兰"},{"gc_id":"4324","gc_name":"CHANEL香奈儿"},{"gc_id":"4325","gc_name":"GIVENCHY纪梵希"},{"gc_id":"4326","gc_name":"LANCOME兰蔻"}]}]}
     */

    private int code;
    private DatasBean datas;

    public static CategoryRight objectFromData(String str) {

        return new Gson().fromJson(str, CategoryRight.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<ClassListBean> class_list;

        public static DatasBean objectFromData(String str) {

            return new Gson().fromJson(str, DatasBean.class);
        }

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * gc_id : 2745
             * gc_name : 面部护肤
             * child : [{"gc_id":"4060","gc_name":"面霜乳液"},{"gc_id":"2748","gc_name":"洁面"},{"gc_id":"2749","gc_name":"爽肤水"},{"gc_id":"2750","gc_name":"面膜"},{"gc_id":"2751","gc_name":"精华"},{"gc_id":"2752","gc_name":"眼膜/眼霜"},{"gc_id":"3560","gc_name":"防晒"},{"gc_id":"4059","gc_name":"卸妆"},{"gc_id":"4064","gc_name":"套装/套盒"},{"gc_id":"4374","gc_name":"明兰本草"},{"gc_id":"4470","gc_name":"佰草集"}]
             */

            private String gc_id;
            private String gc_name;
            private List<ChildBean> child;

            public static ClassListBean objectFromData(String str) {

                return new Gson().fromJson(str, ClassListBean.class);
            }

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }

            public List<ChildBean> getChild() {
                return child;
            }

            public void setChild(List<ChildBean> child) {
                this.child = child;
            }

            public static class ChildBean {
                /**
                 * gc_id : 4060
                 * gc_name : 面霜乳液
                 */

                private String gc_id;
                private String gc_name;

                public static ChildBean objectFromData(String str) {

                    return new Gson().fromJson(str, ChildBean.class);
                }

                public String getGc_id() {
                    return gc_id;
                }

                public void setGc_id(String gc_id) {
                    this.gc_id = gc_id;
                }

                public String getGc_name() {
                    return gc_name;
                }

                public void setGc_name(String gc_name) {
                    this.gc_name = gc_name;
                }
            }
        }
    }
}
