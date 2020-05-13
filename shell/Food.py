import sys
import os
import json
import argparse

parser = argparse.ArgumentParser(description='種と作物が同じ作物用のJSONファイルと言語情報を出力するスクリプト')
parser.add_argument('files', metavar='S', type=str, nargs='+')

jsonFileBaseDir = os.getcwd() + r"\src\main\resources\assets\japanesefoodmod"

def create_json(fileName, data):
    with open(fileName, 'w') as f:
        json.dump(data, f, indent = 2)
    print("Create File: " , fileName)

def create_models_item(name):
    fileName = jsonFileBaseDir + "\\models\\item\\" + name + ".json"
    data = {"parent": "item/generated", "textures": {"layer0": "japanesefoodmod:items/" + name}}
    create_json(fileName, data)

def pascal_conversion(s):
    return s.capitalize()

def character_conversion(name, suffix = ""):
    return "item." + name + suffix + ".name=" + " ".join(list(map(pascal_conversion, name.split("_")))) + "\n"

def create_lang(name):
    return character_conversion(name)

def create(name):
    create_models_item(name)
    return create_lang(name)

if __name__ == "__main__":
    print("CropsWithSeeds")
    args = parser.parse_args()
    lang = ""
    for item in args.files:
        lang += create(item)
    print("")
    print(lang)