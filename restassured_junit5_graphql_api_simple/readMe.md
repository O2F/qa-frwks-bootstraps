# RestAssured - JUnit5 - GraphQL API - Simple

## Type:

- **Basic Framework:** JUnit 5
- **Secondary Framework:** RestAssured
- **Type of config file:** yaml file
- **Test Parallelization:** No
- **CI/CD:** Yes
- **Reporting:** Allure Reports

## Notes

- Since there seems to be a problem with one API when the test suites are run in parallel, the parallelization has been turned off but it is possible to run automations in parallel.
- For a TestNG project adapt the [testng rest api](../restassured_testng_rest_api_parallel) to graphql using what this one provides

## How to run

The default environment set is `qa` if more yaml with configurations are added use the following command.

```sh
mvn clean test -Denv=<env> allure:report
```

The following parameters that can also be provided are (and must if not in the properties file):

`-DbaseUrl`     :: Base Url of the application under test

If you don't have properties/yaml configuration files or want to overwrite the values in it:

```sh
mvn clean test -Denv=<qa|preprod> -DbaseUrl=<base_url> allure:report
```
