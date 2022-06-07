from playwright.sync_api import Page, expect

def test_example(page: Page) -> None:
    # Go to https://www.google.com/?gws_rd=ssl
    page.goto("https://www.google.com/?gws_rd=ssl")
    # Click button:has-text("I agree")
    # with page.expect_navigation(url="https://www.google.com/?gws_rd=ssl"):
    with page.expect_navigation():
        page.locator("button:has-text(\"I agree\")").click()
    # Click [aria-label="Search"]
    page.locator("[aria-label=\"Search\"]").click()
    # Fill [aria-label="Search"]
    page.locator("[aria-label=\"Search\"]").fill("teste")
    # Press Enter
    # with page.expect_navigation(url="https://www.google.com/search?q=teste&source=hp&ei=iBmaYta3JYH-lwSQzIfwAQ&iflsig=AJiK0e8AAAAAYponmPATf3iC9Q2wlk8YMzhjo75ZrxR4&ved=0ahUKEwjWm_OAvpH4AhUB_4UKHRDmAR4Q4dUDCAc&uact=5&oq=teste&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOg4IABCPARDqAhCMAxDlAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEKMCUIULWJIQYKIjaAFwAHgAgAFxiAH8A5IBAzIuM5gBAKABAbABCQ&sclient=gws-wiz"):
    with page.expect_navigation():
        page.locator("[aria-label=\"Search\"]").press("Enter")
    # expect(page).to_have_url("https://www.google.com/search?q=teste&source=hp&ei=iBmaYta3JYH-lwSQzIfwAQ&iflsig=AJiK0e8AAAAAYponmPATf3iC9Q2wlk8YMzhjo75ZrxR4&ved=0ahUKEwjWm_OAvpH4AhUB_4UKHRDmAR4Q4dUDCAc&uact=5&oq=teste&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOg4IABCPARDqAhCMAxDlAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEKMCUIULWJIQYKIjaAFwAHgAgAFxiAH8A5IBAzIuM5gBAKABAbABCQ&sclient=gws-wiz")
    # Click text=Speedtest by Ookla - The Global Broadband Speed Test
    page.locator("text=Speedtest by Ookla - The Global Broadband Speed Test").click()
    # expect(page).to_have_url("https://www.speedtest.net/")

def test_example2(page: Page) -> None:
    # Go to https://www.google.com/?gws_rd=ssl
    page.goto("https://www.google.com/?gws_rd=ssl")
    # Click button:has-text("I agree")
    # with page.expect_navigation(url="https://www.google.com/?gws_rd=ssl"):
    with page.expect_navigation():
        page.locator("button:has-text(\"I agree\")").click()
    # Click [aria-label="Search"]
    page.locator("[aria-label=\"Search\"]").click()
    # Fill [aria-label="Search"]
    page.locator("[aria-label=\"Search\"]").fill("teste")
    # Press Enter
    # with page.expect_navigation(url="https://www.google.com/search?q=teste&source=hp&ei=iBmaYta3JYH-lwSQzIfwAQ&iflsig=AJiK0e8AAAAAYponmPATf3iC9Q2wlk8YMzhjo75ZrxR4&ved=0ahUKEwjWm_OAvpH4AhUB_4UKHRDmAR4Q4dUDCAc&uact=5&oq=teste&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOg4IABCPARDqAhCMAxDlAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEKMCUIULWJIQYKIjaAFwAHgAgAFxiAH8A5IBAzIuM5gBAKABAbABCQ&sclient=gws-wiz"):
    with page.expect_navigation():
        page.locator("[aria-label=\"Search\"]").press("Enter")
    # expect(page).to_have_url("https://www.google.com/search?q=teste&source=hp&ei=iBmaYta3JYH-lwSQzIfwAQ&iflsig=AJiK0e8AAAAAYponmPATf3iC9Q2wlk8YMzhjo75ZrxR4&ved=0ahUKEwjWm_OAvpH4AhUB_4UKHRDmAR4Q4dUDCAc&uact=5&oq=teste&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOg4IABCPARDqAhCMAxDlAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEKMCUIULWJIQYKIjaAFwAHgAgAFxiAH8A5IBAzIuM5gBAKABAbABCQ&sclient=gws-wiz")
    # Click text=Speedtest by Ookla - The Global Broadband Speed Test
    page.locator("text=Speedtest by Ookla - The Global Broadband Speed Test").click()
    # expect(page).to_have_url("https://www.speedtest.net/")

def test_example3(page: Page) -> None:
    # Go to https://www.google.com/?gws_rd=ssl
    page.goto("https://www.google.com/?gws_rd=ssl")
    # Click button:has-text("I agree")
    # with page.expect_navigation(url="https://www.google.com/?gws_rd=ssl"):
    with page.expect_navigation():
        page.locator("button:has-text(\"I agree\")").click()
    # Click [aria-label="Search"]
    page.locator("[aria-label=\"Search\"]").click()
    # Fill [aria-label="Search"]
    page.locator("[aria-label=\"Search\"]").fill("teste")
    # Press Enter
    # with page.expect_navigation(url="https://www.google.com/search?q=teste&source=hp&ei=iBmaYta3JYH-lwSQzIfwAQ&iflsig=AJiK0e8AAAAAYponmPATf3iC9Q2wlk8YMzhjo75ZrxR4&ved=0ahUKEwjWm_OAvpH4AhUB_4UKHRDmAR4Q4dUDCAc&uact=5&oq=teste&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOg4IABCPARDqAhCMAxDlAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEKMCUIULWJIQYKIjaAFwAHgAgAFxiAH8A5IBAzIuM5gBAKABAbABCQ&sclient=gws-wiz"):
    with page.expect_navigation():
        page.locator("[aria-label=\"Search\"]").press("Enter")
    # expect(page).to_have_url("https://www.google.com/search?q=teste&source=hp&ei=iBmaYta3JYH-lwSQzIfwAQ&iflsig=AJiK0e8AAAAAYponmPATf3iC9Q2wlk8YMzhjo75ZrxR4&ved=0ahUKEwjWm_OAvpH4AhUB_4UKHRDmAR4Q4dUDCAc&uact=5&oq=teste&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOg4IABCPARDqAhCMAxDlAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEKMCUIULWJIQYKIjaAFwAHgAgAFxiAH8A5IBAzIuM5gBAKABAbABCQ&sclient=gws-wiz")
    # Click text=Speedtest by Ookla - The Global Broadband Speed Test
    page.locator("text=Speedtest by Ookla - The Global Broadband Speed Test").click()
    # expect(page).to_have_url("https://www.speedtest.net/")

def test_example4(page: Page) -> None:
    # Go to https://www.google.com/?gws_rd=ssl
    page.goto("https://www.google.com/?gws_rd=ssl")
    # Click button:has-text("I agree")
    # with page.expect_navigation(url="https://www.google.com/?gws_rd=ssl"):
    with page.expect_navigation():
        page.locator("button:has-text(\"I agree\")").click()
    # Click [aria-label="Search"]
    page.locator("[aria-label=\"Search\"]").click()
    # Fill [aria-label="Search"]
    page.locator("[aria-label=\"Search\"]").fill("teste")
    # Press Enter
    # with page.expect_navigation(url="https://www.google.com/search?q=teste&source=hp&ei=iBmaYta3JYH-lwSQzIfwAQ&iflsig=AJiK0e8AAAAAYponmPATf3iC9Q2wlk8YMzhjo75ZrxR4&ved=0ahUKEwjWm_OAvpH4AhUB_4UKHRDmAR4Q4dUDCAc&uact=5&oq=teste&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOg4IABCPARDqAhCMAxDlAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEKMCUIULWJIQYKIjaAFwAHgAgAFxiAH8A5IBAzIuM5gBAKABAbABCQ&sclient=gws-wiz"):
    with page.expect_navigation():
        page.locator("[aria-label=\"Search\"]").press("Enter")
    # expect(page).to_have_url("https://www.google.com/search?q=teste&source=hp&ei=iBmaYta3JYH-lwSQzIfwAQ&iflsig=AJiK0e8AAAAAYponmPATf3iC9Q2wlk8YMzhjo75ZrxR4&ved=0ahUKEwjWm_OAvpH4AhUB_4UKHRDmAR4Q4dUDCAc&uact=5&oq=teste&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOg4IABCPARDqAhCMAxDlAjoLCC4QgAQQxwEQ0QM6CwguEIAEEMcBEKMCUIULWJIQYKIjaAFwAHgAgAFxiAH8A5IBAzIuM5gBAKABAbABCQ&sclient=gws-wiz")
    # Click text=Speedtest by Ookla - The Global Broadband Speed Test
    page.locator("text=Speedtest by Ookla - The Global Broadband Speed Test").click()
    # expect(page).to_have_url("https://www.speedtest.net/")
