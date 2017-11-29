package com.example.administrator.eshop.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */

public class CategoryLeft {

    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"2723","gc_name":"美妆个护","type_id":"34","type_name":"New美妆个护","gc_parent_id":"0","commis_rate":"6","gc_sort":"1","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"http://img.emall001.com//mobile/category/05549250206470622.png","text":"面部护肤/时尚彩妆/美发护发/身体护理/女性护理/美容清洁/男士护肤/眼睛护理/国际名品"},{"gc_id":"2683","gc_name":"母婴玩具","type_id":"31","type_name":"New母婴用品类型","gc_parent_id":"0","commis_rate":"5","gc_sort":"2","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"2","image":"http://img.emall001.com//mobile/category/05549248214440874.png","text":"品牌推荐/奶粉/婴幼食品/哺育喂养/洗护清洁/尿裤湿巾/智力玩具/童装童鞋/生活学习"},{"gc_id":"3894","gc_name":"时尚数码","type_id":"44","type_name":"New智能数码","gc_parent_id":"0","commis_rate":"8","gc_sort":"3","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"http://img.emall001.com//mobile/category/05549248343224870.png","text":"为您优选/品牌推荐/智能生活/手机配件/电脑配件/品牌名表/服饰/配饰/北京故事"},{"gc_id":"2392","gc_name":"乳品生鲜","type_id":"28","type_name":"New壹号生鲜类型","gc_parent_id":"0","commis_rate":"3","gc_sort":"4","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"2","image":"http://img.emall001.com//mobile/category/05549248456284520.png","text":"品牌推荐/进口水果/时鲜水果/牛羊肉/蛋糕/禽/蛋/全球海鲜/奶制品/阳澄湖蟹"},{"gc_id":"2460","gc_name":"休闲食品","type_id":"30","type_name":"New食品饮料类型","gc_parent_id":"0","commis_rate":"5","gc_sort":"5","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"2","image":"http://img.emall001.com//mobile/category/05549248561215696.png","text":"热卖爆款/饼干糕点/休闲零食/糖果巧克力/面包/速食/罐头/坚果炒货/俄罗斯食品/海味零食"},{"gc_id":"2641","gc_name":"饮料酒水","type_id":"45","type_name":"New饮料酒水","gc_parent_id":"0","commis_rate":"5","gc_sort":"6","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"http://img.emall001.com//mobile/category/05549248836746366.png","text":"进口啤酒/国产啤酒/进口葡萄酒/国产葡萄酒/国产名酒/地方特色酒/黄酒/洋酒/气泡香槟酒/进口饮料/国产饮料"},{"gc_id":"3891","gc_name":"南北特产","type_id":"46","type_name":"New牛奶乳品","gc_parent_id":"0","commis_rate":"3","gc_sort":"7","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"http://img.emall001.com//mobile/category/05593323092942241.png","text":"品牌推荐/干货/北京特产/山东特产/东北特产/江南特产/湘鄂特产/河南特产/山西特产/陕甘宁特产/西部特产"},{"gc_id":"2559","gc_name":"粮油调味","type_id":"33","type_name":"New粮油副食类型","gc_parent_id":"0","commis_rate":"5","gc_sort":"8","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"http://img.emall001.com//mobile/category/05549249074191459.png","text":"为你推荐/食用油/大米面粉/厨房调味/进口调料/进口橄榄油"},{"gc_id":"3413","gc_name":"营养保健","type_id":"36","type_name":"New营养保健","gc_parent_id":"0","commis_rate":"7","gc_sort":"9","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"http://img.emall001.com//mobile/category/05549249193662061.png","text":"健康营养/维生素/传统滋补/调节三高/护理护具/计生用品/儿童保健/妇女保健"},{"gc_id":"2780","gc_name":"居家生活","type_id":"37","type_name":"New居家生活","gc_parent_id":"0","commis_rate":"8","gc_sort":"10","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"http://img.emall001.com//mobile/category/05549249299330239.png","text":"家庭清洁/纸品湿巾/衣物清洁/文具用品/驱虫除湿/厨具/家纺/户外/鲜花"},{"gc_id":"3899","gc_name":"茶冲咖啡","type_id":"47","type_name":"New鲜花蛋糕","gc_parent_id":"0","commis_rate":"5","gc_sort":"11","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","show_type":"1","image":"http://img.emall001.com//mobile/category/05593318930025831.png","text":"品牌推荐/进口速溶咖啡/进口早餐谷物/进口冲饮/粉/进口养生茶/进口红茶/进口绿茶/进口花果茶/咖啡伴侣"}]}
     */

    private int code;
    private DatasBean datas;

    public static CategoryLeft objectFromData(String str) {

        return new Gson().fromJson(str, CategoryLeft.class);
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
             * gc_id : 2723
             * gc_name : 美妆个护
             * type_id : 34
             * type_name : New美妆个护
             * gc_parent_id : 0
             * commis_rate : 6
             * gc_sort : 1
             * gc_virtual : 0
             * gc_title :
             * gc_keywords :
             * gc_description :
             * show_type : 1
             * image : http://img.emall001.com//mobile/category/05549250206470622.png
             * text : 面部护肤/时尚彩妆/美发护发/身体护理/女性护理/美容清洁/男士护肤/眼睛护理/国际名品
             */

            private String gc_id;
            private String gc_name;
            private String type_id;
            private String type_name;
            private String gc_parent_id;
            private String commis_rate;
            private String gc_sort;
            private String gc_virtual;
            private String gc_title;
            private String gc_keywords;
            private String gc_description;
            private String show_type;
            private String image;
            private String text;

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

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getGc_parent_id() {
                return gc_parent_id;
            }

            public void setGc_parent_id(String gc_parent_id) {
                this.gc_parent_id = gc_parent_id;
            }

            public String getCommis_rate() {
                return commis_rate;
            }

            public void setCommis_rate(String commis_rate) {
                this.commis_rate = commis_rate;
            }

            public String getGc_sort() {
                return gc_sort;
            }

            public void setGc_sort(String gc_sort) {
                this.gc_sort = gc_sort;
            }

            public String getGc_virtual() {
                return gc_virtual;
            }

            public void setGc_virtual(String gc_virtual) {
                this.gc_virtual = gc_virtual;
            }

            public String getGc_title() {
                return gc_title;
            }

            public void setGc_title(String gc_title) {
                this.gc_title = gc_title;
            }

            public String getGc_keywords() {
                return gc_keywords;
            }

            public void setGc_keywords(String gc_keywords) {
                this.gc_keywords = gc_keywords;
            }

            public String getGc_description() {
                return gc_description;
            }

            public void setGc_description(String gc_description) {
                this.gc_description = gc_description;
            }

            public String getShow_type() {
                return show_type;
            }

            public void setShow_type(String show_type) {
                this.show_type = show_type;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}
