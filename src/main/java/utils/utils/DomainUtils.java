package utils.utils;

import utils.domain.Domain;

public class DomainUtils {

	public static String printDomain(Domain domain) {
		return "Domain [ id=" + domain.getId() + ", firstDate=" + DateUtils.printDate(domain.getFirstDate())
				+ "," + printTab(domain)+ "secondDate=" + DateUtils.printDate(domain.getSecondDate()) + " ]";
	}

	private static String printTab(Domain domain) {
		return domain.getFirstDate() == null ? "\t\t":"\t";
	}

}
