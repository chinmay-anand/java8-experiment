package com.chinmay.java8.flight_recording;

import java.util.ArrayList;
import java.util.List;

/**
 * JMC Demo: https://www.youtube.com/watch?v=qytuEgVmhsI
 * The following command generates 200 seconds data to analyze
 * 		java -XX:+UnlockCommercialFeatures -XX:+FlightRecorder 
 * 			-XX:StartFlightRecording=duration=200s,filename=myflight.jfr com.chinmay.java8.flight_recording.FlightRecordTester
 * Open this data "myflight.jfr" in JMC to analyze the bottlenecks and performance issues.
 * @author Chinmay
 *
 */
public class FlightRecordTester {
	public static void main(String[] args) {
		System.out.println("This is a faulty program used to demonstrate usage of Java Mission Control tool to monitor and find the bottlenecks in your java application");
	    List<Object> items = new ArrayList<Object>(1);
	    try {
	        while (true){
	            items.add(new Object());
	        }
	    } catch (OutOfMemoryError e){
	        System.out.println(e.getMessage());
	    }
	    assert items.size() > 0;
	    try {
	        Thread.sleep(1000);
	    } catch (InterruptedException e) {
	        System.out.println(e.getMessage());
	    }
	}
}
