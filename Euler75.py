L = 1500000

d = {}
done = {}

for i in range(3, L+1):
  d[i] = 0

m = 1
mSum = 0

while(mSum <= L):
  m += 1
  n = 1

  a = 2*m*n
  b = m*m - n*n
  c = m*m + n*n

  mSum = a+b+c
  nSum = 0
  
  while(nSum <= L and n < m):
    a = 2*m*n
    b = m*m - n*n
    c = m*m + n*n

    if b < a:
      temp = b
      b = a
      a = temp

    nSum = a+b+c
    
    if (a,b,c) in done:
      n += 1
      continue

    pro = nSum

    ct = 1
    while(pro <= L):
      d[pro] += 1
      done[(ct*a,ct*b,ct*c)] = 1
      pro += nSum
      ct += 1

    n += 1

answer = 0

for i in range(3, L+1):
  if d[i] == 1:
    answer += 1

print answer
