# Arquitectura Multicapa

## Estructura de carpetas
![carpetas](/docs/estructura_carpetas.png "Estructura de carpetas")

## Controller

Se encarga de manejar las request y response junto con los datos que contienen(comunicación con el cliente), 
además tiene control sobre los endpoints, y necesita comunicarse con el **Service** 
para seguir con el funcionamiento de la API.

* Se usa la anotación **@RestController**
* Solo debería conocer Objetos **DTOs**

## Service

Tiene que tener la mayor cantidad de lógica de negocio(cálculos, excepciones, etc), es la parte central de la API, 
recibe los datos del **Controller** para trabajar y según sea necesario puede comunicarse con el **Repository**.

* Se usa la anotación **@Service**
* Puede llegar a conocer todos los objetos **Models**, **DTOs** y **Entities**.
* Debido a que trabaja con distintos objetos
  - Suele tener alguna forma de *convertir un objeto en otro* 
  - Puede usar un *objeto para crear otro*
  - También se puede usar alguna librería como [Model Mapper](http://modelmapper.org/getting-started/)

## Repository

Su objetivo es controlar y persistir los **datos** de la API, se encarga de las operaciones de CRUD 
(Create, Read, Update, Delete) además puede llegar a devolver los datos *ordenados* y/o *filtrados* 
según sea necesario.

* Se usa la anotación **@Repository**
* Solo debería conocer Objetos **Entities**
* Pueden usar Objetos **Optional< T >**, donde T sería la entidad, pueden consultar este [blog de Baeldung](https://www.baeldung.com/java-optional)
* Disclaimer: vamos a trabajarlo como un listado de objetos en esta primera parte
* En un futuro usaremos algún ORM

# Tarea: completar las siguientes secciones

## DTO

Su nombre completo es Data Transfer Objects, son clases que se utilizan como "vistas" de una Entity, nos permiten crear clases con los atributos necesarios para los request o los reponse de nuestra API.
Su uso es importante no solo por la reduccion de carga de datos innecesarios sino tambien porque protege el modelo al no exponer datos sensibles.

* Se usan en el Controller
* Tienen la misma forma que una clase
* Pueden existir muchos, según haga falta.

## Entity

Son clases modelo, que representan a los objetos de nuestra aplicacion. En un futuro seran utilizadas para crear las tablas de la base de datos mediante ORM.
En resumen, es la que define la estructura de datos a utilizar.

* Cuando se utilice base de datos se le colocara la anotacion @Entity
* Tambien se las conoce como POJO, son clases simples que como detalle tienen que utilizar **WRAPPERS**

