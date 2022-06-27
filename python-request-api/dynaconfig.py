
from dynaconf import Dynaconf


settings = Dynaconf(
    envvar_prefix="DYNACONF",
    settings_files=['settings.yaml', '.secrets.yaml'],
    # To add different environments
    environments=True,
    # support for .env files
    load_dotenv=True
)

# `envvar_prefix` = export envvars with `export DYNACONF_FOO=bar`.
# `settings_files` = Load these files in the order.
