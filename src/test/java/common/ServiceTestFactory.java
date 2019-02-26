package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ServiceTestFactory {
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(new InputStreamReader(SoaAutomatedTest.class.getResourceAsStream("/soa_properties.properties"),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object[] generate(List<ServiceCase> serviceCaseList){
        List<Object> serviceTests = new ArrayList<Object>();
        for(ServiceCase serviceCase:serviceCaseList){
            if("restful".equals(serviceCase.getServiceType())){
                serviceTests.add(new RestfulTest(serviceCase));
            }else if("soa".equals(serviceCase.getServiceType())){
                serviceTests.add(new SoaTest(serviceCase));
            }

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
        row = sheet.getRow(0);
        if("serviceUrl".equals(row.getCell(0).getStringCellValue())){
            for(int i=1;i<=rowNum;i++){
                ServiceCase serviceCase = new ServiceCase();
                serviceCase.setServiceType("restful");
                row = sheet.getRow(i);
                serviceCase.setServiceUrl(row.getCell(0).getStringCellValue());
                serviceCase.setInput(row.getCell(1).getStringCellValue());
                serviceCase.setExpectOutput(row.getCell(2).getStringCellValue());
                serviceCaseList.add(serviceCase);
            }
        }else if("serviceName".equals(row.getCell(0).getStringCellValue())){
            for(int i=1;i<=rowNum;i++){
                JSONObject soaInput = new JSONObject();
                soaInput.put("zkConnectStr",properties.getProperty("zkConnectStr"));
                soaInput.put("nsCode",properties.getProperty("nsCode"));
                soaInput.put("groupName",properties.getProperty("groupName"));
                soaInput.put("envCode",properties.getProperty("envCode"));
                soaInput.put("companyId",properties.getProperty("companyId"));
                soaInput.put("timeout",properties.getProperty("timeout"));
                soaInput.put("serviceType",1);
                soaInput.put("serviceUrl","");

                row = sheet.getRow(i);
                soaInput.put("serviceName",row.getCell(0).getStringCellValue());
                soaInput.put("methodName",row.getCell(1).getStringCellValue());
                soaInput.put("version",row.getCell(2).getStringCellValue());
                JSONArray patameters = new JSONArray();
                patameters.add(row.getCell(3).getStringCellValue());
                soaInput.put("parameters",patameters);

                ServiceCase serviceCase = new ServiceCase();
                serviceCase.setServiceUrl(soaInput.getString("serviceName")+"/"+soaInput.getString("methodName"));
                serviceCase.setServiceType("soa");
                serviceCase.setInput(JSON.toJSONString(soaInput));
                serviceCase.setExpectOutput(row.getCell(4).getStringCellValue());
                serviceCaseList.add(serviceCase);
            }
        }

        return serviceCaseList;
    }

}
