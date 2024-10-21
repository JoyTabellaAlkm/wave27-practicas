package ar.com.mercadolibre.clavescompuestas.service;

import ar.com.mercadolibre.clavescompuestas.dto.CompraItemDTO;
import ar.com.mercadolibre.clavescompuestas.dto.ItemDTO;
import ar.com.mercadolibre.clavescompuestas.entity.Compra;
import ar.com.mercadolibre.clavescompuestas.entity.Item;
import ar.com.mercadolibre.clavescompuestas.repository.ICompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements ICompraService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private final ICompraRepository compraRepository;


    public CompraServiceImpl(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public List<CompraItemDTO> getAllCompraItem(){
        List<Object[]> results = compraRepository.findCompraWithItems();

        Map<Long, CompraItemDTO> compraMap = results.stream()
                .collect(Collectors.toMap(
                        result -> ((Compra) result[0]).getId(),
                        result -> {
                            Compra compra = (Compra) result[0];

                            CompraItemDTO compraDTO = modelMapper.map(compra, CompraItemDTO.class);
                            compraDTO.setItems(new HashSet<>());
                            return compraDTO;
                        },
                        (existing, update) -> existing
                ));

        results.forEach(result -> {
            Compra compra = (Compra) result[0];
            Item item = (Item) result[1];

            ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);

            compraMap.get(compra.getId()).getItems().add(itemDTO);
        });


        return new ArrayList<>(compraMap.values());
    }

}
