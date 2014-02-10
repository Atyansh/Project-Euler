a = 1000000000
flag = True


while(a < 1415000000):
  sq = a*a;
  sq /= 100
  for i in range(9, -1, -1):
    if sq % 10 != i:
      break
    sq /= 100

  if sq != 0:
    a += 10
    continue

  print a
  print a*a
  break

