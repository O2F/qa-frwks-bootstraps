# import logging
import os
import pytest
from datetime import datetime
from dynconfig import settings


def pytest_addoption(parser):
    parser.addoption("--env", action="store", default="qa")


@pytest.fixture(scope='session', autouse=True)
def config_loader(pytestconfig):
    settings.configure(FORCE_ENV_FOR_DYNACONF=pytestconfig.getoption("env"))


# All the browser context args need to be applied in a single method with the name "browser_context_args" as below
# @pytest.fixture(scope="session")
# def browser_context_args(browser_context_args):
#     if Configuration.add_browser_context_extra_args:
#         args = {
#             **browser_context_args,
#             "viewport": Configuration.view_port,
#             "ignore_https_errors": Configuration.ignore_https_errors
#         }
#         #        a = logging.getLogger("a")
#         #        a.error(args)
#         return args


# report filename renaming
@pytest.hookimpl(tryfirst=True)
def pytest_configure(config):
    settings.configure(FORCE_ENV_FOR_DYNACONF=config.getoption("env"))
    report_path = settings.reports_path

    config._metadata = None

    if not os.path.exists(report_path):
        os.makedirs(report_path)

    config.option.htmlpath = f'{report_path}report_{datetime.now().strftime("%Y%m%d_%H%M%S")}.html'
