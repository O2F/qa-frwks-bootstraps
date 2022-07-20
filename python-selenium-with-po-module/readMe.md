# Bootstrap Selenium - Python - PageFactory Class usage

## Type:

- **Basic Framework:** Pytest + Selenium + PageFactory class
- **Secondary Framework:** --
- **Browsers:** WebDriver Manager downloaded for python
- **Type of config file:** pytest.ini file + dynaconf
- **Remote runner possibility:** No
- **Test Parallelization:** Yes
- **CI/CD:** Yes
- **Reporting:** pytest html report

## Notes
- [Doesn't work with list of WebElements](https://github.com/NayakwadiS/selenium-page-factory/issues/10) (methods are not implemented) so it needs normal locator and methods for that case (see example on BasePage)
- **NOT TO PRACTICAL SINCE IT CAN'T HANDLE LIST OF ELEMENTS - ONLY CHOOSE TO USE IN LAST RESORT**

## Dependencies

- pytest
- selenium
- pytest-html
- pytest-xdist
- pytest-xdist[psutil]
- webdriver-manager

To install the dependencies just run:

```sh
pip install -r requirements.txt
```

## How to run

To run this project either add the arguments to the pytest.ini file or to the command line

example of pytest.ini:

```ini
[pytest]
addopts = -n auto

log_cli = 1
log_cli_level = INFO
log_cli_format = %(asctime)s [%(levelname)8s] %(message)s (%(filename)s:%(lineno)s)
log_cli_date_format=%Y-%m-%d %H:%M:%S
```

example of command line:

```shell
pytest tests
```