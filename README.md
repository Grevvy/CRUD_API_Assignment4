# Animal CRUD API

The REST API performs CRUD operations on Animal objects as described below.

## Installation
- Get the project
    - clone

      `git clone https://github.com/your-repo/animal-crud-api.git`
    - download zip.
- Open the project in IntelliJ or your preferred IDE.
- The `/src/main/resources/application.properties` file is the configuration for the MySQL database on your localhost.
    - The database name is set in the `datasource.url` property between the last `/` and the `?`. In this case, the database name is `animal`.
    - You MUST have the MySQL database running before running the project!
        - Open your XAMPP Control Panel.
        - Start the **Apache** server.
        - Start **MySQL**.
        - Click on **MySQL "Admin"** to open up phpMyAdmin.
        - Ensure the `animal` database is created and the `animal` table exists (you can use the SQL script provided earlier).
- Build and run the main class. You should see new data being stored in the `animal` database as you interact with the API.

## API Endpoints
Use **POSTMAN** to try the following endpoints:

## Get list of Animals

### Request

`GET /animal/all`

`http://localhost:8080/animal/all`

### Response

```json
[
    {"animalId": 1, "name": "Blue Jay", "species": "Bird", "habitat": "Forests", "description": "A vibrant blue bird found in North America."}, 
    {"animalId": 2, "name": "Great Blue Heron", "species": "Bird", "habitat": "Wetlands", "description": "A large wading bird found in North American wetlands."}
]
```

## Get a specific Animal

### Request
`GET /animal/{animalId}`

`http://localhost:8080/animal/1`

```json
{
    "animalId": 1, "name": "Blue Jay", "species": "Bird", "habitat": "Forests", "description": "A vibrant blue bird found in North America."
}
```

## Create a new Animal

### Request

`POST /animal/add`

`http://localhost:8080/animal/add`

```json
{
    "name": "Russian Blue Cat",
    "species": "Mammal",
    "habitat": "Domestic",
    "description": "A domestic cat breed known for its short blue-grey coat."
}
```

## Get Animals by Species

### Request

`GET /animal/species/{species}`

`http://localhost:8080/animal/species/Bird`

### Response

```json
[
    {"animalId": 1, "name": "Blue Jay", "species": "Bird", "habitat": "Forests", "description": "A vibrant blue bird found in North America."}, 
    {"animalId": 2, "name": "Great Blue Heron", "species": "Bird", "habitat": "Wetlands", "description": "A large wading bird found in North American wetlands."}
]
```

## Search Animals by Name (Partial Match)

### Request

`GET /animal/search?name=blue`

`http://localhost:8080/animal/search?name=blue`

### Response

```json
[
    {"animalId": 1, "name": "Blue Jay", "species": "Bird", "habitat": "Forests", "description": "A vibrant blue bird found in North America."}, 
    {"animalId": 3, "name": "Russian Blue Cat", "species": "Mammal", "habitat": "Domestic", "description": "A domestic cat breed known for its short blue-grey coat."}
]
```

## Update an existing Animal

### Request

`PUT /animal/update/{animalId}`

`http://localhost:8080/animal/update/1`

```json
{
    "name": "Updated Blue Jay",
    "species": "Bird",
    "habitat": "Updated Forests",
    "description": "Updated description."
}
```

## Delete an existing Animal

### Request

`DELETE /animal/delete/{animalId}`

`http://localhost:8080/animal/delete/1`