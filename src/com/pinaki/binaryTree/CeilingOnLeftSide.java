package com.pinaki.binaryTree;

import java.util.TreeSet;

class CeilingOnLeftSide { 
    
    public static void main(String args[]) 
    { 
        int arr[]={2,8,30,15,25,12};
	    int n=arr.length;
	
	    printCeiling(arr,n);
    }
    
    public static void printCeiling(int arr[], int n){
        System.out.print("-1"+" ");
        TreeSet<Integer> s=new TreeSet<>();
        s.add(arr[0]);
        for(int i=1;i<n;i++){
            if(s.ceiling(arr[i])!=null)
                System.out.print(s.ceiling(arr[i])+" ");
            else
                System.out.print("-1"+" ");
            s.add(arr[i]);
        }
    }
} 
