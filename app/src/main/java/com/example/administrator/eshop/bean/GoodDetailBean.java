package com.example.administrator.eshop.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/2 0002.
 */

public class GoodDetailBean  implements Serializable{

    private int code;
    private DatasBean datas;
    private int count;
    private boolean isChecked=true;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public static GoodDetailBean objectFromData(String str) {

        return new Gson().fromJson(str, GoodDetailBean.class);
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

    public static class DatasBean implements Serializable{
        private GoodsInfoBean goods_info;
        private Object video_path;
        private Object mansong_info;
        private StoreInfoBean store_info;
        private SpecListBean spec_list;
        private String goods_image;
        private boolean is_favorate;
        private GoodsEvaluateInfoBean goods_evaluate_info;
        private GoodsHairInfoBean goods_hair_info;
        private List<String> spec_image;
        private List<ImageListBean> image_list;
        private List<?> gift_array;
        private List<GoodsCommendListBean> goods_commend_list;
        private List<?> goods_eval_list;

        public static DatasBean objectFromData(String str) {

            return new Gson().fromJson(str, DatasBean.class);
        }

        public GoodsInfoBean getGoods_info() {
            return goods_info;
        }

        public void setGoods_info(GoodsInfoBean goods_info) {
            this.goods_info = goods_info;
        }

        public Object getVideo_path() {
            return video_path;
        }

        public void setVideo_path(Object video_path) {
            this.video_path = video_path;
        }

        public Object getMansong_info() {
            return mansong_info;
        }

        public void setMansong_info(Object mansong_info) {
            this.mansong_info = mansong_info;
        }

        public StoreInfoBean getStore_info() {
            return store_info;
        }

        public void setStore_info(StoreInfoBean store_info) {
            this.store_info = store_info;
        }

        public SpecListBean getSpec_list() {
            return spec_list;
        }

        public void setSpec_list(SpecListBean spec_list) {
            this.spec_list = spec_list;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public boolean isIs_favorate() {
            return is_favorate;
        }

        public void setIs_favorate(boolean is_favorate) {
            this.is_favorate = is_favorate;
        }

        public GoodsEvaluateInfoBean getGoods_evaluate_info() {
            return goods_evaluate_info;
        }

        public void setGoods_evaluate_info(GoodsEvaluateInfoBean goods_evaluate_info) {
            this.goods_evaluate_info = goods_evaluate_info;
        }

        public GoodsHairInfoBean getGoods_hair_info() {
            return goods_hair_info;
        }

        public void setGoods_hair_info(GoodsHairInfoBean goods_hair_info) {
            this.goods_hair_info = goods_hair_info;
        }

        public List<String> getSpec_image() {
            return spec_image;
        }

        public void setSpec_image(List<String> spec_image) {
            this.spec_image = spec_image;
        }

        public List<ImageListBean> getImage_list() {
            return image_list;
        }

        public void setImage_list(List<ImageListBean> image_list) {
            this.image_list = image_list;
        }

        public List<?> getGift_array() {
            return gift_array;
        }

        public void setGift_array(List<?> gift_array) {
            this.gift_array = gift_array;
        }

        public List<GoodsCommendListBean> getGoods_commend_list() {
            return goods_commend_list;
        }

        public void setGoods_commend_list(List<GoodsCommendListBean> goods_commend_list) {
            this.goods_commend_list = goods_commend_list;
        }

        public List<?> getGoods_eval_list() {
            return goods_eval_list;
        }

        public void setGoods_eval_list(List<?> goods_eval_list) {
            this.goods_eval_list = goods_eval_list;
        }

        public static class GoodsInfoBean implements Serializable{
            private String goods_name;
            private String goods_jingle;
            private String gc_id_1;
            private String gc_id_2;
            private String gc_id_3;
            private Object spec_name;
            private Object spec_value;
            private GoodsAttrBean goods_attr;
            private GoodsCustomBean goods_custom;
            private String mobile_body;
            private String goods_price;
            private String goods_marketprice;
            private String goods_costprice;
            private String goods_discount;
            private String goods_serial;
            private String goods_storage_alarm;
            private String goods_barcode;
            private String transport_id;
            private String transport_title;
            private String goods_freight;
            private String goods_vat;
            private String areaid_1;
            private String areaid_2;
            private String goods_stcids;
            private String plateid_top;
            private String plateid_bottom;
            private String is_virtual;
            private String virtual_indate;
            private String virtual_limit;
            private String virtual_invalid_refund;
            private String sup_id;
            private String is_own_shop;
            private String goods_trans_v;
            private String is_dis;
            private String dis_add_time;
            private String dis_commis_rate;
            private String sale_count;
            private String click_count;
            private Object goods_video;
            private String goods_id;
            private String goods_promotion_price;
            private String goods_promotion_type;
            private int goods_click;
            private String goods_salenum;
            private String goods_collect;
            private Object goods_spec;
            private String goods_storage;
            private String color_id;
            private String evaluation_good_star;
            private String evaluation_count;
            private String is_fcode;
            private String is_presell;
            private String presell_deliverdate;
            private String is_book;
            private String book_down_payment;
            private String book_final_payment;
            private String book_down_time;
            private String book_buyers;
            private String have_gift;
            private String contract_1;
            private String contract_2;
            private String contract_3;
            private String contract_4;
            private String contract_5;
            private String contract_6;
            private String contract_7;
            private String contract_8;
            private String contract_9;
            private String contract_10;
            private String is_chain;
            private String custom_sort;
            private String is_direct_mail;
            private Object groupbuy_info;
            private Object xianshi_info;
            private Object jjg_info;
            private int cart;
            private int buynow;
            private ContractlistBean contractlist;
            private String goods_url;
            private List<?> sole_info;

            public static GoodsInfoBean objectFromData(String str) {

                return new Gson().fromJson(str, GoodsInfoBean.class);
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_jingle() {
                return goods_jingle;
            }

            public void setGoods_jingle(String goods_jingle) {
                this.goods_jingle = goods_jingle;
            }

            public String getGc_id_1() {
                return gc_id_1;
            }

            public void setGc_id_1(String gc_id_1) {
                this.gc_id_1 = gc_id_1;
            }

            public String getGc_id_2() {
                return gc_id_2;
            }

            public void setGc_id_2(String gc_id_2) {
                this.gc_id_2 = gc_id_2;
            }

            public String getGc_id_3() {
                return gc_id_3;
            }

            public void setGc_id_3(String gc_id_3) {
                this.gc_id_3 = gc_id_3;
            }

            public Object getSpec_name() {
                return spec_name;
            }

            public void setSpec_name(Object spec_name) {
                this.spec_name = spec_name;
            }

            public Object getSpec_value() {
                return spec_value;
            }

            public void setSpec_value(Object spec_value) {
                this.spec_value = spec_value;
            }

            public GoodsAttrBean getGoods_attr() {
                return goods_attr;
            }

            public void setGoods_attr(GoodsAttrBean goods_attr) {
                this.goods_attr = goods_attr;
            }

            public GoodsCustomBean getGoods_custom() {
                return goods_custom;
            }

            public void setGoods_custom(GoodsCustomBean goods_custom) {
                this.goods_custom = goods_custom;
            }

            public String getMobile_body() {
                return mobile_body;
            }

            public void setMobile_body(String mobile_body) {
                this.mobile_body = mobile_body;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_marketprice() {
                return goods_marketprice;
            }

            public void setGoods_marketprice(String goods_marketprice) {
                this.goods_marketprice = goods_marketprice;
            }

            public String getGoods_costprice() {
                return goods_costprice;
            }

            public void setGoods_costprice(String goods_costprice) {
                this.goods_costprice = goods_costprice;
            }

            public String getGoods_discount() {
                return goods_discount;
            }

            public void setGoods_discount(String goods_discount) {
                this.goods_discount = goods_discount;
            }

            public String getGoods_serial() {
                return goods_serial;
            }

            public void setGoods_serial(String goods_serial) {
                this.goods_serial = goods_serial;
            }

            public String getGoods_storage_alarm() {
                return goods_storage_alarm;
            }

            public void setGoods_storage_alarm(String goods_storage_alarm) {
                this.goods_storage_alarm = goods_storage_alarm;
            }

            public String getGoods_barcode() {
                return goods_barcode;
            }

            public void setGoods_barcode(String goods_barcode) {
                this.goods_barcode = goods_barcode;
            }

            public String getTransport_id() {
                return transport_id;
            }

            public void setTransport_id(String transport_id) {
                this.transport_id = transport_id;
            }

            public String getTransport_title() {
                return transport_title;
            }

            public void setTransport_title(String transport_title) {
                this.transport_title = transport_title;
            }

            public String getGoods_freight() {
                return goods_freight;
            }

            public void setGoods_freight(String goods_freight) {
                this.goods_freight = goods_freight;
            }

            public String getGoods_vat() {
                return goods_vat;
            }

            public void setGoods_vat(String goods_vat) {
                this.goods_vat = goods_vat;
            }

            public String getAreaid_1() {
                return areaid_1;
            }

            public void setAreaid_1(String areaid_1) {
                this.areaid_1 = areaid_1;
            }

            public String getAreaid_2() {
                return areaid_2;
            }

            public void setAreaid_2(String areaid_2) {
                this.areaid_2 = areaid_2;
            }

            public String getGoods_stcids() {
                return goods_stcids;
            }

            public void setGoods_stcids(String goods_stcids) {
                this.goods_stcids = goods_stcids;
            }

            public String getPlateid_top() {
                return plateid_top;
            }

            public void setPlateid_top(String plateid_top) {
                this.plateid_top = plateid_top;
            }

            public String getPlateid_bottom() {
                return plateid_bottom;
            }

            public void setPlateid_bottom(String plateid_bottom) {
                this.plateid_bottom = plateid_bottom;
            }

            public String getIs_virtual() {
                return is_virtual;
            }

            public void setIs_virtual(String is_virtual) {
                this.is_virtual = is_virtual;
            }

            public String getVirtual_indate() {
                return virtual_indate;
            }

            public void setVirtual_indate(String virtual_indate) {
                this.virtual_indate = virtual_indate;
            }

            public String getVirtual_limit() {
                return virtual_limit;
            }

            public void setVirtual_limit(String virtual_limit) {
                this.virtual_limit = virtual_limit;
            }

            public String getVirtual_invalid_refund() {
                return virtual_invalid_refund;
            }

            public void setVirtual_invalid_refund(String virtual_invalid_refund) {
                this.virtual_invalid_refund = virtual_invalid_refund;
            }

            public String getSup_id() {
                return sup_id;
            }

            public void setSup_id(String sup_id) {
                this.sup_id = sup_id;
            }

            public String getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(String is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public String getGoods_trans_v() {
                return goods_trans_v;
            }

            public void setGoods_trans_v(String goods_trans_v) {
                this.goods_trans_v = goods_trans_v;
            }

            public String getIs_dis() {
                return is_dis;
            }

            public void setIs_dis(String is_dis) {
                this.is_dis = is_dis;
            }

            public String getDis_add_time() {
                return dis_add_time;
            }

            public void setDis_add_time(String dis_add_time) {
                this.dis_add_time = dis_add_time;
            }

            public String getDis_commis_rate() {
                return dis_commis_rate;
            }

            public void setDis_commis_rate(String dis_commis_rate) {
                this.dis_commis_rate = dis_commis_rate;
            }

            public String getSale_count() {
                return sale_count;
            }

            public void setSale_count(String sale_count) {
                this.sale_count = sale_count;
            }

            public String getClick_count() {
                return click_count;
            }

            public void setClick_count(String click_count) {
                this.click_count = click_count;
            }

            public Object getGoods_video() {
                return goods_video;
            }

            public void setGoods_video(Object goods_video) {
                this.goods_video = goods_video;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_promotion_price() {
                return goods_promotion_price;
            }

            public void setGoods_promotion_price(String goods_promotion_price) {
                this.goods_promotion_price = goods_promotion_price;
            }

            public String getGoods_promotion_type() {
                return goods_promotion_type;
            }

            public void setGoods_promotion_type(String goods_promotion_type) {
                this.goods_promotion_type = goods_promotion_type;
            }

            public int getGoods_click() {
                return goods_click;
            }

            public void setGoods_click(int goods_click) {
                this.goods_click = goods_click;
            }

            public String getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(String goods_salenum) {
                this.goods_salenum = goods_salenum;
            }

            public String getGoods_collect() {
                return goods_collect;
            }

            public void setGoods_collect(String goods_collect) {
                this.goods_collect = goods_collect;
            }

            public Object getGoods_spec() {
                return goods_spec;
            }

            public void setGoods_spec(Object goods_spec) {
                this.goods_spec = goods_spec;
            }

            public String getGoods_storage() {
                return goods_storage;
            }

            public void setGoods_storage(String goods_storage) {
                this.goods_storage = goods_storage;
            }

            public String getColor_id() {
                return color_id;
            }

            public void setColor_id(String color_id) {
                this.color_id = color_id;
            }

            public String getEvaluation_good_star() {
                return evaluation_good_star;
            }

            public void setEvaluation_good_star(String evaluation_good_star) {
                this.evaluation_good_star = evaluation_good_star;
            }

            public String getEvaluation_count() {
                return evaluation_count;
            }

            public void setEvaluation_count(String evaluation_count) {
                this.evaluation_count = evaluation_count;
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

            public String getPresell_deliverdate() {
                return presell_deliverdate;
            }

            public void setPresell_deliverdate(String presell_deliverdate) {
                this.presell_deliverdate = presell_deliverdate;
            }

            public String getIs_book() {
                return is_book;
            }

            public void setIs_book(String is_book) {
                this.is_book = is_book;
            }

            public String getBook_down_payment() {
                return book_down_payment;
            }

            public void setBook_down_payment(String book_down_payment) {
                this.book_down_payment = book_down_payment;
            }

            public String getBook_final_payment() {
                return book_final_payment;
            }

            public void setBook_final_payment(String book_final_payment) {
                this.book_final_payment = book_final_payment;
            }

            public String getBook_down_time() {
                return book_down_time;
            }

            public void setBook_down_time(String book_down_time) {
                this.book_down_time = book_down_time;
            }

            public String getBook_buyers() {
                return book_buyers;
            }

            public void setBook_buyers(String book_buyers) {
                this.book_buyers = book_buyers;
            }

            public String getHave_gift() {
                return have_gift;
            }

            public void setHave_gift(String have_gift) {
                this.have_gift = have_gift;
            }

            public String getContract_1() {
                return contract_1;
            }

            public void setContract_1(String contract_1) {
                this.contract_1 = contract_1;
            }

            public String getContract_2() {
                return contract_2;
            }

            public void setContract_2(String contract_2) {
                this.contract_2 = contract_2;
            }

            public String getContract_3() {
                return contract_3;
            }

            public void setContract_3(String contract_3) {
                this.contract_3 = contract_3;
            }

            public String getContract_4() {
                return contract_4;
            }

            public void setContract_4(String contract_4) {
                this.contract_4 = contract_4;
            }

            public String getContract_5() {
                return contract_5;
            }

            public void setContract_5(String contract_5) {
                this.contract_5 = contract_5;
            }

            public String getContract_6() {
                return contract_6;
            }

            public void setContract_6(String contract_6) {
                this.contract_6 = contract_6;
            }

            public String getContract_7() {
                return contract_7;
            }

            public void setContract_7(String contract_7) {
                this.contract_7 = contract_7;
            }

            public String getContract_8() {
                return contract_8;
            }

            public void setContract_8(String contract_8) {
                this.contract_8 = contract_8;
            }

            public String getContract_9() {
                return contract_9;
            }

            public void setContract_9(String contract_9) {
                this.contract_9 = contract_9;
            }

            public String getContract_10() {
                return contract_10;
            }

            public void setContract_10(String contract_10) {
                this.contract_10 = contract_10;
            }

            public String getIs_chain() {
                return is_chain;
            }

            public void setIs_chain(String is_chain) {
                this.is_chain = is_chain;
            }

            public String getCustom_sort() {
                return custom_sort;
            }

            public void setCustom_sort(String custom_sort) {
                this.custom_sort = custom_sort;
            }

            public String getIs_direct_mail() {
                return is_direct_mail;
            }

            public void setIs_direct_mail(String is_direct_mail) {
                this.is_direct_mail = is_direct_mail;
            }

            public Object getGroupbuy_info() {
                return groupbuy_info;
            }

            public void setGroupbuy_info(Object groupbuy_info) {
                this.groupbuy_info = groupbuy_info;
            }

            public Object getXianshi_info() {
                return xianshi_info;
            }

            public void setXianshi_info(Object xianshi_info) {
                this.xianshi_info = xianshi_info;
            }

            public Object getJjg_info() {
                return jjg_info;
            }

            public void setJjg_info(Object jjg_info) {
                this.jjg_info = jjg_info;
            }

            public int getCart() {
                return cart;
            }

            public void setCart(int cart) {
                this.cart = cart;
            }

            public int getBuynow() {
                return buynow;
            }

            public void setBuynow(int buynow) {
                this.buynow = buynow;
            }

            public ContractlistBean getContractlist() {
                return contractlist;
            }

            public void setContractlist(ContractlistBean contractlist) {
                this.contractlist = contractlist;
            }

            public String getGoods_url() {
                return goods_url;
            }

            public void setGoods_url(String goods_url) {
                this.goods_url = goods_url;
            }

            public List<?> getSole_info() {
                return sole_info;
            }

            public void setSole_info(List<?> sole_info) {
                this.sole_info = sole_info;
            }

            public static class GoodsAttrBean implements Serializable{
                @SerializedName("77")
                private _$77Bean _$77;

                public static GoodsAttrBean objectFromData(String str) {

                    return new Gson().fromJson(str, GoodsAttrBean.class);
                }

                public _$77Bean get_$77() {
                    return _$77;
                }

                public void set_$77(_$77Bean _$77) {
                    this._$77 = _$77;
                }

                public static class _$77Bean {
                    @SerializedName("344")
                    private String _$344;
                    private String name;

                    public static _$77Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$77Bean.class);
                    }

                    public String get_$344() {
                        return _$344;
                    }

                    public void set_$344(String _$344) {
                        this._$344 = _$344;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }

            public static class GoodsCustomBean {
                @SerializedName("120")
                private _$120Bean _$120;
                @SerializedName("121")
                private _$121Bean _$121;
                @SerializedName("122")
                private _$122Bean _$122;
                @SerializedName("143")
                private _$143Bean _$143;

                public static GoodsCustomBean objectFromData(String str) {

                    return new Gson().fromJson(str, GoodsCustomBean.class);
                }

                public _$120Bean get_$120() {
                    return _$120;
                }

                public void set_$120(_$120Bean _$120) {
                    this._$120 = _$120;
                }

                public _$121Bean get_$121() {
                    return _$121;
                }

                public void set_$121(_$121Bean _$121) {
                    this._$121 = _$121;
                }

                public _$122Bean get_$122() {
                    return _$122;
                }

                public void set_$122(_$122Bean _$122) {
                    this._$122 = _$122;
                }

                public _$143Bean get_$143() {
                    return _$143;
                }

                public void set_$143(_$143Bean _$143) {
                    this._$143 = _$143;
                }

                public static class _$120Bean {
                    private String name;
                    private String value;

                    public static _$120Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$120Bean.class);
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class _$121Bean {
                    private String name;
                    private String value;

                    public static _$121Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$121Bean.class);
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class _$122Bean {
                    private String name;
                    private String value;

                    public static _$122Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$122Bean.class);
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class _$143Bean {
                    private String name;
                    private String value;

                    public static _$143Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$143Bean.class);
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }
            }

            public static class ContractlistBean {
                @SerializedName("1")
                private _$1Bean _$1;
                @SerializedName("2")
                private _$2Bean _$2;
                @SerializedName("3")
                private _$3Bean _$3;
                @SerializedName("4")
                private _$4Bean _$4;

                public static ContractlistBean objectFromData(String str) {

                    return new Gson().fromJson(str, ContractlistBean.class);
                }

                public _$1Bean get_$1() {
                    return _$1;
                }

                public void set_$1(_$1Bean _$1) {
                    this._$1 = _$1;
                }

                public _$2Bean get_$2() {
                    return _$2;
                }

                public void set_$2(_$2Bean _$2) {
                    this._$2 = _$2;
                }

                public _$3Bean get_$3() {
                    return _$3;
                }

                public void set_$3(_$3Bean _$3) {
                    this._$3 = _$3;
                }

                public _$4Bean get_$4() {
                    return _$4;
                }

                public void set_$4(_$4Bean _$4) {
                    this._$4 = _$4;
                }

                public static class _$1Bean {
                    private String cti_id;
                    private String cti_name;
                    private String cti_describe;
                    private String cti_cost;
                    private String cti_icon;
                    private String cti_descurl;
                    private String cti_state;
                    private String cti_sort;
                    private String cti_state_key;
                    private String cti_state_text;
                    private String cti_icon_url;
                    private String cti_icon_url_60;
                    private String cti_state_name;

                    public static _$1Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$1Bean.class);
                    }

                    public String getCti_id() {
                        return cti_id;
                    }

                    public void setCti_id(String cti_id) {
                        this.cti_id = cti_id;
                    }

                    public String getCti_name() {
                        return cti_name;
                    }

                    public void setCti_name(String cti_name) {
                        this.cti_name = cti_name;
                    }

                    public String getCti_describe() {
                        return cti_describe;
                    }

                    public void setCti_describe(String cti_describe) {
                        this.cti_describe = cti_describe;
                    }

                    public String getCti_cost() {
                        return cti_cost;
                    }

                    public void setCti_cost(String cti_cost) {
                        this.cti_cost = cti_cost;
                    }

                    public String getCti_icon() {
                        return cti_icon;
                    }

                    public void setCti_icon(String cti_icon) {
                        this.cti_icon = cti_icon;
                    }

                    public String getCti_descurl() {
                        return cti_descurl;
                    }

                    public void setCti_descurl(String cti_descurl) {
                        this.cti_descurl = cti_descurl;
                    }

                    public String getCti_state() {
                        return cti_state;
                    }

                    public void setCti_state(String cti_state) {
                        this.cti_state = cti_state;
                    }

                    public String getCti_sort() {
                        return cti_sort;
                    }

                    public void setCti_sort(String cti_sort) {
                        this.cti_sort = cti_sort;
                    }

                    public String getCti_state_key() {
                        return cti_state_key;
                    }

                    public void setCti_state_key(String cti_state_key) {
                        this.cti_state_key = cti_state_key;
                    }

                    public String getCti_state_text() {
                        return cti_state_text;
                    }

                    public void setCti_state_text(String cti_state_text) {
                        this.cti_state_text = cti_state_text;
                    }

                    public String getCti_icon_url() {
                        return cti_icon_url;
                    }

                    public void setCti_icon_url(String cti_icon_url) {
                        this.cti_icon_url = cti_icon_url;
                    }

                    public String getCti_icon_url_60() {
                        return cti_icon_url_60;
                    }

                    public void setCti_icon_url_60(String cti_icon_url_60) {
                        this.cti_icon_url_60 = cti_icon_url_60;
                    }

                    public String getCti_state_name() {
                        return cti_state_name;
                    }

                    public void setCti_state_name(String cti_state_name) {
                        this.cti_state_name = cti_state_name;
                    }
                }

                public static class _$2Bean {
                    private String cti_id;
                    private String cti_name;
                    private String cti_describe;
                    private String cti_cost;
                    private String cti_icon;
                    private String cti_descurl;
                    private String cti_state;
                    private String cti_sort;
                    private String cti_state_key;
                    private String cti_state_text;
                    private String cti_icon_url;
                    private String cti_icon_url_60;
                    private String cti_state_name;

                    public static _$2Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$2Bean.class);
                    }

                    public String getCti_id() {
                        return cti_id;
                    }

                    public void setCti_id(String cti_id) {
                        this.cti_id = cti_id;
                    }

                    public String getCti_name() {
                        return cti_name;
                    }

                    public void setCti_name(String cti_name) {
                        this.cti_name = cti_name;
                    }

                    public String getCti_describe() {
                        return cti_describe;
                    }

                    public void setCti_describe(String cti_describe) {
                        this.cti_describe = cti_describe;
                    }

                    public String getCti_cost() {
                        return cti_cost;
                    }

                    public void setCti_cost(String cti_cost) {
                        this.cti_cost = cti_cost;
                    }

                    public String getCti_icon() {
                        return cti_icon;
                    }

                    public void setCti_icon(String cti_icon) {
                        this.cti_icon = cti_icon;
                    }

                    public String getCti_descurl() {
                        return cti_descurl;
                    }

                    public void setCti_descurl(String cti_descurl) {
                        this.cti_descurl = cti_descurl;
                    }

                    public String getCti_state() {
                        return cti_state;
                    }

                    public void setCti_state(String cti_state) {
                        this.cti_state = cti_state;
                    }

                    public String getCti_sort() {
                        return cti_sort;
                    }

                    public void setCti_sort(String cti_sort) {
                        this.cti_sort = cti_sort;
                    }

                    public String getCti_state_key() {
                        return cti_state_key;
                    }

                    public void setCti_state_key(String cti_state_key) {
                        this.cti_state_key = cti_state_key;
                    }

                    public String getCti_state_text() {
                        return cti_state_text;
                    }

                    public void setCti_state_text(String cti_state_text) {
                        this.cti_state_text = cti_state_text;
                    }

                    public String getCti_icon_url() {
                        return cti_icon_url;
                    }

                    public void setCti_icon_url(String cti_icon_url) {
                        this.cti_icon_url = cti_icon_url;
                    }

                    public String getCti_icon_url_60() {
                        return cti_icon_url_60;
                    }

                    public void setCti_icon_url_60(String cti_icon_url_60) {
                        this.cti_icon_url_60 = cti_icon_url_60;
                    }

                    public String getCti_state_name() {
                        return cti_state_name;
                    }

                    public void setCti_state_name(String cti_state_name) {
                        this.cti_state_name = cti_state_name;
                    }
                }

                public static class _$3Bean {
                    private String cti_id;
                    private String cti_name;
                    private String cti_describe;
                    private String cti_cost;
                    private String cti_icon;
                    private String cti_descurl;
                    private String cti_state;
                    private String cti_sort;
                    private String cti_state_key;
                    private String cti_state_text;
                    private String cti_icon_url;
                    private String cti_icon_url_60;
                    private String cti_state_name;

                    public static _$3Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$3Bean.class);
                    }

                    public String getCti_id() {
                        return cti_id;
                    }

                    public void setCti_id(String cti_id) {
                        this.cti_id = cti_id;
                    }

                    public String getCti_name() {
                        return cti_name;
                    }

                    public void setCti_name(String cti_name) {
                        this.cti_name = cti_name;
                    }

                    public String getCti_describe() {
                        return cti_describe;
                    }

                    public void setCti_describe(String cti_describe) {
                        this.cti_describe = cti_describe;
                    }

                    public String getCti_cost() {
                        return cti_cost;
                    }

                    public void setCti_cost(String cti_cost) {
                        this.cti_cost = cti_cost;
                    }

                    public String getCti_icon() {
                        return cti_icon;
                    }

                    public void setCti_icon(String cti_icon) {
                        this.cti_icon = cti_icon;
                    }

                    public String getCti_descurl() {
                        return cti_descurl;
                    }

                    public void setCti_descurl(String cti_descurl) {
                        this.cti_descurl = cti_descurl;
                    }

                    public String getCti_state() {
                        return cti_state;
                    }

                    public void setCti_state(String cti_state) {
                        this.cti_state = cti_state;
                    }

                    public String getCti_sort() {
                        return cti_sort;
                    }

                    public void setCti_sort(String cti_sort) {
                        this.cti_sort = cti_sort;
                    }

                    public String getCti_state_key() {
                        return cti_state_key;
                    }

                    public void setCti_state_key(String cti_state_key) {
                        this.cti_state_key = cti_state_key;
                    }

                    public String getCti_state_text() {
                        return cti_state_text;
                    }

                    public void setCti_state_text(String cti_state_text) {
                        this.cti_state_text = cti_state_text;
                    }

                    public String getCti_icon_url() {
                        return cti_icon_url;
                    }

                    public void setCti_icon_url(String cti_icon_url) {
                        this.cti_icon_url = cti_icon_url;
                    }

                    public String getCti_icon_url_60() {
                        return cti_icon_url_60;
                    }

                    public void setCti_icon_url_60(String cti_icon_url_60) {
                        this.cti_icon_url_60 = cti_icon_url_60;
                    }

                    public String getCti_state_name() {
                        return cti_state_name;
                    }

                    public void setCti_state_name(String cti_state_name) {
                        this.cti_state_name = cti_state_name;
                    }
                }

                public static class _$4Bean {
                    private String cti_id;
                    private String cti_name;
                    private String cti_describe;
                    private String cti_cost;
                    private String cti_icon;
                    private String cti_descurl;
                    private String cti_state;
                    private String cti_sort;
                    private String cti_state_key;
                    private String cti_state_text;
                    private String cti_icon_url;
                    private String cti_icon_url_60;
                    private String cti_state_name;

                    public static _$4Bean objectFromData(String str) {

                        return new Gson().fromJson(str, _$4Bean.class);
                    }

                    public String getCti_id() {
                        return cti_id;
                    }

                    public void setCti_id(String cti_id) {
                        this.cti_id = cti_id;
                    }

                    public String getCti_name() {
                        return cti_name;
                    }

                    public void setCti_name(String cti_name) {
                        this.cti_name = cti_name;
                    }

                    public String getCti_describe() {
                        return cti_describe;
                    }

                    public void setCti_describe(String cti_describe) {
                        this.cti_describe = cti_describe;
                    }

                    public String getCti_cost() {
                        return cti_cost;
                    }

                    public void setCti_cost(String cti_cost) {
                        this.cti_cost = cti_cost;
                    }

                    public String getCti_icon() {
                        return cti_icon;
                    }

                    public void setCti_icon(String cti_icon) {
                        this.cti_icon = cti_icon;
                    }

                    public String getCti_descurl() {
                        return cti_descurl;
                    }

                    public void setCti_descurl(String cti_descurl) {
                        this.cti_descurl = cti_descurl;
                    }

                    public String getCti_state() {
                        return cti_state;
                    }

                    public void setCti_state(String cti_state) {
                        this.cti_state = cti_state;
                    }

                    public String getCti_sort() {
                        return cti_sort;
                    }

                    public void setCti_sort(String cti_sort) {
                        this.cti_sort = cti_sort;
                    }

                    public String getCti_state_key() {
                        return cti_state_key;
                    }

                    public void setCti_state_key(String cti_state_key) {
                        this.cti_state_key = cti_state_key;
                    }

                    public String getCti_state_text() {
                        return cti_state_text;
                    }

                    public void setCti_state_text(String cti_state_text) {
                        this.cti_state_text = cti_state_text;
                    }

                    public String getCti_icon_url() {
                        return cti_icon_url;
                    }

                    public void setCti_icon_url(String cti_icon_url) {
                        this.cti_icon_url = cti_icon_url;
                    }

                    public String getCti_icon_url_60() {
                        return cti_icon_url_60;
                    }

                    public void setCti_icon_url_60(String cti_icon_url_60) {
                        this.cti_icon_url_60 = cti_icon_url_60;
                    }

                    public String getCti_state_name() {
                        return cti_state_name;
                    }

                    public void setCti_state_name(String cti_state_name) {
                        this.cti_state_name = cti_state_name;
                    }
                }
            }
        }

        public static class StoreInfoBean {
            private String store_id;
            private String store_name;
            private String member_id;
            private String member_name;
            private String is_own_shop;
            private String goods_count;
            private StoreCreditBean store_credit;

            public static StoreInfoBean objectFromData(String str) {

                return new Gson().fromJson(str, StoreInfoBean.class);
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public String getMember_name() {
                return member_name;
            }

            public void setMember_name(String member_name) {
                this.member_name = member_name;
            }

            public String getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(String is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public String getGoods_count() {
                return goods_count;
            }

            public void setGoods_count(String goods_count) {
                this.goods_count = goods_count;
            }

            public StoreCreditBean getStore_credit() {
                return store_credit;
            }

            public void setStore_credit(StoreCreditBean store_credit) {
                this.store_credit = store_credit;
            }

            public static class StoreCreditBean {
                private StoreDesccreditBean store_desccredit;
                private StoreServicecreditBean store_servicecredit;
                private StoreDeliverycreditBean store_deliverycredit;

                public static StoreCreditBean objectFromData(String str) {

                    return new Gson().fromJson(str, StoreCreditBean.class);
                }

                public StoreDesccreditBean getStore_desccredit() {
                    return store_desccredit;
                }

                public void setStore_desccredit(StoreDesccreditBean store_desccredit) {
                    this.store_desccredit = store_desccredit;
                }

                public StoreServicecreditBean getStore_servicecredit() {
                    return store_servicecredit;
                }

                public void setStore_servicecredit(StoreServicecreditBean store_servicecredit) {
                    this.store_servicecredit = store_servicecredit;
                }

                public StoreDeliverycreditBean getStore_deliverycredit() {
                    return store_deliverycredit;
                }

                public void setStore_deliverycredit(StoreDeliverycreditBean store_deliverycredit) {
                    this.store_deliverycredit = store_deliverycredit;
                }

                public static class StoreDesccreditBean {
                    private String text;
                    private String credit;
                    private String percent_text;

                    public static StoreDesccreditBean objectFromData(String str) {

                        return new Gson().fromJson(str, StoreDesccreditBean.class);
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public String getCredit() {
                        return credit;
                    }

                    public void setCredit(String credit) {
                        this.credit = credit;
                    }

                    public String getPercent_text() {
                        return percent_text;
                    }

                    public void setPercent_text(String percent_text) {
                        this.percent_text = percent_text;
                    }
                }

                public static class StoreServicecreditBean {
                    private String text;
                    private String credit;
                    private String percent_text;

                    public static StoreServicecreditBean objectFromData(String str) {

                        return new Gson().fromJson(str, StoreServicecreditBean.class);
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public String getCredit() {
                        return credit;
                    }

                    public void setCredit(String credit) {
                        this.credit = credit;
                    }

                    public String getPercent_text() {
                        return percent_text;
                    }

                    public void setPercent_text(String percent_text) {
                        this.percent_text = percent_text;
                    }
                }

                public static class StoreDeliverycreditBean {
                    private String text;
                    private String credit;
                    private String percent_text;

                    public static StoreDeliverycreditBean objectFromData(String str) {

                        return new Gson().fromJson(str, StoreDeliverycreditBean.class);
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public String getCredit() {
                        return credit;
                    }

                    public void setCredit(String credit) {
                        this.credit = credit;
                    }

                    public String getPercent_text() {
                        return percent_text;
                    }

                    public void setPercent_text(String percent_text) {
                        this.percent_text = percent_text;
                    }
                }
            }
        }

        public static class SpecListBean {
            @SerializedName("")
            private String _$76; // FIXME check this code

            public static SpecListBean objectFromData(String str) {

                return new Gson().fromJson(str, SpecListBean.class);
            }

            public String get_$76() {
                return _$76;
            }

            public void set_$76(String _$76) {
                this._$76 = _$76;
            }
        }

        public static class GoodsEvaluateInfoBean {
            private int good;
            private int normal;
            private int bad;
            private int all;
            private int img;
            private int good_percent;
            private int normal_percent;
            private int bad_percent;
            private int good_star;
            private int star_average;

            public static GoodsEvaluateInfoBean objectFromData(String str) {

                return new Gson().fromJson(str, GoodsEvaluateInfoBean.class);
            }

            public int getGood() {
                return good;
            }

            public void setGood(int good) {
                this.good = good;
            }

            public int getNormal() {
                return normal;
            }

            public void setNormal(int normal) {
                this.normal = normal;
            }

            public int getBad() {
                return bad;
            }

            public void setBad(int bad) {
                this.bad = bad;
            }

            public int getAll() {
                return all;
            }

            public void setAll(int all) {
                this.all = all;
            }

            public int getImg() {
                return img;
            }

            public void setImg(int img) {
                this.img = img;
            }

            public int getGood_percent() {
                return good_percent;
            }

            public void setGood_percent(int good_percent) {
                this.good_percent = good_percent;
            }

            public int getNormal_percent() {
                return normal_percent;
            }

            public void setNormal_percent(int normal_percent) {
                this.normal_percent = normal_percent;
            }

            public int getBad_percent() {
                return bad_percent;
            }

            public void setBad_percent(int bad_percent) {
                this.bad_percent = bad_percent;
            }

            public int getGood_star() {
                return good_star;
            }

            public void setGood_star(int good_star) {
                this.good_star = good_star;
            }

            public int getStar_average() {
                return star_average;
            }

            public void setStar_average(int star_average) {
                this.star_average = star_average;
            }
        }

        public static class GoodsHairInfoBean {
            private String content;
            private String if_store_cn;
            private boolean if_store;
            private String area_name;

            public static GoodsHairInfoBean objectFromData(String str) {

                return new Gson().fromJson(str, GoodsHairInfoBean.class);
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getIf_store_cn() {
                return if_store_cn;
            }

            public void setIf_store_cn(String if_store_cn) {
                this.if_store_cn = if_store_cn;
            }

            public boolean isIf_store() {
                return if_store;
            }

            public void setIf_store(boolean if_store) {
                this.if_store = if_store;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }
        }

        public static class ImageListBean {
            private String _small;
            private String _mid;
            private String _big;

            public static ImageListBean objectFromData(String str) {

                return new Gson().fromJson(str, ImageListBean.class);
            }

            public String get_small() {
                return _small;
            }

            public void set_small(String _small) {
                this._small = _small;
            }

            public String get_mid() {
                return _mid;
            }

            public void set_mid(String _mid) {
                this._mid = _mid;
            }

            public String get_big() {
                return _big;
            }

            public void set_big(String _big) {
                this._big = _big;
            }
        }

        public static class GoodsCommendListBean {
            private String goods_id;
            private String goods_name;
            private Object goods_price;
            private String goods_promotion_price;
            private String goods_image_url;

            public static GoodsCommendListBean objectFromData(String str) {

                return new Gson().fromJson(str, GoodsCommendListBean.class);
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public Object getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(Object goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_promotion_price() {
                return goods_promotion_price;
            }

            public void setGoods_promotion_price(String goods_promotion_price) {
                this.goods_promotion_price = goods_promotion_price;
            }

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
            }
        }
    }
}
