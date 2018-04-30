# movies

Download the project and build it using "clean install" and run it as a Spring Boot Application.
You can test it from Postman using following:

GET - http://localhost:8080/v1/movies
POST - http://localhost:8080/v1/movies
  {
        "id": 2,
        "title": "movie2",
        "year": 2018
    }
PUT - http://localhost:8080/v1/movies/{movieId}
  {
        "id": 2,
        "title": "movie2",
        "year": 2017
    }
DELETE - http://localhost:8080/v1/movies/{movieId}

Running the test case:
Right click MoviesApplicationTests.java file and Run As JUnit Test.
