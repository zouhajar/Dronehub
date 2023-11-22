package  test ;

import java.util.List;

public interface loginIDAO extends IDAO<Login> {
	public List<Login> getAll(String des);

}