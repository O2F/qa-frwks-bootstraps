import json
import logging
from time import sleep

import requests
from dynaconfig import settings

tl = logging.getLogger("test-logger")


def test_book_details_are_displayed():
    response = requests.get(f"{settings.base_url}/books/1")
    assert response.status_code == 200
    assert response.json()["id"] == "1"
    assert response.json()["title"] == "The book of testing"
    assert response.json()["isbn"] == "123456789"


def test_book_id_not_exist():
    response = requests.get(f"{settings.base_url}/books/1000")
    assert response.status_code == 404
    assert response.json() == {}
    tl.info(response.text)


def test_book_add():
    json_payload = json.loads('{"id": 3, "title": "The book of testing 2", "isbn": 123456799}')
    response = requests.post(f"{settings.base_url}/books", json_payload)
    assert response.status_code == 201
    assert response.json()["id"] == "3"
    assert response.json()["title"] == "The book of testing 2"
    assert response.json()["isbn"] == "123456799"
    tl.info(response.text)


def test_book_update():
    json_payload = json.loads('{"id": 4, "title": "The book of testing 3", "isbn": 123456791}')
    requests.post(f"{settings.base_url}/books", json_payload)
    # persist the previous call
    sleep(0.1)
    json_payload = json.loads('{"id": 4, "title": "The book of testing 2A", "isbn": 123456790}')
    response = requests.put(f"{settings.base_url}/books/3", json_payload)
    assert response.status_code == 200
    assert response.json()["id"] == "3"
    assert response.json()["title"] == "The book of testing 2A"
    assert response.json()["isbn"] == "123456790"
    tl.info(response.text)
