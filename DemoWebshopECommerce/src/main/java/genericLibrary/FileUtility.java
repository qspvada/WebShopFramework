package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	 
	public static String getProperty(String key) {
		
		//Step 1: •	Get the java representation Object of the Physical file using “FileInputSteam
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("./src/test/resources/commonData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Step 2: • Create a Object of “Properties” class & load all the keys
		Properties p=new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 3: Read the data using getProperty(“Key”)
		return p.getProperty(key);
	}
	
	
	public static String readCellDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		//Step 1: Get the java representation of excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		
		//Step 2: Get the Workbook
//		Workbook book=WorkbookFactory.create(fis);
		
        //Step 3: Get the sheet from WorkBook
//		Sheet sheet=book.getSheet("register");
		
		//Step 4: Get the row from sheet
//		Row row=sheet.getRow(3);
		
		//Step 5: Get the cell from selected row
//		System.out.println(row.getCell(4));
		
		//Reading the data from cell using method chaining
		return WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
		
	}
	
	
	public static String[][] readRowDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException{
		//Step 1: Get the java representation of physical file
		FileInputStream fis=new FileInputStream(".src/test/resources/testdata.xlsx");
		
		//Step 2: Get the Workbook
		Workbook book=WorkbookFactory.create(fis);
		
		//Step 3: Get the Workbook
		Sheet sheet=book.getSheet(sheetName);
		
		//Step 4: Get the count of rows having value
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		//Step 5: Get the count of cell having value
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		//Step 5: Create a 2 dimensional array
		String [][] data=new String[rowCount-1][cellCount];
		
		//Step 6: Read the data from Excel and store inside 2 dimensional array.
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		//Return 2D array
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		readRowDataFromExcel("register");
	}
}
