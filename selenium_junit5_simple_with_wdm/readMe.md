# Bootstrap JUnit5 - UI/E2E - Simple + WDM

## Type:

- **Basic Framework:** JUnit 5
- **Secondary Framework:** ---
- **Browsers:** Manually downloaded
- **Type of config file:** properties file
- **Remote runner possibility:** No
- **Test Parallelization:** No
- **CI/CD:** No

## Notes

- This is the simplest of them all
- Have driver paths hardcoded
- Has the concept of **page components** that are used in **pages**
- Has a configuration model that then creates a configuration - **BaseTestConfig**

## How to run

To run this project, at least we need to give it the environment (considering the remaining vars are in the properties files)

```sh
mvn clean test -Denv=<qa|preprod>
```

The following parameters that can also be provided are (and must if not in the properties file):

`-DbaseUrl`     :: Base Url of the application under test

`-Dbrowser`     :: The browser used to run the automation - only supporting chrome or firefox

