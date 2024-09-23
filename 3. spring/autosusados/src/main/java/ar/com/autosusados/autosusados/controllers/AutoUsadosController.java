package ar.com.autosusados.autosusados.controllers;

import ar.com.autosusados.autosusados.dtos.AutoDTO;
import ar.com.autosusados.autosusados.entities.AutoUsados;
import ar.com.autosusados.autosusados.services.IAutoUsadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/autos")
public class AutoUsadosController {

    @Autowired
    private IAutoUsadosService autoUsadosService;

    @PostMapping
    public boolean addCar(@RequestBody AutoDTO auto){
        return autoUsadosService.agregarAuto(auto);
    }

    @GetMapping
    public List<AutoDTO> getCars(){
        return autoUsadosService.getAutos();
    }

    @GetMapping("/dates")
    public List<AutoDTO> getCarsBetweenDates(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                         @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return autoUsadosService.getAutosBetweenDates(since, to);
    }

    @GetMapping("/prices")
    public List<AutoDTO> getCarsBetweenPrices(@RequestParam Double since, @RequestParam Double to){
        return autoUsadosService.getAutoDTOBetweenPrices(since, to);
    }

    @GetMapping("/{id}")
    public AutoDTO getCarsBetweenPrices(@PathVariable Long id){
        return autoUsadosService.getAutoDTOId(id);
    }
}
