Luego de un análisis realizado en un sistema de facturación, se ha detectado un mal diseño en la base de datos. La misma, cuenta con una tabla facturas que almacena datos de diferente naturaleza.
Como se puede observar, la tabla cuenta con datos que podrían ser normalizados y separados en diferentes entidades.

Ejercicio

Se solicita para el escenario anterior:
Aplicar reglas de normalización y elaborar un modelo de DER que alcance la tercera forma normal (3FN).
Describir con sus palabras cada paso de la descomposición y aplicación de las reglas para visualizar el planteo realizado

Resumen de la Normalización
1FN: Se verificó que todos los atributos fueran atómicos y se identificó la necesidad de separar los datos de clientes.
2FN: Se creó la tabla Clientes para eliminar las dependencias parciales, asegurando que todos los atributos dependan completamente de la clave primaria de Facturas.
3FN: Se eliminaron las dependencias transitivas creando la tabla Productos y se excluyó el cálculo del Total, que puede derivarse.
Este proceso de normalización asegura que la base de datos esté organizada de manera eficiente, minimizando la redundancia y facilitando la integridad de los datos.