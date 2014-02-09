import math

def isPrime(n):
  if n < 2:
    return False

  if n == 2:
    return True

  if n % 2 == 0:
    return False
  
  root = int(math.sqrt(n))

  for i in range(3, root+1, 2):
    if n % i == 0:
      return False

  return True


sum = 0
count = 0
i = 11

while count != 11:
  flag = True
  
  if isPrime(i):
    num = i
    rev = 0

    while num != 0:
      rev += 1
      
      if num / 10 != 0 and isPrime(num / 10) == False:
        flag = False
      
      num /= 10

    num = i

    while num != 0:
      num = num - (int((num / (10**(rev-1)))) * (10**(rev-1)))
      
      if num != 0 and isPrime(num) == False:
        flag = False
      
      rev -= 1
      

    if flag == True:
      sum += i
      count += 1
  
  i += 2

print sum
