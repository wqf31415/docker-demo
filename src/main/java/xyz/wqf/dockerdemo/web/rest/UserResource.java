package xyz.wqf.dockerdemo.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wqf.dockerdemo.annotation.AnnoAspect;
import xyz.wqf.dockerdemo.domain.User;
import xyz.wqf.dockerdemo.repository.UserRepository;
import xyz.wqf.dockerdemo.service.UserService;

import java.util.Optional;

/**
 * Created by Administrator on 2020/7/1.
 *
 * @author WeiQuanfu
 */
@RestController
@RequestMapping(value = "/api")
public class UserResource {
    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public ResponseEntity<User> save(User user){
        if (user == null){
            user = new User();
            user.setName("admin");
            user.setPwd("admin");
        }
        user = userService.save(user);
        return ResponseEntity.ok(user);
    }

    @AnnoAspect("User")
    @RequestMapping("/users/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
