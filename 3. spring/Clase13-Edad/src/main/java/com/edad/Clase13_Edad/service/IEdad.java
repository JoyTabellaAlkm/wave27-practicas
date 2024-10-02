package com.edad.Clase13_Edad.service;

import com.edad.Clase13_Edad.exceptions.FechaInvalidaException;

public interface IEdad {

    long obtenerEdad(Integer dia, Integer mes, Integer anio) throws FechaInvalidaException;
}
