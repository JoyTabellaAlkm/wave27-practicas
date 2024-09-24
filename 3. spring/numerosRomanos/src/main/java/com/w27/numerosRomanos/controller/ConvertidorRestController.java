package com.w27.numerosRomanos.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConvertidorRestController {

    @GetMapping("/convertir/{numeroDecimal}")
    public String convertir (@PathVariable Integer numeroDecimal){
        String numeroRomano = "";
        switch (numeroDecimal) {
            case 1:
                numeroRomano = "I";
                break;
            case 2:
                numeroRomano = "II";
                break;
            case 3:
                numeroRomano = "III";
                break;
            case 4:
                numeroRomano = "IV";
                break;
            case 5:
                numeroRomano = "V";
                break;
            case 6:
                numeroRomano = "VI";
                break;
            case 7:
                numeroRomano = "VII";
                break;
            case 8:
                numeroRomano = "VIII";
                break;
            case 9:
                numeroRomano = "IX";
                break;
            case 10:
                numeroRomano ="X";
                break;
            case 20:
                numeroRomano = "XX";
                break;
            case 30:
                numeroRomano = "XXX";
                break;
            case 40:
                numeroRomano = "XL";
                break;
            case 50:
                numeroRomano = "L";
                break;
            case 60:
                numeroRomano = "LX";
                break;
            case 70:
                numeroRomano = "LXX";
                break;
            case 80:
                numeroRomano = "LXXX";
                break;
            case 90:
                numeroRomano = "XC";
                break;
            case 100:
                numeroRomano = "C";
                break;
            case 200:
                numeroRomano = "CC";
                break;
            case 300:
                numeroRomano = "CCC";
                break;
            case 400:
                numeroRomano = "CD";
                break;
            case 500:
                numeroRomano = "D";
                break;
            case 600:
                numeroRomano = "DC";
                break;
            case 700:
                numeroRomano = "DCC";
                break;
            case 800:
                numeroRomano = "DCCC";
                break;
            case 900:
                numeroRomano = "CM";
                break;
            case 1000:
                numeroRomano = "M";
                break;
        }
        return numeroRomano;

    }
}
