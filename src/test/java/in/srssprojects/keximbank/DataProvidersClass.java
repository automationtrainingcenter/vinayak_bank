package in.srssprojects.keximbank;

import org.testng.annotations.DataProvider;

import utilities.ExcelHelper;

public class DataProvidersClass {
	ExcelHelper excel;

	// data provider for branch data
	@DataProvider(name = "branch_data")
	public Object[][] getBranchData() {
		excel = new ExcelHelper();
		return excel.getExcelData("testdata.xls", "branchdata");
	}

	// data provider for role data
	@DataProvider(name = "role_data")
	public Object[][] getRoleData() {
		excel = new ExcelHelper();
		return excel.getExcelData("testdata.xls", "roledata");
	}

}
