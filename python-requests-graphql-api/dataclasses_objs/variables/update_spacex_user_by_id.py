import dataclasses

from dataclasses_objs.variables.query_blocks.set_name import SetName
from dataclasses_objs.variables.query_blocks.where import Where


@dataclasses.dataclass
class UpdateSpaceXUserNameById:

    where: Where
    set: SetName
