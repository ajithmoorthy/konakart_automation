package com.atmecs.konakart.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.konakart.constants.FileConstants;
import com.atmecs.konakart.helper.ActionHelper;
import com.atmecs.konakart.logreports.LogReporter;
import com.atmecs.konakart.pages.HeroPage;
import com.atmecs.konakart.testbase.TestBase;
import com.atmecs.konakart.utils.PropertiesReader;

public class HeroImage extends TestBase {
	LogReporter log=new LogReporter();
	ActionHelper help=new ActionHelper();
	HeroPage hero=new HeroPage();
	PropertiesReader propread=new PropertiesReader();
	@Test
	public void validateHeroImage() throws IOException {
		Properties prop=propread.KeyValueLoader(FileConstants.HERO_PATH);
		logger=extentObject.startTest("validate hero img");
		hero.validateHeropPage(driver, prop);
		
	}

}
