package com.futa.romannumtrans;

/**
 * Created by Futa on 2016/07/07.
 */
public class RomanNumTrans {
    private String str = "";
    public int maxNum = 3999, minNum = 1;

    static final structArabian[] arabian = {
            new structArabian("M", 1000),
            new structArabian("CM", 900),
            new structArabian("D", 500),
            new structArabian("CD", 400),
            new structArabian("C", 100),
            new structArabian("XC", 90),
            new structArabian("L", 50),
            new structArabian("XL", 40),
            new structArabian("X", 10),
            new structArabian("IX", 9),
            new structArabian("V", 5),
            new structArabian("IV", 4),
            new structArabian("I", 1)
    };

    RomanNumTrans(){

    }


    public String rTrans(int num){
        int i=0;

        while(num != 0){
            if(num / arabian[i].num >= 1){
                this.str = this.str + arabian[i].name;
                num -= arabian[i].num;
            }else i++;
        }

        return this.str;
    }

    public boolean rCheck(int num){
        if(num > this.maxNum || num < this.minNum){
            return false;
        }
        return true;
    }

}

class structArabian{
    public int num;
    public String name;

    public structArabian(String name, int num){
        this.num = num;
        this.name = name;
    }
}