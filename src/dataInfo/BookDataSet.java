package dataInfo;

import java.util.HashMap;

public class BookDataSet {
	public static HashMap<String, BookVO> bookList = new HashMap<String, BookVO>();
	public BookDataSet() {
	}
	
	//책 데이터 세팅
	public static void basicBookSet() {
		bookList.put("음악의집", new BookVO("음악의집", "예술", "보유중", 1000 ,3));
		bookList.put("리얼제주", new BookVO("리얼제주", "여행", "보유중", 1500 ,3));
		bookList.put("백년의독서", new BookVO("백년의독서", "인문", "보유중", 1200 ,3));
		bookList.put("에스콰이어", new BookVO("에스콰이어", "패션잡지", "강감찬", 2000 ,5));
		bookList.put("해리포터", new BookVO("해리포터", "장르소설", "이순신", 800 ,4));
	}
	
	//책 빌린 목록
	public static HashMap<String, BookVO> rentalBookList = new HashMap<String, BookVO>();
	public static void rentalBookListSet() {
		
	}
}
