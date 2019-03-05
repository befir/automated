package common;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ServiceTestFactory {
    public static Object[] generate(List<ServiceCase> serviceCaseList){
        List<Object> serviceTests = new ArrayList<Object>();
        for(ServiceCase serviceCase:serviceCaseList){
            serviceTests.add(new RestfulAutomatedTest(serviceCase));
        }
        return serviceTests.toArray();
    }
    public static List<ServiceCase> loadCaseFromExcel(String fileName) throws Exception {
        //File excelFile = new File(fileName); // 创建文件对象
        InputStream in = ClassLoader.getSystemResourceAsStream(fileName); // 文件流
        Workbook workbook = new XSSFWorkbook(in);
        Sheet sheet = workbook.getSheetAt(0);

        int rowNum = sheet.getLastRowNum();
        Row row;
        List<ServiceCase> serviceCaseList = new ArrayList<ServiceCase>();
        for(int i=1;i<=rowNum;i++){
            row = sheet.getRow(i);
            ServiceCase serviceCase = new ServiceCase();
            serviceCase.setServiceType(row.getCell(0).getStringCellValue());
            serviceCase.setRequestMethod(row.getCell(1).getStringCellValue());
            serviceCase.setContentType(row.getCell(2).getStringCellValue());
            serviceCase.setBaseUrl(row.getCell(3).getStringCellValue());
            serviceCase.setServiceUrl(row.getCell(4).getStringCellValue());
            serviceCase.setInput(row.getCell(5).getStringCellValue());
            serviceCase.setExpectOutput(row.getCell(6).getStringCellValue());
            serviceCaseList.add(serviceCase);
        }
        return serviceCaseList;
    }
}
