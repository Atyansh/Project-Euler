def is_leap(year):
  return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)

month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
day = 2 # Tuesday
count = 0

for y in range(1901, 2001):
  for m in range(12):
    if day == 0:
      count += 1
    day = (day + month[m]) % 7
    if m == 1 and is_leap(y):
      day = (day + month[m]) % 7

print count
