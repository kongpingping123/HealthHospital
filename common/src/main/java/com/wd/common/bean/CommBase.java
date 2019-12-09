package com.wd.common.bean;

public class CommBase {



    public String benefitTaboo;
    public String chineseMedicineTreatment;
    public long createTime;
    public int diseaseCategoryId;
    public int id;
    public String pathology;
    public String symptom;

    public CommBase(String benefitTaboo, String chineseMedicineTreatment, long createTime, int diseaseCategoryId, int id, String pathology, String symptom) {
        this.benefitTaboo = benefitTaboo;
        this.chineseMedicineTreatment = chineseMedicineTreatment;
        this.createTime = createTime;
        this.diseaseCategoryId = diseaseCategoryId;
        this.id = id;
        this.pathology = pathology;
        this.symptom = symptom;
    }

    public String getBenefitTaboo() {
        return benefitTaboo;
    }

    public String getChineseMedicineTreatment() {
        return chineseMedicineTreatment;
    }

    public long getCreateTime() {
        return createTime;
    }

    public int getDiseaseCategoryId() {
        return diseaseCategoryId;
    }

    public int getId() {
        return id;
    }

    public String getPathology() {
        return pathology;
    }

    public String getSymptom() {
        return symptom;
    }

    @Override
    public String toString() {
        return "CommBase{" +
                "benefitTaboo='" + benefitTaboo + '\'' +
                ", chineseMedicineTreatment='" + chineseMedicineTreatment + '\'' +
                ", createTime=" + createTime +
                ", diseaseCategoryId=" + diseaseCategoryId +
                ", id=" + id +
                ", pathology='" + pathology + '\'' +
                ", symptom='" + symptom + '\'' +
                '}';
    }
}
