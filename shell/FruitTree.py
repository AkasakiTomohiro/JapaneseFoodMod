import sys
import os
import json
import argparse

parser = argparse.ArgumentParser(description='種と作物が同じ作物用のJSONファイルと言語情報を出力するスクリプト')
parser.add_argument('files', metavar='S', type=str, nargs='+')

jsonFileBaseDir = os.getcwd() + r"\src\main\resources\assets\japanesefoodmod"

def create_block_states_fruit_block(name):
    fileName = jsonFileBaseDir + "\\blockstates\\" + name + "_fruit_block.json"
    data = {"variants": {"inventory": [{ "model": "japanesefoodmod:fruits/" + name + "_fruit_block_0"}]}}
    for i in range(3):
        data["variants"]["age=" + str(i)] = {"model": "japanesefoodmod:fruits/" + name + "_fruit_block_" + str(i)}
    with open(fileName, 'w') as f:
        json.dump(data, f, indent = 2)
    print("Create File: " , fileName)

def create_block_states_leaves(name):
    fileName = jsonFileBaseDir + "\\blockstates\\" + name + "_leaves.json"
    data = {"forge_marker":1,"defaults":{"model":"japanesefoodmod:trees/" + name + "_leaves","uvlock":True},"variants":{"normal":[{}],"inventory":[{}],"check_decay=true,decayable=true":[{}],"check_decay=true,decayable=false":[{}],"check_decay=false,decayable=true":[{}],"check_decay=false,decayable=false":[{}]}}
    with open(fileName, 'w') as f:
        json.dump(data, f, indent = 2)
    print("Create File: " , fileName)

def create_block_states_log(name):
    fileName = jsonFileBaseDir + "\\blockstates\\" + name + "_log.json"
    data = {"forge_marker":1,"variants":{"axis=y":{"model":"japanesefoodmod:trees/" + name + "_log"},"axis=z":{"model":"japanesefoodmod:trees/" + name + "_log","x":90},"axis=x":{"model":"japanesefoodmod:trees/" + name + "_log","x":90,"y":90},"axis=none":{"model":"japanesefoodmod:trees/" + name + "_log"}}}
    with open(fileName, 'w') as f:
        json.dump(data, f, indent = 2)
    print("Create File: " , fileName)

def create_block_states_sapling(name):
    fileName = jsonFileBaseDir + "\\blockstates\\" + name + "_sapling.json"
    data = {"forge_marker":1,"defaults":{"model":"japanesefoodmod:trees/" + name + "_sapling","uvlock":True},"variants":{"normal":[{}],"inventory":[{}],"stage=0":[{}],"stage=1":[{}]}}
    with open(fileName, 'w') as f:
        json.dump(data, f, indent = 2)
    print("Create File: " , fileName)

def create_block_states(name):
    create_block_states_fruit_block(name)
    create_block_states_leaves(name)
    create_block_states_log(name)
    create_block_states_sapling(name)

def create_models_item(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\item\\" + name + ".json"
    seedsData = {"parent": "item/generated", "textures": {"layer0": "japanesefoodmod:items/" + name}}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_block_leaves(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\block\\trees\\" + name + "_leaves.json"
    seedsData = {"parent":"block/leaves","textures":{"all":"japanesefoodmod:blocks/trees/" + name + "_leaves"}}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_block_log(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\block\\trees\\" + name + "_log.json"
    seedsData = {"parent":"block/cube_column","textures":{"end":"japanesefoodmod:blocks/trees/" + name + "_log_top","side":"japanesefoodmod:blocks/trees/" + name + "_log_side"}}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_block_sapling(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\block\\trees\\" + name + "_sapling.json"
    seedsData = {"parent":"block/cross","textures":{"cross":"japanesefoodmod:blocks/trees/" + name + "_sapling"}}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_block_fruits(name):
    for i in range(3):
        itemPlantFileName = jsonFileBaseDir + "\\models\\block\\fruits\\" + name + "_fruit_block_" + str(i) + ".json"
        plantData = {"parent":"block/cross","textures": {"cross": "japanesefoodmod:blocks/fruits/" + name + "_fruit_block_" + str(i)}}
        with open(itemPlantFileName, 'w') as f:
            json.dump(plantData, f, indent = 2)
        print("Create File: " , itemPlantFileName)

def create_models_block(name):
    create_models_block_leaves(name)
    create_models_block_log(name)
    create_models_block_sapling(name)
    create_models_block_fruits(name)

def create_models_item_fruits(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\item\\" + name + ".json"
    seedsData = {"parent":"item/generated","textures":{"layer0":"japanesefoodmod:items/" + name}}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_item_leaves(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\item\\" + name + "_leaves.json"
    seedsData = {"parent":"japanesefoodmod:block/" + name + "_leaves"}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_item_log(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\item\\" + name + "_log.json"
    seedsData = {"parent":"japanesefoodmod:block/trees/" + name + "_log"}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_item_sapling(name):
    itemSeedsFileName = jsonFileBaseDir + "\\models\\item\\" + name + "_sapling.json"
    seedsData = {"parent":"item/generated","textures":{"layer0":"japanesefoodmod:blocks/" + name + "_sapling"}}
    with open(itemSeedsFileName, 'w') as f:
        json.dump(seedsData, f, indent = 2)
    print("Create File: " , itemSeedsFileName)

def create_models_item(name):
    create_models_item_fruits(name)
    create_models_item_leaves(name)
    create_models_item_log(name)
    create_models_item_sapling(name)

def pascal_conversion(s):
    return s.capitalize()

def character_conversion_item(name, suffix = ""):
    return "item." + name + suffix + ".name=" + " ".join(list(map(pascal_conversion, name.split("_")))) + "\n"

def character_conversion_block(name, suffix = ""):
    return "tile." + name + suffix + ".name=" + " ".join(list(map(pascal_conversion, name.split("_")))) + "\n"

def create_lang_item(name):
    return character_conversion_item(name)

def create_lang_block(name):
    return character_conversion_block(name + "_log") + character_conversion_block(name + "_leaves") + character_conversion_block(name + "_sapling")

def create(name):
    create_block_states(name)
    create_models_item(name)
    create_models_block(name)

if __name__ == "__main__":
    print("FruitTree")
    args = parser.parse_args()
    items = ""
    blocks = ""
    for item in args.files:
        create(item)
        items += create_lang_item(item)
        blocks += create_lang_block(item)
    print("")
    print(items)
    print(blocks)
