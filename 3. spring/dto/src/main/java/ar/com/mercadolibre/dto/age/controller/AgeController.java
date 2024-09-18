package ar.com.mercadolibre.dto.age.controller;


import ar.com.mercadolibre.dto.age.service.IAgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class AgeController {


    IAgeService ageService;

    public AgeController(IAgeService ageService){
        this.ageService = ageService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public Integer calculateAge(@PathVariable Integer day,
                                @PathVariable Integer month,
                                @PathVariable Integer year){

        return ageService.calculateAge(day, month, year);
    }

}
