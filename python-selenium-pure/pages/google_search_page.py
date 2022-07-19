from selenium.webdriver import Keys
from selenium.webdriver.common.by import By

from config import settings
from pages.base_page import BasePage


class GoogleSearchPage(BasePage):

    search_box: By = (By.NAME, "q")
    search_btn: By = (By.NAME, "btnK") # this is a list of elements
    agree_btn: By = (By.ID, "L2AGLb")
    results_links: By = (By.XPATH, "//h3") # this is a list of elements

    def __init__(self, driver):
        super().__init__(driver)

    def open_google_page(self):
        self.goto_page(settings.google_base_url)

    def accept_conditions(self):
        self.click_on_btn(self.agree_btn)

    def perform_search(self, text: str):
        self.input_text(self.search_box,text)
        self.use_keyboard_key(self.search_box, Keys.ENTER)

    def validate_first_result_contains_sentence(self, sentence: str):
        elements = self.wait_until_elements_displayed(self.results_links)
        if len(elements) > 0:
            text = elements[0].text
            assert sentence in text
