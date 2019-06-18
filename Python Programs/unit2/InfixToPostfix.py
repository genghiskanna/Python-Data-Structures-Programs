from __future__ import print_function


def infixToPostfix(infixexpr):
    # initializing precedence as a dictionary to easily identify
    prec = {}
    prec["*"] = 3
    prec["/"] = 3
    prec["+"] = 2
    prec["-"] = 2
    prec["("] = 1

    # list can be used as stack when .pop() is used as deletion
    opStack = []

    postfixList = []
    tokenList = infixexpr.split()

    for token in tokenList:
        # identifying whether the token is a variable or an operator
        if token in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
            postfixList.append(token)
        elif token == '(':
            opStack.append(token)
        elif token == ')':
            topToken = opStack.pop()
            while topToken != '(':
                postfixList.append(topToken)
                topToken = opStack.pop()
        else:
            while (not len(opStack) == 0) and (
                    prec[opStack[-1]] >= prec[token]):
                postfixList.append(opStack.pop())
            opStack.append(token)

    while not len(opStack) == 0:
        postfixList.append(opStack.pop())
    # converting the list to string
    return " ".join(postfixList)


exp = str(input("Enter the expression : "))
print(infixToPostfix(exp))
