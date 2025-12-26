package generic_utilities;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * This method is used to get random int value
	 * @return
	 */
	public int getRandomNo() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
		
	}
	/**
	 *  This method is used to get required date format
	 * @param futureMon
	 * @return
	 */
	public String systemDate(long futureMon )
	{
		LocalDate date = LocalDate.now();
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String systemdate = d.format(date);
		return systemdate;
	}
	/**
	 *  This method is used to get date in required date format and it will give timing also
	 * @return
	 */
	public String sysDate()
	{
		Date date= new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		String systemDateInFormat = sim.format(date);
		return systemDateInFormat;
	}
	/**
	 *  This method is used to get the future date
	 * @param FutureMon
	 * @return
	 */
	public String futureDateIntermsOfMonths(long FutureMon)
	{
		LocalDate date = LocalDate.now();
		LocalDate future = date.plusMonths(FutureMon);
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String FutureMonth = d.format(future);
		return FutureMonth;
		
	}

}
