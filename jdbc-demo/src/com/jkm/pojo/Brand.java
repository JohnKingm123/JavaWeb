package com.jkm.pojo;

public class Brand {
    private Integer id;     //主键
    private String brandName;     //名称
    private String companyName;     //公司
    private Integer ordered;     //排序权重
    private String description;     //描述
    private Integer status;     //可用

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatus() {
        return status;
    }
}
