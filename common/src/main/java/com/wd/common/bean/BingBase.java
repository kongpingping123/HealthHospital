package com.wd.common.bean;

import java.util.List;

public class BingBase {




        public int departmentId;
        public int id;
        public String name;

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;

    }

    @Override
    public String toString() {
        return "BingBase{" +
                "departmentId=" + departmentId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
