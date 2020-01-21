package com.example.univeristyligthhousekeeper;

public class LogoHelper {

    public static int getWydzialLogo(int id) {
        switch(id) {
            case 1:
                return R.drawable.logo1;
            case 2:
                return R.drawable.logo2;
            case 3:
                return R.drawable.logo3;
            case 4:
                return R.drawable.logo4;
            case 5:
                return R.drawable.logo5;
            case 6:
                return R.drawable.logo6;
            case 7:
                return R.drawable.logo7;
            case 8:
                return R.drawable.logo8;
            case 9:
                return R.drawable.logo9;
            default:
                return R.drawable.logo1;
        }
    }
}
