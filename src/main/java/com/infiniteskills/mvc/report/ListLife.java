/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.report;

import com.infiniteskills.mvc.entity.Bron;
import com.infiniteskills.mvc.entity.Nomerhotel;
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
public class ListLife {

    public File doReport(List<Progivanie> list, List<Bron> bron, List<Nomerhotel> nomers) throws IOException 
    {
        System.out.println("Formint Excel");
       // System.out.println(list.size());
         System.out.println(bron.size());
          System.out.println(nomers.size());
        
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/listlife.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //получаем актуальное число строк
        System.out.println(rows);
        int kolprog = 0;
        int kolbron=0;
        for (int r = 0; r < rows; r++) {

            row = sheet.getRow(r); //берем строку
            {
                if (r == 1) {
                    cell = row.getCell(3);
                    if (cell != null) {
                        if (nomers==null){ cell.setCellValue("");} else 
                        cell.setCellValue(nomers.get(nomers.size()-1).getIdgostin().getName()); //задаем значение €чейки
                    }

                }
                
                if (r == 2) {
                    cell = row.getCell(3);
                    if (cell != null) {
                        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                            Date today = new Date();
                            String reportDate = df.format(today);
                        cell.setCellValue(reportDate); //задаем значение €чейки
                    }

                }
                

                if (r == 5) {
                    int j = 5;
                    for (Nomerhotel x : nomers) {
                        cell = row.getCell(1);
                        if (cell != null) {
                            cell.setCellValue(x.getNumber()); //задаем значение €чейки
                        }
                        
                        if (!(list==null)) {  
                        for (Progivanie pr : list) {
                            System.out.println(pr.getIdclient().getFio());
                            if (pr.getIdnomer().getId().toString().compareTo(x.getId().toString())==1) {
                                kolprog++;
                                cell = row.getCell(2); //берем первую €чейку
                                if (cell != null) {
                                    cell.setCellValue(pr.getIdclient().getFio()); //задаем значение €чейки
                                }
                            }
                        }
                        }
                           
                        if (!(bron==null)) {
                            for (Bron br : bron) {
                                if (br.getIdnomer().getId().toString().compareTo(x.getId().toString()) == 1) {
                                   kolbron++;
                                    cell = row.getCell(2); //берем первую €чейку
                                    if (cell != null) {
                                        cell.setCellValue("«абронирован: "+br.getIdclient().getFio()); //задаем значение €чейки
                                    }
                                }

                            }
                           
                        }
                        
                        
                            // конец foreach
                            j++;
                            row = sheet.getRow(j);
                        }
                        j++;
                        row = sheet.getRow(j);
                        cell = row.getCell(1);
                        if (cell != null) {
                            cell.setCellValue("—вободных номеров"); //задаем значение €чейки
                        }
                        cell = row.getCell(2);
                        if (cell != null) {
                            cell.setCellValue(nomers.size() - kolprog-kolbron); //задаем значение €чейки
                        }
                        j++;
                        ///
                        row = sheet.getRow(j);
                        cell = row.getCell(1);
                        if (cell != null) {
                            cell.setCellValue("«аселенных номеров"); //задаем значение €чейки
                        }
                        cell = row.getCell(2);
                        if (cell != null) {
                            cell.setCellValue(kolprog); //задаем значение €чейки
                        }
                        j++;
                         //
                        row = sheet.getRow(j);
                        cell = row.getCell(1);
                        if (cell != null) {
                            cell.setCellValue("«абронированных номеров"); //задаем значение €чейки
                        }
                        cell = row.getCell(2);
                        if (cell != null) {
                            cell.setCellValue(bron.size()); //задаем значение €чейки
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

