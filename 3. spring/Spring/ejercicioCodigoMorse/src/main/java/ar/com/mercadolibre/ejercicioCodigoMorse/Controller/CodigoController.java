package ar.com.mercadolibre.ejercicioCodigoMorse.Controller;

import ar.com.mercadolibre.ejercicioCodigoMorse.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CodigoController {
    @Autowired
    IService iService;

    @GetMapping("/espaniol/{inputUrl}")
    public String convertirCodigo(@PathVariable String inputUrl){
        return iService.convertirCodigo(inputUrl);
    }

    @GetMapping("/morse/{inputUrl}")
    public String convertirEspaniol(@PathVariable String inputUrl){
        return iService.convertirEspaniol(inputUrl);
    }


}
