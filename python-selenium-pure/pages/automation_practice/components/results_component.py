import logging

from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions

from pages.base_page import BasePage


class ResultsComponent(BasePage):

    results_container: By = (By.ID, "center_column")
    term_searched: By = (By.CLASS_NAME, "lighter")
    results_boxes: By = (By.CLASS_NAME, "product-container")

    def __init__(self, driver):
        super().__init__(driver)

    def is_loaded(self):
        self.wait_until_element_displayed(self.results_container)
        self.wait_until_element_displayed(self.term_searched)
        self.wait_until_elements_displayed(self.results_boxes)

    def get_searched_term(self) -> str:
        assert type(self.get_element_text(self.term_searched)) == str
        return str(self.get_element_text(self.term_searched)).replace("\"", "")

    def get_nr_of_results(self) -> int:
        return len(self.wait_until_elements_displayed(self.results_boxes))
