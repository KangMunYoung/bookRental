
import dataInfo.ProfileDataSet;
import dataInfo.ProfileVO;

public class Login  {
	private final String ROOTID = "admin";
	private final String ROOTPWD = "1234";
	
	public Login() {
	}

	public boolean loginCheck(String id, String pwd) {
		ProfileDataSet.basicProfileSet();
		ProfileVO vo = ProfileDataSet.profileList.get(id);
		
		
		if(id.equals(ROOTID) && pwd.equals(ROOTPWD)) {
			BookRentalManager.session = id;	//������ �α���
			System.out.println("�����ڷα���");
			return true;
			
		}else if(ProfileDataSet.profileList.containsKey(id)) {
			String memberPwd = vo.getMemberPwd();
			if(memberPwd.equals(pwd)) {
				System.out.println("aasdf");
				BookRentalManager.session = "user";	//ȸ�� �α���
				System.out.println("����α���");
				return true;
			}
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���̵�� ��й�ȣ�� Ȯ���� �ٽ��Է��� �ּ���");
			return false;
			
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���̵�� ��й�ȣ�� Ȯ���� �ٽ��Է��� �ּ���");
			return false;
		}
	}
}

