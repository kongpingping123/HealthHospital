package com.wd.common.bean;

import java.util.List;

public class SousuoBase {



    public List<DiseaseSearchVoListBean> diseaseSearchVoList;
    public List<DoctorSearchVoListBean> doctorSearchVoList;
    public List<DrugsSearchVoListBean> drugsSearchVoList;

        public List<DiseaseSearchVoListBean> getDiseaseSearchVoList() {
            return diseaseSearchVoList;
        }

        public void setDiseaseSearchVoList(List<DiseaseSearchVoListBean> diseaseSearchVoList) {
            this.diseaseSearchVoList = diseaseSearchVoList;
        }

        public List<DoctorSearchVoListBean> getDoctorSearchVoList() {
            return doctorSearchVoList;
        }

        public void setDoctorSearchVoList(List<DoctorSearchVoListBean> doctorSearchVoList) {
            this.doctorSearchVoList = doctorSearchVoList;
        }

        public List<DrugsSearchVoListBean> getDrugsSearchVoList() {
            return drugsSearchVoList;
        }

        public void setDrugsSearchVoList(List<DrugsSearchVoListBean> drugsSearchVoList) {
            this.drugsSearchVoList = drugsSearchVoList;
        }

        public static class DiseaseSearchVoListBean {
            /**
             * diseaseId : 123
             * diseaseName : 新生儿黄疸
             */

            public int diseaseId;
            public String diseaseName;

            public int getDiseaseId() {
                return diseaseId;
            }

            public void setDiseaseId(int diseaseId) {
                this.diseaseId = diseaseId;
            }

            public String getDiseaseName() {
                return diseaseName;
            }

            public void setDiseaseName(String diseaseName) {
                this.diseaseName = diseaseName;
            }
        }

        public static class DoctorSearchVoListBean {
            /**
             * doctorId : 1
             * doctorName : 张医生
             */

            public int doctorId;
            public String doctorName;

            public int getDoctorId() {
                return doctorId;
            }

            public void setDoctorId(int doctorId) {
                this.doctorId = doctorId;
            }

            public String getDoctorName() {
                return doctorName;
            }

            public void setDoctorName(String doctorName) {
                this.doctorName = doctorName;
            }
        }

        public static class DrugsSearchVoListBean {
            /**
             * drugsId : 59
             * drugsName :  [小施尔康]小儿多维生素咀嚼片(10)
             */

            public int drugsId;
            public String drugsName;

            public int getDrugsId() {
                return drugsId;
            }

            public void setDrugsId(int drugsId) {
                this.drugsId = drugsId;
            }

            public String getDrugsName() {
                return drugsName;
            }

            public void setDrugsName(String drugsName) {
                this.drugsName = drugsName;
            }

    }
}
