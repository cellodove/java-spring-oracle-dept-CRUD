package min.dept.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import min.dept.contorl.DeptAction;
import min.dept.dao.DeptDAO;
import min.dept.model.DeptDTO;

public class DeptSearch implements DeptAction{

	@Override
	public void execute(Scanner scanner) {
		// 절대 경로를 지정하여 설정 파일 정보를 읽어 온다.
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		// Bean 객체를 호출한다.
		System.out.println("*****부서 목록*****");
		DeptDAO deptDAO = (DeptDAO) context.getBean("deptDAO");
		List<DeptDTO> list = deptDAO.getDeptList( );
		System.out.println(list);
	}
}
