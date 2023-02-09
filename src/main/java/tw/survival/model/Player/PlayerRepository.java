package tw.survival.model.Player;



import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface PlayerRepository extends JpaRepository<PlayerBean, Integer> {

	public default boolean CheckLogin(PlayerBean player,Session session) {
		
		String hqlstr="from Player where account =:act and password =:psw";
		Query<PlayerBean> query=session.createQuery(hqlstr,PlayerBean.class);
		query.setParameter("act",player.getAccount());
		query.setParameter("psw",player.getPassword());
		
		PlayerBean bean=query.uniqueResult();
		return bean!=null;
	}
}
