import pytest

from config import settings
from pages.google_search_page import GoogleSearchPage
from utils.os_utils import path_includes_name


@pytest.fixture()
def google_page(driver):
    yield GoogleSearchPage(driver)


def test_simple_search(google_page):
    search_text = "Espera sempre só coisas boas"

    google_page.open_google_page()
    # Needs to be bypassed on CI since the conditions modal is not displayed
    if not path_includes_name(settings.ci_distinct_folder):
        google_page.accept_conditions()
    google_page.perform_search(search_text)
    #google_page.validate_first_result_contains_sentence(search_text)


def test_simple_search02(google_page):
    search_text = "Espera sempre só coisas boas"

    google_page.open_google_page()
    # Needs to be bypassed on CI since the conditions modal is not displayed
    if not path_includes_name(settings.ci_distinct_folder):
        google_page.accept_conditions()
    google_page.perform_search(search_text)
    #google_page.validate_first_result_contains_sentence(search_text)


def test_simple_search03(google_page):
    search_text = "Espera sempre só coisas boas"

    google_page.open_google_page()
    # Needs to be bypassed on CI since the conditions modal is not displayed
    if not path_includes_name(settings.ci_distinct_folder):
        google_page.accept_conditions()
    google_page.perform_search(search_text)
    #google_page.validate_first_result_contains_sentence(search_text)


def test_simple_search04(google_page):
    search_text = "Espera sempre só coisas boas"

    google_page.open_google_page()
    # Needs to be bypassed on CI since the conditions modal is not displayed
    if not path_includes_name(settings.ci_distinct_folder):
        google_page.accept_conditions()
    google_page.perform_search(search_text)
    #google_page.validate_first_result_contains_sentence(search_text)
