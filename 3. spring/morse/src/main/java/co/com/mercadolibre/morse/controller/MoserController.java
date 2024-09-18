package co.com.mercadolibre.morse.controller;

import co.com.mercadolibre.morse.service.IEncriptado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MoserController {

    @Autowired
    IEncriptado iEncriptado;
    @GetMapping("/morseATexto/{texto}")
    public String coder(@PathVariable String texto){
        return iEncriptado.coder(texto);
    }
    @GetMapping("/textoAMorse/{texto}")
    public String decoder(@PathVariable String texto){
        return iEncriptado.decoder(texto);
    }

}
