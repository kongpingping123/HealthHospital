package com.wd.common.bean;

/**
 * @Description: 作用描述 病友圈列表展示
 * @CreateDate: 2019/12/5 14:53
 * @Author: 作者名
 * @Version: 1.0
 */
public class CircleBean {

        /**
         * amount : 0
         * collectionNum : 0
         * commentNum : 0
         * detail : 呀呀呀
         * releaseTime : 1575475200000
         * sickCircleId : 1639
         * title : 嘿嘿嘿
         */
        private int amount;
        private int collectionNum;
        private int commentNum;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
                return amount;
        }

        public void setAmount(int amount) {
                this.amount = amount;
        }

        public int getCollectionNum() {
                return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
                this.collectionNum = collectionNum;
        }

        public int getCommentNum() {
                return commentNum;
        }

        public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
        }

        public String getDetail() {
                return detail;
        }

        public void setDetail(String detail) {
                this.detail = detail;
        }

        public long getReleaseTime() {
                return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
                this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
                return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
                this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }
}
