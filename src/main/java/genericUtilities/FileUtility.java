package genericUtilities;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class consists of generic methods related to files
 * @author Najira
 */
public class FileUtility {
/**
 * This method will read the data from property file
 * @return value
 * @param key 
 * @throws IOException 
 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\sample\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String value=p.getProperty(key);
		return value;
	}

	
	/**
	 * This method will read the data from excel and return the value to caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	
	public String readDataFromExcelFile(String sheetName,int rowNo,int cellNo) throws FileNotFoundException, EncryptedDocumentException, IOException
	{

		FileInputStream fise=new FileInputStream(".\\sample\\src\\test\\resources\\TestData.xlsx");
		Workbook wb =WorkbookFactory.create(fise);
		String value=wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();		
		return value;
	}


	
}
