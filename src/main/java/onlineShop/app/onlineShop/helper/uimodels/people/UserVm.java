package onlineShop.app.onlineShop.helper.uimodels.people;

import onlineShop.app.onlineShop.entities.people.User;
import onlineShop.app.onlineShop.enums.UserRole;

public class UserVm {
    private long id;
    private String username;
    private String name;
    private String lastName;
    private String password;
    private String newPassword;
    private String email;
    private UserRole role ;
    private boolean enable;
    private String token;
    private String fullName;

    public UserVm() {
    }

    public UserVm(User user) {
        setUsername(user.getUsername());
        setId(user.getId());
        setName(user.getName());
        setLastName(user.getLastName());
        setEmail(user.getEmail());
        setEnable(user.isEnable());
        setRole(user.getRole());
        setFullName(user.getName()+""+user.getLastName());
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
