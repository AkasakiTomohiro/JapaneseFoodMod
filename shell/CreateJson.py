import sys
import SameCropAsSeed

args = sys.argv

if(len(args) == 2):
    SameCropAsSeed.create(args[1])

