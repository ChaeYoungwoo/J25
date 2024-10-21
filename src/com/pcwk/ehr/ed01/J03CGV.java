package com.pcwk.ehr.ed01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pcwk.ehr.cmn.PLog;

public class J03CGV implements PLog {
	static final String CGV = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
	static final int VIEW_MOVIES = 7;

	public static void downloadImage(String webUrl, String fileName) throws MalformedURLException {
		URL url = new URL(webUrl);
		/*
		 * URL에 있는 이미지를 local에 기록
		 */
		long start = System.currentTimeMillis();
		String path = "D:\\JAP_20240909\\01_JAVA\\WORKSPACE\\J25\\img\\";
		try (InputStream in = url.openStream(); // 읽고
				FileOutputStream out = new FileOutputStream(path +fileName); // 파일을 쓰고
		) {
			byte[] bufferImg = new byte[1024];
			int bytesRead = 0; // len값 buffer를 얼마나 읽는지

			// 입력스트림에서 데이터를 읽어와서 출력스트림에 기록
			while ((bytesRead = in.read(bufferImg)) != -1) {
//				System.out.print(bytesRead);
				out.write(bufferImg, 0, bytesRead);
			}

		} catch (IOException e) {
			log.debug("IOException: " + e.getMessage());
		}
		long end = System.currentTimeMillis();
		log.debug("파일: {} 생성, 경과시간: {}", fileName, (end - start));
	}

	public static void main(String[] args) {
//		try {
//			downloadImage("https://img.cgv.co.kr/Movie/Thumbnail/Poster/000088/88539/88539_320.jpg",
//					"아마존_활명수.jpg");
//		} catch (MalformedURLException e) {
//			System.out.println("MalformedURLException: " + e.getMessage());
//		}
		
		try {
			Document doc = Jsoup.connect(CGV).get(); // .get()으로 문서 전체 가져오기
//			log.debug(doc.toString()); //문서 전체 출력 url의 html코드 출력됨 (너무 길어서 코멘트 처리해버림)

			// div : html
			// css : box-contents
			// div.box-contents : '.' class의 속성
			// div.box-contents strong.title: ' '(띄어쓰기) = 서로 다른 tag

			// contents 이후에 태그가 바뀌었으니 스페이스바 후, strong
			// 태그가 바뀌지 않았으니 strong.title
			Elements titles = doc.select("div.box-contents strong.title"); // 제목
			Elements reRates = doc.select("div.score strong.percent span"); // 예매율
			Elements posters = doc.select("div.box-image span.thumb-image img"); // 포스터

			for (int i = 0; i < VIEW_MOVIES; i++) {

				// Elements랑 Element랑 다른 것 인지
				Element titleElement = titles.get(i);
				Element rate = reRates.get(i);
				String posterURL = posters.get(i).attr("src"); // img태그에 있는 src만 골라빼먹기
				
				String title = titleElement.text();
				title = title.replace(":", "");
				
				

				log.debug("{}.{}, 예매율: {}, 포스터 URL: {}", (i + 1), titleElement.text(), rate.text(), posterURL);

				downloadImage(posterURL,title+".jpg");
				

			}

		} catch (IOException e) {
			log.debug("IOException: " + e.getMessage());

		}

	}

}
