import logging

from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions

from pages.base_page import BasePage


class ResultsComponent(BasePage):

    locators = {
        "results_container": ("id", "center_column"),
        "term_searched": ("class_name", "lighter"),
    }

    # This one needs to be outside since it is a list and it is not handled by pagefactory
    results_boxes: By = (By.CLASS_NAME, "product-container")

    def __init__(self, driver):
        super().__init__(driver)

    def is_loaded(self):
        self.results_container.visibility_of_element_located()
        self.term_searched.visibility_of_element_located()
        self.wait_until_elements_displayed(self.results_boxes)

    def get_searched_term(self) -> str:
        text = self.term_searched.get_text()
        assert type(text) == str
        return text.replace("\"", "")

    def get_nr_of_results(self) -> int:
        return len(self.wait_until_elements_displayed(self.results_boxes))
