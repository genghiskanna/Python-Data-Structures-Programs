from __future__ import print_function


class Poly():

    def __init__(self):
        self.pow = None
        self.coeff = None
        self.next = None


def create_poly():
    flag = True
    tmp_node = Poly()  # To hold the temporary last address
    node = tmp_node  # Store the head address to the reference variable
    while flag:
        # Get the user data
        coeff = int(input("Enter Coeff:"))
        tmp_node.coeff = coeff
        pow = int(input("Enter Pow:"))
        tmp_node.pow = pow

        # Done storing user data
        # Now increase the Linked on user condition
        tmp_node.next = None

        # Ask user for continuation
        print("Continue adding more terms to the polynomial list?(Y = 1/N = 0): ")
        flag = int(input())

        # Grow the linked list on condition
        if flag:
            tmp_node.next = Poly()  # Grow the list
            tmp_node = tmp_node.next
            tmp_node.next = None
    return node


def show_poly(node):
    print("The polynomial expression is:")
    while node is not None:
        print("%dx^%d" % (node.coeff, node.pow), end="")
        node = node.next
        if node is not None:
            print(" + ", end="")
    print("")


def add_poly(poly1, poly2):
    tmp_node = Poly()  # Temporary storage for the linked list
    result = tmp_node  # Copy the head address to the result linked list

    # Loop while both of the linked lists have value
    while poly1 is not None and poly2 is not None:
        if poly1.pow > poly2.pow:
            tmp_node.pow = poly1.pow
            tmp_node.coeff = poly1.coeff
            poly1 = poly1.next

        elif poly1.pow < poly2.pow:
            tmp_node.pow = poly2.pow
            tmp_node.coeff = poly2.coeff
            poly2 = poly2.next

        else:
            tmp_node.pow = poly1.pow
            tmp_node.coeff = poly1.coeff + poly2.coeff
            poly1 = poly1.next
            poly2 = poly2.next

        # Grow the linked list on condition
        if poly1 is not None and poly2 is not None:
            tmp_node.next = Poly()
            tmp_node = tmp_node.next
            tmp_node.next = None

    # Loop while either of the linked lists has value
    while poly1 is not None or poly2 is not None:
        tmp_node.next = Poly()
        tmp_node = tmp_node.next
        tmp_node.next = None

        if poly1 is not None:
            tmp_node.pow = poly1.pow
            tmp_node.coeff = poly1.coeff
            poly1 = poly1.next

        if poly2 is not None:
            tmp_node.pow = poly2.pow
            tmp_node.coeff = poly2.coeff
            poly2 = poly2.next
    return result


ch = 1
while ch:
    print("Create 1st expression")
    pol1 = create_poly()
    print("Stored the 1st expression")
    show_poly(pol1)
    print("Create 2nd expression")
    pol2 = create_poly()
    print("Stored the 2nd expression")
    show_poly(pol2)
    res = add_poly(pol1, pol2)
    show_poly(res)

    ch = int(input("Add two more expressions? (Y = 1/N = 0): "))
