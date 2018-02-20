package utils.utils;

import utils.domain.Domain;

public class DomainUtils {

	public static String printDomain(Domain domain) {
		return "Domain [id=" + domain.getId() + ", firstDate=" + DateUtils.printDate(domain.getFirstDate())
				+ ", secondDate=" + DateUtils.printDate(domain.getSecondDate()) + "]";
	}

}
