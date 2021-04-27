package org.demo;

import org.testng.annotations.Test;

public class TestNew extends BaseClass{
	@Test
	private void demo() {
		BaseClass b = new BaseClass();
		b.getDriver();
		b.launchUrl("C:\\Users\\Administrator\\eclipse-workspace\\FrameWork\\DemoAutomation\\driver\\chromedriver.exe");
		
	}
	
	

}
