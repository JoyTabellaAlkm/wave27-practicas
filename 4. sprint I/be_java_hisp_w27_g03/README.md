# Social Meli

---


## Integrantes

- Ana Maria García Acosta
- Angela Tatiana Daza Rojas
- Leandro Jossue Ramirez Vezga
- Sebastian Vallejo Rangel
- Vanessa Lozano Landinez

## Descripción del Proyecto

Social Meli es una aplicación desarrollada con Spring Boot que permite gestionar las relaciones entre usuarios y vendedores, sus publicaciones y productos en promoción. El desarrollo del proyecto fue realizado en: https://github.com/SebastianValleRang/be_java_hisp_w27_g03

## Tecnologías Utilizadas

- **SDK:** 22
- **Java:** 21
- **Spring Boot:** 3.3.4

### Dependencias

- **Spring Dev Tools**
- **Spring Web**
- **Lombok**

---

## Estructura del Proyecto

El proyecto está compuesto por las siguientes entidades:

- **User**
- **Post**
- **Product**

### Controladores y Servicios

Se implementan cuatro controladores, cada uno con sus respectivos servicios:

- **Post Controller**
- **Promo Controller**
- **Seller Controller**
- **User Controller**

A continuación, se presenta un diagrama que ilustra la estructura del proyecto, incluyendo los DTOs, repositorios e interfaces utilizadas:

<p align="center"><img src="src/main/resources/Diagrama.png" width="100%"></p>

---

## Cómo Ejecutar el Proyecto

Para probar ejecutar y hacer uso del proyecto se cuenta con una collección de Postman con los request necesarios para verificar cada user story.
Este archivo se encuentra en:
```src/main/resources/Sprint I.postman_collection.json ```



---

## Endpoints y responsables

- **US 0001:** Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
  - **Endpoint:** /users/{userId}/follow/{userIdToFollow}
  - **Responsable:** Angela Daza.
  - **Reglas de verificación:** 
    1. El usuario con id userId debe existir
    2. El usuario con id userIdToFollow debe existir y ser vendedor (tener al menos 1 post)
    3. El usuario no se puede seguir a si mismo
    4. Se verifica si el usuario ya es seguidor del vendedor


- **US 0002:** Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
  - **Endpoint:** /users/{userId}/followers/count
  - **Responsable:** Vanessa Lozano.
  - **Reglas de verificación:** El usuario con id userId debe existir y ser vendedor (tener al menos 1 post)


- **US 0003:** Obtener un listado de todos los usuarios que siguen a un determinado vendedor
  - **Endpoint:** /users/{userId}/followers/list
  - **Responsable:** Vanessa Lozano.
  - **Reglas de verificación:** El usuario con id userId debe existir y ser vendedor (tener al menos 1 post)


- **US 0004:** Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
  - **Endpoint:** /users/{userId}/followed/list
  - **Responsable:** Ana Garcia.
  - **Reglas de verificación:** El usuario con id userId debe existir


- **US 0005:** Dar de alta una nueva publicación
  - **Endpoint:** /products/post
  - **Responsable:** Leandro Ramírez.
  - **Reglas de verificación:**
    1. Se verifica que los datos enviados en la request estén completos y en el formato indicado
    1. El usuario con el id enviado para crear el post debe existir
    1. El producto enviado para crear el post debe existir en el repositorio de productos y coincidir en sus datos


- **US 0006:** Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
  - **Endpoint:** /products/followed/{userId}/list
  - **Responsables:** Leandro Ramírez y Sebastian Vallejo.
  - **Reglas de verificación:**
    1. El usuario con id userId debe existir
    1. El usuario con id userId debe seguir a al menos 1 vendedor


- **US 0007:** Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
  - **Endpoint:** /users/{userId}/unfollow/{userIdToUnfollow}
  - **Responsable:** Angela Daza.
  - **Reglas de verificación:**
    1. El usuario con id userId debe existir
    2. El usuario con id userIdToUnfollow debe existir y ser vendedor (tener al menos 1 post)
    3. Se verifica que el usuario con userId sea actualmente seguidor del vendedor 


- **US 0008:** Ordenamiento alfabético ascendente y descendente.
  - **Endpoint:** 
    - /users/{UserID}/followed/list?order=name_asc
    - /users/{UserID}/followed/list?order=name_desc
  - **Responsable:** Ana Garcia.
  - **Endpoint:** 
    - /users/{UserID}/followers/list?order=name_asc
    - /users/{UserID}/followers/list?order=name_desc
  - **Responsable:** Vanessa Lozano.
  - **Reglas de verificación:** Se verifica que el parámetro enviado (order) sea un ordenamiento válido (name_asc o name_desc)


- **US 0009:** Ordenamiento por fecha ascendente y descendente
  - **Endpoint:** 
  - /products/followed/{userId}/list?order=date_asc
  - /products/followed/{userId}/list?order=date_desc
  - **Responsable:** Leandro Ramírez.
  - **Reglas de verificación:** Se verifica que el parámetro enviado (order) sea un ordenamiento válido (date_asc o date_desc)


- **US 0010:** Llevar a cabo la publicación de un nuevo producto en promoción.
  - **Endpoint:** /products/promo-post
  - **Responsable:** Sebastian Vallejo.
  - **Reglas de verificación:**
    1. Se verifica que los datos enviados en la request estén completos y en el formato indicado
    1. El usuario con el id enviado para crear el post debe existir
    1. El producto enviado para crear el post debe existir en el repositorio de productos y coincidir en sus datos



- **US 0011:** Obtener la cantidad de productos en promoción de un determinado vendedor.
  - **Endpoint:** /products/promo-post/count?user_id={userId}
  - **Responsable:** Sebastian Vallejo.
  - **Reglas de verificación:** El usuario con id userId debe existir y ser vendedor (tener al menos 1 post)


### Bonus:

- **US 0012:** Listar los 5 vendedores con más posts
  - **Endpoint:** /users/list/most_active_sellers
  - **Responsables:** Leandro Ramírez y Sebastian Vallejo.
  - **Reglas de verificación:** Se verifica que el repositorio cuente con usuarios y al menos uno de ellos sea vendedor (tenga al menos 1 post)
    

- **US 0013:** Listar los vendedores inactivos, es decir que no han hecho publicaciones en los últimos 6 meses
  - **Endpoint:** /users/list/inactive_sellers
  - **Responsables:** Ana Garcia, Angela Daza y Vanessa Lozano
  - **Reglas de verificación:** 
    1. Se considera como vendedor inactivo a aquellos vendedores que no han publicado en los últimos 6 meses. 
    2. Se valida que existan usuarios en el repositorio
    3. Se valida si no existen vendedores inactivos

---

## Futuras implementaciones: 

Como parte del proyecto hemos considerado algunas implementaciones futuras. Estas son:

- Añadir un post de un vendedor a favoritos
- Listar post favoritos de un usuario
- Listar los 5 vendedores con más seguidores
- Mostrar las estadísticas de un vendedor: número de seguidores, número de seguidos, número de posts y fecha última publicación

Para más detalles sobre el desarrollo de estas funcionalidades, consulta el archivo de especificaciones de req. técnicos y funcionales en la carpeta de recursos.

