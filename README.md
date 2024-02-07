
# Password Security Meter

This API project is crafted to analyze the security of input passwords, providing users with a comprehensive assessment and displaying the results.

#### Frontend
[![Frontend](https://wakatime.com/badge/user/018ccb12-9467-4e68-9840-5044c971aca3/project/018d1781-3c17-4a90-a8fe-18acf9cb33f6.svg)](https://wakatime.com/badge/user/018ccb12-9467-4e68-9840-5044c971aca3/project/018d1781-3c17-4a90-a8fe-18acf9cb33f6)

##### Backend
[![Backend](https://wakatime.com/badge/user/018ccb12-9467-4e68-9840-5044c971aca3/project/018d781d-8c55-4018-a163-6d5b5052ff26.svg)](https://wakatime.com/badge/user/018ccb12-9467-4e68-9840-5044c971aca3/project/018d781d-8c55-4018-a163-6d5b5052ff26)

## Reference

 - [Password Metter](https://passwordmeter.com/)


## Stack used

**Front-end:** HTML, CSS, Javascript, JQuery; <br>
**Back-end:** Java, Spring; <br>
**Database:** MariaDB;

## Shields

[![Java](https://img.shields.io/badge/Java-17-red)](https://docs.oracle.com/en/java/)
[![Spring](https://img.shields.io/badge/Spring-3.2.2-orange)](https://docs.spring.io/spring-framework/reference/index.html)
[![JQuery](https://img.shields.io/badge/jQuery-3.6.4-yellow)](https://api.jquery.com/)
[![MariaDb](https://img.shields.io/badge/MariaDB-15.1-white)](https://mariadb.com/docs/)

## API Documentation

#### Get all items

```http
    GET /
```

#### Get information about a specific item

```http
    GET /${id}
```

#### Add a new item

```http
    POST /
```

Send JSON in the request body with the following format:

```json
    {
        "name": "YourName",
        "password": "YourSafePassword123!"
    }
```


## Extra

All of these methods can be tested using the application's front-end.

## Demonstration

### Postman

#### Get All
![Postman-1](https://github.com/Ismael-Moreira-Kt/Password-Security-Meter/assets/154206380/8e644f24-78a0-46ee-b21e-b833ddef1fb3)

#### Get by Id
![Postman-2](https://github.com/Ismael-Moreira-Kt/Password-Security-Meter/assets/154206380/d09646d5-f661-41b0-a3a0-3614d99345f2)

#### Post
![Postman-3](https://github.com/Ismael-Moreira-Kt/Password-Security-Meter/assets/154206380/104626db-63c6-4838-9964-89c9c1745bfb)


#### Front-End
<table>
    <tr>
        <td>Print</td>
        <td>Postman</td>
    </tr>
    <tr>
        <td><img src="https://github.com/Ismael-Moreira-Kt/Password-Security-Meter/assets/154206380/b82fab2a-9d92-463e-a320-5ecec83db9e6" alt="Front-End-Image"></td>
        <td><img src="https://github.com/Ismael-Moreira-Kt/Password-Security-Meter/assets/154206380/728a69c1-2163-4e3c-abea-5db8ff85cacc" alt="Postman-Print"></td>
    </tr>
        <tr>
        <td><img src="https://github.com/Ismael-Moreira-Kt/Password-Security-Meter/assets/154206380/e202fa28-d953-432c-9d2e-780ed04d4eaa" alt="Front-End-Image"></td>
        <td>----</td>
    </tr>
</table>


## Authors

- [@Ismael-Moreira-Kt](https://github.com/Ismael-Moreira-Kt)
