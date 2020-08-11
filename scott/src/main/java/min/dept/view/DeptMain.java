package min.dept.view;

import java.util.Scanner;
import min.dept.service.*;

public class DeptMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isStop = false;
		do {
			System.out.println();
			System.out.println("다음 메뉴 중 하나를 입력하세요.");
			System.out.print("1.자료 보기" + " ");
			System.out.print("2.자료 등록" + " ");
			System.out.print("3.자료 수정" + " ");
			System.out.print("4.자료 삭제" + " ");
			System.out.println("5.종료");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			String menu = scanner.next();
			switch (menu) {
			case "1":
				DeptSearch deptSearch = new DeptSearch();
				deptSearch.execute(scanner);
				break;
			case "2":
				DeptInsert deptInsert = new DeptInsert();
				deptInsert.execute(scanner);
				break;
			case "3":
				DeptUpdate deptUpdate = new DeptUpdate();
				deptUpdate.execute(scanner);
				break;
			case "4":
				DeptDelete deptDelete = new DeptDelete();
				deptDelete.execute(scanner);
				break;
			case "5":
				isStop = true;
				System.out.println("프로그램을 종료합니다.");
			}
		} while (!isStop);
	}
}