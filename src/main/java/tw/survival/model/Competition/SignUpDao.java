package tw.survival.model.Competition;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SignUpDao {

	@PersistenceContext
	private EntityManager em;

	public List<SignUpBean> selectSQL(CompetitionSearchCondititonsDto conditions) {
		return null;
	}

	public String sql(CompetitionSearchCondititonsDto conditions) {
		StringBuilder sql = new StringBuilder("select * from SignUp ");
		sql.append("where 1=1 ");
		return sql.toString();
	}

}