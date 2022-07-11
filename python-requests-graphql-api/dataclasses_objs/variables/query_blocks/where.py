import dataclasses

from dataclasses_objs.variables.query_blocks.id import Id
from dataclasses_objs.variables.query_blocks.rocket import Rocket


@dataclasses.dataclass
class Where:
    id: Id = None

    rocket: Rocket = None
