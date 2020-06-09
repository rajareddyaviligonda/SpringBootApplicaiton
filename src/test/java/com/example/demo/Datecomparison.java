package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Datecomparison {
	
public static void main (String args[]) {
	// TODO Auto-generated method stub
	Date today = new Date();
	Calendar cal = new GregorianCalendar();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	System.out.println("today=="+dateFormat.format(today));
	
	
	cal.setTime(today);
	cal.add(Calendar.DAY_OF_MONTH, -30);
	Date today30 = cal.getTime();
	System.out.println("30 day=="+dateFormat.format(today30));
	
	cal.add(Calendar.DAY_OF_MONTH, -60);
	Date today60 = cal.getTime();
	System.out.println("60 day=="+dateFormat.format(today60));
	
	cal.add(Calendar.DAY_OF_MONTH, -90);
	Date today90 = cal.getTime();
	System.out.println("90 day=="+dateFormat.format(today90));

}
	
}
