package com.ck.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_DataMining")
public class DataMining implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "EPC_code", nullable = true)
	private String EPC_code;

	@Column(name = "STimestamp", nullable = true)
	private Date STimestamp;

	@Column(name = "RSSI", nullable = true)
	private int RSSI;

	@Column(name = "アンテナNo", nullable = true)
	private int アンテナNo;

	@Column(name = "Output_level", nullable = true)
	private int Output_level;

	@Column(name = "Freaqency", nullable = true)
	private int Freaqency;

	@Column(name = "Phase", nullable = true)
	private int Phase;

	@Column(name = "Read_time", nullable = true)
	private int Read_time;

	@Column(name = "CompanyNo", nullable = true)
	private String CompanyNo;

	@Column(name = "StoreNo", nullable = true)
	private String StoreNo;

	@Column(name = "ReaderNo", nullable = true)
	private String ReaderNo;

	@Column(name = "Area_no", nullable = true)
	private String Area_no;

	@Column(name = "F_Timestamp", nullable = true)
	private Date F_Timestamp;

	@Column(name = "Jan_code", nullable = true)
	private String Jan_code;

	@Column(name = "Create_date", nullable = true)
	private Date Create_date;

	public String getEPC_code() {
		return EPC_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEPC_code(String ePC_code) {
		EPC_code = ePC_code;
	}

	public Date getSTimestamp() {
		return STimestamp;
	}

	public void setSTimestamp(Date sTimestamp) {
		STimestamp = sTimestamp;
	}

	public int getRSSI() {
		return RSSI;
	}

	public void setRSSI(int rSSI) {
		RSSI = rSSI;
	}

	public int getアンテナNo() {
		return アンテナNo;
	}

	public void setアンテナNo(int アンテナNo) {
		this.アンテナNo = アンテナNo;
	}

	public int getOutput_level() {
		return Output_level;
	}

	public void setOutput_level(int output_level) {
		Output_level = output_level;
	}

	public int getFreaqency() {
		return Freaqency;
	}

	public void setFreaqency(int freaqency) {
		Freaqency = freaqency;
	}

	public int getPhase() {
		return Phase;
	}

	public void setPhase(int phase) {
		Phase = phase;
	}

	public int getRead_time() {
		return Read_time;
	}

	public void setRead_time(int read_time) {
		Read_time = read_time;
	}

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

	public Date getF_Timestamp() {
		return F_Timestamp;
	}

	public void setF_Timestamp(Date f_Timestamp) {
		F_Timestamp = f_Timestamp;
	}

	public String getJan_code() {
		return Jan_code;
	}

	public void setJan_code(String jan_code) {
		Jan_code = jan_code;
	}

	public Date getCreate_date() {
		return Create_date;
	}

	public void setCreate_date(Date create_date) {
		Create_date = create_date;
	}

}
