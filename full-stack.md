# Green Fox Takeout :ramen:

We are going to create our very own online restaurant where guests can customize
their orders based on their preferences. :stew:

**Please read the whole description in order to understand the application.**

## Database

Feel free to use the provided SQL file:

- [for MySQL](assets/fullstack-takeout.sql)
- [for SQLite](assets/fullstack-takeout-sqlite.sql)

## `GET /`

- The main page should be rendered

- It should contain a form that has:

  - Two input fields with labels
  - One radio button-type selector
  - One drop-down menu

  ![form](assets/form.png)

- The base options should be `rice noodles` `egg noodles` and `white rice`

- The topping options should be `chicken` `beef` and `smoked tofu`

- The customer can choose only one of each

- The form should be submitted to `POST /api/orders`

- After submission based on the response display the order id below the form and
  clear the input fields

## `POST /api/orders`

- After saving the order in the database respond with the stored order in the
  following JSON format

  ```json
    {
      "id": 2,
      "name": "István Kárász",
      "address": "Andrassy street 66",
      "base": "white rice",
      "topping": "smoked tofu",
      "status": "ordered"
    }
  ```

## `GET /api/orders/{orderId}`

- It should respond with the stored entry in the following JSON format

   ```json
    {
      "id": 2,
      "name": "István Kárász",
      "address": "Andrassy street 66",
      "base": "white rice",
      "topping": "smoked tofu",
      "status": "ordered"
    }
  ```

- In case the order ID does not exist, the application should respond with 404
  status code

## `GET /api/orders?status=[string]`

- Valid `status` values are

  - `ordered`
  - `inprogress`
  - `done`

- This endpoint should respond in JSON format with those
  orders only that are still in progress

  ```json
  [
    {
      "id": 2,
      "name": "István Kárász",
      "address": "Andrassy street 66",
      "base": "white rice",
      "topping": "smoked tofu",
      "status": "inprogress"
    },
    {
      "id": 5,
      "name": "Tamás Kökény",
      "address": "Andrassy street 666",
      "base": "egg noodles",
      "topping": "smoked tofu",
      "status": "inprogress"
    }
  ]
  ```

- The `status` query string in the URL is required. The endpoint should return with `422` status
  code in case the status is not valid

- For example, if no `ordered` status was found then the `/api/orders?status=ordered` should return with empty list:

```json
  []
```

## `PATCH /api/orders/{orderId}`

- The order status should be in the request's body in JSON format, this is how
  we will be able to modify its progress

  ```json
  {
    "status": "inprogress"
  }
  ```

- If there is no order with the specified id then it should return with `404`
- If the status is not valid it should respond with `422` status code

- Valid status values are

  - `ordered`
  - `inprogress`
  - `done`

## Question

You are working with following SQL table of 10 outstanding videogames:

| id | name                     | genre      | releaseDate | developer              | engine            | price | rating |
|---:|:-------------------------|:-----------|------------:|:-----------------------|:------------------|------:|-------:|
|  1 | The Witcher 3: Wild Hunt | RPG        |  2015-05-19 | CD Projekt Red         | REDengine 3       |  1499 |    9.2 |
|  2 | Half-Life 2              | FPS        |  2004-11-16 | Valve                  | Source            |   299 |    8.7 |
|  3 | The Sims                 | Simulation |  2000-01-31 | Maxis                  | Custom            |   199 |      9 |
|  4 | BioShock                 | FPS        |  2007-08-21 | 2K                     | Unreal Engine 2.5 |   350 |    9.1 |
|  5 | BioShock: Infinite       | FPS        |  2013-03-26 | Irrational Games       | Unreal Engine 3   |   699 |    8.4 |
|  6 | Quake                    | FPS        |  1996-07-22 | id Software            | Quake engine      |   299 |    8.6 |
|  7 | Diablo                   | RPG        |  1996-12-31 | Blizzard North         | DEngine           |   299 |    8.9 |
|  8 | World of Warcraft        | MMORPG     |  2004-11-23 | Blizzard Entertainment | Custom            |   499 |    8.8 |
|  9 | Grand Theft Auto V       | Advenure   |  2013-09-17 | Rockstar North         | RAGE              |   899 |    8.8 |
| 10 | Undertake                | Roleplay   |  2015-09-15 | Toby Fox               | GameMaker Studio  |   399 |    9.1 |

`1.` Write SQL query to create the table

```mysql

```

`2.` Write SQL query to insert one row of data

```mysql

```


`3.` Write SQL query that will return top 2 rated FPS game's
titles and developers

```mysql

```


`4.` Write SQL query that will make every game released in 20th century
go on sale (reduce its price by 200)

```mysql

```
