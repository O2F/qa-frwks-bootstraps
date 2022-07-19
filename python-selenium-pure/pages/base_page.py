from selenium import webdriver
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

from config import settings


class BasePage:

    def __init__(self, driver):
        if driver is None:
            raise RuntimeError("WebDriver not defined")
        self.driver = driver
        self.wait = WebDriverWait(driver, settings.browser_configs.explicit_timeout,
                                  settings.browser_configs.pooling_time)

        # actions(if needed): https://www.geeksforgeeks.org/action-chains-in-selenium-python/

    def goto_page(self, url: str):
        self.driver.get(url)

    def click_on_btn(self, by_locator: By) -> None:
        # locator must be a By.
        # example: WebDriverWait(driver,100).until(EC.presence_of_element_located((By.class, "ng-binding ng-scope")))
        element = self.wait_until_element_displayed(by_locator)
        element.click()

    def input_text(self, by_locator: By, text: str):
        element = self.wait_until_element_displayed(by_locator)
        element.click()
        element.send_keys(text)

    def use_keyboard_key(self, by_locator: By, key: Keys):
        element = self.wait_until_element_displayed(by_locator)
        element.send_keys(key)

    def wait_until_element_displayed(self, by_locator: By):
        return self.wait.until(expected_conditions
                               .presence_of_element_located(by_locator))

    def wait_until_elements_displayed(self, by_locator: By):
        return self.wait.until(expected_conditions.presence_of_all_elements_located(by_locator))

    def get_element_text(self, by_locator: By) -> str:
        element = self.wait_until_element_displayed(by_locator)
        return element.text
