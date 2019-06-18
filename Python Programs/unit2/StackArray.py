from __future__ import print_function


class StackT:
    def __init__(self, size):
        self.stack = [0] * size
        self.top = -1
        self.size = size

    def popS(self):
        temp = self.stack[self.top]
        self.top -= 1
        return temp

    def pushS(self, element):
        self.top += 1
        self.stack[self.top] = element

    def isFullS(self):
        return True if self.top >= self.size - 1 else False

    def isEmptyS(self):
        return True if self.top == -1 else False

    def displayS(self):
        if self.isEmptyS():
            print("Stack is Empty")
        else:
            for i in range(0, self.top + 1):
                print(self.stack[i], end=" ")
            print("")


st = StackT(size=5)
print("Implementation Of Stack")
while True:
    choice = int(input("1.Push 2.Pop 3.Display 4.exit\nEnter your choice : "))
    if choice == 1:
        item = int(input("Enter The item to be pushed : "))
        if (st.isFullS()):
            print("Stack is Full!")
        else:
            st.pushS(item)

    elif choice == 2:
        if (st.isEmptyS()):
            print("Empty stack!Underflow !!")
        else:
            item = st.popS()
            print("The popped element is %d" % item)

    elif choice == 3:
        st.displayS()

    elif choice == 4:
        exit(0)

    else:
        print("Wrong Choice")
