
## Code Review I - Concesionaria Vehiculo
### Request para probar
- Crear Vehiculo: 

```
  curl --location 'http://localhost:8080/vehicles' \
  --header 'Content-Type: application/json' \
  --data '{
  "brand": "Marca",
  "model": "Modelo",
  "registration": "Registro",
  "color": "Color",
  "year": 2021,
  "max_speed": "200",
  "passengers": 5,
  "fuel_type": "Gasolina",
  "transmission": "Automática",
  "height": 1.5,
  "width": 1.8,
  "weight": 1500
  }'
``` 
- Busqueda por color y año
```
curl --location 'http://localhost:8080/vehicles/search?color=Color&year=2021'
```
- Añadir múltiples vehículos (Response Conflict)
```
curl --location 'http://localhost:8080/vehicles/batch' \
--header 'Content-Type: application/json' \
--data '[
    {
        "brand": "Toyota",
        "model": "Corolla",
        "registration": "ABC123",
        "color": "Rojo",
        "year": 2020,
        "max_speed": "180",
        "passengers": 5,
        "fuel_type": "Gasolina",
        "transmission": "Automática",
        "height": 1.5,
        "width": 1.8,
        "weight": 1300
    },
        {
        "brand": "Toyota",
        "model": "Corolla",
        "registration": "ABC123",
        "color": "Rojo",
        "year": 2020,
        "max_speed": "180",
        "passengers": 5,
        "fuel_type": "Gasolina",
        "transmission": "Automática",
        "height": 1.5,
        "width": 1.8,
        "weight": 1300
    }

]'
```
- Añadir Multiples Vehiculos (Response Created)
```
curl --location 'http://localhost:8080/vehicles/batch' \
--header 'Content-Type: application/json' \
--data '[
    {
        "brand": "Pontiac",
        "model": "Fiero",
        "registration": "660325",
        "year": 1986,
        "color": "Mauv",
        "max_speed": "85",
        "fuel_type": "gasoline",
        "transmission": "semi-automatic",
        "passengers": 2,
        "height": 105.43,
        "width": 280.28,
        "weight": 288.8
    },
    {
        "brand": "Buick",
        "model": "LeSabre",
        "registration": "8196226",
        "year": 2005,
        "color": "Green",
        "max_speed": "240",
        "fuel_type": "gasoline",
        "transmission": "semi-automatic",
        "passengers": 6,
        "height": 207.93,
        "width": 125.94,
        "weight": 199.22
    },
    {
        "brand": "Mitsubishi",
        "model": "Excel",
        "registration": "090427",
        "year": 1987,
        "color": "Green",
        "max_speed": "89",
        "fuel_type": "gas",
        "transmission": "automatic",
        "passengers": 5,
        "height": 39.18,
        "width": 290.82,
        "weight": 121.17
    }
]'
```
-Añadir múltiples Vehículos (Response Bad Request - Solo modelo y marca)
```
curl --location 'http://localhost:8080/vehicles/batch' \
--header 'Content-Type: application/json' \
--data '[
    {
        "brand": "Pontiac",
        "model": "Fiero",
        "registration": "66033",
        "year": 1986,
        "color": "Mauv",
        "max_speed": "85",
        "fuel_type": "gasoline",
        "transmission": "semi-automatic",
        "passengers": 2,
        "height": 105.43,
        "width": 280.28,
        "weight": 288.8
    },
    {
        "brand": "Buick",
        "model": "LeSabre",
        "registration": "819624",
        "year": 2005,
        "color": "Green",
        "max_speed": "240",
        "fuel_type": "gasoline",
        "transmission": "semi-automatic",
        "passengers": 6,
        "height": 207.93,
        "width": 125.94,
        "weight": 199.22
    },
    {
        "brand": "Mitsubishi",
        "model": "",
        "registration": "09046",
        "year": 1987,
        "color": "Green",
        "max_speed": "89",
        "fuel_type": "gas",
        "transmission": "automatic",
        "passengers": 5,
        "height": 39.18,
        "width": 290.82,
        "weight": 121.17
    }
]'
```

