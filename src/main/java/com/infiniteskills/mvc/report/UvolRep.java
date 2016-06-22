/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.report;

import com.infiniteskills.mvc.entity.Otpusk;
import com.infiniteskills.mvc.entity.Sotrudnik;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

/**
 *
 * @author ќлег
 */
public class UvolRep {

    public File doReport(Sotrudnik sotr) throws IOException {

        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/uvol.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //получаем актуальное число строк
        System.out.println(rows);
         System.out.println(sotr.getFio());
        for (int r = 0; r < rows; r++) {
            System.out.println(sotr.getFio());
            row = sheet.getRow(r); //берем строку
            {
                if (r == 4) {
                    cell = row.getCell(6); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getFio()); //задаем значение €чейки
                    }

                }
                

                if (r == 18) {
                    cell = row.getCell(6); //берем первую €чейку
                    if (cell != null) {
                        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                        Date today = new Date();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                        String reportDate = df.format(today);

                        cell.setCellValue(reportDate); //задаем значение €чейки
                    }
                }
            }
        }
        FileOutputStream fileOut = new FileOutputStream("C:/mytemp/output.xls");
        wb.write(fileOut);
        fileOut.close();

        return new File("C:/mytemp/output.xls");
    }
}
