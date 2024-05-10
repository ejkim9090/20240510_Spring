package kh.mclass.test1r.sub;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	public String method1() {
		return "서비스리턴값";
	}
}
