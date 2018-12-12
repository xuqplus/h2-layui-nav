package cn.xuqplus.h2.repository;

import cn.xuqplus.h2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
