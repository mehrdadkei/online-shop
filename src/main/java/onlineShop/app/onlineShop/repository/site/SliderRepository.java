package onlineShop.app.onlineShop.repository.site;

import onlineShop.app.onlineShop.entities.site.Slider;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderRepository extends PagingAndSortingRepository<Slider,Long> {

   List<Slider>findAllByEnableIsTrue(Sort sort);
}
