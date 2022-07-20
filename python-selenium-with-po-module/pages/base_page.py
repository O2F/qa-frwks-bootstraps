from selenium import webdriver
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from seleniumpagefactory import PageFactory
from selenium.webdriver.support import expected_conditions as EC

from config import settings


class BasePage(PageFactory):

    def __init__(self, driver):
        super().__init__()
        if driver is None:
            raise RuntimeError("WebDriver not defined")
        self.driver = driver
        self.timeout = settings.browser_configs.explicit_timeout

    def wait_until_elements_displayed(self, by_locator: By):
        return WebDriverWait(driver=self.driver, timeout=self.timeout)\
            .until(expected_conditions.presence_of_all_elements_located(by_locator))
