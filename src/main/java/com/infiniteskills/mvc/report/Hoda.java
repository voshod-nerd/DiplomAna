/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.report;

import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.entity.Zayvka;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author јндрей
 */
public class Hoda {

    public File doReport(List<Progivanie> list) throws IOException {
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/hoda.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //получаем актуальное число строк
        System.out.println(rows);
        int j = 11;
        for (Progivanie x : list) {
            row = sheet.getRow(j);
             cell = row.getCell(1); //берем первую €чейку
            if (cell != null) {
                cell.setCellValue(j-10); //задаем значение €чейки
            }
            

            cell = row.getCell(2); //берем первую €чейку
            if (cell != null) {
                cell.setCellValue(x.getIdclient().getFio()); //задаем значение €чейки
            }
            cell = row.getCell(4); //берем первую €чейку
            if (cell != null) {
                cell.setCellValue(x.getIdclient().getStrana()); //задаем значение €чейки
            }
            cell = row.getCell(5); //берем первую €чейку
            if (cell != null) {
                cell.setCellValue(x.getIdclient().getSerdoc()); //задаем значение €чейки
            }
            cell = row.getCell(6); //берем первую €чейку
            if (cell != null) {
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                Date today = x.getIdclient().getDr();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                String reportDate = df.format(today);

                cell.setCellValue(reportDate); //задаем значение €чейки
            }
           
            
            cell = row.getCell(7); //берем первую €чейку
            if (cell != null) {

                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                Date today = x.getDateout();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                String reportDate = df.format(today);

                cell.setCellValue(reportDate); //задаем значение €чейки
            }
            cell = row.getCell(8); //берем первую €чейку
            if (cell != null) {
                cell.setCellValue(x.getIdnomer().getIdgostin().getName()); //задаем значение €чейки
            }

           
            j++;

        }

        FileOutputStream fileOut = new FileOutputStream("C:/mytemp/output.xls");
        wb.write(fileOut);
        fileOut.close();

        return new File("C:/mytemp/output.xls");
    }
}
