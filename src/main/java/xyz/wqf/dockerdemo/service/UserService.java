package xyz.wqf.dockerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wqf.dockerdemo.domain.User;
import xyz.wqf.dockerdemo.repository.UserRepository;

/**
 * Created by Administrator on 2020/7/1.
 *
 * @author WeiQuanfu
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }
}
