package zemian.jpaexample.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import zemian.jpaexample.dao.UserDao;
import zemian.jpaexample.data.User;
import zemian.service.logging.Logger;
import zemian.service.security.Encrypt;

@Stateless
public class UserService {
    private static final Logger LOGGER = new Logger(UserService.class);
    
    @Inject
    private UserDao userDao;
    
    @Inject
    private Encrypt encrypt;

    @PostConstruct
    public void init() {
        LOGGER.info("Service inited.");
    }
    
    public void encryptPasswordAndSaveUser(User user, String plainPassword) {
        byte[] hashedPassword = encrypt.encrypt(plainPassword.getBytes(StandardCharsets.UTF_8));
        user.setPassword(new String(hashedPassword, StandardCharsets.UTF_8));
        userDao.save(user);
    }

    public List<User> findMostActiveUsers() {
        LOGGER.debug("Finding all active users.");
        LOGGER.info("Using userDao=%s", userDao);
        return userDao.findMostActiveUsers();
    }
}
