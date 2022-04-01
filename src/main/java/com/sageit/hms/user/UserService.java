package com.sageit.hms.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository urepo;

    public User userlogin(String email, String password) {
        User user = urepo.findByEmailAndPassword(email, password);
        return user;
    }

}
