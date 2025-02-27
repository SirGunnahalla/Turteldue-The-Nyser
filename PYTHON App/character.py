from son_of_odin import SonOfOdin

class Character(SonOfOdin):
    def __init__(self, name, constitution, dexterity, intelligence, strength):
        self.constitution = constitution
        self.dexterity = dexterity
        self.intelligence = intelligence
        self.strength = strength
        self.exp_points = 0
        self.max_weight = (strength * 10) + 1
        
        super().__init__(
            name=name,
            max_health=constitution*10,
            level=1
        )

    def show_stats(self):
        print("Level: " + str(self.level)
              + " - HP: " + str(self.current_health) + "/" + str(self.max_health)
              + "\nCon: " + str(self.constitution)
              + " | Dex: " + str(self.dexterity)
              + " | Int: " + str(self.intelligence)
              + " | Str: " + str(self.strength)
            )