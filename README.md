# SpringBank

Esse projeto é uma API Restful construída usando Java, Java Spring e MySQL como Banco de dados.

# Endpoints

Esses endpoints permitem você criar usuários, listar os usuários e enviar dinheiro para outros usuários.

## GET
`BASE URL` [/users](#get-users)<br/>

## POST
`BASE URL` [/users/create](#post-userscreate)<br/>
`BASE URL` [/transactions/create](#)<br/>
___

### GET /users
Retorna a lista de usuários cadastrados no sistema.                                                                |

**Resposta**

```
[
	{
		"id": 1,
		"firstName": "Raphael",
		"lastName": "Alexei",
		"document": "43200000000",
		"email": "exemplo@gmail.com",
		"password": "exemplo",
		"balance": 100.00
	},
	{
		"id": 2,
		"firstName": "Pedro",
		"lastName": "Santos",
		"document": "12300000000",
		"email": "exemplo2@gmail.com",
		"password": "exemplo2",
		"balance": 1200.00
	}
]
```

### POST /users/create
Cria um novo usuário no sistema.

**Parameters**

|          Name | Required |  Type   | Description                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `firstName` | Obrigatório | Texto  | Primeiro nome do cliente                                                                     |
|        `lastName` | Obrigatório | Texto  | Segundo nome do cliente |
| `document` | Obrigatório | Inteiro | Documento do cliente |
|       `email` | Obrigatório | Texto  | Email do cliente |
|    `balance` | Obrigatório | Inteiro  | Dinheiro em conta do cliente  |
|    `password` | Obrigatório | Texto  | Senha do cliente |

**Resposta**

```
{
	"id": 1,
	"firstName": "Raphael",
	"lastName": "Alexei",
	"document": "12300000000",
	"email": "exemplo@gmail.com",
	"password": "exemplo",
	"balance": 1000.0
}
```

### POST /transactions/create
Cria uma nova transação entre dois usuários no sistema.

**Parameters**

|          Name | Required |  Type   | Description                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `sender` | obrigatório | Texto  | Email do cliente que irá enviar                                                                    |
|        `receiver` | Obrigatório | Texto  | Email do cliente que irá receber |
| `amount` | Obrigatório | Inteiro | Montante que será movimentado ao recebedor. |

**Resposta**

```
{
	"id": 16,
	"amount": 10,
	"sender": {
		"id": 1,
		"firstName": "Raphael",
		"lastName": "Alexei",
		"document": "43200000000",
		"email": "exemplo@gmail.com",
		"password": "exemplo",
		"balance": 10.00
	},
	"receiver": {
		"id": 2,
		"firstName": "Pedro",
		"lastName": "Santos",
		"document": "12300000000",
		"email": "exemplo2@gmail.com",
		"password": "exemplo2",
		"balance": 1990.00
	},
	"timestamp": "2023-09-10T18:23:19.7214729"
}
```

## Tecnologias Utilizadas

- [MySQL]([https://redis.io/](https://www.mysql.com)) - Banco de dados SQL para armazenar os usuários
- [Spring](https://spring.io) - Ambiente de execução da API Restful
  - [Bull](https://github.com/OptimalBits/bull) - Biblioteca para manipulação de filas de mensagens utilizando Redis
  - [AWS SDK for JavaScript](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/SES.html#constructor-property) - SDK da AWS para envio de e-mails utilizando o serviço Simple Email Service (SES)

