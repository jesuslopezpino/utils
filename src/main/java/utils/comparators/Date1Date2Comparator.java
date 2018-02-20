
package utils.comparators;

import java.util.Comparator;

import utils.domain.Domain;

/**
 * This comparator returns a list sorted by all items of that has firstDate
 * value in descendant order and then the rest of elements sorted by secondDate
 * value also in descendant order, in case that first date is the same then the
 * list will be result by secondDate in descendant order
 * 
 * @author adictoalwhisky
 *
 *         Given that sample (date format dd/MM/yyyy)
 *         ________________________________ 
 *         | Id | firtDate	 | secondDate |
 *         -------------------------------- 
 *         | 1	| 01/01/2000	 | 01/02/1999 |
 *         -------------------------------- 
 *         | 2	| 			 | 01/02/1999 |
 *         -------------------------------- 
 *         | 3	| 07/01/2000 | 01/02/1999 |
 *         -------------------------------- 
 *         | 4	| 			 | 05/02/1999 |
 *         -------------------------------- 
 *         | 5	| 12/01/2000 | 01/02/1999 |
 *         -------------------------------- 
 *         | 6	| 			 | 22/02/1999 |
 *         --------------------------------
 *         | 7 | 07/01/2000	 | 01/02/1950 |
 *         --------------------------------
 * 
 *         The comparator will return 
 *         ________________________________ 
 *         | Id | firtDate	 | secondDate | 
 *         -------------------------------- 
 *         | 5 | 12/01/2000	 | 01/02/1999 | 
 *         -------------------------------- 
 *         | 3 | 07/01/2000	 | 01/02/1999 | 
 *         --------------------------------
 *         | 7 | 07/01/2000	 | 01/02/1950 |
 *         -------------------------------- 
 *         | 1 | 01/01/2000	 | 01/02/1999 | 
 *         -------------------------------- 
 *         | 6 | 			 | 22/02/1999 | 
 *         -------------------------------- 
 *         | 4 | 			 | 05/02/1999 |
 *         -------------------------------- 
 *         | 2 | 			 | 01/02/1999 |
 *         --------------------------------
 * 
 */
public class Date1Date2Comparator implements Comparator<Domain> {

	@Override
	public int compare(Domain o1, Domain o2) {
		if (o1.getFirstDate() == null && o2.getFirstDate() == null) {
			return o2.getSecondDate().compareTo(o1.getSecondDate());
		} else if (o1.getFirstDate() != null && o2.getFirstDate() != null
				&& o1.getFirstDate().equals(o2.getFirstDate())) {
			return o2.getSecondDate().compareTo(o1.getSecondDate());
		} else if (o1.getFirstDate() != null && o2.getFirstDate() == null) {
			return -1;
		} else if (o1.getFirstDate() == null && o2.getFirstDate() != null) {
			return 1;
		} else {
			return o2.getFirstDate().compareTo(o1.getFirstDate());
		}
	}

}
