#실습 6 copy
import sys
args=[]

for i in sys.argv[1:]:
    args.append(i)
    print(i)


f=open(args[0],'r')
lines=f.readlines()
f.close()

words=[]
for i in lines:
    word=i.split(" ")
    for j in word:
        words.append(j)

print("# of lines : {}".format(len(lines)))
print("# of words : {}".format(len(words)))