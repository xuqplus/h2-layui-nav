package cn.xuqplus.h2.listener;

import cn.xuqplus.h2.domain.Menu;
import cn.xuqplus.h2.domain.Role;
import cn.xuqplus.h2.domain.User;
import cn.xuqplus.h2.repository.MenuRepository;
import cn.xuqplus.h2.repository.RoleRepository;
import cn.xuqplus.h2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitListener implements ApplicationListener<ApplicationStartedEvent> {

  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleRepository roleRepository;
  @Autowired
  MenuRepository menuRepository;

  @Override
  public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
    User user1 = new User();
    user1.setId(1L);
    user1.setName("1号用户");
    userRepository.save(user1);
    User user2 = new User();
    user2.setId(2L);
    user2.setName("2号用户");
    userRepository.save(user2);

    Role roleA = new Role();
    roleA.setId(1L);
    roleA.setName("A角色");
    roleRepository.save(roleA);
    Role roleB = new Role();
    roleB.setId(2L);
    roleB.setName("B角色");
    roleRepository.save(roleB);
    Role roleC = new Role();
    roleC.setId(3L);
    roleC.setName("C角色");
    roleRepository.save(roleC);

    Menu menuA = new Menu();
    menuA.setId(1L);
    menuA.setName("A菜单");
    menuA.setRole(roleA);
    menuRepository.save(menuA);

    Menu menuB = new Menu();
    menuB.setId(2L);
    menuB.setName("B菜单");
    menuB.setRole(roleB);
    menuRepository.save(menuB);

    Menu menuC = new Menu();
    menuC.setId(3L);
    menuC.setName("C菜单");
    menuC.setRole(roleC);
    menuRepository.save(menuC);

    Menu menuD = new Menu();
    menuD.setId(4L);
    menuD.setName("D菜单");
    menuD.setRole(roleC);
    menuD.setUrl("d.html");
    menuRepository.save(menuD);

    Set<Role> user1Roles = new HashSet<>();
    user1Roles.add(roleA);
    user1Roles.add(roleB);
    user1.setRoles(user1Roles);
    userRepository.save(user1);
    Set<Role> user2Roles = new HashSet<>();
    user2Roles.add(roleB);
    user2Roles.add(roleC);
    user2.setRoles(user2Roles);
    userRepository.save(user2);

    Menu menuA_X = new Menu();
    menuA_X.setId(11L);
    menuA_X.setRole(roleA);
    menuA_X.setName("A的子菜单_X");
    menuA_X.setParent(menuA);
    menuRepository.save(menuA_X);
    Menu menuA_y = new Menu();
    menuA_y.setId(12L);
    menuA_y.setRole(roleA);
    menuA_y.setName("A的子菜单_y");
    menuA_y.setParent(menuA);
    menuA_y.setUrl("a_y.html");
    menuRepository.save(menuA_y);
    Menu menuA_z = new Menu();
    menuA_z.setId(13L);
    menuA_z.setRole(roleA);
    menuA_z.setName("A的子菜单_z");
    menuA_z.setParent(menuA);
    menuA_z.setUrl("a_z.html");
    menuRepository.save(menuA_z);
    Menu menuB_x = new Menu();
    menuB_x.setId(21L);
    menuB_x.setRole(roleB);
    menuB_x.setName("B的子菜单_x");
    menuB_x.setParent(menuB);
    menuB_x.setUrl("b_x.html");
    menuRepository.save(menuB_x);
    Menu menuB_Y = new Menu();
    menuB_Y.setId(22L);
    menuB_Y.setRole(roleB);
    menuB_Y.setName("B的子菜单_Y");
    menuB_Y.setParent(menuB);
    menuRepository.save(menuB_Y);
    Menu menuC_x = new Menu();
    menuC_x.setId(31L);
    menuC_x.setRole(roleC);
    menuC_x.setName("C的子菜单_x");
    menuC_x.setParent(menuC);
    menuC_x.setUrl("c_x.html");
    menuRepository.save(menuC_x);
    Menu menuC_y = new Menu();
    menuC_y.setId(32L);
    menuC_y.setRole(roleC);
    menuC_y.setName("C的子菜单_y");
    menuC_y.setParent(menuC);
    menuC_y.setUrl("c_y.html");
    menuRepository.save(menuC_y);
    Menu menuC_z = new Menu();
    menuC_z.setId(33L);
    menuC_z.setRole(roleC);
    menuC_z.setName("C的子菜单_z");
    menuC_z.setParent(menuC);
    menuC_z.setUrl("c_z.html");
    menuRepository.save(menuC_z);

    Menu menuA_X_a = new Menu();
    menuA_X_a.setId(101L);
    menuA_X_a.setRole(roleA);
    menuA_X_a.setName("A_X的子菜单_a");
    menuA_X_a.setParent(menuA_X);
    menuA_X_a.setUrl("a_x_a.html");
    menuRepository.save(menuA_X_a);
    Menu menuB_Y_a = new Menu();
    menuB_Y_a.setId(201L);
    menuB_Y_a.setRole(roleB);
    menuB_Y_a.setName("B_Y的子菜单_a");
    menuB_Y_a.setParent(menuB_Y);
    menuB_Y_a.setUrl("b_y_a.html");
    menuRepository.save(menuB_Y_a);
  }
}
