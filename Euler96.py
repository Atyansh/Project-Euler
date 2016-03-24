import itertools
import pycosat

from pprint import pprint


def getBoard(i, lines):
  board = []
  for j in range(9):
    board.append([])
    i += 1
    for k in range(9):
      board[j].append(int(lines[i][k]))
  return board

def solve(board):
  sq = len(board)
  n = int(sq**(0.5))

  def mapping(i, j, k):
    return (n ** 4) * i + (n ** 2) * j + k

  def blocks():
    result = []
    for bi in range(n):
      for bj in range(n):
        block = []
        for i in range(n):
          for j in range(n):
            block.append((((bi * n) + i), ((bj * n) + j)))
        result.append(block)
    return result


  def sudoku_clauses():
    clauses = []

    for i in range(sq):
      for j in range(sq):
        ks = []
        nks = []
        for k in range(1, sq + 1):
          ks.append(mapping(i,j,k))
          nks.append(0-mapping(i,j,k))
        clauses.append(ks)
        nxs = itertools.combinations(nks, 2)
        for nx in nxs:
          clauses.append(nx)

    for i in range(sq):
      for k in range(1, sq + 1):
        js = []
        njs = []
        for j in range(sq):
          js.append(mapping(i,j,k))
          njs.append(0-mapping(i,j,k))
        clauses.append(js)
        nxs = itertools.combinations(njs, 2)
        for nx in nxs:
          clauses.append(nx)

    for j in range(sq):
      for k in range(1, sq + 1):
        ils = []
        nis = []
        for i in range(sq):
          ils.append(mapping(i,j,k))
          nis.append(0-mapping(i,j,k))
        clauses.append(ils)
        nxs = itertools.combinations(nis, 2)
        for nx in nxs:
          clauses.append(nx)

    for block in blocks():
      for k in range(1, sq + 1):
        bs = []
        nbs = []
        for b in block:
          bs.append(mapping(b[0], b[1], k))
          nbs.append(0-mapping(b[0], b[1], k))
        clauses.append(bs)
        nxs = itertools.combinations(nbs, 2)
        for nx in nxs:
          clauses.append(nx)
    return clauses
  
  clauses = sudoku_clauses()
  for i in range(sq):
    for j in range(sq):
      k = board[i][j]
      if k:
        clauses.append([mapping(i,j,k)])

  solution_sat = set(pycosat.solve(clauses))

  def read_cell(i, j):
      for k in range(1, sq + 1):
          if mapping(i, j, k) in solution_sat:
              return k
  
  solution = []

  for i in range(sq):
      solution.append([])
      for j in range(sq):
          solution[i].append(read_cell(i, j))
  return solution


if __name__ == '__main__':
  lines = open("Euler96.txt", 'r').readlines()

  answer = 0

  for i in range(0, len(lines), 10):
    board = getBoard(i, lines)
    board = solve(board)
    answer += board[0][0]*100 + board[0][1]*10 + board[0][2]
  print answer
