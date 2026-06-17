## Resumen de cosas que faltan checkear :)
#### CVSreader.java:
El CSVreader funciona (lo saqué de un tutorial de youtube)

#### Servicios.java:
    Se puede usar TreeMap, ahí nos ahorramos de hacer el BTS y la clase nodotree
    Ver el tema de la complejidad de los 3 servicios

#### Greedy.java: 
    Hay que explicar la estrategia
    Linea 17: ver si ese break se puede poner.
        Cuando lo pongo los candidatos son 9 
        Cuando lo saco los candidatos son 12

#### Backtracking.java:
    Hay que explicar la estrategia
    Línea 11,12,13:
        Ver si estos atributos van adentro de public Backtracking, o los valores se ponen directamente en los private.
            mejorSolucion = null;
            menorPesoPerdido = Double.MAX_VALUE;
            cantidad = 0;
    Línea 15:
        Si hago paquetes.sort() de mayor a menor, el resultado da:

            SOLUCIÓN BACKTRACKING

            =====================================
            ID Camión: 101 | Patente: AAA001B | Capacidad: 500.0 kg | Refrigerado:false
            Paquetes asignados:
            - Código: P003 | Peso: 80.0 kg | Urgencia: 10 | Alimentos: false

            =====================================
            ID Camión: 100 | Patente: AAA000A | Capacidad: 100.0 kg | Refrigerado:true
            Paquetes asignados:
            - Código: P002 | Peso: 100.0 kg | Urgencia: 2 | Alimentos: false

            =====================================
            ID Camión: 102 | Patente: AAA002C | Capacidad: 115.0 kg | Refrigerado:true
            Paquetes asignados:
            - Código: P001 | Peso: 30.0 kg | Urgencia: 80 | Alimentos: true
            - Código: P004 | Peso: 25.0 kg | Urgencia: 100 | Alimentos: true

            =====================================
            Peso no asignado: 0.0 kg
            Candidatos considerados: 12

    Si no ordeno los paquetes el resultado da:

        SOLUCIÓN BACKTRACKING

            =====================================
            ID Camión: 100 | Patente: AAA000A | Capacidad: 100.0 kg | Refrigerado:true
            Paquetes asignados:
            - Código: P001 | Peso: 30.0 kg | Urgencia: 80 | Alimentos: true
            - Código: P004 | Peso: 25.0 kg | Urgencia: 100 | Alimentos: true

            =====================================
            ID Camión: 101 | Patente: AAA001B | Capacidad: 500.0 kg | Refrigerado:false
            Paquetes asignados:
            - Código: P002 | Peso: 100.0 kg | Urgencia: 2 | Alimentos: false
            - Código: P003 | Peso: 80.0 kg | Urgencia: 10 | Alimentos: false

            =====================================
            Peso no asignado: 0.0 kg
            Candidatos considerados: 13
## si hago el nuevo codigo mio  de greedy da 
ID Camión: 100
Patente: AAA000A
Capacidad: 100.0 kg
Refrigerado: true
Paquetes asignados:

- Código paquete: P001
- Peso: 30.0 kg
- Urgencia: 80
- Alimentos: true

- Código paquete: P004
- Peso: 25.0 kg
- Urgencia: 100
- Alimentos: true

____________________________________________________________
ID Camión: 101
Patente: AAA001B
Capacidad: 500.0 kg
Refrigerado: false
Paquetes asignados:

- Código paquete: P003
- Peso: 80.0 kg
- Urgencia: 10
- Alimentos: false

____________________________________________________________
ID Camión: 102
Patente: AAA002C
Capacidad: 115.0 kg
Refrigerado: true
Paquetes asignados:

- Código paquete: P002
- Peso: 100.0 kg
- Urgencia: 2
- Alimentos: false

____________________________________________________________
Peso no asignado: 0.0 kg

Candidatos considerados: 12

----------------------------------------------------------
## en el viejo 
ID Camión: 102
Patente: AAA002C
Capacidad: 115.0 kg
Refrigerado: true
Paquetes asignados:

- Código paquete: P001
- Peso: 30.0 kg
- Urgencia: 80
- Alimentos: true

- Código paquete: P004
- Peso: 25.0 kg
- Urgencia: 100
- Alimentos: true

____________________________________________________________
ID Camión: 101
Patente: AAA001B
Capacidad: 500.0 kg
Refrigerado: false
Paquetes asignados:

- Código paquete: P003
- Peso: 80.0 kg
- Urgencia: 10
- Alimentos: false

____________________________________________________________
ID Camión: 100
Patente: AAA000A
Capacidad: 100.0 kg
Refrigerado: true
Paquetes asignados:

- Código paquete: P002
- Peso: 100.0 kg
- Urgencia: 2
- Alimentos: false

____________________________________________________________
Peso no asignado: 0.0 kg

Candidatos considerados: 9


