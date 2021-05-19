#실습 6 copy
import sys
args=[]

for i in sys.argv[1:]:
    args.append(i)
    print(i)


f1=open(args[0],'r')
data=f1.read()
f1.close()

f2=open(args[1],'w')
f2.write(data)
f2.close()

print(data)
