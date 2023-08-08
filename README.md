# Flight planner
Vienkāršs lidojumu REST API plānotājs būvēts ar Gradle Java Spring Boot kā backend. Atbalsta CR~~U~~D darbības ar lidostām un lidojumiem starp tām. Datu glabāšanai ir 2 opcijas: `in-memory` un `database` (kas tiek veikts ar PostgreSQL servera palīdzību).

## API lietošana

### Uzstādīšana
Lai programmatūru būtu iespējams palaist, jāveic sekojošās darbības:

0. Pārliecinies, ka [Docker](https://docs.docker.com/get-docker/) ir ieinstalēts (lai spētu lietot datubāzes opciju)
1. Lejupielādē repo
```sh
git clone https://github.com/students-gi/flight-planner.git
cd flight-planner
```
2. Palaid datubāzes Docker konteineri
```sh
docker build -t flightplanner-postgres .
docker run -d -p 5432:5432 --name flightplanner-db flightplanner-postgres
```
3. Startē Spring aplikāciju

### Atbrīvošanās
1. Apturi un izdzēs Docker konteineri
```sh
docker stop flightplanner-db
docker rm flightplanner-db
```
2. Izdzēs projekta mapi
```sh
cd ..
rm -r flight-planner
```

### Piekļuves punkti
API ir 7 piekļuves punkti ar 3 dažādiem lietotājiem:
- **Admin**, kam ir tiesības pievienot un dzēst lidojumus
  - **[PUT]** /admin-api/flights
  - **[DELETE]** /admin-api/flights/{flightId}
- **Test**, kam ir tiesības iztīrīt datubāzi
  - **[POST]** /testing-api/clear
- **Customer**, kas spēj meklēt lidojumus un lidostas, un iegūt info par lidojumiem
  - **[GET]** /api/airports
  - **[GET]** /api/flights/
  - **[POST]** /api/flights/search
  - **[GET]** /api/flights/{flightId}

**Admin** ir vienīgais lietotājs kam nepieciešami piekļuves dati lai veiktu savas darbības. Tos var aplūkot (un pēc ieskatiem mainīt) [lietotnes config failā](/src/main/resources/application.properties). Konkrēti mainīgo, `spring.security.user.name` un `spring.security.user.password` vērtības.

---
## Lietotnes konfigurācija

### Datu glabāšanas sistēmas maiņa

[Lietotnes config failā](/src/main/resources/application.properties) ir mainīgais ``flightplanner.repository.version``. Tas pieņem 2 vērtības: `in-memory` un `database`.