n = 3

a = 1
b = 1
c = 2

while(c / (10**999) == 0):
  a = b
  b = c
  c = a + b
  n += 1

print n
