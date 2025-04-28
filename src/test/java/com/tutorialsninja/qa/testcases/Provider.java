package com.tutorialsninja.qa.testcases;
import org.testng.annotations.DataProvider;

import com.tutorialninja.qa.utils.Utilities;

public class Provider {
	
	@DataProvider (name="getTestData")
	public String[][] dataSupplier() {
		
		String[] [] data = {{"Sanskruti", "Kolhe", Utilities.generateEmailWithTimeStamp(), "qwer1234", "8787877787"},
				/*{"Rat", "Tho", Utilities.generateEmailWithTimeStamp(), "qwerty", "7412589631"}*/};
			
		return data;
	

	}

}
