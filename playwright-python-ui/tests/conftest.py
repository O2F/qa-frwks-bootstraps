import os
import pytest
from datetime import datetime

from tests.constants import Constants


@pytest.hookimpl(tryfirst=True)
def pytest_configure(config):
    # to remove environment section
    config._metadata = None

    if not os.path.exists(Constants.reports_dir):
        os.makedirs(Constants.reports_dir)

    config.option.htmlpath = f'{Constants.reports_dir}report_{datetime.now().strftime("%Y%m%d_%H%M%S")}.html'
