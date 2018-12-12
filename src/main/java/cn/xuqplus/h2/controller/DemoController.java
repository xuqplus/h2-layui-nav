package cn.xuqplus.h2.controller;

import cn.xuqplus.h2.domain.Menu;
import cn.xuqplus.h2.domain.Role;
import cn.xuqplus.h2.domain.User;
import cn.xuqplus.h2.repository.MenuRepository;
import cn.xuqplus.h2.repository.RoleRepository;
import cn.xuqplus.h2.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api
@RestController
public class DemoController {
  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleRepository roleRepository;
  @Autowired
  MenuRepository menuRepository;

  @GetMapping("findMenu")
  public Set<Menu> findMenu(Long userId) {
    User user = userRepository.getOne(userId);
    List<Menu> menus = menuRepository.findByRoleInAndUrlIsNotNull(user.getRoles());
    Set r = new HashSet();
    menus.stream().forEach(menu -> addMenu(r, menu));
    return r;
  }

  private void addMenu(Set r, Menu menu) {
    if (null != menu.getParent() && !r.contains(menu.getParent())) addMenu(r, menu.getParent());
    r.add(new Menu.Vo(menu));
  }

  @PostMapping("user")
  public User user(User user) {
    return userRepository.save(user);
  }

  @PostMapping("role")
  public Role role(Role role) {
    return roleRepository.save(role);
  }

  @PostMapping("menu")
  public Menu menu(Menu menu) {
    return menuRepository.save(menu);
  }

  @GetMapping("list")
  public Object list(Integer type) {
    if (null == type || 0 == type) return userRepository.findAll();
    if (1 == type) return roleRepository.findAll();
    if (2 == type) return menuRepository.findAll();
    return userRepository.findAll();
  }
}
