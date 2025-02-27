class SonOfOdin:
    def __init__(self, name, max_health, level):
        self.name = name
        self.current_health = max_health
        self.max_health = max_health
        self.level = level
        self.inventory = []

    def print_inventory(self):
        for item in self.inventory:
            print(item.name + ", ")
