# Konfiguracja
## Front
`orchestrator` - host, port 8081,
`calculator` - remote, port 8082,
`collector` - remote, port 8083.

uruchomienie npm run start:all w katalogu \frontend\angular-mf-poc
## Backend
`calculator` - 8092
`collector` - 8093
`decision` - 8094
`orchestrator` - 8091
## Kafka 
`Docker` - 9092
uruchomienie kafki to wykonanie
docker compose up -d 
w katalogu z plikiem docker-compose.yml
wymagane jest wcześniejsze ściągnięcie image i dockerDesktop 
zatrzymanie docker ps 
a potem docker stop nazwa/id

//TODO: przejść na uruchamianie z projektu 