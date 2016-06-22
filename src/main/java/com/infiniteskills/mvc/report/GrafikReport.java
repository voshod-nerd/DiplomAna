/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.report;

import com.infiniteskills.mvc.entity.Grafik;
import com.infiniteskills.mvc.entity.Hotel;
import com.infiniteskills.mvc.entity.Otpusk;
import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.entity.Sotrudnik;
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
public class GrafikReport {

    public File doReport(List<Grafik> grafik, List<Hotel> hotels, int month) throws IOException {

        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/grafik.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //�������� ���������� ����� �����
        System.out.println(rows);

        String mon;
        mon="";
        if (month == 1) {
            mon = "������";
        }
        if (month == 2) {
            mon = "�������";
        }
        if (month == 3) {
            mon = "����";
        }
        if (month == 4) {
            mon = "������";
        }
        if (month == 5) {
            mon = "���";
        }
        if (month == 6) {
            mon = "����";
        }
        if (month == 7) {
            mon = "����";
        }
        if (month == 8) {
            mon = "������";
        }

        if (month == 9) {
            mon = "�������";
        }
        if (month == 10) {
            mon = "������";
        }
        if (month == 11) {
            mon = "�����";
        }
        if (month == 12) {
            mon = "�������";
        }
        
        row = sheet.getRow(1);
        cell = row.getCell(17);
            if (cell != null) {
                cell.setCellValue(mon);
            }
        

        int r = 4;
        for (Hotel hotel : hotels) {
            row = sheet.getRow(r); //����� ������
            cell = row.getCell(0);
            if (cell != null) {
                cell.setCellValue(hotel.getName());
            }
            // �������� ���� ����������� ����
            HashSet<String> hsot = new HashSet<String>();
            for (Grafik gr : grafik) {

                System.out.println("-----");
                System.out.println(gr.getIdhotel().getName());
                System.out.println("+");
                System.out.println(hotel.getName());
                if (gr.getIdhotel().getName().equals(hotel.getName())) {
                    System.out.println("�����");
                    if (hsot.contains(gr.getIdsotrudnik().getFio())) {
                    } else {
                        System.out.println(gr.getIdsotrudnik().getFio());
                        hsot.add(gr.getIdsotrudnik().getFio());
                    }
                }
            }
            // ��������
            for (String sotr : hsot) {

                cell = row.getCell(1);
                if (cell != null) {
                    cell.setCellValue(sotr);
                }
                // �������� ���� 
                for (int j = 0; j < 30; j++) {
                    for (Grafik gr : grafik) {
                        {
                           // String fio = gr.getIdsotrudnik().getFio();
                            //String fio1=sotr;
                           // if (sotr.compareTo(fio) == 1) {
                           //     cell = row.getCell(1);
                          //      if (cell != null) {
                          //          cell.setCellValue(sotr);
                          //      }
                          //  }

                            if (sotr.contains(gr.getIdsotrudnik().getFio())) {

                                Calendar cal = Calendar.getInstance();
                                cal.setTime(gr.getDayd());
                                cal.set(Calendar.HOUR_OF_DAY, 0);
                                cal.set(Calendar.MINUTE, 0);
                                cal.set(Calendar.SECOND, 0);
                                cal.set(Calendar.MILLISECOND, 0);

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), j, 0, 0, 0);
                                calendar.set(Calendar.HOUR_OF_DAY, 0);
                                calendar.set(Calendar.MINUTE, 0);
                                calendar.set(Calendar.SECOND, 0);
                                calendar.set(Calendar.MILLISECOND, 0);

                                System.out.println(calendar.getTimeInMillis());
                                System.out.println(cal.getTimeInMillis());
                                System.out.println(calendar.getTimeInMillis()-cal.getTimeInMillis());
                                if (calendar.equals(cal)) {
                                    cell = row.getCell(1 + j);
                                    if (cell != null) {
                                        cell.setCellValue("14");
                                    }
                                    cell = row.getCell(1 + 1 + j);
                                    if (cell != null) {
                                        cell.setCellValue("8");
                                    }

                                }

                            }
                        }
                    }

                }
                r++;
            }
            r++;
        }

        FileOutputStream fileOut = new FileOutputStream("C:/mytemp/output.xls");
        wb.write(fileOut);
        fileOut.close();

        return new File("C:/mytemp/output.xls");
    }
}
