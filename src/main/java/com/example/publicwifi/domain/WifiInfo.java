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

    private String x_swifi_mgr_no;
    private String x_swifi_wrdofc;
    private String x_swifi_main_nm;
    private String x_swifi_adres1;
    private String x_swifi_adres2;
    private String x_swifi_instl_floor;
    private String x_swifi_instl_ty;
    private String x_swifi_instl_mby;
    private String x_swifi_svc_se;
    private String x_swifi_cmcwr;
    private String x_swifi_cnstc_year;
    private String x_swifi_inout_door;
    private String x_swifi_remars3;
    private String lat; // 위도
    private String lnt; // 경도
    private String work_dttm;
}
