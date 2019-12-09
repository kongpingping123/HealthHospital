package com.wd.common.bean;

import java.util.List;

public class XiangqingBase {


    public int id;
    public int plateId;
    public long releaseTime;
    public String source;
    public String thumbnail;
    public String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPlateId() {
            return plateId;
        }

        public void setPlateId(int plateId) {
            this.plateId = plateId;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

}
