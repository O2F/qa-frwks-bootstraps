import pytest

from model.user import User
from pages.sauce_demo_pages.catalog_page import CatalogPage
from pages.sauce_demo_pages.login_page import LoginPage
from playwright.sync_api import Page


@pytest.fixture
def login_page(page: Page):
    login_page = LoginPage(page)
    yield login_page


@pytest.fixture
def catalog_page(page: Page):
    catalog_page = CatalogPage(page)
    yield catalog_page


def test_one(login_page, catalog_page):
    valid_user = User("standard_user", "secret_sauce")
    login_page.goto_login_page()
    login_page.login_page_loaded()
    login_page.login(valid_user)
    catalog_page.is_loaded()
    catalog_page.validate_title_is("Products")
    catalog_page.validate_item_nr_text_is(0, "Sauce Labs Backpack")
    catalog_page.iter_items_names()


def test_two(login_page):
    user = User("locked_out_user", "secret_sauce")
    login_page.goto_login_page()
    login_page.login_page_loaded()
    login_page.login(user)


def test_three(login_page):
    user = User("problem_user", "secret_sauce")
    login_page.goto_login_page()
    login_page.login_page_loaded()
    login_page.login(user)


def test_four(login_page):
    user = User("performance_glitch_user", "secret_sauce")
    login_page.goto_login_page()
    login_page.login_page_loaded()
    login_page.login(user)
