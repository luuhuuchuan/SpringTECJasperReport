package com.ck.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GoodsMst")
public class GoodsMst implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Jan_code", nullable = false)
	private String Jan_code;

	@Column(name = "Goods_name", nullable = true)
	private String Goods_name;

	public String getJan_code() {
		return Jan_code;
	}

	public void setJan_code(String jan_code) {
		Jan_code = jan_code;
	}

	public String getGoods_name() {
		return Goods_name;
	}

	public void setGoods_name(String goods_name) {
		Goods_name = goods_name;
	}

}
