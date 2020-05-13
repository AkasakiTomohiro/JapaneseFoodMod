import csv

csv_file = open("./shell/JapaneaseFoodMod - 実装アイテム一覧.csv", "r", encoding="utf-8", errors="", newline="" )
f = csv.reader(csv_file, delimiter=",", doublequote=True, lineterminator="\r\n", quotechar='"', skipinitialspace=True)

def split_list(l, n):
    for idx in range(0, len(l), n):
        yield l[idx:idx + n]

Food = []
CropsWithSeeds = []
FruitTree = []
SameCropAsSeed = []

for row in f:
    if(row[1] == "Food" and row[5] != ""):
        Food.append(row[5])
    if(row[1] == "CropsWithSeeds" and row[5] != ""):
        CropsWithSeeds.append(row[5])
    if(row[1] == "FruitTree" and row[5] != ""):
        FruitTree.append(row[5])
    if(row[1] == "SameCropAsSeed" and row[5] != ""):
        SameCropAsSeed.append(row[5])
        
print("\nFood: " + str(len(Food)))
Food = split_list(Food, 50)
for food in Food:
    print("python shell/Food.py " + " ".join(food))
print("\nCropsWithSeeds: " + str(len(CropsWithSeeds)))
CropsWithSeeds = split_list(CropsWithSeeds, 50)
for cropsWithSeeds in CropsWithSeeds:
    print("python shell/CropsWithSeeds.py " + " ".join(cropsWithSeeds))
print("\nFruitTree: " + str(len(FruitTree)))
FruitTree = split_list(FruitTree, 50)
for fruitTree in FruitTree:
    print("python shell/FruitTree.py " + " ".join(fruitTree))
print("\nSameCropAsSeed: " + str(len(SameCropAsSeed)))
SameCropAsSeed = split_list(SameCropAsSeed, 50)
for sameCropAsSeed in SameCropAsSeed:
    print("python shell/SameCropAsSeed.py " + " ".join(sameCropAsSeed))