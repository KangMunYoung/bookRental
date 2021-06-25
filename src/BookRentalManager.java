import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import dataInfo.BookDataSet;
import dataInfo.BookVO;
import dataInfo.ProfileDataSet;
import dataInfo.ProfileVO;

public class BookRentalManager {
	Scanner scan = new Scanner(System.in);
	static String session = "";	// 0 �α׾ƿ�����, 2 �����ڷα���, 1����α���
	String id = "";
	public BookRentalManager() {
	}

	public void bookRentalStart() {
		ProfileDataSet.basicProfileSet();
		BookDataSet.basicBookSet();
		BookDataSet.rentalBookListSet();
		do {
			firstMenu();
			if(session.equals("admin")) {
				System.out.println("�����ڰ������� �α����մϴ�.");
				adminMenu();
			}else if(session.equals("user")) {
				System.out.println("�α��� �Ǿ����ϴ�.");
				memberMenu();
			}
		}while(true);
	}
	
	public void firstMenu() {//�α���//ȸ������//����
		boolean logResult = false;
		Login log = new Login();
		do {
			String menu = inData("�޴��� �������ּ���[1.�α���, 2.ȸ������, 3.����]");
			if(menu.equals("1")) {//�α���
				id = inData("���̵�");
				String pwd = inData("��й�ȣ");
				logResult = log.loginCheck(id, pwd);
				System.out.println("a1111");
			}else if(menu.equals("2")) {//ȸ������
				logResult = signUp();
			}else if(menu.equals("3")) {//���α׷�����
				programExit();
			}else {
				System.out.println("�޴��� �߸��Է��ϼ̽��ϴ�. �ٽ��Է��ϼ���.");
			}
		}while(!logResult);
	}

	//��¥����==============================================================
	public String nowDate() {	//��¥����
		Calendar now = Calendar.getInstance();
		String year = Integer.toString(now.get(Calendar.YEAR));
		String month = Integer.toString(now.get(Calendar.MONTH)+1);
		String day = Integer.toString(now.get(Calendar.DAY_OF_MONTH));
		return year+"-"+month+"-"+day;
	}
	//ȸ������=======================================================
	public boolean signUp() {	//ȸ������
		ProfileVO vo = new ProfileVO();
		vo.setMemberId(inData("���̵�"));
		vo.setMemberPwd(inData("��й�ȣ"));
		vo.setName(inData("�̸�"));
		vo.setTel(inData("��ȭ��ȣ"));
		vo.setSince(nowDate());
		do {
			boolean flag = true;
			try {
				vo.setMoney(Integer.parseInt(inData("������")));
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("���� ���ڷ� �Է��ϼ���");
			}
			if(flag) break;
		}while(true);
		ProfileDataSet.profileList.put(vo.getMemberId(), vo);
		return true;
	}
	
	//ȸ���޴�
	public void memberMenu() {
		String memberTitle = "�޴�[1.å���, 2.å�뿩, 3.å�ݳ�, 4.���ݳֱ�, 5.�뿩�߸��, 6.�α׾ƿ�, 7.����]";
		do {
			try {
				System.out.println();
				allBookList();
				rentalList();
				
				System.out.println("����->"+ProfileDataSet.profileList.get(id).getMoney());
				int menu = Integer.parseInt(inData(memberTitle));
				if(menu == 1) {	allBookList(); //å���
				}else if(menu == 2) { rental(menu);	//å�뿩
				}else if(menu == 3) { rental(menu);	//å�ݳ�
				}else if(menu == 4) { memMoney();//���ݳֱ�
				}else if(menu == 5) { rentalList();	//�뿩�߸��
				}else if(menu == 6) { logout();	//�α׾ƿ�
				}else if(menu == 7) { programExit();	//����
				}
			}catch(NumberFormatException nfe) {
				System.out.println("�߸��Է��ϼ̽��ϴ�. 1~7������ �޴��� ����ּ���");
			}
		}while(session.equals("user"));
	}
	//���ݳֱ�
	public void memMoney() {
		int money = Integer.parseInt(inData("�󸶸� �߰��Ͻðڽ��ϱ�."));
		ProfileVO vo = ProfileDataSet.profileList.get(id);
		int wallet = vo.getMoney()+money;
		vo.setMoney(wallet);
	}
	
	//å�뿩
	public void rental(int menu) { // å�뿩&å�ݳ�
		String pick = inData("�뿩�� å������ �Է��ϼ���");
		if(menu == 2) {		//å�뿩
			BookVO vo = BookDataSet.bookList.get(pick);
			BookDataSet.rentalBookList.put(vo.getBookName(), vo);
			
			ProfileVO pvo = ProfileDataSet.profileList.get(id);
			int don = pvo.getMoney(); 
			int temp = vo.getRentalFee();
			don-=temp;
			pvo.setMoney(don);
			
			BookDataSet.bookList.remove(pick);
			
		}else if(menu == 3) {	//å�ݳ�
			BookVO vo = BookDataSet.rentalBookList.get(pick);
			BookDataSet.bookList.put(vo.getBookName(), vo);
			BookDataSet.rentalBookList.remove(pick);
			System.out.println("���");
		}
	}
	//�뿩���
	public void rentalList() {
		Collection<BookVO> rentalList = BookDataSet.rentalBookList.values();
		Iterator<BookVO> ii = rentalList.iterator();
		BookVO.bookTitlePrint();
		while(ii.hasNext()) {
			BookVO Vo = ii.next();
			Vo.bookPrint();
		}
	}
	//���ݳֱ�

	
	//�����ڸ޴�==================================================================
	public void adminMenu() {
		System.out.println("�����ڸ޴�");
		String adminTitle = "�޴�[1.å���, 2.å����, 3.å���, 4.ȸ�����, 5.ȸ�����, 6.ȸ������, 7.�α׾ƿ�, 8.����]";
		do {
			try {
				System.out.println();
				int menu = Integer.parseInt(inData(adminTitle));
				if(menu == 1) {	//å���
					addBook(); allBookList(); 
				}else if(menu == 2) {	//å����
					delBook(); allBookList();
				}else if(menu == 3) {	//å���
					allBookList();
				}else if(menu == 4) {	//ȸ�����
					signUp(); allProfileList();
				}else if(menu == 5) {	//ȸ�����
					allProfileList();
				}else if(menu == 6) {	//ȸ������
					delProfile(); allProfileList();
				}else if(menu == 7) {	//�α׾ƿ�
					logout();
				}else if(menu == 8) {	//����
					programExit();
				}
			}catch(NumberFormatException nfe) {
				System.out.println("�߸��Է��ϼ̽��ϴ�. 1~7������ �޴��� ����ּ���");
			}
		}while(session.equals("admin"));
	}
	//å���
	public void addBook() {
		BookVO vo = new BookVO();
		vo.setBookName(inData("����"));
		vo.setGenre(inData("�帣"));
		do {
			boolean flag = true;
			try {
				vo.setRentalFee(Integer.parseInt(inData("�뿩��")));
				vo.setRentalDate(Integer.parseInt(inData("�뿩��")));
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("�߸��Է� �ϼ̽��ϴ�. �뿩����� ���ڷ� �Է��ϼ���");
			}
			if(flag) break;
		}while(true);
		BookDataSet.bookList.put(vo.getBookName(), vo);
	}
	
	//å����
	public void delBook() {
		String delName = inData("������ å����");
		BookDataSet.bookList.remove(delName);
	}

	
	//ȸ����� ����ϱ�====================================================
	public void allProfileList() {
		ProfileDataSet.basicProfileSet();
		Collection<ProfileVO> list = ProfileDataSet.profileList.values();
		Iterator<ProfileVO> ii = list.iterator();
		ProfileVO.profileTitlePrint();
		while(ii.hasNext()) {
			ProfileVO vo = ii.next();
			vo.profilePrint();
		}
	}
	//ȸ������
	public void delProfile() {
		String delName = inData("������ ���̵�");
		ProfileDataSet.profileList.remove(delName);
	}
	
	//����=================================================================
	//�α׾ƿ� & ���� & �Է¹ޱ�===============================================
	public void logout() {//�α׾ƿ�
		session = "logout";
		System.out.println("�α׾ƿ��Ǿ����ϴ�.");
	}
	public void programExit() {	//����
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
		System.exit(0);
	}
	
	public String inData(String msg) {	//�Է¹ޱ�
		System.out.print(msg+"->");
		return scan.nextLine();
	}
	//å��� ����ϱ�=============================================
	public void allBookList() {
		Collection<BookVO> bookList = BookDataSet.bookList.values();
		Iterator<BookVO> ii = bookList.iterator();
		BookVO.bookTitlePrint();
		while(ii.hasNext()) {
			BookVO vo = ii.next();
			vo.bookPrint();
		}
	}
	
	//��������===========================================================
	public void statusUpdate() {//���¼���
		String data = inData("�����Ұ�");
		
	}
	
}
