package top.lixb.libsrc.bean;

import java.util.Date;

public class AppUpdateBean {
    /**
     * 版本号
     */
    private int verstionCode;

    /**
     * 版本名称
     */
    private String versionName;

    /**
     * 升级说明
     */
    private String updateDesc;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否强制升级
     */
    private boolean isCoerced;

    /**
     * 新版本下载地址
     */
    private String newVersionDownloadUrl;

    public int getVerstionCode() {
        return verstionCode;
    }

    public void setVerstionCode(int verstionCode) {
        this.verstionCode = verstionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUpdateDesc() {
        return updateDesc;
    }

    public void setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isCoerced() {
        return isCoerced;
    }

    public void setCoerced(boolean coerced) {
        isCoerced = coerced;
    }

    public String getNewVersionDownloadUrl() {
        return newVersionDownloadUrl;
    }

    public void setNewVersionDownloadUrl(String newVersionDownloadUrl) {
        this.newVersionDownloadUrl = newVersionDownloadUrl;
    }
}
