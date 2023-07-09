package com.example.publicwifi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
    private String lat;
    private String lnt;
    private String workDttm;

}
