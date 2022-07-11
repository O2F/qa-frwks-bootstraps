import dataclasses
import logging

import jsonpath_rw_ext as jsonpath
import requests

from config import settings
from dataclasses_objs.graphQLQuery import GraphQLQuery
from dataclasses_objs.variables.countryIsoCode2 import CountryIsoCode2

tl = logging.getLogger("test-logger")


def test_query_country_full_data():
    code = CountryIsoCode2("PT")

    query = GraphQLQuery(query="query getCountryData($code: ID!) { country(code: $code) { name native capital emoji "
                               "currency languages { code name } } }", variables=code)

    response = requests.post(settings.base_url, json=dataclasses.asdict(query))

    assert response.json()["data"]["country"]["name"] == "Portugal"
    assert response.json()["data"]["country"]["languages"][0]["name"] == "Portuguese"


def test_all_countries_data():
    query = GraphQLQuery(query="query getAllCountries { countries { code name phone } }")

    response = requests.post(settings.base_url, json=dataclasses.asdict(query))

    assert response.status_code == 200

    '''
    #############################################
    VALIDATION WITH JSONPATH INSTEAD OF JSON DICT
    #############################################
    '''

    # Assert sublist is part of the list - needs to use sets
    assert {"PT", "AD"}.issubset(jsonpath.match("$..code", response.json()))
