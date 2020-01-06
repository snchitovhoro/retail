package co.za.furniture.pnp.retail.DAO;

import co.za.furniture.pnp.retail.model.Category;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CategoryJpaDao")
public interface CategoryJpaDao extends JpaRepository<Category, ID> {
}
