package com.example.alexandre.tabbedairforce;

import android.util.Log;

/**
 * Created by alexandre on 08/10/17.
 */

public class LandingCalculation {

    static int[] DD9 = {435, 460, 485, 475, 505, 535, 525, 555, 590};
    static int[] DD7 = {365, 385, 400, 395, 420, 440, 430, 460, 485};

    static int[] RD9 = {185, 200, 210, 205, 225, 240, 235, 250, 270};
    static int[] RD7 = {145, 155, 165, 160, 175, 185, 180, 195, 210};

    static int[] DH9 = {530, 560, 590, 580, 615, 655, 640, 680, 725};
    static int[] DH7 = {435, 460, 485, 475, 505, 530, 525, 555, 590};

    static int[] RH9 = {280, 300, 325, 310, 335, 360, 350, 375, 405};
    static int[] RH7 = {215, 230, 250, 240, 260, 285, 275, 290, 315};
    
    public static final int[] calculation(String HorR, int altAD, int QNH, int TEMP) {

        float vt;
        
        float RDD9, RRD9, RDD7, RRD7;
        
        
        int[] resultats = new int[4];
        resultats[0] = 1;


        int Zp = Math.abs(altAD + (1013-QNH)*28);
        float ISA = 15-(2/1000)*Zp;
        float diffT = TEMP-ISA;
        Log.e("TAKEOFF", HorR);
        if (HorR.equals("Dur")) {
            //Calcul piste en dur
            if (TEMP < 15) {
                vt = 20;
                if (altAD < 4000) {
                    RDD9 = calculs(DD9[0], DD9[1], DD9[3], DD9[4], diffT, vt, Zp);
                    RRD9 = calculs(RD9[0], RD9[1], RD9[3], RD9[4], diffT, vt, Zp);
                    RDD7 = calculs(DD7[0], DD7[1], DD7[3], DD7[4], diffT, vt, Zp);
                    RRD7 = calculs(RD7[0], RD7[1], RD7[3], RD7[4], diffT, vt, Zp);
                }else {
                    RDD9 = calculs(DD9[3], DD9[4], DD9[6], DD9[7], diffT, vt, Zp);
                    RRD9 = calculs(RD9[3], RD9[4], RD9[6], RD9[7], diffT, vt, Zp);
                    RDD7 = calculs(DD7[3], DD7[4], DD7[6], DD7[7], diffT, vt, Zp);
                    RRD7 = calculs(RD7[3], RD7[4], RD7[6], RD7[7], diffT, vt, Zp);
                }
            }else {
                vt = 20;
                if (altAD < 4000) {
                    RDD9 = calculs(DD9[2], DD9[1], DD9[5], DD9[4], diffT, vt, Zp);
                    RRD9 = calculs(RD9[2], RD9[1], RD9[5], RD9[4], diffT, vt, Zp);
                    RDD7 = calculs(DD7[2], DD7[1], DD7[5], DD7[4], diffT, vt, Zp);
                    RRD7 = calculs(RD7[2], RD7[1], RD7[5], RD7[4], diffT, vt, Zp);
                }else {
                    RDD9 = calculs(DD9[5], DD9[4], DD9[8], DD9[7], diffT, vt, Zp);
                    RRD9 = calculs(RD9[5], RD9[4], RD9[8], RD9[7], diffT, vt, Zp);
                    RDD7 = calculs(DD7[5], DD7[4], DD7[8], DD7[7], diffT, vt, Zp);
                    RRD7 = calculs(RD7[5], RD7[4], RD7[8], RD7[7], diffT, vt, Zp);
                }
            }
            
        }else {
            //Calcul piste en herbe
            if (TEMP < 15) {
                vt = 20;
                if (altAD < 4000) {
                    RDD9 = calculs(DH9[0], DH9[1], DH9[3], DH9[4], diffT, vt, Zp);
                    RRD9 = calculs(RH9[0], RH9[1], RH9[3], RH9[4], diffT, vt, Zp);
                    RDD7 = calculs(DH7[0], DH7[1], DH7[3], DH7[4], diffT, vt, Zp);
                    RRD7 = calculs(RH7[0], RH7[1], RH7[3], RH7[4], diffT, vt, Zp);
                }else {
                    RDD9 = calculs(DH9[3], DH9[4], DH9[6], DH9[7], diffT, vt, Zp);
                    RRD9 = calculs(RH9[3], RH9[4], RH9[6], RH9[7], diffT, vt, Zp);
                    RDD7 = calculs(DH7[3], DH7[4], DH7[6], DH7[7], diffT, vt, Zp);
                    RRD7 = calculs(RH7[3], RH7[4], RH7[6], RH7[7], diffT, vt, Zp);
                }
            }else {
                vt = 20;
                if (altAD < 4000) {
                    RDD9 = calculs(DH9[2], DH9[1], DH9[5], DH9[4], diffT, vt, Zp);
                    RRD9 = calculs(RH9[2], RH9[1], RH9[5], RH9[4], diffT, vt, Zp);
                    RDD7 = calculs(DH7[2], DH7[1], DH7[5], DH7[4], diffT, vt, Zp);
                    RRD7 = calculs(RH7[2], RH7[1], RH7[5], RH7[4], diffT, vt, Zp);
                }else {
                    RDD9 = calculs(DH9[5], DH9[4], DH9[8], DH9[7], diffT, vt, Zp);
                    RRD9 = calculs(RH9[5], RH9[4], RH9[8], RH9[7], diffT, vt, Zp);
                    RDD7 = calculs(DH7[5], DH7[4], DH7[8], DH7[7], diffT, vt, Zp);
                    RRD7 = calculs(RH7[5], RH7[4], RH7[8], RH7[7], diffT, vt, Zp);
                }
            }
        }
        resultats[0] = Math.round(RDD9);
        resultats[1] = Math.round(RRD9);
        resultats[2] = Math.round(RDD7);
        resultats[3] = Math.round(RRD7);
        Log.e("RESULTAT"," | " + Integer.toString(resultats[0])+" | " + Integer.toString(resultats[1])+" | " + Integer.toString(resultats[2])+" | " + Integer.toString(resultats[3]));
        return resultats;
    }
    
    private static float calculs(int un, int deux, int trois, int quatre, float diffT, float vt, int Zp) {
        float AA = un-deux;
        float AB = AA*diffT;
        float AC = AB/vt;
        float AD = deux+AC;
        float BA = trois-quatre;
        float BB = BA*diffT;
        float BC = BB/vt;
        float BD = quatre + BC;
        float CA = BD-AD;
        float CB = CA*Zp;
        float CC = CB/4000;
        float CD = AD+CC;
        Log.e("TAkEOFF", Float.toString(AA) + " | " +Float.toString(AB) + " | "+Float.toString(AC) + " | "+Float.toString(AD) + " | "+Float.toString(BA) + " | "+Float.toString(BB) + " | "+Float.toString(BC) + " | "+Float.toString(BD) + " | "+Float.toString(CA) + " | "+Float.toString(CB) + " | "+Float.toString(CC) + " | "+Float.toString(CD));
        return CD;
    }
    

}
