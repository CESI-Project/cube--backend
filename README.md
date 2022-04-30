# Cube Back-End

## Prerequisites

You need to have :
* Maven 3.x
* Java 17.x
* PostgreSQL 14.x

## How to install

Clone the git project

```shell
git clone git@github.com:SVT-Cube-Project/cube--backend.git
```

## PostgreSQL

Initial DB

```SQL
CREATE DATABASE cube;
GRANT ALL PRIVILEGES ON DATABASE "cube" TO postgres;
```

After running project 
```SQL
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_SUPERADMIN');
```

## How to run

### With Docker

First you need to build the project

```shell
maven clean install
```

And after launching docker-compose

```shell
docker-compose up
```

### With IntelliJ

Use the runner :

![runner](https://user-images.githubusercontent.com/56682141/157540985-2da33548-91ec-477d-a299-eba14fc673d8.png)

If `CubeApplication` isn't setup automatically, you can configure it like this

![configRunner](https://user-images.githubusercontent.com/56682141/157540860-eb1e5439-7cc2-4247-ab36-74cb3648bd53.png)

## How to test

## Contributing

Please see [CONTRIBUTING.md](./CONTRIBUTING.md)

## Maintainers

* theo.gadiffet@gmail.com
* valou.lacour59@gmail.com
* sebastienpostiaux@gmail.com