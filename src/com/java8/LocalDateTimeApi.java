package com.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeApi {
	public static void main(String[] args) {
		/******************************************LocalDate***************************************************/
		LocalDate localDate = LocalDate.now();
		System.out.println("Today's Date: "+localDate);
		
		LocalDate joinDate = LocalDate.of(2016, 9, 19); 
		
		//LocalDate joinDate2 = LocalDate.of(2016, 09, 19);   //not allowed
		
		System.out.println(joinDate+ " ---> "+joinDate.getDayOfMonth()+" "+ joinDate.getMonth() + " "+ joinDate.getYear());
		
		LocalDate l = LocalDate.parse("2016-09-19");
		
		System.out.println(l.equals(joinDate));  
		
		/******************************************LocalTime***************************************************/
		
		System.out.println("Current Time: "+LocalTime.now());
		
		 System.out.println(LocalTime.parse("07:30:04"));
		 
		 /******************************************LocalDateTime***************************************************/
		 
			System.out.println("Current Date Time: "+LocalDateTime.now());
			
			LocalDateTime dateTimeJoining= LocalDateTime.of(2016, Month.SEPTEMBER, 19, 10, 30);
			
			System.out.println("dateTimeJoining: "+dateTimeJoining);
	}
}
