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
 * @author ����
 */
public class PersonalCard {

    public File doReport(Sotrudnik sotr, List<Otpusk> otpusk) throws IOException {

        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/personalcard.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //�������� ���������� ����� �����
        System.out.println(rows);
        for (int r = 0; r < 19; r++) {

            row = sheet.getRow(r); //����� ������
            {
                if (r == 1) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getIddolgnost().getDolgnost()); //������ �������� ������
                    }

                }

                if (r == 2) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getFio()); //������ �������� ������
                    }
                }

                if (r == 3) {
                  
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getDr().toString()); //������ �������� ������
                    }
                }
                if (r == 4) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getMr()); //������ �������� ������
                    }
                }

                if (r == 5) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getDoclich()); //������ �������� ������
                    }
                }

                if (r == 6) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getNum() + " " + sotr.getSer()); //������ �������� ������
                    }
                }
                if (r == 7) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getKogdavidan().toString()); //������ �������� ������
                    }
                }
                if (r == 8) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getKemvidan()); //������ �������� ������
                    }
                }
                if (r == 9) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getAdres()); //������ �������� ������
                    }
                }

                if (r == 10) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getPhone()); //������ �������� ������
                    }
                }

                if (r == 11) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getEducation()); //������ �������� ������
                    }
                }

                if (r == 12) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(sotr.getKoldet()); //������ �������� ������
                    }
                }

                if (r == 13) {
                    for (Otpusk ot : otpusk) {
                        cell = row.getCell(2); //����� ������ ������
                        if (cell != null) {
                            cell.setCellValue(ot.getDateb() + " ��  " + ot.getDateend()); //������ �������� ������
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
