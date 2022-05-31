# Bootstrap JUnit5 - UI/E2E - Parallel + WDM

## Type:

- **Basic Framework:** JUnit 5
- **Secondary Framework:** ---
- **Browsers:** WebDriver Manager downloaded
- **Type of config file:** yaml file
- **Remote runner possibility:** No
- **Test Parallelization:** Yes
- **CI/CD:** No

## Notes

- Has the concept of **page components** that are used in **pages**
- Has a configuration model that then creates a configuration - **BaseTestConfig**
- This use YAML configuration instead of properties file configuration
- This use the JUnit properties file and a custom strategy class, so it can run 

## How to run

To run this project, at least we need to give it the environment (considering the remaining vars are in the properties files)

```sh
mvn clean test -Denv=<qa|preprod> allure:report
```

The following parameters that can also be provided are (and must if not in the properties file):

`-DbaseUrl`     :: Base Url of the application under test

`-Dbrowser`     :: The browser used to run the automation - only supporting chrome or firefox

```sh
mvn clean test -Denv=<qa|preprod> -DbaseUrl=<base_url> -Dbrowser=<chrome|firefox> allure:report
```


