package dataInfo;

import java.util.HashMap;
import java.util.Map;

public class ProfileDataSet {
	public static Map<String, ProfileVO> profileList = new HashMap<String, ProfileVO>();
	public ProfileDataSet() {}
	
	public static void basicProfileSet() {
		profileList.put("sunsin", new ProfileVO("sunsin", "1234","이순신","010-1111-2222","2021-01-05", 3, 50000 ));
		profileList.put("abcd", new ProfileVO("abcd", "qwer","강감찬","010-2424-5555","2020-05-11", 10, 150000 ));
		profileList.put("zzxx", new ProfileVO("zzxx", "aaaa","유재석","010-9999-2877","2017-02-04", 40, 20000 ));
		profileList.put("nugu", new ProfileVO("nugu", "4444","김길동","010-4244-5353","2020-05-02", 24, 10000 ));
		profileList.put("qqqccc", new ProfileVO("qqqccc", "1111","홍길동","010-2321-1122","2019-10-25", 22, 90000 ));
	}
}


















