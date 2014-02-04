def fact(n):
  if n <= 2:
    return n
  return n*fact(n-1)

n = fact(100)

s = str(n)
sum = 0
for a in s:
  sum += int(a)

print sum
