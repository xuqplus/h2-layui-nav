package cn.xuqplus.h2.repository;

import cn.xuqplus.h2.domain.Menu;
import cn.xuqplus.h2.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MenuRepository extends JpaRepository<Menu, Long> {
  List<Menu> findByRoleIn(Set<Role> roles);

  List<Menu> findByRoleInAndUrlIsNotNull(Set<Role> roles);
}
