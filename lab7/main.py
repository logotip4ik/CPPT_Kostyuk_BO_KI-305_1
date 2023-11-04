size = int(input("Enter output size: "))
filler = input("Enter filler char: ")

matrix = [];
for i in range(int(size / 2)):
  row = [];

  for j in range(size):
    inner = filler if j % 2 == 0 else "0"
    row.append(inner)

  matrix.append(row)

for row in matrix:
  for c in row:
    print(c, end="")
  print("\n\n")
