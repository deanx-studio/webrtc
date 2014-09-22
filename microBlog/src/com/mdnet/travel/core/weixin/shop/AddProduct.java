package com.mdnet.travel.core.weixin.shop;

import com.google.gson.Gson;

public class AddProduct {

	private ProductBase product_base;
	private ProductProperty[] property;
	private String name;// ": "testaddproduct",
	private SkuInfo[] sku_info;
	private String main_img;// ": "http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjD3ulEKogfsiaua49pvLfUS8Ym0GSYjViaLic0FD3vN0V8PILcibEGb2fPfEOmw/0",
	private String[] img;
	private ProductDetail[] detail;
	private int buy_limit;
	private Skus[] sku_list;
	private Attrext attrext;
	private DeliveryInfo delivery_info;

	public ProductBase getProduct_base() {
		return product_base;
	}

	public void setProduct_base(ProductBase product_base) {
		this.product_base = product_base;
	}

	public ProductProperty[] getProperty() {
		return property;
	}

	public void setProperty(ProductProperty[] property) {
		this.property = property;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SkuInfo[] getSku_info() {
		return sku_info;
	}

	public void setSku_info(SkuInfo[] sku_info) {
		this.sku_info = sku_info;
	}

	public String getMain_img() {
		return main_img;
	}

	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}

	public String[] getImg() {
		return img;
	}

	public void setImg(String[] img) {
		this.img = img;
	}

	public ProductDetail[] getDetail() {
		return detail;
	}

	public void setDetail(ProductDetail[] detail) {
		this.detail = detail;
	}

	public int getBuy_limit() {
		return buy_limit;
	}

	public void setBuy_limit(int buy_limit) {
		this.buy_limit = buy_limit;
	}

	public Skus[] getSku_list() {
		return sku_list;
	}

	public void setSku_list(Skus[] sku_list) {
		this.sku_list = sku_list;
	}

	public Attrext getAttrext() {
		return attrext;
	}

	public void setAttrext(Attrext attrext) {
		this.attrext = attrext;
	}

	public DeliveryInfo getDelivery_info() {
		return delivery_info;
	}

	public void setDelivery_info(DeliveryInfo delivery_info) {
		this.delivery_info = delivery_info;
	}
	
	public String toJson()
	{
		Gson g = new Gson();
		return g.toJson(this);
	}
}
