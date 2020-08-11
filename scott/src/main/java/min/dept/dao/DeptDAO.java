package min.dept.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import min.dept.model.DeptDTO;
import min.dept.template.DeptDaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO implements DeptDaoService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 전체레코드를 검색한다.
	@Override
	public List<DeptDTO> getDeptList() {
		String sql = "select deptno, dname, loc from dept";
		return jdbcTemplate.query(sql, new RowMapper<DeptDTO>() {

			public DeptDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				DeptDTO deptDTO = new DeptDTO();
				deptDTO.setDeptno(resultSet.getInt("deptno"));
				deptDTO.setDname(resultSet.getString("dname"));
				deptDTO.setLoc(resultSet.getString("loc"));
				return deptDTO;
			}
		});
	}

	// 레코드를 추가한다.
	@Override
	public void add(int deptno, String dname, String loc) {
		String sql = "insert into dept (deptno,dname,loc) ";
		sql += " values(?,?,?)";

		jdbcTemplate.update(sql, deptno, dname, loc);
		System.out.println("추가되었습니다.");
	}

	// 레코드수정
	@Override
	public void update(int deptno, String dname, String loc) {
		String sql = "update dept set dname = ?, loc = ? ";
		sql += " where deptno = ?";

		// update 메소드로 SQL 문의 update 문을 실행한다.
		jdbcTemplate.update(sql, dname, loc, deptno);
		System.out.println("수정 되었습니다.");
	}

	@Override
	public void remove(int deptno) {
		String sql = "delete from dept ";
		sql += " where deptno= ?";
		// update 메소드로 SQL 문의 delete 문을 실행한다.
		jdbcTemplate.update(sql, deptno);
		System.out.println("삭제되었습니다.");

	}
}
