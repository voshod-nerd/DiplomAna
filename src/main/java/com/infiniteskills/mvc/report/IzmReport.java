/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.report;

import com.infiniteskills.mvc.entity.Bron;
import com.infiniteskills.mvc.entity.Grafik;
import com.infiniteskills.mvc.entity.Hotel;
import com.infiniteskills.mvc.entity.Otpusk;
import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.entity.Sotrudnik;
import com.infiniteskills.mvc.entity.Zayvka;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
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
public class IzmReport {

    public File doReport(List<Bron> bron, List<Progivanie> prog, List<Zayvka> zay, Date beg, Date end) throws IOException {
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/izm.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //�������� ���������� ����� �����
        System.out.println(rows);

        row = sheet.getRow(0);

        cell = row.getCell(5);
        if (cell != null) {

            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date today = beg;
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
            String reportDate = df.format(today);

            cell.setCellValue(reportDate);
        }
        cell = row.getCell(7);
        if (cell != null) {

            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date today = end;
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
            String reportDate = df.format(today);

            cell.setCellValue(reportDate);
        }

        int j = 3;
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                row = sheet.getRow(j);
                cell = row.getCell(2);
                if (cell != null) {
                    cell.setCellValue("������ ��������������� �������");
                }
                j++;
                row = sheet.getRow(j);
                cell = row.getCell(2);
                if (cell != null) {
                    cell.setCellValue("��� �������");

                }
                cell = row.getCell(3);
                if (cell != null) {
                    cell.setCellValue("���� �����");

                }

                cell = row.getCell(4);
                if (cell != null) {
                    cell.setCellValue("�����");

                }
                
                 cell = row.getCell(5);
                if (cell != null) {
                    cell.setCellValue("���������");

                }
                
                
                j++;
                for (Bron br : bron) {
                    row = sheet.getRow(j);
                    cell = row.getCell(2);
                    if (cell != null) {
                        cell.setCellValue(br.getIdclient().getFio());
                    }

                    cell = row.getCell(3);
                    if (cell != null) {
                        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                        Date today = br.getDateb();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                        String reportDate = df.format(today);

                        cell.setCellValue(reportDate);
                    }

                    cell = row.getCell(4);
                    if (cell != null) {
                        cell.setCellValue(br.getIdnomer().getNumber());
                    }
                    
                    
                    cell = row.getCell(5);
                    if (cell != null) {
                        cell.setCellValue(br.getIdnomer().getIdgostin().getName());
                    }
                    
                    
                    j++;
                }

            }
            /// ����������� 

            if (i == 2) {
                row = sheet.getRow(j);
                cell = row.getCell(2);
                if (cell != null) {
                    cell.setCellValue("������ ����������� ��������");
                }
                j++;
                row = sheet.getRow(j);
                cell = row.getCell(2);
                if (cell != null) {
                    cell.setCellValue("��� �������");

                }
                cell = row.getCell(3);
                if (cell != null) {
                    cell.setCellValue("���� ��������");

                }

                cell = row.getCell(4);
                if (cell != null) {
                    cell.setCellValue("�����");

                }
                 cell = row.getCell(5);
                if (cell != null) {
                    cell.setCellValue("���������");

                }
                
                j++;
                for (Progivanie br : prog) {
                    row = sheet.getRow(j);
                    cell = row.getCell(2);
                    if (cell != null) {
                        cell.setCellValue(br.getIdclient().getFio());
                    }

                    cell = row.getCell(3);
                    if (cell != null) {
                        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                        Date today = br.getDatein();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                        String reportDate = df.format(today);

                        cell.setCellValue(reportDate);
                    }

                    cell = row.getCell(4);
                    if (cell != null) {
                        cell.setCellValue(br.getIdnomer().getNumber());
                    }
                    
                    cell = row.getCell(5);
                    if (cell != null) {
                        cell.setCellValue(br.getIdnomer().getIdgostin().getName());
                    }
                    
                    j++;
                }

            }

            /// C����� ������ �� �� ������
            if (i == 3) {
                row = sheet.getRow(j);
                cell = row.getCell(2);
                if (cell != null) {
                    cell.setCellValue("������ ������� ������");
                }
                j++;
                row = sheet.getRow(j);
                cell = row.getCell(2);
                if (cell != null) {
                    cell.setCellValue("��� ����������");

                }
                cell = row.getCell(3);
                if (cell != null) {
                    cell.setCellValue("���� ������");

                }

                cell = row.getCell(4);
                if (cell != null) {
                    cell.setCellValue("��� ������");

                }
                
                 cell = row.getCell(5);
                if (cell != null) {
                    cell.setCellValue("���������");

                }
                
                
                
                j++;
                for (Zayvka br : zay) {
                    row = sheet.getRow(j);
                    cell = row.getCell(2);
                    if (cell != null) {
                        cell.setCellValue(br.getIdsotr().getFio());
                    }

                    cell = row.getCell(3);
                    if (cell != null) {
                        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                        Date today = br.getDatez();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                        String reportDate = df.format(today);

                        cell.setCellValue(reportDate);
                    }

                    cell = row.getCell(4);
                    if (cell != null) {
                        cell.setCellValue(br.getTypez().getName());
                    }
                    
                    cell = row.getCell(5);
                    if (cell != null) {
                        cell.setCellValue(br.getIdnomer().getIdgostin().getName());
                    }
                    
                    j++;
                }

            }
           j++;
        }

        FileOutputStream fileOut = new FileOutputStream("C:/mytemp/output.xls");
        wb.write(fileOut);
        fileOut.close();
       return new File("C:/mytemp/output.xls");
    }
}


