#!/bin/python

# ************************************************
#  klasa: Notatka
#  opis: Zapis notatki i obsługa
#  pola: __notes - (int) liczba notatek
#        __id - (int) unikalny identyfikator notatki
#        __title - (str) tytuł notatki
#        __content - (str) treść notatki
#  autor: XYZ
# ************************************************
class Notatka:
    __notes: int = 0

    def __init__(self, title: str, content: str):
        self.__notes += 1
        self.__id: int = self.__notes
        self.__title: str = title
        self.__content: str = content

    def displayNote(self) -> None:
        print(f"***Notatka***\n{self.__title}\n{self.__content}\n***")

    def displayParams(self) -> None:
        print(f"***Parametry***\n__notes : {self.__notes}; __id : {self.__id}; __title : {self.__title}; __content : {self.__content};\n***")

# Start
print("Program testujący funkcjonalność notatek")
print("Test notatki 1.")
note1 = Notatka("Notatka pierwsza", "Ala ma kota, a kot ma Alę")
note1.displayNote()
note1.displayParams()
print("Test notatki 2.")
note2 = Notatka("Notatka druga", "Kot ma Alę, a Ala ma kota")
note2.displayNote()
note2.displayParams()