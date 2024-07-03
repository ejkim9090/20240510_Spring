package kh.mclass.demo8;

import java.util.List;


public interface EmpRepository {
	List<Emp> selectAll();
	List<Emp> selectFind(String ename);
	int insert(Emp emp);
}
