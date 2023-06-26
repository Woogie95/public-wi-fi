package com.example.publicwifi.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class WifiInfo {

    private Double distance;
    private String mgrNo;
    private String wrdofc;
    private String mainNm;
    private String address1;
    private String address2;
    private String instlFloor;
    private String instlTy;
    private String instlMby;
    private String svcSe;
    private String cmcwr;
    private String cnstcYear;
    private String inoutDoor;
    private String remars3;
    private String lat; // 위도
    private String lnt; // 경도
    private String workDttm;

    public Double getDistance() {
        return distance;
    }

    public String getMgrNo() {
        return mgrNo;
    }

    public String getWrdofc() {
        return wrdofc;
    }

    public String getMainNm() {
        return mainNm;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getInstlFloor() {
        return instlFloor;
    }

    public String getInstlTy() {
        return instlTy;
    }

    public String getInstlMby() {
        return instlMby;
    }

    public String getSvcSe() {
        return svcSe;
    }

    public String getCmcwr() {
        return cmcwr;
    }

    public String getCnstcYear() {
        return cnstcYear;
    }

    public String getInoutDoor() {
        return inoutDoor;
    }

    public String getRemars3() {
        return remars3;
    }

    public String getLat() {
        return lat;
    }

    public String getLnt() {
        return lnt;
    }

    public String getWorkDttm() {
        return workDttm;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setMgrNo(String mgrNo) {
        this.mgrNo = mgrNo;
    }

    public void setWrdofc(String wrdofc) {
        this.wrdofc = wrdofc;
    }

    public void setMainNm(String mainNm) {
        this.mainNm = mainNm;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setInstlFloor(String instlFloor) {
        this.instlFloor = instlFloor;
    }

    public void setInstlTy(String instlTy) {
        this.instlTy = instlTy;
    }

    public void setInstlMby(String instlMby) {
        this.instlMby = instlMby;
    }

    public void setSvcSe(String svcSe) {
        this.svcSe = svcSe;
    }

    public void setCmcwr(String cmcwr) {
        this.cmcwr = cmcwr;
    }

    public void setCnstcYear(String cnstcYear) {
        this.cnstcYear = cnstcYear;
    }

    public void setInoutDoor(String inoutDoor) {
        this.inoutDoor = inoutDoor;
    }

    public void setRemars3(String remars3) {
        this.remars3 = remars3;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLnt(String lnt) {
        this.lnt = lnt;
    }

    public void setWorkDttm(String workDttm) {
        this.workDttm = workDttm;
    }
}
