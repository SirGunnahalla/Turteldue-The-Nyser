from rat import Rat
from character import Character

def section_divider():
    print("\n-------------------------------------------------------------------------------\n")

def title_text():
    print("Welcome to the best text adventure you've ever seen!\n")
    print("          ----------------------------")
    print("   | T u r t e l d u e :  T h e  N y s e r |")
    print("          ----------------------------")

def instructions_text():
    print("INSTRUCTIONS:")
    print(" 1) ONLY use numbers, except when typing your name.")
    print(" 2) When battling or picking an item, type the number correspondent to the position of the monster/item.")
    print("    Ex: Rat, Spider | Type 1 to battle Rat and 2 to battle Spider.")
    print(" 3) HAVE FUN!")

def story_text():
    print("                                    STORY TIME                                     ")
    print(" | It's the year of 2042 and it is Christmas, a day when everyone is celebrating, |")
    print(" | except you...                                                                  |")
    print(" | The society we are established in is monarchy based, and our Kingdom, the      |")
    print(" | Kjempebra Kingdom, is in war with the malicious kingdom of Ondsinnet.          |")
    print(" | You probably know this story already. However, now it's time I needed you.     |")
    print(" | My name is Lord Skummel and I am the leader of the Oppr�rers, a secret         |")
    print(" | brotherhood, and we need you to DESTROY ONDSINNET!                             |")

title_text()
section_divider()
instructions_text()
section_divider()
story_text()
section_divider()


rat = Rat(1)
print("O dano é: " + str(rat.damage()))

char = Character("Miguel", 3, 1, 2, 4)
char.show_stats()
