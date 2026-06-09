# TP Especial Programación 3

## Sistema de Gestión y Asignación de Paquetes a Camiones

### Integrantes

* Carrillo Santiago
* D'Annunzio Julieta

---

# Descripción

El sistema permite administrar información de camiones y paquetes obtenida desde archivos CSV.

Cada paquete posee:

* ID único.
* Código identificador.
* Peso en kilogramos.
* Indicador de si contiene alimentos.
* Nivel de urgencia entre 1 y 100.

Cada camión posee:

* ID único.
* Patente.
* Indicación de si está refrigerado.
* Capacidad máxima de carga.

El objetivo es asignar los paquetes a los camiones respetando las restricciones del problema.

---

# Restricciones

Un paquete puede ser transportado por un camión únicamente si:

1. El camión posee capacidad suficiente para transportarlo.
2. Si el paquete contiene alimentos, el camión debe ser refrigerado.

---

# Estructuras de Datos Utilizadas

## Servicio 1

Permite obtener un paquete a partir de su código.

**Estructura utilizada:**

```java
HashMap<String, Paquete>
```

**Complejidad temporal:**

```text
O(1)
```

---

## Servicio 2

Permite obtener todos los paquetes que contienen alimentos o todos los que no contienen alimentos.

**Estructura utilizada:**

```java
HashMap<Boolean, List<Paquete>>
```

**Complejidad temporal:**

```text
O(1)
```

---

## Servicio 3

Permite recuperar todos los paquetes cuyo nivel de urgencia se encuentra dentro de un rango determinado.

**Estructura utilizada:**

```java
TreeMap<Integer, List<Paquete>>
```

**Complejidad temporal:**

```text
O(log n + k)
```

Donde:

* `n` es la cantidad de niveles de urgencia almacenados.
* `k` es la cantidad de paquetes recuperados.

---

# Algoritmo Greedy

## Estrategia

Los paquetes se ordenan por peso descendente.

Para cada paquete se selecciona el primer camión que pueda transportarlo respetando las restricciones establecidas.

## Ventajas

* Bajo costo computacional.
* Implementación sencilla.
* Obtiene soluciones rápidamente.

## Desventajas

* No garantiza encontrar siempre la solución óptima.

## Complejidad Temporal

```text
O(P × C)
```

Donde:

* `P` es la cantidad de paquetes.
* `C` es la cantidad de camiones.

---

# Algoritmo Backtracking

## Estrategia

Para cada paquete se consideran todas las alternativas posibles:

* Asignarlo a un camión válido.
* No asignarlo.

Se utiliza una poda para evitar explorar soluciones peores que la mejor encontrada:

```java
if (pesoPerdidoActual >= menorPesoPerdido)
    return;
```

## Ventajas

* Garantiza encontrar una solución óptima.

## Desventajas

* Mayor costo computacional.
* Genera una mayor cantidad de estados.

## Complejidad Temporal

Peor caso:

```text
O((C + 1)^P)
```

Donde:

* `P` es la cantidad de paquetes.
* `C` es la cantidad de camiones.

---

# Formato de los Archivos CSV

## Camiones.csv

Formato:

```text
cantidad
id;patente;refrigerado;capacidad
```

Ejemplo:

```text
3
100;AAA000A;1;100
101;AAA001B;0;500
102;AAA002C;1;115
```

---

## Paquetes.csv

Formato:

```text
cantidad
id;codigo;peso;alimentos;urgencia
```

Ejemplo:

```text
4
1;P001;30;1;80
2;P002;100;0;2
3;P003;80;0;10
4;P004;25;1;100
```

---

# Resultados Obtenidos

## Greedy

* Peso no asignado: 0 kg.
* Candidatos considerados: 9.

## Backtracking

* Peso no asignado: 0 kg.
* Candidatos considerados: 12.

---

# Conclusiones

Ambos algoritmos lograron asignar todos los paquetes disponibles, obteniendo un peso no asignado igual a 0 kg.

El algoritmo Greedy encontró rápidamente una solución válida considerando una menor cantidad de candidatos.

El algoritmo Backtracking exploró una mayor cantidad de estados, garantizando la optimalidad de la solución obtenida.

Esto permite comparar el compromiso existente entre eficiencia y optimalidad en la resolución del problema.
