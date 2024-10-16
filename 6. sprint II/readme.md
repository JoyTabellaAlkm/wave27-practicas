<details>  
<summary> <h1> Social MELI API - Sprint 1 </h1></summary>  

Mercado Libre planea lanzar "SocialMeli" el próximo año, una herramienta que mejorará la conexión entre compradores y  
vendedores. La versión Beta permitirá a los usuarios seguir a sus vendedores favoritos y mantenerse actualizados sobre  
sus novedades.

## Definiciones de equipo

- Si un usuario tiene publicaciones, se considera un vendedor.
- Los vendedores pueden seguir a otros vendedores.
- Si un vendedor elimina todas sus publicaciones, sigue siendo vendedor.
- Los post_id no pueden repetirse.
- Todos los datos del payload son obligatorios.
- Los descuentos se gestionan por publicación, no por producto.
- El product_id puede repetirse.
- La función de seguimiento almacena el objeto user y el objeto userToFollow (ambos de tipo User)
- Cada publicación debe contener un único producto.
- Cuando se debe responder alguna lista y la misma esta vacia, decidimos no devolver un mensaje de error.
- Las ramas de características deben basarse en la rama develop y seguir la estructura us/`{número-user-story}`-  
  `{breve-descripción}`. Por ejemplo: `us/1-follow-user`.
- Contenido de la carpeta resources:
  - [Postman](https://github.com/JoyTabellaAlkm/wave27-practicas/tree/cisternas_celeste/4.%20sprint%20I/ejercicio_socialMeli2/src/main/resources/API-Documentation.Postman.json)
  - [Requerimientos](https://github.com/JoyTabellaAlkm/wave27-practicas/tree/cisternas_celeste/4.%20sprint%20I/ejercicio_socialMeli2/src/main/resources/requerimientos.pdf)
  - [UML - Diagrama de Clases](https://github.com/JoyTabellaAlkm/wave27-practicas/tree/cisternas_celeste/4.%20sprint%20I/ejercicio_socialMeli2/src/main/resources/diagrama.png)

### Aclaracion de equipo:

Todos los PR (Pull Requests) fueron revisados en vivo por el equipo, y las correcciones se realizaron en el momento.  
Esto asegura que cada detalle fue discutido y abordado de manera colaborativa.

## Endpoints

<details>  
<summary> <code>US 0001:</code> Poder realizar la acción de “Follow” (seguir) a un determinado vendedor. </summary>  

```java  
1.POST /users/{userId}/follow/{userIdToFollow}.   
```  

| Parameter        | Type  | Description                               |  
|:-----------------|:------|:------------------------------------------|  
| `userId`         | `int` | Número que identifica al usuario actual   |  
| `userIdToFollow` | `int` | Número que identifica al usuario a seguir |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

```json  
{
  "user_id": 3,
  "followed_user_id": 1
}  
```  

| Response | **Status Code 400 (Bad Request):** |  
|----------|------------------------------------|  

```json  
{
  "message": "User 5 is not a seller",
  "status_code": "BAD_REQUEST"
}  
```  

```json  
{
  "message": "User 1 can't follow himself",
  "status_code": "BAD_REQUEST"
}  
```  

```json  
{
  "message": "User 3 already follows user 1",
  "status_code": "BAD_REQUEST"
}  
```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 15 not found",
  "status_code": "NOT_FOUND"
}  
```  

### Responsables

- [@LicFuraca](https://www.github.com/LicFuraca) Martín Díaz
- [@fcafici](https://www.github.com/fcafici) Felipe Cafici

</details>  

<details>  
<summary> <code>US 0002:</code> Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor. </summary>  

```java  
2.GET /users/{userId}/followers/count  
```  

| Parameter | Type  | Description                          |  
|:----------|:------|:-------------------------------------|  
| `userId`  | `int` | Número que identifica a cada usuario |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

```json  
{
  "user_id": 234,
  "user_name": "vendedor1",
  "followers_count": 35
}  
```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}  
```  

| Response | **Status Code 400 (Bad Request):** |  
|----------|------------------------------------|  

```json  
{
  "message": "User 4 is not a seller",
  "status_code": "BAD_REQUEST"
}

```  

### Responsables

- [@Inwinkelried](https://www.github.com/Inwinkelried) Santiago Inwinkelried

</details>  

<details>  
<summary> <code>US 0003:</code> Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?). </summary>  

```java  
3.GET /users/{userId}/followers/list  
```  

| Parameter | Type  | Description                          |  
|:----------|:------|:-------------------------------------|  
| `userId`  | `int` | Número que identifica a cada usuario |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

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
      "user_id": 1536,
      "user_name": "usuario2"
    },
    {
      "user_id": 2236,
      "user_name": "usuario3"
    }
  ]
}  
```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}

```  

| Response | **Status Code 400 (Bad Request):** |  
|----------|------------------------------------|  

```json  
{
  "message": "User 4 is not a seller",
  "status_code": "BAD_REQUEST"
}

```  

### Responsables

- [@mSoledadAmore](https://www.github.com/mSoledadAmore) Soledad Amore

</details>  

<details>  
<summary> <code>US 0004:</code> Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?). </summary>  

```java  
4.GET /users/{userId}/followed/list  
```  

| Parameter | Type  | Description                          |  
|:----------|:------|:-------------------------------------|  
| `userId`  | `int` | Número que identifica a cada usuario |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

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
      "user_id": 6932,
      "user_name": "vendedor2"
    },
    {
      "user_id": 6631,
      "user_name": "vendedor3"
    }
  ]
}  
```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}

```  

### Responsables

- [@LicFuraca](https://www.github.com/LicFuraca) Martín Díaz

</details>  

<details>  
<summary> <code>US 0005:</code> Dar de alta una nueva publicación. </summary>  

```java  
5.POST /products/post  
```  

| Parameter      | Type        | Description                                                                                                              |  
|----------------|-------------|--------------------------------------------------------------------------------------------------------------------------|  
| `user_id`      | `int`       | Número que identifica a cada usuario                                                                                     |  
| `date`         | `LocalDate` | Fecha de la publicación en formato dd-MM-yyyy                                                                            |  
| `product_id`   | `int`       | Número identificatorio de un producto asociado a una publicación                                                         |  
| `product_name` | `String`    | Cadena de caracteres que representa el nombre de un producto                                                             |  
| `type`         | `String`    | Cadena de caracteres que representa el tipo de un producto                                                               |  
| `brand`        | `String`    | Cadena de caracteres que representa la marca de un producto                                                              |  
| `color`        | `String`    | Cadena de caracteres que representa el color de un producto                                                              |  
| `notes`        | `String`    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |  
| `category`     | `int`       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |  
| `price`        | `double`    | Precio del producto                                                                                                      |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

```json  
{
  "user_id": 1,
  "date": "29-04-2021",
  "category": 100,
  "price": 1500.5,
  "product": {
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition",
    "product_id": 1,
    "product_name": "Silla Gamer"
  }
}

```  

| Response | **Status Code 400 (Bad Request):** |  
|----------|------------------------------------|  

```json  
{
  "message": "Product cannot be empty",
  "status_code": "BAD_REQUEST"
}  
```  

```json  
{
  "message": "Invalid user ID",
  "status_code": "BAD_REQUEST"
}  
```  

```json  
{
  "message": "Invalid category",
  "status_code": "BAD_REQUEST"
}  
```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}

```  

### Responsables

- [@Celescis](https://www.github.com/Celescis) Celeste Cisternas
- [@Inwinkelried](https://www.github.com/Inwinkelried) Santiago Inwinkelried
- [@mSoledadAmore](https://www.github.com/mSoledadAmore) Soledad Amore

</details>  

<details>  
<summary> <code>US 0006:</code> Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero). </summary>  

```java  
6.GET /products/followed/{userId}/list  
```  

| Parameter | Type  | Description                          |  
|:----------|:------|:-------------------------------------|  
| `userId`  | `int` | Número que identifica a cada usuario |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

```json  
{
  "user_id": 4698,
  "posts": [
    {
      "user_id": 123,
      "post_id": 32,
      "date": "01-05-2021",
      "product": {
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
      "user_id": 234,
      "post_id": 18,
      "date": "29-04-2021",
      "product": {
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
}  
```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}  
```  

### Responsables

- [@fcafici](https://www.github.com/fcafici) Felipe Cafici

</details>  

<details>  
<summary> <code>US 0007:</code> Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor. </summary>  

```java  
7.POST /users/{userId}/unfollow/{userIdToUnfollow}  
```  

| Parameter          | Type  | Description                                        |  
|--------------------|-------|----------------------------------------------------|  
| `userId`           | `int` | Número que identifica al usuario actual            |  
| `userIdToUnfollow` | `int` | Número que identifica al usuario a dejar de seguir |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

```json  
{
  "user_id": 1,
  "followed_user_id": 3
}  
```  

| Response | **Status Code 404(Not Found):** |  
|----------|---------------------------------|  

```json  
{
  "message": "User 5 does not follow user 1",
  "status_code": "NOT_FOUND"
}  
```  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}  
```  

### Responsables

- [@Celescis](https://www.github.com/Celescis) Celeste Cisternas

</details>  

<details>  
<summary> <code>US 0008:</code> Ordenamiento alfabético ascendente y descendente. </summary>  

```java  
8.GET /users/{UserID}/followers/list?order=name_asc  
       /users/{UserID}/followers/list?order=name_desc       /users/{UserID}/followed/list?order=name_asc       /users/{UserID}/followed/list?order=name_desc  
```  

| Parameter   | Type     | Description            |  
|-------------|----------|------------------------|  
| `name_asc`  | `String` | Alfabético ascendente  |  
| `name_desc` | `String` | Alfabético descendente |  

| Response Followed | **Status Code 200(OK):** |  
|-------------------|--------------------------|  

```json  
{
  "followed": [
    {
      "user_id": 9,
      "user_name": "Andres"
    },
    {
      "user_id": 5,
      "user_name": "Hernan"
    },
    {
      "user_id": 3,
      "user_name": "Jose"
    },
    {
      "user_id": 7,
      "user_name": "Lucas"
    }
  ],
  "user_id": 2,
  "user_name": "Juan"
}  
```  

| Response Follower | **Status Code 200(OK):** |  
|-------------------|--------------------------|  

```json  
{
  "followers": [
    {
      "user_id": 5,
      "user_name": "Hernan"
    },
    {
      "user_id": 3,
      "user_name": "Jose"
    },
    {
      "user_id": 11,
      "user_name": "Luis"
    },
    {
      "user_id": 4,
      "user_name": "Oscar"
    }
  ],
  "user_id": 2,
  "user_name": "Juan"
}

```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}

```  

| Response | **Status Code 400 (Bad Request):** |  
|----------|------------------------------------|  

```json  
{
  "message": "Cannot order by cualquier_verdura",
  "status_code": "BAD_REQUEST"
}  
```  

### Responsables

- [@Inwinkelried](https://www.github.com/Inwinkelried) Santiago Inwinkelried

</details>  

<details>  
<summary> <code>US 0009:</code> Ordenamiento por fecha ascendente y descendente. </summary>  

```java  
9.GET /products/followed/{userId}/list?order=date_asc  
       /products/followed/{userId}/list?order=date_desc  
```  

| Parameter   | Type     | Description                                    |  
|-------------|----------|------------------------------------------------|  
| `date_asc`  | `String` | Fecha ascendente (de más antigua a más nueva)  |  
| `date_desc` | `String` | Fecha descendente (de más nueva a más antigua) |  

| Response Followed | **Status Code 200(OK):** |  
|-------------------|--------------------------|  

```json  
{
  "posts": [
    {
      "date": "25-09-2024",
      "product": {
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition",
        "product_id": 1,
        "product_name": "Silla Gamer"
      },
      "category": 0,
      "price": 1500.5,
      "user_id": 1,
      "post_id": 1
    },
    {
      "date": "29-09-2024",
      "product": {
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition",
        "product_id": 1,
        "product_name": "Silla Gamer"
      },
      "category": 0,
      "price": 1500.5,
      "user_id": 2,
      "post_id": 2
    },
    {
      "date": "29-09-2024",
      "product": {
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition",
        "product_id": 1,
        "product_name": "Silla Gamer"
      },
      "category": 0,
      "price": 1500.5,
      "user_id": 1,
      "post_id": 4
    }
  ],
  "user_id": 3
}

```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}

```  

| Response | **Status Code 400 (Bad Request):** |  
|----------|------------------------------------|  

```json  
{
  "message": "Cannot order by cualquier_verdura_v2",
  "status_code": "BAD_REQUEST"
}  
```  

### Responsables

- [@mSoledadAmore](https://www.github.com/mSoledadAmore) Soledad Amore

</details>  

<details>  
<summary> <code>US 0010:</code> Llevar a cabo la publicación de un nuevo producto en promoción. </summary>  

```java  
10.POST /products/promo-post  
```  

| Parameter      | Type        | Description                                                                                                              |  
|----------------|-------------|--------------------------------------------------------------------------------------------------------------------------|  
| `user_id`      | `int`       | Número que identifica a cada usuario                                                                                     |  
| `date`         | `LocalDate` | Fecha de la publicación en formato dd-MM-yyyy                                                                            |  
| `product_id`   | `int`       | Número identificatorio de un producto asociado a una publicación                                                         |  
| `product_name` | `String`    | Cadena de caracteres que representa el nombre de un producto                                                             |  
| `type`         | `String`    | Cadena de caracteres que representa el tipo de un producto                                                               |  
| `brand`        | `String`    | Cadena de caracteres que representa la marca de un producto                                                              |  
| `color`        | `String`    | Cadena de caracteres que representa el color de un producto                                                              |  
| `notes`        | `String`    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |  
| `category`     | `int`       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |  
| `price`        | `double`    | Precio del producto                                                                                                      |  
| `has_promo`    | `boolean`   | Campo true o false para determinar si un producto está en promoción o no                                                 |  
| `discount`     | `double`    | En caso de que un producto estuviese en promoción, establece el monto de descuento.                                      |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

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

| Response | **Status Code 400 (Bad Request):** |  
|----------|------------------------------------|  

```json  
{
  "message": "Product cannot be empty",
  "status_code": "BAD_REQUEST"
}  
```  

```json  
{
  "message": "Invalid user ID",
  "status_code": "BAD_REQUEST"
}  
```  

```json  
{
  "message": "Discount cannot be zero",
  "status_code": "BAD_REQUEST"
}  
```  

```json  
{
  "message": "Date cannot be empty",
  "status_code": "BAD_REQUEST"
}  
```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}

```  

### Responsables

- [@Celescis](https://www.github.com/Celescis) Celeste Cisternas

</details>  

<details>  
<summary> <code>US 0011:</code> Obtener la cantidad de productos en promoción de un determinado vendedor. </summary>  

```java  
11.GET /products/promo-post/count?user_id={userId}  
```  

| Parameter              | Type     | Description                                                           |  
|------------------------|----------|-----------------------------------------------------------------------|  
| `user_id`              | `int`    | Número que identifica a cada usuario                                  |  
| `user_name`            | `String` | Cadena de caracteres que representa el nombre del usuario             |  
| `promo_products_count` | `int`    | Cantidad numérica de productos en promoción de un determinado usuario |  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

```json  
{
  "user_id": 234,
  "user_name": "vendedor1",
  "promo_products_count": 23
}

```  

| Response | **Status Code 404 (Not Found):** |  
|----------|----------------------------------|  

```json  
{
  "message": "User 99 not found",
  "status_code": "NOT_FOUND"
}

```  

| Response | **Status Code 400 (Bad Request):** |  
|----------|------------------------------------|  

```json  
{
  "message": "User 3 is not a seller",
  "status_code": "BAD_REQUEST"
}

```  

### Responsables

- [@LicFuraca](https://www.github.com/LicFuraca) Martín Díaz

</details>  

<details>  
<summary> <code>US BONUS:</code> Obtener un listado de top 10 vendedores según la cantidad de seguidores y desempatan por la cantidad de publicaciones. </summary>  

```java  
12.GET /users/top-10  
```  

| Response | **Status Code 200(OK):** |  
|----------|--------------------------|  

```json  
[
  {
    "user_id": 7,
    "user_name": "Lucas",
    "followers_count": 11,
    "posts_count": 1
  },
  {
    "user_id": 9,
    "user_name": "Andres",
    "followers_count": 9,
    "posts_count": 4
  },
  {
    "user_id": 5,
    "user_name": "Hernan",
    "followers_count": 8,
    "posts_count": 2
  },
  {
    "user_id": 2,
    "user_name": "Juan",
    "followers_count": 6,
    "posts_count": 11
  },
  {
    "user_id": 3,
    "user_name": "Jose",
    "followers_count": 6,
    "posts_count": 1
  },
  {
    "user_id": 4,
    "user_name": "Oscar",
    "followers_count": 5,
    "posts_count": 5
  },
  {
    "user_id": 6,
    "user_name": "Santiago",
    "followers_count": 4,
    "posts_count": 4
  },
  {
    "user_id": 1,
    "user_name": "Pepe",
    "followers_count": 2,
    "posts_count": 6
  },
  {
    "user_id": 8,
    "user_name": "Carlos",
    "followers_count": 1,
    "posts_count": 4
  },
  {
    "user_id": 11,
    "user_name": "Luis",
    "followers_count": 1,
    "posts_count": 2
  }
]  
```  

</details>  
</details>  
<details>  
<summary> <h1> Social MELI Testing - Sprint 2  </h1></summary>  

Social Meli, la nueva implementación de MercadoLibre que fue realizada por el equipo de desarrollo “Bootcamp” se ha convertido en ¡Todo un éxito!

Dado esto y que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones que considera que sean necesarias tener en cuenta a la hora de incorporar datos como así también diferentes test unitarios que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

## Definiciones de equipo

- Todos los mensajes deberán estar en español, sin importar si son mensajes de error o de éxito.
- Todas las fechas deberán ser pasadas o presentes.
- Branching:
  - Unit tests: `test/{número de test}-{breve descripción}`
  - Integration tests: `int/{número de user story}-{breve descripción}`

### Aclaracion de equipo:

Todos los PR (Pull Requests) fueron revisados en vivo por el equipo, y las correcciones se realizaron en el momento.  
Esto asegura que cada detalle fue discutido y abordado de manera colaborativa.

Sin embargo, se agregaron comentarios en los PRs para dejar constancia de las correcciones.

# 94% de Coverage con:

## Unit Tests

<details>  
<summary> <code>T-0001</code> Verificar que el usuario a seguir exista <code>(US-0001)</code> </summary>  

- **Responsables:** [@Inwinkelried](https://www.github.com/Inwinkelried) - Santiago Inwinkelried
- **Si cumple:** Permite continuar con normalidad.
- **Si no cumple:** Notifica la no existencia mediante una excepción.
- **Tests asociados:**
  - `userToFollowShouldExist()`: *Expected: OK (200) for valid seller.*
  - `userToFollowIsNotSeller()`: *Expected: BAD REQUEST (400) if user is not a seller.*
  - `userNotFound()`: *Expected: NOT FOUND (404) for non-existent user.*
  - `userToFollowNotFound()`: *Expected: NOT FOUND (404) for non-existent seller.*
  - `userCantFollowHimself()`: *Expected: BAD REQUEST (400) for self-follow.*
  - `userAlreadyFollowsUserToFollow()`: *Expected: BAD REQUEST (400) if already followed.*

</details>  


<details>  
<summary> <code>T-0002</code> Verificar que el usuario a dejar de seguir exista <code>(US-0007)</code></summary>  

- **Responsables:** [@mSoledadAmore](https://www.github.com/mSoledadAmore) - Soledad Amore
- **Si cumple:** Permite continuar con normalidad.
- **Si no cumple:** Notifica la no existencia mediante una excepción.
- **Tests asociados:**
  - `countFollowersShouldBeOk()`: *Expected: OK (200) for valid seller.*
  - `countFollowersNotFoundUserException()`: *Expected: NOT FOUND (404) for non-existent user.*
  - `countFollowersNotSellerValidation()`: *Expected: BAD REQUEST (400) if user is not a seller.*

</details>  

<details>  
<summary> <code>T-0003</code> Verificar que el tipo de ordenamiento alfabético exista <code>(US-0008)</code></summary>  

- **Responsables:** [@Celescis](https://www.github.com/Celescis) - Celeste Cisternas
- **Si cumple:** Permite continuar con normalidad.
- **Si no cumple:** Notifica la no existencia mediante una excepción.
- **Tests asociados:**
  - `getFollowedsAlphabeticalOrderAsc()`: *Expected: OK (200) for followeds in ascending alphabetical order.*
  - `getFollowersAlphabeticalOrderAsc()`: *Expected: OK (200) for followers in ascending alphabetical order.*
  - `getFollowedsAlphabeticalOrderDescShouldBeOk()`: *Expected: OK (200) for followeds in descending alphabetical order.*
  - `getFollowersAlphabeticalOrderDesc()`: *Expected: OK (200) for followers in descending alphabetical order.*
  - `getFollowersAlphabeticalOrderException()`: *Expected: BAD REQUEST (400) for invalid request regarding followers.*
  - `getFollowedsAlphabeticalOrderException()`: *Expected: BAD REQUEST (400) for invalid request regarding followeds.*
  - `getFollowersAlphabeticalOrderExceptionNotFoundUser()`: *Expected: NOT FOUND (404) for non-existent user.*
  - `getFollowedsAlphabeticalOrderExceptionNotFoundUser()`: *Expected: NOT FOUND (404) for non-existent user.*
</details>  

<details>  
<summary>  <code>T-0004</code> Verificar el correcto ordenamiento ascendente y descendente por nombre <code>(US-0008)</code></summary>  

- **Responsables:** [@fcafici](https://www.github.com/fcafici) - Felipe Cafici
- Devuelve la lista ordenada según el criterio solicitado.
- **Tests asociados:**
  - `findAllFollowedSortsAsc()`: *Expected: OK (200) for sorted followeds in ascending order.*
  - `findAllFollowersSortsAsc()`: *Expected: OK (200) for sorted followers in ascending order.*
  - `findAllFollowedSortsDesc()`: *Expected: OK (200) for sorted followeds in descending order.*
  - `findAllFollowersSortsDesc()`: *Expected: OK (200) for sorted followers in descending order.*
  - `findAllFollowersSortsDefault()`: *Expected: OK (200) for followers in default order.*
  - `findAllFollowedSortsDefault()`: *Expected: OK (200) for followeds in default order.*
  - `findAllFollowersThrowsValidationException()`: *Expected: BAD REQUEST (400) for invalid request regarding followers.*
</details>  

<details>  
<summary>  <code>T-0005</code> Verificar que el tipo de ordenamiento por fecha exista <code>(US-0009)</code> </summary>  

- **Responsables:** [@fcafici](https://www.github.com/fcafici) - Felipe
  Cafici & [@LicFuraca](https://www.github.com/LicFuraca) - Martín Díaz
- **Si cumple:** Permite continuar con normalidad.
- **Si no cumple:** Notifica la no existencia mediante una excepción.
- **Tests asociados:**
  - `getPostsFromFollowedOrdersThrowsValidationException()`: *Expected: BAD REQUEST (400) for invalid sort type.*
  - `getPostsFromFollowedOrdersAscTest()`: *Expected: OK (200) for posts from followed users in ascending order.*
  - `getPostsFromFollowedOrdersDescTest()`: *Expected: OK (200) for posts from followed users in descending order.*
</details>  

<details>  
<summary> <code>T-0006</code> Verificar el correcto ordenamiento ascendente y descendente por fecha <code>(US-0009)</code></summary>  

- **Responsables:** [@fcafici](https://www.github.com/fcafici) - Felipe
  Cafici & [@LicFuraca](https://www.github.com/LicFuraca) - Martín Díaz
- Verificar el correcto ordenamiento ascendente y descendente por fecha.
- **Tests asociados:**
  - `getPostsFromFollowedOrdersAscTest()`: *Expected: OK (200) for posts from followed users in ascending order.*
  - `getPostsFromFollowedOrdersDescTest()`: *Expected: OK (200) for posts from followed users in descending order.*
  - `getPostsFromFollowedOrdersDefaultTest()`: *Expected: OK (200) for posts from followed users in default order.*
  - `getPostsFromFollowedOrdersThrowsUserNotFound()`: *Expected: NOT FOUND (404) for non-existent user.*
</details>  

<details>  
<summary> <code>T-0007</code> Verificar que la cantidad de seguidores de un determinado usuario sea correcta <code>(US-0002)</code></summary>  

- **Responsables:** [@mSoledadAmore](https://www.github.com/mSoledadAmore) - Soledad
  Amore, [@Celescis](https://www.github.com/Celescis) - Celeste
  Cisternas & [@Inwinkelried](https://www.github.com/Inwinkelried) - Santiago Inwinkelried
- Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.
- **Tests asociados:**
  - `countFollowersShouldBeOk()`: *Expected: OK (200) and correct followers count for valid seller.*
  - `countFollowersNotFoundUserException()`: *Expected: NOT FOUND (404) for non-existent user.*
  - `countFollowersNotSellerValidation()`: *Expected: BAD REQUEST (400) if user is not a seller.*

</details>  

<details>  
<summary> <code>T-0008</code> Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas <code>(US-0006)</code> </summary>  

- **Responsables:** [@fcafici](https://www.github.com/fcafici) - Felipe
  Cafici & [@LicFuraca](https://www.github.com/LicFuraca) - Martín Díaz
- Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a
  partir del día de la fecha.
- **Tests asociados:**
  - `getPostsFromFollowedOrdersAscTest()`: *Expected: OK (200) for posts from followed users in ascending order.*
  - `getPostsFromFollowedOrdersDescTest()`: *Expected: OK (200) for posts from followed users in descending order.*
  - `getPostsFromFollowedOrdersDefaultTest()`: *Expected: OK (200) for posts from followed users in default order.*
</details>  

## Integration Tests

<details>  
<summary> <code>(US-0001)</code> Poder realizar la acción de “Follow” (seguir) a un determinado vendedor</summary>  

- **Responsables:** [@LicFuraca](https://www.github.com/LicFuraca) Martín Díaz
- **Tests asociados:**
  - `followUserTestReturnsOk()`: *Expected: OK (200) for valid seller.*
  - `followUserTestReturnsValidationException()`: *Expected: BAD REQUEST (400) for self-follow.*
  - `followUserTestReturnsNotFound()`: *Expected: NOT FOUND (404) for non-existent user.*
  - `followUserTestReturnsNotFoundSeller()`: *Expected: NOT FOUND (404) for non-existent seller.*
  - `followUserTestReturnsValidationExceptionNotSeller()`:  *Expected: BAD REQUEST (400) if user is not a seller.*
  - `followUserTestReturnsValidationExceptionAlreadyFollowed()`: *Expected: BAD REQUEST (400) if already followed.*

</details>  

<details>  
<summary> <code>(US-0005)</code> Dar de alta una nueva publicación</summary>  

- **Responsables:** [@Inwinkelried](https://www.github.com/Inwinkelried) - Santiago Inwinkelried
- **Tests asociados:**
  - `createPostTestReturnsOk()`: *Expected: OK (200) with valid data.*
  - `createPostTestReturnsBadRequest()`: *Expected: BAD REQUEST (400) with invalid data.*
  - `createPostTestForNotSellerReturnsBadRequest()`: *Expected: BAD REQUEST (400) if user is not a seller.*

</details>  

<details>  
<summary> <code>(US-0010)</code> Agregar publicación promocional</summary>  

- **Responsables:** [@Celescis](https://www.github.com/Celescis) Celeste Cisternas
- **Tests asociados:**
  - `addPromoPostTestReturnsOk()`: *Expected: OK (200) with valid data.*
  - `promoPostTestReturnsNotFoundExceptionNotExistsUser()`: *Expected: NOT FOUND (404) for non-existent user.*
  - `promoPostWithMultipleValidationErrorsShouldReturnBadRequest()`:  *Expected: BAD REQUEST (400) with validation
    errors.*

</details>  

<details>  
<summary> <code>(US-0011)</code> Contar publicaciones promocionales</summary>  

- **Responsables:** [@mSoledadAmore](https://www.github.com/mSoledadAmore) Soledad Amore
- **Tests asociados:**
  - `getPromoPostCountOk()`: *Expected: OK (200) with correct count.*
  - `getPromoPostCountUserNotFound()`: *Expected: NOT FOUND (404) for non-existent user.*
  - `getPromoPostCountUserNotSeller()`: *Expected: BAD REQUEST (400) if user is not a seller.*

</details>  

<details>  
<summary> <code>(US-BONUS)</code> Obtener un listado del top 10 vendedores</summary>  

- **Responsables:** [@fcafici](https://www.github.com/fcafici) Felipe Cafici
- **Tests asociados:**
  - `getTop10UsersTest()`: <br> *Expected: OK (200) with correct top users list.*

</details>  

## Validations

| Dato/Parámetro | ¿Obligatorio? | Validación                                                                                                                                 | Mensaje de error                                                                                                                       |  
|----------------|---------------|--------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|  
| user_id        | Sí            | Que el campo no esté vacío.<br> Mayor 0                                                                                                    | El id no puede estar vacío.<br> El id debe ser mayor a cero.                                                                           |  
| date           | Sí            | Que el campo no esté vacío.                                                                                                                | La fecha no puede estar vacía.                                                                                                         |  
| product_id     | Sí            | Que el campo no esté vacío.<br> Mayor 0                                                                                                    | La id no puede estar vacía.<br> El id debe ser mayor a cero.                                                                           |  
| product_name   | Sí            | Que el campo no esté vacío.<br> Longitud máxima de 40 caracteres.<br> Que no posea caracteres especiales (%, &, $, etc), permite espacios. | El campo no puede estar vacío.<br> La longitud no puede superar los 40 caracteres.<br> El campo no puede poseer caracteres especiales. |  
| type           | Sí            | Que el campo no esté vacío.<br> Longitud máxima de 15 caracteres.<br> Que no posea caracteres especiales (%, &, $, etc)                    | El campo no puede estar vacío.<br> La longitud no puede superar los 15 caracteres.<br> El campo no puede poseer caracteres especiales. |  
| brand          | Sí            | Que el campo no esté vacío.<br> Longitud máxima de 25 caracteres.<br> Que no posea caracteres especiales (%, &, $, etc)                    | La longitud no puede superar los 25 caracteres.<br> El campo no puede estar vacío.<br> El campo no puede poseer caracteres especiales. |  
| color          | Sí            | Que el campo no esté vacío.<br> Longitud máxima de 15 caracteres.<br> Que no posea caracteres especiales (%, &, $, etc)                    | El campo no puede estar vacío.<br> La longitud no puede superar los 15 caracteres.<br> El campo no puede poseer caracteres especiales. |  
| notes          | No            | Longitud máxima de 80 caracteres.<br> Que no posea caracteres especiales (%, &, $, etc), permite espacios.                                 | La longitud no puede superar los 80 caracteres.<br> El campo no puede poseer caracteres especiales.                                    |  
| category       | Sí            | Que el campo no esté vacío.                                                                                                                | El campo no puede estar vacío.                                                                                                         |  
| price          | Sí            | Que el campo no esté vacío.<br> El precio máximo puede ser 10.000.000.                                                                     | El campo no puede estar vacío.<br> El precio máximo por producto es de 10.000.000.                                                     |  

</details>  

# Integrantes EQUIPO 2 :handshake:

- [@mSoledadAmore](https://www.github.com/mSoledadAmore) Soledad Amore
- [@fcafici](https://www.github.com/fcafici) Felipe Cafici
- [@LicFuraca](https://www.github.com/LicFuraca) Martín Díaz
- [@Inwinkelried](https://www.github.com/Inwinkelried) Santiago Inwinkelried
- [@Celescis](https://www.github.com/Celescis) Celeste Cisternas

# Agradecimientos ✨

Queremos agradecerle a todo el equipo y a nuestros mentores por este tiempo compartido.  
Gracias por brindarnos la oportunidad de aprender y crecer juntos codo a codo.  
¡Estamos emocionados por lo que se viene y por seguir compartiendo este viaje en conjunto! 🙌  
¡Gracias a todos! ❤️
