package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public static final List<CharacterDTO> CHARACTERS_DARTH = Arrays.asList(
            new CharacterDTO(
                    "Darth Vader", "none", "white", "yellow",
                    "41.9BBY", "male", "Tatooine", "Human",
                    202, 136
            ),
            new CharacterDTO(
                    "Darth Maul", "none", "red", "yellow",
                    "54BBY", "male", "Dathomir", "Zabrak",
                    175, 80
            )
    );
}