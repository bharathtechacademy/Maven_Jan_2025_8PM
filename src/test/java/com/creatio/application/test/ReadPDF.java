package com.creatio.application.test;

import com.creatio.framework.utilities.PDFUtil;

public class ReadPDF {

	public static void main(String[] args) {
		String pdfText = PDFUtil.getText(System.getProperty("user.dir") + "\\Files\\Data.pdf");
		System.out.println(pdfText);
	}

}
