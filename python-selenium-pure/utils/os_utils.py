import os


def path_includes_name(name: str):
    cwd = os.getcwd()
    names_in_cwd = cwd.split("/")
    print(names_in_cwd)
    if name in names_in_cwd:
        return True
