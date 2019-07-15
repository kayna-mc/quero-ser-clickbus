The application was coded with Java and Springboot

You can test the application on heroku: https://clickbus-test.herokuapp.com

To run the application from source code, run the "TestApllication.java" file.

The endpoints of the API:
- to insert a record (POST): "/places"
- to edit a record (PUT): "/places/id" - where "id" is the number generated when the record was created
- to delete a record (DELETE): "/places/id" - where "id" is the number generated when the record was created
- to get a specif record (GET): "/places/id" - where "id" is the number generated when the record was created
- to get records by name (GET): "/placesByName/name" - the "name" can be partial for the search
- to get all records (GET): "/places"
