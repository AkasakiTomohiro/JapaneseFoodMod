import sys
import os
import json
import argparse

parser = argparse.ArgumentParser(description='種と作物が同じ作物用のJSONファイルと言語情報を出力するスクリプト')
parser.add_argument('files', metavar='S', type=str, nargs='+')

jsonFileBaseDir = os.getcwd() + r"\src\main\resources\assets\japanesefoodmod"

def create_block_states(name):
    fileName = jsonFileBaseDir + "\\blockstates\\" + name + "_plant.json"
    data = {"variants": {}}
    for i in range(8):
        data["variants"]["age=" + str(i)] = {"model": "japanesefoodmod:plants/" + name + "_plant_" + str(i)}
    with open(fileName, 'w') as f:
        json.dump(data, f, indent = 2)
    print("Create File: " , fileName)

def create_models_item(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\item\\" + name + ".json"
    seedsData = {"parent": "item/generated", "textures": {"layer0": "japanesefoodmod:items/" + name}}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_item_seed(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\item\\" + name + "_seeds.json"
    seedsData = {"parent": "item/generated", "textures": {"layer0": "japanesefoodmod:items/" + name + "_seeds"}}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_item_plant(name):
    itemPlantFileName = jsonFileBaseDir + "\\models\\item\\" + name + "_plant.json"
    plantData = {"parent": "block/cube_all", "textures": {"all": "japanesefoodmod:blocks/" + name + "_plant" }}
    with open(itemPlantFileName, 'w') as f:
        json.dump(plantData, f, indent = 2)
    print("Create File: " , itemPlantFileName)

def create_models_block(name):
    for i in range(8):
        itemPlantFileName = jsonFileBaseDir + "\\models\\block\\plants\\" + name + "_plant_" + str(i) + ".json"
        plantData = {"parent": "block/crop", "textures": {"crop": "japanesefoodmod:blocks/plants/" + name + "_plant_" + str(i) }}
        with open(itemPlantFileName, 'w') as f:
            json.dump(plantData, f, indent = 2)
        print("Create File: " , itemPlantFileName)
def pascal_conversion(s):
    return s.capitalize()

def character_conversion(name, suffix = ""):
    return "item." + name + suffix + ".name=" + " ".join(list(map(pascal_conversion, name.split("_")))) + "\n"

def create_lang(name):
    return character_conversion(name) + character_conversion(name + "_seed", "s")

def create(name):
    create_block_states(name)
    create_models_item(name)
    create_models_item_seed(name)
    create_models_item_plant(name)
    create_models_block(name)
    return create_lang(name)

if __name__ == "__main__":
    print("CropsWithSeeds")
    args = parser.parse_args()
    lang = ""
    for item in args.files:
        lang += create(item)
    print("")
    print(lang)