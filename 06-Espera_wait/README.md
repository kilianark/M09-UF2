# Preguntes teòriques

## Per què s'atura l'execució al cap d'un temps? 

L'execució s'atura perquè, tot i que els fils estan en execució contínua, el sistema de gestió de processos de Java pot arribar a un estat on no hi ha activitat nova. Això passa si tots els assistents estan bloquejats en wait() esperant una plaça disponible que mai no s'allibera. Si no hi ha cap notifyAll(), el programa pot quedar en un estat d'espera indefinit, depenent de la distribució aleatòria de les accions.

## Què passaria si en lloc de una probabilitat de 50%-50% fora de 70% (ferReserva)-30% (cancel·lar)? I si foren al revés les probabilitats? → Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos

### Cas 1: 70% ferReserva - 30% cancelar
Amb aquesta probabilitat, la llista de reserves s'omple ràpidament i la majoria dels assistents es queden en espera perquè no es cancel·len prou reserves.

Codi modificat:
    ```
        if (random.nextInt(100) < 70) esdeveniment.ferReserva(this);  
        else esdeveniment.cancelaReserva(this);
    ```

Sortida resultant:
    ```
        Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
        Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
        Assistent-6 ha fet una reserva. Places disponibles: 4
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-4 ha fet una reserva. Places disponibles: 3
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-1 ha fet una reserva. Places disponibles: 2
        Assistent-2 ha fet una reserva. Places disponibles: 1
        Assistent-0 ha fet una reserva. Places disponibles: 0
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-9 ha fet una reserva. Places disponibles: 0
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    ```

### Cas 2: 30% ferReserva - 70% cancelar
Codi modificat:
    ```
        if (random.nextInt(100) < 30) esdeveniment.ferReserva(this);  
        else esdeveniment.cancelaReserva(this);
    ```
Sortida resultant:
    ```
        Assistent-0 ha fet una reserva. Places disponibles: 4
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-7 ha fet una reserva. Places disponibles: 3
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-2 ha fet una reserva. Places disponibles: 2
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-7 ha fet una reserva. Places disponibles: 1
        Assistent-5 ha fet una reserva. Places disponibles: 0
        Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-7 ha fet una reserva. Places disponibles: 0
        Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-9 ha fet una reserva. Places disponibles: 0
        Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-1 ha fet una reserva. Places disponibles: 0
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-9 ha cancel·lat una reserva. Places disponibles: 2
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-2 ha fet una reserva. Places disponibles: 1
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-7 ha cancel·lat una reserva. Places disponibles: 2
        Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-1 ha cancel·lat una reserva. Places disponibles: 3
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-3 ha fet una reserva. Places disponibles: 2
        Assistent-3 ha cancel·lat una reserva. Places disponibles: 3
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-2 ha fet una reserva. Places disponibles: 2
        Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-5 ha fet una reserva. Places disponibles: 1
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-7 ha fet una reserva. Places disponibles: 0
        Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-0 ha fet una reserva. Places disponibles: 0
        Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-5 ha fet una reserva. Places disponibles: 0
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-2 ha cancel·lat una reserva. Places disponibles: 2
        Assistent-6 ha fet una reserva. Places disponibles: 1
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-5 ha cancel·lat una reserva. Places disponibles: 2
        Assistent-0 ha cancel·lat una reserva. Places disponibles: 3
        Assistent-6 ha cancel·lat una reserva. Places disponibles: 4
        Assistent-7 ha fet una reserva. Places disponibles: 3
        Assistent-1 ha fet una reserva. Places disponibles: 2
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-9 ha fet una reserva. Places disponibles: 1
        Assistent-9 ha cancel·lat una reserva. Places disponibles: 2
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
        Assistent-0 ha fet una reserva. Places disponibles: 1
        Assistent-2 ha fet una reserva. Places disponibles: 0
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-4 ha fet una reserva. Places disponibles: 0
        Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-4 ha cancel·lat una reserva. Places disponibles: 2
        Assistent-1 ha cancel·lat una reserva. Places disponibles: 3
        Assistent-2 ha cancel·lat una reserva. Places disponibles: 4
        Assistent-0 ha cancel·lat una reserva. Places disponibles: 5
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
        Assistent-4 ha fet una reserva. Places disponibles: 4
        Assistent-8 ha fet una reserva. Places disponibles: 3
        Assistent-8 ha cancel·lat una reserva. Places disponibles: 4
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-9 ha fet una reserva. Places disponibles: 3
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-9 ha cancel·lat una reserva. Places disponibles: 4
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-4 ha cancel·lat una reserva. Places disponibles: 5
        Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
        Assistent-0 ha fet una reserva. Places disponibles: 4
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
        Assistent-3 ha fet una reserva. Places disponibles: 3
        Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
        Assistent-2 ha fet una reserva. Places disponibles: 2
        Assistent-0 ha cancel·lat una reserva. Places disponibles: 3
        Assistent-0 ha fet una reserva. Places disponibles: 2
        Assistent-4 ha fet una reserva. Places disponibles: 1
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
        Assistent-3 ha cancel·lat una reserva. Places disponibles: 2
        Assistent-9 ha fet una reserva. Places disponibles: 1
        Assistent-5 ha fet una reserva. Places disponibles: 0
        Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-8 ha fet una reserva. Places disponibles: 0
        Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-7 ha fet una reserva. Places disponibles: 0
        Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-5 ha cancel·lat una reserva. Places disponibles: 2
        Assistent-4 ha fet una reserva. Places disponibles: 1
        Assistent-3 ha fet una reserva. Places disponibles: 0
        Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-1 ha fet una reserva. Places disponibles: 0
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-9 ha fet una reserva. Places disponibles: 0
        Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-6 ha fet una reserva. Places disponibles: 0
        Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
        Assistent-8 ha fet una reserva. Places disponibles: 0
        Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
        Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
    ```

## Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves? 
Una variable sencera que compti el nombre de reserves no permetria gestionar quins assistents han reservat i quins poden cancel·lar. Amb una llista podem:

- Identificar quins assistents tenen plaça.

- Evitar que un assistent cancel·li sense haver fet reserva prèviament.

- Implementar wait() i notifyAll() correctament, ja que podem gestionar les accions sobre elements concrets de la llista.

Si només féssim servir una variable sencera per comptar reserves, no podríem assegurar que un assistent que intenta cancel·lar una reserva hagi fet realment una reserva abans.