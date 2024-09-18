package ar.com.mercadolibre.ejercicioRomanos.Controller;

import ar.com.mercadolibre.ejercicioRomanos.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RomanoController {

    @Autowired
    IService iService;

    @GetMapping("/{decimal}")
    public String convertirDecimalRomano(@PathVariable int decimal){
        return iService.convertirDecimalRomano(decimal);
    }


    // el for adentro del for lo que hace es ir restando el número más alto , en este caso 1000
    // hasta que ya number no es igual a 1000 lo que hace es buscar cuál es igual al numero que quede menor a 1000
    @GetMapping("/prueba/{number}")
    public String toRoman(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }
}
