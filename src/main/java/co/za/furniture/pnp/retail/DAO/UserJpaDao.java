package co.za.furniture.pnp.retail.DAO;

import co.za.furniture.pnp.retail.model.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaDao extends JpaRepository<User, ID> {

    <S extends User> S save(S entity);
}
