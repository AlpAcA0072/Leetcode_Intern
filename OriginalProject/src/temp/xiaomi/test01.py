class Cat:
    "1"
    name = "2"

    def showInfo(self):
        self.name = "3"
        name = "4"
        print(Cat.name, self.name)


cat = Cat()
cat.showInfo()
