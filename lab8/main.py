import os
import sys
import math
import struct

from enum import Enum

class FileMode(Enum):
  Text = "t"
  Binary = "b"


def readFromFile(filename: str, mode: FileMode) -> int:
  if not os.path.exists(filename):
    raise FileNotFoundError(f"no file found with \"{filename}\" name")
  
  with open(filename, f"r{mode.value}") as f:
    if mode == FileMode.Text:
      return int(f.read())
    elif mode == FileMode.Binary:
      return struct.unpack("f", f.read())[0]

def writeToFile(filename: str, mode: FileMode, value: float):
  normalizedValue = str(value) if mode == FileMode.Text else bytearray(struct.pack("f", value))
  
  with open(filename, f"w{mode.value}") as f:
    f.write(normalizedValue)

def calculate(x: int) -> float:
  # cos(x) / tg(2x)
  return math.cos(x) / math.tan(2 * x);

if __name__ == "__main__":
  isReadingFromFile = input("Read x from file (y/n) ? ").lower() == "y"

  x: int

  if isReadingFromFile:
    filename = input("Enter filename: ")
    mode = input("Enter mode\nt - for text\nb - for binary\n: ").lower();

    try:
      x = readFromFile(filename, FileMode.Text if mode == "t" else FileMode.Binary)
    except FileNotFoundError as e:
      print(e)
      sys.exit(1)
  else:
    x = int(input("Enter your x: "))

  print(f"x is: {x}")
  value = calculate(x)

  filename = input("Enter filename: ")
  mode = input("Enter mode\nt - for text\nb - for binary\n: ").lower();

  x = writeToFile(filename, FileMode.Text if mode == "t" else FileMode.Binary, value)
