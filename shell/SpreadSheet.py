import csv

csv_file = open("./shell/JapaneaseFoodMod - 実装アイテム一覧.csv", "r", encoding="utf-8", errors="", newline="" )
f = csv.reader(csv_file, delimiter=",", doublequote=True, lineterminator="\r\n", quotechar='"', skipinitialspace=True)

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

print("\nFood")
print("python shell/Food.py " + " ".join(Food))
print("\nCropsWithSeeds")
print("python shell/CropsWithSeeds.py " + " ".join(CropsWithSeeds))
print("\nFruitTree")
print("python shell/FruitTree.py " + " ".join(FruitTree))
print("\nSameCropAsSeed")
print("python shell/SameCropAsSeed.py " + " ".join(SameCropAsSeed))