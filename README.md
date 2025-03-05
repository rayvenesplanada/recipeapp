# Spring Simple Recipe Filtering App 

### Overview
This Simple Recipe service exposes 2 API endpoints, `/recipes` and `/recipes/filter` which displays a list of food items, and may filter it by difficulty.


### Prerequisites
1. Java 21 SDK 
2. IDE (IntelliJ, NetBeans, VSC, etc.)
3. Maven

### Components
1. **Database** - Used **H2** to create a lightweight in-memory database storing sample data for the app. 
2. **Controller** - Handles API logic
3. **Service** - Handles business logic
   - `DataLoaderService` - Added to mock database (with the help of **H2** DB). Initializes schema using **liquibase** dependency and populates database using a static **JSON** file
4. **Data** - Defines the models
5. **Repository** - Handles database logic
6. **Exception** - Handles exception logic. Returns error message to the client instead of generic Internal Server Error message for 5XX errors

### Application Set-up
1. Clone repository to your working environment. Right now there is only a `master` branch that's in the remote repository.
2. Run `mvn clean install` to install the dependencies.
3. Either run the app in `RecipeappApplication.java` using your IDE's embedded Run features OR run the following command in the root path of your project:
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
  - `difficulty` (Request Param): The difficulty level of the recipes (e.g., EASY, MEDIUM, HARD).
- **Response**:
  - **Status**: `200 OK`
  - **Body**: JSON array of recipes with the specified difficulty.
- **Error Response**
  - **Status**: `500`
  - **Body**: Error message "A difficulty is required for filtering trending recipes"


