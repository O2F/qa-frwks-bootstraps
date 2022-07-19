from time import sleep

import pytest

from pages.google_search_page import GoogleSearchPage


@pytest.fixture()
def google_page(driver):
    yield GoogleSearchPage(driver)


def test_simple_search(google_page):
    search_text = "Espera sempre só coisas boas"

    google_page.open_google_page()
    google_page.accept_conditions()
    google_page.perform_search(search_text)
    google_page.validate_first_result_contains_sentence(search_text)
    sleep(0.2)


def test_simple_search02(google_page):
    search_text = "Espera sempre só coisas boas"

    google_page.open_google_page()
    google_page.accept_conditions()
    google_page.perform_search(search_text)
    google_page.validate_first_result_contains_sentence(search_text)
    sleep(0.2)


def test_simple_search03(google_page):
    search_text = "Espera sempre só coisas boas"

    google_page.open_google_page()
    google_page.accept_conditions()
    google_page.perform_search(search_text)
    google_page.validate_first_result_contains_sentence(search_text)
    sleep(0.2)


def test_simple_search04(google_page):
    search_text = "Espera sempre só coisas boas"

    google_page.open_google_page()
    google_page.accept_conditions()
    google_page.perform_search(search_text)
    google_page.validate_first_result_contains_sentence(search_text)
    sleep(0.2)
