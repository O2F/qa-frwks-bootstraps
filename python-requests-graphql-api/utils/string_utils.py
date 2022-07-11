import string
import random


def create_random_string(string_len: int = 1,
                         with_letters: bool = True,
                         with_numbers: bool = False,
                         with_symbols: bool = False) -> str:
    """
    Creates a random string based on the options provided
    """
    letters = ''
    nr = ''
    symb = ''

    if with_letters:
        letters = string.ascii_letters
    if with_numbers:
        nr = string.digits
    if with_symbols:
        symb = string.punctuation

    return ''.join(random.choice(letters + nr + symb) for i in range(string_len))
