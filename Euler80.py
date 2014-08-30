num = 100

sum = 0

for i in range(2, 100):
  sqrt =  int(i**0.5)

  sq = sqrt*sqrt

  if sq == i:
    continue

  n = i
  answer = str(sqrt)

  n -= sq
  n = int(str(n)+"00")

  for j in range(0, 99):
    sqrt = int(answer) * 2
    k = 9
    while k >= 0:
      sq = int(str(sqrt) + str(k)) * k
      if sq < n:
        sqrt = int(str(sqrt) + str(k))
        break
      k -= 1

    answer += str(k)
    n -= sq
    n = int(str(n)+"00")
  
  for j in range(0, 100):
    sum += int(answer[j])

print sum
