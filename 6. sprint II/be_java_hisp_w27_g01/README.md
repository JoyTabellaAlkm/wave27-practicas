# Social MELI Grupo 01

El objetivo de este sprint es aplicar los contenidos dados hasta el momento durante el BOOTCAMP MeLi (Git, Java y Spring), con la finalidad de poder implementar una API REST a partir de un enunciado propuesto, una especificación de requisitos y documentación anexada

## Desarrolladores:
- [@Delfina Glavas](https://github.com/delfi85)
- [@Emilia Lascano](https://github.com/EmiLascano)
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)
- [@Stephanie Castillo](https://github.com/Stephaaniie)
- [@Fernando Baldrich](https://github.com/Fern1ck)

La fecha de entrega y cierre es: Martes 01/10/2024, 16:00hs ARG.

## Funcionalidades del proyecto

<details>
<summary> Funcionalidad 1: Poder realizar la acción de “Follow” (seguir) a un determinado usuario. </summary>

## Dev:

- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### Metodo POST

```http
http://localhost:8080/users/{userId}/follow/{userIdToFollow}
```

```http
http://localhost:8080/users/123/follow/234
```

| Response  |
| :-------- | 
| `Status Code 200 (todo OK) - bodyless or dto` | 
| `Status Code 400 (Bad Request) - bodyless or dto` | 

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica al usuario actual |
| `userIdToFollow`      | `int` | **Required**. Número que identifica al usuario a seguir |

</details>

<details>
<summary>Funcionalidad 2: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.</summary>
## Dev:

- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### Metodo GET

```http
http://localhost:8080/users/{userId}/followers/count
```

```http
http://localhost:8080/users/234/followers/count/
```

| Response  |
| :-------- | 
```json
    {
      "user_id": 234, 
      "user_name": "vendedor1",
      "followers_count": 35
    }
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |

</details>

<details>
<summary>Funcionalidad 3: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).</summary>

## Dev:

- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)
  
#### Metodo GET

```http
http://localhost:8080/users/{userId}/followers/list
```
```http
http://localhost:8080/users/234/followers/list
```

| Response  |
| :-------- | 
```json
      {
        "user_id": 234, 
        "user_name": "vendedor1", 
        "followers": [
         {
            "user_id": 4698,
            "user_name": "usuario1"
          },
          {
            "user_name": "usuario2" 
           },
           {
             "user_id": 2236,
             "user_name": "usuario3"
           }
        ]
      }
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`  | `int`    | **Required**. Número que identifica a cada usuario. |

</details>

<details>
<summary>Funcionalidad 4: Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).</summary>

## Dev:

- [@Delfina Glavas](https://github.com/delfi85)
  
#### Metodo GET

```http
http://localhost:8080/users/{userId}/followed/list
```

```http
http://localhost:8080/users/4698/followed/list
```

| Response  |
| :-------- | 
```json
    {
      "user_id": 4698,
      "user_name": "usuario1",
      "followed": [
        {
          "user_id": 234,
          "user_name": "vendedor1"
        },
        {
          "user_name": "vendedor2"
        },
        {
          "user_id": 6631,
          "user_name": "vendedor3"
        }
      ]
    }
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |

</details>

<details>
<summary>Funcionalidad 5: Dar de alta una nueva publicación.</summary>

## Dev:

- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### Metodo POST

```http
http://localhost:8080/products/post
```
  | PAYLOAD  |
  | :-------- | 
```json
  {
    "user_id": 123,
    "date": "29-04-2021",
    "product": {
      "product_id": 1,
      "product_name": "Silla Gamer",
      "type": "Gamer",
      "brand": "Racer",
      "color": "Red & Black",
      "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50  
  }
```   
| Response  |
| :-------- | 
| `Status Code 200 (todo OK) - bodyless or dto` | 
| `Status Code 400 (Bad Request) - bodyless or dto` | 

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |
| `date`      | `LocalDate` | **Required**. Fecha de la publicación en formato dd-MM-yyyy. |
| `product_id`      | `int` | **Required**. Número identificatorio de un producto asociado a una publicación. |
| `product_name`      | `String` | **Required**. Cadena de caracteres que representa el nombre de un producto. |
| `type`      | `String` | **Required**. Cadena de caracteres que representa el tipo de un producto|
| `brand`      | `String` | **Required**. Cadena de caracteres que representa el tipo de un producto. |
| `color`      | `String` | **Required**. Cadena de caracteres que representa el color de un producto notes.|
| `note`      | `String` | **Required**. Cadena de caracteres para colocar notas u observaciones de un producto.|
| `category`      | `int` | **Required**. Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados|
| `price`      | `double` | **Required**. Precio del producto.|

</details>

<details>
<summary>Funcionalidad 6: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).</summary>

## Dev:

- [@Emilia Lascano](https://github.com/EmiLascano)

#### Metodo GET

```http
http://localhost:8080/products/followed/{userId}/list
```
```http
http://localhost:8080/products/followed/4698/list
```
| Response  |
| :-------- | 
```json
{
  "user_id": 4698,
  "posts": [{
    "user_id" : 123, 
    "post_id" : 32,
    "date" : "01-05-2021",
    "product": {
        "product_id": 62,
        "product_name": "Headset RGB Inalámbrico",
        "type": "Gamer",
        "brand": "Razer",
        "color": "Green with RGB",
        "notes": "Sin Batería"
      },
      "category" : 120,
      "price":2800.69
    },
    {
      "user_id" : 234, 
      "post_id" : 18, 
      "date" : "29-04-2021",
      "product" :
      {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category" : 100,
      "price" : 15000.50
    }
  ]
}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |
</details>

<details>
<summary>Funcionalidad 7: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.</summary>

## Dev:

- [@Emilia Lascano](https://github.com/EmiLascano)
  
#### Metodo POST

```http
http://localhost:8080/users/{userId}/unfollow/{userIdToUnfollow}
```
```http
http://localhost:8080/users/234/unfollow/123
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |
| `userIdToUnfollow`      | `int` | **Required**. Número que identifica al usuario a dejar de seguir |

</details>

<details>
<summary>Funcionalidad 8: Ordenamiento alfabético ascendente y descendente.</summary>

## Dev:
- [@Fernando Baldrich](https://github.com/Fern1ck)

#### Metodo GET
 
```http
  http://localhost:8080/users/{UserID}/followers/list?order=name_asc
  http://localhost:8080/users/{UserID}/followers/list?order=name_desc
  http://localhost:8080/users/{UserID}/followed/list?order=name_asc
  http://localhost:8080/users/{UserID}/followed/list?order=name_desc
```
```http
  http://localhost:8080/users/1/followers/list?order=name_asc
  http://localhost:8080/users/1/followers/list?order=name_desc
  http://localhost:8080/users/1/followed/list?order=name_asc
  http://localhost:8080/users/1/followed/list?order=name_desc
```

| Order       | Description                       |
| :-----------| :-------------------------------- |
| `name_asc`  | **Alfabético ascendente.**        |
| `name_desc` | **Alfabético descendente.**       |

Nota: Este ordenamiento aplica solo para la funcionalidad 3 y 4.

</details>

<details>
<summary>Funcionalidad 9: Ordenamiento por fecha ascendente y descendente.</summary>

## Dev:

- [@Delfina Glavas](https://github.com/delfi85)

#### Metodo GET

```http
  http://localhost:8080//products/followed/{userId}/list?order=date_asc
  http://localhost:8080/products/followed/{userId}/list?order=date_desc
```
```http
  http://localhost:8080//products/followed/2/list?order=date_asc
  http://localhost:8080/products/followed/2/list?order=date_desc
```
| Order       | Description                                          |
| :-----------| :--------------------------------------------------- |
| `date_asc`  | **Fecha ascendente (de más antigua a más nueva).**   |
| `date_desc` | **Fecha descendente (de más nueva a más antigua).**  |

Nota: Este ordenamiento aplica solo para la funcionalidad 6.
</details>

<details>
<summary>Funcionalidad 10: Llevar a cabo la publicación de un nuevo producto en promoción.</summary>

## Dev:
- [@Fernando Baldrich](https://github.com/Fern1ck)

#### Metodo POST

```http
  http://localhost:8080/products/promo-post
```
| PAYLOAD  |
| :-------- | 
```json

{
  "user_id": 234,
  "date": "29-04-2021",
  "product": {
    "product_id": 1,
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.25
}
```
| Response  |
| :-------- | 
| `Status Code 200 (todo OK) - bodyless or dto` | 
| `Status Code 400 (Bad Request) - bodyless or dto` | 

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |
| `date`      | `LocalDate` | **Required**. Fecha de la publicación en formato dd-MM-yyyy. |
| `product_id`      | `int` | **Required**. Número identificatorio de un producto asociado a una publicación. |
| `product_name`      | `String` | **Required**. Cadena de caracteres que representa el nombre de un producto. |
| `type`      | `String` | **Required**. Cadena de caracteres que representa el tipo de un producto. |
| `brand`      | `String` | **Required**. Cadena de caracteres que representa el tipo de un producto. |
| `color`      | `String` | **Required**. Cadena de caracteres que representa el color de un producto notes. |
| `note`      | `String` | **Required**. Cadena de caracteres para colocar notas u observaciones de un producto. |
| `category`      | `int` | **Required**. Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados. |
| `price`      | `double` | **Required**. Precio del producto.|
| `has_promo`      | `boolean` | **Required**. Campo true o false para determinar si un producto está en promoción o no. |
| `discount`      | `double` | **Required**. En caso de que un producto estuviese en promoción ,establece el monto de descuento. |

</details>

<details>
<summary>Funcionalidad 11: Obtener la cantidad de productos en promoción de un determinado vendedor.</summary>

## Devs:

- [@Delfina Glavas](https://github.com/delfi85)
- [@Emilia Lascano](https://github.com/EmiLascano)
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)
- [@Stephanie Castillo](https://github.com/Stephaaniie)
- [@Fernando Baldrich](https://github.com/Fern1ck)
  
#### Metodo GET

```htttp
  http://localhost:8080/products/promo-post/count?user_id={userId}
```

```htttp
  http://localhost:8080/products/promo-post/count?user_id=1
```

| Response  |
| :-------- | 

```json
    {
      "user_id" : 234,
      "user_name": "vendedor1",
      "promo_products_count": 23
    }
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `user_id`      | `int` | **Required**. Número que identifica a cada usuario. |
| `user_name`      | `String` | **Required**. Cadena de caracteres que representa el nombre del usuario. |
| `promo_products_count`      | `int` | **Required**. Cantidad numérica de productos en promoción de un determinado usuario. |

</details>

<details>
<summary> Funcionalidad 13: Buscar productos por nombre o marca, opcionalmente pasandole un ID de usuario</summary>

  ## Dev:

- [@Fernando Baldrich](https://github.com/Fern1ck)

#### Metodo GET

```http
http://localhost:8080/products/search?query={query}&user_id={user_id}
```

```http
http://localhost:8080/products/search?query=ams
http://localhost:8080/products/search?query=ams&user_id=2
```

| Response  |
| :-------- | 
```json
  [
    {
      "post_id": 3,
      "user_id": 2,
      "product": {
        "type": "Monitor",
        "brand": "Samsung",
        "color": "Negro",
        "notes": "Ultra HD",
        "product_id": 3,
        "product_name": "Monitor 4K"
      },
      "date": "18-09-2024",
      "category": 300,
      "price": 30000.0,
      "discount": 0.3,
      "has_promo": true
    }
  ]
```
La respuesta es una lista con objetos con las siguientes propiedades:

| Parameter      | Type     | Description                                                                                                                             |
|:---------------| :------- |:----------------------------------------------------------------------------------------------------------------------------------------|
| `postId`       | `int` | **Required**. Número que identifica a cada post.                                                                                        |
| `userId`       | `int` | **Required**. Número que identifica a cada usuario.                                                                                     |
| `post_id`      | `int` | **Required**. Número identificatorio de cada una de las publicaciones.                                                                  |
| `date`         | `LocalDate` | **Required**. Fecha de la publicación en formato dd-MM-yyyy.                                                                            |
| `product_id`   | `int` | **Required**. Número identificatorio de un producto asociado a una publicación.                                                         |
| `type`         | `String` | **Required**. Cadena de caracteres que representa el tipo de un producto.                                                               |
| `brand`        | `String` | **Required**. Cadena de caracteres que representa el tipo de un producto.                                                               |
| `color`        | `String` | **Required**. Cadena de caracteres que representa el color de un producto notes.                                                        |
| `note`         | `String` | **Required**. Cadena de caracteres para colocar notas u observaciones de un producto.                                                   |
| `category`     | `int` | **Required**. Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados. |
| `price`        | `double` | **Required**. Precio del producto.                                                                                                      |
| `has_promo`    | `boolean` | **Required**. Campo true o false para determinar si un producto está en promoción o no.                                                 |
| `discount`     | `double` | **Required**. En caso de que un producto estuviese en promoción ,establece el monto de descuento.                                       |

</details>


<details>
  <summary> Funcionalidad 14: Obtener un listado de las publicaciones realizadas por los vendedores según las fechas ingresadas.</summary>


### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)


#### Metodo GET

```http
  http://localhost:8080/products/search/date?date_start={date_start}&date_end={date_end}
```
```http
  http://localhost:8080/products/search/date?date_start=16/09/2021&date_end=18/09/2024
```

| Response  |
| :-------- | 
```json
    [
      {
          "user_id": 2,
          "post_id": 1,
          "date": "16-09-2021",
          "product": {
              "type": "Gamer",
              "brand": "Racer",
              "color": "Red",
              "notes": "Special Edition",
              "product_id": 1,
              "product_name": "Silla gamer"
          },
          "category": 100,
          "price": 15000.0
      },
      {
          "user_id": 2,
          "post_id": 3,
          "date": "18-09-2024",
          "product": {
              "type": "Monitor",
              "brand": "Samsung",
              "color": "Negro",
              "notes": "Ultra HD",
              "product_id": 3,
              "product_name": "Monitor 4K"
          },
          "category": 300,
          "price": 30000.0
      },
      {
          "user_id": 4,
          "post_id": 2,
          "date": "17-09-2024",
          "product": {
              "type": "Periférico",
              "brand": "Logitech",
              "color": "Negro",
              "notes": "RGB",
              "product_id": 2,
              "product_name": "Teclado mecánico"
          },
          "category": 200,
          "price": 5000.0
      }
    ]
```

| Parameter    | Type     | Description                                                                                                                                      |
|:-------------| :------- |:-------------------------------------------------------------------------------------------------------------------------------------------------|
| `date_start` | `LocalDate` | **Required**. Fecha que marca el inicio temporal del cúal el usuario quiere empezar la búsqueda de posteos de los vendedores. Formato dd-MM-yyyy.|
| `date_end`   | `LocalDate` |  Fecha que marca el fin temporal del cúal el usuario quiere finalizar la búsqueda de posteos de los vendedores. (En caso de que el usuario no ingrese este dato se tomará como fin de búsqueda la fecha actual). Formato dd-MM-yyyy .|


</details>

<details>
<summary> Funcionalidad 15: Activar una promocion de un posteo existente. </summary> 

## Dev:

- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### Metodo PUT
```http
  http://localhost:8080/products/posts/activate-promo
```

| Parameter  | Type     | Description                                         |
|:-----------|:---------|:----------------------------------------------------|
| `user_id`  | `int`    | **Required**. Número que identifica a cada usuario. |
| `post_id`  | `int`    | **Required**. Número que identifica al posteo.      |
| `discount` | `double` | **Required**. Número que el descuento a aplicar.    |

| Response  |
| :-------- | 
| `Status Code 200 (todo OK) - bodyless or dto` | 
| `Status Code 400 (Bad Request) - bodyless or dto` | 
</details>

<details>
<summary> Funcionalidad 16: Eliminar una publicación.</summary>

## Dev:
- [@Delfina Glavas](https://github.com/delfi85)

#### Metodo DELETE
```http
  http://localhost:8080/products/post/{userId}/{postId}
```
| Response                                        |
|:------------------------------------------------| 
| `Status Code 200 (todo OK) - bodyless or dto`   | 
| `Status Code 404 (Not Found) - bodyless or dto` | 

| Parameter | Type     | Description                                                                                                  |
|:----------| :------- |:-------------------------------------------------------------------------------------------------------------|
| `userId`  | `int` | **Required**. Número que identifica a cada usuario.                                                          |
| `postId`  | `int` | **Required**. Número identificatorio de una publicación asociado a una lista de publicaciones en un usuario. |

</details>

<details>
 <summary> Funcionalidad 17: Obtener un listado de todos los productos de un determinado vendedor, con la posibilidad de filtrar por posteos que tienen descuento y posteos que no tienen descuentos. </summary>

## Dev:
- [@Emilia Lascano](https://github.com/Fern1ck)

#### Metodo GET

```http
  http://localhost:8080/products/promo-post/3/history
  http://localhost:8080/products/promo-post/3/history?with_promo=true
  http://localhost:8080/products/promo-post/3/history?with_promo=false
```
| with_promo | Description                                              |
|:-----------|:---------------------------------------------------------|
| null       | **Devuelve todos los posts, sin aplicar ningún filtro.** |
| `true`     | **Devuelve solo los posts que tienen descuento.**        |
| `false`    | **Devuelve solo los posts que no tienen descuentos.**    |


| Response  |
| :-------- | 
```json
{
  "user_id": 234,
  "user_name": "vendedor1",
  "posts": [
    {
      "post_id": 18,
      "date": "29-04-2021",
      "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": "100",
      "price": 15000.50,
      "has_promo": true,
      "discount": 0.25
    },
    {
      "post_id": 32,
      "date": "01-05-2021",
      "product": {
        "product_id": 2,
        "product_name": "Headset RGB Inalámbrico",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Green with RGB",
        "notes": "Sin Batería"
      },
      "category": "120",
      "price": 2800.69,
      "has_promo": false,
      "discount": 0.0
    }
  ]
}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |
| `user_name`      | `int` | **Required**. Cadena de caracteres que representa el nombre del usuario. |
| `post_id`      | `int` | **Required**. Número identificatorio de cada una de las publicaciones. |
| `date`      | `LocalDate` | **Required**. Fecha de la publicación en formato dd-MM-yyyy. |
| `product_id`      | `int` | **Required**. Número identificatorio de un producto asociado a una publicación. |
| `product_name`      | `String` | **Required**. Cadena de caracteres que representa el nombre de un producto. |
| `type`      | `String` | **Required**. Cadena de caracteres que representa el tipo de un producto. |
| `brand`      | `String` | **Required**. Cadena de caracteres que representa el tipo de un producto. |
| `color`      | `String` | **Required**. Cadena de caracteres que representa el color de un producto notes. |
| `note`      | `String` | **Required**. Cadena de caracteres para colocar notas u observaciones de un producto. |
| `category`      | `int` | **Required**. Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados. |
| `price`      | `double` | **Required**. Precio del producto.|
| `has_promo`      | `boolean` | **Required**. Campo true o false para determinar si un producto está en promoción o no. |
| `discount`      | `double` | **Required**. En caso de que un producto estuviese en promoción ,establece el monto de descuento. |

</details>

## Pruebas realizada en el proyecto

#### Objetivo: Aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.

### Requerimientos técnicos funcionales

<details>
  <summary>T-0001</summary>

#### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### Requerimiento: US-0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor


| Referencia | Situaciones de entrada                               | Comportamiento Esperado                                                                                              |
|:-----------|:-----------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| T-0001     | Verificar que el usuario a seguir exista. (US-0001)  | **Se cumple:** Permite continuar con normalidad. **No se cumple:** Notifica la no existencia mediante una excepción. |

</details>

<details>
  <summary>T-0002</summary>

#### Dev:
- [@Emilia Lascano](https://github.com/EmiLascano)

#### Requerimiento US-0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor


| Referencia | Situaciones de entrada                                      | Comportamiento Esperado                                                                                              |
|:-----------|:------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| T-0002     | Verificar que el usuario a dejar de seguir exista. (US-0007)| **Se cumple:** Permite continuar con normalidad. **No se cumple:** Notifica la no existencia mediante una excepción. |

</details>

<details>
  <summary>T-0003</summary>

#### Dev:
- [@Fernando Baldrich](https://github.com/Fern1ck)

#### Requerimiento US-0008: Ordenamiento alfabético ascendente y descendente.


| Referencia | Situaciones de entrada                                             | Comportamiento Esperado                                                                                              |
|:-----------|:-------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| T-0003     | Verificar que el tipo de ordenamiento alfabético exista (US-0008)  | **Se cumple:** Permite continuar con normalidad. **No se cumple:** Notifica la no existencia mediante una excepción. |

</details>

<details>
  <summary>T-0004</summary>

#### Dev:
- [@Delfina Glavas](https://github.com/delfi85)

#### Requerimiento US-0008: Ordenamiento alfabético ascendente y descendente.

| Referencia | Situaciones de entrada                                                           | Comportamiento Esperado                                                                                        |
|:-----------|:---------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------|
| T-0004     | Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)| **Devuelve la lista ordenada según el criterio solicitado**                                                                          |

</details>

<details>
<summary>T-0005</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### Requerimiento US-0009: Ordenamiento por fecha ascendente y descendente.

| Referencia | Situaciones de entrada                                            | Comportamiento Esperado                                                                                              |
|:-----------|:------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| T-0005     | Verificar que el tipo de ordenamiento por fecha exista (US-0009)  | **Se cumple:** Permite continuar con normalidad. **No se cumple:** Notifica la no existencia mediante una excepción. |

</details>

<details>
<summary>T-0006</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### Requerimiento US-0009: Ordenamiento por fecha ascendente y descendente.

| Referencia | Situaciones de entrada                                            | Comportamiento Esperado                                                                                           |
|:-----------|:------------------------------------------------------------------|:------------------------------------------------------------------------------------------|
| T-0006     | Verificar que el tipo de ordenamiento por fecha exista (US-0009)  | Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)                                                       |

</details>

<details>
<summary>T-0007</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### Requerimiento US-0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.

| Referencia | Situaciones de entrada                                                                     | Comportamiento Esperado                                                                                              |
|:-----------|:-------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| T-0007     | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)  | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.  |

</details>

<details>
<summary>T-0008</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### Requerimiento US-0009: Ordenamiento por fecha ascendente y descendente.

| Referencia | Situaciones de entrada                                                                                                                                              | Comportamiento Esperado                                                                                                                                |
|:-----------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------|
| T-0008     | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)| Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.     |

</details>

### Requerimientos técnicos funcionales de integración(Bonus).

<details>
  <summary>INTEGRATION - US - 01</summary>

#### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### INTEGRATION - US - 01: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor

| Situaciones de entrada                                                  | Comportamiento Esperado                                                        |
|:------------------------------------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el correcto funcionamiento de la acción seguir a un vendedor | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 02</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### INTEGRATION - US - 002 - Negative User ID

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 002 - Counts Zero

| Situaciones de entrada                       | Comportamiento Esperado                                                        |
|:---------------------------------------------|:-------------------------------------------------------------------------------|
| Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 002 - Counts more than Zero

| Situaciones de entrada                       | Comportamiento Esperado                                                        |
|:---------------------------------------------|:-------------------------------------------------------------------------------|
| Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 03</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### INTEGRATION - US - 003 - Gets list more than zero

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 003 - Gets list more than zero

| Situaciones de entrada                       | Comportamiento Esperado                                                        |
|:---------------------------------------------|:-------------------------------------------------------------------------------|
| Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 003 - Negative User ID

| Situaciones de entrada                       | Comportamiento Esperado                                                        |
|:---------------------------------------------|:-------------------------------------------------------------------------------|
| Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 04</summary>

#### Dev:
- [@Delfina Glavas](https://github.com/delfi85)

#### INTEGRATION - US - 04 - Find By Followed

| Situaciones de entrada                                | Comportamiento Esperado    |
|:------------------------------------------------------|:---------------------------|
| Verificar la lista de vendedores que sigue el usuario | **Se cumple:** Código 200. |

#### INTEGRATION - US - 04 - Find By Followed Sad Path 1

| Situaciones de entrada                          | Comportamiento Esperado                                      |
|:------------------------------------------------|:-------------------------------------------------------------|
| Verificar que el usuario sigue a algún vendedor | **Se cumple:** Falla, el usuario no sigue a ningún vendedor. |

#### INTEGRATION - US - 04 - INTEGRATION - US - 04 - Find By Followed Sad Path 2

| Situaciones de entrada                 | Comportamiento Esperado                                      |
|:---------------------------------------|:-------------------------------------------------------------|
| Verificar que el ID del usuario existe | **Se cumple:** Falla, el ID del usuario ingresado no existe. |

#### INTEGRATION - US - 04 - INTEGRATION - US - 04 - Find By Followed Sad Path 3

| Situaciones de entrada                 | Comportamiento Esperado                               |
|:---------------------------------------|:------------------------------------------------------|
| Verificar el parámetro order ingresado | **Se cumple:** Falla, el parámetro order es inválido. |


</details>

<details>
  <summary>INTEGRATION - US - 05</summary>

#### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### INTEGRATION - US - 05 -  Create Post

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 06</summary>

#### Dev:
- [@Emilia Lascano](https://github.com/EmiLascano)

#### INTEGRATION - US - 06 - happyPath

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 06 - sadPath - There aren't posts of minus two weeks

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 07</summary>

#### Dev:
- [@Emilia Lascano](https://github.com/EmiLascano)

#### INTEGRATION - US - 07 - happyPath

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 07 - sadPath - UnfollowIdNotExist

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 07 - sadPath - userIdNotExist

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 08</summary>

#### Dev:
- [@Fernando Baldrich](https://github.com/Fern1ck)

La integración de este US - 008 se contempla en la integracion 003.

</details>

<details>
  <summary>INTEGRATION - US - 09</summary>

#### Dev:
- [@Delfina Glavas](https://github.com/delfi85)

#### INTEGRATION - US - 09 - Get Recent Post From Followed Users Order Ascendent

| Situaciones de entrada                         | Comportamiento Esperado    |
|:-----------------------------------------------|:---------------------------|
| Verificar el ordenamiento ascendente por fecha | **Se cumple:** Código 200. |

#### INTEGRATION - US - 09 - Get Recent Post From Followed Users - Order Descendent

| Situaciones de entrada                          | Comportamiento Esperado    |
|:------------------------------------------------|:---------------------------|
| Verificar el ordenamiento descendente por fecha | **Se cumple:** Código 200. |

#### INTEGRATION - US - 09 - Get Recent Post From Followed Users - Sad Path

| Situaciones de entrada                 | Comportamiento Esperado                               |
|:---------------------------------------|:------------------------------------------------------|
| Verificar el parámetro order ingresado | **Se cumple:** Falla, el parámetro order es inválido. |

</details>

<details>
  <summary>INTEGRATION - US - 10</summary>

#### Dev:
- [@Delfina Glavas](https://github.com/delfi85)

#### INTEGRATION - US - 10 - Success

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 11</summary>

#### Dev:


#### INTEGRATION - US - 11 - Success

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 13</summary>

#### Dev:
- [@Fernando Baldrich](https://github.com/Fern1ck)

#### INTEGRATION - US - 13 - Should search by query and user_id

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### NTEGRATION - US - 13 - Should search by query

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 13 - Should not find anything

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 14</summary>

#### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### INTEGRATION - US - 14 - Happy Path - Search post By startDate and endDate 

| Situaciones de entrada                                                                    | Comportamiento Esperado                                                |
|:------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------|
| Verificar se realice correctamente la busqueda de post de productos enviando ambas fechas | **Se cumple:** Se obtiene una lista de Post con las fechas ingresadas. |

</details>

<details>
  <summary>INTEGRATION - US - 15</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### INTEGRATION - US - 15 - User Not Found

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 15 - Post Not Found

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

### INTEGRATION - US - 015 - All Values Negative

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 015 - All Values Null

| Situaciones de entrada                        | Comportamiento Esperado                                                        |
|:----------------------------------------------|:-------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple:** Falla con usuarios inexistentes y si el usuario no es vendedor. |

</details>

<details>
  <summary>INTEGRATION - US - 16</summary>

#### Dev:
- [@Delfina Glavas](https://github.com/delfi85)

#### INTEGRATION - US - 16 -  Delete Post

| Situaciones de entrada                       | Comportamiento Esperado    |
|:---------------------------------------------|:---------------------------|
| Eliminar un post con userId y postId válidos | **Se cumple:** Código 200. |

#### INTEGRATION - US - 16 -  Delete Post Sad Path 1

| Situaciones de entrada  | Comportamiento Esperado                               |
|:------------------------|:------------------------------------------------------|
| Verificar ID de usuario | **Se cumple:** Falla, el usuario ingresado no existe. |

#### INTEGRATION - US - 16 -  Delete Post Sad Path 2

| Situaciones de entrada | Comportamiento Esperado                            |
|:-----------------------|:---------------------------------------------------|
| Verificar ID de post   | **Se cumple:** Falla, el post ingresado no existe. |



</details>

<details>
  <summary>INTEGRATION - US - 17</summary>

#### Dev:
- [@Emilia Lascano](https://github.com/EmiLascano)

#### INTEGRATION - US - 17 - Happy Path - Get promo posts history

| Situaciones de entrada                        | Comportamiento Esperado                                                                                                          |
|:----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------|
|  Verificar el usuario no tenga un ID negativo | **Se cumple: Status 200**, muestra la lista de todos los posteos Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 17 - Happy Path - Get promo posts history with promo

| Situaciones de entrada                                                | Comportamiento Esperado                                                                                                              |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------|
| Verificar el usuario no tenga un ID negativo. Param with-promo = true | **Se cumple: Status 200**, muestra la lista de los posteos con promo Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 17 - Happy Path - Get promo posts history without promo

| Situaciones de entrada                                                  | Comportamiento Esperado                                                                                                              |
|:------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------|
| Verificar el usuario no tenga un ID negativo.  Param with-promo = false | **Se cumple: Status 200**, muestra la lista de los posteos sin promo Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 17 - Sad Path - no have posts

| Situaciones de entrada                                                                | Comportamiento Esperado                                                                    |
|:--------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------|
| Verificar el usuario no tenga un ID negativo. Verifica que el usuario no tenga posts. | **Se cumple: Status 400**. Falla con usuarios inexistentes y si el usuario no es vendedor. |

#### INTEGRATION - US - 17 - Sad Path - User ID doesn't exist

| Situaciones de entrada                                                          | Comportamiento Esperado                              |
|:--------------------------------------------------------------------------------|:-----------------------------------------------------|
| Verificar el usuario no tenga un ID negativo. Verifica que el usuario no exista | **Se cumple: Status 400**. El usuario es inexistente |

</details>

### Requerimientos técnicos funcionales unitarios (Bonus).

<details>
<summary>TB-0001</summary>

#### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### TB-0001 - Follow a specific user by ID

| Referencia | Situaciones de entrada                | Comportamiento Esperado                                          |
|:-----------|:--------------------------------------|:-----------------------------------------------------------------|
| TB-0001    | Seguir a un usuario con ID existente. | **Se cumple:** El usuario realiza la funcionalidad sin problema. |

#### TB-0001 - Follow someone they already follow

| Referencia | Situaciones de entrada                | Comportamiento Esperado                                                                                               |
|:-----------|:--------------------------------------|:----------------------------------------------------------------------------------------------------------------------|
| TB-0001    | Seguir a un usuario con que ya sigue. | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ya sigue a la persona mediante una excepción. |

#### TB-0001 - Follow a non existing user by ID

| Referencia | Situaciones de entrada                 | Comportamiento Esperado                                                                                                                  |
|:-----------|:---------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------|
| TB-0001    | Seguir a un usuario con que no existe. | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que no existe el usuario a seguir mediante una excepción.            |

#### TB-0001 - Usert with Zero ID and send exception BadRequestException invalid Ids.

| Referencia | Situaciones de entrada        | Comportamiento Esperado                                                                                              |
|:-----------|:------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| TB-0001    | Seguir a un usuario con ID 0. | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que el usuario no existe mediante una excepción. |

#### TB-0001 - Followed list update.

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                                                                            |
|:-----------|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0001    | Seguir a un usuario.   | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error al intentar actualizar los seguidores del usuario mediante una excepción. |

</details>

<details>
<summary>TB-0002</summary>

#### Dev:
- [@Emilia Lascano](https://github.com/EmiLascano)

#### TB-0002 - User does not follow seller

| Referencia | Situaciones de entrada                                                        | Comportamiento Esperado                                                                                                         |
|:-----------|:------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------|
| TB-0002    | Dejar de seguir a un usuario(vendedor) que no está en su lista de seguidores. | Se cumple: Status 400. Notifica que ocurrió un error al intentar dar unfollow a un usuario que no sigue mediante una excepción. |

</details>



<details>
<summary>TB-0004</summary>

#### Dev:
- [@Delfina Glavas](https://github.com/delfi85)

#### TB-0004 - User doesn't follow anyone

| Referencia | Situaciones de entrada                     | Comportamiento Esperado                             |
|:-----------|:-------------------------------------------|:----------------------------------------------------|
| TB-0004    | Verificar que el usuario no sigue a nadie. | **Se cumple:** Devuelve el mensaje de la excepción. |

#### TB-0004 - User doesn't have followers

| Referencia | Situaciones de entrada                      | Comportamiento Esperado                         |
|:-----------|:--------------------------------------------|:------------------------------------------------|
| TB-0004    | Verificar que al usuario no lo sigue nadie. | Se cumple: Devuelve el mensaje de la excepción. |

</details>

<details>
<summary>TB-0005</summary>

#### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### TB - 0005 Validate request null send exception BadRequestException

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                                                                            |
|:-----------|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0001    | Seguir a un usuario.   | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error al intentar actualizar los seguidores del usuario mediante una excepción. |

</details>

<details>
<summary>TB-0010</summary>

#### TB - 0010 Success

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                                                                            |
|:-----------|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0010    | Seguir a un usuario.   | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error al intentar actualizar los seguidores del usuario mediante una excepción. |

</details>

<details>
<summary>TB-0011</summary>

#### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)
- 
#### TB-0011 - Promotional products have an ID that does not exist

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                                                                            |
|:-----------|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0011    | Seguir a un usuario.   | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error al intentar actualizar los seguidores del usuario mediante una excepción. |

#### TB-0011 - Promotional products exist

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                                                                            |
|:-----------|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0011    | Seguir a un usuario.   | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error al intentar actualizar los seguidores del usuario mediante una excepción. |


</details>

<details>
<summary>TB-0013</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### TB - 0013 - User ID doesn't exist.

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                                                                            |
|:-----------|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0013    | Seguir a un usuario.   | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error al intentar actualizar los seguidores del usuario mediante una excepción. |

#### TB - 0013 - Query and User ID.

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                                                                            |
|:-----------|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0013    | Seguir a un usuario.   | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error al intentar actualizar los seguidores del usuario mediante una excepción. |

#### TB - 0013 - Success Only query.

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                                                                            |
|:-----------|:-----------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0013    | Seguir a un usuario.   | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error al intentar actualizar los seguidores del usuario mediante una excepción. |

</details>

<details>
<summary>TB-0014</summary>

#### Dev:
- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### TB-0014 - valid endDate Null

| Referencia | Situaciones de entrada                      | Comportamiento Esperado                                                                                                                                           |
|:-----------|:--------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0014    | Solicitar los post cuando end_date es null. | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error mediante una excepción.                                                  |

#### TB-0014 - Success

| Referencia | Situaciones de entrada                                    | Comportamiento Esperado                                                                                                                                           |
|:-----------|:----------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0014    | Solicitar la lista de post enviando stard_date y end_date | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error mediante una excepción.                                                  |

#### TB-0014 - valid exception BadRequestException

| Referencia | Situaciones de entrada                        | Comportamiento Esperado                                                                                                                                           |
|:-----------|:----------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TB-0014    | Solicitar los post cuando start_date es null. | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error mediante una excepción.                                                  |

</details>

<details>
<summary>TB-0015</summary>

#### Dev:
- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)

#### TB - 0015 - Activate Promo Post Not Found

| Referencia | Situaciones de entrada                             | Comportamiento Esperado                                                                                                                                            |
|:-----------|:---------------------------------------------------|:----------------------------------------------------------------------------------------------------------------------|
| TB-0015    | Intentar activar una promo a un vendedor sin post. | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error mediante una excepción.  |

#### TB - 0015 - Activate Promo User Not Found

| Referencia | Situaciones de entrada                       | Comportamiento Esperado                                                                                                  |
|:-----------|:---------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------|
| TB-0015    | Intentar activar una promo con usuario null. | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error mediante una excepción.         |

#### TB - 0015 - Activate Promo Success

| Referencia | Situaciones de entrada | Comportamiento Esperado                                                                                           |
|:-----------|:-----------------------|:------------------------------------------------------------------------------------------------------------------|
| TB-0015    | Activar una promo.     | Se cumple: Permite continuar con normalidad. No se cumple: Notifica que ocurrio un error mediante una excepción.  |

</details>


## Coverage

<image src="/src/main/resources/coverage.png" alt="Imagen de la covertura de los test realizados">

## Información del proyecto

<details>
 <summary> Información técnica </summary>

## Introducción

La ficha técnica es un documento que describe las características principales, la composición y las aplicaciones de un proyecto, aportando información detallada sobre los aspectos del mismo.

En el siguiente enlace se encuentra la documentación técnica del proyecto [Click acá](https://github.com/Fern1ck/be_java_hisp_w27_g01/blob/develop/src/main/resources/Esp.%20de%20Req.%20t%C3%A9cnicos%20funcionales%20-%20W27%20-%20G01%20-%20Sprint%20N%C2%BA%201%20-%20Spring.docx.pdf).
  
</details>


<details>
 <summary> Colección de peticiones </summary>

## Introducción

Para hacer pruebas con la API de SocialMeli será necesario disponer de una herramienta que permita hacer peticiones HTTP e interactuar con ésta. En este caso, recomendamos la herramienta Postman ya que permite gestionar y configurar de forma sencilla una colección de peticiones, por lo que será muy sencillo realizar las operaciones necesarias.

Postman nos permite definir un catálogo de peticiones, posteriormente podemos exportar e importar para compartirlas con otras personas. 

## Instalación y configuración de Postman

1. Descargar [Postman](https://www.getpostman.com/) e instalar.

2. Descargar el [Collection](https://github.com/Fern1ck/be_java_hisp_w27_g01/blob/develop/src/main/resources/Social%20Meli.postman_collection.json) de peticiones que se van a utilizar en la práctica. [Descargar](https://github.com/Fern1ck/be_java_hisp_w27_g01/blob/develop/src/main/resources/Social%20Meli.postman_collection.json) (botón derecho -> Guardar enlace como...)

3. En este punto debemos tener Postman instalado y un ficheros con extensión ".json" en nuestro PC.

5. Abrir Postman.

6. Importar la colección "Social%20Meli.postman_collection.json"
   
7. Finalmente podras poner a prueba cada funcionalidad del proyecto.
  
</details>

<details>
 <summary> Trello </summary>
  
## Introducción

Trello sirve para organizar, coordinar y gestionar cualquier tipo de tareas, ya bien sean proyectos laborales, tareas del día a día, planificación y ejecución de viajes e itinerarios, entre otras actividades que requieran establecer listas de actividades a llevar a cabo.

Para seguir el cronograma de trabajo empleado por el equipo por favor revisar el siguiente enlace [Click acá](https://trello.com/b/SO9rx038/equipo1-wave27)

 </details>

<details>
<summary> Swagger </summary>

## Introducción

Swagger es una herramienta que permite documentar y probar APIs de manera interactiva. Facilita la visualización y la interacción con los endpoints de la API, lo que es útil tanto para desarrolladores como para testers.

## Dependencia

Para integrar Swagger en el proyecto, se ha añadido la siguiente dependencia en el archivo `pom.xml`.

Swagger se agrego a este proyecto para dar visibilidad a los endpoints y los posibles RequestDTO que puedan ingresar asi como los distintos validaciones que tienen que cumplir los mismos.
Si se quiere acceder a la pagina es suficiente levantar el proyecto y acceder a la siguiente URL -> http://localhost:8080/swagger-ui.html

</details>
