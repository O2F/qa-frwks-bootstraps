from dataclasses import dataclass, field


@dataclass
class GraphQLQuery:
    query: str
    variables: object = field(default=None)
