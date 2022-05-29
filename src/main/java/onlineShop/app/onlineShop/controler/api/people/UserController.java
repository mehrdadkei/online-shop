package onlineShop.app.onlineShop.controler.api.people;

import onlineShop.app.onlineShop.confige.JwtTokenUtil;
import onlineShop.app.onlineShop.entities.people.User;
import onlineShop.app.onlineShop.helper.exception.JwtTokenException;
import onlineShop.app.onlineShop.helper.ui.ResponseStatus;
import onlineShop.app.onlineShop.helper.ui.ServiceResponse;
import onlineShop.app.onlineShop.helper.uimodels.people.UserVm;
import onlineShop.app.onlineShop.services.people.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ServiceResponse<UserVm> login(@RequestBody User user) {
        User userdata = service.auth(user.getUsername(), user.getPassword());
        if (userdata == null) {
            return new ServiceResponse<UserVm>(ResponseStatus.failed, "incorrect username or password");
        }
        UserVm userVm = new UserVm(userdata);
        String token = jwtTokenUtil.generateToken(userVm);
        userVm.setToken(token);

        return new ServiceResponse<UserVm>(ResponseStatus.success, userVm);

    }

    @GetMapping("/{id}")
    public ServiceResponse<UserVm> search(@PathVariable long id) {
        User result = service.getById(id);
        return new ServiceResponse<UserVm>(ResponseStatus.success, new UserVm(result));
    }

    @GetMapping("/getUserInfo")
    public ServiceResponse<UserVm> getUserInfo(HttpServletRequest Request) {
        try {
            String requestTokenHeader = Request.getHeader("Authorization");
            if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer "))
                throw new JwtTokenException("request token header does not set");

            String token = requestTokenHeader.substring(7);
            String username = jwtTokenUtil.getUsernameFromToken(token);
            if (username == null)
                throw new JwtTokenException("username can not resolve");
            User result = service.getByUsername(username);
            return new ServiceResponse<UserVm>(ResponseStatus.success, new UserVm(result));
        } catch (Exception ex) {
            return new ServiceResponse<UserVm>(ex);
        }
    }


    @PostMapping("/")
    public ServiceResponse<UserVm> add(@RequestBody User data) {
        try {
            User result = service.add(data);
            return new ServiceResponse<UserVm>(ResponseStatus.success, new UserVm(result));
        } catch (Exception e) {
            return new ServiceResponse<UserVm>(e);
        }
    }

    @PutMapping("/")
    public ServiceResponse<UserVm> update(@RequestBody User data) {
        try {
            User update = service.update(data);
            return new ServiceResponse<UserVm>(ResponseStatus.success, new UserVm(update));
        } catch (Exception e) {
            return new ServiceResponse<UserVm>(e);
        }
    }

    @DeleteMapping("{id}")
    public ServiceResponse<Boolean> delete(@PathVariable long id) {
        try {
            boolean delete = service.delete(id);
            return new ServiceResponse<Boolean>(ResponseStatus.success, delete);
        } catch (Exception e) {
            return new ServiceResponse<Boolean>(e);
        }
    }

    @PutMapping("/changePassword")
    public ServiceResponse<UserVm> updatePass(@RequestBody UserVm data) {
        try {
            User result = service.updatePassword(data.getId(), data.getPassword(), data.getNewPassword());
            return new ServiceResponse<UserVm>(ResponseStatus.success, new UserVm(result));
        } catch (Exception e) {
            return new ServiceResponse<UserVm>(e);
        }
    }
}

