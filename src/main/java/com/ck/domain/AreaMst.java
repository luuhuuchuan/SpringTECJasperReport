package com.ck.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AreaMst")
public class AreaMst implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CompanyNo", nullable = false)
	private String CompanyNo;

	@Id
	@Column(name = "StoreNo", nullable = false)
	private String StoreNo;

	@Id
	@Column(name = "ReaderNo", nullable = false)
	private String ReaderNo;

	@Column(name = "Area_no", nullable = true)
	private String Area_no;

	@Column(name = "Cut_no", nullable = true)
	private String Cut_no;

	@Column(name = "CommonArea", nullable = true)
	private String CommonArea;

	public String getCompanyNo() {
		return CompanyNo;
	}

	public void setCompanyNo(String companyNo) {
		CompanyNo = companyNo;
	}

	public String getStoreNo() {
		return StoreNo;
	}

	public void setStoreNo(String storeNo) {
		StoreNo = storeNo;
	}

	public String getReaderNo() {
		return ReaderNo;
	}

	public void setReaderNo(String readerNo) {
		ReaderNo = readerNo;
	}

	public String getArea_no() {
		return Area_no;
	}

	public void setArea_no(String area_no) {
		Area_no = area_no;
	}

	public String getCut_no() {
		return Cut_no;
	}

	public void setCut_no(String cut_no) {
		Cut_no = cut_no;
	}

	public String getCommonArea() {
		return CommonArea;
	}

	public void setCommonArea(String commonArea) {
		CommonArea = commonArea;
	}

}
