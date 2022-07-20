def test_search_possible(landing_page, search_results_page):
    landing_page.navigate_to_automation_practice()
    landing_page.perform_search("dress")
    search_results_page.is_loaded()
    search_results_page.displayed_search_term_should_be("DRESS")
    search_results_page.nr_of_result_should_be(7)
