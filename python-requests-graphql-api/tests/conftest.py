import os
from datetime import datetime
from config import settings

import pytest


def pytest_addoption(parser):
    parser.addoption("--env", action="store", default="qa")


@pytest.fixture(scope='session', autouse=True)
def config_loader(pytestconfig):
    settings.configure(FORCE_ENV_FOR_DYNACONF=pytestconfig.getoption("env"))


@pytest.hookimpl(tryfirst=True)
def pytest_configure(config):
    # needs also to be imported here since it is a hookimpl
    settings.configure(FORCE_ENV_FOR_DYNACONF=config.getoption("env"))
    config._metadata = None

    path = settings.report_opts.path

    if not os.path.exists(path):
        os.makedirs(path)

    config.option.htmlpath = f'{path}report_{datetime.now().strftime("%Y%m%d_%H%M%S")}.html'


# @pytest.fixture(autouse=True, scope="session")
# def base_url():
#     return settings.base_url
