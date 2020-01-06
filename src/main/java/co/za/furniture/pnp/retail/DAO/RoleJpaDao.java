package co.za.furniture.pnp.retail.DAO;

import co.za.furniture.pnp.retail.model.Role;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RoleJpaDao")
public interface RoleJpaDao extends JpaRepository<Role, ID> {
}
