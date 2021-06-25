package dataInfo;

public class BookVO {
	private String genre;	//�帣
	private String bookName;	//����
	private String bookStatus;	//�뿩����
	private int rentalFee;	//�뿩���
	private int rentalDate;	//�뿩������
	
	private String registrationDate; //��ϳ�¥
	private String writer;	//�۰�
	
	public BookVO(String bookName, String genre, String bookStatus, int rentalFee, int rentalDate) {
		this.bookName = bookName;
		this.genre = genre;
		this.bookStatus = bookStatus;
		this.rentalFee = rentalFee;
		this.rentalDate = rentalDate;
	}
	public static void bookTitlePrint() {
		System.out.println("======================================================================");
		System.out.printf("%s\t\t %s\t\t %s\t\t %s\t\t %s\n", "����", "�帣", "����", "�뿩��", "�뿩��");
		System.out.println("======================================================================");
	}
	public void bookPrint() {
		System.out.printf("%s\t\t %s\t\t %s\t\t %d\t\t %3d\n", bookName, genre, bookStatus, rentalFee, rentalDate);
	}
	public void rentalBookPrint() {
		System.out.printf("%s\t\t %s\t\t %s\t\t %d\t\t %3d\n", bookName, genre, bookStatus, rentalFee, rentalDate);
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getRentalFee() {
		return rentalFee;
	}

	public void setRentalFee(int rentalFee) {
		this.rentalFee = rentalFee;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String isBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public int getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(int rentalDate) {
		this.rentalDate = rentalDate;
	}

	public BookVO() {
	}

}
