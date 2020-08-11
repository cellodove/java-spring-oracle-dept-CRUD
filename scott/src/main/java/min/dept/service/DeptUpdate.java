package min.dept.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import min.dept.contorl.DeptAction;
import min.dept.dao.DeptDAO;
import min.dept.model.DeptDTO;

public class DeptUpdate implements DeptAction {

	@Override
	public void execute(Scanner scanner) {
		// 절대 경로를 지정하여 설정 파일 정보를 읽어 온다.
		ApplicationContext context = new GenericXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		// Bean 객체를 호출한다.
		DeptDAO deptDAO = (DeptDAO) context.getBean("deptDAO");

		List<DeptDTO> list = deptDAO.getDeptList();
		System.out.println(list);
		System.out.println();
		System.out.println("*****부서 수정*****");
		System.out.println("수정할 부서의 번호를 입력하세요");
		int deptno = scanner.nextInt();
		System.out.print("수정할 부서이름을 입력하세요.: " + " ");
		String dname = scanner.next();
		System.out.print("수정할 지역을 입력하세요.: " + " ");
		String loc = scanner.next();
		deptDAO.update(deptno, dname, loc);

		System.out.println(list);

	}

}
