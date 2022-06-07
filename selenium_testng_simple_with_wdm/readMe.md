# Bootstrap TestNG - UI/E2E - Simple + WDM

## Type:

- **Basic Framework:** TestNG
- **Secondary Framework:** ---
- **Browsers:** WebDriver Manager downloaded
- **Type of config file:** properties file
- **Remote runner possibility:** No
- **Test Parallelization:** No
- **CI/CD:** No
- **Reporting:** Allure Report for TestNG

## Notes

- Has the concept of **page components** that are used in **pages**
- Has a configuration model that then creates a configuration - **BaseTestConfig**

## How to run

To run this project, at least we need to give it the environment (considering the remaining vars are in the properties/yaml files)

```sh
mvn clean test -Denv=<qa|preprod> allure:report
```

The following parameters that can also be provided are (and must if not in the properties file):

`-DbaseUrl`     :: Base Url of the application under test

`-Dbrowser`     :: The browser used to run the automation - only supporting chrome or firefox

If you don't have properties/yaml configuration files or want to overwrite the values in it:

```sh
mvn clean test -Denv=<qa|preprod> -DbaseUrl=<base_url> -Dbrowser=<chrome|firefox> allure:report
```
