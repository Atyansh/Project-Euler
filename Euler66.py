D = 1001

answer = 0
large = 0

for i in range(2, D):
  sq = i ** 0.5
  n = int(sq)

  if n*n == i:
    continue

  set = {}
  list = []
  num = 1
  den = n

  t = (n, (num, den))

  while t not in set:
    set[t] = 1
    list.append(t[0])

    num = (i - (den*den))/num
    n = int((sq + den) / num)
    den = n * num - den

    t = (n,(num, den))

  list.pop(0)

  prevX = 1
  prevY = 0

  x = int(sq)
  y = 1
  
  diophantine = x * x - i * y * y - 1

  index = 0

  while diophantine != 0:
    tempX = x
    tempY = y

    x = (x * list[index]) + prevX
    y = (y * list[index]) + prevY

    index += 1
    if index >= len(list):
      index = 0

    prevX = tempX
    prevY = tempY

    diophantine = x * x - i * y * y - 1

  if x > large:
    large = x
    answer = i

print answer
