from lark import Lark


def parse():

    test = "1 + 1 + 2"

    math_grammer = open("matlang.lark", "r").read()
    parse = Lark(math_grammer).parse
    print(parse(test))


if __name__ == "__main__":
    parse()