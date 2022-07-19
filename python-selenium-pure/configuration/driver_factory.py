from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager

from config import settings


class DriverFactory:
    used_browsers = ('chrome', 'firefox', 'edge')

    def __init__(self, browser: str, headless: bool = False):
        if browser not in self.used_browsers:
            raise RuntimeError("Browser not supported, please implement the needed configuration")

        self.browser = browser
        self.headless = headless

    def get_driver(self) -> webdriver:

        # page_load_strategy - (normal, eager, none)

        browser = str(self.browser).lower()
        if browser == "chrome":
            chrome_opts = webdriver.ChromeOptions()
            chrome_opts.page_load_strategy = "normal"
            chrome_opts.headless = self.headless
            return webdriver.Chrome(service=ChromeService(ChromeDriverManager(
                cache_valid_range=settings.browser_configs.browser_binary_cache)
                                                          .install()),
                                    options=chrome_opts)
        if browser == "firefox":
            firefox_opts = webdriver.FirefoxOptions()
            firefox_opts.page_load_strategy = "normal"
            firefox_opts.headless = self.headless
            return webdriver.Firefox(service=FirefoxService(GeckoDriverManager(
                cache_valid_range=settings.browser_configs.browser_binary_cache)
                                                            .install()),
                                     options=firefox_opts)