package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders extends UtilClass{
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException 
	{
		String path = System.getProperty("user.dir")+"";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("sheetname");
		int colcount = xl.getCellCount("sheetname", 1);
		
		String data[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount;j++)
			{
				data[i-1][j] = xl.getCellData("sheetname", i, j);
			}
		}
		return data;
	}
	
	@DataProvider(name="Logindata")
	public Object[][] InvalidLoginCredentials() throws Exception{
		Object[][] data = dataReader("InvalidLogin_Cred", "/src/test/resources/testData/AECP_Data.xlsx.xlsx");
		return data;
	}
	
	@DataProvider(name="DashboardNavigation")
	public Object[][] navigationLinksDashboard() throws Exception{
	   return UtilClass.dataReader("Dashboard_Navigation", "/src/test/resources/testData/AECP_Data.xlsx.xlsx");
	
	}
	
	
			

}
