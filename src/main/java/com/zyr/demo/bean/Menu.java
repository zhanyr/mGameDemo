package com.zyr.demo.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Menu implements Serializable {
    private static final long serialVersionUID = 3535301802680517238L;

    private String id;

    private String menuname;

    private String url;

    private String menuCode;

    private Set<Menu> children = new HashSet<Menu>();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Menu) {
            Menu menu = (Menu) obj;
            if (menu.getId().equals(this.getId())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Menu> getChildren() {
        return children;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

}
