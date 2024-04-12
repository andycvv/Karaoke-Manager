package utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Formatear {
	public static final DecimalFormat DF2 = new DecimalFormat("00");
	public static final DecimalFormat DF3 = new DecimalFormat("000");
	public static final DecimalFormat DF4 = new DecimalFormat("0000");
	
	public static final SimpleDateFormat STRINGTODATE = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
	public static final SimpleDateFormat DATETOSTRING = new SimpleDateFormat("dd/MM/yyyy");
}
