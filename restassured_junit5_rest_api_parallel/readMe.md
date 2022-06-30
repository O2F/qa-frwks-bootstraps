# RestAssured - JUnit5 - Rest API - Parallel

## Type:

- **Basic Framework:** JUnit 5
- **Secondary Framework:** RestAssured
- **Type of config file:** yaml file
- **Test Parallelization:** Yes
- **CI/CD:** YEs
- **Reporting:** Allure Reports


## How to run

The default environment set is `qa` if more yaml with configurations are added use the following command.

```sh
mvn clean test -Denv=<environment> allure:report
```

The following parameters that can also be provided are (and must if not in the properties file):

`-DbaseUrl`     :: Base Url of the application under test

`-Dport`        :: The port of the application

If you don't have properties/yaml configuration files or want to overwrite the values in it:

```sh
mvn clean test -Denv=<qa|preprod> -DbaseUrl=<base_url> -Dport=<port> allure:report
```
