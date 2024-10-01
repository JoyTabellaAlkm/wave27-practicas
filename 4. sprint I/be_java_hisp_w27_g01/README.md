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

```
  http://localhost:8080/users/{userId}/follow/{userIdToFollow}
```

```http
  Ejemplo:  /users/123/follow/234
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

```
  http://localhost:8080/users/{userId}/followers/count
```

```http
  Ejemplo: /users/234/followers/count/
```

| Response  |
| :-------- | 
    
    "user_id": 234, 
    "user_name": "vendedor1",
    "followers_count": 35

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |

</details>

<details>
<summary>Funcionalidad 3: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).</summary>

## Dev:

- [@Matias Gregorat](https://github.com/81866-Gregorat-Matias)
  
#### Metodo GET

```
  http://localhost:8080/users/{userId}/followers/list
```
```http
  Ejemplo: /users/234/followers/list
```

| Response  |
| :-------- | 
    
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

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`  | `int`    | **Required**. Número que identifica a cada usuario. |

</details>

<details>
<summary>Funcionalidad 4: Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).</summary>

## Dev:

- [@Delfina Glavas](https://github.com/delfi85)
  
#### Metodo GET

```
  http://localhost:8080/users/{userId}/followed/list
```

```http
  Ejemplo: /users/4698/followed/list
```

| Response  |
| :-------- | 
    
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

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |

</details>

<details>
<summary>Funcionalidad 5: Dar de alta una nueva publicación.</summary>

## Dev:

- [@Stephanie Castillo](https://github.com/Stephaaniie)

#### Metodo POST

```
  http://localhost:8080/products/post
```
  | PAYLOAD  |
  | :-------- | 
      
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

```
  http://localhost:8080/products/followed/{userId}/list
```
```http
  Ejemplo: /products/followed/4698/list
```
| Response  |
| :-------- | 

        "user_id": 4698, 
        "posts": 
        [
          {
            “user_id”: 123,
            "post_id": 32,
            "date": "01-05-2021",
            "product": 
            {
              "product_id": 62,
              "product_name": "Headset RGB Inalámbrico",
              "type": "Gamer",
              "brand": "Razer",
              "color": "Green with RGB",
              "notes": "Sin Batería"
            },
            "category": 120,
            "price": 2800.69
            },
            {
              “user_id”: 234, 
              "post_id": 18,
              "date": "29-04-2021",
              "product":
                {
                  "product_id": 1,
                  "productName": "Silla Gamer",
                  "type": "Gamer",
                  "brand": "Racer",
                  "color": "Red & Black",
                  "notes": "Special Edition"
                  },
              "category": 100,
              "price": 15000.50
           } 
        ]

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `int` | **Required**. Número que identifica a cada usuario. |
</details>

<details>
<summary>Funcionalidad 7: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.</summary>

## Dev:

- [@Emilia Lascano](https://github.com/EmiLascano)
  
#### Metodo POST

```
  http://localhost:8080/users/{userId}/unfollow/{userIdToUnfollow}
```
```http
  Ejemplo: /users/234/unfollow/123
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
 
```
  http://localhost:8080/users/{UserID}/followers/list?order=name_asc
  http://localhost:8080/users/{UserID}/followers/list?order=name_desc
  http://localhost:8080/users/{UserID}/followed/list?order=name_asc
  http://localhost:8080/users/{UserID}/followed/list?order=name_desc
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

```
  http://localhost:8080//products/followed/{userId}/list?order=date_asc
  http://localhost:8080/products/followed/{userId}/list?order=date_desc
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

```
  http://localhost:8080/products/promo-post
```
| PAYLOAD  |
| :-------- | 
    
    "user_id": 234,
    "date": "29-04-2021",
    "product":
    {
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

```
  http://localhost:8080/products/promo-post/count?user_id={userId}
```
| Response  |
| :-------- | 

    "user_id" : 234, 
    "user_name": "vendedor1",
    "promo_products_count": 23

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

```
  http://localhost:8080/products/search?query={query}&user_id={user_id}
```

```http
  Ejemplo: localhost:8080/products/search?query=ams
  Ejemplo: localhost:8080/products/search?query=ams&user_id=2
```

| Response  |
| :-------- | 

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


```
  http://localhost:8080/products/search/date?date_start=16/09/2021&date_end=18/09/2024
```

| Response  |
| :-------- | 

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
```
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
```
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

```
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
```
    "user_id": 234,
    "user_name": "vendedor1",
    "posts": [
    {
      "post_id": 18,
      "date": "29-04-2021",
      "product": 
      {
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
      "product": 
      {
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
    }]
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
