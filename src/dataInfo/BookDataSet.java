package dataInfo;

import java.util.HashMap;

public class BookDataSet {
	public static HashMap<String, BookVO> bookList = new HashMap<String, BookVO>();
	public BookDataSet() {
	}
	
	//å ������ ����
	public static void basicBookSet() {
		bookList.put("��������", new BookVO("��������", "����", "������", 1000 ,3));
		bookList.put("��������", new BookVO("��������", "����", "������", 1500 ,3));
		bookList.put("����ǵ���", new BookVO("����ǵ���", "�ι�", "������", 1200 ,3));
		bookList.put("�������̾�", new BookVO("�������̾�", "�м�����", "������", 2000 ,5));
		bookList.put("�ظ�����", new BookVO("�ظ�����", "�帣�Ҽ�", "�̼���", 800 ,4));
	}
	
	//å ���� ���
	public static HashMap<String, BookVO> rentalBookList = new HashMap<String, BookVO>();
	public static void rentalBookListSet() {
		
	}
}
