package com.xzit.service;

import com.xzit.entity.Menu;

import java.util.List;

/**
 * Created by huang on 2018/3/28.
 */
public interface MenuService {
    List<Menu> kookforRootMenu();
    List<Menu> kookforChildMenu(Integer pid);
    boolean addMenu(Menu menu);
    int deleteMenu(Integer mid[]);
    Menu allmenu(Integer pid);
    List<Menu> menus();
    int deleteMenu(List mid);
    boolean idisonly(Integer id);
    Menu findbyprimyid(Integer mid);
    boolean editmenu(Menu menu);

}
