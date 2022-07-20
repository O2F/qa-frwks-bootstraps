import pytest

from config import settings
from configuration.driver_factory import DriverFactory
from pages.automation_practice.landing_page import LandingPage
from pages.automation_practice.search_result_page import SearchResultPage


@pytest.fixture(params=settings.browsers)
def driver(request):
    driver = DriverFactory(request.param, bool(settings.browser_configs.headless)).get_driver()
    yield driver

    driver.quit()


@pytest.fixture()
def landing_page(driver):
    yield LandingPage(driver)


@pytest.fixture()
def search_results_page(driver):
    yield SearchResultPage(driver)
