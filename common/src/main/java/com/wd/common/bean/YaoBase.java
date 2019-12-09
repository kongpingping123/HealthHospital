package com.wd.common.bean;

import java.util.List;

public class YaoBase {



    public int drugsCategoryId;
    public int id;
    public String name;
    public String picture;

        public int getDrugsCategoryId() {
            return drugsCategoryId;
        }

        public void setDrugsCategoryId(int drugsCategoryId) {
            this.drugsCategoryId = drugsCategoryId;
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

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

}
