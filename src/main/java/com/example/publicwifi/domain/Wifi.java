package com.example.publicwifi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Wifi {

    private Double distance;
    private String managementNumber;
    private String city;
    private String wifiName;
    private String streetAddress;
    private String detailedAddress;
    private String installLocation;
    private String installType;
    private String installOrganization;
    private String serviceCategory;
    private String networkType;
    private Integer networkInstallDate;
    private String networkCategory;
    private String wifiConnectEnvironment;
    private Double longitude; // x경도
    private Double latitude; // y위도
    private LocalDateTime resisterDate;

}
