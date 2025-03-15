package genericUtilities;
import java.text.Format;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * This class consists of genereic methods realted to java
 * @author Najira
 */
public class JavaUtility {
/**
 * This method will capture the current system date and return to caller
 * Used to name screenshots and reports
 * 
 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = f.format(d);
		return date;
	}
	
	
}
