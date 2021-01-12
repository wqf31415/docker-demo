package xyz.wqf.dockerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wqf.dockerdemo.domain.User;

/**
 * Created by Administrator on 2020/7/1.
 *
 * @author WeiQuanfu
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
