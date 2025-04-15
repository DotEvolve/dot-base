package net.dotevolve.base.utils;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConversionUtils {
    @Autowired
    DateUtil dateUtil;

    public double sat2act(double sat_composite, double act_composite) {
        int converted_act_composite = 0;
        if (sat_composite > 0) {

            converted_act_composite = (sat_composite >= 1570 ? 1 : 0) * 36
                    + (sat_composite < 1570 && sat_composite >= 1530 ? 1 : 0) * 35 +
                    (sat_composite < 1530 && sat_composite >= 1490 ? 1 : 0) * 34
                    + (sat_composite < 1490 && sat_composite >= 1450 ? 1 : 0) * 33 +
                    (sat_composite < 1450 && sat_composite >= 1420 ? 1 : 0) * 32
                    + (sat_composite < 1420 && sat_composite >= 1390 ? 1 : 0) * 31 +
                    (sat_composite < 1390 && sat_composite >= 1360 ? 1 : 0) * 30
                    + (sat_composite < 1360 && sat_composite >= 1330 ? 1 : 0) * 29 +
                    (sat_composite < 1330 && sat_composite >= 1300 ? 1 : 0) * 28
                    + (sat_composite < 1300 && sat_composite >= 1260 ? 1 : 0) * 27 +
                    (sat_composite < 1260 && sat_composite >= 1230 ? 1 : 0) * 26
                    + (sat_composite < 1230 && sat_composite >= 1200 ? 1 : 0) * 25 +
                    (sat_composite < 1200 && sat_composite >= 1160 ? 1 : 0) * 24
                    + (sat_composite < 1160 && sat_composite >= 1130 ? 1 : 0) * 23 +
                    (sat_composite < 1130 && sat_composite >= 1100 ? 1 : 0) * 22
                    + (sat_composite < 1100 && sat_composite >= 1060 ? 1 : 0) * 21 +
                    (sat_composite < 1060 && sat_composite >= 1030 ? 1 : 0) * 20
                    + (sat_composite < 1030 && sat_composite >= 990 ? 1 : 0) * 19 +
                    (sat_composite < 990 && sat_composite >= 960 ? 1 : 0) * 18
                    + (sat_composite < 960 && sat_composite >= 920 ? 1 : 0) * 17 +
                    (sat_composite < 920 && sat_composite >= 880 ? 1 : 0) * 16
                    + (sat_composite < 880 && sat_composite >= 830 ? 1 : 0) * 15 +
                    (sat_composite < 830 && sat_composite >= 780 ? 1 : 0) * 14
                    + (sat_composite < 780 && sat_composite >= 730 ? 1 : 0) * 13 +
                    (sat_composite < 730 && sat_composite >= 690 ? 1 : 0) * 12
                    + (sat_composite < 690 && sat_composite >= 650 ? 1 : 0) * 11 +
                    (sat_composite < 650 && sat_composite >= 620 ? 1 : 0) * 10
                    + (sat_composite < 620 && sat_composite >= 590 ? 1 : 0) * 9;

        } else {
            converted_act_composite = 0;
        }

        if (act_composite > 0) {
            act_composite = Math.max(converted_act_composite, act_composite);
        } else {

            act_composite = converted_act_composite;
        }
        return act_composite;
    }

    public double clt2act(double clt_composite, double act_composite) {
        int converted_act_composite = 0;
        if (clt_composite > 0) {

            converted_act_composite = (clt_composite >= 111 ? 1 : 0) * 36
                    + (clt_composite < 111 && clt_composite >= 107 ? 1 : 0) * 35 +
                    (clt_composite < 107 && clt_composite >= 103 ? 1 : 0) * 34
                    + (clt_composite < 103 && clt_composite >= 100 ? 1 : 0) * 33 +
                    (clt_composite < 100 && clt_composite >= 97 ? 1 : 0) * 32
                    + (clt_composite < 97 && clt_composite >= 94 ? 1 : 0) * 31 +
                    (clt_composite < 94 && clt_composite >= 92 ? 1 : 0) * 30
                    + (clt_composite < 92 && clt_composite >= 89 ? 1 : 0) * 29 +
                    (clt_composite < 89 && clt_composite >= 86 ? 1 : 0) * 28
                    + (clt_composite < 86 && clt_composite >= 84 ? 1 : 0) * 27 +
                    (clt_composite < 84 && clt_composite >= 81 ? 1 : 0) * 26
                    + (clt_composite < 81 && clt_composite >= 78 ? 1 : 0) * 25 +
                    (clt_composite < 78 && clt_composite >= 76 ? 1 : 0) * 24
                    + (clt_composite < 76 && clt_composite >= 74 ? 1 : 0) * 23 +
                    (clt_composite < 74 && clt_composite >= 72 ? 1 : 0) * 22
                    + (clt_composite < 72 && clt_composite >= 68 ? 1 : 0) * 21 +
                    (clt_composite < 68 && clt_composite >= 66 ? 1 : 0) * 20
                    + (clt_composite < 66 && clt_composite >= 64 ? 1 : 0) * 19 +
                    (clt_composite < 64 && clt_composite >= 61 ? 1 : 0) * 18
                    + (clt_composite < 61 && clt_composite >= 57 ? 1 : 0) * 17 +
                    (clt_composite < 57 && clt_composite >= 55 ? 1 : 0) * 16
                    + (clt_composite < 55 && clt_composite >= 52 ? 1 : 0) * 15 +
                    (clt_composite < 52 && clt_composite >= 49 ? 1 : 0) * 14
                    + (clt_composite < 49 && clt_composite >= 46 ? 1 : 0) * 13 +
                    (clt_composite < 46 && clt_composite >= 44 ? 1 : 0) * 12
                    + (clt_composite < 44 && clt_composite >= 40 ? 1 : 0) * 11 +
                    (clt_composite < 40 ? 1 : 0) * 10;
        } else {
            converted_act_composite = 0;
        }

        if (act_composite > 0) {
            act_composite = Math.max(converted_act_composite, act_composite);
        } else {
            act_composite = converted_act_composite;
        }
        return act_composite;
    }

    public int dobToAge(String dob) { // dob should be in yyyy-mm-dd format

        LocalDate dateOfBirth = LocalDate.parse(dob);
        LocalDate curDate = LocalDate.now();
        return Period.between(dateOfBirth, curDate).getYears();
    }

    public double actToSat(double act) {
        int converted_sat_composite = 0;
        if (act == 36) {
            converted_sat_composite = 1590;
        } else if (act >= 35) {
            converted_sat_composite = 1540;
        } else if (act >= 34) {
            converted_sat_composite = 1500;
        } else if (act >= 33) {
            converted_sat_composite = 1460;
        } else if (act >= 32) {
            converted_sat_composite = 1430;
        } else if (act >= 31) {
            converted_sat_composite = 1400;
        } else if (act >= 30) {
            converted_sat_composite = 1370;
        } else if (act >= 29) {
            converted_sat_composite = 1340;
        } else if (act >= 28) {
            converted_sat_composite = 1310;
        } else if (act >= 27) {
            converted_sat_composite = 1280;
        } else if (act >= 26) {
            converted_sat_composite = 1240;
        } else if (act >= 25) {
            converted_sat_composite = 1210;
        } else if (act >= 24) {
            converted_sat_composite = 1180;
        } else if (act >= 23) {
            converted_sat_composite = 1140;
        } else if (act >= 22) {
            converted_sat_composite = 1110;
        } else if (act >= 21) {
            converted_sat_composite = 1080;
        } else if (act >= 20) {
            converted_sat_composite = 1040;
        } else if (act >= 19) {
            converted_sat_composite = 1010;
        } else if (act >= 18) {
            converted_sat_composite = 970;
        } else if (act >= 17) {
            converted_sat_composite = 930;
        } else if (act >= 16) {
            converted_sat_composite = 890;
        } else if (act >= 15) {
            converted_sat_composite = 850;
        } else if (act >= 14) {
            converted_sat_composite = 800;
        } else if (act >= 13) {
            converted_sat_composite = 760;
        } else if (act >= 12) {
            converted_sat_composite = 710;
        } else if (act >= 11) {
            converted_sat_composite = 670;
        } else if (act >= 10) {
            converted_sat_composite = 630;
        } else if (act >= 9) {
            converted_sat_composite = 590;
        } else if (act >= 8) {
            converted_sat_composite = 550;
        } else if (act >= 7) {
            converted_sat_composite = 510;
        } else if (act >= 6) {
            converted_sat_composite = 470;
        } else if (act >= 5) {
            converted_sat_composite = 430;
        } else if (act >= 0) {
            converted_sat_composite = 400;
        }

        return converted_sat_composite;
    }

}
