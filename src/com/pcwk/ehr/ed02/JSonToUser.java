package com.pcwk.ehr.ed02;

import com.google.gson.Gson;

public class JSonToUser {

	public static void main(String[] args) {
		
		//JSON String 
		String jsonString = "{\"name\":\"이상무\",\"age\":23,\"isActive\":true}";
		
		//Gson 객체
		
		Gson gson = new Gson();
		
		//JSON을 자바 객체로 변환
		User user = gson.fromJson(jsonString, User.class);
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user.isActive());
	}

}
