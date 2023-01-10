package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;

public class Main {
    public static void main(String[] args) {


        IdolDancer idolDancer
                = new IdolDancer("AB6IX", "이대휘");

        StreetDancer streetDancer
                = new StreetDancer("길거리춤꾼들", "박격포");

        idolDancer.dance();
        System.out.println();

        streetDancer.dance();



    }
}






