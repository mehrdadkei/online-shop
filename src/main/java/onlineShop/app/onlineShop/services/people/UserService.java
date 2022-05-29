package onlineShop.app.onlineShop.services.people;

import onlineShop.app.onlineShop.entities.people.User;

import onlineShop.app.onlineShop.helper.exception.DataNotFoundException;
import onlineShop.app.onlineShop.helper.security.Sha1Security;
import onlineShop.app.onlineShop.repository.people.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static onlineShop.app.onlineShop.helper.security.Sha1Security.encryptPassword;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User auth(String username , String password) {
       try {
           password= encryptPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return repository.findFirstByUsernameAndPassword(username,password);

    }

    public User getByUsername(String username ) {

        return repository.findFirstByUsername(username);

    }

    public User getById(long id) {
        Optional<User> date = repository.findById(id);
        if (date.isPresent()) return date.get();
        return null;
    }

    public User add(User data) {
        return repository.save(data);
    }

    public User update(User data) throws DataNotFoundException {
        User oldData = getById(data.getId());

        if (oldData == null) {
            throw new DataNotFoundException("data with " + data.getId() + " not found ");
        }

        oldData.setEnable(data.isEnable());
        oldData.setEmail(data.getEmail());
        oldData.setLastName(data.getLastName());
        oldData.setName(data.getName());
        return repository.save(oldData);
    }

    public boolean delete(long id) throws DataNotFoundException {
        User del = getById(id);
        if (del == null) {
            throw new DataNotFoundException("data with " + id + " not found ");
        }
        repository.deleteById(id);
        return true;
    }

    public User updatePassword(long id , String oldPassword , String newPassword) throws DataNotFoundException {
        try {
            oldPassword= encryptPassword(oldPassword);
            newPassword= encryptPassword(newPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = getById(id);
        if (user == null) {
            throw new DataNotFoundException("data with id " + id + " not found ");
        }
        if (! user.getPassword().equals(oldPassword)){
            throw new DataNotFoundException("invalid password");
        }
        user.setPassword(newPassword);
        return repository.save(user);

    }

}
