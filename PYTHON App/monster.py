import random
from son_of_odin import SonOfOdin

class Monster(SonOfOdin):
    def __init__(self, name, max_health, level, min_damage, max_damage, exp_given):
        self.min_damage = min_damage
        self.max_damage = max_damage
        self.exp_given = exp_given
        super().__init__(name, max_health, level)

    def damage(self):
        return random.randint(self.min_damage, self.max_damage)