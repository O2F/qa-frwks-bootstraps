from pages.automation_practice.components.header_component import HeaderComponent
from pages.automation_practice.components.results_component import ResultsComponent
from pages.base_page import BasePage


class SearchResultPage(BasePage):

    def __init__(self, driver):
        super().__init__(driver)
        self.header_component = HeaderComponent(driver)
        self.result_component = ResultsComponent(driver)

    def is_loaded(self):
        self.result_component.is_loaded()
        # in a normal automation should have the remaining components

    def displayed_search_term_should_be(self, text: str):
        assert text == self.result_component.get_searched_term()

    def nr_of_result_should_be(self, nr: int):
        assert nr == self.result_component.get_nr_of_results()