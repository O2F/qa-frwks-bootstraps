import dataclasses
import logging

import pytest
import requests
import jsonpath_rw_ext as jsonpath

from dataclasses_objs.graphQLQuery import GraphQLQuery
from dataclasses_objs.variables.delete_spacex_user import DeleteSpaceXUserByRocketPartialName
from dataclasses_objs.variables.query_blocks.rocket import Rocket
from dataclasses_objs.variables.query_blocks.where import Where

tl = logging.getLogger("test-logger")


@pytest.fixture(autouse=True)
def gql_spacex_url():
    return "https://api.spacex.land/graphql/"


@pytest.fixture(autouse=True)
def tear_down(gql_spacex_url):
    yield ""

    delete_query = '''mutation Mutation($where: users_bool_exp!) {
                  delete_users(where: $where) {
                    returning {
                      id
                      name
                    }
                  }
                }
    '''

    delete_payload = DeleteSpaceXUserByRocketPartialName(
        Where(
            rocket=Rocket("Mega Rocket")
        )
    )

    query = GraphQLQuery(
        query=delete_query,
        variables=delete_payload
    )

    response = requests.post(gql_spacex_url, json=dataclasses.asdict(query))

    assert response.status_code == 200
    assert jsonpath.match("$..returning[*]", response.json()) != []
