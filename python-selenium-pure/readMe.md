# Bootstrap Selenuim - Python - Pure

## Type:

- **Basic Framework:** Pytest + Selenium
- **Secondary Framework:** --
- **Browsers:** WebDriver Manager downloaded for python
- **Type of config file:** pytest.ini file + dynaconf
- **Remote runner possibility:** No
- **Test Parallelization:** Yes
- **CI/CD:** Yes
- **Reporting:** pytest html report

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

## Notes

To reuse remove the directory `dbjson` as it only serves for mocking.

If the file `.secrets.yaml` doesn't exist create it as is part of dynaconf and can be used to add local data
