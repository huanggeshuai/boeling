package com.xzit.service.Impl;

import com.xzit.entity.Menu;
import com.xzit.entity.MenuExample;
import com.xzit.mapper.MenuMapper;
import com.xzit.service.MenuService;
import com.xzit.utils.Dateutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huang on 2018/3/28.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> kookforRootMenu() {
        MenuExample menuExample=new MenuExample();
        MenuExample.Criteria criteria=menuExample.createCriteria();
        criteria.andParentidEqualTo(2);
        List<Menu> menus=menuMapper.selectByExample(menuExample);
        return menus;
    }

    public List<Menu> kookforChildMenu(Integer pid) {

        MenuExample menuExample=new MenuExample();
        MenuExample.Criteria criteria=menuExample.createCriteria();
        criteria.andParentidEqualTo(pid);
        List<Menu> menus=menuMapper.selectByExample(menuExample);
        return menus;
    }

    public boolean addMenu(Menu menu) {
       // Date date=new Date();
        menu.setCreatetime(Dateutils.getDate());
        int num=menuMapper.insertSelective(menu);
        if(num>0)
        return true;
        else return false;
    }

    public int deleteMenu(Integer[] mid) {
        if(mid.length>0){
            List<Integer> mids=new ArrayList<Integer>();
            for(int i=0;i<mid.length;i++){
                mids.add(mid[i]);
            }
            MenuExample menuExample=new MenuExample();
            MenuExample.Criteria criteria=menuExample.createCriteria();
            criteria.andMidIn(mids);

            return menuMapper.deleteByExample(menuExample);
        }
       else return -1;
    }

    public Menu allmenu(Integer pid) {

        return menuMapper.selectchildrenByid(pid);
    }

    public List<Menu> menus() {
        return menuMapper.selectchildbypartent(2);
    }

    public int deleteMenu(List mid) {
        MenuExample menuExample=new MenuExample();
        MenuExample.Criteria criteria=menuExample.createCriteria();
        criteria.andMidIn(mid);

        return menuMapper.deleteByExample(menuExample);
    }

    public boolean idisonly(Integer id) {
        MenuExample menuExample=new MenuExample();
        MenuExample.Criteria criteria=menuExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<Menu> menus=menuMapper.selectByExample(menuExample);
        if(menus.size()>0)
        return false;
        else return true;
    }

    public Menu findbyprimyid(Integer mid) {
        return menuMapper.selectByPrimaryKey(mid);
    }

    public boolean editmenu(Menu menu) {
        menu.setEdittime(Dateutils.getDate());
        int i=menuMapper.updateByPrimaryKeySelective(menu);
        if(i>0)
        return true;
        else return false;
    }

}
