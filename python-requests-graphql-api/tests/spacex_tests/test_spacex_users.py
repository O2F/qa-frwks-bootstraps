import dataclasses
import logging
import uuid

import requests

from dataclasses_objs.graphQLQuery import GraphQLQuery
from dataclasses_objs.variables import spacex_user
from dataclasses_objs.variables.query_blocks.id import Id
from dataclasses_objs.variables.query_blocks.set_name import SetName
from dataclasses_objs.variables.query_blocks.where import Where
from dataclasses_objs.variables.update_spacex_user_by_id import UpdateSpaceXUserNameById
from utils.string_utils import create_random_string
import jsonpath_rw_ext as jsonpath

tl = logging.getLogger("test-logger")
QUERY_CREATE = "mutation insert_users ($id: uuid!, $name: String!, $rocket: String!) " \
        "{ insert_users(objects: {id: $id, name: $name, rocket: $rocket}) { returning { id name rocket } } }"

QUERY_UPDATE = """mutation Mutation($where: users_bool_exp!, $set: users_set_input) { 
                update_users(where: $where, _set: $set) { 
                    affected_rows 
                    returning { 
                      name 
                      id 
                      rocket 
                    } 
                  } 
                }"""


def test_create_user(gql_spacex_url):
    # the user obj
    user = spacex_user.SpaceXUser(str(uuid.uuid4()), create_random_string(), "Mega Rocket")

    # the query
    query = GraphQLQuery(
        query=QUERY_CREATE,
        variables=user
    )

    response = requests.post(gql_spacex_url, json=dataclasses.asdict(query))

    assert jsonpath.match("$..returning[*].id", response.json())[0] == user.id
    assert jsonpath.match("$..returning[*].name", response.json())[0] == user.name
    assert jsonpath.match("$..returning[*].rocket", response.json())[0] == user.rocket


def test_update_user_by_uuid(gql_spacex_url):

    user = spacex_user.SpaceXUser(str(uuid.uuid4()), create_random_string(), "Mega Rocket")

    # create user
    query = GraphQLQuery(
        query=QUERY_CREATE,
        variables=user
    )

    requests.post(gql_spacex_url, json=dataclasses.asdict(query))

    # update user

    update_user = UpdateSpaceXUserNameById(
        Where(
            Id(user.id)
        ),
        SetName(create_random_string())
    )

    update_query = GraphQLQuery(
        query=QUERY_UPDATE,
        variables=update_user
    )

    response = requests.post(gql_spacex_url, json=dataclasses.asdict(update_query))

    assert jsonpath.match("$..returning[*].name", response.json())[0] == update_user.set.name
    assert jsonpath.match("$..returning[*].id", response.json())[0] == user.id
    assert jsonpath.match("$..returning[*].rocket", response.json())[0] == user.rocket
