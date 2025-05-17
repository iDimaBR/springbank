# SpringBank

This project is a RESTful API built using Java, Spring Framework, and MySQL as the database.

*This project is based on the PicPay Challenge.*

# Endpoints

These endpoints allow you to create users, list users, and send money to other users.

## GET  
`BASE URL`/users

## POST  
`BASE URL`/users/create  
`BASE URL`/transactions/create  
___

### GET /users  
Returns the list of users registered in the system.

**Response**

```
[
  {
    "id": 1,
    "firstName": "Raphael",
    "lastName": "Alexei",
    "document": "43200000000",
    "email": "example@gmail.com",
    "password": "example",
    "balance": 100.00
  },
  {
    "id": 2,
    "firstName": "Pedro",
    "lastName": "Santos",
    "document": "12300000000",
    "email": "example2@gmail.com",
    "password": "example2",
    "balance": 1200.00
  }
]
```

### POST /users/create  
Creates a new user in the system.

**Parameters**

| Name       | Required | Type   | Description                    |
|------------|:--------:|:------:|-------------------------------|
| firstName  | Yes      | String | User's first name             |
| lastName   | Yes      | String | User's last name              |
| document   | Yes      | String | User's document number        |
| email      | Yes      | String | User's email address          |
| balance    | Yes      | Float  | Initial balance               |
| password   | Yes      | String | User's password               |

**Response**

```
{
  "id": 1,
  "firstName": "Raphael",
  "lastName": "Alexei",
  "document": "12300000000",
  "email": "example@gmail.com",
  "password": "example",
  "balance": 1000.0
}
```

### POST /transactions/create  
Creates a new transaction between two users in the system.

**Parameters**

| Name      | Required | Type   | Description                          |
|-----------|:--------:|:------:|------------------------------------|
| sender    | Yes      | String | Email of the user sending money    |
| receiver  | Yes      | String | Email of the user receiving money  |
| amount    | Yes      | Float  | Amount to be transferred            |

**Response**

```
{
  "id": 16,
  "amount": 10,
  "sender": {
    "id": 1,
    "firstName": "Raphael",
    "lastName": "Alexei",
    "document": "43200000000",
    "email": "example@gmail.com",
    "password": "example",
    "balance": 10.00
  },
  "receiver": {
    "id": 2,
    "firstName": "Pedro",
    "lastName": "Santos",
    "document": "12300000000",
    "email": "example2@gmail.com",
    "password": "example2",
    "balance": 1990.00
  },
  "timestamp": "2023-09-10T18:23:19.7214729"
}
```

## Technologies Used

- [MySQL](https://www.mysql.com) - SQL database for storing users  
- [Spring](https://spring.io) - Framework for building the RESTful API
