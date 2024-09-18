package ar.com.mercadolibre.ejercicioRomanos.Service.Impl;

import ar.com.mercadolibre.ejercicioRomanos.Service.IService;
import org.springframework.stereotype.Service;

@Service
public class ServiceRomano implements IService {

    @Override
    public String convertirDecimalRomano(int decimal) {
        return switch (decimal) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "VI";
            case 7 -> "VII";
            case 10 -> "X";
            case 13 -> "XIII";
            case 50 -> "L";
            case 100 -> "C";
            case 500 -> "D";
            case 1000 -> "M";
            default -> "";
        };
    }
}
