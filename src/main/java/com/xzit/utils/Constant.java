package com.xzit.utils;

/**
 * Created by huang on 2018/3/31.
 */
public class Constant {
    public static enum Authority{
        User(3,"用户"),Admin(1,"管理员"),Curator(2,"馆长");
      public   Integer key;
        public String name;

        Authority(Integer key, String name) {
            this.key = key;
            this.name = name;
        }
        public static String getName(int index) {
            for (Authority c : Authority.values()) {
                if (c.getKey() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static enum Del{
        isdel(1,"已删除"),nodel(0,"未删除");
        public Integer key;
        public String name;

        Del(Integer key, String des) {
            this.key = key;
            this.name = des;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getDes() {
            return name;
        }

        public void setDes(String des) {
            this.name = des;
        }

        public static String getName(int index) {
            for (Del c : Del.values()) {
                if (c.getKey() == index) {
                    return c.name;
                }
            }
            return null;
        }
    }
    public static enum Order{
        income(1,"收入"),outcome(-1,"支出");
        public   Integer key;
        public String name;

        Order(Integer key, String name) {
            this.key = key;
            this.name = name;
        }
        public static String getName(int index) {
            for (Authority c : Authority.values()) {
                if (c.getKey() == index) {
                    return c.name;
                }
            }
            return null;
        }
    }
public  static enum Medium{
        account(1,"账户"),card(2,"银行卡"),platform(3,"平台"),cancel(4,"退款");
    public   Integer key;
    public String name;

    Medium(Integer key, String name) {
        this.key = key;
        this.name = name;
    }
    public static String getName(int index) {
        for (Authority c : Authority.values()) {
            if (c.getKey() == index) {
                return c.name;
            }
        }
        return null;
    }
}
    public static enum UserState{
        isdel(1,"已禁用"),nodel(0,"未删除");
        public Integer key;
        public String name;

        UserState(Integer key, String des) {
            this.key = key;
            this.name = des;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getDes() {
            return name;
        }

        public void setDes(String des) {
            this.name = des;
        }

        public static String getName(int index) {
            for (Del c : Del.values()) {
                if (c.getKey() == index) {
                    return c.name;
                }
            }
            return null;
        }
    }
}
