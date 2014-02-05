f = open("Euler13.txt")

c = 0
a = f.read(50)

f.read(1)

while(a != ""):
  b = int(a)
  c += b
  a = f.read(50)
  f.read(1)

print c
