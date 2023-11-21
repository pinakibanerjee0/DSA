package com.pinaki.greedyAlgo;

import java.util.ArrayList;
import java.util.Collections;

public class NMeetingsInOneRoom {
	/*
	 * 
	 * There is one meeting room in a firm. There are N meetings in the form of
	 * (start[i], end[i]) where start[i] is start time of meeting i and end[i] is
	 * finish time of meeting i. What is the maximum number of meetings that can be
	 * accommodated in the meeting room when only one meeting can be held in the
	 * meeting room at a particular time?
	 * 
	 * Note: Start time of one chosen meeting can't be equal to the end time of the
	 * other chosen meeting.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: N = 6 start[] = {1,3,0,5,8,5} end[] = {2,4,6,7,9,9} Output: 4
	 * Explanation: Maximum four meetings can be held with given start and end
	 * timings. The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
	 */
	
	 public static int maxMeetings(int start[], int end[], int n)
	    {
	        
	        int meetings = 1;
	        ArrayList<Meeting> meet = new ArrayList<>();
	        
	        for(int i = 0; i < start.length; i++)
	            meet.add(new Meeting(start[i], end[i], i+1));
	            
	        Collections.sort(meet , (m1 , m2)->(m1.end<m2.end) ? -1 : (m1.end>m2.end) ? 1 : 0 );
	        int limit = meet.get(0).end;
	        
	        
	        for(int i = 1;i<start.length;i++) {
	            if(meet.get(i).start > limit) {
	                limit = meet.get(i).end; 
	                meetings++;
	            }
	        }
	        
	        return meetings;
	    }
	    public static class Meeting {
	        int start;
	        int end;
	        int pos;
	         
	        Meeting(int start, int end, int pos)
	        {
	            this.start = start;
	            this.end = end;
	            this.pos = pos;
	        }
	    }
	    
	    public static void main(String[] args) {
	    	int [] start =  {1,3,0,5,8,5} , end = {2,4,6,7,9,9};
	    	int maxMeetings = maxMeetings(start , end ,  start.length);
	    	
	    	System.out.println("maxMeetings : "+maxMeetings);
	    }
}
