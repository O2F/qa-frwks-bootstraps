# Bootstrap Playwright - Python - UI/E2E 

## Type:

- **Basic Framework:** Pytest
- **Secondary Framework:** Playwright
- **Browsers:** Playwright - needs to install/update 
- **Type of config file:** pytest.ini file
- **Remote runner possibility:** No
- **Test Parallelization:** Yes
- **CI/CD:** Yes
- **Reporting:** pytest html report

## Dependencies

- pytest
- pytest-playwright
- pytest-html
- pytest-parallel
- playwright

To install the dependencies just run:

```sh
pip install -r requirements-test.txt
```

After installing the dependencies playwright also needs to install the browsers
- Chromium
- Firefox
- Webkit (safari)

To do this run the following command:

```shell
playwright install
```

## How to run

To run this project either add the arguments to the pytest.ini file or to the command line

example of pytest.ini:

```ini
[pytest]
addopts = --headed --browser chromium --workers 4  --html=target/reports/report.html --browser firefox --browser webkit

log_cli = 1
log_cli_level = INFO
log_cli_format = %(asctime)s [%(levelname)8s] %(message)s (%(filename)s:%(lineno)s)
log_cli_date_format=%Y-%m-%d %H:%M:%S
```

example of command line:

```shell
pytest --headed --browser chromium --tests-per-worker 4  --html=report.html --browser firefox --browser webkit
```

### Notes on the arg opts

| opt              | cardinality | values                              | obs                                                                                                                               |
|------------------|-------------|-------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| browser          | 1..3        | - chromium<br>- firefox<br>- webkit | The browser where the automation will run.<br>To provide more than one browser example:<br>`--browser chromium --browser firefox` |
| tests-per-worker | 1..n        | --                                  | Threads per process (worker)<br>To let python decide:<br>`--tests-per-worker auto`                                                |
| workers          | 1..n        | --                                  | Concurrent Processes<br>To let python decide:<br>`--workers auto`                                                                 |
| headed           | --          | --                                  | Provides visual browser span                                                                                                      |
| html=\<path\>    | --          | --                                  | provides the path to HTML report                                                                                                  |


- **tests-per-worker** and **workers** can be used at the same time (although normally not needed)
- Using tests-per-worker or workers doesn't mess up with the html reporting
- **log_cli_*** - these options are needed to provide logging in the CLI

