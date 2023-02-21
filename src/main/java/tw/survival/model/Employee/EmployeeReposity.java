package tw.survival.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeReposity extends JpaRepository<EmployeeBean, Integer> {

	@Query(value="Select * from Employee where account=:account and password=:password",nativeQuery = true)
	public EmployeeBean findByAccount(@Param(value = "account")String account,@Param(value = "password")String password);
}
