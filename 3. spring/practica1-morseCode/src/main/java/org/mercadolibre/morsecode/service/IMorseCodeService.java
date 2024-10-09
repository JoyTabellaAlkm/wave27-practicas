package org.mercadolibre.morsecode.service;

public interface IMorseCodeService {
    String traduccion(String code);

    String alReves(String palabra);
}
