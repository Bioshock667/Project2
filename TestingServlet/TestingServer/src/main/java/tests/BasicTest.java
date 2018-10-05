package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {
	
	@Test
	public void alwaysPass() {
		Assert.assertEquals(1, 1);
	}

}
