# Websockets y eventos desde servidor


## Objetivos

1. Conocer las diferentes técnicas para enviar comunicaciones desde servidor a cliente sin hacer polling
2. Implementación de ejemplo de Server send events
3. Implementación de ejempllo de websockets usando un broker en memoria
    
## Websockets

Dentro de los websockets el objetivo es simular el envio de notificaciones a los clientes de manera genérica y a unos clientes en concreto.

## Probar Server end events
    1. Hacer run del proyecto ya sea con gradlew o con IntelliJ
    2. Hacer una petición GET a: http://localhost:8080/serverSendEvents
    3. Esperar y ver como llegan las notificaciones

## Probar Websockets

    1. Hacer run del proyecto ya sea con gradlew o con IntelliJ
    2. Hacer una petición GET a: http://localhost:8080/e0a4c76d-4ce7-4071-bd77-d9292ca966d2
    3. Abrir otra pestaña del navegador con la misma URL anterior
    4. Abrrir otra pestaña del navegador con la misma URL pero modificando el GUUID
    5. Comprobar que las dos primeras pestañas reciben los dos tipos de notificaciones (general y particular) mientras que la tercera pestaña solo recibe la generales
 
 
## Próximos pasos

1. Explorar como securizar 
2. Como montar un broker fuera de memoria para poder escalar:
    https://stackoverflow.com/questions/26853745/spring-websocket-in-a-tomcat-cluster

