f = open("Euler18.txt", 'r')

ll = []

for line in f:
  ll.append(map(int, line.split()))

ll.reverse()

for i in range(len(ll) - 1):
  for j in range(len(ll[i]) - 1):
    ll[i+1][j] += max(ll[i][j], ll[i][j+1])

print ll[-1]
