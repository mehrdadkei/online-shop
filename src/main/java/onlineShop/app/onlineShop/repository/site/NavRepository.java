package onlineShop.app.onlineShop.repository.site;

import onlineShop.app.onlineShop.entities.site.Nav;
import onlineShop.app.onlineShop.entities.site.Slider;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavRepository extends PagingAndSortingRepository<Nav,Long> {
    List<Nav> findAllByEnableIsTrue(Sort sort);
    Nav findTopByOrderByItemOrderDesc();
    Nav findTopByItemOrder(int itemOrder);
}
