
package utils.comparators;

import java.util.Comparator;

import utils.domain.Domain;
import utils.utils.DomainUtils;

/**
 * This comparator returns a list sorted by all items of that has firstDate
 * value in descendant order and then the rest of elements sorted by secondDate
 * value also in descendant order
 * 
 * @author adictoalwhisky
 *
 *         Given that sample (date format dd/MM/yyyy)
 *         ________________________________ | Id | firtDate | secondDate |
 *         -------------------------------- | 1 | 01/01/2000 | 01/02/1999 |
 *         -------------------------------- | 2 | | 01/02/1999 |
 *         -------------------------------- | 3 | 07/01/2000 | 01/02/1999 |
 *         -------------------------------- | 4 | | 05/02/1999 |
 *         -------------------------------- | 5 | 12/01/2000 | 01/02/1999 |
 *         -------------------------------- | 6 | | 22/02/1999 |
 *         --------------------------------
 * 
 *         The comparator will return ________________________________ | Id |
 *         firtDate | secondDate | -------------------------------- | 5 |
 *         12/01/2000 | 01/02/1999 | -------------------------------- | 3 |
 *         07/01/2000 | 01/02/1999 | -------------------------------- | 1 |
 *         01/01/2000 | 01/02/1999 | -------------------------------- | 6 | |
 *         22/02/1999 | -------------------------------- | 4 | | 05/02/1999 |
 *         -------------------------------- | 2 | | 01/02/1999 |
 *         --------------------------------
 * 
 */
public class Date1Date2Comparator implements Comparator<Domain> {

	@Override
	public int compare(Domain o1, Domain o2) {
		System.out.println("o1 is " + DomainUtils.printDomain(o1));
		System.out.println("o2 is " + DomainUtils.printDomain(o2));
		if (o1.getFirstDate() == null && o2.getFirstDate() == null) {
			System.out.println("second dates returns " + o1.getSecondDate().compareTo(o2.getSecondDate()));
			return o2.getSecondDate().compareTo(o1.getSecondDate());
		} else if (o1.getFirstDate() != null && o2.getFirstDate() == null) {
			System.out.println("Return -1");
			return -1;
		} else if (o1.getFirstDate() == null && o2.getFirstDate() != null) {
			System.out.println("Return 1");
			return 1;
		} else {
			System.out.println("first dates returns " + o1.getFirstDate().compareTo(o2.getFirstDate()));
			return o2.getFirstDate().compareTo(o1.getFirstDate());
		}
	}

}
