package  test ;

import java.util.List;

public interface SignupIDAO extends IDAO<Login> {
	public List<Signup> getAll(String des);

}
