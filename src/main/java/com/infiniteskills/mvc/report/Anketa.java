/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.report;
import com.infiniteskills.mvc.entity.Otpusk;
import com.infiniteskills.mvc.entity.Progivanie;
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
public class Anketa {
public File doReport(Progivanie progiv) throws IOException {

        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/ancet.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //получаем актуальное число строк
        System.out.println(rows);
        for (int r = 0; r < rows; r++) {

            row = sheet.getRow(r); //берем строку
            {
                if (r == 2) {
                    cell = row.getCell(3); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdclient().getFio()); //задаем значение €чейки
                    }

                }

                if (r == 2) {
                    cell = row.getCell(8); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdnomer().getIdgostin().getName()); //задаем значение €чейки
                    }
                }

                if (r == 3) {
                    
                    cell = row.getCell(3); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdclient().getFioeng()); //задаем значение €чейки
                    }
                }
                if (r == 3) {
                    cell = row.getCell(8); //берем первую €чейку
                    if (cell != null) {
                         DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                            Date today =  progiv.getDatein();
                            String reportDate = df.format(today);
                        
                        
                        cell.setCellValue(reportDate); //задаем значение €чейки
                    }
                }

                if (r == 4) {
                    cell = row.getCell(8); //берем первую €чейку
                    if (cell != null) {
                        
                          DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                            Date today =  progiv.getDateout();
                            String reportDate = df.format(today);
                        
                        cell.setCellValue(reportDate); //задаем значение €чейки
                    }
                }

                if (r == 5) {
                    cell = row.getCell(3); //берем первую €чейку
                    if (cell != null) {
                        
                         DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                            Date today =  progiv.getIdclient().getDr();
                            String reportDate = df.format(today);
                        
                        cell.setCellValue(reportDate); //задаем значение €чейки
                    }
                }
                
                if (r == 6) {
                    cell = row.getCell(3); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdclient().getStrana()); //задаем значение €чейки
                    }
                }
                if (r == 7) {
                    cell = row.getCell(5); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdclient().getViddock()); //задаем значение €чейки
                    }
                }
                if (r == 8) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdclient().getSerdoc()); //задаем значение €чейки
                    }
                }

                if (r == 9) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdclient().getNumberdoc()); //задаем значение €чейки
                    }
                }

                if (r == 10) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdclient().getKemvidan()); //задаем значение €чейки
                    }
                }

                if (r == 12) {
                    cell = row.getCell(4); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(progiv.getIdclient().getAdres()); //задаем значение €чейки
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
