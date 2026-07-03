Technologies used:
- Java 26
- Spring Boot 4.1.0
- Spring Data JPA / Hibernate
- Microsoft SQL Server
- Maven

Database choice:
SQL server. Because the data we have is relational, playlists and songs many to many relation fit the classic foreign key relations

Prerequisites needed:
- Java 26 installed
- Microsoft SQL Server installed
- Maven installed

Setup in order to run:
1. Create the database
Open SQL Server Management Studio and run:
CREATE DATABASE playlist;
or right click on databases folder->new database named playlist

2. Configure the connection
Open `src/main/resources/application.properties` and update these lines to match your setup:
   spring.datasource.url=jdbc:sqlserver://localhost;instanceName=YOUR_INSTANCE_NAME;databaseName=playlist;encrypt=false;trustServerCertificate=true
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD

3.Run the application
```bash
./mvnw spring-boot:run
```
Or run `PlaylistApiApplication.java` directly from IntelliJ.

The tables will be created automatically on first run.

API Endpoints:

# Songs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/songs` | Create a song |
| GET | `/songs` | Get all songs |
| GET | `/songs/{id}` | Get song by id |
| PUT | `/songs/{id}` | Update a song |
| DELETE | `/songs/{id}` | Delete a song |

### Playlists
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/playlists` | Create a playlist |
| GET | `/playlists?userId={id}` | Get playlists by user |
| GET | `/playlists/{id}` | Get playlist by id |
| PUT | `/playlists/{id}` | Update a playlist |
| DELETE | `/playlists/{id}` | Delete a playlist |
| POST | `/playlists/{playlistId}/songs/{songId}` | Add song to playlist |

Testing:
Import the endpoints into Postman and test in this order:
1. Create a song via `POST /songs`
2. Create a playlist via `POST /playlists`
3. Add the song to the playlist via `POST /playlists/{playlistId}/songs/{songId}`
4. Fetch playlists via `GET /playlists?userId=1`

Database Schema:
See `documents/playlistERD.png` for the entity relationship diagram.