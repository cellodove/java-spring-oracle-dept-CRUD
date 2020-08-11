package min.dept.template;

import java.util.List;

import min.dept.model.DeptDTO;

public interface DeptDaoService {
	
	List<DeptDTO> getDeptList();
	
	public void add(int deptno,String dname,String loc);
	public void update(int deptno, String dname, String loc);
	public void remove(int deptno);
}
