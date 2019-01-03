package com.ck.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;


	@SuppressWarnings("static-access")
	public boolean renderReport(String pathJrxml, String imageName, HashMap<String, Object> params) throws Exception {
		boolean flag = false;
		File file = null;
		FileOutputStream outputStream = null;
		FileInputStream inputStream = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
//		Logger.getLogger(this.getName()).log(Level.SEVERE, null, imageName);
		file = new File(imageName);
		outputStream = new FileOutputStream(file);
		inputStream = new FileInputStream(pathJrxml);
		JasperDesign jDesign = JRXmlLoader.load(inputStream);
		JasperReport jReport = JasperCompileManager.compileReport(jDesign);
		JasperPrint jPrint = JasperFillManager.fillReport(jReport, params, conn);
		DefaultJasperReportsContext.getInstance();
		JasperPrintManager printManager = JasperPrintManager.getInstance(DefaultJasperReportsContext.getInstance());

		BufferedImage rendered_image = null;
		rendered_image = (BufferedImage) printManager.printPageToImage(jPrint, 0, 1.6f);
		ImageIO.write(rendered_image, "png", outputStream);
		flag = true;
		if (conn.isClosed() == false)
			conn.close();
		outputStream.flush();
		outputStream.close();
		return flag;
	}

	public void renderReport() {
		HashMap<String, Object> params = new HashMap<>();
//		params.put("starttime", COMPANY_ID);
//		params.put("endtime", ORIGIN);

		String jrxmlPath1;
		String imagePath1;
		String jrxmlPath2;
		String imagePath2;
		String jrxmlPath3;
		String imagePath3;
		try {
			jrxmlPath1 = this.getClass().getResource("/static/reports").getFile() + "/Report1.jrxml";
			imagePath1 = this.getClass().getResource("/static/reports").getFile() + "/Report1.png";
			renderReport(jrxmlPath1, imagePath1, params);
			
			jrxmlPath2 = this.getClass().getResource("/static/reports").getFile() + "/Report2.jrxml";
			imagePath2 = this.getClass().getResource("/static/reports").getFile() + "/Report2.png";
			renderReport(jrxmlPath2, imagePath2, params);
			
//			jrxmlPath3 = this.getClass().getResource("/static/reports").getFile() + "/Report3.jrxml";
//			imagePath3 = this.getClass().getResource("/static/reports").getFile() + "/Report3.png";
//			renderReport(jrxmlPath3, imagePath3, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
