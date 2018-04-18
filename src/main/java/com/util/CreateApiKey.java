package com.util;

public class CreateApiKey {
	
	public String create(){
		
		String accStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		char[] acc = accStr.toCharArray();
		char[] acc1 = new char[25];
		for(int i = 0;i <= 24;i++){
			
			int a = (int) (Math.random() * 62);
			acc1[i] = acc[a];
		}
		
		for(int j = 0;j < acc1.length;j++){
			
			System.out.print(acc1[j]);
		}
		
		System.out.println(String.valueOf(acc1));
		return String.valueOf(acc1);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CreateApiKey c = new CreateApiKey();
		c.create();
	}

}
