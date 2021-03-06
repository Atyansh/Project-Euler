N = 10001
answer = 0

for i in range(2, N):
  sq = i ** 0.5
  n = int(sq)

  if n*n == i:
    continue

  set = {}
  num = 1
  den = n

  t = (n, (num, den))

  while t not in set:
    set[t] = 1

    num = (i - (den*den))/num
    n = int((sq + den) / num)
    den = n * num - den

    t = (n,(num, den))

  if len(set) % 2 == 0:
    answer += 1

print answer
