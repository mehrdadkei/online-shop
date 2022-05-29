package onlineShop.app.onlineShop.repository.people;

import onlineShop.app.onlineShop.entities.people.Customer;
import onlineShop.app.onlineShop.entities.people.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findFirstByUsernameAndPassword(String username , String password);
    User findFirstByUsername(String username);
}
