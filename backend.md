# Tinder clone

You will create a web page where you can register your profile and swipe random
profiles (one at a time).

## Highlights

### It has two frontend pages which can:

  - list all users and a form to register a new user
  - show profile page of a user

### It has a backend which can:

  - list all users
  - save user
  - save a swipe
  - update swipe

## Database

There are two tables, one is "user" and another is "swipe".
In this application, swipe will store the information about the user that
created the swipe and the user that he swiped for. In addition to that,
it will store the direction of the swipe. User table doesn't store
the information about swipes.

- User:
  - id, username, age, gender, description

- Swipe:
  - id, current_user_id, other_user_id, direction

## Endpoints

Create the following endpoints:


### GET `/`

The main page is rendered:

- title/heading: Tinder clone
- all known users are listed in a table containing these data: username, age,
description, gender
- a form is displayed to add a new user
  - form has to contain a field for: username, select for the gender, age and
    description (text area)

- the form should be sent to the POST `/register` endpoint



### POST `/register`

A new user is saved:

- validate the user input, every field is *required*
  - should check if the username is already taken
  - if taken, render the main page with an error message above the form
- if the username is not taken: save the new user to the database (if all
fields are provided and befit the database constraints)

- redirect to the main page

### GET `/profile/{id}`

- Path variable `{id}` refers to the user that is swiping (`current` user)
- The new page is rendered with the users details:

  - a title/heading with the name of the first user (or random user) from database
  (can't be the same user as the one that is swiping)
  - a smaller heading with the age and the gender
  - a paragraph with the description of the user
  - a form for swiping containing:

    - hidden input for the `current` user's id, and another the
    hidden input for the random `other` user's id
    - a direction preferably using radio buttons, but a select is good as well
    - the form should be sent to the POST `/swipe` endpoint


### POST `/swipe`

A new swipe is saved:

  - containing the current user's id, the other user's id and the swipe
    direction
  - if there is a swipe present with the given ids: overwrite it
  - otherwise, create a new one
  - should redirect back to the `/profile/{id}` endpoint with the current user's
  id as path variable


### PUT `/swipe`

- The new swipe data should be in the request's body in JSON format, this is how
  we will be able to modify it:

  ```json
  {
    "currentUserId": 2,
    "otherUserId": 7,
    "direction" : "left"
  }
  ```

- if there is no swipe data stored with the given id-s: it should return with
`404`
- if the direction is not valid it should respond with `422` status code
- otherwise, if all data are valid, update the swipe data and respond with
`202` status code
- Valid directions values are
  - `left`
  - `right`

## Question

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
