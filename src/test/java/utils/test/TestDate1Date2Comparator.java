package utils.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import utils.comparators.Date1Date2Comparator;
import utils.domain.Domain;
import utils.utils.DateUtils;
import utils.utils.DomainUtils;

public class TestDate1Date2Comparator {

	@Test
	public void testComparator() {

		// ___________________________________
		// | Id | firtDate		| secondDate |
		// -----------------------------------
		// | 5 | 12/01/2000		| 01/02/1999 |
		// -----------------------------------
		// | 3 | 07/01/2000		| 01/02/1999 |
		// -----------------------------------
		// | 7 | 07/01/2000		| 01/02/1950 |
		// -----------------------------------
		// | 1 | 01/01/2000		| 01/02/1999 |
		// -----------------------------------
		// | 6 | 				| 22/02/1999 |
		// -----------------------------------
		// | 4 | 				| 05/02/1999	 |
		// -----------------------------------
		// | 2 | 				| 01/02/1999	 |
		// -----------------------------------
		
		// expected ids 5,3,8,1,6,4,2
		
		List<Domain> samples = new ArrayList<Domain>();
		Domain testCase1 = new Domain();
		testCase1.setId(1);
		testCase1.setFirstDate(DateUtils.getDate("01/01/2000"));
		testCase1.setSecondDate(DateUtils.getDate("01/02/1999"));

		Domain testCase2 = new Domain();
		testCase2.setId(2);
		testCase2.setFirstDate(null);
		testCase2.setSecondDate(DateUtils.getDate("01/02/1999"));

		Domain testCase3 = new Domain();
		testCase3.setId(3);
		testCase3.setFirstDate(DateUtils.getDate("07/01/2000"));
		testCase3.setSecondDate(DateUtils.getDate("01/02/1999"));

		Domain testCase4 = new Domain();
		testCase4.setId(4);
		testCase4.setFirstDate(null);
		testCase4.setSecondDate(DateUtils.getDate("05/02/1999"));

		Domain testCase5 = new Domain();
		testCase5.setId(5);
		testCase5.setFirstDate(DateUtils.getDate("12/01/2000"));
		testCase5.setSecondDate(DateUtils.getDate("01/02/1999"));

		Domain testCase6 = new Domain();
		testCase6.setId(6);
		testCase6.setFirstDate(null);
		testCase6.setSecondDate(DateUtils.getDate("22/02/1999"));

		Domain testCase7 = new Domain();
		testCase7.setId(7);
		testCase7.setFirstDate(DateUtils.getDate("07/01/2000"));
		testCase7.setSecondDate(DateUtils.getDate("01/02/1950"));
		
		samples.add(testCase1);
		samples.add(testCase2);
		samples.add(testCase3);
		samples.add(testCase4);
		samples.add(testCase5);
		samples.add(testCase6);
		samples.add(testCase7);
		
		printSamples("Before sorting", samples);
		Collections.sort(samples, new Date1Date2Comparator());
		printSamples("After sorting", samples);

		int[] expectedIds = { 5, 3, 7, 1, 6, 4, 2 };
		for (int i = 0; i < samples.size(); i++) {
			Domain testCase = samples.get(i);
			System.out.println("testCase id: " + testCase.getId() + " expected id: " + expectedIds[i]);
			Assert.assertTrue("Id is the expected", testCase.getId() == expectedIds[i]);
		}
	}

	private void printSamples(String title, List<Domain> samples) {
		System.out.println(title);
		samples.stream().forEach(sample -> {
			System.out.println(DomainUtils.printDomain(sample));
		});
	}

}
