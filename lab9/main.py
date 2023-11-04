from TVWithTuner import TVWithTuner, Range

if __name__ == "__main__":
  tv = TVWithTuner("name", 25, 25, Range.Short)

  print(tv.getName())
  print(tv.getRange())
