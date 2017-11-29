package com.example.administrator.eshop.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28 0028.
 */

public class GoodListBean {
    private int code;
    private boolean hasmore;
    private int page_total;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static GoodListBean objectFromData(String str) {

        return new Gson().fromJson(str, GoodListBean.class);
    }

    public static class DatasBean{
         private List<GoodsListBean> goods_list;

        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public static  DatasBean objectFromData(String str) {

            return new Gson().fromJson(str, DatasBean.class);
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean {
            private String goods_id;
            private String goods_marketprice;
            private ContractlistBean contractlist;
            private String evaluation_good_star;
            private String is_virtual;
            private String is_fcode;
            private String is_presell;
            private String evaluation_count;
            private String member_id;
            private Object store_domain;
            private String store_id;
            private String goods_storage;
            private String goods_image;
            private String store_name;
            private String goods_name;
            private Object goods_jingle;
            private String gc_name;
            private String brand_name;
            private String brand_id;
            private String is_book;
            private String attr_id;
            private String area_id;
            private String have_gift;
            private String goods_click;
            private String goods_salenum;
            private Object goods_barcode;
            private String is_own_shop;
            private boolean sole_flag;
            private boolean group_flag;
            private boolean xianshi_flag;
            private String goods_price;
            private String goods_image_url;
            private List<String> image;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_marketprice() {
                return goods_marketprice;
            }

            public void setGoods_marketprice(String goods_marketprice) {
                this.goods_marketprice = goods_marketprice;
            }

            public ContractlistBean getContractlist() {
                return contractlist;
            }

            public void setContractlist(ContractlistBean contractlist) {
                this.contractlist = contractlist;
            }

            public String getEvaluation_good_star() {
                return evaluation_good_star;
            }

            public void setEvaluation_good_star(String evaluation_good_star) {
                this.evaluation_good_star = evaluation_good_star;
            }

            public String getIs_virtual() {
                return is_virtual;
            }

            public void setIs_virtual(String is_virtual) {
                this.is_virtual = is_virtual;
            }

            public String getIs_fcode() {
                return is_fcode;
            }

            public void setIs_fcode(String is_fcode) {
                this.is_fcode = is_fcode;
            }

            public String getIs_presell() {
                return is_presell;
            }

            public void setIs_presell(String is_presell) {
                this.is_presell = is_presell;
            }

            public String getEvaluation_count() {
                return evaluation_count;
            }

            public void setEvaluation_count(String evaluation_count) {
                this.evaluation_count = evaluation_count;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public Object getStore_domain() {
                return store_domain;
            }

            public void setStore_domain(Object store_domain) {
                this.store_domain = store_domain;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getGoods_storage() {
                return goods_storage;
            }

            public void setGoods_storage(String goods_storage) {
                this.goods_storage = goods_storage;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public Object getGoods_jingle() {
                return goods_jingle;
            }

            public void setGoods_jingle(Object goods_jingle) {
                this.goods_jingle = goods_jingle;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(String brand_id) {
                this.brand_id = brand_id;
            }

            public String getIs_book() {
                return is_book;
            }

            public void setIs_book(String is_book) {
                this.is_book = is_book;
            }

            public String getAttr_id() {
                return attr_id;
            }

            public void setAttr_id(String attr_id) {
                this.attr_id = attr_id;
            }

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getHave_gift() {
                return have_gift;
            }

            public void setHave_gift(String have_gift) {
                this.have_gift = have_gift;
            }

            public String getGoods_click() {
                return goods_click;
            }

            public void setGoods_click(String goods_click) {
                this.goods_click = goods_click;
            }

            public String getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(String goods_salenum) {
                this.goods_salenum = goods_salenum;
            }

            public Object getGoods_barcode() {
                return goods_barcode;
            }

            public void setGoods_barcode(Object goods_barcode) {
                this.goods_barcode = goods_barcode;
            }

            public String getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(String is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public boolean isSole_flag() {
                return sole_flag;
            }

            public void setSole_flag(boolean sole_flag) {
                this.sole_flag = sole_flag;
            }

            public boolean isGroup_flag() {
                return group_flag;
            }

            public void setGroup_flag(boolean group_flag) {
                this.group_flag = group_flag;
            }

            public boolean isXianshi_flag() {
                return xianshi_flag;
            }

            public void setXianshi_flag(boolean xianshi_flag) {
                this.xianshi_flag = xianshi_flag;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
            }

            public List<String> getImage() {
                return image;
            }

            public void setImage(List<String> image) {
                this.image = image;
            }

            public static class ContractlistBean {
               
                    /**
                     * 1 : {"cti_descurl":"","cti_name":"天天低价","cti_icon_url_60":"http://img.emall001.com//shop/contracticon/05375769456551693_60.png"}
                     * 2 : {"cti_descurl":"","cti_name":"品质承诺","cti_icon_url_60":"http://img.emall001.com//shop/contracticon/pz_60.gif"}
                     * 3 : {"cti_descurl":"","cti_name":"破损补寄","cti_icon_url_60":"http://img.emall001.com//shop/contracticon/psbf_60.gif"}
                     * 4 : {"cti_descurl":"","cti_name":"急速物流","cti_icon_url_60":"http://img.emall001.com//shop/contracticon/jswl_60.gif"}
                     */

                    @SerializedName("1")
                    private ContractlistBean._$1Bean _$1;
                    @SerializedName("2")
                    private ContractlistBean._$2Bean _$2;
                    @SerializedName("3")
                    private ContractlistBean._$3Bean _$3;
                    @SerializedName("4")
                    private ContractlistBean._$4Bean _$4;

                    public static ContractlistBean objectFromData(String str) {

                        return new Gson().fromJson(str, ContractlistBean.class);
                    }

                    public ContractlistBean._$1Bean get_$1() {
                        return _$1;
                    }

                    public void set_$1(ContractlistBean._$1Bean _$1) {
                        this._$1 = _$1;
                    }

                    public ContractlistBean._$2Bean get_$2() {
                        return _$2;
                    }

                    public void set_$2(ContractlistBean._$2Bean _$2) {
                        this._$2 = _$2;
                    }

                    public ContractlistBean._$3Bean get_$3() {
                        return _$3;
                    }

                    public void set_$3(ContractlistBean._$3Bean _$3) {
                        this._$3 = _$3;
                    }

                    public ContractlistBean._$4Bean get_$4() {
                        return _$4;
                    }

                    public void set_$4(ContractlistBean._$4Bean _$4) {
                        this._$4 = _$4;
                    }

                    public static class _$1Bean {
                        /**
                         * cti_descurl :
                         * cti_name : 天天低价
                         * cti_icon_url_60 : http://img.emall001.com//shop/contracticon/05375769456551693_60.png
                         */

                        private String cti_descurl;
                        private String cti_name;
                        private String cti_icon_url_60;

                        public static ContractlistBean._$1Bean objectFromData(String str) {

                            return new Gson().fromJson(str, ContractlistBean._$1Bean.class);
                        }

                        public String getCti_descurl() {
                            return cti_descurl;
                        }

                        public void setCti_descurl(String cti_descurl) {
                            this.cti_descurl = cti_descurl;
                        }

                        public String getCti_name() {
                            return cti_name;
                        }

                        public void setCti_name(String cti_name) {
                            this.cti_name = cti_name;
                        }

                        public String getCti_icon_url_60() {
                            return cti_icon_url_60;
                        }

                        public void setCti_icon_url_60(String cti_icon_url_60) {
                            this.cti_icon_url_60 = cti_icon_url_60;
                        }
                    }

                    public static class _$2Bean {
                        /**
                         * cti_descurl :
                         * cti_name : 品质承诺
                         * cti_icon_url_60 : http://img.emall001.com//shop/contracticon/pz_60.gif
                         */

                        private String cti_descurl;
                        private String cti_name;
                        private String cti_icon_url_60;

                        public static ContractlistBean._$2Bean objectFromData(String str) {

                            return new Gson().fromJson(str, ContractlistBean._$2Bean.class);
                        }

                        public String getCti_descurl() {
                            return cti_descurl;
                        }

                        public void setCti_descurl(String cti_descurl) {
                            this.cti_descurl = cti_descurl;
                        }

                        public String getCti_name() {
                            return cti_name;
                        }

                        public void setCti_name(String cti_name) {
                            this.cti_name = cti_name;
                        }

                        public String getCti_icon_url_60() {
                            return cti_icon_url_60;
                        }

                        public void setCti_icon_url_60(String cti_icon_url_60) {
                            this.cti_icon_url_60 = cti_icon_url_60;
                        }
                    }

                    public static class _$3Bean {
                        /**
                         * cti_descurl :
                         * cti_name : 破损补寄
                         * cti_icon_url_60 : http://img.emall001.com//shop/contracticon/psbf_60.gif
                         */

                        private String cti_descurl;
                        private String cti_name;
                        private String cti_icon_url_60;

                        public static ContractlistBean._$3Bean objectFromData(String str) {

                            return new Gson().fromJson(str, ContractlistBean._$3Bean.class);
                        }

                        public String getCti_descurl() {
                            return cti_descurl;
                        }

                        public void setCti_descurl(String cti_descurl) {
                            this.cti_descurl = cti_descurl;
                        }

                        public String getCti_name() {
                            return cti_name;
                        }

                        public void setCti_name(String cti_name) {
                            this.cti_name = cti_name;
                        }

                        public String getCti_icon_url_60() {
                            return cti_icon_url_60;
                        }

                        public void setCti_icon_url_60(String cti_icon_url_60) {
                            this.cti_icon_url_60 = cti_icon_url_60;
                        }
                    }

                    public static class _$4Bean {
                        /**
                         * cti_descurl :
                         * cti_name : 急速物流
                         * cti_icon_url_60 : http://img.emall001.com//shop/contracticon/jswl_60.gif
                         */

                        private String cti_descurl;
                        private String cti_name;
                        private String cti_icon_url_60;

                        public static ContractlistBean._$4Bean objectFromData(String str) {

                            return new Gson().fromJson(str, ContractlistBean._$4Bean.class);
                        }

                        public String getCti_descurl() {
                            return cti_descurl;
                        }

                        public void setCti_descurl(String cti_descurl) {
                            this.cti_descurl = cti_descurl;
                        }

                        public String getCti_name() {
                            return cti_name;
                        }

                        public void setCti_name(String cti_name) {
                            this.cti_name = cti_name;
                        }

                        public String getCti_icon_url_60() {
                            return cti_icon_url_60;
                        }

                        public void setCti_icon_url_60(String cti_icon_url_60) {
                            this.cti_icon_url_60 = cti_icon_url_60;
                        }
                    }
            }
        }
    }

}
