package ar.org.mercadolibre.showroom.service.impl;

import ar.org.mercadolibre.showroom.dto.ClothingDTO;
import ar.org.mercadolibre.showroom.dto.SaleDTO;
import ar.org.mercadolibre.showroom.model.Clothing;
import ar.org.mercadolibre.showroom.model.Sale;
import ar.org.mercadolibre.showroom.repository.SalesRepository;
import ar.org.mercadolibre.showroom.service.ISaleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class SaleService implements ISaleService {
    @Autowired
    SalesRepository salesRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale createSale= modelMapper.map(saleDTO, Sale.class);
        createSale= salesRepository.save(createSale);
        return modelMapper.map(createSale,SaleDTO.class);
    }

    @Override
    public List<SaleDTO> getAllSales() {
        List<Sale> salesList= salesRepository.findAll();
        return salesList.stream().map(s-> modelMapper.map(s,SaleDTO.class)).toList();
    }

    @Override
    public SaleDTO getSaleByNumber(Long number) {
        Sale s= salesRepository.findById(number).orElse(null);
        return modelMapper.map(s,SaleDTO.class);
    }

    @Override
    public SaleDTO updateSaleByNumber(Long number, SaleDTO saleDTO) {
        Sale sale= salesRepository.findById(number).orElse(null);
        if(sale !=null){
           sale= modelMapper.map(saleDTO,Sale.class);
           sale.setId(number);
           sale= salesRepository.save(sale);
           return modelMapper.map(sale,SaleDTO.class);
        }
        return null;
    }

    @Override
    public String deleteSale(Long number) {
        Sale s= salesRepository.findById(number).orElse(null);
        if(s!=null){
            salesRepository.delete(s);
            return "Delete Sale Id: "+ number + "ok";
        }
        return "Can't delete";
    }


  /*  public List<ClothingDTO> getAllsClothingBySaleDate(LocalDate date) {
        List<Clothing> clothings= salesRepository.findClothingBySalesDate(date);


     //   clothings.stream().filter(c-> objectMapper.convertValue(c,ClothingDTO.class)); //ver
        return null;
    }

    @Override
    public List<ClothingDTO> getClothingsBySaleNumber(Long number) {
        return List.of();
    }*/
}
