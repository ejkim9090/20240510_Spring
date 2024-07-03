package kh.mclass.demo8;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Emp {
	private String empno;
	private String ename;
	private String deptno;

}
