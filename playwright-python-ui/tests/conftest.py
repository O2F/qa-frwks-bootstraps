import logging
import os
import pytest
from datetime import datetime

from tests.configuration import Configuration


# All the browser context args need to be applied in a single method with the name "browser_context_args" as below
@pytest.fixture(scope="session")
def browser_context_args(browser_context_args):
    if Configuration.add_browser_context_extra_args:
        args = {
            **browser_context_args,
            "viewport": Configuration.view_port,
            "ignore_https_errors": Configuration.ignore_https_errors
        }
        a = logging.getLogger("a")
        a.error(args)
        return args

# report filename renaming
@pytest.hookimpl(tryfirst=True)
def pytest_configure(config):
    # to remove environment section
    config._metadata = None

    if not os.path.exists(Configuration.reports_dir):
        os.makedirs(Configuration.reports_dir)

    config.option.htmlpath = f'{Configuration.reports_dir}report_{datetime.now().strftime("%Y%m%d_%H%M%S")}.html'
