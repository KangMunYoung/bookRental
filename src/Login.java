
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
			BookRentalManager.session = id;	//관리자 로그인
			System.out.println("관리자로그인");
			return true;
			
		}else if(ProfileDataSet.profileList.containsKey(id)) {
			String memberPwd = vo.getMemberPwd();
			if(memberPwd.equals(pwd)) {
				System.out.println("aasdf");
				BookRentalManager.session = "user";	//회원 로그인
				System.out.println("멤버로그인");
				return true;
			}
			System.out.println("잘못 입력하셨습니다. 아이디와 비밀번호를 확인후 다시입력해 주세요");
			return false;
			
		}else {
			System.out.println("잘못 입력하셨습니다. 아이디와 비밀번호를 확인후 다시입력해 주세요");
			return false;
		}
	}
}

