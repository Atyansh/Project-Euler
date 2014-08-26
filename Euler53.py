def fact(n):
  if n == 2:
    return 2
  return n*fact(n-1)

list = [1, 2]
count = 0

def comb(n, r):
  return list[n-1]/list[n-r-1]/list[r-1]

for i in range(3, 101):
  list.append(fact(i))

for i in range(1, 101):
  for j in range(1, i+1):
    if comb(i, j) > 1000000:
      count += 1

print count
