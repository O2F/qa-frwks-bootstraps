from selenium import webdriver

from config import settings
from pages.automation_practice.components.header_component import HeaderComponent
from pages.base_page import BasePage


class LandingPage(BasePage):

    def __init__(self, driver):
        super().__init__(driver)
        self.header_component = HeaderComponent(driver)

    def navigate_to_automation_practice(self):
        self.driver.get(settings.base_url)

    def perform_search(self, text: str):
        self.header_component.search(text)