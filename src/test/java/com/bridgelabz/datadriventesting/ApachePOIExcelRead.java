package com.bridgelabz.datadriventesting;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ApachePOIExcelRead {

    private static final String fileName = "/home/admin1/Documents/PrajktaRaut/SeleniumDemo/MyFirstExcel.xlsx";

    public static void main(String[] args) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(fileName));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet dataTypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = dataTypeSheet.iterator();
            while (iterator.hasNext())
            {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext())
                {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellTypeEnum() == CellType.STRING)
                    {
                        System.out.println(currentCell.getStringCellValue()+"--");
                    }
                    else if (currentCell.getCellTypeEnum() == CellType.NUMERIC)
                    {
                        System.out.println(currentCell.getNumericCellValue() +"--");
                    }
                }
                System.out.println();
                    
                }
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

