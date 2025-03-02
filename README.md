# Spring Simple Recipe Filtering App 

### Overview
This Simple Recipe service exposes 2 API endpoints, `/recipes` and `/recipes/difficulty` which displays a list of food items, and may filter it by difficulty.


### Prerequisites
1. Java 21 SDK 
2. IDE (IntelliJ, NetBeans, VSC, etc.)

### Components
1. **Controller** - Handles API logic
2. **Service** - Handles business logic
   3. `DataLoaderService` - Added to mock database (with the help of **H2** DB). Initializes schema using **liquibase** dependency and populates database using a static **JSON** file
3. **Data** - Defines the models
3. **Repository** - Handles database logic

### Application Set-up
1. Run `mvn clean install` to install the dependencies
2. Either run the app in `RecipeappApplication.java` using your IDE's embedded Run features OR run the following command in the root path of your project:
```bash
java -jar target/recipeapp-0.0.1-SNAPSHOT.jar
```

### API Endpoints
#### Get All Recipes
- **URL**: `/api/recipes`
- **Method**: `GET`
- **Description**: Retrieves a list of all recipes.
- **Response**:
  - **Status**: `200 OK`
  - **Body**: JSON array of recipes.

#### Get Recipes by Difficulty
- **URL**: `/api/recipes/filter?={difficulty}`
- **Method**: `GET`
- **Description**: Retrieves recipes filtered by difficulty.
- **Parameters**:
  - `difficulty` (path): The difficulty level of the recipes (e.g., EASY, MEDIUM, HARD).
- **Response**:
  - **Status**: `200 OK`
  - **Body**: JSON array of recipes with the specified difficulty.
- **Error Response**
  - **Status**: `500`
  - **Body**: Error message "A difficulty is required for filtering trending recipes"


