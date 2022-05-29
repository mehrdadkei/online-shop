package onlineShop.app.onlineShop.services.site;

import onlineShop.app.onlineShop.entities.site.Nav;
import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.repository.site.NavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NavService {

    @Autowired
    private NavRepository repository;

    public List<Nav> findAllOrdersByOrderItem() {
        return repository.findAllByEnableIsTrue(Sort.by("ItemOrder"));
    }

    public List<Nav> getAll(Integer pageSize , Integer pageNumber) {
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("itemOrder"));
        Page<Nav> all = repository.findAll(page);
        return all.toList();
    }

    public long totalCount () {
        long count = repository.count();
        return count;
    }

    public Nav getById(long id) {
        Optional<Nav> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public Nav add(Nav data) {
        return repository.save(data);
    }

    public Nav update(Nav data) throws DataNotFoundException {
        Nav oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setEnable(data.isEnable());
        oldData.setItemOrder(data.getItemOrder());
        oldData.setTitle(data.getTitle());
        oldData.setLink(data.getLink());

        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        Nav del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }
    public Nav changingOrder(long id , Integer direction) throws Exception {
        Nav item=getById(id);
        if (item==null)
            throw new Exception("item not found");
        switch (direction){
            case 1:
                if (item.getItemOrder() <=1)
                    return item;
                break;
            case 2: //down
                break;
        }

    }
}
