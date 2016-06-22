/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.report;

import com.infiniteskills.mvc.entity.Client;
import com.infiniteskills.mvc.entity.Otpusk;
import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.entity.Reestruslug;
import com.infiniteskills.mvc.entity.Sotrudnik;
import com.infiniteskills.mvc.entity.Stoimostuslug;
import com.infiniteskills.mvc.repository.StoimostUslugRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ������
 */
public class ClientReports {

    private StoimostUslugRepository stoimService;

    @Autowired(required = false)
    public void setServiceStoimUslug(StoimostUslugRepository uService) {
        this.stoimService = uService;
    }

    public File doReport(Progivanie prog, List<Reestruslug> listuslug) throws IOException {

        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/mytemp/client.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);

        // ��� ������ �������� 
        HSSFRow row = null;
        HSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows(); //�������� ���������� ����� �����
        System.out.println(rows);
        for (int r = 0; r < rows; r++) {
            row = sheet.getRow(r); //����� ������
            {
                if (r == 7) {
                    cell = row.getCell(3); //����� ������ ������
                    if (cell != null) {

                        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                        Date today = prog.getDateout();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                        String reportDate = df.format(today);

                        cell.setCellValue(reportDate); //������ �������� ������
                    }

                }

                //////
                if (r == 11) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(prog.getIdnomer().getNumber()); //������ �������� ������
                    }
                }

                if (r == 12) {

                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {
                        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                        Date today = prog.getDateout();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                        String reportDate = df.format(today);

                        cell.setCellValue(reportDate); //������ �������� ������
                    }
                }

                ///
                if (r == 13) {
                    cell = row.getCell(2); //����� ������ ������
                    if (cell != null) {

                        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                        Date today = prog.getDateout();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                        String reportDate = df.format(today);
                        cell.setCellValue(reportDate); //������ �������� ������
                    }
                }

                //
                if (r == 10) {
                    cell = row.getCell(4);
                    if (cell != null) {
                        cell.setCellValue(prog.getIdclient().getFio()); //������ �������� ������
                    }
                }

                ///
                if (r == 11) {
                    cell = row.getCell(4);
                    if (cell != null) {
                        cell.setCellValue(prog.getIdclient().getStrana()); //������ �������� ������
                    }
                }

                if (r == 12) {
                    cell = row.getCell(4);
                    if (cell != null) {
                        cell.setCellValue(prog.getIdclient().getIdorg().getName()); //������ �������� ������
                    }
                }

                if (r == 13) {
                    cell = row.getCell(4);
                    if (cell != null) {
                        cell.setCellValue(prog.getIdclient().getProgclient().getName()); //������ �������� ������
                    }
                }

                ///
                if (r == 18) {
                    cell = row.getCell(1); //����� ������ ������
                    if (cell != null) {

                        Calendar cal1 = new GregorianCalendar();
                        Calendar cal2 = new GregorianCalendar();
                        cal1.setTime(prog.getDateout());
                        cal2.setTime(prog.getDatein());
                        Integer days = (int) ((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                        cell.setCellValue(days.toString()); //������ �������� ������
                    }
                }

                ///
                if (r == 19) {
                    cell = row.getCell(3); //����� ������ ������
                    if (cell != null) {
                        cell.setCellValue(prog.getIdstoimostnomer().getSumma().floatValue()); //������ �������� ������
                    }
                }
                if (r == 19) {
                    cell = row.getCell(4); //����� ������ ������
                    if (cell != null) {
                        Calendar cal1 = new GregorianCalendar();
                        Calendar cal2 = new GregorianCalendar();
                        cal1.setTime(prog.getDateout());
                        cal2.setTime(prog.getDatein());
                        Integer days = (int) ((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                        cell.setCellValue(prog.getIdstoimostnomer().getSumma().floatValue() * days); //������ �������� ������
                    }
                }
                if (r == 23) {
                    cell = row.getCell(3); //����� ������ ������
                    if (cell != null) {
                        Calendar cal1 = new GregorianCalendar();
                        Calendar cal2 = new GregorianCalendar();
                        cal1.setTime(prog.getDateout());
                        cal2.setTime(prog.getDatein());
                        Integer days = (int) ((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                        cell.setCellValue(prog.getIdstoimostnomer().getSumma().floatValue() * days); //������ �������� ������
                    }
                }

            }
        }

        // ���  ������ ��������
        if (prog.getIdstoimostpit() != null) {
            sheet = wb.getSheetAt(1);
            row = null;
            cell = null;
            rows = sheet.getPhysicalNumberOfRows(); //�������� ���������� ����� �����
            System.out.println(rows);
            for (int r = 0; r < rows; r++) {
                row = sheet.getRow(r); //����� ������
                {
                    if (r == 7) {
                        cell = row.getCell(3); //����� ������ ������
                        if (cell != null) {

                            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                            Date today = prog.getDateout();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                            String reportDate = df.format(today);

                            cell.setCellValue(reportDate); //������ �������� ������
                        }

                    }
                    //////

                    if (r == 11) {
                        cell = row.getCell(2); //����� ������ ������
                        if (cell != null) {
                            cell.setCellValue(prog.getIdnomer().getNumber()); //������ �������� ������
                        }
                    }

                    if (r == 12) {

                        cell = row.getCell(2); //����� ������ ������
                        if (cell != null) {
                            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                            Date today = prog.getDatein();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                            String reportDate = df.format(today);

                            cell.setCellValue(reportDate); //������ �������� ������
                        }
                    }
                    ///

                    if (r == 13) {
                        cell = row.getCell(2); //����� ������ ������
                        if (cell != null) {

                            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                            Date today = prog.getDateout();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                            String reportDate = df.format(today);
                            cell.setCellValue(reportDate); //������ �������� ������
                        }
                    }

                    //
                    if (r == 10) {
                        cell = row.getCell(4);
                        if (cell != null) {
                            cell.setCellValue(prog.getIdclient().getFio()); //������ �������� ������
                        }
                    }

                    ///
                    if (r == 11) {
                        cell = row.getCell(4);
                        if (cell != null) {
                            cell.setCellValue(prog.getIdclient().getStrana()); //������ �������� ������
                        }
                    }

                    if (r == 12) {
                        cell = row.getCell(4);
                        if (cell != null) {
                            cell.setCellValue(prog.getIdclient().getIdorg().getName()); //������ �������� ������
                        }
                    }

                    if (r == 13) {
                        cell = row.getCell(4);
                        if (cell != null) {
                            cell.setCellValue(prog.getIdclient().getProgclient().getName()); //������ �������� ������
                        }
                    }

                    ///
                    if (r == 18) {
                        cell = row.getCell(1); //����� ������ ������
                        if (cell != null) {

                            Calendar cal1 = new GregorianCalendar();
                            Calendar cal2 = new GregorianCalendar();
                            cal1.setTime(prog.getDateout());
                            cal2.setTime(prog.getDatein());
                            Integer days = (int) ((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                            cell.setCellValue(days.toString()); //������ �������� ������
                        }
                    }

                    ///
                    if (r == 19) {
                        cell = row.getCell(3); //����� ������ ������
                        if (cell != null) {
                            cell.setCellValue(prog.getIdstoimostpit().getIdpitanie().getName()); //������ �������� ������
                        }
                    }

                    if (r == 20) {
                        cell = row.getCell(3); //����� ������ ������
                        if (cell != null) {

                            cell.setCellValue(prog.getIdstoimostpit().getSum().floatValue()); //������ �������� ������
                        }
                    }

                    if (r == 21) {
                        cell = row.getCell(3); //����� ������ ������
                        if (cell != null) {
                            Calendar cal1 = new GregorianCalendar();
                            Calendar cal2 = new GregorianCalendar();
                            cal1.setTime(prog.getDateout());
                            cal2.setTime(prog.getDatein());
                            Integer days = (int) ((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                            cell.setCellValue(prog.getIdstoimostpit().getSum().floatValue() * days); //������ �������� ������
                        }
                    }
                }
            }
        }

        // ��� ������ ��������
        if (listuslug != null) {
            sheet = wb.getSheetAt(2);
            row = null;
            cell = null;
            rows = sheet.getPhysicalNumberOfRows(); //�������� ���������� ����� �����
            System.out.println(rows);
            for (int r = 0; r < rows; r++) {
                row = sheet.getRow(r); //����� ������
                {
                    if (r == 7) {
                        cell = row.getCell(3); //����� ������ ������
                        if (cell != null) {
                            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                            Date today = prog.getDateout();

                            String reportDate = df.format(today);

                            cell.setCellValue(reportDate); //������ �������� ������
                        }

                    }
                    //////

                    if (r == 11) {
                        cell = row.getCell(2); //����� ������ ������
                        if (cell != null) {
                            cell.setCellValue(prog.getIdnomer().getNumber()); //������ �������� ������
                        }
                    }

                    if (r == 12) {

                        cell = row.getCell(2); //����� ������ ������
                        if (cell != null) {
                            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                            Date today = prog.getDatein();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                            String reportDate = df.format(today);

                            cell.setCellValue(reportDate); //������ �������� ������
                        }
                    }
                    ///

                    if (r == 13) {
                        cell = row.getCell(2); //����� ������ ������
                        if (cell != null) {

                            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                            Date today = prog.getDateout();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
                            String reportDate = df.format(today);
                            cell.setCellValue(reportDate); //������ �������� ������
                        }
                    }

                    //
                    if (r == 10) {
                        cell = row.getCell(4);
                        if (cell != null) {
                            cell.setCellValue(prog.getIdclient().getFio()); //������ �������� ������
                        }
                    }

                    ///
                    if (r == 11) {
                        cell = row.getCell(4);
                        if (cell != null) {
                            cell.setCellValue(prog.getIdclient().getStrana()); //������ �������� ������
                        }
                    }

                    if (r == 12) {
                        cell = row.getCell(4);
                        if (cell != null) {
                            cell.setCellValue(prog.getIdclient().getIdorg().getName()); //������ �������� ������
                        }
                    }

                    if (r == 13) {
                        cell = row.getCell(4);
                        if (cell != null) {
                            cell.setCellValue(prog.getIdclient().getProgclient().getName()); //������ �������� ������
                        }
                    }

                    ///
                    if (r == 18) {
                        cell = row.getCell(1); //����� ������ ������
                        if (cell != null) {

                            Calendar cal1 = new GregorianCalendar();
                            Calendar cal2 = new GregorianCalendar();
                            cal1.setTime(prog.getDateout());
                            cal2.setTime(prog.getDatein());
                            Integer days = (int) ((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                            cell.setCellValue(days.toString()); //������ �������� ������
                        }
                    }

                    if (r == 19) {
                        BigDecimal total = new BigDecimal(0.0);
                        int j = r;
                        for (Reestruslug ot : listuslug) {

                            cell = row.getCell(2); //����� ������ ������
                            if (cell != null) {
                                cell.setCellValue(ot.getIduslug().getName()); //������ �������� ������
                            }
                            System.out.println(ot.getIduslug().getName());
                            cell = row.getCell(3); //����� ������ ������
                            if (cell != null) {
                                Stoimostuslug temp = stoimService.getStoimUslugByClientAndIdUslug(ot.getIduslug(), prog.getIdclient());
                                if (temp == null) {
                                    break;
                                }
                                total = total.add(temp.getSumma());
                                cell.setCellValue(temp.getSumma().floatValue()); //������ �������� ������
                            }

                            j = j + 1;
                            row = sheet.getRow(j);
                        }
                        row = sheet.getRow(j);
                        cell = row.getCell(2);
                        cell.setCellValue("TOTAL");
                        cell = row.getCell(3);
                        cell.setCellValue(total.floatValue());
                        break;
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
