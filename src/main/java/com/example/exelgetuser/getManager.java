package com.example.exelgetuser;

import com.example.basicLayout.Manager;
import com.example.basicLayout.Teacher;
import com.example.jdbc.IloginDao;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class getManager {
    public static void getManger(String path) {
        try {
            FileInputStream fip = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(fip);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row = null;
            int n = sheet.getPhysicalNumberOfRows();
            for(int i=1;i<n;i++){
                row = sheet.getRow(i);
                String account = row.getCell(1).getStringCellValue();
                String password = row.getCell(2).getStringCellValue();
                Manager managers = new Manager(account,password);
                ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
                IloginDao logDao = ac.getBean("loginDao",IloginDao.class);
                logDao.updateManager(managers);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
