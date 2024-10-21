package com.pcwk.ehr.ed03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class NaverBlogAPI {

	public static void main(String[] args) {

		String clientId = "nDa3RiegbP742jMHOa0A";
		String clientSecret = "YGS7zQgYef";

		// 검색어. UTF-8로 인코딩되어야 합니다.
		String searchWord = null;

		try {
			searchWord = URLEncoder.encode("홍대 베이글", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.printf("searchWord: %s%n", searchWord);

		// JSON으로 return
		String apiURL = "https://openapi.naver.com/v1/search/blog.json?query=" + searchWord;

		System.out.printf("apiURL: %s%n", apiURL);

		// ------------------------------------------------------------------------
		// apiURL출력해서 나온 주소값 크롬에 붙여넣으면 인증하라함, 인증 단계.

		try {
			URL url = new URL(apiURL);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET"); // 요청 방식
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			int responseCode = con.getResponseCode(); // 200이면 성공 / 401이면 실패

			System.out.printf("responseCode: %s%n", responseCode);

			// 인증 성공
			if (200 == responseCode) {
				//
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line = "";

				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}

				br.close();
			}
			// 인증 실패
			else {
				System.out.printf("인증실패!%d%n", responseCode);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// ------------------------------------------------------------------------

	}

}
