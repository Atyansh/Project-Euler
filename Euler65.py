e = 2

c = 66
num = 1
den = 1

temp = c*den+num
num = den
den = temp

c -= 2

temp = 1*den+num
num = den
den = temp

for i in range(0, 32):
  temp = 1*den+num
  num = den
  den = temp
  
  temp = c*den+num
  num = den
  den = temp

  c -= 2

  temp = 1*den+num
  num = den
  den = temp

temp = 2*den+num

sum = 0
for i in str(temp):
  sum += int(i)

print sum
