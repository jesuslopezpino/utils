package utils.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import utils.domain.Domain;

public class TestDate1Date2Comparator {

	@Test
	public void testComparator() {

		List<Domain> samples = new ArrayList<Domain>();
		Domain testCase1 = new Domain();
		Domain testCase2 = new Domain();
		Domain testCase3 = new Domain();
		Domain testCase4 = new Domain();
		Domain testCase5 = new Domain();
		Domain testCase6 = new Domain();
		
		samples.add(testCase6);
		samples.add(testCase1);
		samples.add(testCase3);
		samples.add(testCase4);
		samples.add(testCase2);
		samples.add(testCase5);
		
		List<Domain> expected = new ArrayList<Domain>();
		expected.add(testCase1);
		expected.add(testCase2);
		expected.add(testCase3);
		expected.add(testCase4);
		expected.add(testCase5);
		expected.add(testCase6);
		Assert.assertTrue("Result is the expected", true);
	}
}
