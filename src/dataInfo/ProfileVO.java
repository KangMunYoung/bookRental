package dataInfo;

public class ProfileVO {
	private String memberId;	//유저아이디
	private String memberPwd;	//유저비밀번호
	private String name;		//이름
	private String tel;			//전화번호
	private String since;	//가입일
	//===========================================
	private int rentalCnt = 0;	//대여권수
	private int money = 0;			//가진돈
	
	public ProfileVO() {
	}
	public ProfileVO(String memberId, String memberPwd, String name, String tel, String since, int rentalCnt, int money) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.name = name;
		this.tel = tel;
		this.since = since;
		this.rentalCnt = rentalCnt;
		this.money = money;
	}
	
	public static void profileTitlePrint() {
		System.out.println("=========================================================================");
		System.out.printf("%s\t %s\t %s\t %-5s\t %s\t\t %s\t %s\t\n", "아이디", "비밀번호", "이름", "전화번호", "가입일", "대여권수", "선불금액");
		System.out.println("=========================================================================");
//		System.out.printf("%-8s %-10s %-10s %-20s %-10s %-10s %-10s \n", "아이디", "비밀번호", "이름", "전화번호", "가입일", "대여권수", "선불금액");
	}
	public void profilePrint() {
		System.out.printf("%s\t %s\t %s\t %s\t %s\t %4d\t %d\t\n", memberId, memberPwd, name, tel, since, rentalCnt, money);
//		System.out.printf("%-10s %-10s %-10s %-20s %-10s %-10s %-10d\n", memberId, memberPwd, name, tel, since, rentalCnt, money);
	}
	
	public int getRentalCnt() {
		return rentalCnt;
	}
	public void setRentalCnt(int rentalCnt) {
		this.rentalCnt = rentalCnt;
	}
	
	
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSince() {
		return since;
	}

	public void setSince(String since) {
		this.since = since;
	}



	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}



}
