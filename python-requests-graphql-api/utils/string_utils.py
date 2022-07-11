import string
import random


def create_random_string(string_len: int = 10):
    letters = string.ascii_letters
    return ''.join(random.choice(letters) for i in range(string_len))
