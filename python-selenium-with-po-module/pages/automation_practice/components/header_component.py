from selenium.webdriver.common.by import By

from pages.base_page import BasePage


class HeaderComponent(BasePage):

    locators = {
        "header_discounts": ("css", "#header .banner .img-responsive"),
        "logo": ("css", "[class='logo img-responsive']"),
        "submit_search_btn": ("name", "submit_search"),
        "search_input_box": ("name", "search_query"),
        "login_btn": ("css", "a.login")
    }

    #header_discounts: By = (By.CSS_SELECTOR, "#header .banner .img-responsive")
    #logo: By = (By.CSS_SELECTOR, "[class='logo img-responsive']")
    #submit_search_btn: By = (By.NAME, "submit_search")
    #search_input_box: By = (By.NAME, "search_query")
    #login_btn: By = (By.CSS_SELECTOR, "a.login")

    def __init__(self, driver):
        super().__init__(driver)

    def header_discount_should_be_displayed(self):
        self.header_discounts.visibility_of_element_located()
        #element = self.wait_until_element_displayed(self.header_discounts)
        #assert element is not None or element != ""

    def login_btn_should_be_displayed(self):
        self.login_btn.visibility_of_element_located()
        #self.wait_until_element_displayed(self.login_btn)

    def search(self, text: str):
        self.search_input_box.set_text(text)
        self.submit_search_btn.click_button()
        #self.input_text(self.search_input_box, text)
        #self.click_on_btn(self.submit_search_btn)

