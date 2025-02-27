from monster import Monster
# name, health, level, strength
class Rat(Monster):
    def __init__(self, level):
        super().__init__(
            name="Rat",
            max_health=11 * level,
            level=level,
            min_damage=level,
            max_damage=level * 2,
            exp_given=level * 100
        )
