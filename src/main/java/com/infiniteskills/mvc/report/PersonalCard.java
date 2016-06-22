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
public class PersonalCard {

    public File doReport(Sotrudnik sotr, List<Otpusk> otpusk) throws IOException {

        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/personalcard.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //получаем актуальное число строк
        System.out.println(rows);
        for (int r = 0; r < 19; r++) {

            row = sheet.getRow(r); //берем строку
            {
                if (r == 1) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getIddolgnost().getDolgnost()); //задаем значение €чейки
                    }

                }

                if (r == 2) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getFio()); //задаем значение €чейки
                    }
                }

                if (r == 3) {
                  
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getDr().toString()); //задаем значение €чейки
                    }
                }
                if (r == 4) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getMr()); //задаем значение €чейки
                    }
                }

                if (r == 5) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getDoclich()); //задаем значение €чейки
                    }
                }

                if (r == 6) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getNum() + " " + sotr.getSer()); //задаем значение €чейки
                    }
                }
                if (r == 7) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getKogdavidan().toString()); //задаем значение €чейки
                    }
                }
                if (r == 8) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getKemvidan()); //задаем значение €чейки
                    }
                }
                if (r == 9) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getAdres()); //задаем значение €чейки
                    }
                }

                if (r == 10) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getPhone()); //задаем значение €чейки
                    }
                }

                if (r == 11) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getEducation()); //задаем значение €чейки
                    }
                }

                if (r == 12) {
                    cell = row.getCell(2); //берем первую €чейку
                    if (cell != null) {
                        cell.setCellValue(sotr.getKoldet()); //задаем значение €чейки
                    }
                }

                if (r == 13) {
                    for (Otpusk ot : otpusk) {
                        cell = row.getCell(2); //берем первую €чейку
                        if (cell != null) {
                            cell.setCellValue(ot.getDateb() + " по  " + ot.getDateend()); //задаем значение €чейки
                        }
                      row = sheet.getRow(r++);
                    }
                   break;
                }

            }
        }
            FileOutputStream fileOut = new FileOutputStream("C:/mytemp/output.xls");
            wb.write(fileOut);
            fileOut.close();

            return new File("C:/mytemp/output.xls");
        }
    }
