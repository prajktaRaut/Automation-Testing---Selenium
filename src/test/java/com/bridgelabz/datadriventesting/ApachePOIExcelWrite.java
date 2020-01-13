package com.bridgelabz.datadriventesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOIExcelWrite {
    private static final String fileName = "/home/admin1/Documents/PrajktaRaut/SeleniumDemo/MyFirstExcel.xlsx";

    public static void main(String[] args) {

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet("DataType in Java");
        Object[][] datatypes = {
                {"DataType","Type","Size(ibn byte)"},
                {"int","Primitive","2"},
                {"float","Primitive","4"},
                {"double","primitive","8"},
                {"char","Primitive","1"},
                {"String","Non-primitive","No fixed size"}
        };

        int rowNum = 0;
        System.out.println("Creating xcel file");

        for (Object[] datatype: datatypes
        ) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field:datatype
            ) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String)
                {
                    cell.setCellValue((String) field);
                }
                else if (field instanceof Integer)
                {
                    cell.setCellValue((Integer)field);
                }
            }
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            xssfWorkbook.write(fileOutputStream);
            xssfWorkbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
