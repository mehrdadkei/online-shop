package onlineShop.app.onlineShop.repository.site;

import onlineShop.app.onlineShop.entities.site.Content;
import onlineShop.app.onlineShop.entities.site.Nav;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends PagingAndSortingRepository<Content,Long> {
    Content findFirstByKey(String key);
}
