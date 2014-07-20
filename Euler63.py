counter = 0

for n in range(1, 22):
  for m in range(1, 10):
    value = m**n

    if len(str(value)) == n:
      counter += 1

print counter
