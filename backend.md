# Tinder clone

You will create a web page where you can register your profile and swipe random
profiles (one at a time).

## Highlights

### It has one frontend page which:

- can list all users
- has a form to register a new user

### It has multiple backend endpoint which can:

- list users to swipe `GET /api/users/{currentUserId}/swipe`
- create user `POST /api/users`
- handling swipe `POST /api/users/{currentUserId}/swipe`
- update swipe `PATCH /api/users/{currentUserId}/swipe`

## Database

There are two tables, one is "users" and another is "swipes".
In this application, swipe will store the information about the user that
created the swipe and the user that he swiped for. In addition to that,
it will store the direction of the swipe. Users table doesn't store
the information about swipes.

- users:
  - id, name, email, birth_date, gender, bio

- swipes:
  - id, current_user_id, other_user_id, direction

Example database for MySQL can be found here: [tinder_clone.sql](assets/tinder_clone.sql)

## Frontend

Create the following endpoints:

### GET `/`

The main page is rendered:

- has title/heading: Tinder clone
- all users are listed in a table containing these data: name, age, gender, bio
  - age should be calculated from the birth_date
- a form is displayed to add a new user
  - form has to contain a field for: name, email, select for the gender (`female`,`male`), birth_date (text) and
    bio (textarea)
- the form should be submitted to the POST `/register` endpoint

### POST `/register`

A new user is saved:

- validate the user input, every field is *required*
  - should check if the email is already taken
  - should check the gender, it can be only `female` or `male`
  - if taken, render the main page with an error message above the form
- if the email is not taken: save the new user to the database (if all
  fields are provided)
- redirect to the main page
  - in the case of error give an error message above the form: "Error happened :("

## Backend API endpoints

### Create user `POST /api/users`

- The new user data should be in the request's body in JSON format, this is how
  we will be able to create one:

  ```json
  {
    "name": "Mary",
    "email": "mary-hauser@pure.com",
    "birth_date": "2000-07-06",
    "gender": "female",
    "bio": "I'm a virgin, I'm not sure how I got here."
  }
  ```
- in the case of missing data it should respond with `400` status code
- if the email is already taken it should respond with `422` status code
- if the gender is not valid it should respond with `422` status code
  - Valid gender values are
    - `female`
    - `male`
- otherwise, if all data are valid, create a new user and respond with
  `201` status code
- Example JSON response:
  ```json
  {
    "id": 1,
    "name": "Mary",
    "email": "mary-hauser@pure.com",
    "birth_date": "2000-07-06",
    "gender": "female",
    "bio": "I'm a virgin, I'm not sure how I got here."
  }
  ```

### Swipe `POST /api/users/{currentUserId}/swipe`

- A new swipe is saved in database
- the path is containing the current user's id
- the request body containing other user's id and the swipe
  direction
  - Example JSON request:
    ```json
    {
      "otherUserId": 7,
      "direction" : "left"
    }
    ```
- in the case of missing data it should respond with `400` status code
- if previous swipe was found with the same currentUserId and otherUserId then respond with `422` status code
- if the direction is not valid it should respond with `422` status code
  - Valid directions values are
    - `left`
    - `right`
- otherwise, if all data are valid, create a new swipe and respond with
  `201` status code
- Example JSON response:
  ```json
  {
    "id": 1,
    "currentUserId": 1,
    "otherUserId": 7,
    "direction": "left"
  }
  ```

### Update swipe `PATCH /api/users/{currentUserId}/swipe`

- The new swipe data should be in the request's body in JSON format, this is how
  we will be able to modify it:

  ```json
  {
    "otherUserId": 7,
    "direction" : "left"
  }
  ```

- in the case of missing data it should respond with `400` status code
- if there is no swipe data stored with the given ids: it should return with
  `422`
- if the direction is not valid it should respond with `422` status code
  - Valid directions values are
    - `left`
    - `right`
- otherwise, if all data are valid, update the swipe data in database and respond with
  `200` status code and in the following JSON response format:
```json
{
  "id": 1,
  "currentUserId": 1,
  "otherUserId": 7,
  "direction": "left"
}
```

### List users to swipe `GET /api/users/{currentUserId}/swipe`

- the current user's id should be in the path variable
- the response should contain a list of users:
  - who was not swiped by the current user and
  - current user should not be in the results and
  - users should be from the opposite gender (males searching for females and vica-versa)
  - email should not be in the results because it's sensitive data
  - age should be calculated from the birth_date
- the response should be in JSON format with status code `200`
- Example JSON response:
  ```json
  [
    {
      "id": 2,
      "name": "John",
      "age": 25,
      "gender": "male",
      "bio": "I'm a smith, John Smith."
    }
  ]
  ```

## SQL

Given the following table named `applicants`.

| id | name               | country_id | age |
|:---|:-------------------|:-----------|:----|
| 1  | Bořivoj Souček     | 1          | 24  |
| 2  | Papp Patrícia      | 2          | 33  |
| 3  | Kocsis Ivett       | 2          | 37  |
| 4  | Slavomír Vykukal   | 1          | 20  |
| 5  | Bruno Malík        | 1          | 31  |
| 6  | Veronika Lukešová  | 1          | 18  |
| 7  | Székely Miklós     | 2          | 29  |
| 8  | Hegedüs Benjámin   | 2          | 37  |
| 9  | Nela Machová       | 1          | 20  |
| 10 | Balog Rajmund      | 2          | 39  |
| 11 | Major Borbála      | 2          | 35  |
| 12 | Evelína Horváthová | 1          | 23  |
| 13 | Vászoly Vivien     | 2          | 40  |
| 14 | Lada Stýskalová    | 1          | 27  |
| 15 | Dagmar Benešová    | 1          | 33  |

Given the following table named `countries`.

| id | country        |
|:---|:---------------|
| 1  | Czech Republic |
| 2  | Hungary        |


`1.` Write SQL query to insert a new applicant

  ```sql

  ```

`2.` Write SQL query that will return the youngest applicant's name

  ```sql

  ```

`3.` Write SQL query to update the `Czech Republic` country to `Czech Republic or Slovakia`

  ```sql

  ```

`4.` Write SQL query to select the name and the country of applicants from
Hungary with the age 40.

  ```sql

  ```

The expected result should be the following.

| name           | country |
|:---------------|:--------|
| Vászoly Vivien | Hungary |
