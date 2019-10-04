package com.atmecs.konakart.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.atmecs.konakart.helper.ActionHelper;
import com.atmecs.konakart.helper.ValidaterHelper;
import com.atmecs.konakart.logreports.LogReporter;

public class HeroPage {
	LogReporter log=new LogReporter();
	ActionHelper help=new ActionHelper();
	ValidaterHelper validate=new ValidaterHelper();
	 public void validateHeropPage(WebDriver driver,Properties prop){
		help.clickElement(prop.getProperty("loc.img.hero"),driver);
		help.clickElement(prop.getProperty("loc.tab.proddiscrip"), driver);
		help.clickElement(prop.getProperty("loc.tab.specification"), driver);
		help.clickElement(prop.getProperty(""), driver);
	}

}
