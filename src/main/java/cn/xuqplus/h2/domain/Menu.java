package cn.xuqplus.h2.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Menu {
  @Id
  private Long id;
  private String name;
  private String url;
  @ManyToOne
  private Menu parent;
  @ManyToOne
  private Role role;

  @Data
  public static class Vo {
    private Long id;
    private String name;
    private String url;
    private Long parentId;

    public Vo(Menu menu) {
      this.id = menu.id;
      this.name = menu.name;
      this.url = menu.url;
      if (null != menu.getParent()) {
        this.parentId = menu.getParent().getId();
      }
    }
  }
}
