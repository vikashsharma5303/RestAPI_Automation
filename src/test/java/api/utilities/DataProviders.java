package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
public class DataProviders {

	@DataProvider(name = "data")
	public String[][] getAllData() throws IOException {
		String path = System.getProperty("user.dir") + "//DataForAPI.xlsx";
		XLUtils obj = new XLUtils(path);

		int rownum = obj.getRowCount("Sheet1");
		int colcount = obj.getCellCount("Sheet1", rownum);

		String apidata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				apidata[i - 1][j] = obj.getCellData("sheet1", i, j);
			}
		}
		return apidata;

	}

	@DataProvider(name = "UserNames")
	public String[] getUserName() throws IOException {
		String path = System.getProperty("user.dir") + "//DataForAPI.xlsx";
		XLUtils xl = new XLUtils(path);

		int rownum = xl.getRowCount("Sheet1");

		String apidata[] = new String[rownum];

		for (int i = 1; i <= rownum; i++) {
			apidata[i - 1] = xl.getCellData("Sheet1", i, 1);

		}
		return apidata;
	}
}
